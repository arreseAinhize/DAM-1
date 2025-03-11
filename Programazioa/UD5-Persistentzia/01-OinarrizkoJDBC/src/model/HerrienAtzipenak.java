package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HerrienAtzipenak {
    private String server = "localhost";
    private String db = "HerrienDBa";
    private String taula = "Herriak";

    String user = "ikaslea";
    String pass = "ikaslea";


    // public HerrienAtzipena(){
    // }

    public HerrienAtzipenak(String server, String db, String taula, String user, String pass){
        this.server = server;
        this.db = db;
        this.taula = taula;
        this.user = user;
        this.pass = pass;
    }


    public Connection Konektatu() {
        String url = "jdbc:mariadb://" + server + "/" + db;
        Connection conn = null;
        {
            try {
                conn = DriverManager.getConnection(url, user, pass);
                // System.out.println(server + " zerbidoreko " + db + " datu-basera konektatu
                // zara.");
            } catch (SQLException e) {
                if (e.getErrorCode() == 1045)
                    System.out.println("Erabiltzaile edo pasahitz okerrak");
                else if (e.getErrorCode() == 0)
                    System.out.println("Ezin zerbitzariarekin konektatu");
                else
                    System.out.println(e.getErrorCode() + "-" + e.getMessage());
            }
            return conn;
        }
    }
}
