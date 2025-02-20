package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 單字管理 類。
 * 
 * <pre>
 *   負責從設定檔讀取並管理單字。
 * </pre>
 */
public final class WordManager {
	/** 設定檔案路徑 */
	public static final String FILE_PATH = "resources/words.txt";
	
	/** 單例（Singleton）實例 */
	private static final WordManager instance = new WordManager();
	
	/** 單字列表 */
	private final List<String> list;
	/** 隨機數產生器 */
	private final Random random = new Random();
	
	/**
	 * 取得實例。
	 * @return WordManager 單例實例
	 */
	public static WordManager getInstance() {
		// 返回實例
		return instance;
	}
	
	/**
	 * 建構 WordManager。
	 */
	private WordManager() {
		// 讀取單字列表
		this.list = readList();
	}
	
	/**
	 * 從設定檔讀取單字列表。
	 * @return List<String> 單字列表
	 */
	private List<String> readList() {
		ArrayList<String> list = new ArrayList<>();
		// 讀取設定檔
		try (BufferedReader in = new BufferedReader(new FileReader(FILE_PATH));) {
			// 處理單字
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				// 移除左右空白
				line = line.trim();
				// 忽略註解 (#開頭的字串)
				if (line.startsWith("#")) {
					// 
					continue;
				}
				// 新增有效單字
				if (line.length() > 0) {
					list.add(line);
				}
			}
		} catch (IOException e) {
			// 
			e.printStackTrace();
		}
		// 返回單字列表
		return list;
	}
	
	/**
	 * 隨機取得一個單字。
	 * 
	 * <pre>
	 *   由於是隨機選取，因此可能會返回相同的單字。
	 * </pre>
	 * 
	 * @return String 單字
	 */
	public String getWordRandom() {
		// 從單字列表中隨機選取並返回
		return list.get(random.nextInt(list.size()));
	}
}
