package jcg.zheng.demo.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import jcg.zheng.demo.spring.controller.UserController;
import jcg.zheng.demo.spring.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class UserControllerTest {

	@Autowired
	private UserController controller;

	@Test
	public void newUser_view() {

		User user = new User();
		user.setUserName("not exist");
		Model model = new BindingAwareModelMap();
		String viewName = controller.user(user, model);
		assertEquals("newuser", viewName);
	}

}
