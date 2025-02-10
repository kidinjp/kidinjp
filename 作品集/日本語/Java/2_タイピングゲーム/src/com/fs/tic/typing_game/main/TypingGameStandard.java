package com.fs.tic.typing_game.main;

import com.fs.tic.typing_game.io.TypingConsole;
import com.fs.tic.typing_game.io.WordManager;

/**
 * タイピングゲームの実装です。
 * 
 * <pre>
 *   標準的な動作をするタイピングゲームです。
 *   ・タイピングにかかった合計時間を計測します
 *   ・単語はランダムに出題され、同じ単語が出題される可能性があります
 * </pre>
 */
public class TypingGameStandard extends AbstractTypingGame {
	/**
	 * TypingGameStandard を構築します。
	 * @param questions 出題数
	 */
	public TypingGameStandard(int questions) {
		super(1000, questions);
	}
	
	/**
	 * タイピング要求処理です。
	 * 
	 * <pre>
	 *   このメソッドは１問分の出題処理です。
	 * </pre>
	 * 
	 * @return boolean タイピング結果 - タイピングが成功の場合は true、失敗の場合は false
	 */
	@Override
	protected boolean performTypingRequestProcess() {
		// 出題前インターバル
		TypingConsole.println("[READY]");
		TypingConsole.sleep(interval());
		// 出題単語取得
		String word = getNextWord();
		// タイピング要求
		String input = requestTyping(word);
		// タイピング結果判定
		if (input.equals(word)) {
			TypingConsole.println("[OK]");
			// タイピング成功
			return true;
		} else {
			TypingConsole.println("[NG]");
			// タイピング失敗
			return false;
		}
	}
	
	/**
	 * 次に出題する単語を取得します。
	 * @return String 単語
	 */
	protected String getNextWord() {
		// ランダムに取得した単語を返却
		return WordManager.getInstance().getWordRandom();
	}
	
	/**
	 * 結果を表示します。
	 */
	@Override
	protected void showResults() {
		TypingConsole.println("今回の成績は？");
		// 
		TypingConsole.println("正解数：" + getCorrects() + " / " + getQuestions());
		TypingConsole.println("入力時間：" + (getTypingTime() / 1000) + "秒");
	}
}
