import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.ex.message.Message;

public class ClientClass {
private Socket client;
private ObjectInputStream inputStream;
private ObjectOutputStream outputStream;
public ClientClass() throws UnknownHostException, IOException {
	System.out.println("Connecting with server");
	client= new Socket(AppConsts.IP,AppConsts.port);
	System.out.println("Server connected");
}
public void settingUpStreams() throws IOException {
	System.out.println("Setting up streams..");
	outputStream= new ObjectOutputStream(client.getOutputStream());
	inputStream= new ObjectInputStream(client.getInputStream());
	System.out.println("All streams setup");
}
public void sendMessage() throws IOException {
	Message<String> message= new Message<>();
	message.setT("Hello EVS");
	outputStream.writeObject(message);
	outputStream.flush();
	System.out.println("Message sent");
}
public void closeStreams() throws IOException {
	inputStream.close();
	outputStream.close();
}
}
