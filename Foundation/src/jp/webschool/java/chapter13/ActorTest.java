package jp.webschool.java.chapter13;

/**
 * 役者（テスト用） 13_10
 */
public class ActorTest {
	/** 名前 */
	private String name = "未登録";
	/** 年齢 */
	private int age = 0;

	/**
	 * プロフィールを設定します。
	 * @param name　名前
	 * @param age　年齢
	 * @throws ActorException　不正な引数が渡された場合
	 */
	public void setProfile(String name, int age) throws ActorException {
		// 引数の年齢チェック（マイナスは不正な年齢）
		if (age < 0) {
			// 例外クラスのインスタンスを生成
			ActorException e = new ActorException("引数 age の値が不正です：" + age);
			// 例外を送出（例外をスロー）
			// throw new ActorException("引数 age の値が不正です：" + age);
			throw e;
		}

		// プロフィールを設定
		this.name = name;
		this.age = age;
	}

	/**
	 * プロフィールを表示します。
	 */
	public void showProfile() {
		System.out.println("役者の名前は " + name + " さんで、年齢は " + age + " 歳です。");
	}
}
