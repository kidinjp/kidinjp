package com.fs.tic.typing_game;

import com.fs.tic.typing_game.main.ITypingGame;
import com.fs.tic.typing_game.main.TypingGameExtended;

/**
 * タイピングゲーム起動クラス
 * 
 * <pre>
 *   タイピンゲームを起動するためのクラスです。
 *   
 *   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *   [課題の注意点]
 *     新規クラス以外で修正が許可されているのは
 *     このクラスのみです
 *   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * </pre>
 */
public class TypingGameRunner {
	/**
	 * タイピングゲームを起動します。
	 * @param args 未使用パラメータ
	 */
	public static void main(String[] args) {
		// ゲームインスタンスを取得
		ITypingGame game = createNewGameInstance();
		// ゲーム開始
		game.start();
	}

	/**
	 * 新規ゲームを生成します。
	 * @return ITypingGame 新規ゲーム
	 */
	private static ITypingGame createNewGameInstance() {
		// 新規ゲームインスタンスを生成
		return new TypingGameExtended(10);
	}
}
