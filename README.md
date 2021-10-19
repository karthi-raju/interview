# Promotion Engine

Promotion Engine Implementation in Java using Product Price as enums. 

## Problem Statement
Need to implement the promotion engine for a checkout process.Our Cart contains a list of single character SKU ids(A,B,C..) over which the promotion engine has to run

### Running the Application
Its a Maven project . Just import the project as a Maven project in respective IDE

Provided com.interview.promoengine.PromotionEngine to launch and test the application directly

```
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
```
Product Price has given as Enum

```
ProductPrice
   	A(50),
	B(30),
	C(20),
	D(15),
	COMBOPRICE_C_AND_D(30);
```

#### 1.Collect number of products from user
```
// get the noOfProducts from user
int noOfProduct = productService.getNumberOfProducts(scanner);
```

#### 2.Collect product types from user
```
// collect the type of products from user
products = productService.getProductTypes(scanner, noOfProduct, products);
```

#### 3.Calculate the total price product for product
```
// calculate the total price for all the products
float totalPrice = productService.getTotalPrice(products);
```

## Exceptions
Custom tailored exceptions will be thrown runtime so that Promotion Engine will run uninterrupted 

```
//When invalid number is entered
NotValidNumberException

//When trying to add a product which is not available
ProductNotFoundException

```

## Running the tests
Test cases for all the service methods are available under respective package name ends with *Test
