package souchewei.jurisdiction;
/*
 * 权限接口
 */
public interface Jurisdiction {
	int DEMANDER = 1;			//车位需求者权限
	int KEEPER = 2;				//车位管理者权限
	int OWNER = 3;				//车位拥有者权限
	int VERIFIER = 4;			//验证者
	int SUPER = 10;				//超级管理员权限
}
