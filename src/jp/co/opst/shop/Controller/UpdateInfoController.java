package jp.co.opst.shop.Controller;

import java.sql.SQLException;

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
import jp.co.opst.shop.Model.ChangeInfoFormModel;
import jp.co.opst.shop.Model.UpdateInfoModel;
import jp.co.opst.shop.Service.UpdateInfoService;

@Controller
public class UpdateInfoController {
	@Autowired
	private UpdateInfoService updateInfoService;

	@RequestMapping("/userInfo")
	public String showUserInfo(HttpSession session,HttpServletRequest req) {
		if (session.getAttribute("userInfo") == null) {
			HttpServletRequest httpRequest = (HttpServletRequest) req;
			String requestURI = httpRequest.getRequestURI();
			session.setAttribute("requestURI", requestURI);
			return "Login/loginForm";

		} else {

			return "UpdateInfo/userInfo";

		}

	}

	@RequestMapping(path = "/fireConf", method = RequestMethod.POST)
	public ModelAndView deleConf(@ModelAttribute UpdateInfoModel upModel) {

		ModelAndView mv = new ModelAndView("UpdateInfo/fireConf");
		return mv;

	}

	@RequestMapping(path = "/fireDo", method = RequestMethod.POST)
	public ModelAndView deleDo(@ModelAttribute UpdateInfoModel upModel, HttpSession session) {

		try {
			updateInfoService.userDelete(upModel);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ModelAndView mv = new ModelAndView("UpdateInfo/fireResult");
		session.removeAttribute("userInfo");
		return mv;

	}

	@RequestMapping(path = "/changeForm", method = RequestMethod.POST)
	public ModelAndView changeForm() {
		ModelAndView mv = new ModelAndView("UpdateInfo/changeForm");
		return mv;
	}

	@RequestMapping(path = "/changeConf", method = RequestMethod.POST)
	public ModelAndView changeConf(@ModelAttribute ChangeInfoFormModel ciModel) {

		ModelAndView mv = new ModelAndView("UpdateInfo/changeConf", "newInfo", ciModel);
		return mv;

	}

	@RequestMapping(path = "/changeDo", method = RequestMethod.POST)
	public ModelAndView changeDo(@Valid @ModelAttribute ChangeInfoFormModel chanmo, BindingResult errors,HttpSession session) {
		if (errors.hasErrors()) {
			ModelAndView mav = new ModelAndView("UpdateInfo/changeForm");
			return mav;
		} else if (!(chanmo.getPass().equals(chanmo.getConfPass()))) {
			String message = "パスワードが一致していません";
			ModelAndView mav = new ModelAndView("UpdateInfo/changeForm", "error", message);
			return mav;
		} else {
			try {
				boolean res = updateInfoService.changeUserDate(chanmo);
				if (res) {
					UserInfoDto dit = updateInfoService.userData(chanmo);

					session.setAttribute("userInfo", dit);

				}

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			ModelAndView mv = new ModelAndView("UpdateInfo/changeResult");
			return mv;
		}
	}
}
