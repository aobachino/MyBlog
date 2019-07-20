package jp.co.opst.shop.Model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.GroupSequence;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jp.co.opst.shop.Entity.UserInfoEntity;
import jp.co.opst.shop.Model.RegisterModel.Group1;

@GroupSequence({ Group1.class, LoginModel.class })
public class LoginModel {
	public interface Group1 {
	}
	@Pattern(regexp = "[0-9]*", message = "数字のみで入力してください", groups = Group1.class)
	private String memNum;
	@Size(max = 32, message = "32文字以内で入力してください")
	@Pattern(regexp = "[a-zA-z0-9]*", message = "アルファベットと数字のみで入力してください", groups = Group1.class)
	private String pass;

	List<UserInfoEntity> userList = new ArrayList<UserInfoEntity>();

	public String getMemNum() {
		return memNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<UserInfoEntity> getUserList() {
		return userList;
	}

	public void setUserList(List<UserInfoEntity> userList) {
		this.userList = userList;
	}

}
