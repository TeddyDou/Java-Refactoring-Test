package test.com.h2rd.refactoring.unit;

import com.h2rd.refactoring.dao.impl.UserDaoImpl;
import com.h2rd.refactoring.domain.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Arrays;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class UserDaoImplUnitTest {

    private static UserDaoImpl userDaoImpl;

    @BeforeClass
    public static void setUp() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-config.xml");
        userDaoImpl = applicationContext.getBean(com.h2rd.refactoring.dao.impl.UserDaoImpl.class);
    }

    @Test
    public void saveUserTest() {

        User user = new User();
        user.setName("Fake Name");
        user.setEmail("fake@email.com");
        user.setRoles(Arrays.asList("admin", "master"));

        userDaoImpl.saveUser(user);
    }

    @Test
    public void deleteUserTest() {

        User user = new User();
        user.setName("Fake Name");
        user.setEmail("fake@email.com");
        user.setRoles(Arrays.asList("admin", "master"));

        userDaoImpl.deleteUser(user);
    }
}