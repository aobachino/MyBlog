package jp.co.opst.shop.Model;

public class ProductModel {
	
	private String goodsPart;
	private String goodsName;
	private String maker;
	private int minPrice;
	private int maxPrice;
	private String goodsCateg;
	public String getGoodsPart() {
		return goodsPart;
	}
	public void setGoodsPart(String goodsPart) {
		this.goodsPart = goodsPart;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public int getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getGoodsCateg() {
		return goodsCateg;
	}
	public void setGoodsCateg(String goodsCateg) {
		this.goodsCateg = goodsCateg;
	}

}
