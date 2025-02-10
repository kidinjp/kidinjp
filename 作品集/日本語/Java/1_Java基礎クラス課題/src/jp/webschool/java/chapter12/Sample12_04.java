package jp.webschool.java.chapter12;

/*
 *  【課題１】 抽象クラスの継承
 * Animal クラスは動物をあらわす抽象クラスで、Cat クラスは猫をあらわす具象クラスです。
 * 現在のプログラムは、Cat クラスが抜けています。
 * そこで、このプログラムが正常に動作するように Cat クラスを作成してください。
 * 実行結果として、以下のようなメッセージが出力されるように Cat クラスを作成しましょう。
 * また、wakeUp メソッドは引数の値によってメッセージと戻り値が変わります。以下の実行結果から、どのような処理にすれば良いのかを考えて実装しましょう。
 *
 * 実行結果（startDay メソッドに 10 ～ 22 の間の時間を渡した場合）
 * 目を覚ましました。
 * 猫は音を立てずに走ります。
 * どんな生き物も眠ります。
 *
 * 実行結果（startDay メソッドに 10 ～ 22 以外の時間を渡した場合）
 * まだ寝ています。
 *
 * 【課題条件】
 * ・Cat クラスは Animal クラスを継承してください
 * ・Animal クラスと Sample12_04 クラスは変更してはいけません
 * ・Animal クラスと Cat クラス共に、Sample12_04.java ファイル内に記述します
 */

/**
 * 動物クラス
 */
abstract class Animal {
	/**
	 * 目を覚まします。
	 * @param hh 現在の時間（0 時 ～ 24 時）
	 * @return boolean 目を覚ましたら true、寝ていたら false
	 */
	protected abstract boolean wakeUp(int hh);

	/**
	 * 走ります。
	 */
	protected abstract void run();

	/**
	 * 眠ります。
	 */
	protected void sleep() {
		System.out.println("どんな生き物も眠ります。");
	}

	/**
	 * １日を始めます。
	 * @param hh 現在の時間（0 時 ～ 24 時）
	 */
	public final void startDay(int hh) {
		// 目を覚ます
		boolean awake = wakeUp(hh);
		// 目を覚ましたか判断
		if (awake) {
			// 走る
			run();
			// 寝る
			sleep();
		}
	}
}

/**
 * Cat クラス
 */
class Cat extends Animal implements Pet {
	@Override
	protected boolean wakeUp(int hh) {
		if (hh >= 10 && hh <= 22) {
			System.out.println("目を覚ましました。");
			return true;
		}
		System.out.println("まだ寝ています。");
		return false;
	}

	@Override
	protected void run() {
		System.out.println("猫は音を立てずに走ります。");
	}

	@Override
	public void name(String name) {
		System.out.println("名前を「" + name + "」と名付けました。");
	}

	@Override
	public void feed() {
		System.out.println("猫はおいしいごはんがもらえます。");
	}
}

/*
 * 【課題２】 インターフェイスの実装
 * Cat クラスに Pet インターフェイスを実装して、以下の結果メッセージが出力されるようにしてください。
 * 目を覚ましました。
 * 猫は音を立てずに走ります。
 * どんな生き物も眠ります。
 * 名前を「たま」と名付けました。
 * 猫はおいしいごはんがもらえます。
 * 
 * 【課題条件】
 * ・上記指示（Pet インターフェイス、main メソッド）以外に修正するのは Cat クラスのみです
 */

/**
 * ペットインターフェイス
 */
interface Pet {
	/**
	 * 名前を付けます。
	 */
	public void name(String name);

	/**
	 * ごはんをあげます。
	 */
	public void feed();
}

/**
 * 章末問題（抽象クラスとインターフェイス）
 * 【課題１】抽象クラスの継承
 * 【課題２】抽象クラスとインターフェイスの課題プログラム
 */
public class Sample12_04 {
	/**
	 * 抽象クラスとインターフェイスの課題プログラム
	 * @param args
	 */
	public static void main(String[] args) {
		// インスタンスを生成
		Cat cat = new Cat();
		// メソッド呼び出し
		cat.startDay(12);
		cat.name("たま");
		cat.feed();
	}
}