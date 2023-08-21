package sg.edu.rp.c346.id22005564.demoweather;

public class Carpark {
    private String carparkNumber;
    private String lotsAvailable;

    public Carpark(String carparkNumber, String lotsAvailable) {
        this.carparkNumber = carparkNumber;
        this.lotsAvailable = lotsAvailable;
    }

    public String getCarparkNumber() {
        return carparkNumber;
    }

    public String getLotsAvailable() {
        return lotsAvailable;
    }
}


