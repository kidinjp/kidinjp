package jp.webschool.java.chapter14;

import java.util.HashSet;
import java.util.Set;

public class Sample14_05 {

	public static void main(String[] args) {
		// ジェネリクスで型を指定
		Set<Integer> set = new HashSet<>();
		// 値を登録
		set.add(100);
		set.add(200);
		set.add(150);
		set.add(250);
		set.add(200);
		System.out.println(set.isEmpty() ? "要素は空" : "要素あり");
		System.out.println("内容：" + set);
		int[] check = new int[] { 100, 110 };
		for (int target : check) {
			System.out.println(set.contains(target) ? target + " は存在します" : target + " は存在しません");
		}

		set.clear();
		System.out.println(set.isEmpty() ? "要素は空" : "要素あり");
		System.out.println("内容：" + set);
	}

}
