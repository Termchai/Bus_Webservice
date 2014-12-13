package t3s.smartbus.entity;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jetty.websocket.api.Session;

public class Sessions {
	private static Set<Session> sesSet = new HashSet<Session>();
	
	public static Set<Session> getSessionSet()
	{
		return sesSet;
	}
}
