package jp.webschool.java.chapter13;

/**
 * 役者関連の例外クラス
 */
public class ActorException extends Exception {
//public class ActorException extends RuntimeException {

	/**
	 * コンストラクタ
	 * @param message 例外メッセージ
	 */
	public ActorException(String message) {
		super(message);
	}
}
