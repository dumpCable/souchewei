package souchewei.demander.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import souchewei.evaluate.model.DemanderEvaluate;
import souchewei.evaluate.model.KeeperEvaluate;
import souchewei.jurisdiction.Jurisdiction;
/*
 * 车位需求者
 */
@Entity
@Table(name="demander")
public class ParkingPlaceDemander 
	implements java.io.Serializable{
	@Id @Column(name="demander_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long 	demanderId;		
	private String name;	
    private String openId;					//微信号
 	private String phone;					//手机号
 	@OneToMany(targetEntity=Car.class, 
 		mappedBy="demander")
 	private Set<Car> cars;					//所拥有的车
 	@OneToMany(targetEntity=DemanderEvaluate.class, 
 		mappedBy="demander")
	private Set<DemanderEvaluate> evaluatedes;//被评价表
 	@OneToMany(targetEntity=KeeperEvaluate.class, 
 	 	mappedBy="keeper")
 	private Set<KeeperEvaluate> evaluates;  //评价表
	private	double credits;					//积分
	private final static int jurisdiction 
		= Jurisdiction.DEMANDER;			//对应的权限

	public Long getDemanderId() {
		return demanderId;
	}
	public void setDemanderId(Long demanderId) {
		this.demanderId = demanderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCredits() {
		return credits;
	}
	public void setCredits(double credits) {
		this.credits = credits;
	}
	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Set<Car> getCars() {
		return cars;
	}
	public void setCarNumber(Set<Car> cars) {
		this.cars = cars;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public Set<DemanderEvaluate> getEvaluatedes() {
		return evaluatedes;
	}
	public void setEvaluatedes(Set<DemanderEvaluate> evaluatedes) {
		this.evaluatedes = evaluatedes;
	}
	public Set<KeeperEvaluate> getEvaluates() {
		return evaluates;
	}
	public void setEvaluates(Set<KeeperEvaluate> evaluates) {
		this.evaluates = evaluates;
	}
	public static int getJurisdiction(){
		return jurisdiction;
	}
	@Override
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(o != null && o.getClass().equals(ParkingPlaceDemander.class)){
			ParkingPlaceDemander target = (ParkingPlaceDemander)o;
			return target.getDemanderId().equals(this.demanderId);
		}
		return false;
	}
	@Override
	public int hashCode(){
		int hash = 17;
		if(this.demanderId != null){
			hash = hash * 31 + this.demanderId.hashCode();
		}
		return hash;
	}
}
