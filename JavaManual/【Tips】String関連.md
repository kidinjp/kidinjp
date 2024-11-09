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

なお、便宜を図って、各型のデフォ値を下記通りとする。  
`String` s = "Abc123";  
`StringBuilder` sb = new StringBuilder("aBC987");  
`char` c = 'a';  
`int` n = 2;  
***

## String/ StringBuilder/ char
String/ StringBuilder/ char周りの、よく使うコードまとめ  

### 大文字にする
s.`toUpperCase()`;  
`Character.toUpperCase(`c`)`;

### 小文字にする
s`.toLowerCase()`;  
`Character.toLowerCase(`c`)`;

### 大文字であるかどうか【boolean】
`Character.isUpperCase(`c`);`

### 小文字であるかどうか【boolean】
`Character.isLowerCase(`c`);`

### 文字の長さ
s`.length();`  
sb`.length();`

### 文字列を最後尾に追加する
s `+=` "abc";  
String s2 = s`.concat(`"ABC"`)`; ⇒ 結合  
sb`.append(`"abc"`)`;

### 文字列を指定位置に追加する
sb`.insert(`n`, `"abc"`)`;  
※ 指定位置がsb.length()を超えた場合エラーする

### 指定位置の文字を消す\[a\]
sb`.deleteCharAt(`n`)`;

### 指定位置範囲の文字列を消す\[a, b\)
sb`.delete(`n`, `n + 2`)`;

### 指定位置の文字を切り出す\[a\] 【char】
s`.charAt(`n`)`;  
sb`.charAt(`n`)`;

### 指定位置範囲の文字列を切り出す\[a, b\)
s`.substring(`n`, `n + 2`)`;  
sb`.substring(`n`, `n + 2`)`;  
※ どちらかが範囲を超えた場合、エラーが起きる  
※ bは省略可能\[a:\]と見なす

### 指定文字列/charの位置を割り出す（最初に見つけた位置）
s`.indexOf(`"指定文字列"`)`;
sb`.indexOf(`"指定文字列"`)`;
※ 存在しない場合は-1と返す

### 指定文字列/charの位置を割り出す（最後に見つけた位置）
s`.lastIndexOf(`"指定文字列"`)`;
sb`.lastIndexOf(`"指定文字列"`)`;
※ 存在しない場合は-1と返す

### 指定文字列を別の文字列に全置換する
s`.replace(`"元文字"`, `"置換文字"`)`; ⇒ 該当の対象は`全置換`  
※ StringBuilderの.replace()メソッドの[使い方](#指定位置範囲の文字列を消し別文字を挿入するa-b)とは違う

### 指定正規表現を別の文字列に置換する（最初に合致した内容のみ）
s`.replaceFirst(`"\\d+"`, `"X"`)`; ⇒ 最初の対象だけ`置換`、"Abc123" ⇒ "AbcX23"となる

### 指定正規表現を別の文字列に全置換する
s`.replaceAll(`"\\d+"`, `"X"`)`; ⇒ 該当の対象は`全置換`、"Abc123" ⇒ "AbcXXX"となる

### 指定位置範囲の文字列を消し、別文字を挿入する\[a, b\)
sb`.replace(`n`, `n + 2`, `"ZZZZZZ"`)`;  
※ どちらかが範囲を超えた場合、エラーが起きる  
※ Stringの.replace()メソッドの[使い方](#指定する文字列を別の文字列に置換する)とは違う

### 文字列の長さを指定長さにする\[0, n + 1\]
sb`.setLength(`0`)`; ⇒ 全クリとなる

### 文字列の長さは0であるかどうか【boolean】
s`.isEmpty()`;  
sb`.isEmpty()`;

### 文字列を逆順にする
sb`.reverse()`;

### StringBuilder を String にする
String sb_s = sb`.toString()`;

### 二つの文字列は同等であるかどうか【boolean】
s`.equals(`s`)`;  
s`.equalsIgnoreCase(`"Abc123"`)`; ⇒ 大文字/小文字を無視して比較する

### 二つの文字列aはbより後ろかどうか【boolean】
s1`.compareTo(`s2`)`;  
※ 戻り値 0：等しい  
　　　　　-1：s1 < s2 (s1の方が前、s1 = "a", s2 = "b"的な)  
　　　　　1：s2 < s1 (s2の方が前)

### メイン文字列は、指定した文字列で始めるかどうか【boolean】
s`.startsWith(`"abc"`)`;

### メイン文字列は、指定した文字列で終わるかどうか【boolean】
s`.endsWith(`"abc"`)`;

### 分割
s`.split(`"1"`)`; ⇒ {"Abc", "23"} が含むArrayとなる  
s`.split(`"1"`, n)`; ⇒ 引数に長さ上限制限できる（満たなくてもエラーにならない）

### 余分のスペースを取り除く
s`.trim()`; ⇒ s = " A "の場合、Aとなる  
※ 全角スペースは取り除かない

### 文字列をn回繰り返す
s`.repeat(`n`)`;

### 文字列に指定要素が含まれているかどうか【boolean】
s`.contains(`"abc"`)`;

### 文字列のバイト配列を取得
s`.getBytes()`'

### 数値で成り立った内容であるか(正規表現)【boolean】
s`.matches(`"[0-9]+"`)`;

***************************************************************************
## Stringクラスの静的メソッド

### 任意のオブジェクトを文字列に変換する
String`.valueOf(Object x)`;  
※ nullの場合、"null"が返される（nullではなくなる）

### 指定されたフォーマットうぃ使って文字列を生成する
String`.format(`"指定するフォーマット", "", ......`)`; ⇒ 後ろの引数の長さは使用したフォーマット指定子の数で決まる  
※ System.out.printf()と同様な方法
| フォーマット指定子 | 説明 | 例 |
| ---- | --- | --- |
| `%d` | 整数（intなど） | %d → 123 |
| `%f` | 浮動小数点数（doubleなど） | %f → 0.5 |
| `%s` | 文字列（Stringなど） | %s → s |
| `%x` | 整数の16進数表記 | %x → 7b(123の16進数) |
| `%n` | 改行（指定不要） | %n → 改行|

### 文字列群の中に文字列を挿入する
String`.join(`"挿入文字列"`, `"文字列1"`, `"文字列2"......`)`; ⇒ String.join(", ", "a", "b", "c")a, b, cのような結果  
※ 文字列群は、複数のString/コレクション型/配列を入れることができる

### 文字配列から文字列を作成する
String`.copyValueOf(`char[] data`)`;  
※ 引数は` char[] `限定、コレクション型もStringなどもダメ

### 文字配列から文字列を作成する\[a, a + b\)
String`.copyValueOf(`char[] data`, `スタートインデックス`, `取り出す長さ)`;  
※ 引数は` char[] `限定、コレクション型もStringなどもダメ  
※ a + bは <= 配列の長さ

### ロケール指定（地域や言語）
String.format(Locale locale, String format, Object... args);  
String jpFormat = String.format(Locale.JAPAN, "¥%,.2f", number);  
※ 国や地域に応じた表示や処理のルールを指定する
※ import java.util.Locale;  

ロケールを指定することで、例えば以下のような地域ごとの違いに対応できます：  
1. 数字の区切り方：千単位の区切り文字や小数点の記号（カンマやドットなど）
2. 通貨の記号とその位置（前に置くか後に置くか）
3. 日付や時刻の形式（例：YYYY/MM/DD や DD-MM-YYYY）
4. 曜日や月の名前の言語設定(曜日はEEEEと書く)

* 通貨表示変更例
``` Java
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        double number = 12345.67;

        // 日本のロケール
        String jpFormat = String.format(Locale.JAPAN, "¥%,.2f", number);
        System.out.println("Japan format: " + jpFormat);  // 出力例: Japan format: ¥12,345.67

        // アメリカのロケール
        String usFormat = String.format(Locale.US, "$%,.2f", number);
        System.out.println("US format: " + usFormat);  // 出力例: US format: $12,345.67

        // ドイツのロケール
        String deFormat = String.format(Locale.GERMANY, "%,.2f €", number);
        System.out.println("Germany format: " + deFormat);  // 出力例: Germany format: 12.345,67 €
    }
}
```

* 日付時間表示変更例
``` Java
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Date currentDate = new Date();

        // ロケールを指定しない場合（デフォルトロケール）
        // Default locale: Friday, November 8, 2024(現在時間)
        SimpleDateFormat defaultFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy");
        System.out.println("Default locale: " + defaultFormat.format(currentDate));

        // 日本のロケールを指定した場合
        // Japan locale: 金曜日, 11月 8, 2024(現在時間)
        SimpleDateFormat jpFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy", Locale.JAPAN);
        System.out.println("Japan locale: " + jpFormat.format(currentDate));

        // フランスのロケールを指定した場合
        // France locale: vendredi, novembre 8, 2024(現在時間)
        SimpleDateFormat frFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy", Locale.FRANCE);
        System.out.println("France locale: " + frFormat.format(currentDate));

        // アメリカのロケールを指定した場合
        // US locale: Friday, November 8, 2024(現在時間)
        SimpleDateFormat usFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy", Locale.US);
        System.out.println("US locale: " + usFormat.format(currentDate));

        
        // String.format(Locale.国/言語)の使用例
        // 日本のロケールで曜日を含めた日付と時刻をフォーマット
        // Japan time format with weekday: 2024年11月08日 (金曜日) 23時08分05秒(現在時間)
        SimpleDateFormat jpDateFormat = new SimpleDateFormat("yyyy年MM月dd日 (EEEE) HH時mm分ss秒", Locale.JAPAN);
        String jpFormattedDate = String.format(Locale.JAPAN, "%s", jpDateFormat.format(currentDate));
        System.out.println("Japan time format with weekday: " + jpFormattedDate);
    }
}
```

* 独自のロケール制作
``` Java
// カスタムロケール（言語: 英語、国: インド）
Locale indiaLocale = new Locale("en", "IN");
String indiaFormat = String.format(indiaLocale, "₹%,.2f", 12345.67);
System.out.println("India format: " + indiaFormat);  // 出力例: India format: ₹12,345.67
```

## その他（合わせ技的な）
### 指定内容は文字列内に特定内容の出現回数を数える
**filter関数**の利用：  
long count = s.chars().filter(ch -> ch == char文字).count();  
long count = sb.chars().filter(ch -> ch == char文字).count();
