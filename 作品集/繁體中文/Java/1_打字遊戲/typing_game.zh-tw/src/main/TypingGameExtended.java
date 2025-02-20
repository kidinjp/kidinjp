package main;

import java.util.ArrayList;

import io.TypingConsole;
import io.WordManager;

public class TypingGameExtended extends TypingGameStandard {

	public TypingGameExtended(int questions) {
		super(questions);
	}

	/**
	 * 建構 TypingGameExtended 類。
	 * @param questions 出題數量
	 */
	private ArrayList<String> word_list = new ArrayList<>();

	@Override
	protected boolean performTypingRequestProcess(int questionNumber) {
		// 出題前的間隔
		TypingConsole.println("[第 " + (questionNumber + 1) +" 題]");
		TypingConsole.println("[READY]");
		TypingConsole.sleep(interval());
		// 取得出題單字
		String word = getNextWord();
		// 要求輸入
		String input = requestTyping(word);
		// 判斷輸入結果
		if (input.equals(word)) {
			TypingConsole.println("[OK]");
			// 輸入正確
			return true;
		} else {
			TypingConsole.println("[NG]");
			// 輸入錯誤
			return false;
		}
	}

	/**
     * 取得下一個出題單字
     * 1. 不會重複出題已經出現過的單字
     * 2. 若選到重複的單字，總出題數不變（目前程式設定為 10 題）
     * 3. 若選到重複的單字，則重新選擇並出題
     * （3-1） 顯示「(抽選至重複單字...)」的訊息
     * （3-2） 重新選擇單字
     * （3-3） 在重新出題前增加間隔時間
   	 * @return String 單字
	 */
	protected String getNextWord() {
		String word = WordManager.getInstance().getWordRandom();
		if (word_list.contains(word)) {
			System.out.println("(抽選至重複單字...)");
			TypingConsole.sleep(interval());
			return getNextWord();
		} else {
			word_list.add(word);
		}
		// 回傳隨機取得的單字
		return word;
	}

	/**
     * 顯示結果
     * 在目前顯示的結果訊息後，額外輸出以下評價訊息：
     * 1. 顯示每個單字的平均輸入時間（單位為秒，精確到小數點後兩位）
     * 2. 根據以下條件顯示綜合評價：
     * （2-1） 若正確數達到 80% 以上，且平均輸入時間低於 3 秒，則顯示「非常優秀！」
     * （2-2） 若正確數達到 80% 以上，且平均輸入時間超過 3 秒，則顯示「再接再厲！」
     * （2-3） 若正確數低於 80%，則顯示「還請加油！」
     */
	@Override
	protected void showResults() {
		TypingConsole.println("【本次遊玩結果】");
		double averageTypingTime = getTypingTime() / 1000.0 / 10;

		TypingConsole.println("正確題數：" + getCorrects() + " / " + getQuestions());
		TypingConsole.println("輸入總時間：" + (getTypingTime() / 1000) + "秒");
		TypingConsole.println("每個單字的平均輸入時間：" + String.format("%.2f", averageTypingTime) + "秒");
		if (getCorrects() >= 8 && averageTypingTime < 3) {
			TypingConsole.println("非常優秀！");
		} else if (getCorrects() >= 8 && averageTypingTime >= 3) {
			TypingConsole.println("再接再厲！");
		} else if (getCorrects() < 8) {
			TypingConsole.println("還請加油！");
		}

	}

	public ArrayList<String> getWord_list() {
		return word_list;
	}

	public void setWord_list(ArrayList<String> word_list) {
		this.word_list = word_list;
	}
}
