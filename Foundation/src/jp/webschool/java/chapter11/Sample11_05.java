package jp.webschool.java.chapter11;
/*
 * 【課題１】 クラスの継承
 * 課題内容
 * Animal クラスは動物をあらわすクラスで、Cat クラスは猫をあらわすクラスです。
 * 現在のプログラムは、Cat クラスが抜けています。
 * そこで、このプログラムが正常に動作するように Cat クラスを作成してください。
 * 
 * 実行結果として、以下のようなメッセージが出力されるように Cat クラスを作成しましょう。
 * 	動物は呼ばれると返事をします。
 * 	猫は隠れるのが上手です。
 * 
 * 【課題条件】
 * ・Cat クラスは Animal クラスを継承してください
 * ・Animal クラスと Sample11_05 クラスは変更してはいけません
 * ・Animal クラスと Cat クラス共に、Sample11_05.java ファイル内に記述します
 */

/**
 * 動物クラス
 */
class Animal {
	/**
	 * 動物を呼びます。
	 */
	public void call() {
		System.out.println("動物は呼ばれると返事をします。");
	}
}

/**
 * Cat クラス
 */
class Cat extends Animal {
	public void hide() {
		System.out.println("猫は隠れるのが上手です。");
	}
	
	/**
	 * 【課題２】 メソッドのオーバーライド
	 * 課題内容
	 * Cat クラスの機能を変更して、以下の結果メッセージが出力されるようにしてください。
	 * 		猫はにゃーと鳴きます。
	 * 		猫は隠れるのが上手です。
	 * 機能の変更には、メソッドのオーバーライドが利用できそうですね！
	 * 
	 * 【課題条件】
	 * ・修正するのは Cat クラスのみです
	 * ・Animal クラスと Sample11_05 クラスは変更してはいけません
	 */
	public void call() {
		System.out.println("猫はにゃーと鳴きます。");
	}
}

/**
 * 章末問題（継承とオーバーライド）
 */
public class Sample11_05 {
	/**
	 * 継承とオーバーライドの課題プログラム
	 * @param args
	 */
	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.call();
		cat.hide();
	}
}