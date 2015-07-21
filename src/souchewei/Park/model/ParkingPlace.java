package souchewei.Park.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import souchewei.ChargeStandard.model.ChargeStrategy;
import souchewei.ChargeStandard.model.DivisionTimeStrategy;
import souchewei.ParkingPlaceKeeper.model.ParkingPlaceKeeper;
import souchewei.ParkingPlaceOwner.model.ParkingPlaceOwner;
import souchewei.Verifier.model.Verifier;
/*
 * 车位具体信息
 */
@Entity()
@Table(name="parking_place")
public class ParkingPlace implements java.io.Serializable{
	private final boolean VERIFIED 		= true;
	private final boolean UNVERIFIED 	= false;
	@Id @Column(name="parkingPlace_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long parkingPlaceId;
	
	@ManyToOne(targetEntity=ParkingPlaceOwner.class)
	@JoinColumn(name="owner_id", referencedColumnName="owner_id",
		nullable=false)
	private ParkingPlaceOwner owner;		//车位拥有者
	
	@ManyToOne(targetEntity=Park.class)
	@JoinColumn(name="park_id", referencedColumnName="park_id",
		nullable=false)
	private Park park;						//所属停车场
	

	@ManyToOne(targetEntity=Verifier.class)
	@JoinColumn(name="verifier_id",
		referencedColumnName="verifier_id", nullable=false)
	private Verifier verifier;				//信息真实性的验证者
	
	@ManyToMany(targetEntity=ParkingPlaceKeeper.class)
	@JoinTable(name="keeper_parkingPlace",
		joinColumns=@JoinColumn(name="parkingPlace_id",
			referencedColumnName="parkingPlace_id"),
		inverseJoinColumns=@JoinColumn(name="keeper_id",
			referencedColumnName="keeper_id")
	)
	private Set<ParkingPlaceKeeper> keepers;//车位的管理者
	
	private boolean	verificationState;		//车位验证状态
	private boolean managementState;		//车位被管理的状态
	private ChargeStrategy chargeStrategy;	//收费标准
	
	public Long getParkingPlaceId() {
		return parkingPlaceId;
	}
	public void setParkingPlaceId(Long parkingPlaceId) {
		this.parkingPlaceId = parkingPlaceId;
	}
	public ParkingPlaceOwner getOwner() {
		return owner;
	}
	public void setOwner(ParkingPlaceOwner owner) {
		this.owner = owner;
	}
	public Park getPark() {
		return park;
	}
	public void setPark(Park park) {
		this.park = park;
	}
	public Set<ParkingPlaceKeeper> getKeepers() {
		return keepers;
	}
	public void setKeepers(Set<ParkingPlaceKeeper> keepers) {
		this.keepers = keepers;
	}
	public boolean isVerificationState() {
		return verificationState;
	}
	public void setVerificationState(boolean verificationState) {
		this.verificationState = verificationState;
	}
	public ChargeStrategy getStandard() {
		return chargeStrategy;
	}
	public void setStandard(ChargeStrategy chargeStrategy) {
		this.chargeStrategy = chargeStrategy;
	}
	public boolean isManagementState() {
		return managementState;
	}
	public void setManagementState(boolean managementState) {
		this.managementState = managementState;
	}
	@Override 
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(o != null && o.getClass() == ParkingPlace.class){
			ParkingPlace target = (ParkingPlace)o;
			return this.getParkingPlaceId().equals(this.parkingPlaceId);
		}
		return false;
	}
	@Override
	public int hashCode(){
		int hash = 17;
		if(this.parkingPlaceId != null){
			hash = hash * 31 + this.parkingPlaceId.hashCode();
		}
		return hash;
	}
}
