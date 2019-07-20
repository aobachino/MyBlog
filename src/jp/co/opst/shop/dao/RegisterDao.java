package jp.co.opst.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.opst.shop.Entity.UserInfoEntity;

@Repository
public class RegisterDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class RegRowMapper extends BeanPropertyRowMapper<UserInfoEntity> {
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

	public List<UserInfoEntity> findAll() {
		String sql = "select * from ONLINE_MEMBER ";
		List<UserInfoEntity> userInfoList = this.namedParameterTemplate.query(sql, new RegRowMapper());
		return userInfoList;
	}

	public Integer findMaxUserNum() {
		String sql = "select MAX(MEMBER_NO)  from ONLINE_MEMBER ";
		Integer max = this.jdbcTemplate.queryForObject(sql, Integer.class);
		return max;
	}
	
	public int insert1(UserInfoEntity entity) {
		String sql = "insert into ONLINE_MEMBER (MEMBER_NO,PASSWORD,NAME,AGE,SEX,ZIP,ADDRESS,TEL,REGISTER_DATE,LAST_UPD_DATE) "
				+ "value (:memNum,:pass,:name,:age,:sex,:postCode,:address,:phoneNum,NOW(),NOW()) ";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("memNum", entity.getMemNum());
		paramMap.addValue("pass", entity.getPass());
		paramMap.addValue("name", entity.getName());
		paramMap.addValue("age", Integer.parseInt(entity.getAge()));
		paramMap.addValue("sex", entity.getSex());
		paramMap.addValue("postCode", entity.getPostCode());
		paramMap.addValue("address", entity.getAddress());
		paramMap.addValue("phoneNum", entity.getPhoneNum());
		int count = this.namedParameterTemplate.update(sql, paramMap);
		return count;
	}
	public int insert2(UserInfoEntity entity) {
		String sql = "insert into ONLINE_MEMBER (MEMBER_NO,PASSWORD,NAME,AGE,SEX,ZIP,ADDRESS,TEL,REGISTER_DATE,LAST_UPD_DATE) "
				+ "value (:memNum,:pass,:name,:age,:sex,:postCode,:address,:phoneNum,NOW(),NOW()) ";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("memNum", entity.getMemNum() + 1);
		paramMap.addValue("pass", entity.getPass());
		paramMap.addValue("name", entity.getName());
		paramMap.addValue("age", Integer.parseInt(entity.getAge()));
		paramMap.addValue("sex", entity.getSex());
		paramMap.addValue("postCode", entity.getPostCode());
		paramMap.addValue("address", entity.getAddress());
		paramMap.addValue("phoneNum", entity.getPhoneNum());
		int count = this.namedParameterTemplate.update(sql, paramMap);
		return count;
	}
}
