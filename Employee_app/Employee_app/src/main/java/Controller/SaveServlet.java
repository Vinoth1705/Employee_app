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

@WebServlet("/save")
public class SaveServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

		employeeDao.saveEmployee(e);
		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
//		resp.getWriter().print("<h1>Data saved</h1>");

	}

}
