package jp.co.opst.shop.Controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.opst.shop.Model.RegisterModel;
import jp.co.opst.shop.Service.RegisterService;

@Controller
public class RegisterController {
	@Autowired
	private RegisterService registerService;

	@RequestMapping("/newRegisterForm")
	public String regHome() {
		return "NewRegister/newRegisterForm";

	}

	@RequestMapping(path = "/conf", method = RequestMethod.POST)
	public ModelAndView confInfo(@Valid @ModelAttribute RegisterModel regmo, BindingResult errors) {
		if (errors.hasErrors()) {
			ModelAndView mav = new ModelAndView("NewRegister/newRegisterForm");
			return mav;
		} else if (!(regmo.getPass().equals(regmo.getConfPass()))) {
			String message = "パスワードが一致していません";
			ModelAndView mav = new ModelAndView("NewRegister/newRegisterForm", "error", message);
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("NewRegister/newRegisterConf", "newRegisterForm", regmo);
			return mav;
		}

	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute RegisterModel regmo) {

		try {
			registerService.insert(regmo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//UserInfoModel uiModel = regService.allfind();
		int userNum= registerService.findUserNum(); 
		return new ModelAndView("NewRegister/registerOk", "regInfo", userNum);
		//	ModelAndView mav = new ModelAndView("NewRegister/registerOk","registerInfo",regService.allfind());	
		//	return mav;

	}
}
