package souchewei.ParkingPlaceDemander.model;

import java.io.Serializable;

import javax.persistence.*;
/*
 * 车
 */
@Entity()
@Table(name="car")
public class Car implements Serializable{
	@Id @Column(name="car_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long carId;						//车的id号
	private String carNumber;				//车牌号
	private String type;					//车的型号
	@ManyToOne(targetEntity=ParkingPlaceDemander.class)
	@JoinColumn(name="demander_id", referencedColumnName="demander_id",
		nullable=false)
	private ParkingPlaceDemander demander;	//所属者
	private String color;					//车的颜色
	
	public Long getCarId() {
		return carId;
	}
	public void setCarId(Long carId) {
		this.carId = carId;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ParkingPlaceDemander getDemander() {
		return demander;
	}
	public void setDemander(ParkingPlaceDemander demander) {
		this.demander = demander;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(o != null && o.getClass().equals(Car.class)){
			Car target = (Car)o;
			return target.getCarId().equals(this.carId);
		}
		return false;
	}
	@Override
	public int hashCode(){
		int hash = 17;
		if(this.carId != null){
			hash = hash * 31 + this.carId.hashCode();
		}
		return hash;
	}
}
