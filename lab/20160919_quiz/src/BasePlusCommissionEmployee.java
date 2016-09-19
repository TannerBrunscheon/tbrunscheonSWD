// Fig. 9.4: CommissionEmployee.java
// CommissionEmployee class represents an employee paid a 
// percentage of gross sales.
public class BasePlusCommissionEmployee extends Employee {
    private double basePay;
    // five-argument constructor
    public BasePlusCommissionEmployee(String firstName, String lastName,
                                      String socialSecurityNumber, double grossSales,
                                      double commissionRate, double basePay){
        super(commissionRate, grossSales, socialSecurityNumber, lastName, firstName);
        // implicit call to Object's default constructor occurs here

        this.basePay =basePay;

        if (basePay < 0){
            throw new IllegalArgumentException(
                    "Base pay must be > 0"
            );
        }

        // if grossSales is invalid throw exception
        if (grossSales < 0.0)
            throw new IllegalArgumentException(
                    "Gross sales must be >= 0.0");

        // if commissionRate is invalid throw exception
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException(
                    "Commission rate must be > 0.0 and < 1.0");

    } // end constructor

    @Override
    // calculate earnings
    public double earnings() {
        return super.earnings()+basePay;
    }

    @Override
    public String toString() {
        String employeeInfo = super.toString();
        return String.format("%s\n%s: %s\n", employeeInfo,"basePay rate", basePay);
    }
}
// end class CommissionEmployee
/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
