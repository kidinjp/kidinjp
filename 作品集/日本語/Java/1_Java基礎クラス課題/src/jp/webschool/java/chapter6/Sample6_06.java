package jp.webschool.java.chapter6;

public class Sample6_06 {
	/**
	 * 繰り返し処理（continue 文） 6_10
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			// ２桁のランダムな整数
			int num = (int) (Math.random() * 100);
			if (num < 10) {
				System.out.println(" " + num + " なので評価せずに次に進みます。");
				continue;
			}

			if (num % 10 == 0) {
				System.out.println(num + " キリの良い数が当たりました！");
				break;
			}
			System.out.println(num);
		}
	}

}
