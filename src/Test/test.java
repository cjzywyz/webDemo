package Test;

import DBUtil.DataSourceFacotry;
import Dao.LeaveDao;
import Dao.TeacherDao;
import Entity.Teacher;
import Entity.qinjia;
import Impl.LeaveImpl;
import Impl.TeacherImpl;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author kj
 * @date 2022/5/11
 * @apiNote
 */
public class test {
    public static void main(String[] args) {
        DataSource ds = DataSourceFacotry.getInstance();
        QueryRunner runner=new QueryRunner(ds);
        LeaveDao ld=new LeaveImpl();

        try {
            boolean upateis = ld.upateis(ds, "20204738", true);
            System.out.println(upateis);
        } catch (Exception e) {
            e.printStackTrace();
        }


//        try {
//            List<qinjia> list = ld.queryByNum1(ds, "20204738");
//            System.out.println(list);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            boolean b = ld.upIsShool(ds, 5);
//            System.out.println(b);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            qinjia qinjia = ld.queryByNum(ds, "20204738");
//            System.out.println(qinjia);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        qinjia qinjia=new qinjia("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12","13",false,true);
//        try {
//            boolean add = ld.add(ds, qinjia);
//            System.out.println(add);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        TeacherDao td=new TeacherImpl();
//        Teacher tea=new Teacher("杨柳","55555555","123456",null,null,null);
//        try {
//            boolean add = td.add(ds, tea);
//            System.out.println(add);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        try {
//            List<qinjia> list = ld.queryByNum1(ds, "20204738");
//            System.out.println(list);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            System.out.println(ld.upIsShool(ds,"20204738",true));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try {
//            System.out.println(ld.upateis(ds,"20204738",false));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            qinjia qinjia = ld.queryByNum(ds, "20204738");
//            System.out.println(qinjia);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            boolean delete = ld.delete(ds, "43554354");
//            System.out.println(delete);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        System.out.println("我我我我");
//        try {
//            LeaveDao ld=new LeaveImpl();
//            System.out.println(ld.upateis(ds,"20200708",false));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
////            qinjia qin=new qinjia();
//            String sql = "update qinjia "
//                    + "set college=?,"
//                    + "professional=?,"
//                    + "classes=?,"
//                    + "cause=?,"
//                    + "teachername=?,"
//                    + "backDays=?,"
//                    + "severalDays=?,"
//                    + "days=?,"
//                    + "phoneNum=?,"
//                    + "parentsPhoneNum=?,"
//                    + "name=?,"
//                    + "userNum=?,"
//                    + "qinjia_comment=?"
//                    + " where userNum=?";
//            runner.update(sql,"1", "2", "3", "4",
//                    "5", "6", "7", "8", "9",
//                    "10", "11", "12","13","12");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

//        try {
//            LeaveDao ld=new LeaveImpl();
//            qinjia qin=new qinjia("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12","13",false);
//            ld.upate(ds,qin);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        String sql="INSERT INTO qinjia "
//                + "set college=?,"
//                + "professional=?,"
//                + "classes=?,"
//                + "cause=?,"
//                + "teachername=?,"
//                + "backDays=?,"
//                + "severalDays=?,"
//                + "days=?,"
//                + "phoneNum=?,"
//                + "parentsPhoneNum=?,"
//                + "name=?,"
//                + "userNum=?,"
//                + "qinjia_comment=?,"
//                + "isconsent=?,"
//                + "isconsent2=?";
//        try {
//            int num = runner.update(sql, "lj", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12","13",true,false);
//            if (num > 0) {
//                System.out.println("insert success");
//            } else {
//                System.out.println("insert failed");
//            }
//        } catch (SQLException e) {
//
//            e.printStackTrace();
//        }

//        try {
//            QueryRunner runner=new QueryRunner(ds);
//            String sql="select * from qinjia";
//            List<qinjia> queryle = runner.query(sql, new BeanListHandler<qinjia>(qinjia.class));
//            System.out.println(queryle);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }

}
