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
    private String user;
    private String pass;
    private Connection connection;

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

    public Connection konektatu() {
        if (connection == null) {
            String url = "jdbc:mariadb://" + server + "/" + db;
            try {
                connection = DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                handleSQLException(e);
            }
        }
        return connection;
    }

    private void handleSQLException(SQLException e) {
        if (e.getErrorCode() == 1045)
            System.out.println("Erabiltzaile edo pasahitz okerrak");
        else if (e.getErrorCode() == 0)
            System.out.println("Ezin zerbitzariarekin konektatu");
        else
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null; // Reset the connection
            } catch (SQLException e) {
                System.out.println("Errorea konexioa itxiz: " + e.getMessage());
            }
        }
    }

    public int kontsultatuKopurua() {
        String sqlSelectKopurua = "SELECT COUNT(*) AS Kopurua FROM " + taula;
        try (PreparedStatement pstmt = konektatu().prepareStatement(sqlSelectKopurua)) {
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            logenErregistroa(user, "Datu baseko herriak taulako, herri kopurua eskuratu.");
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public boolean herriaBadago(Herria herria) {
        String sqlCheck = "SELECT COUNT(*) FROM " + taula + " WHERE Herria = ? AND Probintzia = ?";
        
        try (PreparedStatement pstmt = konektatu().prepareStatement(sqlCheck)) {
            pstmt.setString(1, herria.getHerriIzena());
            pstmt.setString(2, herria.getProbintzia());

            try (ResultSet rs = pstmt.executeQuery()) {
                logenErregistroa(user, "Datu baseko herriak taulako, herri bat badagoen begiratu.");
                return rs.next() && rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Errorea: " + e.getMessage());
        }
        return false;
    }

    public void txertatu(Herria herria) {
        if (herriaBadago(herria)) {
            System.out.println(herria + " dagoeneko existitzen da.");
            return;
        }
        String sqlInsert = "INSERT INTO " + taula + "(Herria, Probintzia) VALUES(?, ?)";
        try (PreparedStatement pstmt = konektatu().prepareStatement(sqlInsert)) {
            pstmt.setString(1, herria.getHerriIzena());
            pstmt.setString(2, herria.getProbintzia());
            pstmt.executeUpdate();
            System.out.println(herria + " ondo txertatu da.");
            logenErregistroa(user, "Datu baseko herriak taulan, herri berri bat txertatu.");
        } catch (SQLException e) {
            System.out.println("Errorea txertatzean: " + e.getMessage());
        }
    }

    public void erakutsiDatuak() {
        String sqlSelect = "SELECT * FROM " + taula;
        try (Statement stmt = konektatu().createStatement(); ResultSet rs = stmt.executeQuery(sqlSelect)) {
            System.out.println(taula + " taulan dauden datuak:");
            while (rs.next()) {
                System.out.println(rs.getString("Herria") + " - " + rs.getString("Probintzia"));
                logenErregistroa(user, "Datu baseko herriak taulako, herri eta probintzien izenak bistaratu.");
            }
        } catch (SQLException e) {
            System.out.println("Errorea datuak erakustean: " + e.getMessage());
        }
    }

    public void ezabatu(Herria herria) {
        if (!herriaBadago(herria)) {
            System.out.println(herria + " ez da existitzen datu-basean.");
            return;
        }
        String sqlDelete = "DELETE FROM " + taula + " WHERE Herria = ? AND Probintzia = ?";
        try (PreparedStatement pstmt = konektatu().prepareStatement(sqlDelete)) {
            pstmt.setString(1, herria.getHerriIzena());
            pstmt.setString(2, herria.getProbintzia());
            pstmt.executeUpdate();
            System.out.println(herria + " ondo ezabatu da.");
            logenErregistroa(user, "Datu baseko herriak taulako, herri bat ezabatu.");
        } catch (SQLException e) {
            System.out.println("Errorea ezabatzean: " + e.getMessage());
        }
    }

    public String getProbintzia(String herria) {
        String probintzia = null;
        String sqlSelect = "SELECT Probintzia FROM " + taula + " WHERE Herria = ?";
        
        try (PreparedStatement pstmt = konektatu().prepareStatement(sqlSelect)) {
            pstmt.setString(1, herria);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    probintzia = rs.getString("Probintzia");
                    logenErregistroa(user, "Datu baseko herriak taulako, herri baten probintzia izenak eskuratu.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Errorea datuak eskuratzean: " + e.getMessage());
        }
        
        return probintzia;
    }

    public List<String> getProbintziaBatekoHerriak(String probintzia) {
        List<String> herriak = new ArrayList<>();
        String sqlSelect = "SELECT Herria FROM " + taula + " WHERE Probintzia = ?";

        try (PreparedStatement pstmt = konektatu().prepareStatement(sqlSelect)) {
            pstmt.setString(1, probintzia);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    herriak.add(rs.getString("Herria"));
                }
                logenErregistroa(user, "Datu baseko herriak taulako, probintzia bateko, herri gustien izenak eskuratu.");
            }
        } catch (SQLException e) {
            System.out.println("Errorea datuak eskuratzean: " + e.getMessage());
        }
        return herriak;
    }

    public List<String> getHerriIzenak() {
        List<String> herriak = new ArrayList<>();
        String sqlSelect = "SELECT Herria FROM " + taula;
        
        try (Statement stmt = konektatu().createStatement(); ResultSet rs = stmt.executeQuery(sqlSelect)) {
            while (rs.next()) {
                herriak.add(rs.getString("Herria"));
            }
            logenErregistroa(user, "Datu baseko herriak taulako, herri gustien izenak eskuratu.");
        } catch (SQLException e) {
            System.out.println("Errorea datuak eskuratzean: " + e.getMessage());
        }
        
        return herriak;
    }

    private void logenErregistroa(String user, String action) {
        String sqlLog = "INSERT INTO Logs (user, action) VALUES (?, ?)";
        try (PreparedStatement pstmt = konektatu().prepareStatement(sqlLog)) {
            pstmt.setString(1, user);  
            pstmt.setString(2, action);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al registrar en los logs: " + e.getMessage());
        }
    }

    public List<String> logakEskuratu() {
        List<String> logs = new ArrayList<>();
        String sqlSelectLogs = "SELECT data, user, action FROM Logs";
        
        try (PreparedStatement pstmt = konektatu().prepareStatement(sqlSelectLogs)) {
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                String data = rs.getString("data");
                String user = rs.getString("user");
                String action = rs.getString("action");
                
                String logEntry = "Data: " + data + " | Erabiltzailea: " + user + " | Ekintza: " + action;
                logs.add(logEntry);
            }
            
            logenErregistroa(user, "Datu baseko logs taulako erregistroak eskuratu.");
            
        } catch (SQLException e) {
            System.out.println("Error al obtener los registros de los logs: " + e.getMessage());
        }
        
        return logs;
    }

    public void finalize() {
        closeConnection();
    }
}