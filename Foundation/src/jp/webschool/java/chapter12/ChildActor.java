package jp.webschool.java.chapter12;

/**
 * 女性俳優クラス
 */
public class ChildActor extends Actor {
	/**
	 * 挨拶の返事を返します。
	 * @return String 挨拶の返事メッセージ
	 */
	@Override
	protected String getHelloResponse() {
		return "ごきげんよう";
	}

	/**
	 * 演技します。
	 */
	@Override
	public void act() {
		System.out.println("(女性俳優の演技です)");
		System.out.println("華やかな演技で魅せます！");
	}
}
