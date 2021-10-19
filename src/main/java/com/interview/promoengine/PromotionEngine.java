package com.interview.promoengine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.interview.promoengine.exception.NotValidNumberException;
import com.interview.promoengine.exception.ProductNotFoundException;
import com.interview.promoengine.model.Product;
import com.interview.promoengine.service.ProductService;
import com.interview.promoengine.service.ProductServiceImpl;

/**
 * Class to demonstrate the Promotion applied for the products 
 */
public class PromotionEngine {
	public static void main(String[] args) throws NotValidNumberException, ProductNotFoundException {
		try {
			List<Product> products = new ArrayList<Product>();
			ProductService productService = new ProductServiceImpl();
			Scanner scanner = new Scanner(System.in);
			// get the noOfProducts from user
			int noOfProduct = productService.getNumberOfProducts(scanner);
			// collect the type of products from user
			products = productService.getProductTypes(scanner, noOfProduct, products);
			// calculate the total price for all the products
			float totalPrice = productService.getTotalPrice(products);
			// display total price for user
			System.out.println("Total Price " + totalPrice);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
