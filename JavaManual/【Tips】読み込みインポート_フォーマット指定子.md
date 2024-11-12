概要
* [Scannerクラスについて](#scannerクラスについて)
  * [Scanner起動（オブジェクト作成）](#scanner起動オブジェクト作成)
  * [スキャン、読み込み（単純）](#スキャン読み込み単純)
  * [Lineごとスキャン、読み込み（プリミティブ型/ラッパークラス）](#lineごとスキャン読み込みプリミティブ型ラッパークラス)
  * [Lineごとスキャン、読み込み（配列）](#lineごとスキャン読み込み配列)
  * [Lineごとスキャン、読み込み（コレクションフレームワーク（List、Set<del>、Map</del>））](#lineごとスキャン読み込みコレクションフレームワークlistsetmap)
  * [区切り設定](#区切り設定)
  * [読み込める内容がまだあるかどうか【boolean】](#読み込める内容がまだあるかどうかboolean)
  * [クローズ](#クローズ)
* [フォーマット指定子](#フォーマット指定子)
  * [基本構文【引数番号、フラグ、幅、精度、変換文字】](#基本構文引数番号フラグ幅精度変換文字)
    * [変換文字](#変換文字)
    * [フラグ、幅、精度](#フラグ幅精度)
    * [引数番号](#引数番号)
  * [具体例](#具体例)
 
なお、便宜を図って、各型のデフォ値を下記通りとする。
`Scanner` sc = new Scanner(System.in);
***************************************************************************
## Scannerクラスについて
Javaでは、データ入力の読み込みを行うには`Scanner`クラスを利用し、スキャンナー及びスキャンの動作が必要。
* 継承したクラス：`java.lang.Object`
* スキャンナーのパッケージ位置： `import java.util.Scanner;`/ `import java.util.*;`


### Scanner起動（オブジェクト作成）
Scanner 変数 = new Scanner(読み込み内容);  
**変数名**：基本は`scanner` または `sc` または `用途と模した名前` など  
**読み込み内容**：`文字列` または `System.in`（利用者の直接入力）
``` Java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // スキャンナーの基本の形、Scannerオブジェクトを作成
        Scanner sc = new Scanner(System.in);
    }
}
```
### スキャン、読み込み（単純）
sc.next();      ⇒  String  
sc.nextLine();  ⇒  String  
sc.nextInt();  
sc.nextLong();  
sc.nextShort();  
sc.nextDouble();  
sc.nextFloat();  
sc.nextBoolean();  
※ 例えば入力欄が【1\n2】に対して、sc.nextInt()を1回行ったとする。  
　　sc.nextLine()を行うと【\n】の部分のみスキャンしてしまうので、  
　　sc.nextLine()を使うタイミングを見極めよう。  
   またはInteger.parseInt(sc.nextLine())などの書き方でラインごと数値解析しよう。

#### Lineごとスキャン、読み込み（プリミティブ型/ラッパークラス）
本項は、入力内容は該当する型と同じ型が入力された際が前提となる対処法。
``` Java
String str = sc.nextLine();
char   c   = sc.nextLine().charAt(0);
int    n   = Integer.parseInt(sc.nextLine());
long   l   = Long.parseLong(sc.nextLine());
short  s   = Short.parseShort(sc.nextLine());
double d   = Double.parseDouble(sc.nextLine());
float  f   = Float.parseFloat(sc.nextLine());
boolean b  = Boolean.parseBoolean(sc.nextLine());
```
※ プリミティブ型/ラッパークラスの間、改めて変換不要のためプリミティブ型のみを記載する

#### Lineごとスキャン、読み込み（配列）
本項は、入力内容は該当する型と同じ型が入力された際が前提となる対処法。  
なお、一行に複数のデータがある場合、空白文字で区切られる。

``` Java
import java.util.stream.*; // Arrays.stream()を使う場合これは必須となる

// String[]
String[] arrayString = sc.nextLine().split(" ");

// char[] 、1つの文字列を1文字ずつ収納する場合
char[] charArray1 = sc.nextLine().toCharArray();

// char[]、【'a' 'b' 'c'】などのような内容を読み込む場合
char[] charArray2 = sc.nextLine().replace(" ", "").toCharArray();

// Character[]
Character[] charWrapperArray = sc.nextLine().replace(" ", "").chars()
                                          .mapToObj(c -> (char) c)
                                          .toArray(Character[]::new);

// int[]
int[] arrayInt = Arrays.stream(sc.nextLine().split(" "))
                       .mapToInt(Integer::parseInt)
                       .toArray();

// Integer[]
Integer[] arrayInteger = Arrays.stream(sc.nextLine().split(" "))
                               .map(Integer::parseInt)
                               .toArray(Integer[]::new);

// long[]
long[] arrayLong = Arrays.stream(sc.nextLine().split(" "))
                         .mapToLong(Long::parseLong)
                         .toArray();
// Long[]
Long[] arrayLongWrapper = Arrays.stream(sc.nextLine().split(" "))
                                .map(Long::parseLong)
                                .toArray(Long[]::new);

// double[]
double[] arrayDouble = Arrays.stream(sc.nextLine().split(" "))
                              .mapToDouble(Double::parseDouble)
                              .toArray();

// Double[]
Double[] arrayDoubleWrapper = Arrays.stream(sc.nextLine().split(" "))
                                   .map(Double::parseDouble)
                                   .toArray(Double[]::new);

// float[] mapToFloat メソッドは存在していないためスキップ

// Float[]
Float[] arrayFloatWrapper = Arrays.stream(sc.nextLine().split(" "))
                                  .map(Float::parseFloat)
                                  .toArray(Float[]::new);

// boolean[]　スキップ

// Boolean[] 
Boolean[] arrayBooleanWrapper = Arrays.stream(sc.nextLine().split(" "))
                                      .map(Boolean::parseBoolean)
                                      .toArray(Boolean[]::new);
```

#### Lineごとスキャン、読み込み（コレクションフレームワーク（List、Set<del>、Map</del>））
本項は、入力内容は該当する型と同じ型が入力された際が前提となる対処法。  
なお、一行に複数のデータがある場合、空白文字で区切られる。  
（今回はよく使うString、Integerをメインに例に挙げます）
* コレクション型（リスト）：
```Java
import java.util.List; // Listクラスのインポート
import java.util.ArrayList; // ArrayListクラスのインポート
import java.util.LinkedList; // LinkedListクラスのインポート
// import java.util.*;だけでおｋ

// List<String>
List<String> liString = Arrays.asList(sc.nextLine().split(" "));

// List<Integer>
List<Integer> liInt = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

// ArrayList<String>
ArrayList<String> aliString = new ArrayList<>(
                        Arrays.asList(sc.nextLine().split(" "))
                    );

// ArrayList<Integer>
ArrayList<Integer> aliInt = new ArrayList<>(
                            Arrays.stream(sc.nextLine().split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList())
                        );

// LinkedList<String>
LinkedList<String> linkString = new LinkedList<>(
    Arrays.asList(sc.nextLine().split(" "))
);

// LinkedList<Integer>
LinkedList<Integer> linkInt = new LinkedList<>(
    Arrays.stream(sc.nextLine().split(" "))
    .map(Integer::parseInt)
    .collect(Collectors.toList())
);
```

* コレクション型（セット）：
```Java
import java.util.Arrays;
import java.util.stream.*;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

// Set<String>
Set<String> setString = new HashSet<>(
    Arrays.asList(sc.nextLine().split(" "))
    );

// Set<Integer>
Set<Integer> setInt = new HashSet <>(
    Arrays.stream(sc.nextLine().split(" "))
    .map(Integer::parseInt)
    .collect(Collectors.toList())
    );

// HashSet<String>
HashSet<String> hashSetString = new HashSet<>(
    Arrays.asList(sc.nextLine().split(" "))
    );

// HashSet<Integer>
HashSet<Integer> hashSetInt= new HashSet <>(
    Arrays.stream(sc.nextLine().split(" "))
    .map(Integer::parseInt)
    .collect(Collectors.toList())
    );

// LinkedHashSet<String>
LinkedHashSet<String> linkedHashSetString = new LinkedHashSet<>(
    Arrays.asList(sc.nextLine().split(" "))
    );

// LinkedHashSet<Integer>
LinkedHashSet<Integer> linkedHashSetInt = new LinkedHashSet <>(
    Arrays.stream(sc.nextLine().split(" "))
    .map(Integer::parseInt)
    .collect(Collectors.toList())
    );

// TreeSet<String>
TreeSet<String> treeSetString = new TreeSet<>(
    Arrays.asList(sc.nextLine().split(" "))
    );

// TreeSet<Integer>
TreeSet<Integer> treeSetInt= new TreeSet <>(
    Arrays.stream(sc.nextLine().split(" "))
    .map(Integer::parseInt)
    .collect(Collectors.toList())
    );
```

### 区切り設定
scanner.useDelimiter(", ");　⇒　"A, B, C"が【A】【B】【C】に分けて区切って取り出す  
デフォ：空白文字
* 空白（半角スペース）（全角スペースは対象外）
* タブ（\t）
* 改行（\n）
* 復帰（\r）

**デフォに戻す方法**：【"\\s+"】に設定する

### 読み込める内容がまだあるかどうか【boolean】
sc.hasNext();  
sc.hasNextLine();  
sc.hasNextInt();  
sc.hasNextLong();  
sc.hasNextShort();  
sc.hasNextDouble();  
sc.hasNextFloat();  
sc.hasNextBoolean();  
※ whileとかを掛けて計算する場合もある

### クローズ
sc.close()  
※ リソースを解放することができる、他スキャンナーと混乱しないためなど、推奨項目

***************************************************************************
## フォーマット指定子
おさらい：[フォーマット指定子](/【Tips】String関連.md#指定されたフォーマットうぃ使って文字列を生成する)  
String`.format(`"指定するフォーマット", "", ......`)`; ⇒ 後ろの引数の長さは使用したフォーマット指定子の数で決まる    
`System.out.printf(`"指定するフォーマット", "", ......`)`;

### 基本構文【引数番号、フラグ、幅、精度、変換文字】
% `引数番号$` `フラグ` `幅` `.精度` `変換文字`  
全体を""(ダブルクォーテーション)で囲む

| 要素 | 意味 | 例 |
| ---- | --- | --- |
| `%` | フォーマット指定子の始まり | `%d`<br>`%s` |
| 引数番号 | 引数の順番を指定する（1から始まる） | `%2$d`（2番目の引数） |
| フラグ | 整形のルールを指定 | `-`（左揃え）<br>`+`（符号表示） |
| 幅 | 出力の最小幅を指定、右揃え<br>値の長さが幅を超えてない場合：スペース埋めされ<br>値の長さが幅を超えた場合：そのまま表示 | `%5d`（幅5で整数出力） |
| 精度 | 小数点以下の桁数、文字列の最大文字数を指定 | %.2f（小数点以下2桁） |
| 変換文字 | データの型を指定 | `d`：整数<br>`f`：浮動小数点<br>`s`：文字列 |

### 変換文字
| フォーマット指定子 | データ型 | 説明 | 例 |
| ---- | --- | --- | --- |
| `%d` | 整数 | 10進数の整数（intなど） | %d → 123 |
| `%x`<br>`%X` | 整数 | 16進数の整数 | %x → 0x7b(123の16進数)<br> %X → xxx |
| `%o` | 整数 | 8進数の整数 | %o → 173 |
| `%f` | 浮動小数点 | 10進数の浮動小数点数（doubleなど）<br>**四捨五入** | %f → 0.5 |
| `%e`<br>`%E` | 浮動小数点 | 指数表記で表示 | %e → 1.23e+02<br> %E → 1.23e+02 |
| `%g`<br>`%G` | 浮動小数点 | `%f`と`%e`のうち短い方で表示 | %g → 1.23e+02<br> %G → 1.23e+02 |
| `%s` | 文字列 | 文字列（Stringなど） | %s → "ABC" |
| `%c` | 文字 | 文字（charなど） | %c → 'a' |
| `%b` | ブール値 | boolean<br>`null` は `false`と見なす | %b → true |
| `%n` | 改行 | 改行（指定不要） | %n → 改行|

**大文字と小文字について**  
出力される文字を指定するための使い分け
``` Java
System.out.printf("%x%n", 123); // 7b を出力
System.out.printf("%E%n", 123.45); // 1.234500E+02 を出力
```

#### フラグ、幅、精度
**整数**：  
* "%05d" ⇒ 幅5で、0埋め【00123】
* "%,d" ⇒ カンマ区切り【1,000】
* "%+d" ⇒ 正負の記号を付ける【+10】【-10】
* "%(d" ⇒ 負数の場合（）を付ける【(10)】

※ 0埋めは、（）、記号、値をすべて含めた長さに0を埋める【(0001,234)】⇒ 長さ10  
※ "%(+d" ⇒ 正数：【+10】、負数：【(10)】、のように複数のフラグを掛け合わせることも可能

**浮動小数点**：
* "%8.2f" ⇒ 幅8（小数点自体も含む）で、小数点以下2桁まで表示（四捨五入）【  123.46】
* "%05f" ⇒ 幅8で、0埋め【00123.12】
* "%,f" ⇒ カンマ区切り【1,000】
* "%+f" ⇒ 正負の記号を付ける【+10.5】【-10.5】
* "%(f" ⇒ 負数の場合（）を付ける【(10.5)】

**文字列**： 
* -幅："%-5s" ⇒ 幅5で、左揃え
* .幅："%.5s" ⇒ 幅ではなく、最大5文字数となる【普段の幅は長さに対して削減しない】

文字列に対して「0埋め」はできないので、代替案として以下通りに書きます：
``` Java
String ume = String.format("%10s", "abc").replace(' ', '0');
System.out.println(ume);
```

#### 引数番号
番号を指定して表示したい内容を指定順に表示する  
左から1，2...番
```Java
System.out.printf("%2$d, %1$d", 10, 20); // 【20, 10】
```

#### 具体例
通貨表示  
`%,.2f` ⇒ カンマ付き、小数点以下2桁まで（四捨五入）
``` Java
System.out.printf("$%,.2f", 1234567.89); // $1,234,567.89
```

ゼロ埋め  
`%05d` ⇒ 5桁になるまで左のほうに0を埋める
```java
System.out.printf("%05d", 42); // 00042
```

改行  
```java
System.out.printf("Line1\nLine2");
// Line1
// Line2
```
