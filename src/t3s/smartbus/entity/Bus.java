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

@XmlRootElement(name="bus")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="buses")
public class Bus implements Serializable {
	

	private static final long serialVersionUID = 1L;

	
	@XmlAttribute
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	
	private int busLineNumber;
	private double lat, lon;
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

	public int getBusLineNumber() {
		return busLineNumber;
	}

	public void setBusLineNumber(int busLineNumber) {
		this.busLineNumber = busLineNumber;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Bus(int busID, int busLineNumber, double lat, double lon, String timestamp) {
		this.id = busID;
		this.busLineNumber = busLineNumber;
		this.lat = lat;
		this.lon = lon;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ID:" + id + " Line:" + busLineNumber + " Lat:" + lat + " Long:" + lon + " Time:" + timestamp + "\n";
	}
	
	public boolean equals(Object other) {
		if (other == null || other.getClass() != this.getClass()) return false;
		Bus contact = (Bus) other;
		return contact.getId() == this.getId();
	}
	



	@Override
	public int hashCode() {
		return (id+"").hashCode();
	}


}