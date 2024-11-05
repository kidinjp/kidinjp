package jp.webschool.java.chapter8;

public class Sample8_06 {
	/**
	 * メソッドの呼び出し 8_16
	 * @param args
	 */
	public static void main(String[] args) {
		// インスタンスを生成
		Machine machine1 = new Machine();
		machine1.setMachine("M001", 150, 120, 98, "キャンディ（レモン味）", 100);

		// インスタンスを生成
		Machine machine2 = new Machine();
		machine2.setMachine("M002", 140, 110, 98, "キャンディ（リンゴ味）", 120);

		// フィールドから値を取得
		//machine1.showData();
		//machine2.showData();

		System.out.println(machine1.mix("砂糖", "水"));
		System.out.println(machine2.mix("塩", "油"));
	}

}
