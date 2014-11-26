package t3s.smartbus.memory;

import java.util.ArrayList;
import java.util.List;

import t3s.smartbus.entity.Bus;

public class BusFactory {
	private static BusFactory instance;
	private final int LAT_INDEX = 0;
	private final int LONG_INDEX = 1;
	private final int BUS_ID = 2;
	private final int TIMESTAMP = 4;
	private final int BUS_LINEID = 6;
	
	private BusFactory()
	{
		
	}
	
	public static BusFactory getInstance() 
	{
		if (instance == null) 
			instance = new BusFactory();
		return instance;
	}
	
	public List<Bus> parseStringToBus(String busText)
	{
		busText = busText.replace("[","").replace("]", "").replace("\"", "");
		String[] buses = busText.split("}");
		String[] temp;
		ArrayList<Bus> busList = new ArrayList<Bus>();
		for (int i=0; i<buses.length; i++)
		{
			buses[i] = buses[i].replace(",{", "").replace("{", "");
			temp = buses[i].split(",");
			if (Integer.parseInt(temp[BUS_LINEID].split(":")[1]) == 0)
				continue;
			String tempTimeStamp = temp[TIMESTAMP].split(":")[1] + ":" + temp[TIMESTAMP].split(":")[2] + ":" + temp[TIMESTAMP].split(":")[3];
			Bus bus = new Bus(Integer.parseInt(temp[BUS_ID].split(":")[1]),Integer.parseInt(temp[BUS_LINEID].split(":")[1]),Double.parseDouble(temp[LAT_INDEX].split(":")[1]),Double.parseDouble(temp[LONG_INDEX].split(":")[1]),tempTimeStamp);
			busList.add(bus);
		}
		
		return busList;
	}
	
}
