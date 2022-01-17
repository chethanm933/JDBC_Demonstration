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
//		empdb.getEmployeeList(connection);
		empdb.getEmployeeList(connection);
		
	} 
		
		public void getEmployeeList( Connection connection) {
			
			List<EmployeePayroll> employeeList;
			try {
				Statement selectStatement;
				selectStatement = connection
						.createStatement();
				ResultSet result = selectStatement.
						executeQuery("select emp_id,name,emp_table.dept_id,description,dept_name,gender,start from emp_table, "
								+ "dept_table where emp_table.dept_id = dept_table.dept_id order by emp_id;");
		
				List<EmployeePayroll>  databaseList = new ArrayList<>();
		
			while(result.next()) {
			EmployeePayroll emppayroll = new EmployeePayroll();
			emppayroll.setEmp_id(result.getInt("emp_id"));
			emppayroll.setName(result.getString("name"));
			Department department = new Department();
			department.setDept_id(result.getInt("dept_id"));
			department.setDept_name(result.getString("dept_name"));
			emppayroll.setDepartment(department);
			department.setDescription(result.getString("description"));
			emppayroll.setGender(result.getString("gender"));
			emppayroll.setStart(result.getDate("start"));
			
			databaseList.add(emppayroll);
		}
			databaseList.forEach(emp -> {
				  System.out.println("Employee Id :"+emp.getEmp_id());
				  System.out.println("Employee Name :"+emp.getName());
				  System.out.println("Department Id :"+emp.getDepartment().getDept_id());
				  System.out.println("Department Name :"+emp.getDepartment().getDept_name());
				  System.out.println("Department Description :"+emp.getDepartment().getDescription());
				  System.out.println("Gender :"+emp.getGender());
				  System.out.println("Joining Date :"+emp.getStart());
				  System.out.println("---------------");
});  
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

		public void getEmplooyeeListWithDerpartment(Connection connection) {
			List<EmployeePayroll> employeeList = new ArrayList<>();
			  
			Statement statement;
			try {
				statement = connection.createStatement();
				ResultSet resultset = statement.executeQuery("sdfesf");
				
				while(resultset.next()) {
					EmployeePayroll emppayroll = new EmployeePayroll();
					Department department = new Department();
					
					emppayroll.setEmp_id(resultset.getInt(1));
					emppayroll.setName(resultset.getString(2));
					department.setDept_name(resultset.getString(3));
					emppayroll.setDepartment(department);
					emppayroll.setGender(resultset.getString(4));
					emppayroll.setStart(resultset.getDate(5));
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
}
 