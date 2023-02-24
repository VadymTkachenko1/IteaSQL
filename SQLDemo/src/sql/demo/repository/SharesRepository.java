package sql.demo.repository;

import java.sql.SQLException;

public class SharesRepository extends BaseTable implements TableOperation {
    public SharesRepository() throws SQLException {
        super("shares");
    }

    @Override
    public void createTable() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS shares (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(255) NOT NULL,
                changeProbability INTEGER NOT NULL,
                delta INTEGER NOT NULL)
                """;
        super.executeSqlStatement(sql, "Created table " + getTableName());
    }

    @Override
    public void createForeignKeys() throws SQLException {
    }
}
