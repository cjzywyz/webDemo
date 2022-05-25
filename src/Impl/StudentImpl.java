package Impl;

import Dao.StudentDao;
import Entity.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author kj
 * @date 2022/5/11
 * @apiNote
 */
public class StudentImpl implements StudentDao {

    @Override
    public boolean add(DataSource ds, Student stu) throws Exception {
        QueryRunner runner=new QueryRunner(ds);
        String sql="INSERT INTO student "
                + "SET stu_name=?,"
                + "stu_userNum=?,"
                + "stu_userPassword=?,"
                + "stu_back01=?,"
                + "stu_back02=?,"
                + "stu_back03=?";

        int num=runner.update(sql,
                stu.getStu_name(),
                stu.getStu_userNum(),
                stu.getStu_userPassword(),
                stu.getStu_back01(),
                stu.getStu_back02(),
                stu.getStu_back03());
        return num>0?true:false;
    }

    @Override
    public boolean delete(DataSource ds, String stu_userNum) throws Exception {
        QueryRunner runner=new QueryRunner(ds);
        String sql="delete from student where stu_userNum=?";

        int num=runner.update(sql,stu_userNum);

        return num>0?true:false;
    }

    @Override
    public boolean upate(DataSource ds, Student stu) throws Exception {
        QueryRunner runner=new QueryRunner(ds);
        String sql="update student "
                + "set stu_name=?,"
                + "stu_userNum=?,"
                + "stu_userPassword=?,"
                + "stu_back01=?,"
                + "stu_back02=?,"
                + "stu_back03=? "
                + "where stu_userNum=?";
        int num=runner.update(sql,
                stu.getStu_name(),
                stu.getStu_userNum(),
                stu.getStu_userPassword(),
                stu.getStu_back01(),
                stu.getStu_back02(),
                stu.getStu_back03(),
                stu.getStu_userNum());
        return num>0?true:false;
    }

    @Override
    public Student queryByNum(DataSource ds, String stu_userNum) throws Exception {
        QueryRunner runner=new QueryRunner(ds);
        String sql="select * from student where stu_userNum=?";
        BeanHandler<Student> stuB=new BeanHandler<>(Student.class);
        Student stu=runner.query(sql, stuB,stu_userNum);
        return stu;
    }

    @Override
    public List<Student> queryAll(DataSource ds) throws Exception {
        QueryRunner runner=new QueryRunner(ds);
        String sql="select * from student ";
        return runner.query(sql, new BeanListHandler<Student>(Student.class));
    }

    @Override
    public boolean isExist(DataSource ds, Student stu) throws Exception {
        stu=queryByNum(ds, stu.getStu_userNum());
        return stu==null?false:true;
    }

}
