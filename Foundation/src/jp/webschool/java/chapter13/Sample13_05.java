package jp.webschool.java.chapter13;

/**
 * 章末問題（例外処理）
 */
public class Sample13_05 {
/*
 * 【課題１】 例外処理
 * このプログラムは、このままでは例外が発生して処理が異常終了します。
 * プログラムを、以下のように修正してください。
 * ・例外が発生した場合に「指定されたインデックスは配列の範囲外です」というメッセージを出力
 * ・この処理での例外発生の有無に関わらず、必ず最後に「処理が終了しました」というメッセージを出力
 * この際、発生する例外の種類を限定しても広く受け取ってもどちらでも構いません。
 * ただし、最後の終了メッセージについてはどんな例外が発生しても必ず出力してください。
 */
	/**
	 * 例外処理の課題プログラム
	 * @param args
	 */
	public static void main(String[] args) {
		// 配列を宣言
		String[] animal = {"こぶた", "たぬき", "きつね", "ねこ"};
		try {
			// 配列要素を出力
			System.out.println(animal[0]);
			System.out.println(animal[3]);
			System.out.println(animal[5]);
		} catch (Exception e) {
			System.out.println("指定されたインデックスは配列の範囲外です");
		} finally {
			System.out.println("処理が終了しました");
		}
	}
}