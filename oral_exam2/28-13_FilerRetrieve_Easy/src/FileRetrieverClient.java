import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.SocketHandler;

/**
 * Created by Tanner on 11/3/2016.
 */
public class FileRetrieverClient extends JFrame {
    private JTextField userIn; // enters information from user
    private JTextArea displayArea; // display information to user
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private String server;
    private String messageFrom;
    private Socket socket;

    public FileRetrieverClient(String host) throws HeadlessException {
        super("Client");

        server = host; // set server to which this client connects

        userIn = new JTextField(); // create enterField
        userIn.setEditable(true);
        userIn.addActionListener(
                new ActionListener() {
                    // send message to server
                    public void actionPerformed(ActionEvent event) {
                        send(userIn.getText());
                        userIn.setText("");
                    } // end method actionPerformed
                } // end anonymous inner class
        ); // end call to addActionListener

        add(userIn,BorderLayout.NORTH);

        displayArea = new JTextArea(); // create displayArea
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea),BorderLayout.CENTER);

        setSize(300, 150); // set size of window
        setVisible(true); // show window

    }

    public void runClient() {
        try // connect to server, get streams, process connection
        {
            socket = new Socket(InetAddress.getByName(server), 23555);
            output = new ObjectOutputStream(socket.getOutputStream());
            output.flush();
            input = new ObjectInputStream(socket.getInputStream());
            write("Connection Sucessful");
            do // process messages sent from server
            {
                try // read message and display it
                {
                    messageFrom = (String) input.readObject(); // read new message
                    write("\n" + server); // display message
                } // end try
                catch (ClassNotFoundException classNotFoundException) {
                    write("\nUnknown object received");
                } // end catch
            }while (!messageFrom.equals("SERVER>>> TERMINATE"));
        } // end try
        catch (EOFException eofException) {
            write("\nClient terminated connection");
        } // end catch
        catch (IOException ioException) {
            ioException.printStackTrace();
        } // end catch
        finally {
            try {
                output.close(); // close output stream
                input.close(); // close input stream
                socket.close(); // close socket
            } // end try
            catch (IOException ioException) {
                ioException.printStackTrace();
            } // close connection
        } // end finally
    }
    private void write(String string){
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // updates displayArea
                    {
                        displayArea.append(string);
                    }
                }
        );
    }
    private void send(String string){
        try // send object to server
        {
            output.writeObject(string);
            output.flush(); // flush data to output
        } catch (IOException ioException) {
            displayArea.append("\nError writing object");
        }
    }




}
