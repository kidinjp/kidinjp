package jp.webschool.java.chapter13;

public class Sample13_04 {

	/**
	 * 例外通知の確認 13_12
	 * @param args
	 */
	public static void main(String[] args) {
		// マネージャー
		ActorManager manager = new ActorManager();

		// 例外処理の確認
		try {
			// 該当する役者をリクエスト、表示
			ActorTest actorTest1 = manager.request("役者A", 30);
			actorTest1.showProfile();

			ActorTest actorTest2 = manager.request("役者B", -5);
			actorTest2.showProfile();
		} catch (ActorException e) {
			e.printStackTrace();
		}

	}

}
