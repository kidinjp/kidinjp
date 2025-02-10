package jp.webschool.java.chapter4;

public class Sample4_04 {
	/**
	 * ビット演算子 4_06
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 50;
		int b = 60;
		// ビット演算子のテスト
		System.out.println("[a] " + a);
		System.out.println("[b] " + b);
		System.out.println("[a & b] " + (a & b)); // a と b の論理積（AND）
		System.out.println("[a | b] " + (a | b)); // a と b の論理和（OR）
		System.out.println("[a ^ b] " + (a ^ b)); // a と b の排他的論理和（XOR）
		System.out.println("[~a] " + (~a)); // a のビット反転（NOT）
		System.out.println("[a << 2] " + (a << 2)); // a を左へ n ビットシフト	
		System.out.println("[a >> 3] " + (a >> 3)); // a を右へ n ビットシフト（算術シフト）
		System.out.println("[a >>> 3] " + (a >>> 3));

	}

}
