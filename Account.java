
public class Account {
	String bankName;	// 은행이름
	long number;		// 계좌번호
	static long money=20000;			// 잔액
	boolean date;		// 만기여부
	Account(){};
	public Account(String bankName,long number,long money) {
		this.bankName=bankName;
		this.number=number;
		this.money=money;
	}
	public String toString() {
		return bankName+" "+number+"계좌에 "+money+"원 있습니다.";
	}
}
