概要
* [Dictionaryの特徴](#dictionaryの特徴)
* [主なコード一覧](#主なコード一覧)
    * [要素の追加](#要素の追加)
    * [キーが存在していない場合は挿入、している場合は何もしない](#キーが存在していない場合は挿入している場合は何もしない)
    * [要素の取得](#要素の取得)
    * [キーの値を安全に取得_アウト変数](#キーの値を安全に取得_アウト変数)
    * [要素の削除](#要素の削除)
    * [このマップからすべての要素を削除する](#このマップからすべての要素を削除する)
    * [特定のキー値が存在しているのかどうか【boolean】](#特定のキー値が存在しているのかどうかboolean)
    * [特定のバリュー値が存在しているのかどうか【boolean】](#特定のバリュー値が存在しているのかどうかboolean)
    * [特定条件を満たす値が存在しているのかどうか【boolean】](#特定条件を満たす値が存在しているのかどうかboolean)
    * [特定条件を満たしたキー値を保留する](#特定条件を満たしたキー値を保留する)
    * [特定条件を満たしたバリュー値を保留する](#特定条件を満たしたバリュー値を保留する)
    * [最初に特定条件を満たすキー値/バリュー値を取得する](#最初に特定条件を満たすキー値バリュー値を取得する)
    * [ペア数の取得](#ペア数の取得)
    * [Dictionaryをコピー（浅いコピー）](#dictionaryをコピー浅いコピー)
    * [Dictionaryをコピー（深いコピー）](#dictionaryをコピー深いコピー)
    * [キーとバリューを同時に加工して新しいDictionaryを作成](#キーとバリューを同時に加工して新しいdictionaryを作成)
    * [キー値とバリュー値を反転させる](#キー値とバリュー値を反転させる)
    * [キー値のICollectionを取得する](#キー値のicollectionを取得する)
    * [バリュー値のICollectionを取得する](#バリュー値のicollectionを取得する)
    * [キー値の合計](#キー値の合計)
    * [バリュー値の合計](#バリュー値の合計)
    * [キー値の最大値](#キー値の最大値)
    * [バリュー値の最大値](#バリュー値の最大値)
    * [キー値の最小値](#キー値の最小値)
    * [バリュー値の最小値](#バリュー値の最小値)
    * [バリュー値の最頻値（モード）](#バリュー値の最頻値モード)
    * [出力方法](#出力方法)
    * [ソート](#ソート)
        * [Key昇順](#key昇順)
        * [Key降順](#key降順)
        * [Value昇順](#value昇順)
        * [Value降順](#value降順)
        * [Value値昇順⇒Key昇順](#value値昇順key昇順)
        * [Value値降順⇒Key降順](#value値降順key降順)
    * [Key値のリスト化](#key値のリスト化)
    * [Value値のリスト化](#value値のリスト化)
    * [Dictionary を JSON に変換](#dictionary-を-json-に変換)
    * [JSON から Distionary に復元](#json-から-distionary-に復元)

***************************************************************************
## Dictionaryの特徴
* `using System.Collections.Generic;`を使用する
* キー(Key)と値(Value)のペアを格納する
* キーはユニーク
* キーを使って高速に値を検索する

宣言と初期化：
```C#
Dictionary<string, int> dict1 = new Dictionary<string, int>();

// 初期値を設定して作成する
var dict2 = new Dictionary<string, int>()
{
    { "Apple", 3 },
    { "Banana", 5 }
};
```

***************************************************************************
## 主なコード一覧
### 要素の追加
dict.Add(キー値, バリュー値);  
※ キー値がすでに存在している場合、スローされる（`System.ArgumentException`）  
※ 既存キー値でバリュー値がリストなどの場合、該リストに要素を追加することになる  または  
dict\[キー値\] = バリュー値;

### キーが存在していない場合は挿入、している場合は何もしない
dict.TryAdd(キー値, 存在しなかった場合、加入したいバリュー値);  
※ 試そうとしたキー値が存在した場合、何もしない

### 要素の取得
dict\[キー値\];

### キーの値を安全に取得_アウト変数
dict.TryGetValue(key, out value)
* 存在する場合、対応する値をアウト変数 `count` に格納し、`true` を返す
* 存在しない場合、`false`を返す、 `count` は初期化される（`int` 型の場合 `0`）
* `out`: アウト変数(out variable)
* `out value`: 特にメソッドが値を返す際に、その値を別の変数に格納するために使う

```C#
Console.WriteLine(dict.TryGetValue("A", out var c)); // true/ falseを返す

// キーが存在しない場合にエラーを防ぐ
if (dict.TryGetValue("Apple", out int count))
{
    Console.WriteLine($"Appleの数: {count}");
}
else
{
    Console.WriteLine("Appleは存在しません。");
}
```

### 要素の削除
dict.Remove(キー値);  
※ 存在していない場合、エラーにはならない

### このマップからすべての要素を削除する
dict.Clear();

### 特定のキー値が存在しているのかどうか【boolean】
dict.ContainsKey(キー値);

### 特定のバリュー値が存在しているのかどうか【boolean】
dict.ContainsValue(バリュー値);

### 特定条件を満たす値が存在しているのかどうか【boolean】
dict.Keys.Any(x => 条件式);  
dict.Values.Any(x => 条件式);  
※ `using System.Linq`を使用する

### 特定条件を満たしたキー値を保留する
※ `using System.Linq`を使用する
```C#
dict = dict.Where(kvp => kvp.Key に対して条件式を設定する)
           .ToDictionary(kvp => kvp.Key, kvp => kvp.Value);
```

### 特定条件を満たしたバリュー値を保留する
※ `using System.Linq`を使用する
```C#
dict = dict.Where(kvp => kvp.Value に対して条件式を設定する)
           .ToDictionary(kvp => kvp.Key, kvp => kvp.Value);
```

### 最初に特定条件を満たすキー値/バリュー値を取得する
dict.FirstOrDefault(kvp => 特定条件).Key;

### ペア数の取得
dict.Count;

### Dictionaryをコピー（浅いコピー）
var dict2 = new Dictionary<string, int>(dict);  
var dict2 = dict.ToDictionary(entry => entry.Key, entry => entry.Value);

### Dictionaryをコピー（深いコピー）
```C#
var dict2 = new Dictionary<string, List<int>>();
foreach (var kvp in dict)
{
    dict2[kvp.Key] = new List<int>(kvp.Value);
}
```

### キーとバリューを同時に加工して新しいDictionaryを作成
```C#
var dict2 = dict.ToDictionary(
    kvp => kvp.Key.ToLower(), // キーを小文字化
    kvp => kvp.Value * 10     // 値を10倍に
);
```

### キー値とバリュー値を反転させる
var dict2 = dict.ToDictionary(kvp => kvp.Value, kvp => kvp.Key);

### キー値のICollectionを取得する
dict.Keys;  
すべてのキーを`ICollection`として取得する
```C#
foreach (var key in dict.Keys)
{
  Console.WriteLine(key);
}
```

### バリュー値のICollectionを取得する
dict.Values;  
すべてのキーを`ICollection`として取得する
```C#
foreach (var value in dict.Values)
{
  Console.WriteLine(value);
}
```

### キー値の合計
dict.Keys.Sum();  
※ `using System.Linq`を使用する

### バリュー値の合計
dict.Values.Sum();  
※ `using System.Linq`を使用する

### キー値の最大値
dict.Keys.Max();  
※ `using System.Linq`を使用する

### バリュー値の最大値
dict.Values.Max();  
※ `using System.Linq`を使用する

### キー値の最小値
dict.Keys.Min();  
※ `using System.Linq`を使用する

### バリュー値の最小値
dict.Values.Min();  
※ `using System.Linq`を使用する

### バリュー値の最頻値（モード）
※ `using System.Linq`を使用する  
※ 同位になる場合を考慮する必要がある
```C#
// 最頻値となる対象が複数ある場合、
// 内部的な処理順序（具体的にはGroupByがグループを生成する順序）に依存する
var modeValue = dict.Values
                    .GroupBy(value => value)
                    .OrderByDescending(group => group.Count())
                    .First()
                    .Key;

// 最頻値となる対象が複数ある場合、
// ThenByによりDictionaryの登録順に依存する
var modeValue = dict.Values
                    .GroupBy(value => value)
                    .OrderByDescending(group => group.Count())
                    .ThenBy(valueGroup => dict.Values.ToList().IndexOf(valueGroup.Key)) // 登録順
                    .First()
                    .Key;
```

### 出力方法
```C#
// 1. foreach
foreach (var kvp in map)
{
    Console.WriteLine($"{kvp.Key} : {kvp.Value}");
}

// 2. Keysプロパティを使用
foreach (var key in map.Keys)
{
    Console.WriteLine($"{key} : {map[key]}");
}

// 3. 並列処理は C# では非推奨だが、必要なら PLINQ を使用
map.AsParallel().ForAll(kvp => Console.WriteLine($"{kvp.Key} = {kvp.Value}"));

// 4. キーとバリューを結合した文字列
var result = string.Join(", ", dict.Select(kvp => $"{kvp.Key}: {kvp.Value}"));
```

### ソート
#### Key昇順
var sortedKeys = dict.Keys.OrderBy(key => key).ToList();

#### Key降順
var sortedKeysDescending = dict.Keys.OrderByDescending(key => key).ToList();

#### Value昇順
```C#
var sortedByValue = dict.OrderBy(kvp => kvp.Value)
                        .ToDictionary(kvp => kvp.Key, kvp => kvp.Value);
```
#### Value降順
```C#
var sortedByValueDescending = dict.OrderByDescending(kvp => kvp.Value)
                                  .ToDictionary(kvp => kvp.Key, kvp => kvp.Value);
```

#### Value値昇順⇒Key昇順
```C#
var sorted = dict.OrderBy(kvp => kvp.Value)
                 .ThenBy(kvp => kvp.Key)
                 .ToDictionary(kvp => kvp.Key, kvp => kvp.Value);
```

#### Value値降順⇒Key降順
```C#
var sorted = dict.OrderByDescending(kvp => kvp.Value)
                 .ThenByDescending(kvp => kvp.Key)
                 .ToDictionary(kvp => kvp.Key, kvp => kvp.Value);
```

### Key値のリスト化
var keys = dict.Keys.ToList();  
var matchingKeys = dict.Keys.Where(key => 条件式).ToList();  ※ `using System.Linq`を使用する

### Value値のリスト化
var values = dict.Values.ToList();  
var matchingValues = dict.Values.Where(value => 条件式).ToList();  ※ `using System.Linq`を使用する

### Dictionary を JSON に変換
※ `using System.Text.Json;`を使用する  
※ 必須バージョン：.NET 6.0 以上
```C#
var jsonString = JsonSerializer.Serialize(dict);
Console.WriteLine(jsonString);
```

### JSON から Distionary に復元
※ `using System.Text.Json;`を使用する  
※ 必須バージョン：.NET 6.0 以上
```C#
var jsonString = "{\"A\":1,\"B\":2,\"C\":3}";
var dict = JsonSerializer.Deserialize<Dictionary<string, int>>(jsonString);
```
