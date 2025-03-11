package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
     * 
     * @return Zerbitzariaren helbidea.
     */
    public String getServer() {
        return server;
    }

    /**
     * Datu-basearen izena itzultzen du.
     * 
     * @return Datu-basearen izena.
     */
    public String getDb() {
        return db;
    }

    /**
     * Taularen izena itzultzen du.
     * 
     * @return Taularen izena.
     */
    public String getTaula() {
        return taula;
    }

    /**
     * Erabiltzailearen izena itzultzen du.
     * 
     * @return Erabiltzailearen izena.
     */
    public String getUser() {
        return user;
    }

    /**
     * Pasahitza itzultzen du.
     * 
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
     * 
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
     * 
     * @param herria Txertatu beharreko herria.
     */
    public void txertatu(Herria herria) {
        String sql2 = "INSERT INTO Herriak(Herria, Probintzia) VALUES(?, ?)";

        try (Connection conn = konektatu()) {
            if (!herriaBadago(herria)) { // Si no existe, insertamos
                try (PreparedStatement pstmt = conn.prepareStatement(sql2)) {
                    pstmt.setString(1, herria.getHerria());
                    pstmt.setString(2, herria.getProbintzia());
                    pstmt.executeUpdate();
                    System.out.println(herria + " ondo txertatu da.");
                }
            } else {
                System.out.println(herria + " dagoeneko existitzen da.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean herriaBadago(Herria herria) {
        String sql = "SELECT COUNT(*) FROM Herriak WHERE Herria = '?' AND Probintzia = '?'";

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Asignar valores a los parámetros
            pstmt.setString(1, herria.getHerriIzena()); // Suponiendo que Herria tiene un método getIzena()
            pstmt.setString(2, herria.getProbintzia()); // Suponiendo que Herria tiene un método getProbintzia()

            // Ejecutar la consulta
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Herria existitzen da");
                    return rs.getInt(1) > 0; // Si COUNT(*) > 0, significa que el registro existe
                }else{
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false; // En caso de error, devolver false
    }

    /**
     * Taulako erregistro guztiak kontsultatzen eta bistaratzen ditu.
     */
    public void kontsultatuTaula() {
        String sql = "SELECT * FROM " + taula;

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.println("Herria (Probintzia)");
            System.out.println("=====================================");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(new Herria(rs.getString("herria"), rs.getString("probintzia")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
