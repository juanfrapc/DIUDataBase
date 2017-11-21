package model;

public final class ConnectionData {
    
    public static final int SQLITE = 0;
    public static final int MYSQL = 1;
    
    private final int connectionType;

    private final String host;
    private final String dbName;
    private final int port;
    private final String userName;
    private final String passwd;

    public ConnectionData(int type, String host, String dbName, int port, String userName, String passwd) {
        this.connectionType = type;
        this.host = host;
        this.dbName = dbName;
        this.port = port;
        this.userName = userName;
        this.passwd = passwd;
    }    

    public int getConnectionType() {
        return connectionType;
    }
    
    public String getHost() {
        return host;
    }

    public String getDbName() {
        return dbName;
    }

    public int getPort() {
        return port;
    }

    public String getUserName() {
        return userName;
    }

    public String getPasswd() {
        return passwd;
    }
    
}
