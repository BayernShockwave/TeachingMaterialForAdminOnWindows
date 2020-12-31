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

//����ԭ����login_rs_jsp�������߳������,ʹ��Servlet��Ϊ���Ʋ�C������ͼ��V��ģ�Ͳ�M
//ģ�Ͳ�M��JavaBeanʵ�ֺ����ݿ�Ľ���,��ͼ��V��jsp����ʵ�����ݵĲɼ����û�������
@WebServlet("/login_rs")//ʹ��@WebServlet����web.xml
public class ValidateServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");//ָ���������utf-8���򿪷���������������
		response.setCharacterEncoding("utf-8");//����responseʹ�õ����,����response��utf-8����������д������
		request.setCharacterEncoding("utf-8");//ͬ��request
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		String str="";
		String name="";
		ManDao dao = new ManDao();
		List<Man> manList = dao.allMans();
		//out.println(userid);
		//out.println(password);
		if(userid!=null&&password!=null) {
			for(Man man : manList) {
				if(man.getId().equals(userid) && man.getPwd().equals(password)) {
					name = man.getName();
					str="��¼�ɹ�!��ӭ"+name+"!";
					session.setAttribute("userid",userid);
					session.setAttribute("str",str);
					response.sendRedirect("Manfrm.jsp");
					break;
				}
				else {
					str="��¼ʧ��!";
				}
			}
		}
		else {
			str="����!!!�û��������벻��Ϊ��!!!";
		}
		if(userid!=null&&password!=null) {
			boolean exist=false;
			for(Man man : manList) {
				if(man.getId().equals(userid) && man.getPwd().equals(password)) {
					exist=true;
				}
				
			}
			if(!exist) {
				out.println(str);
				out.println("<a href=\"Login.jsp\">����</a>");
				
			}
		}
		if(userid==null||password==null) {
			out.println(str);
			out.println("<a href=\"Login.jsp\">����</a>");
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		doGet(request,response);
	}
}