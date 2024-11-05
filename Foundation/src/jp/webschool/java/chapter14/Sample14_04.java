package jp.webschool.java.chapter14;

import java.util.ArrayList;
import java.util.List;

public class Sample14_04 {

	/**
	 * 14_08
	 * @param args
	 */
	public static void main(String[] args) {
		// ジェネリクスで型を指定
		List<Integer> list = new ArrayList<>();
		// 値を登録
		list.add(100);
		list.add(200);
		list.add(150);
		list.add(250);
		list.add(200);
		System.out.println(list.isEmpty() ? "要素は空" : "要素あり");
		System.out.println("内容：" + list);
		int[] check = new int[] { 100, 110 };
		for (int target : check) {
			System.out.println(list.contains(target) ? target + " は存在します" : target + " は存在しません");
		}

		list.clear();
		System.out.println(list.isEmpty() ? "要素は空" : "要素あり");
		System.out.println("内容：" + list);
	}

}
