package t3s.smartbus.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Bus with bus id, bus line number, location of the bus
 * 		with latitude, longitude, and timestamp.
 * @author Termchai, Supavit
 *
 */

@XmlRootElement(name="bus")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="buses")
public class Bus implements Serializable {
	

	private static final long serialVersionUID = 1L;

	
	@XmlAttribute
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
//TODO Why long?  There aren't that many buses.
	private long id;

//TODO why name attribute "busLineNumber"? You don't name latitude as "busLatitude".
	private int    lineNumber;
	private double latitude;
	private double longitude;
	private String timestamp;
	
	public Bus() {}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int busLineNumber) {
		this.lineNumber = busLineNumber;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Bus(int busID, int busLineNumber, double latitude, double longitude, String timestamp) {
		this.id = busID;
		this.lineNumber = busLineNumber;
		this.latitude = latitude;
		this.longitude = longitude;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ID:" + id + " Line:" + lineNumber + " Lat:" + latitude + " Long:" + longitude + " Time:" + timestamp + "\n";
	}
	
	public boolean equals(Object other) {
		if (other == null || other.getClass() != this.getClass()) return false;
		Bus contact = (Bus) other;
		return contact.getId() == this.getId();
	}
	


	/**
	 * Use the bus id as hashcode.
	 * But there is NO REASON to convert it to String! 
	 * Its a number, so compute hashcode based on number.
	 */
	@Override
	public int hashCode() {
// This is silly.  Please read about hashCode.
//		return (id+"").hashCode();
		return (int)id;
	}


}