package step5_01.exception;

import java.io.FileReader;

/*
 * 
 * # 예외 (Exception) 처리
 * 
 * 심각한 오류를 발생시킬수 있는 내용은
 * try , catch 구문안에 만들도록 강제한다.
 * 
 * try : 에러가 나지 않을 경우 정상적으로 실행 될 명령어
 * catch : try{} 안의 명령어가 실행되는 중 에러가 발생할 경우 분기되는 명령어
 * 
 *  - try 없이 catch가 단독으로 올 수 없고 , catch 없이 try가 단독으로 올 수 없다.
 * 
 * */

public class ExceptionEx01 {

	public static void main(String[] args) {
		
		
		try {			
			int[] testArr = new int[5];
			
			//System.out.println(testArr[999]); //error
			//System.out.println(testArr[0]);  
			//System.out.println(testArr[0] / 0); //0으로 나누면 항상error

			new FileReader("abcdefg");
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열범위초과 에러 catch");
			e.printStackTrace();
		} catch (ArithmeticException e) {
			System.out.println("연산에러 catch");
			e.printStackTrace();
		} catch (Exception e) { 
			System.out.println("모든에러 catch");
			//e.printStackTrace();
		}
		
		
		
		
	}
	
	
}
