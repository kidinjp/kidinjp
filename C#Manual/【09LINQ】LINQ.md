概要
* [LINQとは](#linqとは)
* [LINQの書き方](#linqの書き方)
  * [クエリ構文](#クエリ構文)
  * [メソッド構文](#メソッド構文)
* [主なメソッド構文コード一覧](#主なメソッド構文コード一覧)
  * [条件を満たす要素をフィルタリング](#条件を満たす要素をフィルタリング)
  * [要素を変換または選択](#要素を変換または選択)
  * [昇順でソート](#昇順でソート)
  * [降順でソート](#降順でソート)
  * [ただの逆順](#ただの逆順)
  * [最初のn個の要素を取得](#最初のn個の要素を取得)
  * [最初のn個の要素をスキップ](#最初のn個の要素をスキップ)
* [集計操作](#集計操作)
  * [要素数を取得](#要素数を取得)
  * [合計値を計算](#合計値を計算)
  * [平均値を計算](#平均値を計算)
  * [最大値を取得](#最大値を取得)
  * [最小値を取得](#最小値を取得)
* [グループ化](#グループ化)
* [結合操作](#結合操作)
* [その他](#その他)
  * [AsEnumerable](#asenumerable)
  * [条件を満たす要素が1つでもあるかを確認](#条件を満たす要素が1つでもあるかを確認)
  * [すべての要素が条件を満たすかを確認](#すべての要素が条件を満たすかを確認)
  * [最初の要素を取得](#最初の要素を取得)
  * [条件を満たす最初の要素を取得](#条件を満たす最初の要素を取得)
  * [重複を排除](#重複を排除)
* [実用例](#実用例)
  * [リストの変換](#リストの変換)
  * [グループ化](#グループ化)

***************************************************************************
## LINQとは
* Language Integrated Query
* C#などの.NET言語でコレクションやデータソースに対するクエリを簡潔かつ効率的に記述するための統一的なクエリ言語
* データの形式に関わらず、共通の方法で操作できる
* 主な特徴
  * **統一的なデータ操作**: 配列、リスト、XML、データベース、またはその他のデータソースを同じように操作可能
  * **可読性の高いクエリ構文**: SQLライクな記述が可能
  * **型安全性**: コンパイル時に型チェックが行われるため、エラーを防ぎやすい
  * **デリゲートやラムダ式の活用**: 高度なフィルタリングやマッピング処理を簡潔に記述できる
* 使いどころ
  * コレクション操作
    * 配列やリストの検索・ソート・変換
  * データベースアクセス（LINQ to SQL, LINQ to Entities）
    * データベースに対するクエリを簡潔に記述
  * XML操作（LINQ to XML）
    * XMLデータを簡単にクエリや操作可能
  * その他
    * LINQ to DataSet、LINQ to Objectsなど
* 注意点
  * 遅延実行
    * LINQクエリは、実際に結果が必要になるまで実行されない（これはパフォーマンス上の利点だが、理解が必要）
  * 型安全性
    * 非ジェネリックなコレクションに対してLINQを使うときは、明示的なキャストが必要

***************************************************************************
## LINQの書き方
LINQは**クエリ構文**と**メソッド構文**の2つで記述できる

### クエリ構文
```C#
var result = from item in collection
             where item.Property > 10
             orderby item.Property descending
             select item;
```

### メソッド構文
```C#
var result = collection
    .Where(item => item.Property > 10)
    .OrderByDescending(item => item.Property)
    .Select(item => item);
```
※ **クエリ構文**はSQLライクで可読性が高いが、  
※ **メソッド構文**はラムダ式やメソッドチェーンを活用した柔軟な書き方が可能

***************************************************************************
## 主なメソッド構文コード一覧
なお、下記内容は `List<int> li` との変数を使用する前提で、Linq 

### 条件を満たす要素をフィルタリング
li.Where(x => 条件);

### 要素を変換または選択
li.Select(x => 変換);  
※ .ToUpper()/ .ToLower()/ *2などの変換

### 昇順でソート
li.OrderBy(x => x);

### 降順でソート
li.OrderByDescending(x => x);

### ただの逆順
li.AsEnumerable().Reverse();  
※ データの型やその動作を制御する必要がある場合  
※ Reverse() は IEnumerable<int> を返す

### 最初のn個の要素を取得
li.Take(n);

### 最初のn個の要素をスキップ
li.Skip(n);

## 集計操作

### 要素数を取得
li.Count();

### 合計値を計算
li.Sum();

### 平均値を計算
li.Average();

### 最大値を取得
li.Max();

### 最小値を取得
li.Min();

## グループ化
要素をキーごとにグループ化  
li.GroupBy()
```C#
var grouped = li.GroupBy(x => x.Category);
foreach (var group in grouped)
{
    Console.WriteLine($"Category: {group.Key}");
    foreach (var item in group)
    {
        Console.WriteLine(item);
    }
}
```

## 結合操作
2つのコレクションをキーで結合  
li1.Join(li2, x => x.Id, y => y.Id, (x, y) => new { x, y });
```C#
var result = customers.Join(
    orders,
    customer => customer.Id,
    order => order.CustomerId,
    (customer, order) => new { customer.Name, order.Product }
);
```

## その他
### AsEnumerable
リストや配列を一時的に IEnumerable<T> として扱いたいときに使う  
li.AsEnumerable();  
使いどころ：  
* IQueryable → IEnumerable の切り替え
  * データベースからローカルに処理を切り替えたい場合
```C#
var query = db.Products // IQueryable<Product>
    .Where(p => p.Price > 100) // データベースで処理
    .AsEnumerable() // ここでメモリ上に切り替える
    .Where(p => p.Name.StartsWith("A")); // ローカル処理
// ここで AsEnumerable を使うことで、Name.StartsWith のフィルタはメモリ上で実行される
```
* 型の特殊な動作を避ける
  * List や Array の特化したメソッドを使いたくない場合
* 遅延評価を維持
  * ToList や ToArray を使いたくない場合
```C#
IEnumerable<int> query = Enumerable.Range(1, 100)
    .Select(x => x * 2)
    .AsEnumerable(); // 遅延評価を維持

// この時点ではデータはまだ計算されていない
foreach (var num in query)
{
    Console.WriteLine(num); // 必要になったときに初めて計算
}
```
* 標準的な LINQ の拡張メソッドを優先したい
  * 特定の型の独自実装を無視したい場合

### 条件を満たす要素が1つでもあるかを確認
li.Any(x => 条件);

### すべての要素が条件を満たすかを確認
li.All(x => 条件);

### 最初の要素を取得
li.First(x => 条件);

### 条件を満たす最初の要素を取得
li.FirstOrDefault(x => 条件);  
※ 該当がない場合null

### 重複を排除
li.Distinct();

### 

## 実用例
### リストの変換
```C#
var words = new List<string> { "apple", "banana", "cherry" };
var upperWords = words.Select(word => word.ToUpper());
foreach (var word in upperWords)
{
    Console.WriteLine(word); // APPLE, BANANA, CHERRY
}
```

### グループ化
```C#
var items = new[]
{
    new { Name = "Item1", Category = "A" },
    new { Name = "Item2", Category = "B" },
    new { Name = "Item3", Category = "A" },
};

var grouped = items.GroupBy(item => item.Category);

foreach (var group in grouped)
{
    Console.WriteLine($"Category: {group.Key}");
    foreach (var item in group)
    {
        Console.WriteLine(item.Name);
    }
}
```
