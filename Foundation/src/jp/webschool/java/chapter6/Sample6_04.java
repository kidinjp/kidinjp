package jp.webschool.java.chapter6;

public class Sample6_04 {
	/**
	 * 「九九表を出力する」プログラム 6_08
	 * @param args
	 */
	public static void main(String[] args) {
		// 外側のループ（九九の段）
		for (int i = 1; i < 10; i++) {
			// 内側のループ（段の×１～９）
			for (int j = 1; j < 10; j++) {
				// 掛け算を出力。「\t」はタブを表します。
				System.out.print("[" + i + " × " + j + " = " + (i * j) + "]\t");
			}
			System.out.println();
		}
	}

}
