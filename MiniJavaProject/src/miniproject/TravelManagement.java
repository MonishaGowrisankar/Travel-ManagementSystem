package miniproject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class TravelManagement {

	public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		// We will do add,update,delete and search operations using PreparedStatement
		int choice;
		char ch;
		RentingDetails r = new RentingDetails();
		do {
		System.out.println("Select an option \n1 for booking  \n2 for update your details if you want \n3 for Search Customer Details with particular value \n4  for delete particular details  \n5 for view all details \n6 for Exit");
		Scanner scan = new Scanner(System.in);
		choice=scan.nextInt();
			switch(choice)
			{
			case 1:
				r.getCustomerDetails();
				r.insertCustomerDetails();
					break;
			case 2:
				r.updateCustomerDetails();
					break;
			case 3:
				r.searchCustomerDetails();
					break;
			case 4:
				r.deleteCustomerDetails();
					break;
			case 5:
				r.readCustomerDetails();
					break;
			case 6:
				System.out.println("...Thanks For Visiting Our Page...");
				System.exit(0);
					break;
			default:
				System.out.println("Please select the correct option");
					break;
			}
			System.out.println("\nDo you want to continue(y/n)");
	    	ch=scan.next().charAt(0);
		}
		 while(ch=='y'|| ch=='Y');
		
	

	}

}
