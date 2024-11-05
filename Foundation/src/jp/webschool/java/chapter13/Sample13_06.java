package jp.webschool.java.chapter13;

/**
 * Ａ例外（検査例外）
 */
class AException extends Exception {
	/**
	 * コンストラクタ
	 * @param value 値
	 */
	public AException(int value) {
		super(value + " が渡されました");
	}
}

/**
 * Ｂ例外（非検査例外）
 */
class BException extends RuntimeException {
	/**
	 * コンストラクタ
	 * @param value 値
	 */
	public BException(int value) {
		super(value + " が渡されました");
	}
}

/**
 * 章末問題（例外の送出）
 */
public class Sample13_06 {
	/**
	 * 例外送出の課題プログラム
	 * @param args
	 */
	public static void main(String[] args) {
		// 配列を宣言
		int[] values = new int[] { -1, 0, 100 };
		// 配列を繰り返し
		for (int value : values) {
			try {
				System.out.println("チェック呼び出し：" + value);
				// 値をチェック
				int result = check(value);
				// 結果出力
				System.out.println("正常結果：" + result);
			} catch (AException e) {
				System.out.println("AException をキャッチしました");
				e.printStackTrace();
			} catch (BException e) {
				System.out.println("BException をキャッチしました");
				e.printStackTrace();
			} finally {
				System.out.println();
			}
		}
	}

	/**
	 * 値をチェックします。
	 * @param value チェックする値
	 * @return int チェックした値
	 */
	private static int check(int value) throws AException {
		// 【条件】必要に応じて、このメソッドの宣言部分を修正する
		// 【条件】このメソッド内では try - catch を実装しないこと

		// 引数の値がマイナスだったら AException をスローする
		if (value < 0) {
			// ここで、AException をスローする
			throw new AException(value);
		}
		// 引数の値がゼロだったら BException をスローする
		if (value == 0) {
			// ここで、BException をスローする
			throw new BException(value);
		}
		// 結果返却
		return value;
	}
}