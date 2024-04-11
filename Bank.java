import java.util.Scanner;
import java.time.LocalDate;

public class Bank {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Process process1 = new Process();
		int TaskSelect = process1.Process1();
		Account account1 = new Account();

		// 일반 계좌
		if (process1.AccountSelect == 1) {
			process1.input(TaskSelect);
			account1.bankName = scanner.next();
			account1.number = scanner.nextLong();
			// 입금
			if (TaskSelect == 1) {
				account1.money = process1.insertMoney(account1.money);
				System.out.println(account1);
			}
			// 출금
			else {
				account1.money = process1.getMoney(account1.money);
				System.out.println(account1);
			}
		}

		// 학생 계좌
		else if (process1.AccountSelect == 2) {
			process1.input(TaskSelect);
			account1.bankName = scanner.next();
			account1.number = scanner.nextLong();
			if (TaskSelect == 1) {
				account1.money = process1.insertMoney(account1.money);
				System.out.println(account1);
			} else {
				account1.money = process1.getMoney(account1.money);
				System.out.println(account1);
			}
		}

		// 적금 계좌
		else {
			process1.input(TaskSelect);
			account1.bankName = scanner.next();
			account1.number = scanner.nextLong();
			if (TaskSelect == 1) {
				account1.money = process1.insertMoney(account1.money);
				System.out.println(account1);
			}
			// 출금
			else {
				Boolean GetMoneyAble = process1.getRedMoney1();
				if (GetMoneyAble == true) {
					account1.money = process1.getMoney(account1.money);
					System.out.println(account1);
				}
			}
		}
	}
}
