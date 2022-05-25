package Dao;

import Entity.qinjia;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author kj
 * @date 2022/5/11
 * @apiNote
 */
public interface LeaveDao {
    public boolean add(DataSource ds, qinjia la)throws Exception;
    public boolean delete(DataSource ds,String userNum)throws Exception;
    public boolean upate(DataSource ds, qinjia la)throws Exception;
    public qinjia queryByNum(DataSource ds, String userNum)throws Exception;
    public List<qinjia> queryByNum1(DataSource ds, String userNum)throws Exception;
    public List<qinjia> queryAll(DataSource ds)throws Exception;
    public boolean upateis(DataSource ds, String userNum, boolean iscount)throws Exception;
    public boolean upateis1(DataSource ds, int id, boolean iscount)throws Exception;
    public boolean upIsShool(DataSource ds, int id)throws Exception;
}
