package com.fs.tic.typing_game.io;

import java.util.Scanner;

/**
 * タイピングコンソールクラスです。
 * 
 * <pre>
 *   コンソール入出力に関する制御を請け負います。
 *   ・タイピングのコンソール入出力制御
 *   ・ゲーム全体のスリープ制御
 * </pre>
 */
public final class TypingConsole {
	/** コンソール読み込み */
	private static final Scanner scan = new Scanner(System.in);
	
	/**
	 * TypingConsole を構築します。
	 */
	private TypingConsole() {
	}
	
	/**
	 * コンソールから入力を受け付けます。
	 * 
	 * <pre>
	 *   このメソッドを呼び出すことで入力待ちになります。
	 *   エンターキーをきっかけに入力を受け取ります。
	 * </pre>
	 * 
	 * @return String 入力文字列
	 */
	public static String readLine() {
		// 入力文字列返却(入力待ちになり、エンターキーで入力値を受け取ります)
		return scan.nextLine();
	}
	
	/**
	 * コンソールにメッセージを表示します。
	 * @param message メッセージ
	 */
	public static void println(String message) {
		// コンソール出力
		System.out.println(message);
	}
	
	/**
	 * コンソールにメッセージを表示した後、入力を受け付けます。
	 * @param message 表示メッセージ
	 * @return String 入力文字列
	 */
	public static String readLineWithMessage(String message) {
		// メッセージ表示
		println(message);
		// 入力受け付け
		return readLine();
	}
	
	/**
	 * 指定した時間(ミリ秒)スリープします。
	 * @param millis ミリ秒
	 */
	public static void sleep(long millis) {
		try {
			// スリープ
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// 
			e.printStackTrace();
		}
	}
}
