package jp.webschool.java.chapter12;

/**
 * 役者クラス 12_2
 */
public abstract class Actor {
	/**
	 * 挨拶の返事を返します。
	 * @return
	 */
	protected abstract String getHelloResponse();

	/**
	 * 演技します。
	 */
	public abstract void act();

	/**
	 * 挨拶します。
	 * @param message　挨拶メッセージ
	 */
	public final void hello(String message) {
		System.out.println(message + " → " + getHelloResponse());
	}
}
