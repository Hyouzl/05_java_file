package step5_02.file;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//# 파일 컨트롤러[1단계] : 벡터

public class FileEx06_정답 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int[] vector = null;
		int elementCnt = 0;
		int[] data = new int[1000];
		
		String fileName = "vector.txt";
		FileWriter fw = null;
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		
		while (true) {
			
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가하기");
			System.out.println("[2]삭제하기");
			System.out.println("[3]저장하기");
			System.out.println("[4]로드하기");
			System.out.println("[5]종료하기");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if		(sel == 1) {		
				System.out.println("[추가]데이터 입력 : ");
				data[elementCnt] = scan.nextInt();
				elementCnt++;
				
				for (int i = 0; i < elementCnt; i++) {
					System.out.print(data[i] + " ");
				}
				System.out.println();

			}
			else if (sel == 2) {
				System.out.println("[삭제]인덱스 입력 : ");
				int index = scan.nextInt();
				if (index >= elementCnt) {
					System.out.println("[메세지]해당 위치는 삭제할 수 없습니다.");
					for (int i = 0; i < elementCnt; i++) {
						System.out.print(vector[i] + " ");
					}
				}
				else {
					if (index == elementCnt-1) {
						vector[index] = 0;
						elementCnt--;
					}
					else {
					vector[index] = vector[index+1];
					vector[elementCnt] = 0;
					elementCnt--;
					}
					
				}
				
				for (int i = 0; i < elementCnt; i++) {
					System.out.print(data[i] + " ");
				}
				System.out.println();
			}
			else if (sel == 3) {
				try {
					fw = new FileWriter(fileName);
					
					vector = new int[elementCnt];
					for (int i = 0; i < elementCnt; i++) {
						vector[i] = data[i];
						fw.write(vector[i] + " ");
					}
					
					
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					try { fw.close(); } catch (IOException e) { e.printStackTrace(); }
				}
			
			}
			else if (sel == 4) {
				try {
					fr = new FileReader(file);
					br = new BufferedReader(fr);
					
					String str = br.readLine();
					
					System.out.println(str);
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try { br.close(); } catch (IOException e) { e.printStackTrace(); }
					try { fr.close(); } catch (IOException e) { e.printStackTrace(); }
					
				}
		
			}
			else if (sel == 5) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		
	}
}
