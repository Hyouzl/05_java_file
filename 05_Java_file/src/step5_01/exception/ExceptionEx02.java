package step5_01.exception;

import java.io.FileReader;

/*
 * 	#finally
 *  
 *  예외발생과 상관없이 무조건 실행할 명령어를 작성한다.
 *  주로 외부모듈과의 컨넥션을 종료할때 사용한다.
 *  
 
 * */

public class ExceptionEx02 {

	public static void main(String[] args) {
		
		
		try {			
			int[] testArr = new int[5];
			//System.out.println(testArr[0]);  
			//System.out.println(testArr[999]); //error
			System.out.println(testArr[0] / 0); //0으로 나누면 항상error
			
		} catch (Exception e) { 
			System.out.println("모든에러 catch");
			e.printStackTrace();
		} finally {
			System.out.println("연결 종료");
		}
		
	}
	
	
}
