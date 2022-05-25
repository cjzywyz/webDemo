package Servlets;

import DBUtil.DataSourceFacotry;
import Dao.StudentDao;
import Entity.Student;
import Impl.StudentImpl;
import net.sf.json.JSONObject;
import org.apache.commons.dbutils.DbUtils;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class registerSerclets
 */
@WebServlet("/registerSerclets")
public class registerSerclets extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerSerclets() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
//        String data = request.getParameter("xingming");
//        System.out.println("doGet"+data);
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

//        if (xingmingValue.equals("")||xingmingValue.length()>=8||xingmingValue.length()<2||!DBUtil.FormattoJudge.checkNameChese(xingmingValue)){//姓名为空
//            jsonObject.put("error","error=01");
//            PrintWriter pw=response.getWriter();
//            pw.print(jsonObject.toString());
//            return;
//        }
//        if (xuehaoValue.equals("")||xuehaoValue.length()!=8){//学号不对
//            jsonObject.put("error","error=03");
//            PrintWriter pw=response.getWriter();
//            pw.print(jsonObject.toString());
//            return;
//        }
//        if (mimaValue.equals("")||mimaValue.length()>=13||mimaValue.length()<6||!DBUtil.FormattoJudge.isLetterOrDigits(mimaValue)){//密码为空
//            jsonObject.put("error","error=02");
//            PrintWriter pw=response.getWriter();
//            pw.print(jsonObject.toString());
//            return;
//        }

//        if ()
        DataSource ds= DataSourceFacotry.getInstance();
        Student stu=new Student(xingmingValue,xuehaoValue,mimaValue,null,null,null);
        StudentDao sd=new StudentImpl();
        try {
            boolean add = sd.add(ds, stu);
            System.out.println(add);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
