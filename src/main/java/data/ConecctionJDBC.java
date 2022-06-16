package data;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class ConecctionJDBC {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bienes_raices?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "passwd";
    private static final String JDBC_PASSWORD = "passwd";
    private static BasicDataSource dataSource;
    
    public static DataSource getDataSource() {
        if (dataSource == null) {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            // We define the start of the connection pool
            dataSource.setInitialSize(10);
        }
        return dataSource;
    }
    
    
    
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }
    
    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }
    
    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }
    
    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
