package paagbat.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import paagbat.model.base.Herria;

public class HerrienAtzipenak {
    private String server;
    private String db;
    private String taula;
    private String user;
    private String pass;
    private Connection connection;
    public List<String> herrienZerrenda = new ArrayList<>();

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

    public boolean herriaBadago(Herria herria) {
        String sqlCheck = "SELECT COUNT(*) FROM " + taula + " WHERE Herria = ? AND Probintzia = ?";
        
        try (PreparedStatement pstmt = konektatu().prepareStatement(sqlCheck)) {
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

    public void txertatu(Herria herria) {
        String sqlInsert = "INSERT INTO " + taula + "(Herria, Probintzia) VALUES(?, ?)";
        try (PreparedStatement pstmt = konektatu().prepareStatement(sqlInsert)) {
            pstmt.setString(1, herria.getHerriIzena());
            pstmt.setString(2, herria.getProbintzia());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Errorea txertatzean: " + e.getMessage());
        }
    }

    public List<String> erakutsiDatuak() {
        herrienZerrenda.clear();
        String sqlSelect = "SELECT * FROM " + taula;
        try (Statement stmt = konektatu().createStatement(); ResultSet rs = stmt.executeQuery(sqlSelect)) {
            while (rs.next()) {
                String herria = rs.getString("Herria") + " (" + rs.getString("Probintzia") + ")";
                herrienZerrenda.add(herria);
            }
            return herrienZerrenda;
        } catch (SQLException e) {
            System.out.println("Errorea datuak erakustean: " + e.getMessage());
        }
        return herrienZerrenda;
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
                }
            }
        } catch (SQLException e) {
            System.out.println("Errorea datuak eskuratzean: " + e.getMessage());
        }
        
        return probintzia;
    }

    public List<String> getHerriIzenak() {
        List<String> herriak = new ArrayList<>();
        String sqlSelect = "SELECT Herria FROM " + taula;
        
        try (Statement stmt = konektatu().createStatement(); ResultSet rs = stmt.executeQuery(sqlSelect)) {
            while (rs.next()) {
                herriak.add(rs.getString("Herria"));
            }
        } catch (SQLException e) {
            System.out.println("Errorea datuak eskuratzean: " + e.getMessage());
        }
        
        return herriak;
    }

    public void aldatuHerria(String herriZaharra, Herria herriaBerria) {
        String sqlUpdate = "UPDATE " + taula + " SET Herria = ?, Probintzia = ? WHERE Herria = ?";
        try (PreparedStatement pstmt = konektatu().prepareStatement(sqlUpdate)) {
            pstmt.setString(1, herriaBerria.getHerriIzena());
            pstmt.setString(2, herriaBerria.getProbintzia());
            pstmt.setString(3, herriZaharra);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Errorea eguneratzean: " + e.getMessage());
        }
    }
    

    public void aldatuIzena(String herriZaharra, String izenBerria) {
        String sqlUpdate = "UPDATE " + taula + " SET Herria = ? WHERE Herria = ?";
        try (PreparedStatement pstmt = konektatu().prepareStatement(sqlUpdate)) {
            pstmt.setString(1, izenBerria);
            pstmt.setString(2, herriZaharra);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Errorea izena aldatzean: " + e.getMessage());
        }
    }
    

    public void aldatuProbintzia(String herriIzena, String probintziaBerria) {
        String sqlUpdate = "UPDATE " + taula + " SET Probintzia = ? WHERE Herria = ?";
        try (PreparedStatement pstmt = konektatu().prepareStatement(sqlUpdate)) {
            pstmt.setString(1, probintziaBerria);
            pstmt.setString(2, herriIzena);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Errorea probintzia aldatzean: " + e.getMessage());
        }
    }
    

    public void finalize() {
        closeConnection();
    }
}
