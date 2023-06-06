package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Cart;
import Model.Product;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productName = request.getParameter("prod_name");
        double productPrice = Double.parseDouble(request.getParameter("Price"));
        int productQuantity = Integer.parseInt(request.getParameter("Quantity"));

        // Create a new Product object
        Product product = new Product(productName, productPrice, productQuantity);

        // Get the shopping cart from the session
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        // If the cart doesn't exist in the session, create a new one
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        // Add the product to the shopping cart
        cart.addProduct(product);

        // Redirect to the view cart page
        response.sendRedirect("viewCart.jsp");
    }

	}


