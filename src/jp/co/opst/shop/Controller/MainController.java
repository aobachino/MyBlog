package jp.co.opst.shop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/menu")
	public String mainHome() {
		return "MainMenu/menu";
	}
	
}
