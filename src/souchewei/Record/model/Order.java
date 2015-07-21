package souchewei.Record.model;

import java.util.Date;

import javax.persistence.*;

import souchewei.Park.model.ParkingPlace;
import souchewei.ParkingPlaceDemander.model.Car;
import souchewei.ParkingPlaceKeeper.model.ParkingPlaceKeeper;
/*
 * 订单
 */
@Entity()
@Table(name="orders")
public class Order implements java.io.Serializable{
	@Id @Column(name="order_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderId;
	private Date generationTime;			//生成时间
	
	@ManyToOne(targetEntity=Car.class)
	@JoinColumn(name="car_id", referencedColumnName="car_id",
		nullable=false)
	private Car car;						
	
	@ManyToOne(targetEntity=ParkingPlace.class)
	@JoinColumn(name="parkingPlace_id", referencedColumnName="parkingPlace_id",
		nullable=false)
	private ParkingPlace parkingPlace;		//所在车位
	
	@ManyToOne(targetEntity=ParkingPlaceKeeper.class)
	@JoinColumn(name="keeper_id", referencedColumnName="keeper_id",
		nullable=false)
	private ParkingPlaceKeeper keeper;		//所属管理者
	
	private double money;					//定金
	private int orderState;					//订单状态
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Date getGenerationTime() {
		return generationTime;
	}
	public void setGenerationTime(Date generationTime) {
		this.generationTime = generationTime;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public ParkingPlace getParkingPlace() {
		return parkingPlace;
	}
	public void setParkingPlace(ParkingPlace parkingPlace) {
		this.parkingPlace = parkingPlace;
	}
	public ParkingPlaceKeeper getKeeper() {
		return keeper;
	}
	public void setKeeper(ParkingPlaceKeeper keeper) {
		this.keeper = keeper;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	
	@Override
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(o != null && o.getClass().equals(Order.class)){
			Order target = (Order)o;
			return target.getOrderId().equals(this.orderId);
		}
		return false;
	}
	@Override
	public int hashCode(){
		int hash = 17;
		if(this.orderId != null){
			hash = hash * 31 + this.orderId.hashCode();
		}
		return hash;
	}
}
