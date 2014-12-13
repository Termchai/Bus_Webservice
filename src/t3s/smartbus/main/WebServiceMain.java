package t3s.smartbus.main;

import java.net.URL;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ServerProperties;

import t3s.smartbus.memory.BusMemoryCache;

public class WebServiceMain {
	
	 /*port of the webservice */
	static final int PORT = 8080;
	
	static Server server;

	public static void main(String[] args) throws Exception {
		
		URL url = new URL("http://kusmartbus.netburzt.com/map/getbusposition");
		BusMemoryCache cache = BusMemoryCache.getInstance(url);
		
		int port = PORT;
		server = new Server( port );
		ServletContextHandler context = new ServletContextHandler( ServletContextHandler.SESSIONS );
		ServletHolder holder = new ServletHolder( org.glassfish.jersey.servlet.ServletContainer.class );
		holder.setInitParameter(ServerProperties.PROVIDER_PACKAGES, "t3s.smartbus.resource");
		context.addServlet( holder, "/*" );
		server.setHandler( context );
		System.out.println("Starting Jetty server on port " + port);
		server.start();
		System.out.println("Server started.  Press ENTER to stop it.");
		int ch = System.in.read();
		System.out.println("Stopping server.");
//		ProductFactory.getInstance().shutdown();
		server.stop();
	}

}

