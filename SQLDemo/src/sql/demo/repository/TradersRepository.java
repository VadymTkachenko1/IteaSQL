package sql.demo.repository;

import java.sql.SQLException;

public class TradersRepository extends BaseTable implements TableOperation{

    public TradersRepository() throws SQLException {
        super("traders");
    }

    @Override
    public void createTable() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS shares (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(255) NOT NULL,
                sfreqTick INTEGER NOT NULL,
                cash DECIMAL(15,2) NOT NULL DEFAULT 1000,
                tradingMethod INTEGER NOT NULL,
                changeProbability INTEGER NOT NULL DEFAULT 50,
                about VARCHAR(255) NULL)
                """;
        super.executeSqlStatement(sql, "Created table " + getTableName());
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }
}
