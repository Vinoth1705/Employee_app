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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("pass");

		EmployeeDao dao = new EmployeeDao();

		Employee e = dao.FetchByEmail(email);

		if (e != null) {
			
			if(password.equals(e.getPassword())) {
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("view");
				dispatcher.forward(req, resp);
				
			}else {
				
				req.setAttribute("msg", "Incorrect password");

				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, resp);

				
			}
			
			
			

		} else {

			req.setAttribute("msg", "Email not found");

			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);

		}

	}

}
