package souchewei.ChargeStandard.model;

public class PacketTime extends ChargeStrategy{
	@Override
	public double account(int hours){
		return price;
	}
	@Override 
	public String toString(){
		return "包时段：" + price; 
	}
}
