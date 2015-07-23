package souchewei.owner.model;

import java.util.Set;


/*
 * 车位拥有者
 */


import souchewei.evaluate.model.KeeperEvaluate;
import souchewei.jurisdiction.Jurisdiction;
import souchewei.park.model.ParkingPlace;
import souchewei.verifier.model.Verifier;

import javax.persistence.*;
@Entity()
@Table(name="owner")
public class ParkingPlaceOwner implements java.io.Serializable{
	@Id @Column(name="owner_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ownerId;
	private String name;
	private String openId;					//微信号
	private String phone;					//手机号
	@OneToMany(targetEntity=ParkingPlace.class,
		mappedBy="owner")
	private Set<ParkingPlace> parkingPlaces;//车位拥有者拥有的车位
	@ManyToOne(targetEntity=Verifier.class)
	@JoinColumn(name="verifier_id", referencedColumnName="verifier_id",
		nullable=false)
	private Verifier verifier;				//真实信息的验证者
	private boolean verificatitonState;		//验证状态
	private double overage;					//余额
	private final static int jurisdiction
		= Jurisdiction.OWNER;
	
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isVerificatitonState() {
		return verificatitonState;
	}
	public void setVerificatitonState(boolean verificatitonState) {
		this.verificatitonState = verificatitonState;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Set<ParkingPlace> getParkingPlaces() {
		return parkingPlaces;
	}
	public void setParkingPlaces(Set<ParkingPlace> parkingPlaces) {
		this.parkingPlaces = parkingPlaces;
	}
	public Verifier getVerifier() {
		return verifier;
	}
	public void setVerifier(Verifier verifier) {
		this.verifier = verifier;
	}
	public static int getJurisdiction(){
		return jurisdiction;
	}
	
	public double getOverage() {
		return overage;
	}
	public void setOverage(double overage) {
		this.overage = overage;
	}
	@Override
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(o != null && o.getClass().equals(ParkingPlaceOwner.class)){
			ParkingPlaceOwner target = (ParkingPlaceOwner)o;
			return target.getOwnerId().equals(this.ownerId);
		}
		return false;
	}
	@Override
	public int hashCode(){
		int hash = 17;
		if(this.ownerId != null){
			hash = hash * 31 + this.ownerId.hashCode();
		}
		return hash;
	}
	
}
