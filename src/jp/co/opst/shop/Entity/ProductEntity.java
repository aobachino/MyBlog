package jp.co.opst.shop.Entity;

import java.sql.Date;

public class ProductEntity {
	private int goodsNum;
	private int categNum;
	private String goodsName;
	private String maker;
	private int stCnt;
	private Date regTime;
	private int price;
	private Date updateTime;
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public int getCategNum() {
		return categNum;
	}
	public void setCategNum(int categNum) {
		this.categNum = categNum;
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
	public int getStCnt() {
		return stCnt;
	}
	public void setStCnt(int stCnt) {
		this.stCnt = stCnt;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}}
