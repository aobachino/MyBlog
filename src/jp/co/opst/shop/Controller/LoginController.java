package jp.co.opst.shop.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.opst.shop.Dto.UserInfoDto;
import jp.co.opst.shop.Model.LoginModel;
import jp.co.opst.shop.Service.LoginService;

@Controller
public class LoginController {

	public static final String USERINFO_KEY = "userInfo";

	@Autowired
	private LoginService loginService;

	@RequestMapping("/loginForm")
	public String logHome(HttpSession session, HttpServletRequest req) {
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		String requestURI = httpRequest.getRequestURI();
		session.setAttribute("requestURI", requestURI);
		return "Login/loginForm";

	}

	@RequestMapping(path = "/loginconf", method = RequestMethod.POST)
	public ModelAndView confLogin(@Valid @ModelAttribute LoginModel logmo, BindingResult errors, HttpSession session) {

		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("Login/loginForm");
			return mv;
		} else if (logmo.getMemNum() == "" || logmo.getPass() == "") {
			String message = "必須入力です";
			ModelAndView mv = new ModelAndView("Login/loginForm", "error", message);
			return mv;
		} else {
			boolean logModel = loginService.userFind(logmo);
			if (logModel) {
				if (session.getAttribute("requestURI").equals("/ONLINEKadai1/userInfo.html")) {
					UserInfoDto uit = loginService.userData(logmo);
					session.setAttribute(USERINFO_KEY, uit);
					ModelAndView pr = new ModelAndView("UpdateInfo/userInfo");
					return pr;
				} else if (session.getAttribute("requestURI").equals("/ONLINEKadai1/oderConf.html")) {
					UserInfoDto uit = loginService.userData(logmo);
					session.setAttribute(USERINFO_KEY, uit);
					ModelAndView pr = new ModelAndView("Cart/oderConf");
					return pr;
				} else {
					UserInfoDto uit = loginService.userData(logmo);
					session.setAttribute(USERINFO_KEY, uit);
					ModelAndView pr = new ModelAndView("MainMenu/menu");
					return pr;
				}

			} else {
				// ログイン失敗
				String message = "ログインできませんでした";
				ModelAndView pr = new ModelAndView("Login/loginForm", "loginnot", message);
				return pr;
			}
		}
	}

}
