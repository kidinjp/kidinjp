package jp.webschool.java.chapter5;

public class Sample5_04 {
	/**
	 * 「switch 文」の確認 5_08
	 * 「式に一致した case から処理を開始して、break になるか switch ブロックの最後に到達するまで処理を続ける」
	 * @param args
	 */
	public static void main(String[] args) {
		// 天気を数値で表現（1:晴れ、2:曇り、3:雨）
		int weather = 2;
		// 「switch 文」の確認１（基本形）
		switch (weather) {
			case 1:
				System.out.println("今日は晴れです。");
				System.out.println("ピクニックに行きましょう！");
				break;
			case 2:
				System.out.println("今日は曇りです。");
				System.out.println("映画館に行きましょう！");
				break;
			case 3:
				System.out.println("今日は雨です。");
				System.out.println("家でゆっくり過ごしましょう。");
				break;
			default:
				System.out.println("正しい数値を入力してください。");
		}
		
		// 「switch 文」の確認２（break テスト）
		switch (weather) {
			case 1:
				System.out.println("今日は洗濯日和です！");
				break;
			case 2:
			case 3:
				System.out.println("あまり良い天気ではありません。");	// 2 と 3 の時に出力される
			default:
				System.out.println("洗濯は明日にしましょう。");		// 2 と 3 の時に出力される
		}
	}

}
