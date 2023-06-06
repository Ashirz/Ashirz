package Model;

public class Product{
		
		String Prod_name;
		int Quantity;
		double Price;
		 private int buyXGetYFreeOffer; // number of items needed to qualify for the offer (X) and the number of items to be given for free (Y).


	public Product(String Prod_name, double Price, int Quantity) {
		
		this.Prod_name = Prod_name;
		this.Quantity = Quantity;
		this.Price = Price;
		
		}

	
	public Product(String prod_name, double price, int quantity,int buyXGetYFreeOffer) {
		
		Prod_name = prod_name;
		Quantity = quantity;
		Price = price;
		this.buyXGetYFreeOffer = buyXGetYFreeOffer;
	}



	public Product() {
		// TODO Auto-generated constructor stub
	}




	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}

	public double getPrice() {
		return Price;
	}
	public void setPrice(int Price) {
		this.Price = Price;

	}

	public String getProd_name() {
		return Prod_name;
	}
	public void setProd_name(String Prod_name) {
		this.Prod_name = Prod_name;

	}
	
	public int getBuyXGetYFreeOffer() {
		return buyXGetYFreeOffer;
	}

	public void setBuyXGetYFreeOffer(int buyXGetYFreeOffer) {
		this.buyXGetYFreeOffer = buyXGetYFreeOffer;
	}


	@Override
	public String toString() {
		return "Product [Prod_name=" + Prod_name + ", Quantity=" + Quantity + ", Price=" + Price
				+ ", buyXGetYFreeOffer=" + buyXGetYFreeOffer + "]";
	}

	/*@Override
	public String toString() {
		return "Product [Product_Name=" + Prod_name + ", Price=" + Price + ", Quantity=" + Quantity + "]";
	}*/
	
	

	

	


	}


