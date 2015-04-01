package de.oc.tro.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import de.oc.tro.entity.Category;
import de.oc.tro.entity.City;
import de.oc.tro.entity.Country;
import de.oc.tro.entity.Customer;
import de.oc.tro.entity.MyOrder;
import de.oc.tro.entity.Product;
import de.oc.tro.entity.Purchase_order;

@WebServlet(description = "Servlet", urlPatterns = { "/MyServlet",
		"/MyServlet.do" }, initParams = {
		@WebInitParam(name = "id", value = "1"),
		@WebInitParam(name = "name", value = "value") })
public class MyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int createdCusID = 1; 

	@PersistenceContext(unitName = "MyStore")
	protected EntityManager em;

	@Resource
	private UserTransaction utx;

	public MyServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("<html><body>" + "Hallo World" + "<br></body></html>");
		out.println("<html><body>" + testDB() + "<br></body></html>");
		/*out.println("<html><bodyNew Customer: >" + insertCustomer("firstname", "lastname") + "<br></body></html>");
		out.println("<html><body>Purchase_orders: " + Arrays.toString(findCustomer(createdCusID).getPurchase_order().toArray()) + "<br></body></html>");
		out.println("<html><body>Purchase_orders: " + findCustomer(createdCusID).getCity() + "<br></body></html>");*/

	}
	
	protected Customer testDB(){
		Customer cus = new Customer("Max", "Musterman");
		
		Country country = new Country("Germany", "this is Germany");
		City city = new City("Frankfurt", "this is Frankfurt in Germandy");
		
		Category category_work = new Category("work", "this is work category");
		Category category_home = new Category("home", "this is home category");
		
		HashSet<String> ingredients_tee = new HashSet<String>();
		ingredients_tee.add("tee");
		ingredients_tee.add("water");
		HashSet<String> ingredients_cof = new HashSet<String>();
		ingredients_cof.add("coffe");
		ingredients_cof.add("water");
		Product product_tee = new Product("tee", "this is Product tee", 0.0, ingredients_tee, country, category_home);
		Product product_cof = new Product("coffe", "this is Product coffe", 0.0, ingredients_cof, country, category_work);
		
		MyOrder order_tee = new MyOrder("order tee", 1, product_tee);
		MyOrder order_cof = new MyOrder("order cof", 1, product_cof);
		
		HashSet<MyOrder> orders = new HashSet<MyOrder>();
		orders.add(order_cof);
		orders.add(order_tee);
		Purchase_order porder = new Purchase_order(new Date(), orders);
		
		cus.addPurchase_order(porder);
		cus.setCity(city);
		cus.setCountry(country);
		cus.setStreet("Homestreet 123");
		
		try {
			utx.begin();
			em.persist(cus);
			utx.commit();
			createdCusID = cus.getId();
			System.out.println("-------------------" + cus.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cus;
	}

	protected Customer insertCustomer(String firstname, String lastname) {
		Customer cus = new Customer(firstname, lastname);
		
		Purchase_order por1 = new Purchase_order();
		Purchase_order por2 = new Purchase_order();
		Purchase_order por3 = new Purchase_order();
		cus.addPurchase_order(por1);
		cus.addPurchase_order(por2);
		cus.addPurchase_order(por3);
		City cit = new City("Frankfurt", "60000");
		cus.setCity(cit);

		try {
			utx.begin();
			em.persist(cus);
			utx.commit();
			createdCusID = cus.getId();
			System.out.println("-------------------" + cus.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cus;
	}
	
	protected Customer findCustomer(int id){
		try {
			return em.find(Customer.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
