package jp.webschool.java.chapter2;

public class Sample2_00 {

	public static void main(String[] args) {
		// プログラム実習(2_01 ~ 2_07の内容です)
		// クラスの命名に対する注文なかったので00としました
		// int luckyNumber = (int) (Math.random() * 10);　でも可では？
		int luckyNumber = (int) Math.floor(Math.random() * 10);
		System.out.println("今日のラッキーナンバーは " + luckyNumber + " です");
		if (luckyNumber <= 3) {
			System.out.println("今日は焦らずにゆっくり過ごしましょう。");
		} else if (luckyNumber >= 4 && luckyNumber <= 6) {
			System.out.println("今日は普通の１日です。");
		} else {
			System.out.println("今日はとても好調です！ 元気に過ごしましょう！");
		}

	}

}
