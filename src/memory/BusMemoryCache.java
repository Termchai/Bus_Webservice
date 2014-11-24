package memory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import sabaii.trekking.entity.Bus;


public class BusMemoryCache {
	
	private List<Bus> busList;
	private URL url;
	private BusFactory busFactory;
	private static BusMemoryCache instance;
	
	public static BusMemoryCache getInstance(URL url)
	{
		if (instance == null && url != null)
			try {
				instance = new BusMemoryCache(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return instance;
	}
	
	private BusMemoryCache(URL url) throws Exception 
	{
		this.url = url;
		busFactory = BusFactory.getInstance();
		busList = busFactory.parseStringToBus(getTextFromUrl());
	}

	public String getTextFromUrl()
	{
		try 
		{
		    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		    String line = in.readLine();
		    return line;
		}
		catch (MalformedURLException e) {
			System.out.println("Malformed URL: " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("I/O Error: " + e.getMessage());
		}
		return null;
	}
	
	public List<Bus> findAll() {
		return java.util.Collections.unmodifiableList(busList);
	}


	public List<Bus> getBusList() {
		return busList;
	}
	
}
