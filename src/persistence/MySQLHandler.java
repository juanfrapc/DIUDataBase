package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.ConnectionData;

public class MySQLHandler extends SQLHandler {

    private final Connection connection;
    
    public MySQLHandler(ConnectionData params) throws ClassNotFoundException, SQLException {
        this.connection = createConnection(params);
    }

    private Connection createConnection(ConnectionData params) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return (Connection) DriverManager.getConnection(
                "jdbc:mysql://" + params.getHost() + ":" + params.getPort() + "/" + params.getDbName() + "?useSSL=true",
                params.getUserName(),
                params.getPasswd());
    }

    @Override
    Connection getConnection() {
        return this.connection;
    }
}
