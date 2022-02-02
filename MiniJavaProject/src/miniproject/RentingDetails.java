package miniproject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class RentingDetails {
	private int booking_Id=0;
	private String name;
	private String vehicle_Type;
	private String vehicle_Name;
	private double tot_Amount;
	private String booking_Date;
	private String address_Proof;
	private String contact_No;
	private String email_Id;
	
	
	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	
	public RentingDetails() throws SQLException, FileNotFoundException, IOException
	{
		con = MyConnection.getMyConnection ();
		System.out.println("**********TRAVEL MANAGEMENT SYSTEM**********\n----Book Here For Your Mind-Blowing Experience On Your Travel----");
	}
	
	public void getCustomerDetails()
	{
		System.out.println("\nFill in your details");
		Scanner sc = new Scanner(System.in);
		System.out.println("\nName: ");
		name=sc.nextLine();
		char ch;
		do {
			System.out.println("Type of vehicles");
			ArrayList<String> arrayList = new ArrayList<String>();
			arrayList.add("Bike");
			arrayList.add("Car");
			arrayList.add("Bus");
			for (String string : arrayList) {
			System.out.println(string);
			}
			Scanner sc1 = new Scanner(System.in);
			System.out.println("\nVehicle Type: ");
			vehicle_Type=sc1.nextLine();
			if(arrayList.contains(vehicle_Type))
			{
				System.out.println(vehicle_Type+" has been Selected");
			}
			else
			{
				System.out.println("Not AVAILABLE....PLEASE SELECT FROM THE ABOVE");
			}
			System.out.println("Do you want to select the vehicle type again(y/n): ");
			ch=sc.next().charAt(0);
			}while(ch=='y' || ch=='Y' );
		do {
			System.out.println("Select option from 1-3 to get the list of Vehicles \n1 for booking bike \n2 for booking Cars \n3 for booking Bus");
			Scanner scan = new Scanner(System.in);
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("\nList of Bikes");
				ArrayList<String> bikes = new ArrayList<String>();
				bikes.add("Hero Splendor Plus");
				bikes.add("Yamaha R15");
				bikes.add("Hero passion Pro");
				bikes.add("Honda Dio");
				bikes.add("TVS jupiter");
				bikes.add("Suzuki Access 125");
				for (String string : bikes) {
					System.out.println(string);
					}
				Scanner sc1 = new Scanner(System.in);
				System.out.println("\nEnter the Vehicle Name that you selected from the above list: ");
				vehicle_Name=sc1.nextLine();
				if(bikes.contains(vehicle_Name)){
					System.out.println("Your Booking On "+vehicle_Name+" has been Successfully Booked");
					double per_Hour=500;
					double tot_Hour;
					Scanner sc2 = new Scanner(System.in);
					System.out.println("Enter the total Hours : ");
					tot_Hour=sc2.nextDouble();
					tot_Amount=per_Hour*tot_Hour;
					System.out.println("Total Amount: "+tot_Amount);
					}
				else{
						System.out.println("Not AVAILABLE....PLEASE SELECT FROM THE ABOVE");
					}
					break;
				case 2:
					System.out.println("\nList of Cars");
					ArrayList<String> cars = new ArrayList<String>();
					cars.add("BMW car");
					cars.add("Audi");
					cars.add("Royal Rolls");
					cars.add("Maruthi");
					for (String string : cars) {
						System.out.println(string);
					}
					Scanner k = new Scanner(System.in);
					System.out.println("Enter the Vehicle Name that you selected from the above list: ");
					vehicle_Name=k.nextLine();
					if(cars.contains(vehicle_Name))
					{
						System.out.println("Your Booking On "+vehicle_Name+ " has been Booked");
						double per_Hour=3000;
						double tot_Hour;
						Scanner sc2 = new Scanner(System.in);
						System.out.println("Enter the total Hours : ");
						tot_Hour=sc2.nextDouble();
						tot_Amount=per_Hour*tot_Hour;
						System.out.println("Total Amount: "+tot_Amount);
					}
					else
					{
						System.out.println("Not AVAILABLE....PLEASE SELECT FROM THE ABOVE");
					}
						break;
				case 3:
					System.out.println("\n List of Bus");
					ArrayList<String> bus = new ArrayList<String>();
					bus.add("AC Bus");
					bus.add("Non-AC Bus");
					for (String string : bus) {
						System.out.println(string);
					}
					Scanner scanner = new Scanner(System.in);
					System.out.println("\n Enter the Vehicle Name that you selected from the above list: ");
					vehicle_Name=scanner.nextLine();
					if(bus.contains(vehicle_Name))
					{
						System.out.println("Your Booking On "+vehicle_Name+" Has been Booked");
						double per_Hour=1500;
						double tot_Hour;
						Scanner sc2 = new Scanner(System.in);
						System.out.println("Enter the total Hours : ");
						tot_Hour=sc2.nextDouble();
						tot_Amount=per_Hour*tot_Hour;
						System.out.println("Total Amount: "+tot_Amount);
					}
					else
					{
						System.out.println("Not AVAILABLE....PLEASE SELECT FROM THE ABOVE");
					}
						break;
				default:
					System.out.println("Please Select to the Correct Option");
						break;
			}
			System.out.println("Do you want to select the vehicle Name again(y/n): ");
			ch=sc.next().charAt(0);
			}
		while(ch=='y' || ch=='Y');
		System.out.println("Enter the Booking Date(yyyy-MM-dd):\n");
		booking_Date=sc.next();
		LocalDate d1 = LocalDate.parse(booking_Date);
		System.out.println("Address Proof: ");
		address_Proof=sc.next();
		System.out.println("Contact_ No: ");
		contact_No=sc.next();
		System.out.println("email_Id");
		email_Id=sc.next();
		}
	public void insertCustomerDetails() throws SQLException
	{
		ps = con.prepareStatement("insert into travel_details values(?,?,?,?,?,?,?,?,?)");
		ps.setInt(1,booking_Id);
		ps.setString(2, name);
		ps.setString(3, vehicle_Type);
		ps.setString(4, vehicle_Name);
		ps.setDouble(5, tot_Amount);
		ps.setString(6, booking_Date);
		ps.setString(7, address_Proof);
		ps.setString(8, contact_No);
		ps.setString(9, email_Id);
		int  n=ps.executeUpdate();
		System.out.println("Your Form is Submitted....Thank You!!!! "+name);
	}
	public void updateCustomerDetails() throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Correct Address Proof: ");
		address_Proof=sc.nextLine();
		System.out.println("Enter your Contact_No: ");
		contact_No=sc.next();
		ps = con.prepareStatement("update travel_details  set address_Proof = ? where contact_No=?");
		ps.setString(1, address_Proof );
		ps.setString(2, contact_No);
		int i=ps.executeUpdate();
		if(i>0)
			System.out.println("Updated Successfully");
		else
			System.out.println("No such Record found....Sorry");
	}
	
	public void searchCustomerDetails() throws SQLException
	{
		System.out.println("To Search the Vehicle Type From Your Record");
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter the Vehicle Type You Want to search ");
		vehicle_Type=sc.nextLine();
		ps=con.prepareStatement("select name,contact_No,tot_Amount from travel_details where vehicle_Type=?");
		ps.setString(1, vehicle_Type);
		rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.print(rs.getString(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.println(rs.getDouble(3));
			System.out.println();
		}
	}
	public void deleteCustomerDetails() throws SQLException
	{   
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Contact Number to Cancel Your Booking: ");
		contact_No = sc.next(); 
		ps = con.prepareStatement("delete from travel_details where contact_No=?");
		ps.setString(1, contact_No);
		int i=ps.executeUpdate();
		if(i>0)
			System.out.println("Cancelled");
		else
			System.out.println("No such Record found"); 
	}
	public void readCustomerDetails() throws SQLException
	{
		st=con.createStatement();
		rs=st.executeQuery("Select * from travel_details");
		while(rs.next())
		{
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\t");
			System.out.print(rs.getString(4)+"\t");
			System.out.print(rs.getString(5)+"\t");
			System.out.print(rs.getString(6)+"\t");
			System.out.print(rs.getString(7));
			
			System.out.println();
		}
		con.close();
	}
	
}