//Package to access input output streams.
import java.io.*;

//Package containing all the networking classes (Sockets)
import java.net.*;

//Abstract window toolkit
//Contains all the class required for GUI's ALL OF THEM.
import java.awt.*;

//Sub-class of the awt, contains classes that listen to events.
import java.awt.event.*;

//Extension of awt, holds new classes and old shit from awt
import javax.swing.*;


public class Client extends JFrame{
	//First build GUI (Just two elements)
	//TextField: A object that allows you to type
	//TextAres: An object that allows you to READ-ONLY
	private JTextField theInputZone;
	private JTextArea theOutputZone;
	
	//Setup the streams for your node.
	private ObjectOutputStream output; //Send objects
	private ObjectInputStream input; //Receive objects
	private Socket connection;
	
	
	private String serverIP;
	private String messege = "";
	
	public Client(String theIP) {
		super("The Messenger: Client Side");
		serverIP = theIP;
		
		theInputZone = new JTextField(); 
		theInputZone.setEditable(false); //You can't type shit.
		
		//An action lister is basically an event handler, the action being listened to depends on the object it is added to.
		//For a text field the action listened to is hitting enter
		theInputZone.addActionListener(
				//ActionListener is an interface, which only has one method, actionPerformed
				//actionPerformed is a method that is triggered if the event was listened to.
				new ActionListener() {
					//The ActionEvent class describes varios actions performed click, hitting buttons, scroll
					//the Action event depends on the GUI object it is invoked by. textfield -> hitting enter.
					public void actionPerformed(ActionEvent event) {
						//sendMessage is a method of the server go read its shit.
						sendMessege(event.getActionCommand()); //The getActionCommand method returns a string value associated with an GUI object when an action performed. In most cases you can set these, but for a Jtextfield object it returns the string in the textfield when the action is invoked.
						theInputZone.setText("");//Once you send a message you need to clear up your input zone.
					}
				}
		);
		
		add(theInputZone, BorderLayout.NORTH); //the add method belongs to Jframe class, basically allows you to add GUI objects to the window.
		theOutputZone = new JTextArea();
		add(new JScrollPane(theOutputZone));//Adding a textArea + ScrollPane to the window.
		setSize(500,350); //Window dimensions
		setVisible(true); //Self explanatory.
	}
	
	//Why is this not running infinitely? Because the client is not actively seeking out multiple severs. YOU connect once and terminate once you are done.
	public void runClient() {
		try {
			setupConnection(); //Connects to server.
			setupStreams();
			runChat();
		}catch(EOFException eofException) {
			showMessege("\n Client stopped connection.");
		}catch(IOException ioException) {
			ioException.printStackTrace();
		}finally {
			closeClient();
		}
	}
	
	public void setupConnection() throws IOException {
		showMessege("\n Looking for a server to connect... \n");
		connection = new Socket(InetAddress.getByName(serverIP), 6789); //Find the server.
		showMessege("\n You are connected to: " + connection.getInetAddress().getHostName());
	}
	
	private void setupStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessege("\n Communication streams are now setup \n");
	}
	
	private void runChat() throws IOException{
		sendMessege("You are now connected!");
		accessInputField(true);
		String response = new String();
		
		do {
			
			try {	
				response = (String) input.readObject();
				showMessege("\n" + response);
			}catch(ClassNotFoundException classNotFOund) {
				showMessege("\n invalid response! \n");
			}
			
		}while(!response.equals("Server - END"));
	}
	
	private void closeClient() {
		showMessege("\n Closing connection... \n");
		accessInputField(false);
		
		try {
			connection.close();
			input.close();
			output.close();
		}catch(IOException ioException) {
			ioException.printStackTrace();
		}		
	}
	
	private void sendMessege(String someShit) {
		try {
			output.writeObject("Client - " + someShit);
			output.flush();
			showMessege("\n Client - " + someShit);
		}catch(IOException ioException) {
			theOutputZone.append("\n ERROR: cannot send messege! \n");
		}	
	}
	
	private void showMessege(String someShit) {
		//YOU NEED A THREAD TO UPDATE A PART OF THE GUI
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						theOutputZone.append(someShit);
					}
				}
		);
	}
	
	private void accessInputField(boolean torf) {
		//YOU NEED A THREAD TO UPDATE A PART OF THE GUI
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						theInputZone.setEditable(torf);
					}
				}
		);
	}
	
}




















































































