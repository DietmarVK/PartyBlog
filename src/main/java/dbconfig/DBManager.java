package dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

    private Connection con;

    public static DBManager getInstance() {
        DBManager instance = DBManagerHolder.INSTANCE;
        return instance;
    }

    private static class DBManagerHolder {

        private static final DBManager INSTANCE = new DBManager();
    }

    public void loadAndConnect() {
        try {
            Class.forName(DBProperties.DB_DRIVER.getText());
            con = DriverManager.getConnection(DBProperties.DB_URL.getText(),
                    DBProperties.DB_USERNAME.getText(),
                    DBProperties.DB_PASSWORD.getText());
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection(){
        return this.con;
    }

    public PreparedStatement createPreparedStatement(String sql, int... params) throws SQLException {
        switch (params.length) {
            case 0:
                return con.prepareStatement(sql);
            default:
                return con.prepareStatement(sql, params[0]);
}
    }

    public void close() throws SQLException {
        con.close();
    }

    public int readGeneratedKeys(Statement stmt) throws SQLException {
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            return id;
        }
        throw new SQLException("No generated KeyId");
    }
}
