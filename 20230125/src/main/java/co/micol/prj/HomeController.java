package co.micol.prj;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	//메소드는 동일하지만 전달인자가 다름 => 메서드 오버로딩(같은 메서드지만 다른 역할)
	@RequestMapping("/home.do") 
	public String home() {
		return "home";
	}
	
}
