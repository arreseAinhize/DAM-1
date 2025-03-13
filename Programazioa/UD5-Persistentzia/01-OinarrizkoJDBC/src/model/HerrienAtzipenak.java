package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.base.Herria;

/**
 * Datu-basearekin konektatzeko eta herrien informazioa atzitzeko klasea.
 */
public class HerrienAtzipenak {
    private String server;
    private String db;
    private String taula;
    String user;
    String pass;

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
        String sqlSelectKopurua = "SELECT COUNT(*) AS Kopurua FROM " + taula;

        try (Connection conn = konektatu(); PreparedStatement pstmt = conn.prepareStatement(sqlSelectKopurua)) {
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    /**
     * Herri baten izenaren eta probintziaren arabera, datu-basean dagoen ala ez egiaztatzen du.
     * @param herria Egiaztatu beharreko herria.
     * @return true edo false, herria datu-basean badago edo ez.
     */
    public boolean herriaBadago(Herria herria) {
        String sqlCheck = "SELECT COUNT(*) FROM Herriak WHERE Herria = ? AND Probintzia = ?";
        
        try (Connection conn = konektatu(); PreparedStatement pstmt = conn.prepareStatement(sqlCheck)) {
            pstmt.setString(1, herria.getHerriIzena());
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
     * Herri berri bat taulan txertatzen du.
     * @param herria Txertatu beharreko herria.
     */
    public void txertatu(Herria herria) {
        if (herriaBadago(herria)) {
            System.out.println(herria + " dagoeneko existitzen da.");
            return;
        }
        String sqlInsert = "INSERT INTO " + taula + "(Herria, Probintzia) VALUES(?, ?)";
        try (Connection conn = konektatu(); PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {
            pstmt.setString(1, herria.getHerriIzena());
            pstmt.setString(2, herria.getProbintzia());
            pstmt.executeUpdate();
            System.out.println(herria + " ondo txertatu da.");
        } catch (SQLException e) {
            System.out.println("Errorea txertatzean: " + e.getMessage());
        }
    }

    /**
     * Taulako erregistro guztiak kontsultatzen eta bistaratzen ditu.
     */
    public void erakutsiDatuak() {
        String sqlSelect = "SELECT * FROM " + taula;
        try (Connection conn = konektatu(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sqlSelect)) {
            System.out.println(taula + " taulan dauden datuak:");
            while (rs.next()) {
                System.out.println(rs.getString("Herria") + " - " + rs.getString("Probintzia"));
            }
        } catch (SQLException e) {
            System.out.println("Errorea datuak erakustean: " + e.getMessage());
        }
    }

    /**
     * Herri bat datu-basetik ezabatzen du.
     * @param herria Herriaren objektua (izena eta probintzia).
     */
    public void ezabatu(Herria herria) {
        if (!herriaBadago(herria)) {
            System.out.println(herria + " ez da existitzen datu-basean.");
            return;
        }
        String sqlDelete = "DELETE FROM " + taula + " WHERE Herria = ? AND Probintzia = ?";
        try (Connection conn = konektatu(); PreparedStatement pstmt = conn.prepareStatement(sqlDelete)) {
            pstmt.setString(1, herria.getHerriIzena());
            pstmt.setString(2, herria.getProbintzia());
            pstmt.executeUpdate();
            System.out.println(herria + " ondo ezabatu da.");
        } catch (SQLException e) {
            System.out.println("Errorea ezabatzean: " + e.getMessage());
        }
    }

    /**
     * Herri baten izena jasota, dagokion probintziaren izena itzultzen du.
     * @param herria Herriaren izena.
     * @return Herri horrek dagokion probintziaren izena edo null, aurkitzen ez bada.
     */
    public String getProbintzia(String herria) {
        String probintzia = null;
        String sqlSelect = "SELECT Probintzia FROM " + taula + " WHERE Herria = ?";
        
        try (Connection conn = konektatu(); PreparedStatement pstmt = conn.prepareStatement(sqlSelect)) {
            pstmt.setString(1, herria);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    probintzia = rs.getString("Probintzia");
                }
            }
        } catch (SQLException e) {
            System.out.println("Errorea datuak eskuratzean: " + e.getMessage());
        }
        
        return probintzia;
    }

    /**
     * Probintzia jakin bateko herrien zerrenda eskuratzen du.
     * @param probintzia Probintziaren izena.
     * @return Probintzia horretako herrien zerrenda.
     */
    public List<String> getProbintziaBatekoHerriak(String probintzia) {
        List<String> herriak = new ArrayList<>();
        String sqlSelect = "SELECT Herria FROM " + taula + " WHERE Probintzia = ?";

        try (Connection conn = konektatu(); PreparedStatement pstmt = conn.prepareStatement(sqlSelect)) {
            pstmt.setString(1, probintzia);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    herriak.add(rs.getString("Herria"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Errorea datuak eskuratzean: " + e.getMessage());
        }
        return herriak;
    }

    /**
     * Datu-basean dauden herri guztien izenen zerrenda eskuratzen du.
     * @return Herri guztien izenen zerrenda.
     */
    public List<String> getHerriIzenak() {
        List<String> herriak = new ArrayList<>();
        String sqlSelect = "SELECT Herria FROM " + taula;
        
        try (Connection conn = konektatu(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sqlSelect)) {
            while (rs.next()) {
                herriak.add(rs.getString("Herria"));
            }
        } catch (SQLException e) {
            System.out.println("Errorea datuak eskuratzean: " + e.getMessage());
        }
        
        return herriak;
    }


}
