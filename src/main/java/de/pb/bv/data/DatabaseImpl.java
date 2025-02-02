package de.pb.bv.data;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseImpl {
    public void init() throws SQLException {
        try(var connection = connect()) {
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public DatabaseConnection connect() throws SQLException {
        String url = "jdbc:sqlite:my.db";
        return new DatabaseConnectionImpl(DriverManager.getConnection(url));
    }
}
