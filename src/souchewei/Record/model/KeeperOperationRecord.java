package souchewei.Record.model;

import java.util.Date;

import javax.persistence.*;

import souchewei.ParkingPlaceDemander.model.Car;
import souchewei.ParkingPlaceDemander.model.ParkingPlaceDemander;
import souchewei.ParkingPlaceKeeper.model.ParkingPlaceKeeper;
import souchewei.ParkingPlaceOwner.model.ParkingPlaceOwner;

/*
 * 管理者操作记录
 * 
 */
@Entity()
@Table(name="operation_record")
public class KeeperOperationRecord implements java.io.Serializable{
	@Id @Column(name="operation_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long operationId;
	private Date date;						//时间
	@ManyToOne(targetEntity=ParkingPlaceKeeper.class)
	@JoinColumn(name="keeper_id", referencedColumnName="keeper_id",
		nullable=false)
	private ParkingPlaceKeeper keeper;		//操作者
	
	@ManyToOne(targetEntity=ParkingPlaceOwner.class)
	@JoinColumn(name="owner_id", referencedColumnName="owner_id",
		nullable=false)
	private ParkingPlaceOwner owner;
	
	@ManyToOne(targetEntity=Car.class)
	@JoinColumn(name="car_id", referencedColumnName="car_id",
		nullable=false)
	private Car car;		
	
	@ManyToOne(targetEntity=ParkingPlaceDemander.class)
	@JoinColumn(name="demander_id", referencedColumnName="demander_id",
		nullable=false)
	private ParkingPlaceDemander demander;
	private double money;
	
	public Long getOperationId() {
		return operationId;
	}
	public void setOperationId(Long operationId) {
		this.operationId = operationId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ParkingPlaceKeeper getKeeper() {
		return keeper;
	}
	public void setKeeper(ParkingPlaceKeeper keeper) {
		this.keeper = keeper;
	}
	public ParkingPlaceOwner getOwner() {
		return owner;
	}
	public void setOwner(ParkingPlaceOwner owner) {
		this.owner = owner;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public ParkingPlaceDemander getDemander() {
		return demander;
	}
	public void setDemander(ParkingPlaceDemander demander) {
		this.demander = demander;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(o != null && o.getClass().equals(ParkingPlaceReleaseRecord.class)){
			ParkingPlaceReleaseRecord target = 
					(ParkingPlaceReleaseRecord)o;
			return target.getReleaseId().equals(this.operationId);
		}
		return false;
	}
	@Override
	public int hashCode(){
		int hash = 17;
		if(this.operationId != null){
			hash = hash * 31 + this.operationId.hashCode();
		}
		return hash;
	}
}
