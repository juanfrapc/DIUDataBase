package persistence;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class SQLHandler {
    
    abstract Connection getConnection();
    
    public List<String> getTables() throws SQLException{
        Connection connection = getConnection();
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet result = metaData.getTables(null, null, "%", null);
        ArrayList<String> tables = new ArrayList<>();
        while (result.next()) {
            tables.add(result.getString("TABLE_NAME"));
        }
        return tables;
    };
    
    public List<String> getFields(String table) throws SQLException{
        Connection connection = getConnection();
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet result = metaData.getColumns(null, null, table, null);
        ArrayList<String> columns = new ArrayList<>();
        while (result.next()) {
            columns.add(result.getString("COLUMN_NAME"));
        }
        return columns;
    };
    
    public void closeConnection() throws SQLException{
        this.getConnection().close();
    }
}
