package Servlets;

import DBUtil.DataSourceFacotry;
import Dao.LeaveDao;
import Entity.Student;
import Entity.qinjia;
import Impl.LeaveImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class RequestHolidayServlets
 */
@WebServlet("/RequestHolidayServlets")
public class RequestHolidayServlets extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestHolidayServlets() {
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
        DataSource ds = DataSourceFacotry.getInstance();
        LeaveDao ld = new LeaveImpl();

        HttpSession session = request.getSession();
        Object loginedStudent = session.getAttribute("loginedStudent");
        Student stu = (Student) loginedStudent;


        String college = request.getParameter("value0");
        String professional = request.getParameter("value1");
        String classes = request.getParameter("value2");
        String name = request.getParameter("value3");
        String userNum = request.getParameter("value4");
        String cause = request.getParameter("value5");
        String teachername = request.getParameter("value6");
        String day = request.getParameter("value7");
        String severalDays = request.getParameter("value8");
        String backDays = request.getParameter("value9");
        String phoneNum = request.getParameter("value10");
        String parentsPhoneNum = request.getParameter("value11");


        String qinjia_comment = null;

        String user = request.getParameter("userNum");

        qinjia qa = new qinjia(college, professional, classes, cause, teachername, backDays, severalDays, day, phoneNum, parentsPhoneNum, name, userNum, qinjia_comment, false, true);

        String xiangleave = request.getParameter("isSchool");
        boolean b = Boolean.parseBoolean(xiangleave);
        if (b) {
            try {
                String ids=request.getParameter("ids");
                System.out.println("ids:"+ids);
                int id=Integer.parseInt(ids);
                System.out.println("id="+id);
//                ld.delete(ds, stu.getStu_userNum());
                boolean b1 = ld.upIsShool(ds, id);
                System.out.println(b1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                if(college==""||professional==""||classes==""||cause==""||teachername==""||phoneNum==""||parentsPhoneNum==""){
                    System.out.println("没有数据！！！");
                }else {
                    boolean add = ld.add(ds, qa);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {

                    List<qinjia> list = ld.queryByNum1(ds, stu.getStu_userNum());
//                    System.out.println(list);
//            JSONObject obj=JSONObject.fromObject(list);
                    JSONArray fromObject = JSONArray.fromObject(list);
                    response.setContentType("text/html;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.print(fromObject.toString());


//                        qinjia qinjia1 = ld.queryByNum(ds, stu.getStu_userNum());
//                        JSONObject obj = JSONObject.fromObject(qinjia1);
//                        response.setContentType("text/html;charset=utf-8");
//                        PrintWriter out = response.getWriter();
//                        out.print(obj.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }


    }

}
