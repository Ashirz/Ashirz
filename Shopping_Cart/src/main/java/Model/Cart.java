package Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;
    private int freeItemsEligible; // keep track of the quantities of items eligible for the offer
    
    public int getFreeItemsEligible() {
    	return freeItemsEligible;
    }

    public void setFreeItemsEligible(int freeItemsEligible) {
    	this.freeItemsEligible = freeItemsEligible;
    }

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        
        // Check if the added product has a "Buy X, Get Y free" offer
       /* if (product.getBuyXGetYFreeOffer() > 0) {
            // Calculate the number of free items eligible based on the quantities of products added
            int eligibleItems = product.getBuyXGetYFreeOffer();
            int totalQuantity = getProductCount();
            freeItemsEligible += (totalQuantity / eligibleItems) * eligibleItems;
            System.out.println(freeItemsEligible);
        }*/
    }

    public int getProductCount() {
        int productQuantity = 0;
        for (Product product : products) {
            productQuantity += product.getQuantity();
        }
        return productQuantity;
    }

    public void clearCart() {
        products.clear();
    }
       
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
        	totalPrice += (product.getPrice() * product.getQuantity()) - getDiscountBuyXGetYFree(product);
         
            
        if (totalPrice > 500) {
            double discount = totalPrice * 0.2; // 20% discount
            totalPrice -= discount;
        }}
         return totalPrice;
    }

    
    
    public double calculateTotalPriceWithTax(double taxRate) {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice() * product.getQuantity();
        }
        
        double salesTax = totalPrice * taxRate;
        double totalPriceWithTax = totalPrice + salesTax;
        totalPriceWithTax = Math.round(totalPriceWithTax * 100.0) / 100.0;
        
        return totalPriceWithTax;
    }

    /*public double getTotalDiscount() {
        double totalDiscount = 0;
        
        for (Product product : products) {
            if (product.getBuyXGetYFreeOffer() > 0) {
                // Calculate the discount based on the quantities of eligible free items
                int eligibleItems = product.getBuyXGetYFreeOffer();
                int freeItems = Math.min(product.getQuantity(), freeItemsEligible);
                double productDiscount = product.getPrice() * (freeItems / eligibleItems);
                totalDiscount += productDiscount;
                freeItemsEligible -= freeItems;
            }
        }
        return totalDiscount;
    } */
    //fix this using buyxgetyfree
    public double getDiscountBuyXGetYFree(Product product) {
    	int quantity = product.getQuantity();
    	int paidQuantity = quantity - (quantity /3);
        int freeQuantity = quantity - paidQuantity;
        double discount = freeQuantity * product.getPrice();
        return discount;
    }

    public double getDiscountBuyOneGetNextHalf(Product product) {
        int quantity = product.getQuantity();
        int paidQuantity = (quantity / 2) + (quantity % 2); // Round up to the nearest whole number
        int freeQuantity = quantity - paidQuantity;
        double discount = (product.getPrice() / 2) * freeQuantity;
        return discount;
    }

    
    // Method for adding hardcoded products
   public void addHardcodedProducts() {
        Product product1 = new Product("Product 1", 10.99, 2);
        Product product2 = new Product("Product 2", 19.99, 1);

        // Add the products to the shopping cart
        addProduct(product1);
        addProduct(product2);
    }



}

