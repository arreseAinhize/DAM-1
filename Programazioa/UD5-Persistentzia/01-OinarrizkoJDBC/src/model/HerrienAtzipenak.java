package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.base.Herria;

/**
 * Datu-basearekin konektatzeko eta herrien informazioa atzitzeko klasea.
 */
public class HerrienAtzipenak {
    private String server = "localhost";
    private String db = "HerrienDBa";
    private String taula = "Herriak";

    String user = "ikaslea";
    String pass = "ikaslea";

    /**
     * Eraikitzailea. Datu-basearen konfigurazioa ezartzen du.
     * 
     * @param server Zerbitzariaren helbidea.
     * @param db     Datu-basearen izena.
     * @param taula  Taularen izena.
     * @param user   Erabiltzailea.
     * @param pass   Pasahitza.
     */
    public HerrienAtzipenak(String server, String db, String taula, String user, String pass) {
        this.server = server;
        this.db = db;
        this.taula = taula;
        this.user = user;
        this.pass = pass;
    }

    /**
     * Zerbitzariaren helbidea itzultzen du. 
     * @return Zerbitzariaren helbidea.
     */
    public String getServer() {
        return server;
    }

    /**
     * Datu-basearen izena itzultzen du.
     * @return Datu-basearen izena.
     */
    public String getDb() {
        return db;
    }

    /**
     * Taularen izena itzultzen du.
     * @return Taularen izena.
     */
    public String getTaula() {
        return taula;
    }

    /**
     * Erabiltzailearen izena itzultzen du.
     * @return Erabiltzailearen izena.
     */
    public String getUser() {
        return user;
    }

    /**
     * Pasahitza itzultzen du.
     * @return Pasahitza.
     */
    public String getPass() {
        return pass;
    }

    public void setServer(String serv) {
        this.server = serv;
    }

    public void setDB(String db) {
        this.db = db;
    }

    public void setTaula(String taula) {
        this.taula = taula;
    }

    public void setUser(String us) {
        this.user = us;
    }

    public void setSPass(String pass) {
        this.pass = pass;
    }

    /**
     * Datu-basearekin konexioa ezartzen du.
     * @return Datu-basearen konexioa edo null errore bat gertatzen bada.
     */
    public Connection konektatu() {
        String url = "jdbc:mariadb://" + server + "/" + db;
        Connection conn = null;
        {
            try {
                conn = DriverManager.getConnection(url, user, pass);
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

    /**
     * Taulan dauden erregistroen kopurua kontsultatzen du.
     */
    public int kontsultatuKopurua() {
        String sql = "SELECT COUNT(*) AS Kopurua FROM " + taula;

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    /**
     * Herri berri bat taulan txertatzen du.
     * @param herria Txertatu beharreko herria.
     */
    public void txertatu(Herria herria) {
        String sqlInsert = "INSERT INTO Herriak(Herria, Probintzia) VALUES(?, ?)";

        try (Connection conn = konektatu()) {
            if (conn != null && !herriaBadago(herria)) { 
                try (PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {
                    pstmt.setString(1, herria.getHerria());
                    pstmt.setString(2, herria.getProbintzia());
                    pstmt.executeUpdate();
                    System.out.println(herria + " ondo txertatu da.");
                }
            } else {
                System.out.println(herria + " dagoeneko existitzen da.");
            }
        } catch (SQLException e) {
            System.out.println("Errorea: " + e.getMessage());
        }
    }

    public boolean herriaBadago(Herria herria) {
        String sqlCheck = "SELECT COUNT(*) FROM Herriak WHERE Herria = ? AND Probintzia = ?";
        
        try (Connection conn = konektatu(); PreparedStatement pstmt = conn.prepareStatement(sqlCheck)) {
            pstmt.setString(1, herria.getHerria());
            pstmt.setString(2, herria.getProbintzia());

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Errorea: " + e.getMessage());
        }
        return false;
    }

    /**
     * Taulako erregistro guztiak kontsultatzen eta bistaratzen ditu.
     */
    public void erakutsiDatuak() {
        String sqlSelect = "SELECT * FROM " + taula;
        try (Connection conn = konektatu(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sqlSelect)) {
            System.out.println(taula+" taulan dauden datuak:");
            while (rs.next()) {
                System.out.println(rs.getString("Herria") + " - " + rs.getString("Probintzia"));
            }
        } catch (SQLException e) {
            System.out.println("Errorea datuak erakustean: " + e.getMessage());
        }
    }
}
