import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.SocketHandler;

/**
 * Created by Tanner on 11/3/2016.
 */
public class FileRetrieverClient extends JFrame {
    /**
     * User input feild.
     */
    private final JTextField userIn; // enters information from user
    /**
     * Display area
     */
    private final JTextArea displayArea; // display information to user
    /**
     * Input stream
     */
    private ObjectInputStream input;
    /**
     * Output stream
     */
    private ObjectOutputStream output;
    /**
     * Server address
     */
    private final String server;
    /**
     * Message from the server
     */
    private String messageFrom;
    /**
     * Socket to connect to server peer to peer
     */
    private Socket socket;

    /**
     * Constructor to create the client
     * @param ip Ip address of the server.
     */
    public FileRetrieverClient(String ip) {
        super("Client");

        server = ip; // set server to which this client connects

        userIn = new JTextField(); // create userInputfield
        userIn.setEditable(true);
        userIn.addActionListener(
                new ActionListener() {
                    // send message to server
                    public void actionPerformed(ActionEvent event) {
                        send(userIn.getText());
                        userIn.setText("");
                    }
                }
        );

        add(userIn,BorderLayout.NORTH);

        displayArea = new JTextArea(); // create displayArea
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea),BorderLayout.CENTER);//Add the components

        setSize(300, 150); // set size of window
        setVisible(true); // show window

    }

    /**
     * Runs the client by waiting for user input and sending and receiving the data from the server
     */

    public void runClient() {
        try
        {
            //Connect to server
            socket = new Socket(InetAddress.getByName(server), 23555);
            output = new ObjectOutputStream(socket.getOutputStream());
            output.flush();
            input = new ObjectInputStream(socket.getInputStream());
            do
            {
                setTextFieldEditable(); //Set text editable using mulithreading
                try // read message from server and write it
                {
                    messageFrom = (String) input.readObject(); // read new message
                    write(messageFrom);

                }
                catch (ClassNotFoundException classNotFoundException) {
                    write("\nError from server");
                }
            }while (!messageFrom.equals("SERVER>> TERMINATE"));//Check for termination
        } // end try
        catch (IOException ioException) {
            //If connection not found quit.
            ioException.printStackTrace();
            write("\nConnection not found. Quitting.....");
            System.exit(-1);
        }
        finally {
            try {
                output.close(); // close output stream
                input.close(); // close input stream
                socket.close(); // close socket
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    /**
     * Write a given string to the screen.
     * @param string Thing to write
     */
    private void write(String string){
        SwingUtilities.invokeLater(//Write to display
                new Runnable() {
                    public void run()
                    {
                        displayArea.append(string);
                    }
                }
        );
    }

    /**
     * Sends a given string over the network
     * @param string String to send
     */
    private void send(String string){
        try
        {
            write("\nCLIENT>> "+string);
            output.writeObject(string);//Write data for flushing
            output.flush(); // flush data to output
        } catch (IOException ioException) {
            write("\nError writing object");
        }
    }

    /**
     * Sets the text field editable
     */
    private void setTextFieldEditable() {
        SwingUtilities.invokeLater(//Multithreading
                new Runnable() {
                    public void run()
                    {
                        userIn.setEditable(true);
                    }
                }
        );
    }


}
