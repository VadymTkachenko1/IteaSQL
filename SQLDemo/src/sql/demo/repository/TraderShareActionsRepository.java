package sql.demo.repository;

import java.sql.SQLException;

public class TraderShareActionsRepository extends BaseTable implements TableOperation{

    public TraderShareActionsRepository() throws SQLException {
        super("traderShareActions");
    }

    @Override
    public void createTable() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS traderShareActions (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                operation INT NOT NULL,
                trader BIGINT NOT NULL,
                shareRate DECIMAL NOT NULL,
                amount BIGINT NOT NULL)
                """;
        super.executeSqlStatement(sql, "Created table " + getTableName());
    }

    @Override
    public void createForeignKeys() throws SQLException {
        String sqlKey = """
                ALTER TABLE traderShareActions ADD FOREIGN KEY (trader) REFERENCES shares(id)
                """;
        super.executeSqlStatement(sqlKey, "Created foreign key traderShareActions.trader -> shares.id");
    }
}
