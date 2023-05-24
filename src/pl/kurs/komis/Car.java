package pl.kurs.komis;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class Car implements Serializable{
	private static final long serialVersionUID = 1L;
	int idc;
	String make;
	String model;
	String regNum;
	Double price;

	
	@Id
	@GeneratedValue
	@XmlAttribute
	public int getIdc() {
		return idc;
	}
	
	//dalsze gettery i settery
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRegNum() {
		return regNum;
	}
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setIdc(int idc) {
		this.idc = idc;
	}

	
	
	
}
