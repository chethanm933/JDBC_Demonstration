package com.mavenemployeedb.EmployeeManagment;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDatabase {
	
	public static void main(String[] args) {
		
		Connection connection = DatabaseConnection.getConnection();
		
		EmployeePayrollDatabase empdb = new EmployeePayrollDatabase();
		empdb.getEmployeeList(connection);
		
	} 
		
		public void getEmployeeList( Connection connection) {
			
			List<EmployeePayroll> employeeList;
			try {
				Statement selectStatement;
				selectStatement = connection
						.createStatement();
				ResultSet result = selectStatement.
						executeQuery("select * from emp_table;");
		
				List<EmployeePayroll>  databaseList = new ArrayList<>();
		
			while(result.next()) {
			EmployeePayroll emppayroll = new EmployeePayroll();
			emppayroll.setEmp_id(result.getInt("emp_id"));
			emppayroll.setName(result.getString("name"));
			emppayroll.setDept_id(result.getInt("dept_id"));
			emppayroll.setGender(result.getString("gender"));
			emppayroll.setStart(result.getDate("start"));
			
			databaseList.add(emppayroll);
		}
			databaseList.forEach(emp -> {
				  System.out.println("Employee Id :"+emp.getEmp_id());
				  System.out.println("Employee Name :"+emp.getName());
				  System.out.println("Department"+emp.getDept_id());
				  System.out.println("Gender :"+emp.getGender());
				  System.out.println("Joining Date :"+emp.getStart());
				 
			});  
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

}
 