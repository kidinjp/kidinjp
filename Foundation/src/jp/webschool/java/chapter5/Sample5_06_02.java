package jp.webschool.java.chapter5;

public class Sample5_06_02 {
	/**
	 * 「部屋の広さによって家賃が変わるプログラム」を作成します。
	 *「Sample5_06_01」クラスは、if 文を使ってコーディングしてください
	 * 【条件】
	 * 部屋の広さは変数として宣言し、値を変更できるようにしましょう。
	 * 各条件の部屋の広さは、プログラム固定値で構いません。
	 * さらに、家賃を変数にすることでメッセージをまとめることができそうですね！
	 * @param args
	 */
	public static void main(String[] args) {
		int roonSize = (int) (Math.random() * 6 + 5); // ランダムで 5 - 10 を選ぶ
		int rent = (roonSize - 6) * 5000 + 40000;
		switch (roonSize) {
			case 10:
			case 9:
			case 8:
			case 7:
			case 6:
				System.out.println("家賃は " + rent +  "円以上になります");
				break;
			default:
				System.out.println("一度ご相談ください");
		}

	}

}
