spring的循环依赖：
    为什么singleton+set模式下循环依赖不会出现问题？
                主要原因是在这种模式下Spring对Bean的管理主要分为清晰的两个阶段：
                    第一个阶段：在Spring容器加载时，实例化Bean，只要其中任意一个Bean实例化之后，马上进行”曝光“（不等被赋值就曝光）
                    因为是单例模式，所以提前曝光不怕的，大不了以后再赋值嘛，先曝光个地址，反正地址不会变。
                    第二个阶段：Bean曝光之后再进行属性的赋值。
                核心解决方案：实例化对象和对象的属性赋值分为两个阶段完成
    注意：只有在singleton+set模式下才会提前曝光。当prototype模式下不会提前曝光，因为这个对象会有多个。
    1.set注入
        当二者的scope都是singleton时不会出错，因为singleton下的实例化会在加载spring.xml上下文时进行
        而prototype的实例化不会在加载spring.xml时进行。
        具体过程：在解析spring.xml上下文时，先创建了空白的HusBean对象，紧随其后创建WifeBean对象，然后才能给HusBean赋值，然后再给WifeBean赋值
        此时HusBean与WifeBean两个对象都是存在的。
        对于：
            <bean id="HusBean" class="com.GinElmaC.Bean.HusBand" scope="singleton">
                <property name="name" value="husband111"/>
                <property name="wife" ref="WifeBean"/>
            </bean>
            <bean id="WifeBean" class="com.GinElmaC.Bean.Wife" scope="singleton">
                <property name="name" value="wife111"/>
                <property name="husBand" ref="HusBean"/>
            </bean>
        如果注入的参数是每次注入都重新进行实例化的话会报错。

        当scope="prototype"时，对象的实例化与赋值会同时进行。
        具体过程：在创建HusBean时会同时对其赋值，赋值时要创建Wife，创建Wife时又要创建HusBean，。。。。。死循环了
            <bean id="HusBean" class="com.GinElmaC.Bean.HusBand" scope="singleton">
                <property name="name" value="husband111"/>
                <property name="wife" ref="WifeBean"/>
            </bean>
            <bean id="WifeBean" class="com.GinElmaC.Bean.Wife" scope="singleton">
                <property name="name" value="wife111"/>
                <property name="husBand" ref="HusBean"/>
            </bean>

        当两个Bean其中有一个scope=prototype时不会出错，因为不管哪个是singleton，碰到singleton时总会停下，不会进入死循环
    2.构造注入
        构造注入时需要调用有参构造方法，那么这个Bean对象就不会提前曝光，与prototype一样进入死循环。
        具体过程：与两个都为prototype时相同，对象的实例化与赋值时同时的，会进入死循环。
            <bean id="HusBean" class="com.GinElmaC.Bean.HusBand" scope="singleton">
                <constructor-arg index="0" value="husband111"/>
                <constructor-arg index="1" ref="WifeBean"/>
            </bean>
            <bean id="WifeBean" class="com.GinElmaC.Bean.Wife">
                <constructor-arg index="0" value="wife111"/>
                <constructor-arg index="1" ref="HusBean"/>
            </bean>
    3.spring是怎么用set+singleton解决循环依赖的？
        首先将源码中的一部分拿出：
        DefaultSingletonBeanRegistry类中有三个较为重要的缓存：这里的缓存是用Map实现的
            //一级缓存，存放的是完整的单例Bean对象。key存放配置文件中的beanId，value存放bean对象
            private final Map<String, Object> singletonObjects = new ConcurrentHashMap(256);
            //二级缓存，存放早期的单例Bean对象，这个缓存中的单例Bean对象属性没有赋值，只是一个早期的实例对象。key存放配置文件中的beanId，value存放早期bean对象
            private final Map<String, Object> earlySingletonObjects = new ConcurrentHashMap(16);
            //三级缓存，存放单例Bean的Bean工厂，一个Bean对应一个BeanFactory。key存放配置文件中的beanId，value存放对应的bean工厂
            private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap(16);
        当scope="singleton"时，底层spring解析spring.xml上下文时会实例化Bean对象，并将实例化出的早期Baen对象存放入二级缓存


        源码中对于三级缓存的处理：
            protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory) {
                Assert.notNull(singletonFactory, "Singleton factory must not be null");
                synchronized(this.singletonObjects) {
                    if (!this.singletonObjects.containsKey(beanName)) {
                        this.singletonFactories.put(beanName, singletonFactory);------------将对应bean的工厂加入到三级缓存中，提前曝光
                        this.earlySingletonObjects.remove(beanName);
                        this.registeredSingletons.add(beanName);
                    }

                }
            }


        源码中单例对象bean的获取：
            protected Object getSingleton(String beanName, boolean allowEarlyReference) {
                Object singletonObject = this.singletonObjects.get(beanName);
                if (singletonObject == null && this.isSingletonCurrentlyInCreation(beanName)) {
                    singletonObject = this.earlySingletonObjects.get(beanName);
                    if (singletonObject == null && allowEarlyReference) {
                        synchronized(this.singletonObjects) {
                            singletonObject = this.singletonObjects.get(beanName);------------------从一级缓存中获取
                            if (singletonObject == null) {
                                singletonObject = this.earlySingletonObjects.get(beanName);----------------如果一级缓存找不到，就从二级缓存中找
                                if (singletonObject == null) {
                                    ObjectFactory<?> singletonFactory = (ObjectFactory)this.singletonFactories.get(beanName);如果二级缓存也找不到，则从三级缓存中找对应的工厂
                                    if (singletonFactory != null) {
                                        //通过上一步处理好的三级缓存中找到对应工厂获取对象，并放入二级缓存成为早期Bean。
                                        singletonObject = singletonFactory.getObject();
                                        this.earlySingletonObjects.put(beanName, singletonObject);
                                        //因为scope="singleton"，所以以后不需要再进行实例，删除以符合单例。
                                        this.singletonFactories.remove(beanName);
                                    }
                                }
                            }
                        }
                    }
                }
                //返回得到的单例对象
                return singletonObject;
            }