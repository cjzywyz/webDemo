package Dao;

import Entity.Teacher;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author kj
 * @date 2022/5/11
 * @apiNote
 */
public interface TeacherDao {
    public boolean add(DataSource ds, Teacher tea)throws Exception;
    public boolean delete(DataSource ds,String stu_userNum)throws Exception;
    public boolean upate(DataSource ds,Teacher tea)throws Exception;
    public Teacher queryByNum(DataSource ds,String stu_userNum)throws Exception;
    public List<Teacher> queryAll(DataSource ds)throws Exception;
    public boolean isExist(DataSource ds,Teacher tea)throws Exception;
}
