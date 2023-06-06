package Database;


	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import Model.Product;



	public class ProductDAO {

		Product oneProduct = null;
		Connection conn = null;
		Statement stmt = null;
		String user = "unnisawa";
		String password = "zonkeRan6";
		String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/" + user;

		public ProductDAO() {
		}
		

		private void openConnection() {
			// loading jdbc driver for mysql
			try {
				Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				System.out.println(e);
			}

			// connecting to database
			try {
				// connection string for demos database, username demos, password demos
				conn = DriverManager.getConnection(url, user, password);
				stmt = conn.createStatement();
			} catch (SQLException se) {
				System.out.println(se);
			}
		}

		private void closeConnection() {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		private Product getNextProduct(ResultSet rs) {
			Product thisProduct = null;
			try {

				thisProduct = new Product(rs.getString("Prod_name"), rs.getDouble("Price"), rs.getInt("Quantity"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return thisProduct;
		}

		//retrieving all products
		
		public ArrayList<Product> getAllProducts() {

			ArrayList<Product> allProducts = new ArrayList<Product>();
			openConnection();

			// Create select statement and execute it
			try {
				String selectSQL = "select * from products";
				ResultSet rs1 = stmt.executeQuery(selectSQL);
				// Retrieve the results
				while (rs1.next()) {
					oneProduct = getNextProduct(rs1);
					allProducts.add(oneProduct);
				}

				stmt.close();
				closeConnection();
			} catch (SQLException se) {
				System.out.println(se);
			}

			return allProducts;
		}
		
		//searching a product by id

		public Product getProductByID(int Id) {

			openConnection();
			oneProduct = null;
			// Create select statement and execute it
			try {
				String searchSQL = "select * from products where id=" + Id;
				ResultSet rs1 = stmt.executeQuery(searchSQL);
				// Retrieve the results
				while (rs1.next()) {
					oneProduct = getNextProduct(rs1);
				}

				stmt.close();
				closeConnection();
			} catch (SQLException se) {
				System.out.println(se);
			}

			return oneProduct;
		}


	}

