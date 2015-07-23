package souchewei.verifier.model;
import javax.persistence.*;

import souchewei.jurisdiction.Jurisdiction;
/*
 * 信息验证者
 */
@Entity()
@Table(name="verifier")
public class Verifier implements java.io.Serializable{
	@Id @Column(name="verifier_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long verifierId;
	private String name;
	private double overage;						//余额
	private final static int jurisdiction		//对应的权限
		= Jurisdiction.VERIFIER;
	
	public long getVerifierId() {
		return verifierId;
	}
	public void setVerifierId(long verifierId) {
		this.verifierId = verifierId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static int getJurisdiction() {
		return jurisdiction;
	}
	public double getOverage() {
		return overage;
	}
	public void setOverage(double overage) {
		this.overage = overage;
	}
	
	
}
