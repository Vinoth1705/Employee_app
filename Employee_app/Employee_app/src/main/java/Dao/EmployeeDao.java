package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dto.Employee;

public class EmployeeDao {

	static String className = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/employee_db?user=root&password=root";

	public void saveEmployee(Employee e) {

		try {
			Class.forName(className);
			Connection c = DriverManager.getConnection(url);

			PreparedStatement ps = c.prepareStatement("insert into employee  values(?,?,?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getPassword());
			ps.setLong(5, e.getPhone());

			ps.executeUpdate();

			c.close();

			System.out.println("Data saved");

		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}

	}

	public List<Employee> fetchAllEmployee() {

		try {

			Class.forName(className);
			Connection c = DriverManager.getConnection(url);

			Statement s = c.createStatement();

			ResultSet rs = s.executeQuery("select * from employee");

			ArrayList<Employee> list = new ArrayList<>();

			while (rs.next()) {

				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEmail(rs.getString("email"));
				e.setPassword(rs.getString("pass"));
				e.setPhone(rs.getLong("phone"));

				list.add(e);

			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void deleteEmployeeById(int id) {

		try {

			Class.forName(className);
			Connection c = DriverManager.getConnection(url);

			PreparedStatement ps = c.prepareStatement("delete from employee  where id = ?");
			ps.setInt(1, id);

			ps.executeUpdate();

			c.close();

			System.out.println("Data deleted");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Employee FetchById(int id) {

		try {

			Class.forName(className);
			Connection c = DriverManager.getConnection(url);

			PreparedStatement ps = c.prepareStatement("select * from employee where id = ?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEmail(rs.getString("email"));
				e.setPassword(rs.getString("pass"));
				e.setPhone(rs.getLong("phone"));

				return e;
			}

			return null;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Employee FetchByEmail(String email) {

		try {

			Class.forName(className);
			Connection c = DriverManager.getConnection(url);

			PreparedStatement ps = c.prepareStatement("select * from employee where email = ?");
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEmail(rs.getString("email"));
				e.setPassword(rs.getString("pass"));
				e.setPhone(rs.getLong("phone"));

				return e;
			}

			return null;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public  void    updateEmployee(Employee e) {
		
		try {
			Class.forName(className);
			Connection c = DriverManager.getConnection(url);

			PreparedStatement ps = c.prepareStatement("update employee set name=?,email=?,pass=?,phone=? where id = ?");
			ps.setInt(5, e.getId());
			ps.setString(1,e.getName());
			ps.setString(2,e.getEmail());
			ps.setString(3,e.getPassword());
			ps.setLong(4, e.getPhone());
			
			
			ps.executeUpdate();
			
			c.close();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
