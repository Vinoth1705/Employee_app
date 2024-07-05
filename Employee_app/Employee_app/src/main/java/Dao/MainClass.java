package Dao;

import java.util.List;

import Dto.Employee;

public class MainClass {
		public static void main(String[] args) {
			
			
			EmployeeDao employeeDao = new EmployeeDao();
			
//			
//			Employee e = new Employee();
//			e.setId(2);
//			e.setName("jerry");
//			e.setEmail("jerry@gmail.com");
//			e.setPassword("123");
//			e.setPhone(3522118);
//			
//			
//			
//			employeeDao.saveEmployee(e);
//			
//			
//	List<Employee>  list =		employeeDao.fetchAllEmployee();
//	
//	for(Employee  e : list) {
//		System.out.println(e);
//	}
			
//			
//		Employee e =		employeeDao.FetchByEmail("jerry@.com");
//				
//		Employee e1 =		employeeDao.FetchById(2);
//		
//		System.out.println(e);
//		System.out.println(e1);
			
			
			employeeDao.deleteEmployeeById(2);
			
			
			
			
		}

}
