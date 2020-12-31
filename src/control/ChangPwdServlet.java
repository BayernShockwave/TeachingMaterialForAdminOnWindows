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
					out.println("�޸ĳɹ�!!!�����µ�¼!!!");
					out.println("<a href=\"Login.jsp\">���ص�¼����</a>");
				}
				else {
					out.println("����!!!�������벻һ��!!!");
					out.println("<a href=\"modifyself.jsp?userid="+userid+"\">����</a>");
				}
			}
			else {
				out.println("����!!!ԭ���벻��ȷ!!!");
				out.println("<a href=\"modifyself.jsp?userid="+userid+"\">����</a>");
			}
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		doGet(request,response);
	}
}