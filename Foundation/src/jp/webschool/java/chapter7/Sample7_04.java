package jp.webschool.java.chapter7;

public class Sample7_04 {
	/**
	 * 多次元配列の確認 7_13
	 * @param args
	 */
	public static void main(String[] args) {
		// 配列を宣言
		String[] subject = {"英語", "数学", "国語"};
		int[][] test = {{64, 72, 48, 58, 79}, 
						{60, 55, 58, 63, 83},
						{73, 70, 83, 60, 62},
						};
		for (int i = 0; i <test.length; i ++) {
			System.out.print(subject[i] + "：");
			int sum = 0;
			for (int j = 0; j < test[i].length; j++) {
				sum += test[i][j];
				System.out.print((j + 1) + "人目(" + test[i][j] + "点) ");
			}
			System.out.println("平均(" + (sum / test[i].length) + "点)");
		}
	}

}
