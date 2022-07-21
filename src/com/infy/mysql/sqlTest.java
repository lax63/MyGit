package com.infy.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class sqlTest{
	
	public static void main(String []s) {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        final String database = "jdbc:mysql://localhost:3306/student";
	        final String user = "root";
	        final String password = "pass@word1";
	        Connection connection = DriverManager.getConnection(database,user, password);

	        Statement statement;
	        statement = connection.createStatement();
	        ResultSet resultSet;
	        resultSet = statement.executeQuery(
	            "select * from student");
	        
	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String name = resultSet.getString("name").trim();
	            int marks = resultSet.getInt("marks");
	            System.out.println("id : " + id + " name : " + name + " Marks : " + marks);
	        }
	        resultSet.close();
	        statement.close();
	        connection.close();
	    }
	    catch (Exception exception) {
	        System.out.println(exception);
	    }
	}
	
}
