package paagbat.model.enums;

public enum ErabiltzaileMota {
    IKASLEA("ikaslea"),
    IRAKASLEA("irakaslea");

    private final String mota;

    ErabiltzaileMota(String mota) {
        this.mota = mota;
    }

    @Override
    public String toString() {
        return mota;
    }
}
