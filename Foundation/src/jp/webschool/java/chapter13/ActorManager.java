package jp.webschool.java.chapter13;

/**
 * 役者マネージャクラス
 */
public class ActorManager {
	/**
	 * 役者をリクエストします。
	 * @param name　名前
	 * @param age　年齢
	 * @return　ActorTest　役者
	 * @throws ActorException　不正な引数が渡された場合
	 */
	public ActorTest request(String name, int age) throws ActorException {
		// インスタンスを生成
		ActorTest actor = new ActorTest();

		// プロフィールを設定
		actor.setProfile(name, age);

		// 役者を返却
		return actor;
	}
}
