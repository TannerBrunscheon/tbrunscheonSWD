// Fig. 21.4: EmptyListException.java
// Class EmptyListException declaration.

/**
 * This class creates a new exception the Empty list exception. Can be found as Figure 21.4 in the text book.
 */
public class EmptyListException extends RuntimeException {
    // constructor

    /**
     * Constructor with no arguments
     */
    public EmptyListException() {
        this("List"); // call other EmptyListException constructor
    }

    /**
     * Constructor
     * @param name Name of the list
     */
    public EmptyListException(String name) {
        super(name + " is empty"); // call superclass constructor
    }
} // end class EmptyListException

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
