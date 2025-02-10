package jp.webschool.java.chapter5;

public class Sample5_05 {
	/**
	 * 論理演算子の確認 5_09
	 * @param args
	 */
	public static void main(String[] args) {
		// 部屋の情報
		int rent = 60000;
		int roomSize = 11;
		// 論理演算子の確認
		if (rent <= 60000 && roomSize < 10) {
			System.out.println("手頃な良い物件がありそうです");
		} else if (rent >= 60000 && roomSize < 10) {
			System.out.println("その家賃ならもう少し広い部屋がありますよ");
		} else if (rent < 60000 && roomSize >= 10) {
			System.out.println("なかなかそんな好物件はありません");
		} else {
			System.out.println("高級感のある良い物件がありますよ");
		}
	}

}
