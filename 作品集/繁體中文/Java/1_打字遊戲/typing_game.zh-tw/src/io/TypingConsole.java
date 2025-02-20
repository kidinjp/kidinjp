package io;

import java.util.Scanner;

/**
 * 打字控制台 類。
 * 
 * <pre>
 *   負責處理與控制台輸入輸出相關的操作。
 *   ・管理打字的控制台輸入輸出
 *   ・控制整個遊戲的暫停（睡眠）
 * </pre>
 */
public final class TypingConsole {
	/** 控制台輸入掃描器 */
	private static final Scanner scan = new Scanner(System.in);
	
	/**
	 * 建構 TypingConsole。
	 */
	private TypingConsole() {
	}
	
	/**
	 * 從控制台接收輸入。
	 * 
	 * <pre>
	 *   調用此方法後會進入等待輸入的狀態，
	 *   按下 Enter 鍵後接收輸入的內容。
	 * </pre>
	 * 
	 * @return String 輸入的字串
	 */
	public static String readLine() {
		// 返回輸入的字串（等待輸入，按 Enter 鍵後接收輸入值）
		return scan.nextLine();
	}
	
	/**
	 * 在控制台顯示訊息。
	 * @param message 訊息
	 */
	public static void println(String message) {
		// 控制台輸出
		System.out.println(message);
	}
	
	/**
	 * 在控制台顯示訊息後，接收輸入。
	 * @param message 要顯示的訊息
	 * @return String 輸入的字串
	 */
	public static String readLineWithMessage(String message) {
		// 顯示訊息
		println(message);
		// 接受輸入
		return readLine();
	}
	
	/**
	 * 暫停指定的時間（毫秒）。
	 * @param millis 毫秒數
	 */
	public static void sleep(long millis) {
		try {
			// 暫停執行
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// 當執行緒的休眠被中斷時，輸出異常資訊
			e.printStackTrace();
		}
	}
}
