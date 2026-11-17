import java.math.BigDecimal;
import java.time.Year;

public class Vehicle extends Asset {

    private String makeModel;
    private int year;
    private int odometer;

    // Constructor
    public Vehicle(String description, String dateAcquired, BigDecimal originalCost,
                   String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    // Getters
    public String getMakeModel() {
        return makeModel;
    }

    public int getYear() {
        return year;
    }

    public int getOdometer() {
        return odometer;
    }

    // Setters
    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    // Override getValue()
    @Override
    public BigDecimal getValue() {

        int age = Year.now().getValue() - year;
        BigDecimal value;

        if (age > 10) {
            value = new BigDecimal("1000.00");
        } else {
            double depreciationRate;

            if (age <= 3) {
                depreciationRate = 0.03 * age;
            } else if (age <= 6) {
                depreciationRate = 0.06 * age;
            } else {
                depreciationRate = 0.08 * age;
            }

            value = getOriginalCost()
                    .multiply(BigDecimal.valueOf(1.0 - depreciationRate));
        }

        // Reduce by 25% if over 100,000 miles
        // unless Honda or Toyota
        if (odometer > 100000
                && !makeModel.toLowerCase().contains("honda")
                && !makeModel.toLowerCase().contains("toyota")) {

            value = value.multiply(new BigDecimal("0.75"));
        }

        return value;
    }
}