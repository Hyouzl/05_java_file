package step5_02.file;


import java.util.Scanner;

//# 파일 컨트롤러[3단계] : 장바구니

public class FileEx08_정답 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		String[] ids = {"qwer", "javaking", "abcd"};
		String[] pws = {"1111",   "2222", "3333"};
		String[] items = {"사과", "바나나", "딸기"};
		
		final int MAX_SIZE = 100;
		int[][] jang = new int[MAX_SIZE][2];

		String fileName = "jang.txt";
		
		int count = 0;
		int log = -1;
		
		while (true) {
			
			System.out.println("[MEGA SHOP]");
			System.out.println("[1]로그인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]쇼핑");
			System.out.println("[4]장바구니");
			System.out.println("[5]저장");
			System.out.println("[6]로드");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if		(sel == 1) {
				System.out.print("[로그인]ID 입력 : ");
				String id = scan.next();
				System.out.print("[로그인]PW 입력 : ");
				String pw = scan.next();
				
				int cnt = 0;
				for (int i = 0; i < ids.length; i++) {	
					if (id.equals(ids[i]) && pw.equals(pws[i])) {
						log = i;
						System.out.println("[메세지]" + ids[i] + "님, 환영합니다.");
						break;
					}
					cnt++;
				}
				
				if (cnt == ids.length) {
					System.out.println("ID 와 PW를 확인하세요.");
				}
				
			}
			else if (sel == 2) {
				
				for (int i = 0; i < items.length; i++) {
					System.out.println(i+1 + "." + items[i]);
				}
				System.out.print("[쇼핑]상품번호를 선택하세요 : ");
				int num = scan.nextInt();
				
				jang[log][num-1]++; 
				
		
			}
			else if (sel == 3) {}
			else if (sel == 4) {}
			else if (sel == 5) {}
			else if (sel == 6) {}
			else if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		
	}
}
