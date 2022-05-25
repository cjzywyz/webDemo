package Impl;

import Dao.TeacherDao;
import Entity.Teacher;
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
public class TeacherImpl implements TeacherDao {

    @Override
    public boolean add(DataSource ds, Teacher tea) throws Exception {
        QueryRunner runner=new QueryRunner(ds);
        String sql="insert into teacher "
                +"set tea_name=?,"
                + "tea_userNum=?,"
                + "tea_userPassword=?,"
                + "tea_back01=?,"
                + "tea_back02=?,"
                + "tea_back03=? ";

        int num=runner.update(sql,
                tea.getTea_name(),
                tea.getTea_userNum(),
                tea.getTea_userpassword(),
                tea.getTea_back01(),
                tea.getTea_back02(),
                tea.getTea_back03());
        return num>0?true:false;
    }

    @Override
    public boolean delete(DataSource ds, String tea_userNum) throws Exception {
        QueryRunner runner=new QueryRunner(ds);
        String sql="delete from teacher where tea_userNum=?";

        int num=runner.update(sql,tea_userNum);

        return num>0?true:false;
    }

    @Override
    public boolean upate(DataSource ds, Teacher tea) throws Exception {
        QueryRunner runner=new QueryRunner(ds);
        String sql="update teacher "
                + "set tea_name=?,"
                + "tea_userNum=?,"
                + "tea_userPassword=?,"
                + "tea_back01=?,"
                + "tea_back02=?,"
                + "tea_back03=? "
                +"where tea_userNum=?";
        int num=runner.update(sql,
                tea.getTea_name(),
                tea.getTea_userNum(),
                tea.getTea_userpassword(),
                tea.getTea_back01(),
                tea.getTea_back02(),
                tea.getTea_back03(),
                tea.getTea_userNum());
        return num>0?true:false;
    }

    @Override
    public Teacher queryByNum(DataSource ds, String tea_userNum) throws Exception {
        QueryRunner runner=new QueryRunner(ds);
        String sql="select * from teacher where tea_userNum=?";
        BeanHandler<Teacher> stuB=new BeanHandler<>(Teacher.class);
        Teacher tea=runner.query(sql, stuB,tea_userNum);
        return tea;
    }

    @Override
    public List<Teacher> queryAll(DataSource ds) throws Exception {
        QueryRunner runner=new QueryRunner(ds);
        String sql="select * from teacher ";
        return runner.query(sql, new BeanListHandler<Teacher>(Teacher.class));
    }

    @Override
    public boolean isExist(DataSource ds, Teacher tea) throws Exception {
        tea=queryByNum(ds, tea.getTea_userNum());
        return tea==null?false:true;
    }

}
