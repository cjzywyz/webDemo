package Impl;

import Dao.LeaveDao;
import Entity.qinjia;
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
public class LeaveImpl implements LeaveDao {

    @Override
    public boolean add(DataSource ds, qinjia la) throws Exception {
        QueryRunner runner=new QueryRunner(ds);
        String sql="INSERT INTO qinjia "
                + "set college=?,"
                + "professional=?,"
                + "classes=?,"
                + "cause=?,"
                + "teachername=?,"
                + "backDays=?,"
                + "severalDays=?,"
                + "days=?,"
                + "phoneNum=?,"
                + "parentsPhoneNum=?,"
                + "name=?,"
                + "userNum=?,"
                + "qinjia_comment=?,"
                + "isconsent=?,"
                + "isconsent2=?";
        int num=runner.update(sql,
                la.getCollege(),
                la.getProfessional(),
                la.getClasses(),
                la.getCause(),
                la.getTeachername(),
                la.getBackDays(),
                la.getSeveralDays(),
                la.getDays(),
                la.getPhoneNum(),
                la.getParentsPhoneNum(),
                la.getName(),
                la.getUserNum(),
                la.getQinjia_comment(),
                false,
                true);
        return num>0?true:false;
    }

    @Override
    public boolean delete(DataSource ds, String userNum) throws Exception {
        QueryRunner runner=new QueryRunner(ds);
        String sql="delete from qinjia where userNum=?";

        int num=runner.update(sql,userNum);

        return num>0?true:false;
    }

    @Override
    public boolean upate(DataSource ds, qinjia la) throws Exception {
        QueryRunner runner=new QueryRunner(ds);
        String sql = "update qinjia "
                + "set college=?,"
                + "professional=?,"
                + "classes=?,"
                + "cause=?,"
                + "teachername=?,"
                + "backDays=?,"
                + "severalDays=?,"
                + "days=?,"
                + "phoneNum=?,"
                + "parentsPhoneNum=?,"
                + "name=?,"
                + "userNum=?,"
                + "qinjia_comment=?"
                + " where userNum=?";
        int num=runner.update(sql,
                la.getCollege(),
                la.getProfessional(),
                la.getClasses(),
                la.getCause(),
                la.getTeachername(),
                la.getBackDays(),
                la.getSeveralDays(),
                la.getDays(),
                la.getPhoneNum(),
                la.getParentsPhoneNum(),
                la.getName(),
                la.getUserNum(),
                la.getQinjia_comment(),
                la.getUserNum());
        return num>0?true:false;
    }

    @Override
    public qinjia queryByNum(DataSource ds, String userNum) throws Exception {
        QueryRunner runner=new QueryRunner(ds);
        String sql="select * from qinjia where userNum=?";
        BeanHandler<qinjia> laB=new BeanHandler<>(qinjia.class);
        qinjia la=runner.query(sql, laB,userNum);
        return la;
    }

    @Override
    public List<qinjia> queryByNum1(DataSource ds, String userNum) throws Exception {
        QueryRunner runner=new QueryRunner(ds);
        String sql="select * from qinjia where userNum=?";
        return runner.query(sql, new BeanListHandler<qinjia>(qinjia.class),userNum);
    }

    @Override
    public List<qinjia> queryAll(DataSource ds) throws Exception {
        QueryRunner runner=new QueryRunner(ds);
        String sql="select * from qinjia";
        return runner.query(sql, new BeanListHandler<qinjia>(qinjia.class));
    }

    @Override
    public boolean upateis(DataSource ds, String userNum, boolean iscount) throws Exception {
        QueryRunner runner=new QueryRunner(ds);
//        String sql = "update qinjia "
//                + "set isconsent=?"
//                + " where userNum=?";
//        int num=runner.update(sql,iscount,userNum);

        String sql="update qinjia "
                +"set isconsent=true "
                +"where userNum=?";

        String sql2 = "update qinjia "
                + "set isconsent2=false "
                + " where userNum=?";
        String sql3="update qinjia "
                + "set isconsent2=true, "
                + "isconsent=false "
                + " where userNum=?";

        runner.update(sql3,userNum);
        if (iscount){
            int num=runner.update(sql,userNum);
        }else {
            int num=runner.update(sql2,userNum);
        }
        return true;
    }

    @Override
    public boolean upateis1(DataSource ds, int id, boolean iscount) throws Exception {
        QueryRunner runner=new QueryRunner(ds);
//        String sql = "update qinjia "
//                + "set isconsent=?"
//                + " where userNum=?";
//        int num=runner.update(sql,iscount,userNum);

        String sql="update qinjia "
                +"set isconsent=true "
                +"where id=?";

        String sql2 = "update qinjia "
                + "set isconsent2=false "
                + " where id=?";
        String sql3="update qinjia "
                + "set isconsent2=true, "
                + "isconsent=false "
                + " where id=?";

        runner.update(sql3,id);
        if (iscount){
            int num=runner.update(sql,id);
        }else {
            int num=runner.update(sql2,id);
        }
        return true;
    }

    @Override
    public boolean upIsShool(DataSource ds, int id) throws Exception {
         QueryRunner runner=new QueryRunner(ds);
         String sql = "update qinjia "
                 + "set isconsent2=false,"
                 + "isconsent=true "
                 + "where id=?";
        int num = runner.update(sql, id);
        return num>0?true:false;
    }

}
