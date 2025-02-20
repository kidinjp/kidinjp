package main;

import io.TypingConsole;

/**
 * 打字遊戲 的基底類。
 */
public abstract class AbstractTypingGame implements ITypingGame {
	/** 間隔時間（毫秒） */
	private final long interval;
	/** 出題數 */
	private final int questions;
	/** 正確數 */
	private int corrects = 0;
	/** 打字時間(毫秒) */
	private long typingTime = 0;
	
	/**
	 * 建構 AbstractTypingGame。
	 * @param interval 間隔時間（毫秒）
	 * @param questions 出題數
	 */
	protected AbstractTypingGame(long interval, int questions) {
		this.interval = interval;
		this.questions = questions;
	}
	
	/**
	 * 打字請求處理。
	 * 
	 * <pre>
	 *   此方法為一題的出題處理。
	 * </pre>
	 * 
	 * @return boolean 打字結果 - 打字結果 - 如果打字成功則為 "[OK]"，失敗則為 "[NG]"
	 */
	protected abstract boolean performTypingRequestProcess(int questionNumber);
	
	/**
	 * 顯示結果。
	 */
	protected abstract void showResults();
	
	/**
	 * 開始遊戲。
	 */
	@Override
	public final void start() {
		// 正確數／時間重置
		this.corrects = 0;
		this.typingTime = 0;
		// 正確數／時間重置
		TypingConsole.readLineWithMessage("按下 Enter 鍵開始遊戲！");
		// 出題數重複
		for (int i = 0; i < questions; i ++) {
			// 字請求處理
			boolean result = performTypingRequestProcess(i);
			// 增加正確數
			if (result) {
				corrects ++;
			}
			// 間隔
			TypingConsole.println("");
			TypingConsole.sleep(interval());
		}
		// 結束訊息
		TypingConsole.println("遊戲結束！");
		TypingConsole.println("");
		// 顯示結果
		showResults();
	}
	
	/**
	 * 要求打字。
	 * 
	 * <pre>
	 *   進行打字要求，並返回用戶的輸入字串。
	 *   此方法的輸入等待時間將被計算為打字時間。
	 * </pre>
	 * 
	 * @param target 打字目標單詞
	 * @return String 輸入字串
	 */
	protected final String requestTyping(String target) {
		// 顯示打字目標單詞
		TypingConsole.println(target);
		// 計時用時間戳
		long temp = System.currentTimeMillis();
		// 接受輸入
		String input = TypingConsole.readLine();
		// 增加計時時間
		typingTime += System.currentTimeMillis() - temp;
		// 返回輸入字串
		return input;
	}
	
	/**
	 * 間隔時間（毫秒）的參考。
	 * @return long 間隔時間（毫秒）
	 */
	protected long interval() {
		// 間隔時間（毫秒）
		return interval;
	}
	
	/**
	 * 獲取出題數。
	 * @return int 出題數
	 */
	public final int getQuestions() {
		// 出題數
		return questions;
	}
	
	/**
	 * 獲取正確數。
	 * @return int 正確數
	 */
	public final int getCorrects() {
		// 正確數
		return corrects;
	}
	
	/**
	 * 獲取打字時間。
	 * @return long 打字時間（毫秒）
	 */
	public final long getTypingTime() {
		// 打字時間（毫秒）
		return typingTime;
	}
}
