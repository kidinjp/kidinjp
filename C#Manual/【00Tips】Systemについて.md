概要
* [System名前空間について](#System名前空間について)
  * [役割と特徴](#役割と特徴)
* [よく使うSystem名前空間のクラス](#よく使うSystem名前空間のクラス)
  * [System.Object](#System.Object)
  * [System.String](#System.String)
  * [System.Console](#System.Console)
  * [System.Math](#System.Math)
  * [System.DateTime](#System.DateTime)
  * [System.Random](#System.Random)
  * [System.Exception](#System.Exception)
  * [System.Type](#System.Type)
  * [System.TimeSpan](#System.TimeSpan)
  * [System.IO](#System.IO)
  * [System.Text](#System.Text)
  * [System.Net.Http](#System.Net.Http)
  * [System.Threading.Tasks](#System.Threading.Tasks)

***************************************************************************
## System名前空間について
* .NETプラットフォームの基盤となる重要な名前空間
* 基本的な型、操作、機能を提供する
* この名前空間は、.NETアプリケーションのほぼすべてのコードで利用されるため、最も重要で基本的な名前空間といえる

### 役割と特徴
1. 基本的な型の提供
    * System名前空間には、C#の基本型を定義するクラスや構造体が含まれている
    * 例:
      * 整数型: System.Int32 (int)、System.Int64 (long)
      * 浮動小数点型: System.Single (float)、System.Double (double)
      * 文字型と文字列型: System.Char (char)、System.String (string)
      * 真偽値型: System.Boolean (bool)
      * その他: System.Object (すべての型の基底クラス)
2. ユーティリティクラスの提供
    * System名前空間には、さまざまな便利なクラスが含まれており、一般的な操作を簡単に実行できる
    * 例:
      * 文字列操作: System.String
      * 日付と時刻: System.DateTime
      * 乱数生成: System.Random
      * コンソール操作: System.Console
3. エラーハンドリング
    * 例外処理に使用される基底クラスSystem.Exceptionを提供する
    * try-catch構文での例外処理でよく使用される
4. コレクションとデータ構造
    * 配列やリスト、ディクショナリなどのコレクション型を操作するためのクラスが含まれている
    * 例:
      * System.Array
      * System.Collections名前空間（List<T>, Dictionary<TKey, TValue> などは拡張された System.Collections.Generic にあります）
5. 入出力操作の基盤
    * ファイル操作やストリーム処理に関連する基本機能を提供する
    * 例:
      * System.IO名前空間: ファイルとストリームの操作
6. 型の操作とリフレクション
    * 実行時の型情報を操作するためのクラスを提供する
    * 例:
      * System.Type
      * System.Reflection名前空間
7. 非同期と並列処理
    * 非同期処理をサポートする基本クラスがある
    * 例:
      * System.Threading.Tasks.Task
      * async/await 構文と組み合わせて利用  

System名前空間の重要性
* **広範な適用性**: ほとんどの.NETアプリケーションで使用される基本的な構造を提供する
* **開発効率向上**: 日常的に必要な機能が統一的なインターフェイスで提供されているため、開発者の負担が軽減される
* **拡張性**: 必要に応じて他の名前空間（例: System.Linq, System.Xml）を組み合わせて強力な機能を実現できる

## よく使うSystem名前空間のクラス
C#のSystem名前空間には、多くの便利なクラスやメソッドが含まれている
本ファイルよりはよく使われるSystem関連のクラスとその用途をリストアップしてみる  

| クラス名 | 説明 |
| --- | --- |
| System.Object | すべての型の基底クラス |
| System.String | 不変の文字列操作を提供 |
| System.Console | コンソール入出力（WriteLine, ReadLineなど） |
| System.Math | 数学関数を提供（Math.Pow, Math.Sqrtなど） |
| System.DateTime | 日付と時刻を表すクラス |
| System.Random | 疑似乱数生成を提供 |
| System.Exception | 例外の基本クラス |
| System.Type | 実行時の型情報を提供するリフレクション用クラス |
| System.TimeSpan | 時間の間隔を扱う |
| System.IO | ファイルやディレクトリの操作を提供する |
| System.Text | テキスト操作やエンコーディングを提供する |
| System.Net.Http | HTTP通信を扱う |
| System.Threading.Tasks | 非同期処理を提供する |

* 使用頻度の高い拡張機能  
C#では、これらのクラスを使用している間に、usingディレクティブを利用すると簡潔になる
```C#
using System;
using System.IO;
using System.Linq;
using System.Collections.Generic;
```

### System.Object
すべての型の基底クラスであり、すべてのC#クラスが暗黙的に継承する基本クラス

主要メソッド:  
* Equals(object obj): インスタンスが他のオブジェクトと等しいかを判断
* GetHashCode(): オブジェクトのハッシュコードを取得
* GetType(): オブジェクトの型を取得（System.Typeを返す）
* ToString(): オブジェクトの文字列表現を返す（カスタムでオーバーライド可能）
* ReferenceEquals(object objA, object objB): 2つのオブジェクトが同じインスタンスを参照しているかを判定

### System.String
不変の文字列（変更不可）を扱うクラス  

主要メソッド:  
* Length: 文字列の長さを取得（プロパティ）
* Substring(int startIndex, int length): 部分文字列を取得
* Contains(string value): 指定した文字列が含まれているかを判定
* IndexOf(string value): 指定した文字列の最初の位置を取得
* Replace(string oldValue, string newValue): 指定した文字列を置換
* ToUpper(): 文字列を大文字に変換
* ToLower(): 文字列を小文字に変換
* Split(char[] separator): 文字列を区切り文字で分割
* Trim(): 先頭と末尾の空白を除去

### System.Console
コンソールアプリケーションでの入出力を制御するクラス  

主要メソッド:  
* Write(string value): 文字列を出力（改行なし）
* WriteLine(string value): 文字列を出力（改行付き）
* ReadLine(): ユーザーから1行の文字列入力を受け取る
* ReadKey(): ユーザーから1文字入力を受け取る
* Clear(): コンソール画面をクリア
* SetCursorPosition(int left, int top): コンソールカーソルの位置を設定

### System.Math
数学関連の機能を提供する  

主要メソッド:
* Abs(x)：絶対値を取得
* Pow(x, y)：累乗
* Sqrt(x)：平方根
* Max(x, y)：最大値
* Min(x, y)：最小値
* Round(x)：四捨五入
* Floor(x)：切り捨て
* Ceiling(x)：切り上げ

### System.DateTime
日付と時刻を表すクラス  

主要メンバー:  
* Now (プロパティ): 現在の日時を取得
* Today (プロパティ): 今日の日付を取得（時刻は00:00:00）
* Parse("yyyy-MM-dd")：文字列から日時を解析
* AddDays(double value): 指定した日数を追加した日時を取得
* AddMonths(double value): 指定した月数を追加した日時を取得
* AddYears(double value): 指定した年数を追加した日時を取得
* AddSeconds(double value): 指定した秒を追加した日時を取得
* AddMinutes(double value): 指定した分を追加した日時を取得
* AddHours(double value): 指定した時間を追加した日時を取得
* ToString(string format): 指定した形式の文字列に変換
* Subtract(DateTime value): 2つの日付の差を取得（TimeSpanを返す）
* Day, Month, Year (プロパティ): 日、月、年を取得

### System.Random
疑似乱数を生成するクラス  

主要メンバー:  
* var rand = new Random();
* rand.Next(min, max)：指定範囲の整数を生成
* rand.NextDouble()：0.0 ～ 1.0 のランダムな小数を生成  

主要メソッド:  
* Next(): 0以上の乱数を取得（int）
* Next(int maxValue): 0から指定した最大値未満の乱数を取得
* Next(int minValue, int maxValue): 指定した範囲内の乱数を取得
* NextDouble(): 0.0以上1.0未満の乱数を取得（double）
* NextBytes(byte[] buffer): バイト配列をランダムな値で埋める

### System.Exception
例外処理の基本クラス  

主要プロパティ:  
* Message: 例外メッセージを取得
* StackTrace: スタックトレースを取得
* InnerException: 内包されている例外（発生した原因となる例外）を取得
* HelpLink: 例外に関連付けられたヘルプファイルリンク

主要メソッド:  
* ToString(): 例外の文字列表現を取得
* GetBaseException(): 内包されている最後の例外を取得

### System.Type
実行時の型情報を提供するクラス  

主要メソッド:  
* GetType(string typeName): 型の名前から型を取得
* GetProperties(): 型のすべてのプロパティを取得
* GetMethods(): 型のすべてのメソッドを取得
* IsClass (プロパティ): 型がクラスであるかを判定
* IsValueType (プロパティ): 型が値型であるかを判定
* Assembly (プロパティ): 型が定義されているアセンブリを取得

### System.TimeSpan
時間の間隔を扱う  

主要メンバー:  
* FromDays(x) / FromHours(x) / FromMinutes(x)：指定単位で時間間隔を作成
* Hours / Minutes / Seconds：間隔の各要素を取得
* TotalSeconds / TotalMilliseconds：間隔を合計単位で取得  
演算例：var duration = date2 - date1; → 結果はTimeSpan

### System.IO
ファイルやディレクトリの操作を提供する  

主要クラス:  
* File：
  * File.ReadAllText(path)：ファイルの内容を文字列として読み取る
  * File.WriteAllText(path, text)：文字列を書き込む
  * File.Exists(path)：ファイルが存在するか確認
* Directory：
  * Directory.CreateDirectory(path)：ディレクトリを作成
  * Directory.GetFiles(path)：ディレクトリ内のファイル一覧を取得
* Path：
  * Path.Combine(part1, part2)：パスを結合
  * Path.GetFileName(path)：ファイル名を取得
  * Path.GetExtension(path)：拡張子を取得

### System.Text
テキスト操作やエンコーディングを提供する  

主要クラス:  
* StringBuilder：
  * var sb = new StringBuilder();
  * sb.Append("text");：文字列を追加
  * sb.ToString();：最終結果を文字列に変換
* Encoding：
  * Encoding.UTF8：UTF-8エンコード
  * Encoding.ASCII.GetBytes("text")：文字列をバイト配列に変換

### System.Net.Http
HTTP通信を扱う  

主要クラス:  
* HttpClient：
  * var client = new HttpClient();
  * await client.GetStringAsync(url);：指定URLから文字列を取得
  * await client.PostAsync(url, content);：POSTリクエストを送信

### System.Threading.Tasks
非同期処理を提供する  

主要メンバー:  
* Task.Run(() => { ... })：非同期タスクを実行
* await Task.Delay(milliseconds)：指定時間待機
* Task.WhenAll(tasks) / Task.WhenAny(tasks)：タスクの完了を待機  
