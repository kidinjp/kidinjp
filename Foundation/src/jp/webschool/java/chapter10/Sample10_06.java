package jp.webschool.java.chapter10;

public class Sample10_06 {

	/**
	 * クラスメンバの確認 10_10
	 * @param args
	 */
	public static void main(String[] args) {
		// クラスメンバの確認（インスタンスを生成せずにアクセス）
		Shop.name = "お花屋さん";
		Shop.showTotal();

		// クラスメンバとインスタンスメンバの確認
		// 上野支店
		Shop s1 = new Shop("上野支店");
		s1.visit(2);
		s1.visit(3);
		s1.visit(1);
		// 池袋支店
		Shop s2 = new Shop("池袋支店");
		s2.visit(1);
		s2.visit(4);
		s2.visit(2);
		// 店舗情報表示
		s1.show();
		s2.show();
		// 全店情報表示
		Shop.showTotal();
		test(null);
	}

	// NullPointerException が発生する可能性あるため if で回避
	public static void test(Machine m) {
		if (m != null) {
			m.showData();
		}
	}

}
