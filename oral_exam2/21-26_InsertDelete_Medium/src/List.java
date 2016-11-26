// Fig. 21.3: List.java
// ListNode and List class declarations.

/**
 * Class to represent one node in a list. Figure 21.3 in the book.
  */

class ListNode<T> {
    // package access members; List can access these directly
    T data; // data for this node
    ListNode<T> nextNode; // reference to the next node in the list

    // constructor creates a ListNode that refers to object
    ListNode(T object) {
        this(object, null);
    }

    // constructor creates ListNode that refers to the specified
    // object and to the next ListNode
    ListNode(T object, ListNode<T> node) {
        data = object;
        nextNode = node;
    }

    // return reference to data in node
    T getData() {
        return data;
    }

    // return reference to next node in list
    ListNode<T> getNext() {
        return nextNode;
    }
} // end class ListNode<T>

/**
 * Class List Defintion
 */
public class List<T> {
    private ListNode<T> firstNode;
    private ListNode<T> lastNode;
    private String name; // string like "list" used in printing

    /**
     * Constuctor creates empty list with list as its name  Figure 21.3 in the book.
     */
    public List() {
        this("list");
    }

    /**
     * Constructor creates empty list with name
     * @param listName Name of the list
     */
    public List(String listName) {
        name = listName;
        firstNode = lastNode = null;
    }

    /**
     * Inset item at front  Figure 21.3 in the book.
     * @param insertItem Data to insert
     */
    public void insertAtFront(T insertItem) {
        if (isEmpty()) // firstNode and lastNode refer to same object
            firstNode = lastNode = new ListNode<T>(insertItem);
        else // firstNode refers to new node
            firstNode = new ListNode<T>(insertItem, firstNode);
    }

    /**
     * Insert item at back  Figure 21.3 in the book.
     * @param insertItem Data to insert
     */
    public void insertAtBack(T insertItem) {
        if (isEmpty()) // firstNode and lastNode refer to same object
            firstNode = lastNode = new ListNode<T>(insertItem);
        else // lastNode's nextNode refers to new node
            lastNode = lastNode.nextNode = new ListNode<T>(insertItem);
    }

    /**
     * Remove first node from list  Figure 21.3 in the book.
     * @return Data from node
     * @throws EmptyListException If list is empty
     */
    public T removeFromFront() throws EmptyListException {
        if (isEmpty()) // throw exception if List is empty
            throw new EmptyListException(name);

        T removedItem = firstNode.data; // retrieve data being removed

        // update references firstNode and lastNode
        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else
            firstNode = firstNode.nextNode;

        return removedItem; // return removed node data
    } // end method removeFromFront

    /**
     * Remove last node from list  Figure 21.3 in the book.
     * @return Data from list
     * @throws EmptyListException If list is empty
     */
    public T removeFromBack() throws EmptyListException {
        if (isEmpty()) // throw exception if List is empty
            throw new EmptyListException(name);

        T removedItem = lastNode.data; // retrieve data being removed

        // update references firstNode and lastNode
        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else // locate new last node
        {
            ListNode<T> current = firstNode;

            // loop while current node does not refer to lastNode
            while (current.nextNode != lastNode)
                current = current.nextNode;

            lastNode = current; // current is new lastNode
            current.nextNode = null;
        }

        return removedItem; // return removed node data
    }

    /**
     * Remove node from position given
     * @param position Position of the node starting at 0 that is to be removed
     * @return Data of the node
     */
    public T removeFromPosition(int position){
        if (isEmpty())
            throw new EmptyListException(name);

        ListNode<T> current = firstNode;
        if (position == 0){
            return removeFromFront();
        }
        else {

            for (int i = 0; i < position - 1; i++) {
                current = current.nextNode;
            }
            if (current == lastNode) {
                return removeFromBack();
            }
            else {
                T data = current.nextNode.getData();
                current.nextNode = current.nextNode.nextNode;
                return data;
            }
        }

    }

    /**
     * Add a node at a specific position.
     * @param position Position of the node to be added to start at 0
     * @param data Data to be added
     */
    public void addToPosition(int position,T data){
        //Check if array is empty
        if (isEmpty())
            throw new EmptyListException(name);


        ListNode<T> current = firstNode;
        //If the node we want is added at front call insert at front
        if (position ==0){
            insertAtFront(data);
        }
        else {

            position =position-1;
            //Cycle to the node we want to add
            try {
                for (int i = 0; i < position; i++) {
                    current = current.nextNode;
                }
                //If its the last node call insert at back
                if (current == lastNode) {
                    insertAtBack(data);
                } else {
                    //Make a new node with the data and set the current node next node to the new node. Set the old next
                    //node to the new nodes next node
                    ListNode<T> temp = current.nextNode;
                    current.nextNode = new ListNode<T>(data, temp);
                }
            }
            catch (NullPointerException){
                new EmptyListException();
            }
        }

    }

    /**
     * Determine if list is empty  Figure 21.3 in the book.
     * @return True if empty or False if not
     */
    public boolean isEmpty() {
        return firstNode == null; // return true if list is empty
    }

    /**
     * Output list contents  Figure 21.3 in the book.
     */
    public void print() {
        if (isEmpty()) {
            System.out.printf("Empty %s%n", name);
            return;
        }

        System.out.printf("The %s is: ", name);
        ListNode<T> current = firstNode;

        // while not at end of list, output current node's data
        while (current != null) {
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }

        System.out.println();
    }
} // end class List<T>

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
