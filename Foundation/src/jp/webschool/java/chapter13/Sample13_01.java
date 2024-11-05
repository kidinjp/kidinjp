package jp.webschool.java.chapter13;

public class Sample13_01 {

	/**
	 * 例外の確認 13_01
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
			//配列を初期化
			array = new int[5];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("配列要素を指定するインデックスが不正です。");
		} catch (Exception e) {
			System.out.println("そのほかの例外が発生しました。");
		} finally {
			System.out.println("配列要素への値の代入処理が終了しました。");
		}

		// 内容出力
		for (int a : array) {
			System.out.println(a);
		}
	}

}
