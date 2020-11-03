package com.netset.Reposotory;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.netset.bean.Product;

public class ProductRowMapper implements RowMapper<Product> {
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		int i = 0;
		Product prdct = new Product();
		prdct.setName(rs.getString(++i));
		prdct.setColor(rs.getString(++i));
		prdct.setPrice(rs.getInt(++i));
		prdct.setCatagory(rs.getString(++i));
	//	prdct.setImage(rs.getBytes(++i));
		return prdct;
	}
}
