package de.pb.bv.data;

import java.sql.Connection;

public class DatabaseConnectionImpl implements DatabaseConnection {
    private final Connection connection;
    public DatabaseConnectionImpl(Connection connection) {
        this.connection = connection;
        //EntityManager
        //connection.ins
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
