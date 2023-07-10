package controller;


import java.io.*;
import java.sql.SQLException;
import dao.LoginDAO;
import dao.ProductDAO;
import model.Login;
import model.Product;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Login login = new Login();
		Product product = new Product();
		LoginDAO logindao = new LoginDAO();
		ProductDAO productdao = new ProductDAO();
		int option;
		
		do
		{
			System.out.println("1.Admin");
			System.out.println("2.Agent");
			System.out.println("3.Exit");
			System.out.println("----------------------------------------------");
			option = Integer.parseInt(br.readLine());
			
			switch(option)
			{
			case 1: System.out.println("-------------------------------------------------");
			System.out.println("Enter username");
			String username = br.readLine();
			System.out.println("Enter password");
			String password = br.readLine();
			login.setUSERNAME(username);
			login.setPASSWORD(password);
			boolean result = logindao.validate(login); 
			if(result == true)
			{
				System.out.println("Login Successful");
				System.out.println("------------------------------------------");
				
				do
				{
				
					System.out.println("1.Add Product");
					System.out.println("2.Display Inventory Details");
					System.out.println("3.Logout");
					System.out.println("-------------------------------------");
					option = Integer.parseInt(br.readLine());
					switch(option)
					{
					case 1: System.out.println("Enter product name");
					String productName = br.readLine();
					System.out.println("Enter product id");
					int productId = Integer.parseInt(br.readLine());
					System.out.println("Enter the min selling quantity");
					int minsell = Integer.parseInt(br.readLine());
					System.out.println("Enter the price of the product");
					int price = Integer.parseInt(br.readLine());
					System.out.println("Enter the product quantity");
					int quantity = Integer.parseInt(br.readLine());
					product.setPRODUCTNAME(productName);
					product.setPRODUCTID(productId);
					product.setMINSELL(minsell);
					product.setQUANTITY(quantity);
					product.setPRICE(price);
					productdao.addProduct(product);
					System.out.println("------------------------------------");
					break;
					case 2: productdao.display();
					break;
					case 3: 
					break;
					}
				}
				while(option != 3);
			}
			else
			{
				System.out.println("Username & Pssword is not correct");
			}
			
			break;
			
			case 2: System.out.println("------------------------------------------");
			System.out.println("Enter username");
			String agentusername = br.readLine();
			System.out.println("Enter password");
			String agentpassword = br.readLine();
			login.setUSERNAME(agentusername);
			login.setPASSWORD(agentpassword);
			result = logindao.validate(login);
			if(result == true)
			{
				
				System.out.println("Login Successful");
				System.out.println("----------------------------------------");
				
				do
				{
					System.out.println("1.Buy/Sell");
					System.out.println("2.Show History");
					System.out.println("3.Logout");
					System.out.println("--------------------------------------");
					option = Integer.parseInt(br.readLine());
					
				}
				while(option != 3);
			}
			else
			{
				System.out.println("username & Password is not correct");
			}
			break;
			case 3: System.exit(0);
			}
		}
		while(option!=3);
	}
}