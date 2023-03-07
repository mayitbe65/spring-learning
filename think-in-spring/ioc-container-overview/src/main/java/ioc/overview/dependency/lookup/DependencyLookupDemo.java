package ioc.overview.dependency.lookup;

import ioc.overview.dependency.annotation.Super;
import ioc.overview.dependency.domain.SuperUser;
import ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;


/**
 * 依赖查找
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {

//        lookUpByName();

//        lookUpByType();

        loopUpCollectionByType();

        loopUpByAnnotation();
    }

    // 根据名称查找
    private static void lookUpByName() {
        // 实时查找
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");

//        User user = (User) beanFactory.getBean("user");
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);

        // 延时查找
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user1 = objectFactory.getObject();
        System.out.println(user1);
    }

    // 根据类型查找
    private static void lookUpByType() {

        // 实时查找
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        User user = beanFactory.getBean(User.class);
        System.out.println(user);

    }

    // 根据类型查找集合
    private static void loopUpCollectionByType() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(userMap);
        }
    }

    // 根据注解查找
    private static void loopUpByAnnotation() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println(userMap);
        }
    }
}
