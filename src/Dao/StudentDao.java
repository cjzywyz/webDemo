package Dao;

import Entity.Student;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author kj
 * @date 2022/5/11
 * @apiNote
 */
public interface StudentDao {
    public boolean add(DataSource ds, Student stu)throws Exception;
    public boolean delete(DataSource ds,String stu_userNum)throws Exception;
    public boolean upate(DataSource ds,Student stu)throws Exception;
    public Student queryByNum(DataSource ds,String stu_userNum)throws Exception;
    public List<Student> queryAll(DataSource ds)throws Exception;
    public boolean isExist(DataSource ds,Student stu)throws Exception;
}
