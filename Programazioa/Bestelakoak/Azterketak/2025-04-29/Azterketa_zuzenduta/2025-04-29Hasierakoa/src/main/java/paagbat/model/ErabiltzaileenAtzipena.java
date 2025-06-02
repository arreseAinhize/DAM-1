package paagbat.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import paagbat.model.base.Erabiltzailea;
import paagbat.model.base.Saioa;
/**
 * Datu-basearekin egin beharreko eragiketak definituko ditugu klase honetan.
 */
public class ErabiltzaileenAtzipena {

    private String server;
    private String db;
    private String taula;

    String user;
    String pass;

    public ErabiltzaileenAtzipena(String server, String user, String pass, String db, String taula) {
        this.server = server;
        this.user = user;
        this.pass = pass;
        this.db = db;
        this.taula = taula;
    }

    /**
     * Datu-basearekin konektatzen da.
     * 
     * @return Connection objektua
     */
    public Connection konektatu() {
        String url = "jdbc:mariadb://" + server + "/" + db;
        Connection conn = null;
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

    /**
     * Datu-basean parametro bezala jasotako erabiltzailea txertatzen du.
     * 
     * @param erabiltzailea
     * @return 0 ondo txertatuz gero, -1 errorea gertatuz gero
     */
    public int txertatu(Erabiltzailea erabiltzailea) {
        Connection conn = konektatu(); // Datu basera konektatu
        String sql = "INSERT INTO " + taula + " VALUES ('" + erabiltzailea.getKontua() + "', '" + erabiltzailea.getIzena() + "', '" + erabiltzailea.getAbizena() + "', " + erabiltzailea.getAdina() + ", '" + erabiltzailea.getRola() + ", '"+ erabiltzailea.getPasahitza() +"')";
        try {
            conn.createStatement().executeUpdate(sql); // Konexioaren bitarte sql a executatu datua gehitzeko
            return 0; // Ondo joan bada 0
        } catch (SQLException e) {
            return -1; // Errorea gertatuz -1
        }
    }

    public Erabiltzailea logingErabiltzailea(String kontua, String Pasahitza){
        Connection conn = konektatu(); // Datu basera konektatu
        String sql = "SELECT * FROM " + taula + " WHERE kontua = '" + kontua + "' AND pasahitza = '" + Pasahitza + "'";
        try{
            ResultSet result = conn.createStatement().executeQuery(sql); // Konexioaren bitarte sql a executatu datua gehitzeko
            if(result.next()){ // Hurrengo lerroa badago
                return new Erabiltzailea( // Lerro bakoitza erabiltzailea objektua
                    result.getString("kontua"), 
                    result.getString("pasahitza")
                );
            } else {
                return null; // Ez badago erabiltzaile hori, null bueltatzen da
            }
        } catch (SQLException e) {
            return null; // Errorea gertatuz null bueltatzen da
        }
    }

    public void loginLogs(String kontua){
        Connection conn = konektatu();
        String sql = "INSERT INTO logs (kontua, SarreraData) VALUES ('" + kontua + "', NOW())";
        try {
            conn.createStatement().executeUpdate(sql); // Konexioaren bitarte sql a executatu datua gehitzeko
        } catch (SQLException e) {
            System.out.println("Errorea gertatu da loga sartzean: " + e.getMessage());
        }
    }

    public void logoutLogs(String kontua){
        Connection conn = konektatu();
        String sql = "Update logs SET IrteeraData = NOW() WHERE kontua = '" + kontua + "' AND IrteeraData IS NULL";
        try {
            conn.createStatement().executeUpdate(sql); // Konexioaren bitarte sql a executatu datua gehitzeko
        } catch (SQLException e) {
            System.out.println("Errorea gertatu da loga sartzean: " + e.getMessage());
        }
    }
    /**
     * Datu-basea irakurri eta erabiltzaileen zerrenda bueltatzen du.
     * 
     * @return Erabiltzaileen zerrenda edo null ezin izan bada erabiltzailerik
     *         irakurri.
     */
    public List<Erabiltzailea> getErabiltzaileak() {
        Connection conn = konektatu(); // Datu basera konektatu
        String sql = "SELECT * FROM " + taula;
        try {
            ResultSet result = conn.createStatement().executeQuery(sql); // Konexioaren bitarte sql a executatu datua gehitzeko

            List<Erabiltzailea> erabiltzaileList = new ArrayList<>();

            while (result.next()) { // Next bakoitza hurrengo lerroa
                erabiltzaileList.add(new Erabiltzailea( // Lerro bakoitza erabiltzailea objektua
                    result.getString("kontua"), 
                    result.getString("izena"), 
                    result.getString("abizena"), 
                    result.getInt("adina"), 
                    result.getString("rola"),
                    result.getString("pasahitza")
                ));
            }
            return erabiltzaileList; // Sortutako erabiltzaileen lista bueltatu
        } catch (SQLException e) {
            return null; // Errorea gertatuz null bueltatzen da
        }
    }

    /**
     * Datu-basetik rol jakin bateko erabiltzaileak irakurri eta bueltatzen ditu.
     * 
     * @return Erabiltzaileen zerrenda edo null ezin izan bada erabiltzailerik
     *         irakurri.
     */
    public List<Erabiltzailea> getRolBatekoErabiltzaileak(String rola) {
        Connection conn = konektatu(); // Datu basera konektatu
        String sql = "SELECT * FROM " + taula + " WHERE rola = '" + rola + "'";
        try {
            ResultSet result = conn.createStatement().executeQuery(sql); // Konexioaren bitarte sql a executatu datua gehitzeko

            List<Erabiltzailea> erabiltzaileList = new ArrayList<>();

            while (result.next()) { // Next bakoitza hurrengo lerroa
                erabiltzaileList.add(new Erabiltzailea( // Lerro bakoitza erabiltzailea objektua
                    result.getString("kontua"), 
                    result.getString("izena"), 
                    result.getString("abizena"), 
                    result.getInt("adina"), 
                    result.getString("rola"),
                    result.getString("pasahitza")
                ));
            }
            return erabiltzaileList; // Sortutako erabiltzaileen lista bueltatu
        } catch (SQLException e) {
            return null; // Errorea gertatuz null bueltatzen da
        }
    }

    public boolean pasahitzKonprobatu(String kontua, String pasahitza) {
        Connection conn = konektatu(); // Datu basera konektatu
        String sql = "SELECT * FROM " + taula + " WHERE kontua = '" + kontua + "' AND pasahitza = '" + pasahitza + "'";
        try {
            ResultSet result = conn.createStatement().executeQuery(sql); // Konexioaren bitarte sql a executatu datua gehitzeko
            return result.next(); // Hurrengo lerroa badago, beraz pasahitza zuzena da
        } catch (SQLException e) {
            return false; // Errorea gertatuz false bueltatzen da
        }
    }

    public boolean pasahitzaAldatu(String kontua, String pasahitzZarra, String pasahitzBerria) {
        Connection conn = konektatu(); // Datu basera konektatu
        String sql = "UPDATE " + taula + " SET pasahitza = '" + pasahitzBerria + "' WHERE kontua = '" + kontua + "' AND pasahitza = '" + pasahitzZarra + "'";
        try {
            conn.createStatement().executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            return false; // Errorea gertatuz false bueltatzen da
        }
    }

    public List<Saioa> getSaioak(){
        Connection conn = konektatu(); // Datu basera konektatu
        String sql = "SELECT * FROM logs"; // Logs taulako datuak irakurri
        try {
            ResultSet result = conn.createStatement().executeQuery(sql); // Konexioaren bitarte sql a executatu datua gehitzeko

            List<Saioa> saioaList = new ArrayList<>();

            while (result.next()) { // Next bakoitza hurrengo lerroa
                String kontua = result.getString("kontua");
                LocalDateTime sarreraData = null;
                LocalDateTime irteeraData = null;

                if (result.getTimestamp("SarreraData") != null) {
                    sarreraData = result.getTimestamp("SarreraData").toLocalDateTime();
                }
                if (result.getTimestamp("IrteeraData") != null) {
                    irteeraData = result.getTimestamp("IrteeraData").toLocalDateTime();
                }

                saioaList.add(new Saioa(
                    kontua,
                    sarreraData,
                    irteeraData
                ));
            }
            return saioaList; // Sortutako erabiltzaileen lista bueltatu
        } catch (SQLException e) {
            return null; // Errorea gertatuz null bueltatzen da
        }
    }

    public List<Saioa> getRolBatekoSaioak(String rola){
        Connection conn = konektatu(); // Datu basera konektatu
        String sql = "SELECT * FROM logs WHERE kontua IN (SELECT kontua FROM " + taula + " WHERE rola = '" + rola + "')"; // Logs taulako datuak irakurri
        try {
            ResultSet result = conn.createStatement().executeQuery(sql); // Konexioaren bitarte sql a executatu datua gehitzeko

            List<Saioa> saioaList = new ArrayList<>();

            while (result.next()) { // Next bakoitza hurrengo lerroa
                String kontua = result.getString("kontua");
                LocalDateTime sarreraData = null;
                LocalDateTime irteeraData = null;

                if (result.getTimestamp("SarreraData") != null) {
                    sarreraData = result.getTimestamp("SarreraData").toLocalDateTime();
                }
                if (result.getTimestamp("IrteeraData") != null) {
                    irteeraData = result.getTimestamp("IrteeraData").toLocalDateTime();
                }

                saioaList.add(new Saioa(
                    kontua,
                    sarreraData,
                    irteeraData
                ));
            }
            return saioaList; // Sortutako erabiltzaileen lista bueltatu
        } catch (SQLException e) {
            return null; // Errorea gertatuz null bueltatzen da
        }
    }

    public int getErabiltzaileKopurua() {
        Connection conn = konektatu();
        String sql = "SELECT COUNT(*) FROM Erabiltzaileak";
        try {
            ResultSet result = conn.createStatement().executeQuery(sql);
            if (result.next()) {
                return result.getInt(1);
            }
        } catch (SQLException e) {
            return 0;
        }
        return 0;
    }
    
    public List<String> getKontuak() {
        List<String> kontuak = new ArrayList<>();
        Connection conn = konektatu();
        String sql = "SELECT kontua FROM Erabiltzaileak ORDER BY kontua";
        try {
            ResultSet result = conn.createStatement().executeQuery(sql);
            while (result.next()) {
                kontuak.add(result.getString("kontua"));
            }
        } catch (SQLException e) {
            // Manejo de error
        }
        return kontuak;
    }

    public List<Saioa> getErabiltzaileBakoitzarenSaioak(String kontua) {
        Connection conn = konektatu();
        String sql = "SELECT * FROM logs WHERE kontua = '" + kontua + "'";       
        try {
            ResultSet result = conn.createStatement().executeQuery(sql); // Konexioaren bitarte sql a executatu datua gehitzeko

            List<Saioa> saioaList = new ArrayList<>();

            while (result.next()) { // Next bakoitza hurrengo lerroa
                String kontuaResult = result.getString("kontua");
                LocalDateTime sarreraData = null;
                LocalDateTime irteeraData = null;

                if (result.getTimestamp("SarreraData") != null) {
                    sarreraData = result.getTimestamp("SarreraData").toLocalDateTime();
                }
                if (result.getTimestamp("IrteeraData") != null) {
                    irteeraData = result.getTimestamp("IrteeraData").toLocalDateTime();
                }

                saioaList.add(new Saioa(
                    kontuaResult,
                    sarreraData,
                    irteeraData
                ));
            }
            return saioaList; // Sortutako erabiltzaileen lista bueltatu
        } catch (SQLException e) {
            return null; // Errorea gertatuz null bueltatzen da
        }
    }
}