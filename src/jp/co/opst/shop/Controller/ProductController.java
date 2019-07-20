package jp.co.opst.shop.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.opst.shop.Model.ProductInfoModel;
import jp.co.opst.shop.Model.ProductModel;
import jp.co.opst.shop.Service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/product")
	public String gdHome() {

		return "Product/productSerch";
	}

	@RequestMapping(path = "/serch", method = RequestMethod.POST)
	public ModelAndView serchGd(@ModelAttribute ProductModel promo, HttpSession session) {
		ProductInfoModel gdList = productService.productSerch(promo);
		if (gdList == null) {
			String message = "条件に該当する商品は0件です";
			ModelAndView mv = new ModelAndView("Product/productSerch", "gdZero", message);
			return mv;
		} else {

			ModelAndView mv = new ModelAndView("Product/productSerch", "gdInfo", gdList);
			return mv;
		}

	}

}
