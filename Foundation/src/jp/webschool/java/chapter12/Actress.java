package jp.webschool.java.chapter12;

/**
 * 子役俳優クラス
 */
public class Actress extends Actor {
	/**
	 * 挨拶の返事を返します。
	 * @return String 挨拶の返事メッセージ
	 */
	@Override
	protected String getHelloResponse() {
		return "こんにちは！";
	}

	/**
	 * 演技します。
	 */
	@Override
	public void act() {
		System.out.println("(子役俳優の演技です)");
		System.out.println("可愛らしい演技に釘付けます！");
	}
}
