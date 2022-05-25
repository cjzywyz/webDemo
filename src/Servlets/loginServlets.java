package Servlets;

import DBUtil.DataSourceFacotry;
import Dao.LeaveDao;
import Dao.StudentDao;
import Dao.TeacherDao;
import Entity.Student;
import Entity.Teacher;
import Entity.qinjia;
import Impl.LeaveImpl;
import Impl.StudentImpl;
import Impl.TeacherImpl;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class loginServlets
 */
@WebServlet("/loginServlets")
public class loginServlets extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        doGet(request, response);
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        DataSource ds= DataSourceFacotry.getInstance();
        StudentDao sd=new StudentImpl();
        TeacherDao td=new TeacherImpl();

        JSONObject jsonObject=new JSONObject();

        JSONObject jsonObject1=new JSONObject();

        String name = request.getParameter("name");
        int na=Integer.parseInt(name);

        String xuehaoValue = request.getParameter("xuehaoValue");
        String mimaValue = request.getParameter("mimaValue");

        if (na==1){
            try {
                Student student = sd.queryByNum(ds, xuehaoValue);
                if (student==null){
                    jsonObject.put("error","01");
                    PrintWriter pw=response.getWriter();
                    pw.print(jsonObject.toString());
                    return;
                }
                String stu_userPassword = student.getStu_userPassword();
                if (stu_userPassword.equals(mimaValue)){
                    HttpSession session=request.getSession();
                    session.setAttribute("loginedStudent", student);

                    jsonObject1.put("url","http://localhost:8080/RequestHoliday.jsp");
                    PrintWriter pw1=response.getWriter();
                    pw1.print(jsonObject.toString());
                }else {
                    jsonObject.put("error","01");
                    PrintWriter pw=response.getWriter();
                    pw.print(jsonObject.toString());
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            //判断老师登录
            try {
                Teacher tea = td.queryByNum(ds, xuehaoValue);
                if (tea==null){
                    jsonObject.put("error","01");
                    PrintWriter pw=response.getWriter();
                    pw.print(jsonObject.toString());
                    return;
                }
                String tea_userpassword = tea.getTea_userpassword();
                if (tea_userpassword.equals(mimaValue)){
                    HttpSession session=request.getSession();
                    session.setAttribute("loginedTeacher", tea);

                    jsonObject1.put("url","http://localhost:8080/RequestHoliday.jsp");
                    PrintWriter pw1=response.getWriter();
                    pw1.print(jsonObject.toString());
                }else {
                    jsonObject.put("error","01");
                    PrintWriter pw=response.getWriter();
                    pw.print(jsonObject.toString());
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
