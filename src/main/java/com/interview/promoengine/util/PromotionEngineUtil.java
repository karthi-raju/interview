package com.interview.promoengine.util;

import com.interview.promoengine.model.ProductPrice;

/**
 * 
 * Utility class to handle the common operations
 *
 */
public class PromotionEngineUtil {
	/**
	 * Method checks if the given product is available in our system or not
	 * 
	 * @return true/false
	 */
	public static boolean checkForProduct(String productName) {
		for (ProductPrice p : ProductPrice.values()) {
			if (p.name().equals(productName)) {
				return true;
			}
		}
		return false;
	}
}
