package Test;

import DBUtil.DataSourceFacotry;
import Dao.TeacherDao;
import Entity.Teacher;
import Impl.TeacherImpl;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author kj
 * @date 2022/5/15
 * @apiNote
 */
public class TeacherTest {
    public static void main(String[] args) {
        DataSource ds= DataSourceFacotry.getInstance();
        TeacherDao td=new TeacherImpl();

//        try {
//            Teacher ta=new Teacher("zrm","58585","1234","","","");
//            td.add(ds,ta);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            Teacher teacher = td.queryByNum(ds, "58585");
//            System.out.println(teacher);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            List<Teacher> teacherList = td.queryAll(ds);
//            System.out.println(teacherList);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        try {
//            Teacher ta=new Teacher("zrm","58585","12345","","","");
//            boolean upate = td.upate(ds, ta);
//            System.out.println(upate);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            boolean delete = td.delete(ds, "58585");
            System.out.println(delete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
