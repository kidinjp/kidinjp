package jp.webschool.java.chapter8;

public class Sample8_03 {
	/**
	 * メソッドの呼び出し 8_10
	 * @param args
	 */
	public static void main(String[] args) {
		// インスタンスを生成
		Machine machine1 = new Machine();
		machine1.serialNumber = "M001";
		machine1.height = 150;
		machine1.width = 120;
		machine1.weight = 98;
		machine1.product = "キャンディ（レモン味）";
		machine1.capacity = 100;

		// インスタンスを生成
		Machine machine2 = new Machine();
		machine2.serialNumber = "M002";
		machine2.height = 140;
		machine2.width = 110;
		machine2.weight = 95;
		machine2.product = "キャンディ（リンゴ味）";
		machine2.capacity = 120;

		// フィールドから値を取得
		machine1.showData();
		machine2.showData();
		
		
	}

}
