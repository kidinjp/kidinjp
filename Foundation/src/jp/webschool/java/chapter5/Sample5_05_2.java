package jp.webschool.java.chapter5;

public class Sample5_05_2 {
	/**
	 * 論理演算子の確認（論理演算子を使わない場合）
	 * 一般的には深すぎるネストは嫌われる傾向にあります。
	 * @param args
	 */
	public static void main(String[] args) {
		// 部屋の情報
		int rent = 60000; // 家賃
		int roomSize = 11; // 部屋の広さ（何畳）
		// 論理演算子を使わない場合（if 文のネスト）
		if (rent < 60000) {
			if (roomSize < 10) {
				System.out.println("手頃な良い物件がありそうです");
			} else {
				System.out.println("なかなかそんな好物件はありません");
			}
		} else {
			if (roomSize < 10) {
				System.out.println("その家賃ならもう少し広い部屋がありますよ");
			} else {
				System.out.println("高級感のある良い物件がありますよ");
			}
		}
	}

}
