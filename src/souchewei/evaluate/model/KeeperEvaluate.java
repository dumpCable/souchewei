package souchewei.evaluate.model;

import javax.persistence.*;

import souchewei.demander.model.ParkingPlaceDemander;
import souchewei.keeper.model.ParkingPlaceKeeper;

@Entity()
@Table(name="keeper_evaluate")
public class KeeperEvaluate implements java.io.Serializable{
	@Id @Column(name="evalute_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long evaluateId;
	private int grade;						//星级
	private String description;				//描述
	@ManyToOne(targetEntity=ParkingPlaceKeeper.class)
	@JoinColumn(name="keeper_id", referencedColumnName="keeper_id",
		nullable=false)
	private ParkingPlaceKeeper keeper;		//被评价者
	
	@ManyToOne(targetEntity=ParkingPlaceDemander.class)
	@JoinColumn(name="demander_id", referencedColumnName="demander_id",
		nullable=false)
	private ParkingPlaceDemander demander;	//评价者
	public Long getEvaluateId() {
		return evaluateId;
	}
	public void setEvaluateId(Long evaluateId) {
		this.evaluateId = evaluateId;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ParkingPlaceKeeper getKeeper() {
		return keeper;
	}
	public void setKeeper(ParkingPlaceKeeper keeper) {
		this.keeper = keeper;
	}
	public ParkingPlaceDemander getDemander() {
		return demander;
	}
	public void setDemander(ParkingPlaceDemander demander) {
		this.demander = demander;
	}
	@Override
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(o != null && o.getClass().equals(KeeperEvaluate.class)){
			KeeperEvaluate target = (KeeperEvaluate)o;
			return target.getEvaluateId().equals(this.evaluateId);
		}
		return false;
	}
	@Override
	public int hashCode(){
		int hash = 17;
		if(this.evaluateId != null){
			hash = hash * 31 + this.evaluateId.hashCode();
		}
		return hash;
	}
}
