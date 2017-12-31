import javax.swing.JFrame;

public class ClientTest {
	public static void main(String[] args) {
		Client newClient = new Client("127.0.0.1");
		newClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newClient.runClient();
	}
}
