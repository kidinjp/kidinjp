import main.ITypingGame;
import main.TypingGameExtended;

/**
 * 打字遊戲啟動class
 * 
 * <pre>
 *   用來啟動 打字遊戲 的類
 *   
 * </pre>
 */
public class TypingGameRunner {
	/**
	 * 啟動 打字遊戲
	 * @param args 未使用的參數
	 */
	public static void main(String[] args) {
		// 取得 遊戲實例
		ITypingGame game = createNewGameInstance();
		// 遊戲 開始
		game.start();
	}

	/**
	 * 新建遊戲
	 * @return ITypingGame 新的遊戲
	 */
	private static ITypingGame createNewGameInstance() {
		// 新建 遊戲實例
		return new TypingGameExtended(10);
	}
}
