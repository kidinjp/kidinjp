package jp.webschool.java.chapter12;

public class Sample12_02 {

	/**
	 * 抽象クラスを継承した具象クラスのインスタンス化 12_5
	 * @param args
	 */
	public static void main(String[] args) {
		// インスタンスを生成
		Actor[] actors = { new MaleActor(), new Actress(), new ChildActor() };

		// メソッド呼び出し
		for (Actor a : actors) {
			a.act();
			a.hello("こんにちは");
		}

	}
}
