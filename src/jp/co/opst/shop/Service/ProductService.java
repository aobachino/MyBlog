package jp.co.opst.shop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.opst.shop.Entity.ProductEntity;
import jp.co.opst.shop.Model.ProductInfoModel;
import jp.co.opst.shop.Model.ProductModel;
import jp.co.opst.shop.dao.ProductDao;
@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public ProductInfoModel productSerch(ProductModel promo) {
		List<ProductEntity> gdList = productDao.findProduct(promo);
		ProductInfoModel uim = new ProductInfoModel();
		uim.setGdList(gdList);
		return uim;
	}
	
	
}
