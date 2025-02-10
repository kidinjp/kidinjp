package jp.webschool.java.chapter5;

public class Sample5_07 {
	/**
	 * 「中間試験と期末試験の点数によって、その学期の成績を出力するプログラム」を作成します。
	 * また、今回は if 文をネストせずに論理演算子を使ったプログラムにしてください。
	 * @param args
	 */
	public static void main(String[] args) {
		int chuukann = (int) (Math.random() * 101); // 中間試験、0 - 100まで
		int kimatsu = (int) (Math.random() * 101); // 期末試験、0 - 100まで
		int hyouka = 0;
		if (chuukann < 50 && kimatsu < 50) {
			hyouka = 1;
		} else if (chuukann >= 50 && chuukann <= 70 &&
				kimatsu < 50) {
			hyouka = 2;
		} else if (chuukann > 70 &&
				kimatsu < 50) {
			hyouka = 3;
		} else if (chuukann < 50 &&
				kimatsu >= 50 && kimatsu <= 70) {
			hyouka = 2;
		} else if (chuukann >= 50 && chuukann <= 70 &&
				kimatsu >= 50 && kimatsu <= 70) {
			hyouka = 3;
		} else if (chuukann > 70 &&
				kimatsu >= 50 && kimatsu <= 70) {
			hyouka = 4;
		} else if (chuukann < 50 &&
				kimatsu > 70) {
			hyouka = 4;
		} else if (chuukann >= 50 && chuukann <= 70 &&
				kimatsu > 70) {
			hyouka = 5;
		} else if (chuukann > 70 &&
				kimatsu > 70) {
			hyouka = 5;
		}

		System.out.println(hyouka);
	}

}
