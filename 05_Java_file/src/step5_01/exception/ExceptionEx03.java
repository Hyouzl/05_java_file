package step5_01.exception;

/*
 * 
 * # 예외 (Exception) 처리 throws
 * 
 *  - try ~ catch 와 같이 예외를 처리하나 상위 메서드로 처리를  미룬다.
 * 
 * */


public class ExceptionEx03 {
	
	public static void main(String[] args) throws Exception{
		
		int[] testArr = new int[5];
		System.out.println(testArr[999]);
	}
}
