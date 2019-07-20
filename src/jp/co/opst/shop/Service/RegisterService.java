package jp.co.opst.shop.Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.opst.shop.Entity.UserInfoEntity;
import jp.co.opst.shop.Model.RegisterModel;
import jp.co.opst.shop.Model.UserInfoModel;
import jp.co.opst.shop.dao.RegisterDao;

@Service
public class RegisterService {

	@Autowired
	private RegisterDao registerDao;

	public UserInfoModel allfind() {
		List<UserInfoEntity> uiList = registerDao.findAll();
		UserInfoModel uim = new UserInfoModel();
		uim.setUiList(uiList);
		return uim;
	}

	public int findUserNum() {
		int max = registerDao.findMaxUserNum();
		return max;

	}

	@Transactional(rollbackForClassName = "Exception")
	public void insert(RegisterModel regmo) throws SQLException {
		List<UserInfoEntity> userList = registerDao.findAll();

		if (userList.size() == 0) {
			UserInfoEntity ul = new UserInfoEntity();
			ul.setMemNum(100001);
			ul.setName(regmo.getName());
			ul.setPass(regmo.getPass());
			ul.setAge(regmo.getAge());
			ul.setSex(regmo.getSex());
			ul.setPostCode(regmo.getPostCode());
			ul.setAddress(regmo.getAddress());
			ul.setPhoneNum(regmo.getPhoneNum());

			registerDao.insert1(ul);
		} else {
			UserInfoEntity ul = new UserInfoEntity();
			int max = registerDao.findMaxUserNum();
			ul.setMemNum(max);
			ul.setName(regmo.getName());
			ul.setPass(regmo.getPass());
			ul.setAge(regmo.getAge());
			ul.setSex(regmo.getSex());
			ul.setPostCode(regmo.getPostCode());
			ul.setAddress(regmo.getAddress());
			ul.setPhoneNum(regmo.getPhoneNum());

			registerDao.insert2(ul);
		}
	}

}
