package jp.co.opst.shop.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.opst.shop.Model.LoginModel;

@Controller
public class LogoutController {
	
    @RequestMapping("/logout")
    public ModelAndView userLogin(@ModelAttribute LoginModel model, HttpSession session) {
        session.removeAttribute("userInfo");
        String message = "ログアウトしました";
        ModelAndView mv = new ModelAndView("Login/loginForm","logoutStatus",message);
        return mv;
    }

}
