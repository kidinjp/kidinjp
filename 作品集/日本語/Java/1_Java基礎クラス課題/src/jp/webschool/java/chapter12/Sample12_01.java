package jp.webschool.java.chapter12;

public class Sample12_01 {

	/**
	 * 抽象クラスを継承した具象クラスのインスタンス化 12_4
	 * @param args
	 */
	public static void main(String[] args) {
		// インスタンスを生成
		MaleActor ma = new MaleActor();
		Actress ae = new Actress();
		ChildActor ca = new ChildActor();

		// メソッド呼び出し
		ma.act();
		ma.hello("こんにちは");
		ae.act();
		ae.hello("こんにちは");
		ca.act();
		ca.hello("こんにちは");

	}
}
