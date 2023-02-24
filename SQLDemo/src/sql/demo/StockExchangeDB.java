package sql.demo;

import sql.demo.repository.ShareRatesRepository;
import sql.demo.repository.SharesRepository;
import sql.demo.repository.TraderShareActionsRepository;
import sql.demo.repository.TradersRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StockExchangeDB {
    public static final String DB_URL = "jdbc:h2:./db/stockExchange";
    public static final String DB_Driver = "org.h2.Driver";

    private TradersRepository tradersRepository;
    private ShareRatesRepository shareRatesRepository;
    private SharesRepository sharesRepository;
    private TraderShareActionsRepository traderShareActionsRepository;

    private StockExchangeDB() throws SQLException, ClassNotFoundException {
        Class.forName(DB_Driver);

        tradersRepository = new TradersRepository();
        shareRatesRepository = new ShareRatesRepository();
        sharesRepository = new SharesRepository();
        traderShareActionsRepository = new TraderShareActionsRepository();
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    private void createTablesAndForeignKeys() throws SQLException {
        tradersRepository.createTable();
        shareRatesRepository.createTable();
        sharesRepository.createTable();
        traderShareActionsRepository.createTable();

        shareRatesRepository.createForeignKeys();
        traderShareActionsRepository.createForeignKeys();
    }
    public static void main(String[] args) {
        try {
            StockExchangeDB stockExchangeDB = new StockExchangeDB();
            stockExchangeDB.createTablesAndForeignKeys();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not fount");
        }
    }
}
