package jp.webschool.java.chapter12;

public class Sample12_03 {

	/**
	 * インターフェイスを実装したクラスの利用 12_09
	 * @param args
	 */
	public static void main(String[] args) {
		// インスタンスを生成
		MaleActor actor1 = new MaleActor();
		// キャストの利用
		Actor actor2 = new MaleActor();
		MaleActor a2 = (MaleActor)actor2;

		Entertainer actor3 = new MaleActor();
		MaleActor a3 = (MaleActor)actor3;
		
		// メソッド呼び出し
		actor1.act();
		actor1.hello("こんにちは");
		actor1.search();
		
		a2.act();
		a2.hello("こんにちは");
		a2.search();

		a3.act();
		a3.hello("こんにちは");
		a3.search();

	}
}
