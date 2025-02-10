package com.fs.tic.typing_game.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 単語管理クラスです。
 * 
 * <pre>
 *   設定ファイルから単語を読み込み、管理します。
 * </pre>
 */
public final class WordManager {
	/** 設定ファイルパス */
	public static final String FILE_PATH = "resources/words.txt";
	
	/** シングルトンインスタンス */
	private static final WordManager instance = new WordManager();
	
	/** 単語一覧 */
	private final List<String> list;
	/** 乱数生成 */
	private final Random random = new Random();
	
	/**
	 * インスタンスを取得します。
	 * @return WordManager インスタンス
	 */
	public static WordManager getInstance() {
		// インスタンス返却
		return instance;
	}
	
	/**
	 * WordManager を構築します。
	 */
	private WordManager() {
		// 単語一覧読み込み
		this.list = readList();
	}
	
	/**
	 * 設定ファイルから単語一覧を読み込みます。
	 * @return List<String> 単語一覧
	 */
	private List<String> readList() {
		ArrayList<String> list = new ArrayList<>();
		// 設定ファイル読み込み
		try (BufferedReader in = new BufferedReader(new FileReader(FILE_PATH));) {
			// 単語処理
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				// 左右空白除去
				line = line.trim();
				// コメントは無視
				if (line.startsWith("#")) {
					// 
					continue;
				}
				// 有効単語を登録
				if (line.length() > 0) {
					list.add(line);
				}
			}
		} catch (IOException e) {
			// 
			e.printStackTrace();
		}
		// 単語一覧返却
		return list;
	}
	
	/**
	 * ランダムに単語を取得します。
	 * 
	 * <pre>
	 *   単語はランダムに取得されるため、同じ単語が返却されることがあります。
	 * </pre>
	 * 
	 * @return String 単語
	 */
	public String getWordRandom() {
		// 単語一覧からランダムに返却
		return list.get(random.nextInt(list.size()));
	}
}
