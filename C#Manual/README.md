# 【C#Manual について】
* `0_`と`【00Tips】`の使い分けとして、`0_`はピン留めしたい内容で、`【00Tips】`はC#言語においでの基礎概念または下記マップに属さない内容。
* 各ファイル名の番号は、[0_初心者手引き.md](C%23Manual/0_初心者手引き.md)の内容に沿って番号を振りました。  
  * 下記にマップとして同じ内容を再掲します。  

```
System.Object
├── 基本データ型
│   ├── System.Int32 (int)【整数】
│   ├── System.Double (double)【小数】
│   ├── System.Single (float)【浮動小数点数 (単精度)】
│   ├── System.String (string)【文字列】
│   ├── System.Boolean (bool)【論理値: true/false】
│   ├── System.Char (char)【1文字】
│   ├── System.Decimal (decimal)【高精度小数】
│   ├── System.Object (object)【すべての型の基底型】
│   └── System.Nullable<T> (T?)【値型のNULLサポート】
│
├── System.Array 【配列】
│   ├── 1次元配列
│   │   ├── int[] arr = { 1, 2, 3 };
│   │   └── 操作: arr[0], arr.Length, Array.Sort(arr)
│   ├── 多次元配列
│   │   ├── int[,] arr2D = { { 1, 2 }, { 3, 4 } };
│   │   └── 操作: arr2D[0, 1]
│   |── ジャグ配列【行ごとに長さが異なる配列】
│   |   └── int[][] jaggedArr = { new int[] { 1 }, new int[] { 2, 3 } };
│   └── 配列の便利メソッド
│       ├── Array.IndexOf(arr, value)：指定値のインデックスを検索
│       ├── Array.Resize(ref arr, newSize)：配列のサイズ変更
│       └── Array.Reverse(arr)：配列を反転
│
├── コレクション型　(System.Collections.Generic)
│   ├── System.Collections.Generic.List<T> (List<T>)【可変長リスト】
│   │   ├── 宣言: var list = new List<int> { 1, 2, 3 };
│   │   └── 操作: list.Add(4), list.Remove(2), list[0]
│   ├── System.Collections.Generic.Dictionary<TKey, TValue> (Dictionary<TKey, TValue>)【キーと値のペアを管理】
│   │   ├── 宣言: var dict = new Dictionary<string, int> { { "A", 1 }, { "B", 2 } };
│   │   └── 操作: dict["A"], dict.ContainsKey("C")
│   ├── System.Collections.Generic.Queue<T> (Queue<T>)【先入れ先出しのキュー】
│   │   ├── 宣言: var queue = new Queue<int>();
│   │   └── 操作: queue.Enqueue(1), queue.Dequeue(), queue.Peek()
│   ├── System.Collections.Generic.Stack<T> (Stack<T>)【後入れ先出しのスタック】
│   │   ├── 宣言: var stack = new Stack<int>();
│   │   └── 操作: stack.Push(1), stack.Pop(), stack.Peek()
│   ├── System.Collections.Generic.HashSet<T> (HashSet<T>)【一意の要素を管理】
│   └── System.Collections.ArrayList 【非ジェネリックリスト (非推奨)】
|
├── 特殊なコレクション
│   ├── System.Collections.Generic.SortedList<TKey, TValue> 【ソート済みリスト】
│   │   ├── 宣言: var sortedList = new SortedList<string, int>();
│   │   └── 操作: sortedList.Add("A", 1), sortedList["A"]
│   ├── System.Collections.Generic.LinkedList<T> 【双方向連結リスト】
│   │   ├── 宣言: var linkedList = new LinkedList<int>();
│   │   └── 操作: linkedList.AddLast(1), linkedList.AddFirst(0)
│   └── System.Collections.Generic.ObservableCollection<T> 【変更通知対応コレクション】
|
├── クラスとオブジェクト【基本的な構造】
│   ├── クラス定義
│   │   ├── public class クラス名 { ... }
│   │   └── コンストラクタ: public クラス名() { ... }
│   ├── オブジェクト生成: var obj = new クラス名();
│   └── 継承: public class 子クラス : 親クラス { ... }
│
├── 非同期処理関連 (System.Threading.Tasks)
│   ├── async/await
│   │   ├── async Task メソッド名() { await 処理; }
│   │   └── 使用例: ファイル読み書き
│   ├── System.Threading.Tasks.Task 【非同期タスク】
│   |   ├── Task.Run(() => { ... })：非同期タスクを実行
│   |   ├── await Task.Delay(milliseconds)：指定時間待機
│   |   ├── Task.WhenAll(tasks) / Task.WhenAny(tasks)：タスクの完了を待機
│   |   ├── 使用例: Task.Run(() => { ... });
│   |   └── 並列処理での負荷分散
│   ├── System.Threading.CancellationToken 【非同期処理のキャンセル】
│   └── System.Threading.SemaphoreSlim 【軽量なセマフォ】
│
├── 日時関連
│   ├── System.DateTime 【日時の管理】
│   │   ├── DateTime.Now：現在の日時
│   │   ├── DateTime.Today：今日の日付 (時間は 00:00:00)
│   │   ├── DateTime.Parse("yyyy-MM-dd")：文字列から日時を解析
│   │   ├── DateTime.AddDays(x) / AddMonths(x) / AddYears(x)：日時の加算
│   │   ├── DateTime.Subtract(別のDateTime)：日時の差を取得
│   │   └── DateTime.ToString("yyyy/MM/dd")：フォーマットに従って日時を文字列化
│   ├── System.TimeSpan 【時間の間隔】
│   │   ├── TimeSpan.FromDays(x) / FromHours(x) / FromMinutes(x)：指定単位で時間間隔を作成
│   │   ├── TimeSpan.Hours / Minutes / Seconds：間隔の各要素を取得
│   │   ├── TimeSpan.TotalSeconds / TotalMilliseconds：間隔を合計単位で取得
│   │   └── 演算例：var duration = date2 - date1; → 結果はTimeSpan
│   └── System.DateTimeOffset 【タイムゾーン対応の日時管理】
│
├── IO関連 (System.IO)
│   ├── System.IO.File 【ファイル操作】
│   │   ├── File.ReadAllText(path)：ファイルの内容を文字列として読み取る
│   │   ├── File.WriteAllText(path, text)：文字列を書き込む
│   │   └── File.Exists(path)：ファイルが存在するか確認
│   ├── System.IO.Directory 【ディレクトリ操作】
│   │   ├── Directory.CreateDirectory(path)：ディレクトリを作成
│   │   └── Directory.GetFiles(path)：ディレクトリ内のファイル一覧を取得
│   ├── System.IO.Path 【ファイルパス操作】
│   │   ├── Path.Combine(part1, part2)：パスを結合
│   │   ├── Path.GetFileName(path)：ファイル名を取得
│   │   └── Path.GetExtension(path)：拡張子を取得
│   └── System.IO.Stream 【ストリーム操作 (バイナリ/テキスト)】
│
├── LINQ (クエリ操作、System.Linq)
│   ├── System.Linq.Enumerable 【LINQ用の拡張メソッド】
│   ├── System.Linq.Queryable 【データベースのクエリ用】
│   ├── System.Linq.Expressions.Expression 【式ツリーの作成】
│   |── System.Linq.IGrouping<TKey, TElement> 【グループ化されたデータ】
│   ├── 基本クエリ操作
│   │   ├── フィルタ: arr.Where(x => x > 2)
│   │   ├── ソート: arr.OrderBy(x => x)
│   │   ├── 投影: arr.Select(x => x * 2)
│   │   └── 集計: arr.Sum(), arr.Average()
│   └── コレクションとの連携
│       ├── Zip: arr1.Zip(arr2, (x, y) => x + y)
│       ├── GroupBy: list.GroupBy(x => x % 2 == 0)
│       └── ToList/ToArray: list.ToList(), list.ToArray()
│
├── ネットワーク関連
│   ├── System.Net.Http.HttpClient 【HTTP通信】
│   │   ├── var client = new HttpClient();
│   │   ├── await client.GetStringAsync(url);：指定URLから文字列を取得
│   │   └── await client.PostAsync(url, content);：POSTリクエストを送信
│   ├── System.Net.WebClient 【簡易な通信】
│   ├── System.Net.Sockets.Socket 【低レベルなソケット通信】
│   └── System.Net.IPAddress 【IPアドレスの操作】
│
├── ユーティリティ
│   ├── System.Random 【乱数生成】
│   |   ├── var rand = new Random();
│   |   ├── rand.Next(min, max)：指定範囲の整数を生成
│   |   └── rand.NextDouble()：0.0 ～ 1.0 のランダムな小数を生成
│   ├── System.Diagnostics.Stopwatch 【経過時間の計測】
│   ├── System.Environment 【環境情報 (OS/メモリ)】
│   └── System.Text
│       ├── System.Text.StringBuilder 【文字列操作の最適化】
│       |   ├── var sb = new StringBuilder();
│       |   ├── sb.Append("text");：文字列を追加
│       |   └── sb.ToString();：最終結果を文字列に変換
│       └── Encoding
│           ├── Encoding.UTF8：UTF-8エンコード
│           └── Encoding.ASCII.GetBytes("text")：文字列をバイト配列に変換
|
├── 例外処理 (System.Exception)
│   ├── try-catch-finally
│   │   ├── try { ... } catch (Exception ex) { ... } finally { ... }
│   │   └── 使用例: 数値変換時のエラー捕捉
│   ├── 特定の例外
│   │   ├── System.IO.IOException (入出力エラー)
│   │   └── System.NullReferenceException (null参照エラー)
│   └── 独自の例外クラス: class MyException : Exception { ... }
|
└──System.Math
    ├── Math.Abs(x)：絶対値を取得
    ├── Math.Pow(x, y)：累乗
    ├── Math.Sqrt(x)：平方根
    ├── Math.Max(x, y) / Math.Min(x, y)：最大値 / 最小値
    ├── Math.Round(x)：四捨五入
    └── Math.Floor(x) / Math.Ceiling(x)：切り捨て / 切り上げ
```
