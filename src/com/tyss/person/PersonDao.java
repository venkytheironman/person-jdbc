package com.tyss.person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class PersonDao {
	String url ="jdbc:mysql://localhost:3306";
	String userName = "root";
	String password = "root";

	public void savePerson(int id,String name,long phone,String email,String pass,int age) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url,userName,password);
			String sql ="INSERT INTO ty_learn.person VALUES(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setLong(3, phone);
			preparedStatement.setString(4,email);
			preparedStatement.setString(5, pass);
			preparedStatement.setInt(6, age);
			preparedStatement.execute();
			connection.close();
			System.out.println("Data inserted");


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Person getPersonById(int id) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url,userName,password);
			String sqlGet = "SELECT * FROM ty_learn.person WHERE id =?";
			PreparedStatement preparedStatementGet = connection.prepareStatement(sqlGet);
			preparedStatementGet.setInt(1,id);
			//preparedStatementGet.execute();
			ResultSet resultset = preparedStatementGet.executeQuery();
			Person p1 = new Person();
				while(resultset.next()) {
					p1.id=resultset.getInt(1);
					p1.name=resultset.getString(2);
					p1.phone=resultset.getLong(3);
					p1.email=resultset.getString(4);
					p1.pass=resultset.getString(5);
					p1.age = resultset.getInt(6);
					return p1;
				}
			
			
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}


	public List<Person> getAllPerson(){
		ArrayList<Person> al = new ArrayList();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName, password);
			// 3
			Statement stm = con.createStatement();
			// 4
			String q = "SELECT * FROM ty_learn.person";
			ResultSet resultset = stm.executeQuery(q);

			while (resultset.next()) {

				Person h5 = new Person();
				h5.id = resultset.getInt(1);
				h5.name = resultset.getString(2);
				h5.phone = resultset.getLong(3);
				h5.email=resultset.getString(4);
				h5.pass=resultset.getString(5);
				h5.age=resultset.getInt(6);
				al.add(h5);

			}

			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;

	}

	public void deleteHospital(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url,userName,password);
			String sqlDel= "DELETE FROM ty_learn.person WHERE id= ?";
			PreparedStatement preparedStatementDel = connection.prepareStatement(sqlDel);
			preparedStatementDel.setInt(1, id);
			preparedStatementDel.execute();
			connection.close();
			System.out.println("data is deleted");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public  Person validatePerson(String email, String pass) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url,userName,password);
			String sqlVal = "SELECT * FROM ty_learn.person WHERE email= ? and password=?";
			PreparedStatement preparedStatementDel = connection.prepareStatement(sqlVal);
			preparedStatementDel.setString(1,email);
			preparedStatementDel.setString(2,pass);
			ResultSet resultset = preparedStatementDel.executeQuery();
			Person p1 = new Person();
			while(resultset.next()) {
				p1.email=resultset.getString(1);
				p1.pass=resultset.getString(2);

			}
			if(p1.email != null && p1.pass != null) {
				System.out.println("Email and password is found");
			}
			else {
				System.out.println("Invalid email and password");
			}
			connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public  Person validatePerson2(long phone, String pass) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url,userName,password);
			String sqlVal = "SELECT * FROM ty_learn.person WHERE phone= ? and pass=?";
			PreparedStatement preparedStatementDel = connection.prepareStatement(sqlVal);
			preparedStatementDel.setLong(1,phone);
			preparedStatementDel.setString(2,pass);
			ResultSet resultset = preparedStatementDel.executeQuery();
			Person p1 = new Person();
			while(resultset.next()) {
				p1.phone=resultset.getLong(1);
				p1.pass=resultset.getString(2);
			}
			if(p1.phone != 0 && p1.pass != null) {
				System.out.println("Email and password is found");
			}
			else {
				System.out.println("Invalid email and password");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}


}
