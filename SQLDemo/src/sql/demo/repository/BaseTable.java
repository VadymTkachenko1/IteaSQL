package sql.demo.repository;

import sql.demo.StockExchangeDB;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseTable implements Closeable {
    Connection connection;
    String tableName;

    public BaseTable(String tableName) throws SQLException {
        this.tableName = tableName;
        this.connection = StockExchangeDB.getConnection();
    }

    @Override
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("SQL closing connection error");
        }
    }

    void executeSqlStatement (String sql, String description) throws SQLException {
        reopenConnection();
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        if (description != null) {
            System.out.println(description);
        }
    }

    void executeSqlStatement (String sql) throws SQLException {
        executeSqlStatement(sql, null);
    }
    void reopenConnection () throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = StockExchangeDB.getConnection();
        }
    }

    public String getTableName() {
        return tableName;
    }
}
