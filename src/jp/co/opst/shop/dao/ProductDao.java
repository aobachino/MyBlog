package jp.co.opst.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.opst.shop.Entity.ProductEntity;
import jp.co.opst.shop.Model.ProductModel;

@Repository
public class ProductDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterTemplate;

	private class ProductRowMapper extends BeanPropertyRowMapper<ProductEntity> {
		@Override
		public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProductEntity en = new ProductEntity();
			en.setGoodsNum(rs.getInt("PRODUCT_CODE"));
			en.setCategNum(rs.getInt("CATEGORY_ID"));
			en.setGoodsName(rs.getString("PRODUCT_NAME"));
			en.setMaker(rs.getString("MAKER"));
			en.setStCnt(rs.getInt("STOCK_COUNT"));
			en.setRegTime(rs.getDate("REGISTER_DATE"));
			en.setPrice(rs.getInt("UNIT_PRICE"));
			en.setUpdateTime(rs.getDate("LAST_UPD_DATE"));
			return en;
		}

	}

	public List<ProductEntity> findProduct(ProductModel promo) {
		String sql = "select * from ONLINE_PRODUCT where (PRODUCT_NAME = :goodsName OR :goodsName IS NULL)" +
				"AND   (MAKER = :maker OR :maker IS NULL)" + "AND (UNIT_PRICE >= :minPrice OR :minPrice IS NULL) "
				+ "AND (UNIT_PRICE <= :maxPrice OR :maxPrice IS NULL)";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("categNum", promo.getGoodsCateg());
		paramMap.addValue("goodsName", promo.getGoodsName());
		paramMap.addValue("maker", promo.getMaker());
		paramMap.addValue("maxPrice", promo.getMaxPrice());
		paramMap.addValue("minPrice", promo.getMinPrice());
		List<ProductEntity> infList = namedParameterTemplate.query(sql, paramMap, new ProductRowMapper());

		return infList;
	}

}
