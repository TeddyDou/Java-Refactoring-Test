package test.com.h2rd.refactoring.unit;

import com.h2rd.refactoring.domain.User;
import com.h2rd.refactoring.service.UserService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Arrays;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class UserServiceUnitTest {

    private static UserService userService;

    @BeforeClass
    public static void setUp() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-config.xml");
        userService = applicationContext.getBean(com.h2rd.refactoring.service.UserService.class);
    }

    @Test
    public void addUserTest() {
        User user = new User();
        user.setName("Fake Name");
        user.setEmail("fake@email.com");
        user.setRoles(Arrays.asList("admin", "master"));

        userService.addUser(user);
    }

    @Test
    public void findUserTest() {
        userService.findUser("Fake Name");
    }
}
