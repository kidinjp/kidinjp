package jp.webschool.java.chapter6;

public class Sample6_05 {
	/**
	 * 繰り返し処理（break 文） 6_09
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			// ２桁のランダムな整数
			int num = (int) (Math.random() * 100);
			// １０の倍数判断
			if (num % 10 == 0) {
				System.out.println(num + " キリの良い数が当たりました！");
				break;
			}
			System.out.println(num);
		}
	}

}
