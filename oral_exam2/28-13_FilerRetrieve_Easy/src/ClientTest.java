import javax.swing.*;

/**
 * This driver creates a client
 */
public class ClientTest {
    public static void main(String[] args) {
        FileRetrieverClient client =  new FileRetrieverClient("127.0.0.1");//Client Ip to connect too
        client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.runClient();
    }


}
