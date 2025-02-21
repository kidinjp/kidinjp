# 遊戲開啟方式
於 jar 檔存在之資料夾中 執行下列指令即可遊玩  
```
java -jar TypingGame.jar
```

# 遊玩規則
* 引用 `resources/words/`(50行Java保留字(關鍵詞)) 內容出題，總題數10題。
* 開啟遊戲後，按下 `Enter` 鍵開始進行隨機抽選題目
* 若抽選到已出現的題目會顯示 `(抽選至重複單字...)`並重新開始抽選
* 輸入文字後按下 `Enter` 送出，會回覆是否正確
* 10題結束後會顯示成績(正確題數、輸入總時間、每個單字的平均輸入時間、評語)
	* 80%以上正確 & 平均時間 < 3 秒 → 「非常優秀！」
	* 80%以上正確 & 平均時間 ≥ 3 秒 → 「再接再厲！」
	* 正確率低於 80% → 「還請加油！」

# 實際遊玩後成果範例
```
【本次遊玩結果】
正確題數：10 / 10
輸入總時間：18秒
每個單字的平均輸入時間：1.83秒
非常優秀！
```

# 主要檔案
```
resources
└─ words.txt
src
└─  io
  └─ TypingConsole.java、、、、、、、【6】
	└─ WordManager.java、、、、、、、、【7】
└─  main
  └─ AbstractTypingGame.java、、、【3】
  └─ ITypingGame.java、、、、、、、、【2】
  └─ TypingGameExtended.java、、、【5】
  └─ TypingGameStandard.java、、、【4】
└─ TypingGameRunner.java、、、、、、、、、、【1】
```

## 【1】 `TypingGameRunner.java`
1. main 類
2. 建立遊戲實例
    * 呼叫 `createNewGameInstance()` 方法，建立並回傳一個 【5】`TypingGameExtended` 的物件（【2】`ITypingGame` 介面型態）。
3. 開始遊戲
    * 透過 `game.start();` 執行 【5】`TypingGameExtended` 類別的 `start()` 方法，開始遊戲邏輯。
    * `return new 【5】TypingGameExtended(10);`此指定之數字為出題數。

## 【2】 `ITypingGame.java`
1. 定義 `ITypingGame` 介面
    * 這是一個 `interface`，表示它只提供方法的定義，而不包含具體的實作。
2. 宣告 `start()` 方法
    * `start()` 方法為公開 (`public`) 方法，沒有回傳值 (`void`)。
    * 任何實作 `ITypingGame` 介面的類別必須提供 `start()` 方法的具體實作。

## 【3】 `AbstractTypingGame.java`
1. `AbstractTypingGame` 作為基礎類別，提供打字遊戲的主要邏輯。
2. 子類別需要實作 `performTypingRequestProcess()` 和 `showResults()` 來完成遊戲細節。
3. `start()` 方法控制遊戲流程，包括：
    * 提示開始
    * 執行打字題目
    * 記錄答對數與時間
    * 顯示結果
4. `requestTyping()` 負責記錄打字時間並取得使用者輸入。

## 【4】 `TypingGameStandard.java`
1. 定義 `TypingGameStandard` 類別
    * 繼承 【3】 `AbstractTypingGame`，實作具體的打字遊戲邏輯。
2. 建構子 `TypingGameStandard(int questions)`
    * 設定每題間隔 1000 毫秒（1 秒）。
    * 設定總出題數（由參數 `questions` 決定）。
3. 執行遊戲（繼承 `start()` 方法）
    * 等待玩家開始遊戲
    * 開始回合（依據 `questions` 次數進行）
      1. 顯示 `[READY]` 並等待 `interval()` 毫秒。
      2. 取得一個隨機單字（可能會重複）。
      3. 讓玩家輸入該單字，計算打字時間。
      4. 判斷輸入是否正確
          * 正確：顯示 `[OK]`，計入正確題數。
          * 錯誤：顯示 `[NG]`。
      5. 進入下一題
    * 遊戲結束後顯示結果
4. `performTypingRequestProcess()`（處理單題打字）
    * 顯示 `[READY]` 並暫停 interval() 毫秒。
    * 呼叫 `getNextWord()` 取得隨機單字。
    * 呼叫 `requestTyping()` 讓玩家輸入該單字並計算打字時間。
    * 比對玩家輸入與題目單字：
    * 正確：顯示 `[OK]`，回傳 true。
    * 錯誤：顯示 `[NG]`，回傳 false。
5. `getNextWord()`（獲取隨機單字）
    * 呼叫 `WordManager.getInstance().getWordRandom()`。
    * `WordManager` 負責提供隨機單字（可能會重複）。
6. `showResults()`（顯示遊戲結果）
    * 顯示 "【本次遊玩結果】"。
    * 顯示 "正確題數：" + 正確題數 + " / " + 出題數。
    * 顯示 "輸入總時間：" + (打字時間 / 1000) + "秒"（轉換為秒數）。

## 【5】 `TypingGameExtended.java`
1. 類別與繼承關係
    * `TypingGameExtended` 繼承 【4】`TypingGameStandard`，擴充了**單字選擇**與**結果顯示**的功能。
2. 主要流程
    1. 初始化
        * 透過 `TypingGameExtended(int questions)` 建構函式初始化遊戲。
        * 呼叫 `super(questions);`，確保 【4】`TypingGameStandard` 的初始化過程被執行。
        * 內部維護一個 `word_list`（`ArrayList<String>）`，用來記錄已出現過的單字，避免重複出題。
    2. 遊戲進行過程
        * `performTypingRequestProcess()` 負責每一題的處理：
          1. 顯示 `[第x題][READY]` 並等待 `interval()` 間隔時間。
          2. 透過 `getNextWord()` 取得不重複的隨機單字。
          3. 要求玩家輸入該單字，並比對輸入是否正確：
              * 若輸入正確，顯示 `[OK]`，返回 true。
              * 若輸入錯誤，顯示 `[NG]`，返回 false。
    3. 單字選擇邏輯
        * `getNextWord()` 負責取得下一個出題單字：
          1. 透過 `WordManager.getInstance().getWordRandom()` 取得隨機單字。
          2. 若單字已存在於 `word_list`（代表重複），則：
              * 顯示 (抽選至重複單字...) 提示訊息。
              * 增加 `interval()` 間隔時間，然後重新抽選。
          3. 若單字未重複，則將其加入 `word_list`，並返回該單字。
    4. 顯示結果
        * `showResults()` 在遊戲結束後顯示結果：
          1. 顯示「本次遊玩結果」標題。
          2. 顯示 正確題數 與 輸入總時間（秒）。
          3. 計算 平均輸入時間（每個單字的輸入時間 = `getTypingTime() / 1000.0 / 10`）。
          4. 根據正確率與平均輸入時間評價玩家：
              * 80%以上正確 & 平均時間 < 3 秒 → 「非常優秀！」
              * 80%以上正確 & 平均時間 ≥ 3 秒 → 「再接再厲！」
              * 正確率低於 80% → 「還請加油！」
3. 額外功能
    * `getWord_list()` / `setWord_list()`：
      * 提供 `word_list` 讀取與修改的存取方法。

## 【6】 `TypingConsole.java`
1. 控制台輸入 (`readLine()`)
    * `scan.nextLine();` 會讓程式 等待使用者輸入，直到按下 Enter 鍵才會繼續執行。
    * 回傳值 為使用者輸入的字串。
2. 控制台輸出 (`println(String message)`)
    * 使用 `System.out.println(message);` 在 控制台顯示訊息。
3. 帶提示的輸入 (`readLineWithMessage(String message))`
    * 先輸出 `message（顯示提示訊息）`。
    * 然後調用 `readLine();` 等待輸入，並回傳輸入的字串。
4. 暫停執行 (`sleep(long millis)`)
    * `Thread.sleep(millis);` 讓當前執行緒 暫停指定的毫秒數。
    * 若發生 `InterruptedException`，則捕捉並輸出錯誤訊息 `e.printStackTrace();`。

## 【7】 `WordManager.java`
1. 類別概述
    * `WordManager` 負責從檔案讀取單字並提供 隨機選取單字 的功能。
    * 採用 單例模式（`Singleton Pattern`），確保 整個程式只會有一個 `WordManager` 實例。
    * 主要功能：
      1. 從檔案讀取單字列表
      2. 忽略註解與空白行
      3. 提供隨機單字
2. 主要屬性
    1. `FILE_PATH`（單字檔案的路徑）
        * 指定單字存放的位置 `"resources/words.txt"`。
    2. `instance`（單例模式實例）
        * 類別載入時即建立 唯一的 `WordManager` 物件。
    3. `list`（單字列表）
        * 儲存讀取到的單字。
        * 在 `WordManager` 建構時由 `readList()` 讀取填充。
    4. `random`（隨機數產生器）
        * 用於隨機選取單字，避免每次結果相同。
3. 主要方法
    1. `getInstance()`（取得單例實例）
        * 返回 `WordManager` 唯一的實例，確保不會重複讀取檔案。
    2. `readList()`（讀取單字列表）
        * 開啟檔案並讀取內容：
          * 使用 `BufferedReader` 逐行讀取 `words.txt`。
        * 資料處理邏輯：
          * 去除空白 (`trim()`)
          * 忽略註解（#開頭的行）
          * 忽略空行
          * 儲存有效單字
        * 異常處理：
          * 若讀取過程發生 `IOException`，則輸出錯誤資訊 `e.printStackTrace();`。
    3. `getWordRandom()`（隨機取得單字）
        * 隨機選取 `list` 中的單字：`return list.get(random.nextInt(list.size()));`
        * 保證 `list` 內一定有單字，避免 `IndexOutOfBoundsException`。
4. 執行流程
    1. 類別載入時執行：
        * `private static final WordManager instance = new WordManager();`
        * 自動呼叫 建構子 `WordManager()：`
            * 內部調用 `readList()` 讀取 `words.txt` 並存入 `list`。
    2. 第一次調用 `getInstance()` 時：
        * 直接返回 `instance`（不會重複讀取檔案）。
    3. 當需要隨機單字時：
        * 呼叫 `getWordRandom()`
        * `random.nextInt(list.size())` 產生隨機索引
        * 返回對應的單字
