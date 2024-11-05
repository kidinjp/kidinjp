package jp.webschool.java.chapter8;

public class Sample8_01 {
	/**
	 * インスタンスの生成 8_4
	 * @param args
	 */
	public static void main(String[] args) {
		// インスタンスを生成
		Machine machine1 = new Machine();
		Machine machine2 = new Machine();
		Machine machine3 = machine1;
		machine1.serialNumber = "M001";
		machine1.height = 150;
		machine1.width = 120;
		machine1.weight = 98;
		machine1.product = "キャンディ（レモン味）";
		machine1.capacity = 100;
		machine1.capacity = 200;
		machine1.capacity = 300;

		// フィールドから値を取得
		machine1.show();
		System.out.println("--------------");
		machine2.show();
		System.out.println("--------------");
		machine3.show();

	}

}
