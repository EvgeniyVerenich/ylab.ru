import java.time.LocalDate;
import java.util.Date;

public class Bill {
    private double heating;
    private double hotWater;
    private double coldWater;

    private LocalDate date;

    public Bill(double heating, double hotWater, double coldWater, LocalDate date){
        this.heating = heating;
        this.hotWater = hotWater;
        this.coldWater = coldWater;
        this.date = date;
    }


    public double getHeating() {
        return heating;
    }

    public double getHotWater() {
        return hotWater;
    }

    public double getColdWater() {
        return coldWater;
    }

    @Override
    public String toString() {
        return "Bill "+"(" + date + ")" + " {heating: "+ heating+", hot water: " + hotWater +", cold water: " + coldWater + "}\n";
    }

    public LocalDate getDate() {
        return date;
    }
}
