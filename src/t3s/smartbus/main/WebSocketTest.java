package t3s.smartbus.main;

import java.net.URL;
import java.util.List;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import t3s.smartbus.entity.Bus;
import t3s.smartbus.memory.BusMemoryCache;
import WebSocket.MyWebSocketHandler;

public class WebSocketTest {
	
	public static List<Bus> getBuses() {
		return null;
	}

    public static void main(String[] args) throws Exception {
    	System.out.println("Websocket Server Opened!!!");
    	
		URL url = new URL("http://kusmartbus.netburzt.com/map/getbusposition");
    	
        Server server = new Server(8080);
        WebSocketHandler wsHandler = new WebSocketHandler() 
        {
            @Override
            public void configure(WebSocketServletFactory factory) 
            {
                factory.register(MyWebSocketHandler.class);
            }
        };
        MyWebSocketHandler.isRunning = true;
        server.setHandler(wsHandler);
		BusMemoryCache cache = BusMemoryCache.getInstance(url);
        server.start();
        server.join();
        
        
        
    }

}