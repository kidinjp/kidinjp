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
