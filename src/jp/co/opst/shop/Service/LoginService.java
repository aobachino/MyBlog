package jp.co.opst.shop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.opst.shop.Dto.UserInfoDto;
import jp.co.opst.shop.Entity.UserInfoEntity;
import jp.co.opst.shop.Model.LoginModel;
import jp.co.opst.shop.Model.UserInfoModel;
import jp.co.opst.shop.dao.LoginDao;

@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;

	public boolean userFind(LoginModel logmo) {
		boolean result = true;
		List<UserInfoEntity> infList = loginDao.findLogData(logmo);
		UserInfoModel uim = new UserInfoModel();
		uim.setUiList(infList);
		if (uim.getUiList().size() == 0) {

			result = false;
		}

		return result;
	}

	public UserInfoDto userData(LoginModel logmo) {
		List<UserInfoEntity> infList = loginDao.findLogData(logmo);
		UserInfoDto uit = new UserInfoDto();
		for (UserInfoEntity en : infList) {
			uit.setMemNum(en.getMemNum());
			uit.setPass(en.getPass());
			uit.setName(en.getName());
			uit.setAge(en.getAge());
			uit.setSex(en.getSex());
			uit.setPostCode(en.getPostCode());
			uit.setAddress(en.getAddress());
			uit.setPhoneNum(en.getPhoneNum());
			uit.setRegTime(en.getRegTime());
			uit.setDelete(en.getDelete());
			uit.setUpdateTime(en.getUpdateTime());
		}
		return uit;
	}
}
