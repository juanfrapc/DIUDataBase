package persistence;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ConnectionData;

public class MySQLHandler implements SQLHandler {

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
    public List<String> getTables() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet result = metaData.getTables(null, null, "%", null);
        ArrayList<String> tables = new ArrayList<>();
        while (result.next()) {
            tables.add(result.getString("TABLE_NAME"));
        }
        return tables;
    }

    @Override
    public List<String> getFields(String table) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet result = metaData.getColumns(null, null, table, null);
        ArrayList<String> columns = new ArrayList<>();
        while (result.next()) {
            columns.add(result.getString("COLUMN_NAME"));
        }
        return columns;
    }

    @Override
    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}
