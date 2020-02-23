package jcg.zheng.demo.spring;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jcg.zheng.demo.spring.controller.HomeController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class HomeControllerTest {
	
	@Autowired
	private HomeController welController;

	@Test
	public void welcome_view() {		
		Map<String, Object> model= new HashMap<>();
		Locale locale = new Locale.Builder().setLanguage("en").setRegion("MO").build();
		String viewName = welController.welcome(locale, model);
		assertEquals("home", viewName);
	}
	
}
