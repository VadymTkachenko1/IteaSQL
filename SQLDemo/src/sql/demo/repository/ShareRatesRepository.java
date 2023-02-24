package sql.demo.repository;

import java.sql.SQLException;

public class ShareRatesRepository extends BaseTable implements TableOperation {
    public ShareRatesRepository() throws SQLException{
        super("shareRates");
    }

    @Override
    public void createTable() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS shareRates (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                operDate DATETIME NOT NULL,
                share BIGINT NOT NULL,
                rate DECIMAL NOT NULL)
                """;
        super.executeSqlStatement(sql, "Created table " + getTableName());
    }

    @Override
    public void createForeignKeys() throws SQLException {
        String sqlKey = """
                ALTER TABLE shareRates ADD FOREIGN KEY (share) REFERENCES shares(id)
                """;
        super.executeSqlStatement(sqlKey, "Created foreign key rates.share -> shares.id");
    }
}
