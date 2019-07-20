package jp.co.opst.shop.Model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jp.co.opst.shop.Entity.UserInfoEntity;
import jp.co.opst.shop.Model.RegisterModel.Group1;
@GroupSequence({ Group1.class, ChangeInfoFormModel.class })
public class ChangeInfoFormModel {
	
	public interface Group1 {
	}
	private String memNum ;
	@NotEmpty(message = "必須入力です ", groups = Group1.class)
	@Size(max = 20, message = "20文字以内で入力してください")
	private String name;

	@NotEmpty(message = "必須入力です", groups = Group1.class)
	@Size(max = 32, message = "32文字以内で入力してください")
	@Pattern(regexp = "[a-zA-z0-9]*", message = "アルファベットと数字のみで入力してください")
	private String pass;

	@NotEmpty(message = "必須入力です", groups = Group1.class)
	@Size(max = 32, message = "32文字以内で入力してください")
	@Pattern(regexp = "[a-zA-z0-9]*", message = "アルファベットと数字のみで入力してください")
	private String confPass;

	@NotEmpty(message = "必須入力です", groups = Group1.class)
	@Size(max = 3, message = "3文字以内で入力してください")
	@Pattern(regexp = "[0-9]*", message = "半角数字で入力してください")
	private String age;

	@NotEmpty(message = "必須選択です", groups = Group1.class)
	private String sex;

	@NotEmpty(message = "必須入力です", groups = Group1.class)
	@Size(max = 8, message = "8文字以内で入力してください")
	@Pattern(regexp = "^[0-9]{7}$", message = "正しく入力してください")
	private String postCode;

	@NotEmpty(message = "必須入力です", groups = Group1.class)
	@Size(max = 50, message = "50文字以内で入力してください")
	private String address;

	@NotEmpty(message = "必須入力です", groups = Group1.class)
	@Size(max = 20, message = "20文字以内で入力してください")
	@Pattern(regexp = "[0-9]{2,4}[0-9]{2,4}[0-9]{3,4}", message = "正しいフォーマットで入力してください")
	private String phoneNum;

	List<UserInfoEntity> userList = new ArrayList<UserInfoEntity>();
	public List<UserInfoEntity> getUserList() {
		return userList;
	}

	public void setUserList(List<UserInfoEntity> userList) {
		this.userList = userList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getConfPass() {
		return confPass;
	}

	public void setConfPass(String confPass) {
		this.confPass = confPass;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getMemNum() {
		return memNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	
}
