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
import jp.co.opst.shop.Model.LoginModel;

@Repository
public class LoginDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterTemplate;

	private class UserInfoRowMapper extends BeanPropertyRowMapper<UserInfoEntity> {
		@Override
		public UserInfoEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserInfoEntity en = new UserInfoEntity();
			en.setMemNum(rs.getInt("MEMBER_NO"));
			en.setPass(rs.getString("PASSWORD"));
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
	public List<UserInfoEntity> findLogData(LoginModel logmo) {
		String sql = "select * from ONLINE_MEMBER where MEMBER_NO = :memNum AND PASSWORD = :pass ";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("memNum", Integer.parseInt(logmo.getMemNum()));
		paramMap.addValue("pass", logmo.getPass());
		List<UserInfoEntity> infList = namedParameterTemplate.query(sql, paramMap, new UserInfoRowMapper());
		return infList;
	}

}
