package ioc.overview.dependency.lookup;

import ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 依赖查找
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {

        // 实时查找
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");

        User user = (User) beanFactory.getBean("user");
        System.out.println(user);

        // 延时查找
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user1 = objectFactory.getObject();
        System.out.println(user1);
    }

}
