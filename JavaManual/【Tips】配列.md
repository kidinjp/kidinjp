概要
* [配列の特徴](#配列の特徴)
* [主なコード一覧](#主なコード一覧)
  * [配列内の要素数/長さを返す](#配列内の要素数長さを返す)
  * [特定の文字列で元の文字列を分割する](#特定の文字列で元の文字列を分割する)
  * [文字をchar配列に一文字ずつを入れる](#文字をchar配列に一文字ずつを入れる)
  * [二つの配列の結合](#二つの配列の結合)
  * [出力](#出力)
    * [二重配列のforEach](#二重配列のforeach)
    * [join](#join)
* [Arraysの静的メソッド](#arraysの静的メソッド)
  * [ある要素で配列を埋め尽くす（初期化）](#ある要素で配列を埋め尽くす初期化)
  * [指定した計算式で初期化](#指定した計算式で初期化)
  * [ソート、昇順](#ソート昇順)
  * [ソート、昇順、範囲指定\[a, b\)](#ソート昇順範囲指定a-b)
  * [ソート、逆順](#ソート逆順)
  * [ソートしない、逆順](#ソートしない逆順)
  * [特定の要素を検索](#特定の要素を検索)
  * [指定されたオブジェクトがこのリストと等しいかどうか【boolean】](#指定されたオブジェクトがこのリストと等しいかどうかboolean)
  * [指定されたオブジェクトがこの二重リストと等しいかどうか【boolean】](#指定されたオブジェクトがこの二重リストと等しいかどうかboolean)
  * [配列内に特定の要素が含まれているか/ 特定条件に合致する要素があるかどうか【boolean】](#配列内に特定の要素が含まれているか-特定条件に合致する要素があるかどうかboolean)
  * [配列のミスマッチ](#配列のミスマッチ)
  * [コピー\[0, b\)](#コピー0-b)
  * [コピー\[a, b\)](#コピーa-b)
  * [変換](#変換)
    * [String配列をInteger配列にする](#string配列をinteger配列にする)
    * [String配列をint配列にする(二重)](#string配列をint配列にする(二重))
    * [配列を文字列に変換](#配列を文字列に変換)
    * [二重配列を文字列に変換](#二重配列を文字列に変換)
    * [配列をリストに変換](#配列をリストに変換)
    * [リストを配列に変換](#リストを配列に変換)
    * [配列をセットに変換](#配列をセットに変換)
    * [配列をストリームとして操作](#配列をストリームとして操作)
    * [配列をハッシュコードに変換](#配列をハッシュコードに変換)
    * [二重配列をハッシュコードに変換](#二重配列をハッシュコードに変換)
* [Collectionsクラスのユーティリティメソッド応用](#collectionsクラスのユーティリティメソッド応用)
  * [xというものが現れた回数](#xというものが現れた回数)
  * [最小値（Collectionsクラス）](#最小値collectionsクラス)
  * [最大値（Collectionsクラス）](#最大値collectionsクラス)
* [stream応用](#stream応用)
  * [最小値](#最小値)
  * [最大値](#最大値)
  * [sum合計値](#sum合計値)
  * [sum合計値、\[a:b\)](#sum合計値ab)

なお、便宜を図って、各型のデフォ値を下記通りとする。
`String[]` arr = {"A", "B", "C"};
`Integer[]` arr = {1, 2, 3};
***************************************************************************
## 配列の特徴
* **import java.util.*;**
* **固定サイズ** 配列のサイズは作成時に決まり、動的に変更できない
* **同じ型の要素** 配列には同じデータ型の要素しか格納できない
* **ゼロベースインデックス** 配列の要素は0から始まるインデックスでアクセスする
* **連続したメモリ領域** 配列の要素はメモリ上で連続して格納されており、高速なランダムアクセスが可能
* **配列要素はデフォルト値で初期化される**
  * **数値型**（int, doubleなど）：0
  * **boolean型**：false
  * **参照型**（Stringやラッパークラス、その他クラス）：null
* **宣言と初期化**
```Java
// 空の Array を生成、初期容量を指定
String[] arr = new String[i];

// 初期要素付きで生成する
int[] arr2 = {1, 2, 3, 4, 5};
```

***************************************************************************
## 主なコード一覧
### 配列内の要素数/長さを返す
arr.length;  ⇒  シンプルで効率的  
Arrays.getlength(arr);  ⇒  リフレクションを利用（`java.lang.reflect.Array`）

### 特定の文字列で元の文字列を分割する
String[] li = 文字列.split(" ");  
※ 【1, 2, 3】に対して【, 】を分割すると⇒【1】【2】【3】となる

### 文字をchar配列に一文字ずつを入れる
char[] charArray = s.toCharArray();

### 二つの配列の結合
IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray();  
※ IntStreamは、int[]のみしか使えない結合方法  

汎用的な結合方法：
`Stream.concat` + `Arrays.stream`
```Java
String[] result = Stream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                        .toArray(String[]::new); // ここは結合していきたい内容の型に合わせる
//                        .toArray(Integer[]::new); // の場合もあるなど
```

### 出力
直接にliを出力しようとすると[Ljava.lang.Integer;@2626b418のような内容が出来るので、Arrays.toString()などの処理が必要  
Arrays.asList(arr).forEach(i -> System.out.println(i));  
Arrays.toString(li)  
Arrays.deepToString(li)　⇒　二重配列

#### 二重配列のforEach
```Java
Arrays.stream(teams).forEach(i -> {
    System.out.println(Arrays.toString(i));
});
```

#### join
System.out.println(String.join(" ", arr));  
※ String[]などの文字列にのみに対応可能

***************************************************************************
## Arraysの静的メソッド

### ある要素で配列を埋め尽くす（初期化）
Arrays.fill(arr, 埋め尽くしたい内容); 

### 指定した計算式で初期化
Arrays.setAll(arr, i -> 計算式);  または  
Arrays.parallelSetAll(arr, i -> 計算式);  
※ ここのiは位置（インデックス）と指す

### ソート、昇順
Arrays.sort(arr);　または  
Arrays.parallelSort(arr);  
※ 大きな配列を並列処理でソートするのに適している  
※ スレッドを使ってソートを効率化

### ソート、昇順、範囲指定[a, b)
Arrays.sort(arr, a, b);

### ソート、逆順
Arrays.sort(li, Comparator.reverseOrder());

### ソートしない、逆順
Collections.reverse(li); 

### 特定の要素を検索
Arrays.binarySearch(arr, 特定の要素);  　または  
Arrays.asList(li).indexOf(n);

### 指定されたオブジェクトがこのリストと等しいかどうか【boolean】
Arrays.equals(arr1, arr2);

### 指定されたオブジェクトがこの二重リストと等しいかどうか【boolean】
Arrays.deepEquals(arr1, arr2);

### 配列内に特定の要素が含まれているか/ 特定条件に合致する要素があるかどうか【boolean】
Arrays.stream(arr).anyMatch(i -> i == 5);

### 配列のミスマッチ
Arrays.mismatch(arr1, arr2);  
※ 異なる最初のインデックスを返す
```Java
int[] arr1 = {1, 2, 3};
int[] arr2 = {1, 4, 3};
int index = Arrays.mismatch(arr1, arr2); // 1
```

### コピー[0, b)
Arrays.copyOf(arr, b);
```Java
var arr2 = Arrays.copyOf(arr, 2); // 
```

### コピー[a, b)
Arrays.copyOfRange(arr, a, b);
```Java
var arr2 = Arrays.copyOfRange(arr, 1, 3); // 
```

### 変換

#### String配列をInteger配列にする
```Java
Integer[] arrInteger = Arrays.stream(arrString)
                             .map(Integer::parseInt)
//                           .sorted()　⇒　ソート
//                           .sorted(Comparator.reverseOrder())　⇒　ソートして逆順
                             .toArray(Integer[]::new);
```

#### String配列をint配列にする(二重)
```Java
int[] arrInteger = Arrays.stream(arrString)
                         .mapToInt(Integer::parseInt)
                         .toArray(); 
```

#### 配列を文字列に変換
Arrays.toString(arr);

#### 二重配列を文字列に変換
Arrays.deepToString(arr);

#### 配列をリストに変換
Arrays.asList(arr);

#### リストを配列に変換
* String リスト
```Java
String[] arr = li.toArray(new String[li.size()]);
String[] arr = li.stream()
                 .toArray(String[]::new);
```

* Integer リスト
```Java
int[] a = li.stream()
            .mapToInt(Integer::intValue)
            .toArray();
```

#### 配列をセットに変換
new Set<>(Arrays.asList(arr));

#### 配列をストリームとして操作
Arrays.stream(arr);
```Java
int[] intArray = {1, 2, 3};
Integer[] boxedArray = Arrays.stream(intArray).boxed().toArray(Integer[]::new); // int → Integer
int[] primitiveArray = Arrays.stream(boxedArray).mapToInt(Integer::intValue).toArray(); // Integer → int
```

#### 配列をハッシュコードに変換
Arrays.hashCode(arr);

#### 二重配列をハッシュコードに変換
Arrays.deepHashCode(arr);

***************************************************************************
## Collectionsクラスのユーティリティメソッド応用
[おさらい](/【1List】ArrayList.md#collectionsを利用したコード)

### xというものが現れた回数
Collections.frequency(Arrays.asList(arr), x);

### 最小値（Collectionsクラス）
Collections.min(Arrays.asList(arr));  
Arrays.stream(arr).min().orElseThrow();　⇒　プリミティブ型配列のみ  
Arrays.stream(arr).min(Comparator.naturalOrder()).orElseThrow();

### 最大値（Collectionsクラス）
Collections.max(Arrays.asList(arr));  
Arrays.stream(arr).max().orElseThrow();　⇒　プリミティブ型配列のみ  
Arrays.stream(arr).max(Comparator.naturalOrder()).orElseThrow();

***************************************************************************
## stream応用

### 最小値
Arrays.stream(arr).min(Integer::compareTo).get();  
Arrays.stream(arr).min().orElse(0); 

### 最大値
Arrays.stream(arr).max(Integer::compareTo).get();  
Arrays.stream(arr).max().orElse(0); 

これまでに紹介した最小値/最大値のやり方の比較：
| コード | 特徴 | 推奨 |
| --- | --- | --- |
| `Collections.min(Arrays.asList(arr))` | ・ ジェネリック型配列（Integer[]など）のみ対応<br>・ Arrays.asList()でリストに変換してから最小値を取得 | ・ `ジェネリック型配列`に対して使用<br>・ 配列をリストに変換しているため、性能面ではやや遅くなることがある<br>・ 小規模データでは問題ない |
| `Arrays.stream(arr)`<br>`.min()`<br>`.orElseThrow();` | ・ `プリミティブ型配列専用`の操作<br>・ストリームAPIで最小値を取得<br>・ 要素が空の場合はNoSuchElementExceptionをスロー| ・ int[] などのプリミティブ型配列に使用<br>・ 例外をスローするのは意図的にエラー処理が必要な場合 |
| `Arrays.stream(arr)`<br>`.min()`<br>`.orElse(0); ` | ・ プリミティブ型配列専用`の操作<br>・ 空の場合にデフォルト値を返す（例：0） | ・ 空の配列に対してデフォルト値が必要な場合（0など）<br>・ 例外処理を避ける場合に便利 |
| `Arrays.stream(arr)`<br>`.min(Comparator.naturalOrder())`<br>`.orElseThrow();` | ・ ストリームAPIでジェネリック型配列（Integer[] など）を対象にした数値取得<br>・ Comparator.naturalOrder()を使って最小値を取得 | ・ ジェネリック型配列に対して、数値の最小値を自然順序で取得<br>・ 例外をスローするので、値が空の場合に注意 |
| `Arrays.stream(arr)`<br>`.min(Integer::compareTo)`<br>`.get();` | ・ ジェネリック型配列（Integer[] など）の最小値を取得<br>・ Integer::compareToで比較 | ・ Integer[] などのジェネリック型配列に対して使用<br>・ 最小値が必ず存在することが確定している場合に使う |
優先度について、
* プリミティブ型配列の場合：
  1. `Arrays.stream(arr).min().orElseThrow();`
  2. `Arrays.stream(arr).min().orElse(0);`
* ジェネリック型配列の場合：
  1. `Arrays.stream(arr).min(Comparator.naturalOrder()).orElseThrow();`
  2. `Collections.min(Arrays.asList(arr));`
* 特定の比較方法を使いたい場合：
  1. `Arrays.stream(arr).min(Integer::compareTo).get();`

### sum合計値
Arrays.stream(s).mapToInt(Integer::intValue).sum();

### sum合計値、[a:b)
Arrays.stream(arr, a, b).mapToInt(Integer::intValue).sum(); 
