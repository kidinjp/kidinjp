概要
* [Listの特徴](#listの特徴)
* [主なコード一覧](#主なコード一覧)
  * [要素の追加](#要素の追加)
  * [要素を指定された位置に追加](#要素を指定された位置に追加)
  * [二つのリストを結合](#二つのリストを結合)
  * [二つのリストを指定された位置に結合](#二つのリストを指定された位置に結合)
  * [指定位置範囲の要素を切り出す\[fromIndex, toIndex)【List<>】](#指定位置範囲の要素を切り出すfromindex-toindexlist)
  * [指定された位置にある要素を削除](#指定された位置にある要素を削除)
  * [最初に検出された指定要素を削除](#最初に検出された指定要素を削除)
  * [範囲のインデックスを持つすべての要素をこのリストから削除\[fromIndex, toIndex)](#範囲のインデックスを持つすべての要素をこのリストから削除fromindex-toindex)
  * [リストから、指定されたコレクション内に保持されているすべての要素を削除。差集合](#リストから指定されたコレクション内に保持されているすべての要素を削除差集合)
  * [リストから、指定されたコレクション内に保持されているすべての要素を削除。共通集合](#リストから指定されたコレクション内に保持されているすべての要素を削除共通集合)
  * [指定された条件と合致する要素を全削除](#指定された条件と合致する要素を全削除)
  * [このリストからすべての要素を削除する](#このリストからすべての要素を削除する)
  * [コピー（浅いコピー）](#コピー（浅いコピー）)
  * [コピー（深いコピー）](#コピー（深いコピー）)
  * [指定されたインデックスにある要素を取得する](#指定されたインデックスにある要素を取得する)
  * [指定されたインデックスにある要素を、指定された数値/文字列に置き換える](#指定されたインデックスにある要素を、指定された数値/文字列に置き換える)
  * [指定されたオブジェクトがこのリストと等しいかどうか【boolean】](#指定されたオブジェクトがこのリストと等しいかどうかboolean)
  * [このリストのハッシュ・コード値を返す](#このリストのハッシュ・コード値を返す)
  * [内部配列の容量を要素数に合わせる](#内部配列の容量を要素数に合わせる)
  * [要素を追加する前に容量を確保しておく](#要素を追加する前に容量を確保しておく)
  * [リスト内の要素数/長さを返す](#リスト内の要素数/長さを返す)
  * [xというものが現れた回数](#xというものが現れた回数)
  * [このリストに要素があるかどうか【boolean】](#このリストに要素があるかどうかboolean)
  * [特定要素はリストに含まれているかどうか【boolean】](#特定要素はリストに含まれているかどうかboolean)
  * [特定要素が最初に検出された位置のインデックスを返す](#特定要素が最初に検出された位置のインデックスを返す)
  * [特定要素が最後に検出された位置のインデックスを返す](#特定要素が最後に検出された位置のインデックスを返す)
  * [特定条件に合う最初の要素を検索する](#特定条件に合う最初の要素を検索する)
  * [特定条件に合う最初の要素のインデックスを検索する](#特定条件に合う最初の要素のインデックスを検索する)
  * [特定条件に合う全要素を検索する](#特定条件に合う全要素を検索する)
  * [指定条件で要素をグループ化](#指定条件で要素をグループ化)
  * [join_string](#join_string)
  * [集計join](#集計join)
  * [リスト内の要素を反復するイテレータを返す](#リスト内の要素を反復するイテレータを返す)
  * [配列への変換](#配列への変換)
  * [逆順](#逆順)
  * [ソート（昇順）](#ソート昇順)
  * [ソート（降順）](#ソート降順)
  * [二重ソート](#二重ソート)
    * [li\[x\]\[2\] の昇順で並び替え、同列の場合 li\[x\]\[0\] の昇順](#lix2-の昇順で並び替え同列の場合-lix0-の昇順)
    * [li\[x\]\[2\] の降順で並び替え、同列の場合 li\[x\]\[0\] の降順](#lix2-の降順で並び替え同列の場合-lix0-の降順)
  * [シャッフル](#シャッフル)
  * [最小値](#最小値)
  * [最大値](#最大値)
  * [sum](#sum)
  * [リストの初期化＿fill](#リストの初期化＿fill)
  * [リストの初期化＿連続した値](#リストの初期化＿連続した値)
  * [スレッドセーフなコレクションの生成](#スレッドセーフなコレクションの生成)
  * [ユニークな要素の抽出](#ユニークな要素の抽出)
  * [LINQの応用](#linqの応用)
  * [全出力](#全出力)

***************************************************************************
## Listの特徴
* `List<T>` は、C# の`ジェネリックコレクション`の一つ
* 配列のように`要素を順序付き`で管理する
* 要素の追加や削除が簡単にできる便利なデータ構造

* 名前空間: `System.Collections.Generic`
* 型指定: <T> は、リスト内で扱うデータ型を指定します。例えば、整数型なら List<int>、文字列なら List<string>。
* **宣言と初期化**
```C#
// 空の ArrayList を生成（デフォルトの初期容量）
List<int> li = new List<int>();

// 初期容量を指定して生成（要素数が多い場合に便利）
var li = new List<int>(50);

// 初期値を持つリストを作る
var li = new List<int> { 1, 2, 3 };

// 配列からリストを作る
int[] arr = { 1, 2, 3 };
var li = new List<int>(arr);
```

***************************************************************************
## 主なコード一覧

### 要素の追加
li.Add();

### 要素を指定された位置に追加
li.Insert(インデックス, 指定された要素);  
※ 長さを超えたインデックスに追加しようとすると``エラーが起こる``

### 二つのリストを結合
li1.AddRange(li2);  
※ 前のリストにのみ追加を行う

### 二つのリストを指定された位置に結合
li1.InsertRange(インデックス, li2);  
※ 前のリストにのみ追加を行う  
※ 長さを超えたインデックスに追加しようとすると``エラーが起こる``

### 指定位置範囲の要素を切り出す[fromIndex, toIndex)【List<>】
List<int> subList = li.GetRange(fromIndex, toIndex - fromIndex);

### 指定された位置にある要素を削除
li.RemoveAt(インデックス);  
※ 長さを超えたインデックスを削除しようとすると``エラーが起こる``

### 最初に検出された指定要素を削除
li.Remove(文字（列）);  
※ 特定数値/文字（列）がリスト内に存在しない場合、特に行うことはない上``エラー起らない``  

### 範囲のインデックスを持つすべての要素をこのリストから削除[fromIndex, toIndex)
li.RemoveRange(fromIndex, toIndex);  

### リストから、指定されたコレクション内に保持されているすべての要素を削除。差集合
li1.RemoveAll(i => li2.Contains(i));

### リストから、指定されたコレクション内に保持されているすべての要素を削除。共通集合
li1 = li1.Where(i => li2.Contains(i)).ToList();

### 指定された条件と合致する要素を全削除
li.RemoveAll(x => 条件式); 

### このリストからすべての要素を削除する
li.Clear()

### コピー（浅いコピー）
```C#
List<int> li2 = new List<int>(li);
```
※ 不変オブジェクトではない場合、コピー内容に対する変更はコピー元に影響を与える（浅いコピー）

### コピー（深いコピー）
``` C#
List<int> li2 = li.Select(x => x).ToList();

// クラスのリストの場合
List<Person> deepCopy = original.Select(p => new Person(p.Name)).ToList();
```

### 指定されたインデックスにある要素を取得する
li\[i\];

### 指定されたインデックスにある要素を、指定された数値/文字列に置き換える
li\[i\] = 置き換える要素;

### 指定されたオブジェクトがこのリストと等しいかどうか【boolean】
li1.SequenceEqual(li2);
※ trueになる条件
* 指定されたオブジェクトもリストである
* サイズが同じ
* 2つのリストの各インデックスに対応する要素がすべて等しい

### このリストのハッシュ・コード値を返す
li.GetHashCode();

### 内部配列の容量を要素数に合わせる
li.TrimExcess();

### 要素を追加する前に容量を確保しておく
li.Capacity = 容量;  
※ `Capacity` プロパティを直接設定する

### リスト内の要素数/長さを返す
li.Count; または 
li.Count();

### xというものが現れた回数
li.Count(x => x == "x");

### このリストに要素があるかどうか【boolean】
!li.Any();
※ 空の場合`true`と返す

### 特定要素はリストに含まれているかどうか【boolean】
li.Contains(o);

### 特定要素が最初に検出された位置のインデックスを返す
li.IndexOf(o);

### 特定要素が最後に検出された位置のインデックスを返す
li.LastIndexOf(o);

### 特定条件に合う最初の要素を検索する
li.Find(x => x > 10);  
※ 見つからない場合は、要素の型に応じてデフォルト値（例えば null や 0）を返す

### 特定条件に合う最初の要素のインデックスを検索する
li.FindIndex(x => x > 10);  
※ 見つからない場合は、要素の型に応じてデフォルト値（例えば null や 0）を返す

### 特定条件に合う全要素を検索する
var matches = li.FindAll(x => x > 10);  
※ List<同じ型>を返す
※ 見つからない場合は、要素の型に応じてデフォルト値（例えば null や 0）を返す

### 指定条件で要素をグループ化
li.GroupBy(x => 条件式 ? trueの場合 : falseの場合);
```C#
var grouped = li.GroupBy(x => x % 2 == 0 ? "Even" : "Odd"); // 偶数と奇数でグループ化

foreach (var group in grouped)
{
    Console.WriteLine($"{group.Key}: {string.Join(", ", group)}");
}
```

### join_string
Console.WriteLine(string.Join(" ", li));  
※ intなども使える  
Console.WriteLine(string.Join(" ", li.Select(x => x.ToString())));
※ `using System.Linq`を使用する

### 集計join
Console.WritLine(li.Aggregate(初期値, (前の値, 次の値) => 表現仕方));  
* 初期値
```C#
List<int> li = new List<int> { 1, 2, 3, 4, 5 };
string result = li.Aggregate("", (current, next) => current + next + " ");
Console.WriteLine(result.Trim()); // ""1" "2" "3" "4" "5" "に対して.Trim()をする
Console.WriteLine(li.Aggregate("", (p, n) => p + n + "/ ")); // 【1/ 2/ 3/ 4/ 5/ 】となる
```

***************************************************************************
### リスト内の要素を反復するイテレータを返す
ListIterator<String> iterator = list.listIterator();
```C#
using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        List<string> list = new List<string> { "A", "B", "C" };

        IEnumerator<string> iterator = list.GetEnumerator(); // イテレータ取得
        while (iterator.MoveNext())                         // 次の要素があるか
        {
            Console.WriteLine(iterator.Current);            // 現在の要素を取得
        }
    }
}
```

### 配列への変換
int[] arr = li.ToArray();

### 逆順
li.Reverse();

### ソート（昇順）
li.Sort();

### ソート（降順）
li.Sort((a, b) => b.CompareTo(a));

### 二重ソート
#### li[x][2] の昇順で並び替え、同列の場合 li[x][0] の昇順
```C#
li.Sort((a, b) =>
{
    int result = a[2].CompareTo(b[2]); // 3番目の要素で比較
    return result != 0 ? result : a[0].CompareTo(b[0]); // 同じなら1番目で比較
});
```

#### li[x][2] の降順で並び替え、同列の場合 li[x][0] の降順
```C#
li.Sort((a, b) =>
{
    int result = b[2].CompareTo(a[2]); // 3番目の要素で降順比較
    return result != 0 ? result : b[0].CompareTo(a[0]); // 同じなら1番目で降順比較
});
```

### シャッフル
li = li.OrderBy(x => Guid.NewGuid()).ToList();  
※ `using System.Linq;`を使用する
※ 既有内容でシャッフル
```C#
// サンプルリスト
List<int> li = new List<int> { 1, 2, 3, 4, 5 };

// ランダムシャッフル
li = li.OrderBy(x => Guid.NewGuid()).ToList(); 
```

または`Random クラス`を使ったシャッフル（Fisher-Yates アルゴリズム）  
**パフォーマンスが高い**/**ランダム性が比較的高い**
```C#
using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        // サンプルリスト
        List<int> li = new List<int> { 1, 2, 3, 4, 5 };

        // Fisher-Yatesアルゴリズムによるシャッフル
        Random random = new Random();
        for (int i = li.Count - 1; i > 0; i--)
        {
            int j = random.Next(0, i + 1);

            // スワップ
            int temp = li[i];
            li[i] = li[j];
            li[j] = temp;
        }

        // 結果を表示
        Console.WriteLine(string.Join(", ", li));
    }
}
```


既有内容でランダム生成（重複/欠損内容あり）
```C#
using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        List<int> list = new List<int> { 1, 2, 3, 4, 5 };
        Random rnd = new Random();

        for (int i = 0; i < list.Count; i++)
        {
            int j = rnd.Next(i, list.Count); // ランダムインデックス
            (list[i], list[j]) = (list[j], list[i]); // スワップ
        }

        foreach (int num in list)
        {
            Console.WriteLine(num);
        }
    }
}
```

### 最小値
li.Min();  
※ `using System.Linq;`を使用する

### 最大値
li.Max();  
※ `using System.Linq;`を使用する

### sum
li.Sum();  
※ `using System.Linq;`を使用する
    
### リストの初期化＿fill
var li = Enumerable.Repeat(0, 10).ToList();　`[0] * 10`

### リストの初期化＿連続した値
var li = Enumerable.Range(1, 10).ToList(); `range(1, 1 + 10)`

### スレッドセーフなコレクションの生成
```C#
using System.Collections.Concurrent;
ConcurrentBag<int> safeList = new ConcurrentBag<int>();
```

### ユニークな要素の抽出
var uniqueList = new HashSet<int>(li_.ToList();  `HashSetを使用`  
var uniqueList = li.Distanct().ToList(); `using System.Linqを使用`
```C#
// HashSetを使用
var uniqueList = new HashSet<int>(li).ToList();

// LINQを使用
var uniqueList = li.Distinct().ToList();
```

### LINQの応用
* ソート利用
```C#
List<Person> sortedPeople = people
    .OrderBy(p => p.Height)　　　//昇順でソート
    .ThenByDescending(p => p.BirthMonth)　　//降順でソート
    .ThenBy(p => p.Name)　　　　// 名前で昇順ソート
    .ToList();　　　　　　　　　//ソートされた結果を新しい List<Person> オブジェクトとして返す

// ToList() メソッドは、LINQ クエリ結果を新しいリストとして取得するためのメソッド。
// ソートされた結果を新しいリストとして取得している
```

### 全出力
li.ForEach(x => Console.WriteLine(x));  
※ `using System.Linq;`を使用する  
または  
li.Select(x => x).ToList().ForEach(Console.WriteLine);  
※ `using System.Linq;`を使用する  
