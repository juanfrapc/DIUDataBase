package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.ConnectionData;

public class SQLiteHandler extends SQLHandler {

    private final Connection connection;
    
    public SQLiteHandler(ConnectionData params) throws ClassNotFoundException, SQLException {
        this.connection = createConnection(params);
    }

    private Connection createConnection(ConnectionData params) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        return (Connection) DriverManager.getConnection("jdbc:sqlite:" + params.getDbName());
    }

    @Override
    Connection getConnection() {
        return this.connection;
    }

}
