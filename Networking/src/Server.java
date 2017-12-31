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


//JFrame is a class that allows you to draw a window on to your screen
//Folks say don't use inheritance, use composition to avoid dependencies and involuntary overrides.
//Just in this case am going to be like fuck it.
public class Server extends JFrame{
	//First build GUI (Just two elements)
	//TextField: A object that allows you to type
	//TextAres: An object that allows you to READ-ONLY
	private JTextField theInputZone;
	private JTextArea theOutputZone;
	
	//Setup the streams for your node.
	private ObjectOutputStream output; //Send objects
	private ObjectInputStream input; //Receive objects
	
	//Setup server essentials
	private ServerSocket server; //This object provide the means to listen to client requests.
	private Socket connection; //This gives access to the client
    
	//Server constructor, but really just a GUI constructor.
	//The technical shit happens in runServer.
	public Server() {
		super("The Messenger: Server Side"); //Calling JFrame's constructor, TITLE.
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
	
	//Executes the server and sets up actual functionality.
	public void runServer() {
		try {
			//The serverSocket constructor takes in a port number and a backlog
			server = new ServerSocket(6789,50); 
			
			//The server will never stop unless you close the window.
			//Hence the infinite loop.
			while(true) {
				try {
					//Check the code, its super self explanatory.
					setupConnection();
					setupStreams();
					runChat();
					
					//The EOFException is a sub-class of the IO exception, it looks into streams and makes sure they are active. IF you try to read from a stream that doesn't have anything in it.
				}catch(EOFException eofException) {
					showMessege("\n Server ended the connection \n");
				}finally {
					closeServer();
				}
			}
		}catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	private void setupConnection() throws IOException{
		showMessege("\n Server looking for connection... \n");
		connection = server.accept();
		showMessege("\n Connection established! \n");
		showMessege("You are connected to " + connection.getInetAddress().getHostName());	
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
			
		}while(!response.equals("Client - END"));
	}
	
	//Just to save memory, you might just want to clse these clases.
	private void closeServer() {
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
	
	//sending shit on streams SELF EXPLANATORY
	private void sendMessege(String someShit) {
		try {
			output.writeObject("Server - " + someShit);
			output.flush();
			showMessege("\n Server - " + someShit);
		}catch(IOException ioException) {
			theOutputZone.append("\n ERROR: cannot send messege! \n");
		}	
	}
	
	//Just append shit to the outputZone.
	private void showMessege(String someShit) {
		//YOU NEED A THREAD TO UPDATE A PART OF THE GUI\
		//Why thread guy? well you wouldn't want to disrupt the main thread which is doing the server client shit.
		//So you quickly start a new thread and update the GUI.
		//Swing utilities gives you access to all that.
		
		//Runnable is the interface, which allows you to build new threads.
		//It only wants you to craeat one method called run, which is executed in the new thread.
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						theOutputZone.append(someShit);
					}
				}
		);
	}
	
	//Restricting access to the textField while no connection is established.
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



















































