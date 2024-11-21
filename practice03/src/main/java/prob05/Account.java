package prob05;

public class Account {

	private String accountNo;
	private int balance;

	public Account(String string) {
		this.accountNo = string;
		this.balance = 0;
		System.out.println(this.accountNo + " 계좌가 개설 되었습니다.");
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void save(int i) {
		this.balance += i;
		System.out.println(this.accountNo + " 계좌에 " + i + "만원이 입금 되었습니다.");
	}

	public void deposit(int i) {
		this.balance -= i;
		System.out.println(this.accountNo + " 계좌에 " + i + "만원이 출금 되었습니다.");

	}

}
