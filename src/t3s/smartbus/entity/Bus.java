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
	
	private int busLineID ;
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

	public int getBusLineID() {
		return busLineID;
	}

	public void setBusLineID(int busLineID) {
		this.busLineID = busLineID;
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

	public Bus(int busID, int busLineID, double lat, double lon, String timestamp) {
		this.id = busID;
		this.busLineID = busLineID;
		this.lat = lat;
		this.lon = lon;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ID:" + id + " Line:" + busLineID + " Lat:" + lat + " Long:" + lon + " Time:" + timestamp + "\n";
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