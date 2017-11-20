package diudatabase;

public final class ConnectionData {
    
    private final String host;
    private final String dbName;
    private final int port;
    private final String userName;
    private final String passwd;

    public ConnectionData(String host, String dbName, int port, String userName, String passwd) {
        this.host = host;
        this.dbName = dbName;
        this.port = port;
        this.userName = userName;
        this.passwd = passwd;
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
