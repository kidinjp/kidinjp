package jp.webschool.java.chapter12;

/**
 * 男性俳優クラス
 */
public class MaleActor extends Actor implements Entertainer{
	/**
	 * 挨拶の返事を返します。
	 * @return String 挨拶の返事メッセージ
	 */
	@Override
	protected String getHelloResponse() {
		return "やあ、よろしく！";
	}

	/**
	 * 演技します。
	 */
	@Override
	public void act() {
		System.out.println("(男性俳優の演技です)");
		System.out.println("ダイナミックな演技で沸かせます！");
	}
	
	/**
	 * 出演先を探します。
	 */
	@Override
	public void search() {
		System.out.println("人気と実力で仕事が決まります。");
	}
}
