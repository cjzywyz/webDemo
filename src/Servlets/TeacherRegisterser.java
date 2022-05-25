package Servlets;

import DBUtil.DataSourceFacotry;
import Dao.StudentDao;
import Dao.TeacherDao;
import Entity.Student;
import Entity.Teacher;
import Impl.StudentImpl;
import Impl.TeacherImpl;
import net.sf.json.JSONObject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TeacherRegisterser
 */
@WebServlet("/TeacherRegisterser")
public class TeacherRegisterser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherRegisterser() {
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
        JSONObject jsonObject=new JSONObject();


        String xingmingValue = request.getParameter("xingmingValue");
        String xuehaoValue = request.getParameter("xuehaoValue");
        String mimaValue = request.getParameter("mimaValue");
        System.out.println("姓名"+xingmingValue);
        System.out.println("学号"+xuehaoValue);
        System.out.println("密码"+mimaValue);


        DataSource ds= DataSourceFacotry.getInstance();
        Teacher tea=new Teacher(xingmingValue,xuehaoValue,mimaValue,null,null,null);
        TeacherDao td=new TeacherImpl();
        try {
            boolean add = td.add(ds, tea);
            System.out.println(add);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
