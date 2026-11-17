import java.math.BigDecimal;

public class Asset {

    private String description;
    private String dateAcquired;
    private BigDecimal originalCost;

    // Constructor
    public Asset(String description, String dateAcquired, BigDecimal originalCost) {
        this.description = description;
        this.dateAcquired = dateAcquired;
        this.originalCost = originalCost;
    }

    // Getters
    public String getDescription() {
        return description;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public BigDecimal getOriginalCost() {
        return originalCost;
    }

    // Setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public void setOriginalCost(BigDecimal originalCost) {
        this.originalCost = originalCost;
    }

    // Returns the current value of the asset
    public BigDecimal getValue() {
        return originalCost;
    }
}


