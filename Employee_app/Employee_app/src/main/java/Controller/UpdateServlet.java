package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.EmployeeDao;
import Dto.Employee;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));

		Employee e = new Employee();
		e.setId(id);
		e.setName(name);
		e.setEmail(email);
		e.setPassword(pass);
		e.setPhone(phone);

		EmployeeDao employeeDao = new EmployeeDao();

		employeeDao.updateEmployee(e);

		RequestDispatcher dispatcher = req.getRequestDispatcher("view");
		dispatcher.forward(req, resp);

	}

}
