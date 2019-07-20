package jp.co.opst.shop.Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.opst.shop.Dto.UserInfoDto;
import jp.co.opst.shop.Entity.UserInfoEntity;
import jp.co.opst.shop.Model.ChangeInfoFormModel;
import jp.co.opst.shop.Model.UpdateInfoModel;
import jp.co.opst.shop.dao.UpdateInfoDao;

@Service
public class UpdateInfoService {

	@Autowired
	private UpdateInfoDao updateInfoDao;

	@Transactional(rollbackForClassName = "Exception")
	public boolean userDelete(UpdateInfoModel upModel) throws SQLException {
		boolean result = true;
		UserInfoEntity ui = new UserInfoEntity();
		ui.setMemNum(upModel.getMemNum());

		int cnt = updateInfoDao.deleteData(ui);
		if (cnt == 0) {
			result = false;
		}

		return result;
	}

	public UserInfoDto userData(ChangeInfoFormModel chanmo) {
		List<UserInfoEntity> infList = updateInfoDao.findUserData(chanmo);
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

	@Transactional(rollbackForClassName = "Exception")
	public boolean changeUserDate(ChangeInfoFormModel chanmo) throws SQLException {
		boolean result = true;
		UserInfoEntity ui = new UserInfoEntity();
		ui.setMemNum(Integer.parseInt(chanmo.getMemNum()));
		ui.setPass(chanmo.getPass());
		ui.setName(chanmo.getName());
		ui.setAge(chanmo.getAge());
		ui.setSex(chanmo.getSex());
		ui.setPostCode(chanmo.getPostCode());
		ui.setAddress(chanmo.getAddress());
		ui.setPhoneNum(chanmo.getPhoneNum());
		int cnt = updateInfoDao.changeData(ui);
		if (cnt == 0) {
			result = false;
		}

		return result;

	}
}
