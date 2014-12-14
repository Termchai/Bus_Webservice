package t3s.smartbus.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;

import t3s.smartbus.entity.Bus;

public class TestMain {
	
	private static String serviceUrl;
	private static HttpClient client;
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException 
	{
	serviceUrl = "http://localhost:8080/busesposition";
	client = new HttpClient();
	try {
		client.start();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("some error occurs");
		e.printStackTrace();
	}
	
	
	 ContentResponse res = client.GET(serviceUrl);
	 System.out.println(parseXmlToBus(res.getContentAsString()).toString());
//	 System.out.println(parseXmlToStringArray(res.getContentAsString()));
	}
	
	public static List<Bus> parseXmlToBus(String inputXml)
	{
		inputXml = inputXml.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
		inputXml = inputXml.replace("<buses>", "").replace("</buses>", "");
		String[] temp = inputXml.split("</bus>");
		List<Bus> busList = new ArrayList<Bus>();
		for (int i=0; i<temp.length; i++)
		{
			Bus bus = new Bus();
			String[] temp2 = temp[i].split(">");
			bus.setId(Long.parseLong(temp2[0].split("\"")[1]));
			bus.setLineNumber((Integer.parseInt(temp2[2].split("<")[0])));
			bus.setLatitude((Double.parseDouble(temp2[4].split("<")[0])));
			bus.setLongitude(Double.parseDouble(temp2[6].split("<")[0]));
			bus.setTimestamp(temp2[8].split("<")[0]);
			busList.add(bus);
		}
		return busList;
	}
}
