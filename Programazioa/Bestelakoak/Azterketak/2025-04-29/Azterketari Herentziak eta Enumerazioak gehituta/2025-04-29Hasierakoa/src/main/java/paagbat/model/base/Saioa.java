package paagbat.model.base;
import java.time.LocalDateTime;

public class Saioa{

    private String kontua;
    private LocalDateTime sarreraData;
    private LocalDateTime irteeraData;


    public Saioa(String kontua){
        this.kontua = kontua;
    }

    public Saioa(String kontua, LocalDateTime sarreraData, LocalDateTime irteeraData) {
        this.kontua = kontua;
        this.sarreraData = sarreraData;
        this.irteeraData = irteeraData;
    }

    public String getKontua() {
        return kontua;
    }
    public LocalDateTime getSarreraData() {
        return sarreraData;
    }
    public LocalDateTime getIrteeraData() {
        return irteeraData;
    }
    public void setKontua(String kontua) {
        this.kontua = kontua;
    }
    public void setSarreraData(LocalDateTime sarreraData) {
        this.sarreraData = sarreraData;
    }
    public void setIrteeraData(LocalDateTime irteeraData) {
        this.irteeraData = irteeraData;
    }
    @Override
    public String toString() {
        return kontua + ", " + sarreraData + ", " + irteeraData;
    }
}