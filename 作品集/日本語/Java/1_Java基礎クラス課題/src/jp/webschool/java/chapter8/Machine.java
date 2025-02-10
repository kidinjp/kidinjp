package jp.webschool.java.chapter8;

/**
 * アメを製造する機械 クラス
 */
public class Machine {
	/** 型番 */
	String serialNumber;
	/** 高さ（単位：cm） */
	int height;
	/** 幅（単位：cm） */
	int width;
	/** 重さ（単位：kg） */
	int weight;
	/** 生産物 */
	String product;
	/** 生産能力（１分間あたりの個数） */
	int capacity;

	/**
	 * このクラスの情報を出力します。
	 */
	void show() {
		System.out.println("------------------------------------");
		System.out.println("型番は " + serialNumber + " です");
		System.out.println("高さは " + height + " です");
		System.out.println("幅は " + width + " です");
		System.out.println("重さは " + weight + " です");
		System.out.println("生産物は " + product + " です");
		System.out.println("生産能力は 1 分間あたり " + capacity + " 個です");
		System.out.println("------------------------------------");
	}

	/**
	 * 機械の情報を表示します。
	 */
	void showData() {
		System.out.println("機械の情報を表示します。");
		show();
		System.out.println();
	}

	/**
	 * 型番を設定します。
	 * @param s 型番
	 */	
	void setSerialNumber(String s) {
		serialNumber = s;
	}

	/**
	 * 高さ（単位：cm）を設定します。
	 * @param h 高さ（単位：cm）
	 */
	void setHeight(int h) {
		height = h;
	}
	
	/**
	 * 幅（単位：cm）を設定します。
	 * @param w 幅（単位：cm）
	 */
	void setWidth(int w) {
		width = w;
	}
	
	/**
	 * 重さ（単位：kg）を設定します。
	 * @param w 重さ（単位：kg）
	 */
	void setWeight(int w) {
		weight = w;
	}
	
	/**
	 * 生産物を設定します。
	 * @param p 生産物
	 */
	void setProduct(String p) {
		product = p;
	}
	
	/**
	 * 生産能力（１分間あたりの個数）を設定します。
	 * @param c 生産能力（１分間あたりの個数）
	 */
	void setCapacity(int c) {
		capacity = c;
	}
	
	/**
	 * 属性を一括で設定します。
	 * @param ser 型番
	 * @param hei 高さ（単位：cm）
	 * @param wid 幅（単位：cm）
	 * @param wei 重さ（単位：kg）
	 * @param pro 生産物
	 * @param cap 生産能力（１分間あたりの個数）
	 */
	void setMachine(String s, int h, int w, int W, String p, int c) {
		setSerialNumber(s);
		setHeight(h);
		setWidth(w);
		setWeight(W);
		setProduct(p);
		setCapacity(c);
	}
	
	/**
	 * 材料を混ぜて、結果メッセージを返します。
	 * @param ingredients 材料
	 * @param water 材料（水）
	 * @return String 結果メッセージ
	 */
	String mix(String ingredients, String water) {
		if (ingredients.equals("砂糖") && water.equals("水")) {
			return "ペースト状のアメができました！";
		}
		
		return "アメの材料ではありません。";
	}

	/**
	 * 課題内容
	 * ◆作成メソッド１（mix2 メソッド）
	 * ・新規に mix2 メソッドを定義してください
	 * ・このメソッドは「材料を混ぜて処理結果を返す」という機能を持ちます
	 * @param ・mix メソッドと同じものを定義します
	 * @return ・戻り値の型には boolean を定義します
	 * ・このメソッドの処理は引数として「材料」を受け取り、正しい材料かどうかを判断して作業メッセージを出力してから結果を boolean 値で返却します
	 * ・引数の値が「砂糖」と「水」の場合は「ペースト状のアメができました！」を出力して、戻り値として「true」（成功）を返却します
	 * ・引数の値が上記以外の場合は「アメの材料ではありません。」を出力して、戻り値として「false」（失敗）を返却します
	 * ※処理内容は本章で作成した mix メソッドと似ていますが、メッセージの出力と戻り値が違います
	 * ※mix メソッドは戻り値にメッセージを返却していましたが、mix2 メソッドではメッセージをその場で出力して、戻り値には成功失敗を意味する boolean 値を返却します
	 * ※本来であれば mix2 というメソッド名はあまり良い命名ではありませんが、練習課題のためこのようなメソッド名を指定しています
	 */
	boolean mix2(String ingredients, String water) {
		if (ingredients.equals("砂糖") && water.equals("水")) {
			System.out.println("ペースト状のアメができました！");
			return true;
		}
		
		System.out.println("アメの材料ではありません。");
		return false;
	}

	/**
	 * 	◆作成メソッド２（mold メソッド）
	 * 	・新規に mold メソッドを定義してください
	 * 	・このメソッドは「アメを成型する」という機能を持ちます
	 * 	・引数には、int 型の引数をひとつ定義します
	 * 	・このメソッドに戻り値はありません
	 * 	・このメソッドの処理は引数として「成型するアメの数」を受け取り、「生産物」と「完成予定時間」を出力します
	 * 	・最初に、生成する生産物（product）を出力します（メッセージフォーマット「{生産物} を成型します。」）
	 * 	・次に、完成予定時間を出力します（メッセージフォーマット「約 {完成予定時間} 分後に出来上がります。」）
	 * 	・完成予定時間は、引数の「成型するアメの数」とフィールドの「生産能力（１分間あたりの個数）」で計算できます（おおよその分数で構いません）
	*/
	void  mold(int num) {
		System.out.println(product + " を成型します。");
		System.out.println("約 " + (num / capacity) + " 分後に出来上がります。");
	}
}
