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

//代替原来的login_rs_jsp和其中冗长的语句,使用Servlet作为控制层C连接视图层V和模型层M
//模型层M由JavaBean实现和数据库的交互,视图层V由jsp界面实现数据的采集和用户的请求
@WebServlet("/login_rs")//使用@WebServlet代替web.xml
public class ValidateServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");//指定浏览器及utf-8码表打开服务器发出的数据
		response.setCharacterEncoding("utf-8");//设置response使用的码表,控制response以utf-8码表向浏览器写入数据
		request.setCharacterEncoding("utf-8");//同理request
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
					str="登录成功!欢迎"+name+"!";
					session.setAttribute("userid",userid);
					session.setAttribute("str",str);
					response.sendRedirect("Manfrm.jsp");
					break;
				}
				else {
					str="登录失败!";
				}
			}
		}
		else {
			str="警告!!!用户名或密码不能为空!!!";
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
				out.println("<a href=\"Login.jsp\">返回</a>");
				
			}
		}
		if(userid==null||password==null) {
			out.println(str);
			out.println("<a href=\"Login.jsp\">返回</a>");
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		doGet(request,response);
	}
}