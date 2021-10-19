package com.interview.promoengine.service;

import java.util.List;
import java.util.Scanner;

import com.interview.promoengine.exception.NotValidNumberException;
import com.interview.promoengine.exception.ProductNotFoundException;
import com.interview.promoengine.model.Product;
import com.interview.promoengine.model.ProductPrice;
import com.interview.promoengine.util.ApplicationConstants;
import com.interview.promoengine.util.PromotionEngineUtil;

/**
 * Implementation for the product service
 * 
 *
 */

public class ProductServiceImpl implements ProductService {
	
	/**
	 * To get the total price for the products ordered
	 * 
	 * @return totalPrice
	 */
	@Override
	public float getTotalPrice(List<Product> products) {
		int counterofA = 0;
		int counterofB = 0;
		int counterofC = 0;
		int counterofD = 0;
		for (Product product : products) {

			if (product.getSkuId().equalsIgnoreCase(ApplicationConstants.A)) {
				counterofA = counterofA + 1;
			}
			if (product.getSkuId().equalsIgnoreCase(ApplicationConstants.B)) {
				counterofB = counterofB + 1;
			}
			if (product.getSkuId().equalsIgnoreCase(ApplicationConstants.C)) {
				counterofC = counterofC + 1;
			}
			if (product.getSkuId().equalsIgnoreCase(ApplicationConstants.D)) {
				counterofD = counterofD + 1;
			}
		}
		// calculate price for the products by applying promo
		float totalPriceofA = (counterofA / 3) * 130 + (counterofA % 3 * ProductPrice.A.getPrice());
		float totalPriceofB = (counterofB / 2) * 45 + (counterofB % 2 * ProductPrice.B.getPrice());
		if (counterofC >= 1 && counterofD >= 1) {
			if (counterofC >= counterofD) {
				int comboOfCandD = counterofD;
				int leftoverC = counterofC - counterofD;
				float comboPrice = comboOfCandD * ProductPrice.COMBOPRICE_C_AND_D.getPrice();
				float totalPriceofC = (leftoverC * ProductPrice.C.getPrice());
				return totalPriceofA + totalPriceofB + totalPriceofC + comboPrice;
			} else {
				int comboOfCandD = counterofC;
				int leftoverD = counterofD - counterofC;
				float comboPrice = comboOfCandD * ProductPrice.COMBOPRICE_C_AND_D.getPrice();
				float totalPriceofD = (leftoverD * ProductPrice.D.getPrice());
				return totalPriceofA + totalPriceofB + comboPrice + totalPriceofD;
			}
		}
		float totalPriceofC = (counterofC * ProductPrice.C.getPrice());
		float totalPriceofD = (counterofD * ProductPrice.D.getPrice());
		return totalPriceofA + totalPriceofB + totalPriceofC + totalPriceofD;
	}

	/**
	 * Collect number of product from the user
	 * 
	 *@return integer
	 */
	@Override
	public int getNumberOfProducts(Scanner scanner) throws NotValidNumberException {
		System.out.println("Enter the number of products:");
		int noOfProdct = 0;
		try {
			noOfProdct = scanner.nextInt();
		} catch (Exception e) {
			scanner.close();
			throw new NotValidNumberException();
		}
		return noOfProdct;
	}

	/**
	 * Collect the type of products from user
	 * 
	 */
	@Override
	public List<Product> getProductTypes(Scanner scanner, int noOfProduct, List<Product> products)
			throws ProductNotFoundException {
		for (int i = 0; i < noOfProduct; i++) {
			System.out.println("enter the type of product:A,B,C or D:");
			String productType = scanner.next();
			// check if product is available 
			if (!PromotionEngineUtil.checkForProduct(productType.toUpperCase())) {
				scanner.close();
				throw new ProductNotFoundException(productType);
			}
			Product p = new Product(productType);
			products.add(p);
		}
		scanner.close();
		return products;
	}
}
