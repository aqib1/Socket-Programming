import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.ex.message.Message;

public class ServerClass {
	private ServerSocket server;
	private Socket client;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	public ServerClass() throws IOException {
		server = new ServerSocket(6200);
		System.out.println("Server started");

	}

	public void waitingForTheClient() throws IOException {
		System.out.println("waiting for the client..");
		client = server.accept();
		System.out.println("client connected !! "+client.getInetAddress().getHostName());
	}
	public void settingUpStreams() throws IOException {
		System.out.println("Setting up streams..");
		inputStream= new ObjectInputStream(client.getInputStream());
		outputStream= new ObjectOutputStream(client.getOutputStream());
		System.out.println("All streams setup");
	}
	public void recieveMessage() throws ClassNotFoundException, IOException {
		Object obj=inputStream.readObject();
		if(obj instanceof Message<?>) {
			Message<?> message= (Message<?>)obj;
			if(message.getT() instanceof String) {
				String m= (String) message.getT();
				System.out.println(m);
			}
		}
	}
	public void closeStreams() throws IOException {
		inputStream.close();
		outputStream.close();
	}
}
