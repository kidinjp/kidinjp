package main;

import io.TypingConsole;
import io.WordManager;

/**
 * 實裝 打字遊戲的類
 * 
 * <pre>
 *   這是一個標準的打字遊戲。
 *   ・計算"打字所花的總時間"
 *   ・單字會"隨機出題"，並且有可能會重複出現相同的單字
 * </pre>
 */
public class TypingGameStandard extends AbstractTypingGame {
	/**
	 * 建構 TypingGameStandard。
	 * @param questions 出題數
	 */
	public TypingGameStandard(int questions) {
		super(1000, questions);
	}
	
	/**
	 * 打字請求處理。
	 * 
	 * <pre>
	 *   此方法為每一題的出題處理。
	 * </pre>
	 * 
	 * @return boolean 打字結果 - 如果打字成功則為 "[OK]"，失敗則為 "[NG]"
	 */
	@Override
	protected boolean performTypingRequestProcess(int questionNumber) {
		// 出題前間隔
		TypingConsole.println("[READY]");
		TypingConsole.sleep(interval());
		// 獲取出題單詞
		String word = getNextWord();
		// 打字請求
		String input = requestTyping(word);
		// 判斷打字結果
		if (input.equals(word)) {
			TypingConsole.println("[OK]");
			// 打字成功
			return true;
		} else {
			TypingConsole.println("[NG]");
			// 打字失敗
			return false;
		}
	}
	
	/**
	 * 獲取下一個出題的單字。
	 * @return String 單字
	 */
	protected String getNextWord() {
		// 隨機獲取單字並返回
		return WordManager.getInstance().getWordRandom();
	}
	
	/**
	 * 顯示結果。
	 */
	@Override
	protected void showResults() {
		TypingConsole.println("【本次遊玩結果】");
		// 
		TypingConsole.println("正確題數：" + getCorrects() + " / " + getQuestions());
		TypingConsole.println("輸入總時間：" + (getTypingTime() / 1000) + "秒");
	}
}
