package org.myspringframework;

/**
 * MySpring框架应用上下文接口
 */
public interface ApplicationContext {
    /**
     * 根据Bean的名称获取对应的Bean对象
     * @param BeanName MySpring配置文件中bean标签的id
     * @return 返回的单例Bean对象
     */
    Object getBean(String BeanName);
}
