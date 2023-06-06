import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Model.Cart;
import Model.Product;

class CartTest {
	// private Cart cart;

	    /*@Before
	    public void setUp() {
	        cart = new Cart();
	    }*/

	@Test
    public void testAddProduct() {
		Cart cart = new Cart();
		
        Product product1 = new Product("Dove", 39.99, 5);
        Product product2 = new Product("Axe Deo", 99.99, 3);
        cart.clearCart();
        cart.addProduct(product1);
       cart.addProduct(product2);

        assertEquals(8, cart.getProductCount());
    }
	
	@Test
    public void testCalculateTotalPrice() {
        Cart cart = new Cart();
        
        Product product1 = new Product("Dove", 39.99, 10);
        
        Product product2 = new Product("Axe Deo", 99.99, 5);
        
        cart.addProduct(product1);
        cart.addProduct(product2);
        
        double totalPrice = cart.calculateTotalPrice();
        
        assertEquals(543.91, totalPrice, 0.01);
    }
	
	
	
    @Test
    public void testCalculateTotalPriceWithTax() {
        Cart cart = new Cart();
        
        Product product1 = new Product("Dove", 39.99, 2);
        Product product2 = new Product("Axe Deo", 99.99, 2);
        
        cart.addProduct(product1);
        cart.addProduct(product2);
        
        double totalPrice = cart.calculateTotalPriceWithTax(0.125);
        
        assertEquals(314.96, totalPrice, 0.01);
    }
    
    /*@Test
    public void testAddProductsAndGetTotalPrice() {
        Cart cart = new Cart();
        Product product1 = new Product("Dove", 39.99, 5);
        Product product2 = new Product("Axe Deo", 99.99, 2);
        
        cart.clearCart(); // Clear the cart before adding new products
        
        cart.addProduct(product1);
        cart.addProduct(product2);

        double expectedTotalPrice = product1.getPrice() * product1.getQuantity() + 
                                   product2.getPrice() * product2.getQuantity();
        int expectedProductCount = 7; // Total quantity of products

       assertEquals(expectedTotalPrice, cart.calculateTotalPrice(), 0.01);
        assertEquals(expectedProductCount, cart.getProductCount());
    }*/

    @Test
    public void testgetDiscountBuyXGetYFree() {
    	Cart cart = new Cart();
    	Product product1 = new Product("Dove", 39.99, 7);
    	cart.clearCart(); // Clear the cart before adding new products
        
        cart.addProduct(product1);
       
        assertEquals(7, cart.getProductCount());
        assertEquals( 199.95, cart.calculateTotalPrice(), 0.01);
        assertEquals( 79.98, cart.getDiscountBuyXGetYFree(product1), 0.01);
        
    	
    }
    
    @Test
    public void testgetDiscountBuyOneGetNextHalf() {
    	Cart cart = new Cart();
    	Product product1 = new Product("Dove", 39.99, 5);
    	cart.clearCart(); // Clear the cart before adding new products
        
        cart.addProduct(product1);
        assertEquals( 40, cart.getDiscountBuyOneGetNextHalf(product1), 0.01);
    	
    }
    
    
}


