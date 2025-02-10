package jp.webschool.java.chapter8;

public class Sample8_07 {
	/**
	 * 【課題】 「アメを製造する機械」クラスの改修
	 * 
	 * ◆作成メソッド（main メソッド）
	 * ・Machine クラスのインスタンスをひとつ生成します
	 * ・生成したインスタンスに対して、 setAttributes メソッドで属性を一括設定します（各値は任意）
	 * ・属性設定後、mix2 メソッドを呼び出して結果を取得します
	 * ・取得した結果が成功の場合は、mold メソッドを呼び出します（値は任意）
	 * ・取得した結果が失敗の場合は、なにも処理せずに終了します
	 * @param args
	 */
	public static void main(String[] args) {
		Machine machine1 = new Machine();
		machine1.setMachine("M001", 150, 120, 98, "キャンディ（レモン味）", 100);
		if (machine1.mix2("砂糖", "水")) {
			machine1.mold(500);
		}
	}

}
