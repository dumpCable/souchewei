package souchewei.keeper.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import souchewei.evaluate.model.DemanderEvaluate;
import souchewei.evaluate.model.KeeperEvaluate;
import souchewei.jurisdiction.Jurisdiction;
import souchewei.park.model.ParkingPlace;
import souchewei.verifier.model.Verifier;

/*
 * 车位管理者
 */
@Entity
@Table(name="keeper")
public class ParkingPlaceKeeper implements java.io.Serializable {
	private	final boolean WORKING 		= true;
	private final boolean RESTING		= false;
	private final boolean VERIFIED 		= true;
	private final boolean UNVERIFIED 	= false;
	@Id @Column(name="keeper_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long keeperId;
	private String name;
	private String openId;					//微信号
	private String phone;					//手机号
	private String startWorkingTime;		//开始工作时间
	private String endWorkingTime;			//下班时间
	private	boolean	workState;				//工作状态
	private boolean	verificationState;		//验证状态
	
	@ManyToOne(targetEntity=Verifier.class)
	@JoinColumn(name="verifier_id", 
		referencedColumnName="verifier_id", nullable=false)
	private Verifier verifier;				//真实信息的验证者

	@ManyToMany(targetEntity=ParkingPlace.class)
	@JoinTable(name="keeper_parkingPlace",
		joinColumns=@JoinColumn(name="keeper_id",
			referencedColumnName="keeper_id"),
		inverseJoinColumns=@JoinColumn(name="parkingPlace_id",
			referencedColumnName="parkingPlace_id")
	)
	private	Set<ParkingPlace> parkingPlaces;//所管理的车位
	
	@OneToMany(targetEntity=KeeperEvaluate.class,
		mappedBy="keeper")
	private Set<KeeperEvaluate> evaluatedes;//被评价表
	
	@OneToMany(targetEntity=DemanderEvaluate.class,
		mappedBy="demander")
	private Set<DemanderEvaluate> evaluates;//评价表
	private double overage;					//余额
	private double	credits;				//积分
	private final static int jurisdiction	//对应的权限
		= Jurisdiction.KEEPER;
	
	public Long getKeeperId() {
		return keeperId;
	}
	
	public void setKeeperId(Long keeperId) {
		this.keeperId = keeperId;
	}
	
	public static int getJurisdiction() {
		return jurisdiction;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getStartWorkingTime() {
		return startWorkingTime;
	}
	public void setStartWorkingTime(String startWorkingTime) {
		this.startWorkingTime = startWorkingTime;
	}
	public String getEndWorkingTime() {
		return endWorkingTime;
	}
	public void setEndWorkingTime(String endWorkingTime) {
		this.endWorkingTime = endWorkingTime;
	}
	public boolean isWorkState() {
		return workState;
	}
	public void setWorkState(boolean workState) {
		this.workState = workState;
	}
	public boolean isVerificationState() {
		return verificationState;
	}
	public void setVerificationState(boolean verificationState) {
		this.verificationState = verificationState;
	}
	public Verifier getVerifier() {
		return verifier;
	}
	public void setVerifier(Verifier verifier) {
		this.verifier = verifier;
	}
	public Set<ParkingPlace> getParkingPlaces() {
		return parkingPlaces;
	}
	public void setParkingPlaces(Set<ParkingPlace> parkingPlaces) {
		this.parkingPlaces = parkingPlaces;
	}
	
	public double getOverage() {
		return overage;
	}

	public void setOverage(double overage) {
		this.overage = overage;
	}

	public Set<KeeperEvaluate> getEvaluatedes() {
		return evaluatedes;
	}

	public void setEvaluatedes(Set<KeeperEvaluate> evaluatedes) {
		this.evaluatedes = evaluatedes;
	}

	public Set<DemanderEvaluate> getEvaluates() {
		return evaluates;
	}

	public void setEvaluates(Set<DemanderEvaluate> evaluates) {
		this.evaluates = evaluates;
	}

	public double getCredits() {
		return credits;
	}
	public void setCredits(double credits) {
		this.credits = credits;
	}
	
	@Override
	public  int hashCode(){
		int hash = 17;
		if(this.keeperId != null){
			hash = hash * 31 + this.keeperId.hashCode();
		}
		return hash;
	}
	
	@Override
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(o != null && o.getClass().equals(ParkingPlaceKeeper.class)){
			ParkingPlaceKeeper target = (ParkingPlaceKeeper)o;
			return target.getKeeperId().equals(this.keeperId);
		}
		return false;
	}
}
