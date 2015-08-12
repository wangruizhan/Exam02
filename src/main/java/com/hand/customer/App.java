package com.hand.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("请输入customerID:");
    	Scanner sn = new Scanner(System.in);
    	int i = sn.nextInt();
    	
		String sql = "select film_id,title from film  where film_id='"+i+"'";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","123456");
			
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			System.out.println("Film Id"+"| "+"Film 名称");
			while(rs.next()){
				System.out.print(rs.getInt("film_id")+" ");
				System.out.println(rs.getString("title")+" ");
				
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (Exception e2) {
				
			}
			try {
				st.close();
			} catch (Exception e2) {
				
			}
			try {
				conn.close();
			} catch (Exception e2) {
				
			}
		}
		
		
	}  
    }
    
