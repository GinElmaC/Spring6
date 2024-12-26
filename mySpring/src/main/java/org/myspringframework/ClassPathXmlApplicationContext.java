package org.myspringframework;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext{
    private static final Logger logger = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);

    private Map<String,Object> singletonObject = new HashMap<>();

    /**
     * 解析MySpring的配置文件，初始化所有的Bean对象
     * @param springPath MySpring配置文件的路径。注意：使用ClassPathXmlAppcationContext，配置文件应该放在类路径下(resources)
     */
    public ClassPathXmlApplicationContext(String springPath) {
        try {
            //解析xml文件，然后实例化Bean，将Bean存放到singletonObjects集合当中。
            //dom4j解析XML的核心对象
            SAXReader saxReader = new SAXReader();
            //获取一个输入流指向配置文件
            InputStream springPath1 = ClassLoader.getSystemClassLoader().getResourceAsStream(springPath);
            //dom4j进入配置文件准备解析，读文件
            Document document = saxReader.read(springPath1);
            //获取所有的Bean标签
            List<Node> nodes = document.selectNodes("//bean");
            //遍历Bean标签
            nodes.forEach(node -> {
                try {
                    //为什么要转型？因为Element接口的方法更加丰富，Node接口的方法太少了
                    Element element = (Element) node;
                    //获取bean节点中的id
                    String id = element.attributeValue("id");
                    //获取bean节点中的classname
                    String classname = element.attributeValue("class");
                    logger.info("beanid:" + id);
                    logger.info("classname:" + classname);
                    //通过反射机制获取对象，并提前曝光
                    Class<?> clazz = Class.forName(classname);
                    //获取无参构造方法
                    Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
                    //调用无参构造方法
                    Object bean = declaredConstructor.newInstance();
                    //将Bean曝光
                    singletonObject.put(id, bean);
                    System.out.println(singletonObject.toString());
                    System.out.println("111");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }catch (Exception e){
            e.printStackTrace();;
        }
            //再一次遍历bean标签，这次主要是给bean对象赋值
//            nodes.forEach(node->{
//                try {
//                    Element element = (Element)node;
//                    //获取id,其实就是bean的id
//                    String beanid = element.attributeValue("id");
//                    //获取类的全限定名
//                    String className = element.attributeValue("class");
//                    //通过反射获取要创建类的class
//                    Class<?> Aclazz = Class.forName(className);
//                    //获取该bean标签下所有的标签
//                    List<Element> propertys = element.elements("property");
//                    //遍历所有的属性标签
//                    propertys.forEach(property->{
//                        try {
//                            //获取要赋给bean的值的名字，规定这个名字和类中的属性名相同
//                            String fieldname = property.attributeValue("name");
//                            //反射获取该属性名的field对象
//                            Field declaredField = Aclazz.getDeclaredField(fieldname);
//                            //拼写set方法名字
//                            String setname = "set"+fieldname.toUpperCase().charAt(0)+fieldname.substring(1);
//                            //根据拼出来的set方法名字通过反射获取对应set方法
//                            Method setmethod = Aclazz.getDeclaredMethod(setname,declaredField.getType());
//                            //获取具体的要传入的值
//                            String value = property.attributeValue("value");
//                            String ref = property.attributeValue("ref");
//                            //定义一个真值
//                            Object propertyVal = null;
//                            if(value != null){
//                                //说明值是简单类型，调用set方法
//                                //转换value类型
//                                //获取属性简单类名（如果直接getType，则是全限定类名，比如Stirng是java.lang.String。所以用getSimpleName）
//                                String propertyTypeSimpleName = declaredField.getType().getSimpleName();
//                                switch (propertyTypeSimpleName) {
//                                    case "byte": case "Byte":
//                                        propertyVal = Byte.valueOf(value);
//                                        break;
//                                    case "short": case "Short":
//                                        propertyVal = Short.valueOf(value);
//                                        break;
//                                    case "int": case "Integer":
//                                        propertyVal = Integer.valueOf(value);
//                                        break;
//                                    case "long": case "Long":
//                                        propertyVal = Long.valueOf(value);
//                                        break;
//                                    case "float": case "Float":
//                                        propertyVal = Float.valueOf(value);
//                                        break;
//                                    case "double": case "Double":
//                                        propertyVal = Double.valueOf(value);
//                                        break;
//                                    case "boolean": case "Boolean":
//                                        propertyVal = Boolean.valueOf(value);
//                                        break;
//                                    case "char": case "Character":
//                                        propertyVal = value.charAt(0);
//                                        break;
//                                    case "String":
//                                        propertyVal = value;
//                                        break;
//                                }
//                                Object object = setmethod.invoke(singletonObject.get(beanid),propertyVal);
//                            }
//                            if(ref != null){
//                                //说明值是非简单类型，调用set方法
//                                setmethod.invoke(singletonObject.get(beanid), singletonObject.get(ref));
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    });
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public Object getBean(String BeanName) {
        return singletonObject.get(BeanName);
    }
}
