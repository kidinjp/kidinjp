package jp.webschool.java.chapter14;

// import パッケージ名.クラス名(完全修飾名);
// import パッケージ名.インターフェイス名(完全修飾名);
import java.util.ArrayList;

public class Sample14_01 {

	/**
	 * ArrayList の利用 14_2
	 * @param args
	 */
	public static void main(String[] args) {
		// ArrayList のインスタンスを生成
		// java.util.ArrayList list = new java.util.ArrayList();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 101; i++) {
			if (i % 14 == 0) {
				list.add(i);
			}
		}
		
		list.forEach(System.out::println);
	}

}
