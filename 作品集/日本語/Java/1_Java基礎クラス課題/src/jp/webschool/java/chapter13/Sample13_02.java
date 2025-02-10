package jp.webschool.java.chapter13;

public class Sample13_02 {

	/**
	 * 例外情報の出力 13_06
	 * @param args
	 */
	public static void main(String[] args) {
		// 配列を宣言
		int[] array = new int[5];
		// 例外処理
		try {
			// 配列要素に値を代入
			array[0] = 100;
			array[1] = 200;
			array[20] = 300;
			array[3] = 400;
			array[4] = 500;
			// メッセージ出力
			System.out.println("配列要素への値の代入が完了しました。");
		} catch (NullPointerException e) {
			System.out.println("配列 array が null の可能性があります。");
			System.out.println("発生した例外の種類は " + e + " です。");
			e.printStackTrace(); // 発生した例外の種類　および　例外が発生した場所
			//配列を初期化
			array = new int[5];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("配列要素を指定するインデックスが不正です。");
			System.out.println("発生した例外の種類は " + e + " です。");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("そのほかの例外が発生しました。");
			//			System.out.println("発生した例外の種類は " + e + " です。");
			e.printStackTrace();
		} finally {
			System.out.println("配列要素への値の代入処理が終了しました。");
		}

		// 内容出力
		for (int a : array) {
			System.out.println(a);
		}
	}

}
