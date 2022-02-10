package it.heima.main;

import com.suning.framework.exception.BaseException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

public class ApplicationContextUtil {
    private static ApplicationContext applicationContext;
    private static final String BASE_EXCEPTION = "SP-UTL-ApplicationContextUtil.getBean";
    private ApplicationContextUtil() {
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationContextUtil.applicationContext = applicationContext;

    }

    /**
     * 功能描述：检查applicationContext是否为空
     *
     * @return true - 当applicationContext不为空;false - 反之
     */
    private static boolean checkApplicationContext() {
        if (applicationContext == null) {
            System.out.println("未获取ApplicationContext");
        }

        return applicationContext != null;
    }

    /**
     * 功能描述：通过applicationContext获取实例 期间可能抛出异常NoSuchBeanDefinitionException、BeansException，此时返回null
     *
     * @param beanName 定义的bean名称
     * @return 当applicationContext没有被实例化之前返回null;当遭遇NoSuchBeanDefinitionException 和BeansException时返回null;否则返回实例
     * @see ApplicationContext#getBean(String)
     */
    public static Object getBean(String beanName) {
        Object result = null;
        if (checkApplicationContext()) {
            try {
                result = applicationContext.getBean(beanName);
            } catch (NoSuchBeanDefinitionException e) {
                throw new BaseException(BASE_EXCEPTION, e);
            } catch (BeansException e) {
                throw new BaseException(BASE_EXCEPTION, e);
            }
        }
        return result;
    }
}
