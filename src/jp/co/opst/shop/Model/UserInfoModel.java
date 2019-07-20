package jp.co.opst.shop.Model;

import java.util.ArrayList;
import java.util.List;

import jp.co.opst.shop.Entity.UserInfoEntity;

public class UserInfoModel {

	List<UserInfoEntity> uiList = new ArrayList<UserInfoEntity>();

	public List<UserInfoEntity> getUiList() {
		return uiList;
	}

	public void setUiList(List<UserInfoEntity> uiList) {
		this.uiList = uiList;
	}
}
