package jp.webschool.java.chapter11;

public class Sample11_01 {
	/**
	 * 継承したクラスの利用 11_03
	 * @param args
	 */
	public static void main(String[] args) {
		// インスタンスを生成
		ChocolateMachine m = new ChocolateMachine("C001", 200, 250, 200, "チョコレート", 50);
		// 属性の一括設定
//		m.setAttributes("C001", 200, 250, 200, "チョコレート", 50);
		// 情報表示
		m.showDate();
		// チョコレートを温める
		m.warm(50);
	}

}
