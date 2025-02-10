package jp.webschool.java.chapter13;

public class Sample13_03 {

	/**
	 * 例外送出の確認 13_10
	 * @param args
	 */
	public static void main(String[] args) {
		// インスタンスを生成
		ActorTest a1 = new ActorTest();
		ActorTest a2 = new ActorTest();

		try {
			// プロフィールを設定
			a1.setProfile("役者一郎", 30);
			a2.setProfile("役者次郎", -5);
		} catch (ActorException e) {
			e.printStackTrace();
		}

		// プロフィール表示
		a1.showProfile();
		a2.showProfile();

	}

}
