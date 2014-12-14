package t3s.smartbus.webSocket;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.swing.Timer;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import t3s.smartbus.entity.Bus;
import t3s.smartbus.entity.buses;
import t3s.smartbus.entity.Sessions;
import t3s.smartbus.main.WebSocketMain;

/**
 * 
 * @author Termchai
 *
 */

@WebSocket
public class MyWebSocketHandler {
	public static boolean isRunning = false;
	
	public MyWebSocketHandler() {
		List<Bus> buses = WebSocketMain.getBuses();
	}
	
	
    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        System.out.println("Close: statusCode=" + statusCode + ", reason=" + reason);
    }

    @OnWebSocketError
    public void onError(Throwable t) {
        System.out.println("Error: " + t.getMessage());
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
    	System.out.println("ixw");
    	Sessions.getSessionSet().add(session);
        System.out.println("Connect: " + session.getRemoteAddress().getAddress());
    }

    @OnWebSocketMessage
    public void onMessage(String message) {
        System.out.println("Message: " + message);

    }
    
    public static void broadcastBusesPosition(List<Bus> busList) throws Exception
    {
    	System.out.println(Sessions.getSessionSet().toString() );
    	System.out.println(parseBusListToString(busList));
    	String busPosition = parseBusListToString(busList);
        Set<Session> set = Sessions.getSessionSet();
        for (Session s : set)
        {
        	if (s.isOpen())
        	s.getRemote().sendString(busPosition);
        }
    }
    
    private static String parseBusListToString (List<Bus> buses) throws Exception
    {
    	StringWriter writer = new StringWriter();
		JAXBContext ctx = JAXBContext.newInstance( buses.class );
		Marshaller marshaller = ctx.createMarshaller();
		buses bl = new buses();
		bl.setList(buses);
		marshaller.marshal(bl, writer);
		return writer.toString();
    }
    
}