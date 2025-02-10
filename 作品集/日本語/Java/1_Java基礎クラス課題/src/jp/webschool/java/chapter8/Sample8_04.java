package jp.webschool.java.chapter8;

public class Sample8_04 {
	/**
	 * メソッドの呼び出し 8_13
	 * @param args
	 */
	public static void main(String[] args) {
		// インスタンスを生成
		Machine machine1 = new Machine();
		machine1.setSerialNumber("M001");
		machine1.setHeight(150);
		machine1.setWidth(120);
		machine1.setWeight(98);
		machine1.setProduct("キャンディ（レモン味）");
		machine1.setCapacity(100);

		// インスタンスを生成
		Machine machine2 = new Machine();
		machine2.setSerialNumber("M002");
		machine2.setHeight(140);
		machine2.setWidth(110);
		machine2.setWeight(95);
		machine2.setProduct("キャンディ（リンゴ味）");
		machine2.setCapacity(120);

		// フィールドから値を取得
		machine1.showData();
		machine2.showData();

	}

}
