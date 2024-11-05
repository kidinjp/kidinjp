package jp.webschool.java.chapter14;

// import パッケージ名.クラス名(完全修飾名);
// import パッケージ名.インターフェイス名(完全修飾名);
import java.util.ArrayList;

public class Sample14_03 {

	/**
	 * コレクションとジェネリクス
	 * @param args
	 */
	public static void main(String[] args) {
		// ArrayList のインスタンスを生成
		// java.util.ArrayList list = new java.util.ArrayList();
		ArrayList<String> list = new ArrayList<>();
		list.add("りんご");
		list.add("みかん");
		list.add("いちご");

		for (String i : list) {
			System.out.println(i);
		}
		// list.forEach(System.out::println);
	}

}
