package com.netset.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.netset.bean.Product;
import com.netset.exception.UserException;
import com.netset.service.ProductService;
import com.netset.util.Constants;

@RestController
@RequestMapping("/spring/assignment")
public class ProductController {
	private ProductService productService = new ProductService();

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> addProduct(@RequestParam(required = true, value = "image") MultipartFile Image,
			@RequestParam String name, @RequestParam String category, @RequestParam String color,
			@RequestParam int price) throws IOException {
		Product productObj = new Product(name, color, price, category, Image.getBytes());
		productService.addProduct(productObj);
		return new ResponseEntity<>("Product Added Succesfully", HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/getProduct", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> getProduct(@RequestParam String name, @RequestParam String color,
			@RequestParam String category) {
		Product prdct = new Product();
		prdct.setName(name);
		prdct.setColor(color);
		prdct.setCatagory(category);
		List<Product> resultList = new ArrayList<>();
		resultList = productService.getProduct(prdct);
		if (resultList == null) {
			return new ResponseEntity<String>("No Product Found ", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(resultList, HttpStatus.ACCEPTED);
	}

	@ExceptionHandler(UserException.class)
	public ResponseEntity<Object> handleException(UserException e) throws IOException {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put(Constants.KEY_STATUS, Constants.STATUS_FAILURE);
		resultMap.put(Constants.KEY_ERROR, e.getMessage());
		return new ResponseEntity<>(resultMap, HttpStatus.BAD_REQUEST);
	}
}
