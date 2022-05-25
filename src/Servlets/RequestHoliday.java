package Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DBUtil.DataSourceFacotry;
import Dao.LeaveDao;
import Entity.qinjia;
import Impl.LeaveImpl;

/**
 * Servlet implementation class RequestHoliday
 */
@WebServlet("/RequestHoliday")
public class RequestHoliday extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestHoliday() {
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
        //doGet(request, response);
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String college = request.getParameter("xy");
        String professional=request.getParameter("zy");
        String classes=request.getParameter("bj");
        String teachername=request.getParameter("fdy");
        String cause=request.getParameter("jy");
        String severalDays=request.getParameter("qj");
        String backDays=request.getParameter("fx");
        String day=request.getParameter("ts");
        String phoneNum=request.getParameter("lx");
        String parentsPhoneNum=request.getParameter("jz");
        String name=request.getParameter("xm");
        String userNum=request.getParameter("xh");
        String qinjia_comment=request.getParameter("bz");

        System.out.println(qinjia_comment);

        qinjia la=new qinjia(college, professional, classes, cause, teachername,backDays, severalDays, day, phoneNum, parentsPhoneNum, name, userNum,qinjia_comment,true,false);
//        System.out.println(la);
        DataSource ds=DataSourceFacotry.getInstance();
        LeaveDao ld=new LeaveImpl();
        try {
            ld.add(ds, la);
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
