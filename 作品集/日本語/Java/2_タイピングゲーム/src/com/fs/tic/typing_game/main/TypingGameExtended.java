package com.fs.tic.typing_game.main;

import java.util.ArrayList;

import com.fs.tic.typing_game.io.TypingConsole;
import com.fs.tic.typing_game.io.WordManager;

public class TypingGameExtended extends TypingGameStandard {

	public TypingGameExtended(int questions) {
		super(questions);
	}

	/**
	 * TypingGameExtended を構築します。
	 * @param questions 出題数
	 */
	private ArrayList<String> word_list = new ArrayList<>();

	@Override
	protected boolean performTypingRequestProcess() {
		// 出題前インターバル
		TypingConsole.println("[READY]");
		TypingConsole.sleep(interval());
		// 出題単語取得
		String word = getNextWord();
		// タイピング要求
		String input = requestTyping(word);
		// タイピング結果判定
		if (input.equals(word)) {
			TypingConsole.println("[OK]");
			// タイピング成功
			return true;
		} else {
			TypingConsole.println("[NG]");
			// タイピング失敗
			return false;
		}
	}

	/**
	 * 次に出題する単語を取得します。
	 * １．一度出題されたワード（重複ワード）は出題しない
	 * ２．重複ワードを選択しても、全体の出題数は変えない（現状のプログラムでは全１０問出題する）
	 * ３．重複ワードを選択した場合は、重複していないワードを再選択して出題する
	 * （３－１） 「(重複ワードが選択されました...)」というメッセージを表示する
	 * （３－２） ワードを再選択する
	 * （３－３） 再出題する前に、インターバルを置く（時間間隔を空ける）
	 * @return String 単語
	 */
	protected String getNextWord() {
		String word = WordManager.getInstance().getWordRandom();
		if (word_list.contains(word)) {
			System.out.println("(重複ワードが選択されました...)");
			TypingConsole.sleep(interval());
			return getNextWord();
		} else {
			word_list.add(word);
		}
		// ランダムに取得した単語を返却
		return word;
	}

	/**
	 * 結果を表示します。
	 * 現在表示している結果メッセージの後に、追加で以下の評価メッセージを出力します。
	 * １．１ワードあたりの平均タイピング時間を表示する（単位は秒で、１００分の１秒まで表示）
	 * ２．以下の条件で、総合評価メッセージを表示する
	 * （２－１） 正解数が８０％以上で平均タイピング時間が３秒未満の場合は「すばらしい！」を表示する
	 * （２－２） 正解数が８０％以上で平均タイピング時間が３秒以上の場合は「もう少しはやく！」を表示する
	 * （２－３） 正解数が８０％未満の場合は「もっと正確に！」を表示する
	 */
	@Override
	protected void showResults() {
		TypingConsole.println("今回の成績は？");
		double averageTypingTime = getTypingTime() / 1000.0 / 10;

		TypingConsole.println("正解数：" + getCorrects() + " / " + getQuestions());
		TypingConsole.println("入力時間：" + (getTypingTime() / 1000) + "秒");
		TypingConsole.println("１ワードあたりの平均タイピング時間：" + String.format("%.2f", averageTypingTime) + "秒");
		if (getCorrects() >= 8 && averageTypingTime < 3) {
			TypingConsole.println("すばらしい！");
		} else if (getCorrects() >= 8 && averageTypingTime >= 3) {
			TypingConsole.println("もう少しはやく！");
		} else if (getCorrects() < 8) {
			TypingConsole.println("もっと正確に！");
		}

	}

	public ArrayList<String> getWord_list() {
		return word_list;
	}

	public void setWord_list(ArrayList<String> word_list) {
		this.word_list = word_list;
	}
}
