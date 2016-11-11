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
    private ServerSocket socket;
    private Socket connection;
    private final JTextArea displayArea = new JTextArea();
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String fileToFind;
    private Scanner in;

    public FileRetrieverServer() {
        super("Server");
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea));

        setSize(300, 150); // set size of window
        setVisible(true); // show window
        runServer();
    }

    private void runServer(){
        try // set up server to receive connections; process connections
        {
            socket = new ServerSocket(23555, 100); // create ServerSocket
            while (true) {
                try {
                    connection = socket.accept();
                    output = new ObjectOutputStream(connection.getOutputStream());
                    output.flush();
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
                    }while (fileToFind != "Terminate");
                } catch (EOFException eofException) {
                } finally {
                    try {
                        send("TERMINATE");
                        output.close(); // close output stream
                        input.close(); // close input stream
                        socket.close(); // close socket
                    } // end try
                    catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    private void send(String str){
        try // send object to client
        {
            output.writeObject(str);
            output.flush(); // flush output to client
        } catch (IOException ioException) {
            displayArea.append("\nError writing object");
        }
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
