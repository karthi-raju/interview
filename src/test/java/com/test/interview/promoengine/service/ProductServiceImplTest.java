package com.test.interview.promoengine.service;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.interview.promoengine.exception.NotValidNumberException;
import com.interview.promoengine.exception.ProductNotFoundException;
import com.interview.promoengine.model.Product;
import com.interview.promoengine.service.ProductService;
import com.interview.promoengine.service.ProductServiceImpl;

public class ProductServiceImplTest {

	ProductService productService;

	@Before
	public void instantiate() {
		productService = new ProductServiceImpl();
	}

	@Test
	public void getNumberOfProductsTest() throws NotValidNumberException {
		String data = "3";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		Scanner scanner = new Scanner(System.in);
		assertEquals(3, productService.getNumberOfProducts(scanner));
		scanner.close();
	}

	@Test
	public void getNumberOfProductsTestThrowsException() {
		String data = "A";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		Scanner scanner = new Scanner(System.in);
		try {
			productService.getNumberOfProducts(scanner);
		} catch (NotValidNumberException e) {
			assertEquals("Enter valid number ", e.getMessage());
		} finally {
			scanner.close();
		}
	}
	
	@Test
	public void getTotalPriceTest() {
		List<Product> products = new ArrayList<Product>();
		assertEquals(0.0, productService.getTotalPrice(products), 0.0);
	}
	
	@Test
	public void getTotalPriceTestWrongValue() {
		List<Product> products = createProductScenarioC();
		assertEquals(285.00, productService.getTotalPrice(products), 5.0);
	}

	@Test
	public void getTotalPriceTest1() {
		List<Product> products = createProductScenarioA();
		assertEquals(100.00, productService.getTotalPrice(products), 0.0);
	}

	@Test
	public void getTotalPriceTest2() {
		List<Product> products = createProductScenarioB();
		assertEquals(370.00, productService.getTotalPrice(products), 0.0);
	}

	@Test
	public void getTotalPriceTest3() {
		List<Product> products = createProductScenarioC();
		assertEquals(280.00, productService.getTotalPrice(products), 0.0);
	}

	private List<Product> createProductScenarioA() {
		List<Product> products = new ArrayList<Product>();
		Product product1 = new Product("A");
		Product product2 = new Product("B");
		Product product3 = new Product("C");
		products.add(product1);
		products.add(product2);
		products.add(product3);
		return products;
	}

	private List<Product> createProductScenarioB() {
		List<Product> products = new ArrayList<Product>();
		Product product1 = new Product("A");
		Product product2 = new Product("A");
		Product product3 = new Product("A");
		Product product4 = new Product("A");
		Product product5 = new Product("A");
		Product product6 = new Product("B");
		Product product7 = new Product("B");
		Product product8 = new Product("B");
		Product product9 = new Product("B");
		Product product10 = new Product("B");
		Product product11 = new Product("C");
		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);
		products.add(product5);
		products.add(product6);
		products.add(product7);
		products.add(product8);
		products.add(product9);
		products.add(product10);
		products.add(product11);
		return products;
	}

	private List<Product> createProductScenarioC() {
		List<Product> products = new ArrayList<Product>();
		Product product1 = new Product("A");
		Product product2 = new Product("A");
		Product product3 = new Product("A");
		Product product4 = new Product("B");
		Product product5 = new Product("B");
		Product product6 = new Product("B");
		Product product7 = new Product("B");
		Product product8 = new Product("B");
		Product product9 = new Product("C");
		Product product10 = new Product("D");
		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);
		products.add(product5);
		products.add(product6);
		products.add(product7);
		products.add(product8);
		products.add(product9);
		products.add(product10);
		return products;
	}

	// @Test
	public void getProductTypesTest() throws ProductNotFoundException {
		String data = "A";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		Scanner scanner = new Scanner(System.in);
		List<Product> products = new ArrayList<Product>();
		assertEquals(2, productService.getProductTypes(scanner, 2, products).size());
	}
}
