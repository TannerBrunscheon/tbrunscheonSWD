/**
 * Created by tbrunscheon on 9/19/16.
 */
public class Employee {
    protected final String firstName;
    protected final String lastName;
    protected final String socialSecurityNumber;
    protected double grossSales; // gross weekly sales
    protected double commissionRate; // commission percentage

    public Employee(double commissionRate, double grossSales, String socialSecurityNumber, String lastName, String firstName) {
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
        this.socialSecurityNumber = socialSecurityNumber;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    // return first name
    public String getFirstName() {
        return firstName;
    }

    // return last name
    public String getLastName() {
        return lastName;
    }

    // return social security number
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    // return gross sales amount
    public double getGrossSales() {
        return grossSales;
    }

    // set gross sales amount
    public void setGrossSales(double grossSales) {
        if (grossSales < 0.0)
            throw new IllegalArgumentException(
                    "Gross sales must be >= 0.0");

        this.grossSales = grossSales;
    }

    // return commission rate
    public double getCommissionRate() {
        return commissionRate;
    }

    // set commission rate
    public void setCommissionRate(double commissionRate) {
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException(
                    "Commission rate must be > 0.0 and < 1.0");

        this.commissionRate = commissionRate;
    }

    // return String representation of CommissionEmployee object
    @Override // indicates that this method overrides a superclass method
    public String toString() {
        return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f",
                "commission employee", firstName, lastName,
                "social security number", socialSecurityNumber,
                "gross sales", grossSales,
                "commission rate", commissionRate);
    }

    // calculate earnings
    public double earnings() {
        return getCommissionRate() * getGrossSales();
    }
}
