package souchewei.ChargeStandard;

public class DivisionTimeStrategy extends ChargeStrategy{
	@Override
	public double account(int hours){
		return hours * price;
	}
	@Override
	public String toString(){
		return "分时段每小时" + price;
	}
}
