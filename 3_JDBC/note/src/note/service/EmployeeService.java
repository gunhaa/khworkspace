package note.service;

import java.util.List;

import note.dao.EmployeeDAO;
import note.vo.Employee;

public class EmployeeService {

	private EmployeeDAO dao =new EmployeeDAO();
	
	public List<Employee> selectAll() {
		
		List<Employee> empList = dao.selectAll();
		
		return empList;
	}

}
