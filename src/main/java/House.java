import java.math.BigDecimal;

public class House extends Asset {

    private String address;
    private int condition; // 1=Excellent, 2=Good, 3=Fair, 4=Poor
    private int squareFoot;
    private int lotSize;

    // Constructor
    public House(String description, String dateAcquired, BigDecimal originalCost,
                 String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    // Getters
    public String getAddress() {
        return address;
    }

    public int getCondition() {
        return condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    // Setters
    public void setAddress(String address) {
        this.address = address;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    // Override getValue()
    @Override
    public BigDecimal getValue() {
        BigDecimal valuePerSquareFoot;

        switch (condition) {
            case 1:
                valuePerSquareFoot = new BigDecimal("180.00");
                break;
            case 2:
                valuePerSquareFoot = new BigDecimal("130.00");
                break;
            case 3:
                valuePerSquareFoot = new BigDecimal("90.00");
                break;
            case 4:
                valuePerSquareFoot = new BigDecimal("80.00");
                break;
            default:
                valuePerSquareFoot = BigDecimal.ZERO;
        }

        BigDecimal houseValue =
                valuePerSquareFoot.multiply(BigDecimal.valueOf(squareFoot));

        BigDecimal lotValue =
                new BigDecimal("0.25").multiply(BigDecimal.valueOf(lotSize));

        return houseValue.add(lotValue);
    }
}
