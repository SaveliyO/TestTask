package model.repository;

import config.DBConfig;
import model.entity.Account;

import javax.swing.tree.RowMapper;
import java.sql.Connection;
import java.util.UUID;

//TODO: В этом классе только работа с запросами, конфигурация соединения в отдельном классе (DBConfig)
public class AccountRepository {
    private static final String QUERY_GET_BY_ID = "SELECT FROM * ...";
    private final DBConfig dbConfig;

    public AccountRepository(DBConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

//    public Account getById(UUID id) {
//        execute(QUERY_GET_BY_ID, id);
//    }

//    private RowMapper execute(String query, Object... params) {
//        try (Connection connection = dbConfig.getConnetion()) {
//            connection.createStatement();
//        }
//    }
}
