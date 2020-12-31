package control;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Dao.*;
import Entity.*;
@WebServlet("/check.action")
public class CheckServlet extends HttpServlet {
	private ManDao dao=new ManDao();
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("userid");
		//System.out.println(id);
		String type=request.getParameter("type");
		switch(type) {
		case "checkself":
			request.getSession().setAttribute("slist",dao.selectManById(id));
			response.sendRedirect("checkself.jsp");
			break;
		case "checkuser":
			request.getSession().setAttribute("ulist",dao.allUsers());
			response.sendRedirect("checkuser.jsp");
			break;
		case "checkemail":
			request.getSession().setAttribute("elist",dao.allEmails());
			response.sendRedirect("checkemail.jsp");
			break;
		case "checkdiary":
			response.sendRedirect("checkdiary.jsp");
			break;
		case "modifyself":
			request.getSession().setAttribute("dlist",dao.allDiaries());
			response.sendRedirect("modifyself.jsp");
			break;
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		doGet(request,response);
	}
}