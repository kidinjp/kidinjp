package jp.webschool.java.chapter4;

public class Sample4_03 {
	/**
	 * 複合代入演算子 4_05
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 15;
		int b = -7;
		int sum = 0;
		// a を足し込み
		sum += a;
		System.out.println(sum);
		// b を足し込み
		sum += b;
		System.out.println(sum);
		// 100 を足し込み
		sum += 100;
		System.out.println(sum);
		// 「-=」「*=」「/=」「%=」の動きも試してみましょう。
		sum -= 28;
		System.out.println(sum);
		sum *= 5;
		System.out.println(sum);
		sum /= 10;
		System.out.println(sum);
		sum %= 3;
		System.out.println(sum);
	}

}
