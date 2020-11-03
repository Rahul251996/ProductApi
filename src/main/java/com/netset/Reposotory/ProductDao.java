package com.netset.Reposotory;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.netset.bean.Product;
import com.netset.bean.ProductSearchCriteriaHelper;

public class ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addProduct(Product product) {
		String querry = "Insert into Product(productID,Name,Color,Price,Catagory,Image) values(?,?,?,?,?,?)";

		Object[] params = { product.getName(), product.getColor(), product.getPrice(), product.getCatagory(),
				product.getImage() };

		int[] bytes = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.BLOB };

		return jdbcTemplate.update(querry, params, bytes);
	}

	public List<Product> getProduct(Product productObj) {
		List<Product> resultList = new ArrayList<>();
		ProductSearchCriteriaHelper psch = productObj.getProductSearchCriteria();

		StringBuilder sb = new StringBuilder();

		sb.append("SELECT * FROM PRODUCTS WHERE ");

		if (psch != null) {
			if (psch.getCriteria(Product.CRITERIA_NAME) != null) {
				Product product = (Product) psch.getCriteria(Product.CRITERIA_NAME);
				if (product != null) {
					sb.append("Name LIKE '%" + product.getName() + "%')");
				}
			}
			if (psch.getCriteria(Product.CRITERIA_COLOR) != null) {
				Product product = (Product) psch.getCriteria(Product.CRITERIA_COLOR);
				if (product != null) {
					sb.append("Color LIKE '%" + product.getColor() + "%')");
				}
			}
			if (psch.getCriteria(Product.CRITERIA_CATAGORY) != null) {
				Product product = (Product) psch.getCriteria(Product.CRITERIA_CATAGORY);
				if (product != null) {
					sb.append("Category LIKE '%" + product.getCatagory() + "%')");
				}
			}
		}
		resultList.addAll(jdbcTemplate.query(sb.toString(), new ProductRowMapper()));
		return resultList;
	}
}
