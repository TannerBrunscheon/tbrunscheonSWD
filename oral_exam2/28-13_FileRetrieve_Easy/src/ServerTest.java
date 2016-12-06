import javax.swing.*;

/**
 * This driver creates a server.
 */
public class ServerTest {
    public static void main(String[] args) {
        FileRetrieverServer server =  new FileRetrieverServer();
        server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
