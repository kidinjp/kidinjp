package jp.webschool.java.chapter7;

public class Sample7_03 {
	/**
	 * 「参照型変数の代入」の確認 7_09
	 * 【ディープコピーとシャローコピー】
	 * ここで学習したような、参照型の変数に代入するようなコピー方法のことをシャローコピー（浅いコピー）といいます。
	 * シャローコピーはデータの実体のコピーは行わず、参照だけをコピーします。
	 * それとは別に、ディープコピー（深いコピー）というものがあります。
	 * ディープコピーは、データの実体を複製するコピーです。
	 * ディープコピーの方法はひとつではなく、状況に応じて様々な方法があります。
	 * これはこの先の学習を進める中で、少しずつ知って行きましょう。
	 * @param args
	 */	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		int[] b = a;
		a[0] = 100;
		b[2] = 300;
		System.out.println("[配列 a]");
		for (int i: a) {
			System.out.println(i);
		}
		System.out.println("[配列 b]");
		for (int i: b) {
			System.out.println(i);
		}

	}

}
