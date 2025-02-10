package com.fs.tic.typing_game.main;

import com.fs.tic.typing_game.io.TypingConsole;

/**
 * タイピングゲームの基底クラスです。
 */
public abstract class AbstractTypingGame implements ITypingGame {
	/** インターバル時間(ミリ秒) */
	private final long interval;
	/** 出題数 */
	private final int questions;
	/** 正答数 */
	private int corrects = 0;
	/** タイピング時間(ミリ秒) */
	private long typingTime = 0;
	
	/**
	 * AbstractTypingGame を構築します。
	 * @param interval インターバル時間(ミリ秒)
	 * @param questions 出題数
	 */
	protected AbstractTypingGame(long interval, int questions) {
		this.interval = interval;
		this.questions = questions;
	}
	
	/**
	 * タイピング要求処理です。
	 * 
	 * <pre>
	 *   このメソッドは１問分の出題処理です。
	 * </pre>
	 * 
	 * @return boolean タイピング結果 - 正しいタイピングの場合は true、失敗した場合は false
	 */
	protected abstract boolean performTypingRequestProcess();
	
	/**
	 * 結果を表示します。
	 */
	protected abstract void showResults();
	
	/**
	 * ゲームを開始します。
	 */
	@Override
	public final void start() {
		// 正答数／時間リセット
		this.corrects = 0;
		this.typingTime = 0;
		// 開始メッセージ
		TypingConsole.readLineWithMessage("エンターキーで開始します！");
		// 出題数繰り返し
		for (int i = 0; i < questions; i ++) {
			// タイピング要求処理
			boolean result = performTypingRequestProcess();
			// 正答数を加算
			if (result) {
				corrects ++;
			}
			// インターバル
			TypingConsole.println("");
			TypingConsole.sleep(interval());
		}
		// 終了メッセージ
		TypingConsole.println("終了です！");
		TypingConsole.println("");
		// 結果表示
		showResults();
	}
	
	/**
	 * タイピングを要求します。
	 * 
	 * <pre>
	 *   タイピング要求を行い、ユーザの入力文字列を返却します。
	 *   このメソッドの入力待ちの時間がタイピング時間として計測されます。
	 * </pre>
	 * 
	 * @param target タイピング対象単語
	 * @return String 入力文字列
	 */
	protected final String requestTyping(String target) {
		// タイピング対象単語を表示
		TypingConsole.println(target);
		// 計測用タイムスタンプ
		long temp = System.currentTimeMillis();
		// 入力受け付け
		String input = TypingConsole.readLine();
		// 計測タイム加算
		typingTime += System.currentTimeMillis() - temp;
		// 入力文字列返却
		return input;
	}
	
	/**
	 * インターバル時間(ミリ秒)の参照です。
	 * @return long インターバル時間(ミリ秒)
	 */
	protected long interval() {
		// インターバル時間(ミリ秒)
		return interval;
	}
	
	/**
	 * 出題数を取得します。
	 * @return int 出題数
	 */
	public final int getQuestions() {
		// 出題数
		return questions;
	}
	
	/**
	 * 正答数を取得します。
	 * @return int 正答数
	 */
	public final int getCorrects() {
		// 正答数
		return corrects;
	}
	
	/**
	 * タイピング時間を取得します。
	 * @return long タイピング時間(ミリ秒)
	 */
	public final long getTypingTime() {
		// タイピング時間(ミリ秒)
		return typingTime;
	}
}
