package jp.webschool.java.chapter7;

public class Sample7_05 {
	/**
	 * 課題内容
	 * 「テスト成績表として、点数一覧を出力するプログラム」を作成します。
	 * 以下の点数表をもとに、一覧表を作成して表示してください。
	 * また、各科目の全体平均点もそれぞれ算出して表示しましょう。
	 * 【条件】
	 * この課題では、以下の条件に従ってプログラムを作成してください。
	 * ・点数一覧は、提示された二次元配列【英語、数学、国語の点数表（５人分）】を使用する
	 * ・配列の要素数に関する値は固定リテラルではなく、「配列の長さ（配列の要素数）」を使用する
	 * @param args
	 */
	public static void main(String[] args) {
		// 【英語、数学、国語の点数表（５人分）】
		int[][] test = {
				{64, 60, 73}, 
				{72, 55, 70}, 
				{48, 58, 83}, 
				{58, 63, 60}, 
				{79, 83, 62}
			};

		// 見出しの出力
		String[] subject = {"英語", "数学", "国語"};
		System.out.print("\t\t");	// 【出力フォーマット】では二か分のタブがありますため\t二回
		for (String i: subject) {
			System.out.print(i + "\t");
		}
		System.out.println();
		

		// 成績の出力
		int[] total = new int[3];
 		for (int i = 0; i < test.length; i++) {
 			System.out.print((i + 1) + "人目：\t");
			for (int j = 0; j < test[i].length; j++) {
	 			System.out.print(test[i][j] + "点\t");				
	 			total[j] += test[i][j];
			}
			System.out.println();
		}
 		System.out.println("----------------------------");

 		// 平均の出力
		System.out.print(" 平均：\t");
		for (int i: total) {
			System.out.print((i / test.length) + "点\t");
		}
	}

}
