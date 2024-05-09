package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;
import java.sql.Statement;

public class Employee {
	
	private static Connection connection;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		Employee employeeDb = new Employee();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Scanner scanner = new Scanner(System.in);
			
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String user = "root";
			String pass = "Sa123";
			
			connection = DriverManager.getConnection(url, user, pass);
			while(true) {
				
				System.out.println("Enter your choice: ");
				
				int choice = Integer.parseInt(scanner.next());
				
				switch (choice) {
				case 1:
					employeeDb.insertRecord();
					break;
					
				case 2:
					employeeDb.selectRecord();
					break;

				case 3:
					employeeDb.selectAllRecord();
					break;
					
				case 4:
					employeeDb.updateRecord();
					break;
					
				case 5:
					employeeDb.deleteRecord();
					break;
					
				default:
					System.out.println("Invalid input: ");
					break;
				}
	
				System.out.println("Do you want to perform another action?");
				
				String input = scanner.next();
				
				if(!input.equals("yes")) {
					break;
				}
			}
						
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void insertRecord() throws SQLException{
		String query = "insert into employee(ename, esalary, dept) values (?,?,?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		System.out.println("Please enter the name: ");
		preparedStatement.setString(1, scanner.nextLine());
		
		System.out.println("Please enter the salary: ");
		preparedStatement.setDouble(2, Double.parseDouble(scanner.nextLine()));
		
		System.out.println("Please enter the department: ");
		preparedStatement.setString(3, scanner.nextLine());
		
		int rows = preparedStatement.executeUpdate();
		
		if(rows != 0) {
			System.out.println("Record inserted succssefully!");
		}
	}
	
	
	private void selectRecord() throws SQLException{
		
		System.out.println("Enter EID to get record: ");
		int id =Integer.parseInt(scanner.nextLine());
		String query = "select * from employee where eid = " + id;
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		if(resultSet.next()) {
			int eid = resultSet.getInt("eid");
			String ename = resultSet.getString("ename");
			double esalary = resultSet.getDouble("esalary");
			String dept = resultSet.getString("dept");
			
			System.out.println("Eid : " + eid);
			System.out.println("Ename : " + ename);
			System.out.println("Esalary : " + esalary);
			System.out.println("Department : " + dept);
			System.out.println();
		}else {
			System.out.println();
		}
	}
	
	private void updateRecord() throws SQLException{
		
		System.out.println("What do you want update?");
		System.out.println("Enter 1 for updating name");
		
		
//		case 1:
//			System.out.println("enter name");
//			String newname = scanner.nextLine();
//			updatedQ = updatedQ + "name =? where id = " + id ;
//			PreparedStatement p = connection.prepareStatement(updatedQ)
//			
//			int row = PreparedStatement.executeUpdate();
//			if(row !=0)
//				System.out.println(break;);
			
		
//        System.out.println("Enter Employee ID:");
//        int id = scanner.nextInt();
//        System.out.println("Enter new Salary:");
//        double salary = scanner.nextDouble();
////        System.out.println("Enter new Salary:");
////        String name = scanner.nextLine();
////        System.out.println("Enter new Salary:");
////        String department = scanner.nextLine();
//        
//        String query = "update employee set esalary = ? where eid = ?";
//        PreparedStatement statement = connection.prepareStatement(query);
//        statement.setDouble(1, salary);
//        statement.setInt(2, id);
//
//        int rowsUpdated = statement.executeUpdate();
//        if (rowsUpdated > 0) {
//            System.out.println("Employee details updated !");
//        } else {
//            System.out.println("No employee found with ID: " + id);
//        }
	}
	
	private void selectAllRecord() throws SQLException{
		String query = "select * from employee";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		while(resultSet.next()) {
			int eid = resultSet.getInt("eid");
			String ename = resultSet.getString("ename");
			double esalary = resultSet.getDouble("esalary");
			String dept = resultSet.getString("dept");
			
			System.out.println("Eid : " + eid);
			System.out.println("Ename : " + ename);
			System.out.println("Esalary : " + esalary);
			System.out.println("Department : " + dept);
			System.out.println();
		}
	}
	
	
	private void deleteRecord() throws SQLException{
		System.out.println("Enter EID to delete record: ");
		int eid =Integer.parseInt(scanner.nextLine());
		
		String sql = "delete from employee where eid = " + eid;
		
		Statement statement = connection.createStatement();
		 int row = statement.executeUpdate(sql);
		 if(row !=0 ) {
			System.out.println("Record deleted successfully !"); 
		 }
	}
	
	
//	private void batchProcessing() throws SQLException{
//		String sql = "insert into emplyoee(name,salary,address) values('name',10000,'address')";
//		String sql1 = "insert into emplyoee(name,salary,address) values('name1',20000,'address1')";
//		String sql2 = "insert into emplyoee(name,salary,address) values('name1',30000,'address2')";
//		
//		Statement statement = connection.createStatement();
//		
//		statement.addBatch(sql);
//		statement.addBatch(sql1);
//		statement.addBatch(sql2);
//		
//		int[] rows = statement.executeBatch();
//		
//		for (int i : rows) {
//			if(i != 0)
//				continue;
//			else
//				connection.rollback();
//		}
//		connection.commit();
//	}
	
}
