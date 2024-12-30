概要
* [String/ StringBuilder/ char](#string-stringbuilder-char)
  * [大文字にする](#大文字にする)
  * [小文字にする](#小文字にする)
  * [大文字であるかどうか【boolean】](#大文字であるかどうかboolean)
  * [小文字であるかどうか【boolean】](#小文字であるかどうかboolean)
  * [文字の長さ](#文字の長さ)
  * [文字列を最後尾に追加する](#文字列を最後尾に追加する)
  * [文字列を指定位置に追加する](#文字列を指定位置に追加する)
  * [指定位置の文字を消す\[a\]](#指定位置の文字を消すa)
  * [指定位置範囲の文字列を消す\[a, b\)](#指定位置範囲の文字列を消すa-b)
  * [指定位置の文字を切り出す\[a\] 【char】](#指定位置の文字を切り出すa-char)
  * [指定位置範囲の文字列を切り出す\[a, b\)](#指定位置範囲の文字列を切り出すa-b)
  * [文字列を一個ずつ取り出す方法（配列化）](#文字列を一個ずつ取り出す方法配列化)
  * [指定文字列/charの位置を割り出す（最初に見つけた位置）](#指定文字列charの位置を割り出す最初に見つけた位置)
  * [指定文字列/charの位置を割り出す（最後に見つけた位置）](#指定文字列charの位置を割り出す最後に見つけた位置)
  * [指定文字列を別の文字列に全置換する](#指定文字列を別の文字列に全置換する)
  * [指定正規表現を別の文字列に置換する（最初に合致した内容のみ）](#指定正規表現を別の文字列に置換する最初に合致した内容のみ)
  * [指定正規表現を別の文字列に全置換する](#指定正規表現を別の文字列に全置換する)
  * [指定位置範囲の文字列を消し、別文字を挿入する\[a, b\)](#指定位置範囲の文字列を消し別文字を挿入するa-b))
  * [文字列の長さを指定長さにする\[0, n + 1\]](#文字列の長さを指定長さにする0-n--1)
  * [文字列の長さは0であるかどうか【boolean】](#文字列の長さは0であるかどうかboolean)
  * [文字列を逆順にする](#文字列を逆順にする)
  * [StringBuilder を String にする](#stringbuilder-を-string-にする)
  * [二つの文字列は同等であるかどうか【boolean】](#二つの文字列は同等であるかどうかboolean)
  * [二つの文字列aはbより後ろかどうか【boolean】](#二つの文字列aはbより後ろかどうかboolean)
  * [メイン文字列は、指定した文字列で始めるかどうか【boolean】](#メイン文字列は指定した文字列で始めるかどうかboolean)
  * [メイン文字列は、指定した文字列で終わるかどうか【boolean】](#メイン文字列は指定した文字列で終わるかどうかboolean)
  * [分割](#分割)
  * [余分のスペースを取り除く](#余分のスペースを取り除く)
  * [文字列をn回繰り返す](#文字列をn回繰り返す)
  * [文字列に指定要素が含まれているかどうか【boolean】](#文字列に指定要素が含まれているかどうかboolean)
  * [文字列のバイト配列を取得](#文字列のバイト配列を取得)
  * [数値で成り立った内容であるか(正規表現)【boolean】](#数値で成り立った内容であるか正規表現boolean)
* [Stringクラスの静的メソッド](#stringクラスの静的メソッド)
  * [任意のオブジェクトを文字列に変換する](#任意のオブジェクトを文字列に変換する)
  * [指定されたフォーマットうぃ使って文字列を生成する](#指定されたフォーマットうぃ使って文字列を生成する)
  * [文字列群の中に文字列を挿入する](#文字列群の中に文字列を挿入する)
  * [文字配列から文字列を作成する](#文字配列から文字列を作成する)
  * [文字配列から文字列を作成する\[a, a + b\)](#文字配列から文字列を作成するa-a--b)
  * [ロケール指定（地域や言語）](#ロケール指定地域や言語)
* [その他（合わせ技的な）](#その他合わせ技的な)
  * [指定内容は文字列内に特定内容の出現回数を数える](#指定内容は文字列内に特定内容の出現回数を数える)
  * [文字列をforで一個ずつ取り出す方法_.toCharArray()](#文字列をforで一個ずつ取り出す方法_tochararray)
  * [a-zを出力する方法](#a-zを出力する方法)

なお、便宜を図って、各型のデフォ値を下記通りとする。  
`string` s = "Abc123";  
`StringBuilder` sb = new StringBuilder("aBC987");  
`char` c = 'a';  
`int` n = 2;  

なお、`StringBuilder`を使用する際、下記パッケージが必要  
`using System.Text;`
***************************************************************************
## String/ StringBuilder/ char
String/ StringBuilder/ char周りの、よく使うコードまとめ  

### 大文字にする
s.`ToUpper()`;  
`char.ToUpper(`c`)`;

### 小文字にする
s`.ToLower()`;  
`char.ToLower(`c`)`;

### 大文字であるかどうか【boolean】
`Character.IsUpper(`c`);`

### 小文字であるかどうか【boolean】
`Character.IsLower(`c`);`

### 文字の長さ
s`.Length;`  
sb`.Length;`

### 文字列を最後尾に追加する
s `+=` "abc";  
string s2 = string`.Concat(`s`, `"ABC"`)`; ⇒ 結合  
string s2 = s `+` "ABC";  
sb`.Append(`"abc"`)`;

### 文字列を指定位置に追加する
sb`.Insert(`n`, `"abc"`)`;  
※ 指定位置がsb.Lengthを超えた場合エラーする

### 指定位置範囲の文字列を消す\[a, a + l\)
sb`.Remove(`n`, `2`)`;  
※ どちらかが範囲を超えた場合、エラーが起きる  

### 指定位置の文字を切り出す\[a\] 【char】
s`[`n`]`;  
sb`[`n`]`;

### 指定位置範囲の文字列を切り出す\[a, b\)
s`.Substring(`n`, `n + 2`)`;  
sb`.ToString().Substring(`n`, `n + 2`)`;  
※ どちらかが範囲を超えた場合、エラーが起きる  
※ bは省略可能\[a:\]と見なす

### 文字列を一個ずつ取り出す方法（配列化）
s`.ToCharArray()`;  
sb`.ToString().ToCharArray()`;

### 指定文字列/charの位置を割り出す（最初に見つけた位置）
s`.IndexOf(`"指定文字列"`)`;  
sb`.ToString().IndexOf(`"指定文字列"`)`;  

s`.IndexOf(`"指定文字列"`,` n`)`;  
sb`.ToString().IndexOf(`"指定文字列"`,` n`)`;  
※ \[n, s.Length\]までの範囲に対して割り出す  
※ 存在しない場合は-1と返す

### 指定文字列/charの位置を割り出す（最後に見つけた位置）
s`.LastIndexOf(`"指定文字列"`)`;
sb`.ToString().lastIndexOf(`"指定文字列"`)`;
※ 存在しない場合は-1と返す

### 指定文字列を別の文字列に全置換する
s`.Replace(`"元文字"`, `"置換文字"`)`; ⇒ 該当の対象は`全置換`  
sb`.Replace(`"元文字"`, `"置換文字"`)`; ⇒ 該当の対象は`全置換`  

※ StringBuilderの.replace()メソッドの[使い方](#指定位置範囲の文字列を消し別文字を挿入するa-b)とは違う

### 指定正規表現を別の文字列に置換する（最初に合致した内容のみ）
```C#
using System;
using System.Text.RegularExpressions;

class Program
{
    static void Main()
    {
        string s = "Abc123Abc123";

        // 最初の一致部分だけを取得
        Match match = Regex.Match(s, "\\d+");
        if (match.Success)
        {
            // 最初の一致部分を置換
            s = s.Substring(0, match.Index) + "X" + s.Substring(match.Index + match.Length);
        }

        Console.WriteLine(s); // 出力: "AbcXAbc123"
    }
}
```

### 指定正規表現を別の文字列に全置換する
System.Text.RegularExpressions.Regex.Replace(s, "\\d", "X"); ⇒ 該当の対象は`全置換`、"Abc123" ⇒ "AbcXXX"となる  
System.Text.RegularExpressions.Regex.Replace(s, "\\d+", "X"); ⇒ 該当の対象は`全置換`、"Abc123Abc123" ⇒ "AbcXAbcX"となる

### 文字列の長さを指定長さにする\[0, n + 1\]
sb`.Length` = 0; ⇒ 全クリとなる

### 文字列の長さは0であるかどうか【boolean】
s`.Length` == 0;  
sb`.Length` == 0;

### 文字列を逆順にする
new string(s`.Reverse().ToArray()`);  
new StringBuilder(new string(sb.ToString()`.Reverse().ToArray()`));  
※ `using System.Linq;`を使う

### StringBuilder を string にする
String sb_s = sb`.ToString()`;

### 二つの文字列は同等であるかどうか【boolean】
s == s2; ⇒ 完全一致  
s`.Equals(`s2`)`; ⇒ 完全一致  
s`.Equals(`s2`, StringComparison.OrdinalIgnoreCase)`; ⇒ 大文字/小文字を無視して比較する  

sb == sb2; ⇒ 完全一致  
sb`.Equals(`sb2`)`; ⇒ 完全一致  
※ `StringBuilder`では`StringComparison.OrdinalIgnoreCase`の`StringComparison`をサポートしていないため使用できない。どうしてもの場合は`.ToString()`

### 二つの文字列aはbより後ろかどうか【boolean】
s1`.Compare(`s2`)`;  
※ 戻り値 0：等しい  
　　　　　-1：s1 < s2 (s1の方が前、s1 = "a", s2 = "b"的な)  
　　　　　1：s2 < s1 (s2の方が前)

### メイン文字列は、指定した文字列で始めるかどうか【boolean】
s`.StartsWith(`"abc"`)`;

### メイン文字列は、指定した文字列で終わるかどうか【boolean】
s`.EndsWith(`"abc"`)`;

### 分割
s`.Split(`"1"`)`; ⇒ {"Abc", "23"} が含むArrayとなる  
s`.Split(`"1"`, n)`; ⇒ 引数に長さ上限制限できる（満たなくてもエラーにならない）  
s`.Split(`new[] {' ', '/', ':'}`)`; ⇒ 複数の対象を入れる(この場合\[\]`の間にある【 】(スペース)、【/】、【:】)

### 余分のスペースを取り除く
s`.Trim()`; ⇒ s = " A "の場合、Aとなる  
※ 全角スペースは取り除かない

### 文字列をn回繰り返す
`string.Concat(`Enumerable.Repeat(s, n)`)`;  
new `string(`c, n); ⇒ charを繰り返せる  
`string.Concat(`Enumerable.Repeat(sb, n)`)`;

### 文字列に指定要素が含まれているかどうか【boolean】
s`.Contains(`"abc"`)`;

### 文字列のバイト配列を取得
byte[] bytes = `Encoding.UTF8.GetBytes(`s`)`;

### 数値で成り立った内容であるか(正規表現)【boolean】
`Regex.IsMatch(`s, @"^\[0-9\]+$"`)`;

**************************************************************************
## Stringクラスの静的メソッド

### 任意のオブジェクトを文字列に変換する
`Convert.ToString(`object obj`)`;  
※ nullの場合、**空文字列**が返される

### 指定されたフォーマットうぃ使って文字列を生成する
string`.Format(`"指定するフォーマット", object[] または object)`;  
なお、下記表の【0】との部分は`object`内容のインデックスで指定する
| フォーマット指定子 | 説明 | 例 |
| ---- | --- | --- |
| `{0:D}` | 整数（intなど） | {0:D} → 123 |
| `{0:F}` | 浮動小数点数（doubleなど） | {0:F2} → 0.50 |
| `{0:X}` | 整数の16進数表記 | {0:X} → 7B |
| `{0}` | 文字列やその他オブジェクト | {0} → HelloWorld |

```C#
string[] w = {"abc", "999", "Test"};
Console.WriteLine(string.Format("{2}【{0}】, {1}", w)); // Test【abc】, 999　と出力する
```

### 文字列群の中に文字列を挿入する
String`.join(`"挿入文字列"`, object[]`)`;   
```C#
string[] words = { "a", "b", "c" };
string joined = string.Join(", ", words); // "a, b, c"
```

### 文字配列から文字列を作成する
new `string(`char[] data`)`;  
※ 引数は` char[] `限定、コレクション型もStringなどもダメ

### 文字配列から文字列を作成する\[a, a + b\)
new `string(`char[] data`, `スタートインデックス`, `取り出す長さ)`;  
※ 引数は` char[] `限定、コレクション型もStringなどもダメ  
※ a + bは <= 配列の長さ

### ロケール指定（地域や言語）
string.Format(`IFormatProvider provider`, string format, params object[] args)  
C# では `CultureInfo` クラスを使用してロケールを指定する
`System.Globalization.CultureInfo` を利用して、異なる文化圏のフォーマットに対応する

* 通貨表示変更例
``` C#
using System;
using System.Globalization;

class Program
{
    static void Main()
    {
        double number = 12345.67;

        // 日本のロケール
        string jpFormat = string.Format(new CultureInfo("ja-JP"), "¥{0:N2}", number);
        Console.WriteLine("Japan format: " + jpFormat); // 出力例: Japan format: ¥12,345.67

        // アメリカのロケール
        string usFormat = string.Format(new CultureInfo("en-US"), "${0:N2}", number);
        Console.WriteLine("US format: " + usFormat); // 出力例: US format: $12,345.67

        // ドイツのロケール
        string deFormat = string.Format(new CultureInfo("de-DE"), "{0:N2} €", number);
        Console.WriteLine("Germany format: " + deFormat); // 出力例: Germany format: 12.345,67 €
    }
}
```

日付と時刻をフォーマットする  
`DateTime`.ToString(string format, `IFormatProvider provider`)  
* 日付時間表示変更例
``` C#
using System;
using System.Globalization;

class Program
{
    static void Main()
    {
        DateTime now = DateTime.Now;

        // 日本のロケール
        string jpDate = now.ToString("yyyy年MM月dd日 (dddd)", new CultureInfo("ja-JP"));
        Console.WriteLine("Japan: " + jpDate); // 例: Japan: 2024年11月08日 (金曜日)

        // アメリカのロケール
        string usDate = now.ToString("dddd, MMMM dd, yyyy", new CultureInfo("en-US"));
        Console.WriteLine("US: " + usDate); // 例: US: Friday, November 8, 2024
    }
}
```

* 独自のロケール制作
``` C#
using System;
using System.Globalization;

class Program
{
    static void Main()
    {
        // 独自のロケール（インドの例）
        CultureInfo indiaCulture = new CultureInfo("en-IN");
        string indiaFormat = string.Format(indiaCulture, "₹{0:N2}", 12345.67);
        Console.WriteLine("India format: " + indiaFormat); // 出力例: ₹12,345.67
    }
}
```

**************************************************************************
## その他（合わせ技的な）
### 指定内容は文字列内に特定内容の出現回数を数える
**LINQのCountメソッド**を利用：  
using System.Linq;  
int count = s`.Count(`ch `=>` ch `==` char);   
※　chの部分は一文字ずつでの比較のため、直接にstringでの比較はできない  

文字列で検索：
```C#
using System;
using System.Linq;

class Program
{
    static void Main()
    {
        string str = "AbcAbdAbAb";
        string target = "Ab";
        int count = 0;
        int index = 0;

        while ((index = str.IndexOf(target, index)) != -1)
        {
            count++;
            index += target.Length; // 部分文字列の長さ分進める
        }

        Console.WriteLine($"The substring '{target}' appears {count} times.");
    }
}
```

### 文字列をforで一個ずつ取り出す方法_.toCharArray()
for (char i : s.toCharArray()) {(以下略)  
for (char i : sb.toCharArray()) {(以下略)  
foreach(char i in s) Console.WriteLine(i);  
foreach(char i in sb) Console.WriteLine(i);


### a-zを出力する方法
1. 
for (char i = 'a'; i < 'z' + 1; i++) {  
    Console.WriteLine(i);  
}  
2. 
for (int i = 0; i < 26; i++) {  
    Console.WriteLine((char)('a' + i));  
}
