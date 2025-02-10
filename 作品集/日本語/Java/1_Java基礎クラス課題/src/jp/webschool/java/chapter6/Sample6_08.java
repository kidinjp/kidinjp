package jp.webschool.java.chapter6;

public class Sample6_08 {
	/**
	 * 課題内容
	 * 「引っ越し業者の料金表を出力するプログラム」を作成します。
	 * この業者は、重さと距離で料金を決めています。
	 * 
	 * 金額は、以下の計算によって算出されます。
	 * ・重さ × 距離 × 50 円
	 * 料金表は、以下の単位で区切られます。
	
	 * ・重さは 20kg から 200kg まで、20kg 単位で 10 段階
	 * ・距離は 10km から 100km まで、10km 単位で 10 段階
	 * 表の各項目間の区切りは、タブ（\t）をうまく使って調整しましょう。
	 * @param args
	 */
	public static void main(String[] args) {
		// 距離
		for (int i = 0; i <= 100; i += 10) {
			// 重さ
			for (int j = 0; j <= 200; j += 20) {
				if (i == 0) {
					System.out.print(j == 0 ? "\t" : j +"kg\t");
				} else {
					System.out.print(j == 0 ? i + "km\t" : (i * j * 50) +"\t");
				}
			}
			System.out.println();
		}

	}

}
