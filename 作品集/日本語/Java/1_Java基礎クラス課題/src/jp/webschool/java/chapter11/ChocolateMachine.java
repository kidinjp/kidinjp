package jp.webschool.java.chapter11;

/**
 * チョコレートを製造する機械 クラス 11_01
 */
public class ChocolateMachine extends Machine {
	/** 設定温度 */
	private int temperature;

	/**
	 * コントラスト
	 */
	public ChocolateMachine() {
		System.out.println("チョコレートを製造する機械を生成しました");
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
	public ChocolateMachine(String serialNumber, int height, int width, int weight, String product, int capacity) {
		// スーパークラスの引数ありコンストラクタを呼び出す。
		// しないと引数なしコンストラクタが自動的に呼び出される
		super(serialNumber, height, width, weight, product, capacity);
		System.out.println("チョコレートを製造する機械を生成しました");
	}

	/**
	 * チョコレートを温めます
	 * @param t　設定温度
	 */
	public void warm(int t) {
		// 適正温度判定
		if (t > 45) {
			temperature = t;
			System.out.println(temperature + " 度に温めました。");
		} else {
			System.out.println("適正温度ではないため、温めませんでした。");
		}

	}

	/**
	 * アクセス制限テスト 11_06
	 */
	public void test() {
		// スーパークラスにあるフィールドをprivateにすると参照できるようにはなるが、
		// なるべく狭い範囲に限定することが望ましい
		System.out.println(getSerialNumber());
	}

	/**
	 * Eclipse エディタでは、オーバーライドしたメソッドの左側に緑色の三角形のアイコンで表示する
	 */
	@ Override
	boolean mix2(String ingredients, String water) {
		if (ingredients.equals("カカオ") && water.equals("ミルク")) {
			System.out.println("ベース状のチョコレートができました。");
			return true;
		}
		System.out.println("チョコレートの材料ではありません。");
		return false;
	}

	/**
	 * このクラスの情報を出力します。
	 */
	@ Override
	void show() {
		System.out.println("（これは、チョコレートを製造する機械の情報です）");
		// オーバーライドしたスーパークラスのメソッドを再利用
		super.show();
	}
}
