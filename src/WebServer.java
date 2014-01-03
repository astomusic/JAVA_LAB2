import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class WebServer {
	public static LogHandler logger = LogHandler.getHandler();
	public static void main(String[] args) throws IOException {
		ServerSocket server =  new ServerSocket(8080);
		logger.info("WebServer Start");
				
		Socket connection = null;
		while(true) {
			connection = server.accept();
			RequestThread thread = new RequestThread(connection);
			thread.start();
		}

	}

}
