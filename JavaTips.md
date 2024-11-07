概要
Java自体への紹介
  * [Javaについて](#javaについて)
使用上のよく使う概念
  * [要素の命名ルール](#要素の命名ルール)
    * [予約語一覧](予約語一覧)
  * [リテラルの種類](#リテラルの種類)
  * [エスケープシーケンス](#エスケープシーケンス)
  * [基本データ型（プリミティブ型）一覧](#基本データ型プリミティブ型一覧)
  * [StringとStringBuilder](#stringとstringbuilder)
  * [n進数](#n進数)
  * [演算子とオペランドの意味](#演算子とオペランドの意味)
  * [ビット演算子](#ビット演算子)
  * [Javcdocタグ](#Javcdocタグ)
***

# Javaについて
* オブジェクト指向のプログラミング言語
* オブジェクト指向プログラミングを実現する性質
  * 独立性
  * 再利用性
  * 拡張性

* オブジェクト指向プログラミングの主な手法
  * カプセル化（独立性）
  * 継承（再利用性）
  * ポリモーフィズム（拡張性）

* オブジェクト指向の三大要素
  * カプセル化（隠蔽）
  * 継承（インヘリタンス）
  * ポリモーフィズム（多態性）

*** 
下記よりよく使う前提知識をまとめる。

### 要素の命名ルール
| 要素   | 記法名 | 命名ルール | 例 |
| ------ | --- | --- | --- |
| クラス   | パスカルケース PascalCase<br>（アッパーキャメルケース） | 名詞<br>すべての単語は先頭大文字 | System<br>ArrayList<br>LinkedHashMap |
| 変数     | キャメルケース camelCase<br>（ロウワーキャメルケース） | 名詞<br>1つ目の単語は先頭小文字<br>２つ目以降の単語は先頭大文字 | out<br>modCount<br>serialVersionUID |
| 定数     | アッパースネークケース UpperCamelCase | 名詞<br>すべての単語は先頭大文字<br>間は**アンダーバーで区切る** | DATE<br>AM_PM<br>DAY_OF_WEEK |
| メソッド | キャメルケース lowerCamelCase<br>（ロウワーキャメルケース） | **動詞**<br>1つ目の単語は先頭小文字<br>２つ目以降の単語は先頭大文字 | clear()<br>isEmpty()<br>trimToSize() |

※変数（インスタンス変数、クラス変数、ローカル変数）		
そのほか習慣：習慣：
* (使えるが)日本語/全角で書かない
* 先頭小文字にする
* 予約語は使えない（clasee、intなど）
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
// 数値リテラルは_を付けて見やすく書けるようになれる
int val = 100_000;
System.out.println(val); // 100000
```

# StringとStringBuilder
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

### インクリメント
単項演算子（1つのオペランドに対して作用する演算子）
* 前置インクリメント： ++ i または -- i
  * +=1処理を行ってから数字の評価を行う
* 後置インクリメント： i ++ または i --
  * 数字の評価を行ってから+=1処理を行う
``` Java
// 前置インクリメント
int x1 = 2;
int y1 = ++x1 * 2;
// 後置インクリメント
int x2 = 2;
int y2 = x2++ * 2;

System.out.println(x1);    // 3
System.out.println(y1);    // 6
System.out.println(x2);    // 3
System.out.println(y2);    // 4
```

### ビット演算子

| 演算子 | 使用例  | 説明 | 式の値 |
| ----- | ------- | ----- | ---- |
| &     | a & b   | a と b の論理積（AND） | 整数 |
| \|    | a \| b  | a と b の論理和（OR） | 整数 |
| ^     | a ^ b   | a と b の排他的論理和（XOR） | 整数 |
| \~    | \~a     | a のビット反転（NOT） | 整数 |
| <<    | a << n  | a を左へ n ビットシフト | 整数 |
| >>    | a >> n  | a を右へ n ビットシフト（算術シフト） | 整数 |
| >>>   | a >>> n | a を右へ n ビットシフト（論理シフト） | 整数 |


### Javcdocタグ
| Javadocタグ | 説明 |
| ----------- | --- |
| @author     | **作成者**を記述する |
| @version    | **バージョン**を記述する |
| @param      | **引数の説明**を記述する |
| @return     | **戻り値の説明**を記述する |
| @throws<br>@exception | **例外の説明**を記述する |
| @deprecated | **非推奨項目である**ことを表す |
