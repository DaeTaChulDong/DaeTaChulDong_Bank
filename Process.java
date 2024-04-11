import java.util.Scanner;
import java.time.LocalDate;
import java.util.Calendar;

public class Process{
	Scanner scanner = new Scanner(System.in);
	int AccountSelect;
	int TaskSelect;

	Process() {
	}

	int Process1() {
		System.out.println("계좌를 선택해주세요. ");
		System.out.println("1. 일반 계좌");
		System.out.println("2. 학생 계좌");
		System.out.println("3. 적금");
		int a = scanner.nextInt();
		if (a == 1)
			AccountSelect = 1;
		else if (a == 2)
			AccountSelect = 2;
		else if (a == 3)
			AccountSelect = 3;
		else {
			System.out.println("잘못된 입력입니다. ");
			System.out.println("다시 입력해주세요.");
			return Process1();
		}

		System.out.println("어떤 업무를 보시겠습니까?");
		System.out.println("1. 입금");
		System.out.println("2. 출금");
		System.out.println("3. 뒤로 가기");

		int b = scanner.nextInt();
		if (b == 1)
			TaskSelect = 1;
		else if (b == 2)
			TaskSelect = 2;
		else if (b == 3) {
			System.out.println("뒤로 돌아갑니다.");
			return Process1();
		} else {
			System.out.println("잘못된 입력입니다. ");
			System.out.println("다시 입력해주세요.");
			return Process2();
		}
		return TaskSelect;
	}

	int Process2() {

		int a = scanner.nextInt();
		if (a == 1)
			TaskSelect = 1;
		else if (a == 2)
			TaskSelect = 2;
		else if (a == 3) {
			System.out.println("뒤로 돌아갑니다.");
			return Process1();
		} else {
			System.out.println("잘못된 입력입니다. ");
			System.out.println("다시 입력해주세요.");
			return Process2();
		}
		return TaskSelect;
	}

	void input(int TaskSelect) {
		if (TaskSelect == 1) {
			System.out.println("입금하시려는 계좌를 입력해주세요(ex. 농협 123412341234):");
		} else if (TaskSelect == 2) {
			System.out.println("출금하시려는 계좌를 입력해주세요(ex. 농협 123412341234):");
		}
		return;
	}

	long insertMoney(long money) {
		System.out.println("금액을 입력해주세요: ");
		long plus = scanner.nextLong();
		money += plus;
		System.out.println("입금이 완료되었습니다. ");
		return money;
	}
	
	long getMoney(long money) {
		System.out.println("금액을 입력해주세요: ");
		long minus=scanner.nextLong();
		
		if(AccountSelect==1&&minus>10000000) {
			System.out.println("일반 계좌는 한 번에 최대 1000만 원까지 출금이 가능합니다.");
			return getMoney(money);
		}
		if(AccountSelect==2&&minus>30000) {
			System.out.println("학생 계좌는 출금이 최대 3만원까지 가능합니다. ");
			return getMoney(money);
		}
		if(minus>money) {
			System.out.println("계좌에 돈이 없습니다. ");
			return getMoney(money);
		}
		money-=minus;
		System.out.println("출금이 완료되었습니다. ");
		return money;
	}

	Boolean getRedMoney1() {
		Calendar now=Calendar.getInstance();
		int NowYear = now.get(Calendar.YEAR);
		int NowMonth = now.get(Calendar.MONTH)+1;
		int NowDay = now.get(Calendar.DAY_OF_MONTH);
		System.out.println("오늘은 " + NowYear + "년 " + NowMonth + "월 " + NowDay + "일입니다.");
		System.out.println("출금하시려는 적금 계좌 만기일은 며칠인가요?(ex.2024 04 04)");
		int manyear = scanner.nextInt();
		int manmonth = scanner.nextInt();
		int manday = scanner.nextInt();
		
		if (manyear > NowYear || (manyear == NowYear && manmonth > NowMonth)
				|| (manmonth == NowMonth && manday >= NowDay)) {
			System.out.println("적금 계좌는 적금 만기 일자에만 출금이 가능하고, 입금만 가능합니다. ");
			return false;
		} 
		return true;
	}
	
}
