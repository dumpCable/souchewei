package souchewei.ChargeStandard;
import java.io.Serializable;
/*
 * 收费策略
 */
public abstract class ChargeStrategy implements Serializable{
	protected double price;
	//结算
	public abstract double account(int hours);
	
	public double getPrice(){
		return price;
	}
	public void setPrice(double price){
		this.price = price;
	}
}
