package souchewei.Record.model;
/*
 * 交易状态
 */
public interface OrderState {
	int GENERATION = 1;			//订单生成
	int ORDERING = 2;			//交易中
	int SECOND_ORDER = 3;		//二次交易
	int SUCCESS = 4;			//交易成功
	int FAILURE = 5; 			//交易失败
}
