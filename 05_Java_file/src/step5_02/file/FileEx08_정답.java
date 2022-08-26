package step5_02.file;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
			for (int i = 0; i < ids.length; i++) {
				System.out.print(ids[i] + " : " + pws[i] + "(");
				for (int j = 0; j < count; j++) {
					if (jang[j][0] == i) {
						if (jang[j][1]==1) System.out.print("사과/");
						else if (jang[j][1]==2) System.out.print("바나나/");
						else if (jang[j][1]==3) System.out.print("딸기/");
					}
				}
				System.out.print(")");
				System.out.println();
			}
			
			System.out.println("------------------");
			if (log == -1) {
			System.out.println("상태 : 로그아웃" );
			}
			else {
				System.out.println(ids[log] + "님, 로그인");
			}
			
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
				if (log == -1) {
					System.out.println("로그인 후 이용가능");
				}
				else {
					System.out.println("[메세지] 로그아웃 중 ...");
				}
		
			}
			else if (sel == 3) {
				if (log == -1) {
					System.out.println("로그인 후 이용가능");
				}
				else {
				for (int i = 0; i < items.length; i++) {
					System.out.println(i+1 + "." + items[i]);
				}
				System.out.print("[쇼핑]상품번호를 선택하세요 : ");
				int num = scan.nextInt();
				
				  
				System.out.println("[메세지]장바구니에 담겼습니다.");
				jang[count][0] = log;
				jang[count][1] = num;
				count++;
				}
			}
			else if (sel == 4) {
				if (log == -1) {
					System.out.println("로그인 후 이용가능");
				}
				else {
					System.out.println("[" + ids[log] + "]님의 장바구니");
				}
				
				int k = 0;
				int cnt = 0;
				while (true) {
					if (k == count) {
						break;
					}
					if (jang[k][0] == log) {
						cnt++;
						int num = jang[k][1];
						System.out.println(cnt + "." + items[num-1]);
					}
					k++;
				}
				
			}
			else if (sel == 5) {
				if (log == -1) {
					System.out.println("로그인 후 이용 가능");
				}
				else if (count == 0) {
					System.out.println("저장할 데이터가 없습니다.");
				}
				else {
					String data = "";
					for (int i = 0; i < count; i++) {
								data += jang[count][0];
								data += "/";
								data += jang[count][1];
								data += "\n";
					}
					
					data = data.substring(0, data.length()-1);
					FileWriter fw = null;
					
					try {
						fw = new FileWriter(fileName);
						fw.write(data);
		
					} catch (Exception e) {
						e.printStackTrace(); 
					} finally {
						if (fw != null) try {  {fw.close();} }  catch (IOException e) {} }
					}
				
				System.out.println("[메세지]저장을 완료하였습니다.");
	
				}
				
			
			else if (sel == 6) {
				File file = new File(fileName);
				FileReader fr = null;
				BufferedReader br = null;
				
				if (file.exists()) {
					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						int cnt = 0;
						String line = br.readLine();
						while (line != null) {
							String[] temp = line.split("/");
							jang[cnt][0] = Integer.parseInt(temp[0]);
							jang[cnt][1] = Integer.parseInt(temp[1]);
							cnt++;
							
							line = br.readLine();
						}
						
						
					} catch (Exception e) {
							e.printStackTrace();
					}finally {
						if (fr != null) { try { fr.close(); } catch (IOException e) {} }
						if (br != null) {try { br.close(); } catch (IOException e) {} }
					}
				}
				
			}
			
			else if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		
	}
}

