概要
* [配列の特徴](#配列の特徴)
* [主なコード一覧（Arrayクラスメソッド）](#主なコード一覧arrayクラスメソッド）)
  * [指定範囲\[a, b)の内容をデフォルト値に戻す](#指定範囲a-bの内容をデフォルト値に戻す)
  * [全体コピー（浅いコピー）](#全体コピー浅いコピー)
  * [部分コピー（浅いコピー）](#部分コピー浅いコピー)
  * [配列のサイズを変更する](#配列のサイズを変更する)
  * [C#では引数は値渡し（値のコピーを渡す）となるが、refを使うと、引数の元の値をメソッド内で変更することが可能になる](#C#では引数は値渡し値のコピーを渡すとなるがrefを使うと引数の元の値をメソッド内で変更することが可能になる)
  * [ある要素で配列を埋め尽くす（初期化）](#ある要素で配列を埋め尽くす初期化)
  * [特定の要素を検索](#特定の要素を検索)
  * [特定の要素が最後に出現するインデックスを検索](#特定の要素が最後に出現するインデックスを検索)
  * [二分探索を行い特定の要素を検索](#二分探索を行い特定の要素を検索)
  * [ソート、昇順](#ソート昇順)
  * [ソート、昇順、範囲指定\[a, a + b)](#ソート昇順範囲指定a-a--b)
  * [ソート、逆順](#ソート、逆順)
  * [ソートしない、逆順](#ソートしない逆順)
  * [二重配列ソート](#二重配列ソート)
  * [配列内の要素数/長さを返す](#配列内の要素数長さを返す)
  * [配列の次元数を返す](#配列の次元数を返す)
  * [指定した次元の長さを返す](#指定した次元の長さを返す)
  * [指定した次元の最小インデックスを返す](#指定した次元の最小インデックスを返す)
  * [指定した次元の最大インデックスを返す](#指定した次元の最大インデックスを返す)
  * [要素が空の配列を返す](#要素が空の配列を返す)
  * [配列の要素を指定した型に変換して新しい配列を返す](#配列の要素を指定した型に変換して新しい配列を返す)
  * [配列を読み取り専用のコレクションを返す](#配列を読み取り専用のコレクションを返す)
  * [多次元配列から指定したインデックスの値を取得する](#多次元配列から指定したインデックスの値を取得する)
  * [多次元配列から指定したインデックスの値を設定する](#多次元配列から指定したインデックスの値を設定する)
  * [指定した型とサイズの配列を作成するシンタックス](#指定した型とサイズの配列を作成するシンタックス)
  * [特定の文字列で元の文字列を分割する](#特定の文字列で元の文字列を分割する)
  * [文字をchar配列に一文字ずつを入れる](#文字をchar配列に一文字ずつを入れる)
  * [出力](#出力)
  * [二重配列](#二重配列)
  * [配列を文字列に変換](#配列を文字列に変換)
  * [リストを配列に変換](#リストを配列に変換)
  * [配列をハッシュコードに変換](#配列をハッシュコードに変換)
* [LINQ](#linq)
  * [配列の基本操作](#配列の基本操作)
    * [要素のフィルタリング](#要素のフィルタリング)
    * [最初や最後の要素を取得](#最初や最後の要素を取得)
      * [最初の要素](#最初の要素)
      * [最後の要素](#最後の要素)
    * [特定のインデックス範囲を取得](#特定のインデックス範囲を取得)
      * [コピー\[a, a + b)](#コピーa-a--b)
      * [sum合計値、\[a:a + b)](#sum合計値a-a--b)
  * [集計](#集計)
    * [最小値](#最小値)
    * [最大値](#最大値)
    * [合計値](#合計値)
    * [平均値【double】](#平均値double)
    * [xというものが現れた回数](#xというものが現れた回数)
  * [検索](#検索)
    * [特定の要素を探す【boolean】](#特定の要素を探すboolean)
    * [特定条件のミスマッチ検索](#特定条件のミスマッチ検索)
  * [条件付きソート](#条件付きソート)
  * [変換](#変換)
    * [マッピング、指定した計算式で値を変換](#マッピング、指定した計算式で値を変換)
    * [フラット化（ネストしたコレクションを1次元にする）](#フラット化ネストしたコレクションを1次元にする)
  * [その他](#その他)
    * [配列うぃ逆順にする](#配列うぃ逆順にする)
    * [重複を取り除く](#重複を取り除く)
    * [配列の全要素を確認【boolean】](#配列の全要素を確認boolean)
    * [条件付きグループ化](#条件付きグループ化)
    * [配列が最初にどれだけ一致しているかをカウントする](#配列が最初にどれだけ一致しているかをカウントする)

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
```C#
// 空の Array を生成、初期容量を指定
string[] arr = new string[i];

// 初期要素付きで生成する
int[] arr2 = {1, 2, 3, 4, 5};
```

***************************************************************************
## 主なコード一覧（Arrayクラスメソッド）
### 指定範囲[a, b)の内容をデフォルト値に戻す
Array.Clear(arr, a, b);  
※ int型の場合0、参照型の場合`null`

### 全体コピー（浅いコピー）
(int[])arr.Clone();  
※ (int[])部分内に型指定しないと`System.Int32[]`など型自体をコピーする  
※ 浅いコピー

### 部分コピー（浅いコピー）
Array.Copy(arr1, arr2, b); => [0, b)の範囲をarr2にコピーする
```C#
int[] arr1 = { 1, 2, 3, 4, 5 };
int[] arr2 = new int[5];
Array.Copy(arr1, arr2, 3); // 最初の3つをコピー
Console.WriteLine(string.Join(", ", arr2)); // 結果: 1, 2, 3, 0, 0
```

arr1.CopyTo(arr2, a);  => [a, arr1.Length)の範囲をarr2にコピーする
```C#
int[] arr1 = { 1, 2, 3, 4, 5 };
int[] arr2 = new int[10];

// コピー元配列の全要素をコピー先配列のインデックス3からコピー
arr1.CopyTo(arr2, 3);

Console.WriteLine(string.Join(", ", arr2)); 
// 結果: 0, 0, 0, 1, 2, 3, 4, 5, 0, 0
```

### 配列のサイズを変更する
Array.Resize(ref arr, 長さ);  
refについて：
* refは、参照渡しを行うために使われるキーワード
* これを利用することで、メソッドに渡した引数を直接操作できるようになる
* 通常、C#では引数は値渡し（値のコピーを渡す）となるが、refを使うと、引数の元の値をメソッド内で変更することが可能になる

```C#
int[] arr = { 1, 2, 3 };
Array.Resize(ref arr, 5); // サイズを5に変更
Console.WriteLine(string.Join(", ", arr)); // 結果: 1, 2, 3, 0, 0
```

### ある要素で配列を埋め尽くす（初期化）
Array.Fill(arr, 埋め尽くしたい内容);  
※ C# 7.0 以降の機能となる

### 特定の要素を検索
Array.IndexOf(arr, 特定の要素); => 最初に出現するインデックス

### 特定の要素が最後に出現するインデックスを検索
Array.LastIndexOf(arr, 特定の要素);

### 二分探索を行い特定の要素を検索
Array.BinarySearch(arr, 特定の要素);

### ソート、昇順
Array.Sort(arr);　または  

### ソート、昇順、範囲指定[a, a + b)
Array.Sort(arr, a, b);

### ソート、逆順
Array.Sort(arr);   
Array.Reverse(arr);

### ソートしない、逆順
Array.Reverse(arr);

### 二重配列ソート
二次元配列をソートするには、`List`型を使用する
```C#
var list = new List<int[]> { arr1, arr2 };
list.Sort((a, b) => a[1].CompareTo(b[1])); // 2列目を基準にソート
```

### 配列内の要素数/長さを返す
arr.Length;

### 配列の次元数を返す
arr.Rank; => 2次元配列など

### 指定した次元の長さを返す
arr.GetLength(x);

### 指定した次元の最小インデックスを返す
arr.GetLowerBound();

### 指定した次元の最大インデックスを返す
arr.GetUpperBound();
```C#
int[,] arr = {
    { 1, 2, 3 },
    { 4, 5, 6 },
    { 7, 8, 9 },
    { 10, 11, 12 }
};

Console.WriteLine(arr.GetLowerBound(0));  // 1次元目（行）、結果: 0
Console.WriteLine(arr.GetUpperBound(0));  // 1次元目（行）、結果: 3
Console.WriteLine(arr.GetLowerBound(1));  // 2次元目（列）、結果: 0
Console.WriteLine(arr.GetUpperBound(1));  // 2次元目（列）、結果: 2
```

### 要素が空の配列を返す
var arr = Array.Empty<型>();

### 配列の要素を指定した型に変換して新しい配列を返す
var arr2 = Array.ConvertAll(arr, x => x.ToString());
```C#
int[] arr = { 1, 2, 3, 4, 5 };
string[] strArr = Array.ConvertAll(arr, x => x.ToString());
Console.WriteLine(string.Join(", ", strArr)); // 結果: "1, 2, 3, 4, 5"
```

### 配列を読み取り専用のコレクションを返す
var arr2 = Array.AsReadOnly(arr);  
※ 変更（追加、削除、更新）ができない状態になる

### 多次元配列から指定したインデックスの値を取得する
arr.GetValue(y, x...など);

### 多次元配列から指定したインデックスの値を設定する
arr.SetValue(設定する内容, y, x...など); => arr\[y\]\[x\]を指定内容にする
```C#
int[,] arr = new int[2, 2];
arr.SetValue(42, 0, 1);
Console.WriteLine(arr.GetValue(0, 1)); // 結果: 42
```

### 指定した型とサイズの配列を作成するシンタックス
Array.CreateInstance(Type type, 長さ);
```C#
Array.CreateInstance(Type elementType, int length);
Array.CreateInstance(Type elementType, int length1, int length2);
Array.CreateInstance(Type elementType, int[] lengths);
```
* Type elementType：配列の要素の型。typeof(T) や Type.GetType("型名") を使って型を指定する
* int length：配列の長さ（1次元の場合）
* int length1, length2：配列の次元ごとの長さ（2次元の場合）
* int[] lengths：多次元配列の各次元の長さ（次元数に応じた配列）  

1次元の配列：
```C#
Type type = typeof(int); // int 型を指定
Array arr = Array.CreateInstance(type, 5); // 長さ 5 の int 型配列を作成

for (int i = 0; i < arr.Length; i++)
{
    arr.SetValue(i * 10, i);  // 配列に値をセット
}

foreach (var item in arr)
{
    Console.WriteLine(item);  // 出力: 0, 10, 20, 30, 40
}
```

2次元の配列：
```C#
Type type = typeof(int);
Array arr = Array.CreateInstance(type, 3, 4); // 3行4列の 2次元配列を作成

arr.SetValue(1, 0, 0); // (0,0) に 1 を設定
arr.SetValue(2, 0, 1); // (0,1) に 2 を設定
arr.SetValue(3, 1, 2); // (1,2) に 3 を設定

for (int i = 0; i < arr.GetLength(0); i++) // 行の数
{
    for (int j = 0; j < arr.GetLength(1); j++) // 列の数
    {
        Console.Write(arr.GetValue(i, j) + " "); // 配列の値を出力
    }
    Console.WriteLine();
}
// 出力:
// 1 2 0 0 
// 0 0 3 0 
// 0 0 0 0
```

### 特定の文字列で元の文字列を分割する
string[] li = 文字列.Split(" ");  
※ 【1, 2, 3】に対して【, 】を分割すると⇒【1】【2】【3】となる

### 文字をchar配列に一文字ずつを入れる
char[] charArray = s.ToCharArray();

### 出力
string.Join(", ", arr);  
直接にliを出力しようとするとSystem.Int32[]のような内容が出来るので、Joinなどの処理が必要  
```C#
foreach(var a in arr1)
{
    Console.WriteLine(a);
}
```

#### 二重配列
```C#
foreach (var subArray in arr)
{
    Console.WriteLine(string.Join(", ", subArray));
}
```

### 配列を文字列に変換
string.Join("文字列", arr);

### リストを配列に変換
li.ToArray();

### 配列をハッシュコードに変換
arr.GetHashCode();

***************************************************************************
## LINQ
`using System.Linq;`を使用するコードまとめ

### 配列の基本操作
#### 要素のフィルタリング
条件に一致する要素だけを抽出する  
arr.Where(i => 条件式).ToArray();

#### 最初や最後の要素を取得
##### 最初の要素
arr.First(); または  
arr.FirstOrDefault();  
※ 括弧内に空またはラムダ条件式を入れることが可能  
※ 配列が空の場合、First()は例外を投げる

##### 最後の要素
arr.Last(); または  
arr.LastOrDefault();  
※ 括弧内に空またはラムダ条件式を入れることが可能  
※ 配列が空の場合、Last()は例外を投げる

#### 特定のインデックス範囲を取得
Skip()/ Take()　で範囲を指定することができる  
[a, a + b) -> Skip(2).Take(3) -> {2, 3, 4}

##### コピー[a, a + b)
arr.Skip(a).Take(b).ToArray();  

##### sum合計値、[a:a + b)
arr.Skip(a).Take(b).Sum();  

### 集計
#### 最小値
arr.Min();

#### 最大値
arr.Max();

#### 合計値
arr.Sum();

#### 平均値【double】
arr.Average();

#### xというものが現れた回数
arr.Count();  
※ 括弧内に空(要素数＝長さを返す)またはラムダ条件式を入れることが可能

### 検索
#### 特定の要素を探す【boolean】
arr.Contains(探すターゲット);

#### 特定条件のミスマッチ検索
```C#
int[] arr1 = { 1, 2, 3 };
int[] arr2 = { 1, 4, 3 };
int mismatchIndex = Enumerable.Range(0, Math.Min(arr1.Length, arr2.Length))
                              .Where(i => arr1[i] != arr2[i])
                              .DefaultIfEmpty(-1) // ミスマッチがない場合は -1 を返す
                              .First();　// 最終的に 1 を返す
```

### 条件付きソート
arr.OrderBy(i => 条件式).ToArray();  
arr.OrderByDescending(i => 条件式).ToArray();
```C#
int[] arr = { 5, 3, 1, 4, 2 };
var ascending = arr.OrderBy(x => x).ToArray();  // 昇順: {1, 2, 3, 4, 5}
var descending = arr.OrderByDescending(x => x).ToArray(); // 降順: {5, 4, 3, 2, 1}var sortedByLength = names.OrderBy(name => name.Length).ToArray(); // 文字の長さ順: {"Bob", "Alice", "Charlie"}
```

### 変換

#### マッピング、指定した計算式で値を変換
python3の`li = \[計算式 for i in li\]`みたいなやつ  
arr.Select(i => 計算式).ToArray();

#### フラット化（ネストしたコレクションを1次元にする）
```C#
int[][] nestedArr = { new[] { 1, 2 }, new[] { 3, 4 } };
var flat = nestedArr.SelectMany(x => x).ToArray(); // 結果: {1, 2, 3, 4}
```

### その他
#### 配列うぃ逆順にする
arr.Reverse().ToArray();

#### 重複を取り除く
arr.Distinct().ToArray();

#### 配列の全要素を確認【boolean】
arr.All(i => 条件式); => 全クリアか否か  
arr.Any(i => 条件式); => 一つでもクリアか否か

#### 条件付きグループ化
var groups = arr.GroupBy(x => 条件式 ? "Even" : "Odd");
```C#
int[] arr = { 1, 2, 3, 4, 5, 6 };
var groups = arr.GroupBy(x => x % 2 == 0 ? "Even" : "Odd");
foreach (var group in groups)
{
    Console.WriteLine($"{group.Key}: {string.Join(", ", group)}");
}
Console.WriteLine(groups);

// 結果:
// Odd: 1, 3, 5
// Even: 2, 4, 6
// System.Linq.GroupedEnumerable`2[System.Int32,System.String]
```

#### 乱数生成との組み合わせ
```C#
var random = new Random();
int[] randomArr = Enumerable.Range(0, 10).Select(_ => random.Next(1, 100)).ToArray(); // 1~99 のランダム値 を 10 個生成する
```

#### 二つの配列の結合
arr1.Concat(arr2).ToArray();  

#### 指定されたオブジェクトがこのリストと等しいかどうか【boolean】
arr1.SequenceEqual(arr2);  

#### 配列をリストに変換
arr.ToList();  

#### 配列が最初にどれだけ一致しているかをカウントする
arr1.Zip(arr2, (x, y) => x == y).TakeWhile(b => b).Count();
```C#
arr1.Zip(arr2, (x, y) => x == y)    // arr1とarr2の対応する要素を比較し、一致する場合はtrue、一致しない場合はfalseに変換する
    .TakeWhile(b => b)               // trueの要素が続く限り、それを取得する
    .Count();                        // そのtrueの要素数をカウントする
```
