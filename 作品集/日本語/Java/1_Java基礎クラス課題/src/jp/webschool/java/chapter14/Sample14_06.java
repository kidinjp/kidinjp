package jp.webschool.java.chapter14;

import java.util.HashMap;
import java.util.Map;

public class Sample14_06 {

	public static void main(String[] args) {
		// ジェネリクスで型を指定
		Map<Integer, String> map = new HashMap<>();
		// 値を登録
		map.put(100, "あいうえお");
		map.put(200, "かきくけこ");
		map.put(300, "さしすせそ");
		map.put(200, "ABCDEFG");
		map.put(400, "あいうえお");
		System.out.println(map.isEmpty() ? "要素は空" : "要素あり");
		System.out.println("内容：" + map);
		int[] check = new int[] { 100, 110 };
		for (int target : check) {
			System.out.println(map.containsKey(target) ? target + " は存在します" : target + " は存在しません");
		}

		map.clear();
		System.out.println(map.isEmpty() ? "要素は空" : "要素あり");
		System.out.println("内容：" + map);
	}

}
