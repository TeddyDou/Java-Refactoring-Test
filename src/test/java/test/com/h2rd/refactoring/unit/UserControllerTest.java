package test.com.h2rd.refactoring.unit;

import com.h2rd.refactoring.controller.UserController;
import com.h2rd.refactoring.dao.impl.UserDaoImpl;
import com.h2rd.refactoring.domain.User;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.core.Response;

public class UserControllerTest {

    private UserController userController;
    private UserDaoImpl userDaoImpl;

    @Before
    public void setUp() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-config.xml");
        userController = applicationContext.getBean(com.h2rd.refactoring.controller.UserController.class);
        userDaoImpl = applicationContext.getBean(com.h2rd.refactoring.dao.impl.UserDaoImpl.class);
    }

    @Test
    public void getUsersTest() {
        User user = new User();
        user.setName("fake user");
        user.setEmail("fake@user.com");
        userDaoImpl.saveUser(user);

        Response response = userController.getUsers();
        Assert.assertEquals(200, response.getStatus());
    }
}
