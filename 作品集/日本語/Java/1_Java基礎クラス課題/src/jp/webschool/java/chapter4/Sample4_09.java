package jp.webschool.java.chapter4;

public class Sample4_09 {
	/**
	 * 同じ型の変数同士の演算 4_12
	 * ・基本的には大きな型に合わせられる
	 * ・「int 型」以下同士の演算では、「int 型」に変換される
	 * （１）．「変数 a」「変数 b」の双方が「int 型」より小さい型の場合、演算結果は「int 型」になる
	 * （２）．「変数 a」「変数 b」のどちらか一方が「double 型」の場合、演算結果は「double 型」になる
	 * （３）．（２）以外で、「変数 a」「変数 b」のどちらか一方が「float 型」の場合、演算結果は「float 型」になる
	 * （４）．（２）（３）以外で、「変数 a」「変数 b」のどちらか一方が「long 型」の場合、演算結果は「long 型」になる
	 * （５）．（２）（３）（４）以外の場合、演算結果は「int 型」になる

	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 同じ型の変数を宣言
		int inum1 = 10;
		int inum2 = 4;
		// 同じ型の変数で演算(変数に代入)
		double dnum = inum1 / inum2;
		System.out.println(inum1 + " メートルの " + inum2 + " 分の 1 は " + dnum + " メートルです");
		// 同じ型の変数で演算(直接)
		System.out.println(inum1 + " メートルの " + inum2 + " 分の 1 は " + (inum1 / inum2) + " メートルです");
	}

}
