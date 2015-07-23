package souchewei.record.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import souchewei.chargeStandard.model.ChargeStrategy;
import souchewei.chargeStandard.model.DivisionTimeStrategy;
import souchewei.keeper.model.ParkingPlaceKeeper;
import souchewei.owner.model.ParkingPlaceOwner;
import souchewei.park.model.ParkingPlace;

/*
 * 停车位发布记录
 */
@Entity()
@Table(name="release_record")
public class ParkingPlaceReleaseRecord implements java.io.Serializable{
	@Id @Column(name="release_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long releaseId;
	private Date date;
	@ManyToOne(targetEntity=ParkingPlaceOwner.class)
	@JoinColumn(name="owner_id", referencedColumnName="owner_id",
		nullable=false)
	private ParkingPlaceOwner owner;
	@ManyToOne(targetEntity=ParkingPlace.class)
	@JoinColumn(name="parkingPlace_id", referencedColumnName="parkingPlace_id",
		nullable=false)
	private ParkingPlace parkingPlace;
	@ManyToOne(targetEntity=ParkingPlaceKeeper.class)
	@JoinColumn(name="keeper_id", referencedColumnName="keeper_id",
		nullable=false)
	private ParkingPlaceKeeper keeper;
	
	private ChargeStrategy chargeStrategy;
	
	public Long getReleaseId() {
		return releaseId;
	}
	public void setReleaseId(Long releaseId) {
		this.releaseId = releaseId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ParkingPlaceOwner getOwner() {
		return owner;
	}
	public void setOwner(ParkingPlaceOwner owner) {
		this.owner = owner;
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
	public ChargeStrategy getChargeStrategy() {
		return chargeStrategy;
	}
	public void setChargeStrategy(ChargeStrategy chargeStrategy) {
		this.chargeStrategy = chargeStrategy;
	}
	@Override
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(o != null && o.getClass().equals(ParkingPlaceReleaseRecord.class)){
			ParkingPlaceReleaseRecord target = 
					(ParkingPlaceReleaseRecord)o;
			return target.getReleaseId().equals(this.releaseId);
		}
		return false;
	}
	@Override
	public int hashCode(){
		int hash = 17;
		if(this.releaseId != null){
			hash = hash * 31 + this.releaseId.hashCode();
		}
		return hash;
	}
}
