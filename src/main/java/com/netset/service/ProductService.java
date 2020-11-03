package com.netset.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.netset.Reposotory.ProductDao;
import com.netset.bean.Product;
import com.netset.bean.ProductSearchCriteriaHelper;
import com.netset.exception.UserException;

public class ProductService {

	@Autowired
	private ProductDao productDao;

	public void addProduct(Product product) {
		int i = productDao.addProduct(product);
		if (i < 0) {
			throw new UserException("Exception Occured While Adding the Product");
		}
	}
	public List<Product> getProduct(Product prdct) 
	{
		ProductSearchCriteriaHelper psch=new ProductSearchCriteriaHelper();
		psch.addCriteria(Product.CRITERIA_NAME,prdct);
		psch.addCriteria(Product.CRITERIA_COLOR,prdct);
		psch.addCriteria(Product.CRITERIA_CATAGORY,prdct);
		
		Product productObj=new Product();
		productObj.setProductSearchCriteria(psch);
		
		List<Product> resultList=productDao.getProduct(productObj);
		return resultList;
		
		
	}
}
