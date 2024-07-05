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

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		EmployeeDao dao = new EmployeeDao();

		Employee e = dao.FetchById(id);
		
		req.setAttribute("emp", e);

		RequestDispatcher dispatcher = req.getRequestDispatcher("Update.jsp");
		dispatcher.forward(req, resp);

	}

}
