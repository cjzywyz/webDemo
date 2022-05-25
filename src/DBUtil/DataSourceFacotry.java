package DBUtil;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

/**
 * @author kj
 * @date 2022/5/11
 * @apiNote
 */
public class DataSourceFacotry {
    static DataSource ds = null;
    static {
        ComboPooledDataSource cpds = null;
        try {
            cpds = new ComboPooledDataSource("itcast");
            ds = cpds;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static DataSource getInstance() {
        return ds;
    }
}
