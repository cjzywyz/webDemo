package Test;

import DBUtil.DataSourceFacotry;
import Dao.StudentDao;
import Entity.Student;
import Impl.StudentImpl;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author kj
 * @date 2022/5/12
 * @apiNote
 */
public class StudnetTest {
    public static void main(String[] args) {
        DataSource ds= DataSourceFacotry.getInstance();
        QueryRunner runner=new QueryRunner(ds);
        StudentDao sd=new StudentImpl();

//        try {
//            String sql="INSERT INTO student "
//                    + "SET stu_name=?,"
//                    + "stu_userNum=?,"
//                    + "stu_userPassword=?,"
//                    + "stu_back01=?,"
//                    + "stu_back02=?,"
//                    + "stu_back03=?";
//            int num=runner.update(sql,"1","2","3","4","5","6");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

//        try {
//            StudentDao stuDao=new StudentImpl();
//            Student stu=new Student("1","2","3",null,null,null);
//            System.out.println(stuDao.add(ds,stu));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            Student student = sd.queryByNum(ds, "20204738");
//            System.out.println(student);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            List<Student> students = sd.queryAll(ds);
//            System.out.println(students);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            Student stu=new Student("kk","2","123",null,null,null);
//            boolean upate1 = sd.upate(ds, stu);
//            System.out.println(upate1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            boolean delete = sd.delete(ds, "2");
            System.out.println(delete);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
