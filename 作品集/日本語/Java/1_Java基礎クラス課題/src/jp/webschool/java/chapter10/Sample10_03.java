package jp.webschool.java.chapter10;

public class Sample10_03 {

	/**
	 * オーバーロードしたメソッドの利用 10_07
	 * @param args
	 */
	public static void main(String[] args) {
		// Machine インスタンスを生成
		Machine m = new Machine();
		// 引数が1つの setAttributes メソッド
		m.setAttributes("テスト1号");
		m.showData();
		// 引数が3つの setAttributes メソッド
		m.setAttributes("テスト2号", 150, 30);
		m.showData();
		// 引数が6つの setAttributes メソッド
		m.setAttributes("テスト3号", 200, 50, 30, "サンプル", 10);
		m.showData();
	}

}
