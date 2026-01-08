package br.com.alura.bytebank;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection recuperarConexao() {
        try {
          return createDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();

        String host = System.getenv("DB_HOST");
        String dbName = System.getenv("DB_NAME");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        String jdbcUrl = "jdbc:postgresql://" + host + "/" + dbName;

        config.setJdbcUrl(jdbcUrl);
        config.setUsername(user);
        config.setPassword(password);

        // máximo de conexões permitidas
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }
}
