package pro.christianmtr.tesis.ws.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static Connection con = null;

    public static Connection getConexion() {
        try {
            if (con == null) {
                String driver = "org.postgresql.Driver";

                String user = "user";
                String pass = "pass";
                String url = "jdbc:postgresql://127.0.0.1:5432/database";

                Class.forName(driver);

                con = DriverManager.getConnection(url, user, pass);
            }
            return con;
        } catch (Exception ex) {
            System.out.println(ex.getMessage().toString());
            throw new RuntimeException("Error to connect");
        }

    }

    static class turnOffListener extends Thread {
        @Override
        public void run() {
            try {
                Connection con = Connector.getConexion();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException("Error to close");
            }
        }

    }
}
