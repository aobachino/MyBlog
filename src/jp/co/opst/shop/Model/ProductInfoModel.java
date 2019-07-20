package jp.co.opst.shop.Model;

import java.util.ArrayList;
import java.util.List;

import jp.co.opst.shop.Entity.ProductEntity;

public class ProductInfoModel {

	List<ProductEntity> gdList = new ArrayList<ProductEntity>();

	public List<ProductEntity> getGdList() {
		return gdList;
	}

	public void setGdList(List<ProductEntity> gdList) {
		this.gdList = gdList;
	}

}
