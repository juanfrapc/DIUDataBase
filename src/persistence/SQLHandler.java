package persistence;

import java.sql.SQLException;
import java.util.List;

public interface SQLHandler {
    
    public List<String> getTables() throws SQLException;
    
    public List<String> getFields(String table) throws SQLException;
    
    public void closeConnection() throws SQLException;
}
