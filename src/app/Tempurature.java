package app;


public class Tempurature {
    private int temp;
    private int modif;

    public Tempurature(int modif, int temp) {
        this.temp = temp;
        this.modif = modif;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getModif() {
        return modif;
    }

    public void setModif(int modif) {
        this.modif = modif;
    }
}
