package souchewei.Record.model;

import java.util.Date;

import javax.persistence.*;

import souchewei.Park.model.ParkingPlace;
import souchewei.ParkingPlaceDemander.model.Car;
import souchewei.ParkingPlaceKeeper.model.ParkingPlaceKeeper;
/*
 * 交易记录
 */
@Entity()
@Table(name="order_record")
public class OrderRecord implements java.io.Serializable{
	@Id @Column(name="record_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long recordId;
	private Date generationTime;		//订单生成时间
	private Date finishTime;			//交易完成时间
	@ManyToOne(targetEntity=Car.class)
	@JoinColumn(name="car_id", referencedColumnName="car_id",
		nullable=false)
	private Car car;
	
	@ManyToOne(targetEntity=ParkingPlace.class)
	@JoinColumn(name="placeingPlace_id", referencedColumnName="parkingPlace_id",
		nullable=false)
	private ParkingPlace parkingPlace;
	
	@ManyToOne(targetEntity=ParkingPlaceKeeper.class)
	@JoinColumn(name="keeper_id", referencedColumnName="keeper_id",
		nullable=false)
	private ParkingPlaceKeeper keeper;	
	private double payment;				//付款金额
	private int TradingState;			//交易状态
	
	public Long getRecordId() {
		return recordId;
	}
	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}
	public Date getGenerationTime() {
		return generationTime;
	}
	public void setGenerationTime(Date generationTime) {
		this.generationTime = generationTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
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
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public int getTradingState() {
		return TradingState;
	}
	public void setTradingState(int tradingState) {
		TradingState = tradingState;
	}
	
}
