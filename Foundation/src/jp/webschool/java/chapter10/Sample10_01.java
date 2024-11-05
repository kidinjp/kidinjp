package jp.webschool.java.chapter10;

public class Sample10_01 {
	/**
	 * 「private」修飾子の効果確認 10_03
	 * @param args
	 */
	public static void main(String[] args) {
		// Machine インスタンスを生成
		Machine m = new Machine();
		// フィールドに値を設定
		m.setSerialNumber("M001");
		// フィールドから値を取得
		System.out.println("型番は " + m.getSerialNumber() + " です");
	}

}
