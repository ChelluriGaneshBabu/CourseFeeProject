package com.tmf.SMS.fee.congif;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConfigForFee {
	private static Connection con;
	public static Connection getConnection() {
		String url="jdbc:mysql://@localhost:3306/Fee";
		String usr="root",pwd="root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,usr,pwd);
			System.out.println("Connected with the data base");

			String q="Create table if not exists CourseFee ("
					+ "Fee bigint,sId int,cId int,bId int,FeePaid bigint,"
					+ "ReceivedOn date,ReceiptNumber varchar(20),BalanceFee bigint)";
			Statement st=con.createStatement();
			st.execute(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}