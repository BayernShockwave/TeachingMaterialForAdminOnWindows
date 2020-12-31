package control;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Dao.*;
import Entity.*;
@WebServlet("/change_pwd_rs")
public class ChangPwdServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		String userid=(String)session.getAttribute("userid");
		String oldpassword=request.getParameter("oldpassword");
		String newpassword=request.getParameter("newpassword");
		String check_newpassword=request.getParameter("check_newpassword");
		ManDao dao = new ManDao();
		List<Man> manList = dao.selectManById(userid);
		for(Man man : manList) {
			if(oldpassword.equals(man.getPwd())) {
				if(newpassword.equals(check_newpassword)) {
					int i = dao.changePwd(newpassword,userid);
					out.println("修改成功!!!请重新登录!!!");
					out.println("<a href=\"Login.jsp\">返回登录界面</a>");
				}
				else {
					out.println("警告!!!两次密码不一致!!!");
					out.println("<a href=\"modifyself.jsp?userid="+userid+"\">返回</a>");
				}
			}
			else {
				out.println("警告!!!原密码不正确!!!");
				out.println("<a href=\"modifyself.jsp?userid="+userid+"\">返回</a>");
			}
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		doGet(request,response);
	}
}