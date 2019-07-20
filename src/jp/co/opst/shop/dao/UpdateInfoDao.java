package jp.co.opst.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.opst.shop.Entity.UserInfoEntity;
import jp.co.opst.shop.Model.ChangeInfoFormModel;

@Repository
public class UpdateInfoDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterTemplate;

	private class UpdateInfoRowMapper extends BeanPropertyRowMapper<UserInfoEntity> {
		@Override
		public UserInfoEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserInfoEntity en = new UserInfoEntity();
			en.setMemNum(rs.getInt("MEMBER_NO"));
			en.setName(rs.getString("NAME"));
			en.setAge(rs.getString("AGE"));
			en.setSex(rs.getString("SEX"));
			en.setPostCode(rs.getString("ZIP"));
			en.setAddress(rs.getString("ADDRESS"));
			en.setPhoneNum(rs.getString("TEL"));
			en.setRegTime(rs.getDate("REGISTER_DATE"));
			en.setDelete(rs.getString("DELETE_FLG"));
			en.setUpdateTime(rs.getDate("LAST_UPD_DATE"));
			return en;
		}
	}
	public List<UserInfoEntity> findUserData(ChangeInfoFormModel chanmo) {
		String sql = "select * from ONLINE_MEMBER where MEMBER_NO = :memNum ";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("memNum", chanmo.getMemNum());
		paramMap.addValue("pass", chanmo.getPass());
		List<UserInfoEntity> infList = namedParameterTemplate.query(sql, paramMap, new UpdateInfoRowMapper());
		return infList;
	}
	public int deleteData(UserInfoEntity entity) {
		String sql = "delete from ONLINE_MEMBER where MEMBER_NO = :memNum ";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("memNum", entity.getMemNum());
		int cnt = this.namedParameterTemplate.update(sql, paramMap);
		return cnt;
	}

	public int changeData(UserInfoEntity entity) {
		String sql = "update ONLINE_MEMBER set PASSWORD = :pass,NAME = :name,AGE =:age,SEX = :sex,ZIP = :postCode,ADDRESS = :address,TEL = :phoneNum,REGISTER_DATE = NOW(),LAST_UPD_DATE = NOW() where MEMBER_NO = :memNum ";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("memNum", entity.getMemNum());
		paramMap.addValue("pass", entity.getPass());
		paramMap.addValue("name", entity.getName());
		paramMap.addValue("age", entity.getAge());
		paramMap.addValue("sex", entity.getSex());
		paramMap.addValue("postCode", entity.getPostCode());
		paramMap.addValue("address", entity.getAddress());
		paramMap.addValue("phoneNum", entity.getPhoneNum());

		int cnt = this.namedParameterTemplate.update(sql, paramMap);
		return cnt;
	}
	
}
