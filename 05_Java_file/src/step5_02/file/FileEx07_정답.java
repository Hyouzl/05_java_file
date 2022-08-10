package step5_02.file;


import java.security.Identity;
import java.util.Scanner;

//# 파일 컨트롤러[2단계] : ATM

public class FileEx07_정답 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int size = 5;
		int accsCnt = 0;
		int identifier = -1;
		
		String[] accs = new String[size];
		String[]  pws = new String[size];
		int[]  moneys = new int[size];
		
		String fileName = "atm.txt";
		
		while(true) {
			
			
			System.out.println("[MEGA ATM]");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]입금");
			System.out.println("[6]출금");
			System.out.println("[7]이체");
			System.out.println("[8]잔액조회");
			System.out.println("[9]저장");
			System.out.println("[10]로드");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if		(sel == 1) {
				System.out.print("[가입]계좌번호 입력 : ");
				accs[accsCnt] = scan.next();
				System.out.print("[가입]비밀번호 입력 : ");
				pws[accsCnt] = scan.next();
				
				System.out.println("[메세지]회원가입을 축하합니다.");
				moneys[accsCnt] += 1000; 
				accsCnt++;
							
			}
			
			
			else if (sel == 2) {
				for (int i = identifier; i < accsCnt - 1; i++) {
					accs[i] = accs[i+1];
					pws[i] = pws[i+1];
				}
				accsCnt--;
				System.out.println("[메세지]탈퇴되었습니다.");
			}
			
			else if (sel == 3) {
				System.out.print("[로그인]계좌번호를 입력 : ");
				String id = scan.next();
				System.out.print("[로그인]비밀번호 입력 : ");
				String pw = scan.next();
				
				for (int i = 0; i < accsCnt; i++) {
					if(id.equals(accs[i]) && pw.equals(pws[i])) {
						identifier = i;
						break;
					}
					else System.out.println("[메세지]계좌번호와 비밀번호를 확인해주세요.");
				}
			}
			else if (sel == 4) {
				if (identifier == -1) {
					System.out.println("[메세지]로그인 후 이옹가능");
				}
				else {
					identifier = -1;
					System.out.println("[메세지]로그아웃 되었습니다.");
				}
			}
			else if (sel == 5) {
				if (identifier == -1) {
					System.out.println("[메세지]로그인 후 이옹가능");
				}
				else {
					System.out.println("[입금]금액 입력 : ");
					int money = scan.nextInt();
					moneys[identifier] += money;
					System.out.println("[메세지]입금을 완료하였습니다.");
				}
			}
			else if (sel == 6)  { //출금
				if (identifier == -1) {
					System.out.println("[메세지]로그인 후 이옹가능");
				}
				else {
					System.out.print("[출금]금액 입력 : ");
					int money = scan.nextInt();
					moneys[identifier] -= money;
					System.out.println("[메세지]출금을 완료하였습니다.");
				}
				
			}
			else if (sel == 7) { //이체
				if (identifier == -1) {
					System.out.println("[메세지]로그인 후 이옹가능");
				}
				else {
					System.out.print("[이체]계좌번호 입력 : ");
					String acc = scan.next();
					
					int cnt = 0;
					for (int i = 0; i < accsCnt; i++) {
						if (acc.equals(accs[i])) {
							System.out.print("[이체]금액 입력 : ");
							int money = scan.nextInt();
							moneys[i] += money;
							System.out.println("[메세지]이체를 완료하였습니다.");
							break;
						}	
						cnt++;
					}
					
					if (cnt == accsCnt) {
						System.out.println("[메세지]계좌번호를 확인해주세요.");
					}
				}
			}
			else if (sel == 8) { //잔액조회
				if (identifier == -1) {
					System.out.println("[메세지]로그인 후 이옹가능");
				}
				else {
					System.out.println(accs[identifier] + "님의 계좌잔액은 " + moneys[identifier] + "원 입니다.");
				}
			}
			else if (sel == 9) {}
			else if (sel == 10) {}
			else if (sel == 0) {
				break;
			}
			
			
			System.out.println("--------------");
			for (int i = 0; i < accsCnt; i++) {
				System.out.println(accs[i] + ":" + pws[i] + ":" + moneys[i]);
			}
			
			
			if (identifier == -1) {
				System.out.println("--------------");
				System.out.println("상태 : 로그아웃");
				System.out.println("--------------");
			}
			
			else {
			System.out.println("--------------");
			System.out.println("상태 : " + accs[identifier] +"님, 로그인" );
			System.out.println("--------------");
			}
		}
		
	}
}
