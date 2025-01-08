概要
* [C#自体への紹介](#c自体への紹介)
* [よく使う概念](#よく使う概念)
  * [要素の命名ルール](#要素の命名ルール)
    * [予約語一覧](#予約語一覧)
  * [リテラルの種類](#リテラルの種類)
  * [定数と読み取り専用フィールド(値を変更しない)](#定数と読み取り専用フィールド値を変更しない)
  * [演算子とオペランドの意味](#演算子とオペランドの意味)
    * [算出演算子](#算出演算子)
    * [代入演算子](#代入演算子)
    * [比較演算子](#比較演算子)
    * [論理演算子](#論理演算子)
    * [ビット演算子](#ビット演算子)
    * [インクリメント](#インクリメント)
    * [その他の演算子](#その他の演算子)
  * [エスケープシーケンス](#エスケープシーケンス)
  * [基本データ型](#基本データ型)
  * [StringとStringBuilder](#stringとstringbuilder)
  * [n進数](#n進数)
  * [XMLドキュメントコメント](#xmlドキュメントコメント)
  * [C#の標準ライブラリ](#Cの標準ライブラリ)

***************************************************************************
## C#自体への紹介
1. C#の概要
    * **公式ドキュメント：**[Microsoft Learn](https://learn.microsoft.com/ja-jp/dotnet/csharp/)
    * **学習プラットフォーム:** Udemy, Pluralsight
    * **設計目的:**
      * 生産性の向上: シンプルで直感的な構文
      * セキュリティ: 強い型付けを採用
      * マルチプラットフォーム: .NET Core（現在は.NET）を利用することで、Windows、Linux、macOSで動作可能
    * **用途:**
      * デスクトップアプリケーション（Windows Forms, WPF）
      * Webアプリケーション（ASP.NET）
      * ゲーム開発（Unityエンジン）
      * クラウド・モバイルアプリ開発（Xamarin, MAUI）
    * **プラットフォーム:**
      * .NETフレームワーク（Windows向け）
      * .NET（クロスプラットフォーム）
2. C#の特徴
    * **強い型付け**
    * **オブジェクト指向**
      * クラスとオブジェクトを中心に設計されている
      * 抽象化、カプセル化、継承、多態性をサポート
    * **豊富なライブラリ**
      * 標準ライブラリには、文字列操作、データ構造、ファイル操作、ネットワーク通信などが含まれている
      * NuGetパッケージマネージャで、外部ライブラリを簡単に追加可能
    * **LINQ（Language Integrated Query）**
      * C#独自の機能で、コレクションやデータベースに対するクエリ操作を簡潔に記述できる
3. 開発環境
    * Visual Studioを使うと、GUI設計やリッチなコード補完が活用でき、初心者にも使いやすい
    * dotnet CLIを使用すると、エディタに依存せず操作可能
    1. .NET SDKをインストール
        * [.NET公式サイト](#https://dotnet.microsoft.com/)から最新版をダウンロード
        * クロスプラットフォーム対応のため、Windows、macOS、Linuxで利用可能
    2. IDEのインストール
        * Visual Studio（Windows向け） または Visual Studio Code（軽量エディタ） を使用
    3. プロジェクト作成
        * dotnet new console -n MyApp
        * cd MyApp
    4. ビルドと実行
        * dotnet build
        * dotnet run
    5. NuGetパッケージの利用
        * dotnet add package Newtonsoft.Json

| カテゴリー | 内容 |
| --- | --- |
| ランタイム環境 | .NET Runtime（旧称: .NET Core Runtime / .NET Framework Runtime） |
|  | - CLR（Common Language Runtime）: C#プログラムを実行する仮想環境 |
|  | - BCL（Base Class Library）: 文字列操作、ファイルI/O、ネットワークなどの標準ライブラリ群 |
|  | - クロスプラットフォーム対応（Windows, Linux, macOS） |
| 開発ツール | .NET SDK |
|  | - アプリケーション開発に必要なツールとライブラリを含む |
|  | - C#コンパイラ（csc）: ソースコードを中間言語（CIL）に変換 |
|  | - dotnet CLI: プロジェクト管理、ビルド、実行コマンド |
|  | - デバッグツール、ランタイムライブラリなどを含む |
| プロジェクト管理 | .csprojファイル |
|  | - C#プロジェクトの構成や依存関係をXML形式で定義 |
|  | - NuGetパッケージマネージャで外部ライブラリを管理可能 |
| パッケージ管理 | NuGet |
|  | - .NETエコシステム専用のパッケージマネージャ |
|  | - 数多くのオープンソースおよび商用ライブラリをインストール可能 |
| 統合開発環境（IDE） | Visual Studio（Windows, macOS） |
|  | - Microsoft公式の強力なIDEで、デバッグ、リファクタリング、GUIデザインをサポート |
|  | Visual Studio Code（クロスプラットフォーム） |
|  | - 軽量で高速なエディタ。C#用の拡張機能をインストールして利用 |
|  | Rider（JetBrains社製） |
|  | - 高機能なクロスプラットフォーム対応IDE |
| 実行ファイル | .exe / .dll ファイル |
|  | - C#プログラムをビルドすると、中間言語（CIL）にコンパイルされる |
|  | - .exe: 実行可能ファイル |
|  | 	- .dll: ライブラリとして使用されるファイル |
| コマンドライン操作 | dotnet CLI |
|  | - プロジェクト作成: dotnet new |
|  | - ビルド: dotnet build |
|  | - 実行: dotnet run |
|  | - パッケージ管理: dotnet add package |

***************************************************************************
## よく使う概念
下記よりよく使う基本知識をまとめる。

### 要素の命名ルール
| 要素   | 記法名 | 命名ルール | 例 |
| ------ | --- | --- | --- |
| クラス   | パスカルケース PascalCase<br>（アッパーキャメルケース） | 名詞<br>すべての単語は先頭大文字 | `Person`<br>`ArrayList<br>`HttpClient` |
| 構造体   | パスカルケース PascalCase<br>（アッパーキャメルケース） | 名詞<br>すべての単語は先頭大文字 | `Point`<br>`DateTime` |
| インターフェイス   | パスカルケース PascalCase<br>（アッパーキャメルケース）<br>接頭辞`I` | 接頭辞にIを付ける<br>名詞または形容詞 | `IComparable`<br>`IDisposable` |
| 列挙型   | パスカルケース PascalCase<br>（アッパーキャメルケース） | 名詞<br>すべての単語は先頭大文字 | `DayOfWeek`<br>`HttpStatusCode` |
| 列挙型の値   | パスカルケース PascalCase<br>（アッパーキャメルケース） | 単一の値としての名詞<br>すべての単語は先頭大文字 | `Sunday`<br>`HttpOK` |
| 変数     | キャメルケース camelCase<br>（ロウワーキャメルケース） | 名詞<br>1つ目の単語は先頭小文字<br>２つ目以降の単語は先頭大文字 | `out`<br>`modCount`<br>`serialVersionUID` |
| フィールド     | キャメルケース camelCase<br>（ロウワーキャメルケース）<br>接頭辞`_`推奨 | 名詞<br>プライベートなフィールドは接頭辞`_`を付ける | `_totalCount`<br>`_isCompleted` |
| 定数     | アッパースネークケース UpperCamelCase | 名詞<br>`単語はすべて大文字`<br>間は**アンダーバーで区切る** | `MAX_VALUE`<br>`PI` |
| メソッド | キャメルケース lowerCamelCase<br>（ロウワーキャメルケース） | **動詞**<br>1つ目の単語は先頭小文字<br>２つ目以降の単語は先頭大文字 | `CalculateTotal()`<br>`IsEmpty()` |

#### 予約語一覧
特定動作の名前を使いたい場合は`@`を付けると変数化できる
```C#
int @class = 10;  // キーワード 'class' を変数名として使用
```

| カテゴリ | 予約語 |
| --- | --- |
| 値型 | `bool`, `byte`, `char`, `decimal`, `double`, `float`, `int`, `long`, `sbyte`, `short`, `uint`, `ulong`, `ushort` |
| 制御構造 | `break`, `case`, `catch`, `continue`, `default`, `do`, `else`, `finally`, `for`, `foreach`, `goto`, `if`, `return`, `switch`, `try`, `while` |
| アクセス修飾子 | `private`, `protected`, `public`, `internal` |
| クラスとオブジェクト | `class`, `struct`, `interface`, `enum`, `namespace`, `new`, `this`, `base`, `typeof` |
| 静的メンバーとオーバーライド | `static`, `const`, `readonly`, `sealed`, `override`, `virtual`, `abstract`, `partial` |
| 例外処理 | `throw`, `try`, `catch`, `finally` |
| スレッド同期とリソース管理 | `lock`, `using` |
| 変数とスコープ | `var`, `dynamic`, `out`, `ref`, `in`, `params`, `default` |
| その他 | `as`, `is`, `null`, `void`, `true`, `false`, `sizeof`, `stackalloc`, `unsafe`, `checked`, `unchecked`, `implicit`, `explicit` |
| コンテキストキーワード | `add`, `alias`, `async`, `await`, `dynamic`, `get`, `global`, `partial`, `remove`, `set`, `value`, `where`, `yield` |

### リテラルの種類
| 種類 | 説明 | 例 |
| --- | --- | --- |
| 文字リテラル | 1文字<br>シングルクォート (') で囲む | `'A'`<br>`'\n'` |
| 文字列リテラル | 複数の文字からなる文字列<>ダブルクォート (") で囲む | `"Hello"` |
| 逐語的文字列 | エスケープシーケンスを無効化した文字列。ダブルクォート (@) を付ける | `@"C:\Program Files"` |
| 数値リテラル | 数値<br>整数リテラル　と　浮動小数点リテラルがある | `10`<br>`3.14`<br>`0xFF`<br>`1.5e2` | 
| 論理値リテラル | 真偽を表す<>`ture` と `false` | `ture`<br>`false` |
| nullリテラル | オブジェクトが存在しないことを表すリテラル | `null` |
| 文字列補間 | 式を埋め込むことができる文字列リテラル。 $ を付けてダブルクォートで囲む | `$"Value: {value}"` |
| バイナリリテラル | 2進数表記のリテラル<br>`0b` プレフィックスを付ける | `0b1010`<br>`0b1111_0000` |
| 区切り記号 | 数値リテラル内で読みやすくするためのアンダースコア `_` を使用可能 |`1_000`, `3.14_15`  |
| 逐語的補間文字列 | 文字列補間と逐語的文字列リテラルを組み合わせたもの<br> `$@` または `@$` を付ける | `$@"Path: {path}"` |
| 十六進数リテラル | 16進数表記のリテラル<br>`0x` プレフィックスを付ける | `0xFF`, `0x1A3F` |

型推論とリテラル：  
* L : long (123L)
* F : float (1.23F)
* D : double (1.23D)
* M : decimal (1.23M)

### 定数と読み取り専用フィールド(値を変更しない)
* `const`
  * コンパイル時に値が決まる定数を定義する
  * 値を初期化時に必ず指定しなければならない
  * クラスメンバーとして使う場合、自動的に`static`になるため修飾子は不要
  * フィールド(クラスや構造体のメンバー):
    * constフィールドは静的メンバーとして扱われる
    * アクセス修飾子（public, privateなど）を付けられる
  * ローカル変数
    * ローカルなconst変数はスコープ内でのみ有効
  * 適用可能な場所: `フィールド`、`ローカル変数`
  * 適用可能な型: `プリミティブ型`(varでの指定はだめ)、`string`、`列挙型`(enum)、`null`(参照型の場合)
  * 適用不可な場所: クラス、構造体全体や実行時に値が決定される型。DateTimeやユーザー定義型は、コンパイル時に値を決定できないため使用不可
```C#
public class Example
{
    public const double Pi = 3.14159; // フィールド(クラスや構造体のメンバー)
    public const int MaxValue = 100;
}

class Program
{
    static void Main()
    {
        const double Pi = Math.PI; // ローカル定数
        const string Greeting = "Hello, World!";
        const int DefaultPort = 8080;
        const char NewLineChar = '\n';
    }
}
```

* `readonly`
  * 実行時に値が決まる読み取り専用フィールドを定義する
  * 実行時に動的な値を計算して設定したい場合に便利
  * 参照型に使うと、不変な参照を保証できる（ただし参照先オブジェクトの変更は可能）
```C#
public class Example
{
    public readonly int ID;

    public Example(int id)
    {
        ID = id; // コンストラクタで初期化
    }
}

class Program
{
    static void Main()
    {
        var instance = new Example(42);
        Console.WriteLine(instance.ID); // 42
    }
}
```

### 演算子とオペランドの意味
* 演算子（operator）：演算の処理内容を指定する
* オペランド（operand）：演算の対象  
例： 1 + 2 ⇒　1と2はオペランド。+は演算子

#### 算出演算子
| 演算子 | 説明 | 例 | 結果 |
| --- | --- | --- | --- |
| `+` | 足し算 | 5 + 3 | 8 |
| `-` | 引き算 | 5 - 3 | 2 |
| `*` | 掛け算 | 5 * 3 | 15 |
| `/` | 割り算 | 5 / 3 | 1 |
| `%` | 余り | 5 % 3 | 2 |

#### 代入演算子
| 演算子 | 説明 | 例 | x 結果 |
| --- | --- | --- | --- |
| `=` | 代入<br>`右辺`の値を`左辺`に代入 | int x = 5; | 5 |
| `+=` | 加算代入<br>`左辺`に`右辺`を加算して代入 | x += 3; | 8 |
| `-=` | 減算代入<br>`左辺`から`右辺`を引いて代入 | x -= 2; | 6 |
| `*=` | 乗算代入<br>`左辺`に`右辺`を掛け算して代入 | x *= 2; | 12 |
| `/=` | 除算代入<br>`左辺`を`右辺`で割って代入 | x /= 5; | 2 |
| `%=` | 剰余代入<br>`左辺`を`右辺`で割った余りを代入 | x %= 3; | 2 |

#### 比較演算子
| 演算子 | 説明 | 例 | 結果 |
| --- | --- | --- | --- |
| `==` | 等価 | 5 == 5 | true |
| `!=` | 非等価 | 5 != 3 | true |
| `>` | 大なり | 5 >= 5 | false |
| `>=` | 大なりイコール | 5 >= 5 | false |
| `<` | 小なり | 5 < 5 | false |
| `<=` | 小なりイコール | 5 <= 5 | true |

※ C#の==では、参照型（例：string）の場合でも内容比較が行われる点が特徴的  
※ ただし、object型やカスタムクラスでは参照の比較になるため、必要に応じてEqualsメソッドをオーバーライドする

#### 論理演算子
| 演算子 | 説明 | 例 | 結果 |
| --- | --- | --- | --- |
| `&&` | 論理積<br>AND | true && false | false |
| `\|\|` | 論理和<br>OR | true \|\| false | true |
| `!` | 論理否定<br>NOT | !true | false |

#### ビット演算子
| 演算子 | 使用例  | 説明 | 式の値 |
| ----- | ------- | ----- | ---- |
| &     | a & b   | a と b の論理積（AND） | 整数 |
| \|    | a \| b  | a と b の論理和（OR） | 整数 |
| ^     | a ^ b   | a と b の排他的論理和（XOR） | 整数 |
| \~    | \~a     | a のビット反転（NOT） | 整数 |
| <<    | a << n  | a を左へ n ビットシフト | 整数 |
| >>    | a >> n  | a を右へ n ビットシフト（算術シフト） | 整数 |

#### インクリメント
単項演算子（1つのオペランドに対して作用する演算子）に分類された演算子  
なお、前置/後置インクリメントの挙動はJavaと同じ  
int x = 5;
| 演算子 | 説明 | 例 | x 結果 |
| --- | --- | --- | --- |
| `++` | インクリメント | x++; | 6 |
| `--` | デクリメント | x--; | 5 |

#### その他の演算子
* **`is`演算子：** オブジェクトが指定した型に一致するかをチェックする
```C#
object obj = "Hello";
Console.WriteLine(obj is string); // True
```
* **三項演算子：** 条件式 `?` 真の場合 : 偽の場合
```C#
int a = 5, b = 10;
Console.WriteLine((a == b) ? "Yes" : "No"); // No
```

### エスケープシーケンス
| エスケープシーケンス | 説明 | 使用例 |
| ---- | ---------------------------- | ----------------------------------  |
| `\n` | 改行コード                    | 改行前\n改行後                       |
| `\t` | タブ                          | この間に\tタブ\tを差し込む           |
| `\\` | バックスラッシュ（半角￥マーク）  | バックスラッシュ（半角￥マーク）は\\ |
| `\'` | シングルクォーテーション（'）   | 文字は「\'」で囲む                   |
| `\"` | ダブルクォーテーション（"）     | 文字列は「\」で囲む                  |
| `\uXXX` | Unicode コードポイント（16進数指定）  | `Unicode:\u0041`          |
| `\r` | キャリッジリターン<br>(カーソルをその行の先頭に戻る)| キャリッジリターン\r後               |
| `\b` | バックスペース<br>(1文字分のスペースを削除して、カーソルを左に1文字移動)| バックスペース\b消去後               |

* `\r`と`\b`について：
下記コードで、リアルタイムで文字を修正するシミュレーションを示す
  * Loading. から始まり、. を削除しつつアニメーションを表示する
  * 最後に Completed! を上書きして終了
```C#
using System;

class Program
{
    static void Main()
    {
        Console.Write("Loading.");
        System.Threading.Thread.Sleep(500);
        Console.Write("\b "); // バックスペースとスペースで "." を消す
        System.Threading.Thread.Sleep(500);
        Console.Write(".");
        System.Threading.Thread.Sleep(500);
        Console.Write("\rCompleted!");
    }
}
```

#### 基本データ型
* 値型（基本データ型）は暗黙的にSystem.ValueTypeを継承しており、Javaのように明示的なラッパークラスは必要がない(例えば、intはSystem.Int32のエイリアス)
* 数値リテラルのサフィックス：数値リテラル型を明示するため、以下のサフィックスを付けることが可能
  * L : long (123L)
  * F : float (1.23F)
  * M : decimal (1.23M)
* 区切り記号：
  * int val = 1_000_000; // 1,000,000
  * double pi = 3.141_592_653_59; // π
* 型宣言時のデフォルト値
  * int : 0
  * float : 0.0f
  * bool : false
  * char : \u0000

| データ型 | ビット数（バイト数）  | 説明 |
| -------- | ------------------ | ------------- |
| bool    | 1 ビット             | true または false の２値 |
| char    | 16 ビット<br>(2 バイト) | Unicode の１文字 |
| byte    | 8 ビット<br>(1 バイト)  | 符号なし整数    0 ～ 255 |
| sbyte   | 8 ビット<br>(1 バイト)  | 符号付き整数 -128 ～ 127 |
| short   | 16 ビット<br>(2 バイト) | 符号付き整数 -32768 ～ 32767 |
| ushort  | 16 ビット<br>(2 バイト) | 符号なし整数      0 ～ 65535 |
| int     | 32 ビット<br>(4 バイト) | 符号付き整数 -2147483648 ～ 2147483647 |
| uint    | 32 ビット<br>(4 バイト) | 符号なし整数           0 ～ 4294967295 |
| long    | 64 ビット<br>(8 バイト) | 符号付き整数 -9223372036854775808 ～ 9223372036854775807  |
| ulong   | 64 ビット<br>(8 バイト) | 符号なし整数                    0 ～ 18446744073709551615 |
| float   | 32 ビット<br>(4 バイト) | 単精度浮動小数点数 ±1.5 × 10^-45 ～ ±3.4 × 10^38 |
| double  | 64 ビット<br>(8 バイト) | 倍精度浮動小数点数 ±5.0 × 10^-324 ～ ±1.7 × 10^308 |
| decimal | 128 ビット<br>(16 バイト) | 高精度な固定小数点数 ±1.0 × 10^-28 ～ ±7.9 × 10^28 |

### StringとStringBuilder
| クラス | タイプ | 特徴 |
| --- | --- | --- |
| String | 不変オブジェクト<br>Immutable Object | 変更されると常に新しいインスタンスが作成される |
| StringBuilder | 可変オブジェクト<br>Mutable Object | そのインスタンスを操作して内容を変更可能 |
```C#
using System;
using System.Text;

class Program
{
    static void Main()
    {
        // string は常に新しいインスタンスが生成される
        string s1 = "abc";
        string s2 = s1 + "def";  // 新しい文字列が生成される
        string s3 = s2.Substring(2); // 部分文字列も新しいインスタンス

        Console.WriteLine(s1); // abc
        Console.WriteLine(s2); // abcdef
        Console.WriteLine(s3); // cdef

        // StringBuilder はインスタンスそのものを変更する
        StringBuilder builder = new StringBuilder("abc");
        builder.Append("def");   // 末尾に追加
        builder.Remove(0, 2);    // 指定範囲を削除

        Console.WriteLine(builder.ToString()); // cdef
    }
}
```

### n進数
| n進数  | 書き方 | 例 |
| ------ | --- | --- |
| 10進数 | 数値そのまま記入| 27 |
| 16進数 | 先頭に`0x`を付ける | 0x1B |
| 2進数  | 先頭に`0b`を付ける | 0b11011 |
```C#
using System;

class Program
{
    static void Main()
    {
        int val_10 = 27;      // 10進数
        int val_16 = 0x1B;    // 16進数 (0x)
        int val_2 = 0b11011;  // 2進数 (0b)

        Console.WriteLine(val_10); // 27
        Console.WriteLine(val_16); // 27
        Console.WriteLine(val_2);  // 27
    }
}
```

### XMLドキュメントコメント
3つのスラッシュ（`///`）で始まり、さまざまなタグを使用する
```C#
/// <summary>
/// クラスまたはメソッドの概要を説明します。
/// </summary>
/// <param name="paramName">引数の説明。</param>
/// <returns>戻り値の説明。</returns>
public int Add(int x, int y)
{
    return x + y;
}
```
| XMLドキュメントコメント | 説明 |
| ----------- | --- |
| `<summary>`	  | 概要を記述する<br>`クラス`、`メソッド`、`プロパティ`、`フィールド`などに適用可能 |
| `<param>`     | メソッドやコンストラクタの`引数`を説明する<br>`name属性`で引数名を指定する |
| `<returns>`	  | メソッドやプロパティの`戻り値`を説明する |
| `<remarks>`   | `詳細な説明`を記述する |
| `<exception>` | `スローされる例外`を記述する |
| `<example>`   | `使用例`を記述する |
| `<value>`     | `プロパティの値`について説明する |
| `<typeparam>` | ジェネリック型の`型パラメータ`を説明する |
| `<see>`       | 別の型やメンバーへの`リンク`を提供する |
| `<seealso>`   | 関連する型やメンバーへの`リンク`を提供する（参考リンクとして記述） |

### C#の標準ライブラリ
C#のライブラリは、柔軟性、簡潔さ、パフォーマンスに焦点を当てて設計されている。
1. `コレクション操作`  
C#のコレクションは、System.Collections.Generic 名前空間を中心に、豊富なクラスで構成されています。ジェネリック型を活用することで型安全かつ効率的な操作が可能

| クラス名 | 説明 | 使用例 |
| --- | --- | --- |
| List<T> | 動的な配列。要素の追加/削除が可能 | 配列操作 |
| Dictionary<TKey, TValue> | キーと値のペアを管理 | マッピング |
| HashSet<T> | 重複を許さない集合 | 集合演算 |
| Queue<T> | FIFO（先入れ先出し）のデータ構造 | キュー |
| Stack<T> | LIFO（後入れ先出し）のデータ構造 | スタック |

2. `日時操作`  
C#では、日時操作がシンプルで強力な System 名前空間の DateTime と TimeSpan を利用する
  * `DateTime：`日時を表現するクラス。現在日時の取得、フォーマット変換、日時演算が可能
  * `TimeSpan：`期間や経過時間を表現するクラス

3. `LINQ`(System.Linq)  
コレクションやデータベースに対する操作を簡潔に記述できる、C#の特長的な機能
```C#
var numbers = new List<int> { 1, 2, 3, 4, 5 };
var evenNumbers = numbers.Where(n => n % 2 == 0).ToList();  // 偶数フィルタ
var squaredNumbers = numbers.Select(n => n * n).ToList();   // 各要素を2乗
Console.WriteLine(string.Join(", ", evenNumbers));  // 出力: 2, 4
Console.WriteLine(string.Join(", ", squaredNumbers));  // 出力: 1, 4, 9, 16, 25
```

4. `ファイル操作`(System.IO)
```C#
File.WriteAllText("example.txt", "Hello, C#!");
var content = File.ReadAllText("example.txt");
Console.WriteLine(content);  // 出力: Hello, C#!
```

5. `非同期処理` (System.Threading.Tasks)  
非同期処理は async/await キーワードを使って直感的に記述できる
```C#
async Task DoWorkAsync()
{
    await Task.Delay(1000);  // 1秒待機
    Console.WriteLine("Finished!");
}

await DoWorkAsync();
```

6. `文字列操作` (System.String)  
C#の文字列クラスは、強力で多様な操作メソッドを提供する
```C#
var str = "Hello, C#!";
Console.WriteLine(str.ToUpper());  // 出力: HELLO, C#!
Console.WriteLine(str.Substring(7, 3));  // 出力: C#!
```

7. `属性` (Attributes)
C#では、クラスやメソッドに属性を付与してメタデータを追加することができる
カスタム属性
```C#
[Obsolete("This method is deprecated.")]
void OldMethod()
{
    Console.WriteLine("This is old.");
}
```

8. イベントとデリゲート  
C#のデリゲートとイベントは、Javaのリスナーやコールバックと似ている
```C#
public class Publisher
{
    public event Action<string> OnMessage;
    public void SendMessage(string message)
    {
        OnMessage?.Invoke(message);
    }
}

var publisher = new Publisher();
publisher.OnMessage += message => Console.WriteLine($"Received: {message}");
publisher.SendMessage("Hello, World!");  // 出力: Received: Hello, World!
```

9. その他の便利なクラス
* `System.Text.StringBuilder`: 文字列の効率的な操作
* `System.Net.Http.HttpClient`: HTTPリクエストを簡単に送信
* `System.Diagnostics`: プロセスやパフォーマンス監視
