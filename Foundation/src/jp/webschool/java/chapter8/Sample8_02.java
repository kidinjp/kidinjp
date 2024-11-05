package jp.webschool.java.chapter8;

/**
 * アメを製造する機械 クラス 8_8
 */
class MachineTest {
	/** 型番 */
	String serialNumber;
	/** 高さ（単位：cm） */
	int height;
	/** 幅（単位：cm） */
	int width;
	/** 重さ（単位：kg） */
	int weight;
	/** 生産物 */
	String product;
	/** 生産能力（１分間あたりの個数） */
	int capacity;

	public void printOut(String name) {
		System.out.println("--------------");
		System.out.println(name + " の型番は " + serialNumber + " です");
		System.out.println(name + " の高さは " + height + " です");
		System.out.println(name + " の幅は " + width + " です");
		System.out.println(name + " の重さは " + weight + " です");
		System.out.println(name + " の生産物は " + product + " です");
		System.out.println(name + " の生産能力は " + capacity + " です");

	}
}

public class Sample8_02 {
	/**
	 * インスタンスの生成
	 * @param args
	 */
	public static void main(String[] args) {
		// [machine1] MachineTest インスタンスを生成
		MachineTest machine1 = new MachineTest();
		machine1.serialNumber = "M001";
		machine1.height = 150;
		machine1.width = 120;
		machine1.weight = 98;
		machine1.product = "キャンディ（レモン味）";
		machine1.capacity = 100;

		// [machine1] MachineTest インスタンスを生成
		MachineTest machine2 = new MachineTest();
		machine2.serialNumber = "M002";
		machine2.height = 140;
		machine2.width = 110;
		machine2.weight = 95;
		machine2.product = "キャンディ（リンゴ味）";
		machine2.capacity = 120;

		// フィールドから値を取得
		machine1.printOut("machine1");
		machine2.printOut("machine2");
		
	}

}
