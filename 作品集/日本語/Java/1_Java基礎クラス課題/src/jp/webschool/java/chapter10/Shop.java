package jp.webschool.java.chapter10;

/**
 * インスタンスメンバ同士は、お互いに直接アクセスすることができる
 * クラスメンバ同士は、お互いに直接アクセスすることができる
 * インスタンスメンバからは、クラスメンバに直接アクセスすることができる
 * 
 * クラスメンバからは、インスタンスメンバに直接アクセスすることはできない
 * 
 * 「static メンバ」から「非 static メンバ」に直接アクセスできない（this使えない）
 * お店クラス
 */
public class Shop {

	public static String name = "専門店";
	/**	来店人数（全店合計）*/
	private static int total = 0;

	/** 支店名 */
	private String branch;
	/** 支店人数（店舗） インスタンスメンバ*/
	private int visitors = 0;

	/**
	 * コントラスト
	 */
	public Shop(String branch) {
		this.branch = branch;
	}

	/**
	 * インスタンスメソッド
	 * 来店処理です
	 * @param num 来店人数
	 */
	public void visit(int num) {
		// 来店人数（店舗）
		visitors += num;
		// 来店人数（全店合計）
		total += num;
	}

	/**
	 * 店舗の情報を表示します。
	 */
	public void show() {
		System.out.println("[" + name + "(" + branch + ")] " + visitors + " 名様");
	}

	/**
	 * クラスメソッド
	 * 全店の情報を表示します。
	 */
	public static void showTotal() {
		System.out.println("[" + name + "(全店合計)] " + total + " 名様");
		// System.out.println(visitors);
		// show();
	}
}
