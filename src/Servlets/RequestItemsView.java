package Servlets;

import DBUtil.DataSourceFacotry;
import Dao.LeaveDao;
import Entity.qinjia;
import Impl.LeaveImpl;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.dbutils.QueryRunner;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class RequestItemsView
 */
@WebServlet("/RequestItemsView")
public class RequestItemsView extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestItemsView() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        LeaveDao ld=new LeaveImpl();
//        DataSource ds= DataSourceFacotry.getInstance();
//        try {
////            response.getWriter().append("Served at: ").append(request.getContextPath());
//            List<qinjia> list = ld.queryAll(ds);
////            System.out.println(list);
////            JSONObject obj=JSONObject.fromObject(list);
//            JSONArray fromObject = JSONArray.fromObject(list);
//            response.setContentType("text/html;charset=utf-8");
//            PrintWriter out=response.getWriter();
//            out.print(fromObject.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        try {
//            boolean iscon= Boolean.parseBoolean(request.getParameter("isZhuangTai"));
//            String userNum=request.getParameter("userNum");
//            System.out.println("iscon:"+iscon);
//
////            System.out.println("iscon="+iscon);
////            System.out.println("userNum="+userNum);
//            boolean upateis = ld.upateis(ds, userNum, iscon);
//            System.out.println("upteis="+upateis);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //doGet(request, response);
        LeaveDao ld=new LeaveImpl();
        DataSource ds= DataSourceFacotry.getInstance();
        try {
//            response.getWriter().append("Served at: ").append(request.getContextPath());
            List<qinjia> list = ld.queryAll(ds);
//            System.out.println(list);
//            JSONObject obj=JSONObject.fromObject(list);
            JSONArray fromObject = JSONArray.fromObject(list);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.print(fromObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            boolean iscon= Boolean.parseBoolean(request.getParameter("isZhuangTai"));
            String userNum=request.getParameter("userNum");
            String ids=request.getParameter("ids");
            System.out.println(ids);
            int id =0;
            if (ids!=null){
                id=Integer.parseInt(ids);
            }

            System.out.println("iscon:"+iscon);
            System.out.println("id="+id);

//            System.out.println("iscon="+iscon);
//            System.out.println("userNum="+userNum);
           // boolean upateis = ld.upateis(ds, userNum, iscon);
            boolean b = ld.upateis1(ds, id, iscon);
            System.out.println("upteis="+b);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
////            response.getWriter().append("Served at: ").append(request.getContextPath());
//            List<qinjia> list = ld.queryAll(ds);
////            System.out.println(list);
////            JSONObject obj=JSONObject.fromObject(list);
//            JSONArray fromObject = JSONArray.fromObject(list);
//            response.setContentType("text/html;charset=utf-8");
//            PrintWriter out=response.getWriter();
//            out.print(fromObject.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }


}
