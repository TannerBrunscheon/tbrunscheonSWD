import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;


/**
 * Created by Tanner on 11/3/2016.
 */
public class FileRetrieverServer extends JFrame{
    /**
     * Server socket to connect to many clients
     */
    private ServerSocket socket;
    /**
     * Regular socket to send stuff to clients
     */
    private Socket connection;
    /**
     * Display for client requests
     */
    private final JTextArea displayArea = new JTextArea();
    /**
     * Output stream
     */
    private ObjectOutputStream output;
    /**
     * Input stream
     */
    private ObjectInputStream input;
    /**
     * File request
     */
    private String fileToFind;
    /**
     * Scanner tp read file
     */
    private Scanner in;

    /**
     * Constructor to create the server gui
     */

    public FileRetrieverServer() {
        super("Server");
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea));

        setSize(300, 150); // set size of window
        setVisible(true); // show window
        runServer();
    }

    /**
     * Runs the server by waiting for data from the client and sending appopriate responses back depending on the
     * message
     */
    private void runServer(){
        try
        {
            socket = new ServerSocket(23555, 100);
            while (true) {
                try {
                    //Connect to client
                    connection = socket.accept();
                    output = new ObjectOutputStream(connection.getOutputStream());
                    output.flush();//Send anything in buffer
                    input = new ObjectInputStream(connection.getInputStream());
                    write("Connection Sucessful");
                    send("Connection Sucessful");
                    do {
                        try // read message and display it
                        {
                            fileToFind = (String) input.readObject(); // read new message
                            write("\nFile to find recieved:  " + fileToFind); // display message
                            findFile(fileToFind);
                        } catch (ClassNotFoundException classNotFoundException) {
                            write("\nNot a string");
                        }
                    }while (!fileToFind.equals("TERMINATE"));
                } catch (EOFException eofException) {
                } finally {
                    try {
                        send("TERMINATE");
                        output.close(); // close output stream
                        input.close(); // close input stream
                        connection.close(); // close socket
                    }
                    catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    /**
     * Sends a given string over the network
     * @param str String to send
     */
    private void send(String str){
        try
        {
            System.out.println(str);
            output.writeObject("\n SERVER>>" + str);//Write object for flushing
            output.flush(); // flush output to client
        } catch (IOException ioException) {
        }
    }
    /**
     * Write a given string to the screen.
     * @param string Thing to write
     */
    private void write(String string){
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run()
                    {
                        displayArea.append(string);
                    }
                }
        );
    }

    /**
     * Looks for the file given in the 28-13_FilerRetrieve_Easy and sends its content to the client
     * @param fileToFind File that needs to be found.
     */
    private void findFile(String fileToFind){
        StringBuilder contents = new StringBuilder("");
       try{
           in = new Scanner(Paths.get("oral_exam2/28-13_FilerRetrieve_Easy/"+fileToFind));
           while(in.hasNext()){
               contents.append(in.next()).append(" ");
           }
           write("\nSucessfully wrote file");
           send(contents.toString());
       }
       catch (IOException i)
       {
           send("\nFile not Found");
           write("\nFile not Found");
       }
    }
}
