package test.com.h2rd.refactoring.integration;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

import com.h2rd.refactoring.controller.UserController;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.h2rd.refactoring.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserIntegrationTest {

    private UserController userController;

    @Before
    public void setUp() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-config.xml");
        userController = applicationContext.getBean(com.h2rd.refactoring.controller.UserController.class);
    }

	@Test
    public void createUserTest() {

        User integration = new User();
        integration.setName("integration");
        integration.setEmail("initial@integration.com");
        integration.setRoles(new ArrayList<String>());

        Response response = userController.addUser(integration.getName(), integration.getEmail(), integration.getRoles());
        Assert.assertEquals(200, response.getStatus());
    }

    @Test
    public void updateUserTest() {

		createUserTest();

        User updated = new User();
        updated.setName("integration");
        updated.setEmail("updated@integration.com");
        updated.setRoles(new ArrayList<String>());

        Response response = userController.updateUser(updated.getName(), updated.getEmail(), updated.getRoles());
        Assert.assertEquals(200, response.getStatus());
	}
}
