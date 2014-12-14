package t3s.smartbus.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Contact XML Form
 * @author Termchai Sadsaengchan 5510546042
 *
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class buses {
	
	/** List of buses available. */
	private List<Bus> bus;
	
	public buses()
	{
		
	}

	public List<Bus> getList() {
		return bus;
	}

	public void setList(List<Bus> list) {
		this.bus = list;
	}
	
}
