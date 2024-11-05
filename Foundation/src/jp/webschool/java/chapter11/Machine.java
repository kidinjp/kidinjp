package jp.webschool.java.chapter11;

/**
 * アメを製造する機械 クラス
 */
public class Machine {
	/** 型番 */
	private String serialNumber;
	/** 高さ（単位：cm） */
	private int height;
	/** 幅（単位：cm） */
	private int width;
	/** 重さ（単位：kg） */
	private int weight;
	/** 生産物 */
	private String product;
	/** 生産能力（１分間あたりの個数） */
	private int capacity;

	/**
	 * このクラスの情報を出力します。
	 */
	void show() {
		System.out.println("------------------------------------");
		System.out.println("型番は " + serialNumber + " です");
		System.out.println("高さは " + height + "cm です");
		System.out.println("幅は " + width + "kg です");
		System.out.println("重さは " + weight + " です");
		System.out.println("生産物は " + product + " です");
		System.out.println("生産能力は 1 分間あたり " + capacity + " 個です");
		System.out.println("------------------------------------");
	}

	/**
	 * 機械の情報を表示します。
	 */
	public void showDate() {
		System.out.println("機械の情報を表示します。");
		show();
		System.out.println();
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * 引数なしコンストラクタ
	 */
	public Machine() {
		// 各フィールドに初期値を設定
		serialNumber = "M000";
		height = 100;
		width = 100;
		weight = 100;
		product = "キャンディ";
		capacity = 100;
	}

	/**
	 * 引数ありコンストラクタ
	 */
	public Machine(String serialNumber, int height, int width, int weight, String product, int capacity) {
		// 各フィールドに初期値を設定
		this.serialNumber = serialNumber;
		this.height = height;
		this.width = width;
		this.weight = weight;
		this.product = product;
		this.capacity = capacity;
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
	// void setMachine(String serialNumber, int height, int width, int weight, String product, int capacity) {
	void setMachine() {
		setSerialNumber(serialNumber);
		setHeight(height);
		setWidth(width);
		setWeight(weight);
		setProduct(product);
		setCapacity(capacity);
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
	void mold(int num) {
		System.out.println(product + " を成型します。");
		System.out.println("約 " + (num / capacity) + " 分後に出来上がります。");
	}

	void setAttributes(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	void setAttributes(String serialNumber, int height, int width) {
		this.serialNumber = serialNumber;
		this.height = height;
		this.width = width;
	}

	void setAttributes(String serialNumber, int height, int width, int weight, String product, int capacity) {
		this.serialNumber = serialNumber;
		this.height = height;
		this.width = width;
		this.weight = weight;
		this.product = product;
		this.capacity = capacity;
	}

}
