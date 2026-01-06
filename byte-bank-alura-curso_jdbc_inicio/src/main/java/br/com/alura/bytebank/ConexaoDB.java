package br.com.alura.bytebank;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    public static void main(String... x) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/beca_java?user=devuser&password=dev1234");
            System.out.println("Recuperei a coneção.");

            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
