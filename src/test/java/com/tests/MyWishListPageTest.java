/* Test Steps: 

1. Visit Search Result page with the search term “Paint”: https://www.bunnings.com.au/search/products?q=paint&redirectFrom=Any

2. Randomly visit one product from the Search Result page. This should redirect you to a Product Detail page.

3. In the Product Detail page, click on the “Add to Wish List” button.

4. Verify on the Wishlist page (https://www.bunnings.com.au/wish-lists/) that the product has been successfully added
*/

package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.MyWishListPage;
import com.pages.ProductDetailsPage;

public class MyWishListPageTest extends BaseTest 
{

	@Test
	public void myWishListPageTest() throws InterruptedException{
		//Calling method "clickProduct" from HomePage Class
		page.getInstance(HomePage.class).clickProduct();	
		//Calling method "addProductToWishList" from ProductDetailsPage Class and saving result in another String variable
		String productDetailsPage = page.getInstance(ProductDetailsPage.class).addProductToWishList();
		//Calling method "getProductIdWishListPage" from MyWishListPage Class and saving result in another String variable
		String productWishListPage = page.getInstance(MyWishListPage.class).getProductIdWishListPage();	
		//Comparing the product ids returned from method "addProductToWishList" and "getProductIdWishListPage"
		Assert.assertEquals(productDetailsPage,productWishListPage);
	}
}
