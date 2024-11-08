概要
* Java自体への紹介
  * [Javaについて](#javaについて)
  * [JVM/JRE/JDKについて](#jvmjrejdkについて)
* よく使う概念
  * [要素の命名ルール](#要素の命名ルール)
    * [予約語一覧](#予約語一覧)
  * [リテラルの種類](#リテラルの種類)
  * [エスケープシーケンス](#エスケープシーケンス)
  * [基本データ型（プリミティブ型）一覧](#基本データ型プリミティブ型一覧)
  * [StringとStringBuilder](#stringとstringbuilder)
  * [n進数](#n進数)
  * [演算子とオペランドの意味](#演算子とオペランドの意味)
    * [算出演算子](#算出演算子)
    * [代入演算子](#代入演算子)
    * [比較演算子](#比較演算子)
    * [論理演算子](#論理演算子)
    * [ビット演算子](#ビット演算子)
    * [インクリメント](#インクリメント)
    * [その他の演算子](#その他の演算子)
  * [Javadocタグ](#javadocタグ)
  * [Javaの標準ライブラリ](#javaの標準ライブラリ)
***

# Javaについて
* **オブジェクト指向のプログラミング言語**  
  Javaはオブジェクト指向プログラミング（OOP）を前提としたプログラミング言語であり、データとそれを操作するメソッド（関数）を一つの単位で扱うことが特徴
  
* オブジェクト指向プログラミング(OOP)を実現する性質
  * **独立性**  
  オブジェクトが他のオブジェクトから独立して動作できる特性。クラスごとに明確に責任範囲が分けられ、変更が他の部分に影響を及ぼしにくくなる
  * **再利用性**  
  既存のクラスやコードを再利用することができ、無駄を省きつつ効率的に開発できる<br>例えば、親クラスのメソッドやプロパティを継承して再利用できる
  * **拡張性**  
   新しい機能を既存のシステムに追加する際に、コードを最小限の変更で対応できる特性。<br>新しいクラスを作成して機能を追加したり、既存のクラスを拡張することができる

* オブジェクト指向プログラミングの主な手法
  * **カプセル化（独立性）**  
  クラス内で変数（データ）とメソッド（操作）をまとめ、外部からアクセスを制限することで、データの不正アクセスや変更を防ぐ。<br>**アクセス修飾子**（`private`, `protected`, `public`）を使って、外部からのアクセスを制御する
  * **継承（再利用性）**
  既存のクラスを基に、新しいクラスを作成して、既存の機能を再利用したり拡張する方法。<br>Javaでは、`extends` を使ってクラスを継承し、`super` で親クラスのメソッドやコンストラクタを呼び出す
  * **ポリモーフィズム（拡張性）**
  同じメソッド名で異なる動作をさせることができる仕組みにより、コードの柔軟性と拡張性が向上する。<br>例えば、`メソッドオーバーライド`や`インターフェース`の実装を通じて、オブジェクトの型によって異なる動作をすることが可能です。

* オブジェクト指向の三大要素
  * カプセル化（隠蔽）
  * 継承（インヘリタンス）
  * ポリモーフィズム（多態性）

### JVM/JRE/JDKについて
| 項目 | JVM | JRE | JDK |
| --- | --- | --- | --- |
| **概要** | Javaプログラムを**実行する**仮想マシン | Javaプログラムを実行するための実行環境<br>（←JVMを含む） | Javaプログラムを開発するためのツールキット（←JREを含む） |
| **主な役割** | Javaバイトコードを実行する | Javaプログラムを実行するための環境を提供 | Javaプログラムを開発・コンパイル・デバッグするためのツールを提供 |
| **含まれるもの** | バイトコードの**実行機能**のみ | JVM、<br>[標準ライブラリ](#javaの標準ライブラリ)（java.lang、java.utilなど） | JRE（JVM、標準ライブラリ）、<br>コンパイラ（javac）、デバッガ（jdb）、その他開発ツール（Javadocツール: JavaコードのAPIドキュメントを生成するツール） |
| **開発用途** | プログラム**実行**のみ | プログラムを**実行用**（開発には使用できない） | Javaプログラムの**開発**に使用 |

*** 
下記よりよく使う基本知識をまとめる。

### 要素の命名ルール
| 要素   | 記法名 | 命名ルール | 例 |
| ------ | --- | --- | --- |
| クラス   | パスカルケース PascalCase<br>（アッパーキャメルケース） | 名詞<br>すべての単語は先頭大文字 | System<br>ArrayList<br>LinkedHashMap |
| 変数     | キャメルケース camelCase<br>（ロウワーキャメルケース） | 名詞<br>1つ目の単語は先頭小文字<br>２つ目以降の単語は先頭大文字 | out<br>modCount<br>serialVersionUID |
| 定数     | アッパースネークケース UpperCamelCase | 名詞<br>`単語はすべて大文字`<br>間は**アンダーバーで区切る** | DATE<br>AM_PM<br>DAY_OF_WEEK |
| メソッド | キャメルケース lowerCamelCase<br>（ロウワーキャメルケース） | **動詞**<br>1つ目の単語は先頭小文字<br>２つ目以降の単語は先頭大文字 | clear()<br>isEmpty()<br>trimToSize() |

※変数（インスタンス変数、クラス変数、ローカル変数）		
そのほか習慣：習慣：
* (使えるが)日本語/全角で書かない
* 予約語は使えない（clasee、intなど）
* 先頭小文字にする（クラス/定数じゃない場合）
* 複数の単語を組み合わせる場合、2番目以降の単語を大文字にする

#### 予約語一覧：
<table>
  <tbody>
    <tr>
      <td>abstract</td>
      <td>assert</td>
      <td>boolean</td>
    </tr>
    <tr>
      <td>break</td>
      <td>byte</td>
      <td>case</td>
    </tr>
    <tr>
      <td>catch</td>
      <td>char</td>
      <td>class</td>
    </tr>
    <tr>
      <td>const</td>
      <td>continue</td>
      <td>default</td>
    </tr>
    <tr>
      <td>do</td>
      <td>double</td>
      <td>else</td>
    </tr>
    <tr>
      <td>enum</td>
      <td>extends</td>
      <td>final</td>
    </tr>
    <tr>
      <td>finally</td>
      <td>float</td>
      <td>for</td>
    </tr>
    <tr>
      <td>goto</td>
      <td>if</td>
      <td>implements</td>
    </tr>
    <tr>
      <td>import</td>
      <td>instanceof</td>
      <td>int</td>
    </tr>
    <tr>
      <td>interface</td>
      <td>long</td>
      <td>native</td>
    </tr>
    <tr>
      <td>new</td>
      <td>null</td>
      <td>package</td>
    </tr>
    <tr>
      <td>private</td>
      <td>protected</td>
      <td>public</td>
    </tr>
    <tr>
      <td>return</td>
      <td>short</td>
      <td>static</td>
    </tr>
    <tr>
      <td>strictfp</td>
      <td>super</td>
      <td>switch</td>
    </tr>
    <tr>
      <td>synchronized</td>
      <td>this</td>
      <td>throw</td>
    </tr>
    <tr>
      <td>throws</td>
      <td>transient</td>
      <td>try</td>
    </tr>
    <tr>
      <td>void</td>
      <td>volatile</td>
      <td>while</td>
    </tr>
  </tbody>
</table>

### リテラルの種類
| 種類 | 説明 | 例 |
| --- | --- | --- |
| 文字リテラル | 1文字<br>シングルクォート (') で囲む | `'A'`<br>`'\n'` |
| 文字列リテラル | 複数の文字からなる文字列<>ダブルクォート (") で囲む | `"Hello"` |
| 数値リテラル | 数値<br>整数リテラル　と　浮動小数点リテラルがある | `10`<br>`3.14` | 
| 論理値リテラル | 真偽を表す<>`ture` と `false` | `ture`<br>`false` |

### エスケープシーケンス
| エスケープシーケンス | 説明 | 使用例 |
| ---- | ---------------------------- | ----------------------------------  |
| `\n` | 改行コード                    | 改行前\n改行後                       |
| `\t` | タブ                          | この間に\tタブ\tを差し込む           |
| `\\` | バックスラッシュ（半角￥マーク）  | バックスラッシュ（半角￥マーク）は\\ |
| `\'` | シングルクォーテーション（'）   | 文字は「\'」で囲む                   |
| `\"` | ダブルクォーテーション（"）     | 文字列は「\」で囲む                  |

### 基本データ型（プリミティブ型）一覧
| データ型 | ビット数（バイト数）  | 説明 | ラッパークラス |
| -------- | ------------------ | ---- | ------------- |
| boolean | 1 ビット             | true または false の２値 | java.lang.Boolean |
| char    | 16 ビット<br>(2 バイト) | Unicode の１文字 | java.lang.Character |
| byte    | 8 ビット<br>(1 バイト)  | 符号付き整数 -128 ～ 127 | java.lang.Byte |
| short   | 16 ビット<br>(2 バイト) | 符号付き整数 -32768 ～ 32767 | java.lang.Short |
| int     | 32 ビット<br>(4 バイト) | 符号付き整数 -2147483648 ～ 2147483647 | java.lang.Integer |
| long    | 64 ビット<br>(8 バイト) | 符号付き整数 -9223372036854775808 ～ 9223372036854775807 | java.lang.Long |
| float   | 32 ビット<br>(4 バイト) | 単精度浮動小数点数 約±3.4028235E38 ～ 約±1.4E-45<br>※ E38 … 10 の 38 乗、E-45 … 10 の -45 乗 | java.lang.Float |
| double  | 64 ビット<br>(8 バイト) | 倍精度浮動小数点数 約±1.7976931348623157E308 ～ 約±4.9E-324<br>※ E308 … 10 の 308 乗、E-324 … 10 の -324 乗 | java.lang.Double |

※ 各ラッパークラスの親クラス：`java.lang.Number`  
※ ラッパークラスは、プリミティブ型の値をオブジェクトにラップする
``` Java
// char 英文字と int の互換関係
System.out.println((int)'A');  // 65
System.out.println((int)'a');  // 97

// long と float は数値の後ろに(L/l)(F/f)を付ける必要がある
long l = 1000000000000000L;
float f = 0.5f;

// 数値リテラルは_を付けて見やすく書けるようになれる
int val = 100_000;
System.out.println(val); // 100000
```

### StringとStringBuilder
| クラス | タイプ | 特徴 |
| --- | --- | --- |
| String | 不変オブジェクト<br>Immutable Object | そのインスタンスで保持している値が変更されることはない |
| StringBuilder | 可変オブジェクト<br>Mutable Object | そのインスタンスで保持している値が変更される |
``` Java
// String は常に新しいインスタンスが生成される
String s1 = "abc";
String s2 = s1 + "def";
String s3 = s2.substring(2);

// StringBuilder はインスタンスで保持している値を変更する
StringBuilder builder = new StringBuilder("abc");
builder.append("def");
builder.delete(0, 2);
```

### n進数
| n進数  | 書き方 | 例 |
| ------ | --- | --- |
| 10進数 | 数値そのまま記入| 27 |
| 8進数  | 先頭に`0`を付ける | 033 |
| 16進数 | 先頭に`0x`を付ける | 0x1B |
| 2進数  | 先頭に`0b`を付ける | 0b11011 |
``` Java
int val_10 = 27; // 10進数(そのまま)
int val_8 = 033; // 8進数(先頭に[0])
int val_16 = 0x1B; // 16進数(先頭に[0x])
int val_2 = 0b11011; // 2進数(先頭に[0b])

System.out.println(val_10); // 27
System.out.println(val_8); // 27
System.out.println(val_16); // 27
System.out.println(val_2); // 27
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
``` Java
// ==　は オブジェクト  の場合 参照の比較 となる
//　      プリミティブ型の場合 値の比較   となる
// プリミティブ型
int x = 5;
int y = 5;
System.out.println(x == y); // true

// オブジェクト（String、コレクション型、ラッパークラス、Dateなど）
// StringBuilder はオブジェクトだが、Stringに変換してから比較するように
// equalsはオーバーライドされていないため、そのままだと参照の比較になってしまう
// 配列は Arrays.equals(li1, li2) で書く
String s1 = new String("A");
String s2 = new String("A");
System.out.println(s1 == s2);  // false

StringBuilder sb1 = new StringBuilder("B");
StringBuilder sb2 = new StringBuilder("B");
System.out.println(sb1 == sb2);         // false: 参照の比較
System.out.println(sb1.equals(sb2));    // false: 参照の比較 (equalsはオーバーライドされていないため)
System.out.println(sb1.toString().equals(sb2.toString()));   // true: 内容の比較
```
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
| >>>   | a >>> n | a を右へ n ビットシフト（論理シフト） | 整数 |

#### インクリメント
単項演算子（1つのオペランドに対して作用する演算子）に分類された演算子。
int x = 5;
| 演算子 | 説明 | 例 | x 結果 |
| --- | --- | --- | --- |
| `++` | インクリメント | x++; | 6 |
| `--` | デクリメント | x--; | 5 |

* 前置インクリメント/ デクリメント： ++ i または -- i
  * +=1処理を行ってから数字の評価を行う
* 後置インクリメント/ デクリメント： i ++ または i --
  * 数字の評価を行ってから+=1処理を行う
``` Java
// 前置インクリメント
int x1 = 2;
int y1 = ++x1 * 2;
// 後置インクリメント
int x2 = 2;
int y2 = x2++ * 2;

System.out.println(x1);  // 3
System.out.println(y1);  // 6
System.out.println(x2);  // 3
System.out.println(y2);  // 4
```

#### その他の演算子
* **`instanceof` 演算子**
  オブジェクトが指定した型のインスタンスであるかどうかをチェックする
``` Java
String s = "abc";
System.out.println(s instanceof String); // true
```
* **`三項演算子`**
  条件式?　真の場合 : 偽の場合
``` Java
int a = 5, b = 10;
System.out.println((a == b)? "Yes" : "No"); // No
```

### Javadocタグ
| Javadocタグ | 説明 |
| ----------- | --- |
| @author     | **作成者**を記述する |
| @version    | **バージョン**を記述する |
| @param      | **引数の説明**を記述する |
| @return     | **戻り値の説明**を記述する |
| @throws<br>@exception | **例外の説明**を記述する |
| @deprecated | **非推奨項目である**ことを表す |

### Javaの標準ライブラリ
* java.utilパッケージ
  * ArrayList
  * HashMap
  * HashSet
  * Collectionsクラスなど
* java.timeパッケージ
  * 日時処理 (LocalDate, LocalTime, Duration など)
