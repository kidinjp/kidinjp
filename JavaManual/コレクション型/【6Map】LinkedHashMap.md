概要
* [LinkedHashMapの特徴](#linkedhashmapの特徴)
    * [負荷率とは](#負荷率とは)
    * [accessOrder パラメータとは](#accessorder-パラメータとは)
* [主なコード一覧](#主なコード一覧)
    * [要素の追加](#要素の追加)
    * [要素の取得](#要素の取得)
    * [キー値取得を試し、nullの場合デフォ値を返す](#キー値取得を試しnullの場合デフォ値を返す)
    * [キーが存在していない場合は挿入、している場合は何もしない](#キーが存在していない場合は挿入している場合は何もしない)
    * [キーが存在していない場合は挿入、している場合は更新](#キーが存在していない場合は挿入している場合は更新)
        * [マージ関数](#マージ関数)
    * [特定のキー値が存在しているのかどうか【boolean】](#特定のキー値が存在しているのかどうかboolean)
    * [特定のバリュー値が存在しているのかどうか【boolean】](#特定のバリュー値が存在しているのかどうかboolean)
    * [特定のキー値ペアを削除する](#特定のキー値ペアを削除する)
    * [このマップからすべての要素を削除する](#このマップからすべての要素を削除する)
    * [このマップは空であるかどうか【boolean】](#このマップは空であるかどうかboolean)
    * [ペア数の取得](#ペア数の取得)
    * [全置換](#全置換)
    * [二つのマップを結合](#二つのマップを結合)
    * [コピー方法](#コピー方法)
    * [出力方法](#出力方法)
        * [ラムダ式](#ラムダ式)
        * [keySet()](#keyset)
        * [entrySet()](#entryset)
        * [map.entrySet().parallelStream()](#mapentrysetparallelstream)
    * [ソート](#ソート)
        * [Key昇順](#key昇順)
        * [Key降順](#key降順)
        * [Value昇順](#value昇順)
        * [Value降順](#value降順)
        * [Value値降順⇒Key降順](#value値降順key降順)
    * [Key値のリスト化](#key値のリスト化)
    * [Value値のリスト化](#value値のリスト化)

なお、便宜を図って、各型のデフォ値を下記通りとする。
`LinkedHashMap<String, Integer>` map = new LinkedHashMap<>();
***************************************************************************
## LinkedHashMapの特徴
* **import java.util.LinkedHashMap;**
* **挿入順序またはアクセス順序を保持**  
LinkedHashMap は、要素が挿入された順番を保持する  
また、accessOrder パラメータを true に設定することで、アクセスされた順番で要素が並び替えられる機能も提供している
* **ハッシュマップとリンクリストの組み合わせ**  
基本的には HashMap と同じくハッシュテーブルを使用しており、キーと値のペアを保持する  
加えて、挿入順序を保持するために内部でリンクリストを使用している
* **ランダムアクセスはやや遅いが順序保証あり**  
LinkedHashMap は HashMap よりも順序を保証しますが、その分メモリ消費が若干増え、アクセス速度もやや遅くなる  
ただし、一般的にはキーへのアクセスは十分高速
* **動的にサイズを変更可能**  
要素が追加されるたびに内部的に必要なサイズを自動的に増加させる  
初期容量や負荷率の指定も可能で、容量を事前に設定することで効率的にメモリを使用できる
* **要素の挿入・削除は配列の末尾以外で遅くなる**  
LinkedHashMap は内部的にリンクリストを使用しているため、挿入・削除操作がリストの末尾以外では少し遅くなる  
ただし、要素の挿入順序は常に保持される
* **宣言と初期化**
```Java
// 空の LinkedHashMap を生成
LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

// 初期容量を 16、負荷率を 0.75（デフォルト値）で生成
LinkedHashMap<String, Integer> mapWithCapacity = new LinkedHashMap<>(16, 0.75f);

// 初期容量、負荷率、アクセス順序指定で生成
LinkedHashMap<String, Integer> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);
accessOrderMap.put("A", 1);
accessOrderMap.put("B", 2);
accessOrderMap.put("C", 3);
System.out.println(accessOrderMap); // 出力: {A=1, B=2, C=3}

    // 要素にアクセスすると順序が変わる
accessOrderMap.get("A"); // A が最後に移動
System.out.println(accessOrderMap); // 出力: {B=2, C=3, A=1}

// 既存の Map を元に生成
LinkedHashMap<String, String> linkedMap = new LinkedHashMap<>(linkedHashMap);

// 初期値を手動で設定
LinkedHashMap<String, String> initializedMap = new LinkedHashMap<>() {{
    put("A", "Apple");
    put("B", "Banana");
    put("C", "Cherry");
}};
```

### 負荷率とは
負荷率（Load Factor） とは、`HashMap`や`LinkedHashMap`といったハッシュベースのコレクションで、
内部の配列のサイズをどのタイミングで拡張するかを決定する指標。
これは``衝突の発生率を避けるために重要``であり、パフォーマンスに影響を与える。

* **負荷率**：内部配列（バケット）の どれだけ埋まっているか を示す割合
  * 負荷率が 高い場合：バケットに多くの要素が詰め込まれることになり、衝突が多くなり、操作（検索、挿入、削除）のパフォーマンスが悪化する
  * 負荷率が 低い場合：衝突が少なくなり、操作が効率よく行えますが、メモリを余分に消費する

* デフォルトの負荷率：0.75F  
　　Java の HashMap や LinkedHashMap の デフォルトの負荷率は 0.75  
　　（内部配列が `75%` 埋まると、`容量が2倍に拡張される`ということ）

* 負荷率が 0.75 の場合  
例えば、HashMap の初期容量が 16 だったとする。  
その場合、容量 16 の配列が、要素数が 12（16 × 0.75）に達すると、容量が 32 に増加する

* 負荷率を変更する意味  
負荷率を変更することで、以下のような違いが生まれます。
  * 低い負荷率（例えば 0.5）：  
    * 衝突が少なく、検索や挿入のパフォーマンスは向上するかもしれませんが、メモリを多く消費する
    * すぐに容量が拡張されるため、メモリに余裕がある場合や大量のデータを扱う際に適している

  * 高い負荷率（例えば 0.9）：
    * メモリ使用量が抑えられ、拡張が遅くなりますが、衝突が増えて検索速度が低下する可能性がある

> 負荷率 は、コレクションのパフォーマンスとメモリ効率に影響を与える重要なパラメータ。  
> デフォルトの 0.75 は、メモリ使用量とパフォーマンスのバランスが取れている値ですが、用途によっては変更することもできる

### accessOrder パラメータとは
* false（デフォルト）: **挿入順序**を保持する
  * LinkedHashMap のエントリは、挿入された順番で格納される
  * 最初に挿入された要素が最初に取り出され、順番にアクセスされる
```Java
LinkedHashMap<String, Integer> map = new LinkedHashMap<>(16, 0.75f, false);
map.put("A", 1);
map.put("B", 2);
map.put("C", 3);

// 挿入順で取り出される
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}
```

* true: **アクセス順序**を保持する
  * LinkedHashMap のエントリは、アクセスされた順番で格納される
  * すなわち、**要素が取り出されると、その要素が最後尾に移動する**ようになる
```Java
LinkedHashMap<String, Integer> map = new LinkedHashMap<>(16, 0.75f, true);
map.put("A", 1);
map.put("B", 2);
map.put("C", 3);

// 最初に "A" をアクセス（取り出す）
map.get("A");

// アクセス順で取り出される（"A" が最後に移動）
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}
```
***************************************************************************
## 主なコード一覧
### 要素の追加
map.put(キー値, バリュー値);  
※ すでに同名のキー値があれば、該キーのバリュー値に対して新しいバリュー値を上書きする

### 要素の取得
map.get(キー値);  
※ 登録されていないキー値を取得しようとすると、`エラーにはならず`、`null`を取得する

### キー値取得を試し、nullの場合デフォ値を返す
map.getOrDefault(試すキー値, デフォ値);

```Java
// Sが存在している場合、元のバリュー値+1。存在しない場合n + 1を代入
map.put(S, map.getOrDefault(S, n) + 1);
```

### キーが存在していない場合は挿入、している場合は何もしない
map.computeIfAbsent(試すキー値, key -> 計算);  
※ 存在している場合、何もしない
```Java
map.computeIfAbsent("A", key -> 100);
```

### キーが存在していない場合は挿入、している場合は更新
map.merge(キー値, 新しい値, 計算【マージ関数】);
```Java
LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
map.merge("A", 5, Integer::sum); // A=5
map.merge("A", 5, Integer::sum); // A=10
```

#### マージ関数
oldValue:最初の値  
newValue:新しい値  
1. **加算 Integer::sum**：最初の値 + 新しい値
2. **最大値 Math::max**：最初の値 と 新しい値 の比較
3. **最小値 Math::min**：最初の値 と 新しい値 の比較
4. 計算ロジックを改めて組む
```Java
map.merge("key", 10, (oldValue, newValue) -> {
    if (newValue > oldValue) {
        return newValue; // 大きい方を保存
    }
    return oldValue; // 小さい方を無視
});
```

### 特定のキー値が存在しているのかどうか【boolean】
map.containsKey(キー値);

### 特定のバリュー値が存在しているのかどうか【boolean】
map.containsValue(バリュー値);

### 特定のキー値ペアを削除する
map.remove(キー値);

### このマップからすべての要素を削除する
map.clear();

### このマップは空であるかどうか【boolean】
map.isEmpty();

### ペア数の取得
map.size();

### 全置換
map.replaceAll((key, value) -> バリュー値への変動);  
※ 二項演算子を活用するなど

### 二つのマップを結合
map1.putAll(map2);  
※ コピーとして使える。影響はコピー元に及ばない
```Java
LinkedHashMap<String, Integer> map1 = new LinkedHashMap<>();
map1.put("apple", 5);

LinkedHashMap<String, Integer> map2 = new LinkedHashMap<>();
map2.put("grape", 2);

map1.putAll(map2);
System.out.println(map1);　// {apple=5, grape=2}
```

### コピー方法
stream使用するので、`import java.util.stream.*;`を掛ける必要がある
```Java
Map<String, Integer> map2 = map1.entrySet()
    .stream()
    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
```

### 出力方法
直接mapを出力する際、`{A=1, B=2, C=3}`のような形で出力される

#### ラムダ式
map.forEach((key, value) -> System.out.println(key + ":" + value));

#### keySet()
for (String key : map.keySet()){  
※ String keyのところは、キーの型と合わせる  
※ 各処理ごとに値を探す処理が必要となり、大量のデータには向いていない

#### entrySet()
for (Map.Entry<String, Integer> entry : map`.entrySet()`) {

#### map.entrySet().parallelStream()
map`.entrySet()` `.parallelStream()`.forEach(entry -> {  
※ データが膨大で、順序を気にしない場合には高速化が期待できる
```Java
LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);

// 1. forEach
map.forEach((key, value) -> {
    System.out.println(key + " : " + value);
});

// 2. keySet()
for (String key : map.keySet()){
    System.out.println(key + " : " + map.get(key));
}

// 3. entrySet を使って操作
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " : " + entry.getValue());
}

// 4. entrySet() と parallelStream() (parallelStream() によって並列ストリームを使用。)
// 出力順は：Banana = 2、Cherry = 3、Apple = 1となった
map.entrySet().parallelStream().forEach(entry -> {
    System.out.println(entry.getKey() + " = " + entry.getValue());
});
```

| メリット | コスト | 順序の保持 | 推奨度 |
| --- | --- | --- | --- |
| forEach | O(n) | O(挿入順) | ◎シンプルで最適 |
| keySet() + for | O(n) ~ O(n^2) | O(挿入順) | △非効率 |
| entrySet() + for | O(n) | O(挿入順) | △効率的かつ標準 |
| entrySet() + parallelStream() | O(n)順序非保持 | X | △条件次第 |

### ソート
#### Key昇順
* 基本コスト：O(n log n)
1. `List`にする  
```Java
List<String> sortedKeys = new ArrayList<>(map.keySet());  
Collections.sort(sortedKeys); 
```

2. `TreeSet`にする
```Java
TreeSet<String> sortedKeys = new TreeSet<>(map.keySet());
```

3. `TreeMap`にする  
```Java
for(var i :`(new TreeMap<>(map))`.keySet()) {}
```

#### Key降順
* 基本コスト：O(n log n)
* `Collections.reverseOrder()`を利用するには、`import java.util.Collections;`が必要

1. `List`にする  
```Java
List<String> sortedKeys = new ArrayList<>(li.keySet());  
Collections.sort(li, Collections.reverseOrder());
```

2. `TreeSet`にする  
```Java
TreeSet<String> sortedKeys = new TreeSet<>(Collections.reverseOrder());
sortedKeys.addAll(map.keySet());
```

3. `TreeMap`にする  
```Java
TreeMap<String, String> sortedMap = new TreeMap<>(Collections.reverseOrder());
sortedMap.putAll(map);
for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}
```

#### Value昇順
* stream使用するので、`import java.util.stream.*;`を掛ける必要がある
```Java
LinkedHashMap<String, Integer> sortedByValueAsc = map.entrySet().stream()
    .sorted(Map.Entry.comparingByValue())
    .collect(Collectors.toMap(
        Map.Entry::getKey,
        Map.Entry::getValue,
        (oldValue, newValue) -> oldValue, // マージ関数（競合回避）
        LinkedHashMap::new // ソート結果をLinkedHashMapに
    ));
```

#### Value降順
* stream使用するので、`import java.util.stream.*;`を掛ける必要がある
```Java
LinkedHashMap<String, Integer> sortedByValueDesc = map.entrySet().stream()
    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
    .collect(Collectors.toMap(
        Map.Entry::getKey,
        Map.Entry::getValue,
        (oldValue, newValue) -> oldValue, // マージ関数（競合回避）
        LinkedHashMap::new // ソート結果をLinkedHashMapに
    ));
```

#### Value値降順⇒Key降順
やり方はリストソートを参照している。  
[おさらい](/【1List】ArrayList.md#二重ソート)
```Java
// エントリをリストに変換
List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

// 値で降順、同じ値のときはキーで降順にソート
entryList.sort((entry1, entry2) -> {
    int valueCompare = entry2.getValue().compareTo(entry1.getValue()); // バリュー値の降順
    //int valueCompare = entry1.getValue().compareTo(entry2.getValue()); // バリュー値の昇順
    if (valueCompare == 0) {
        return entry2.getKey().compareTo(entry1.getKey()); // キー値の降順
        //return entry1.getKey().compareTo(entry2.getKey()); // キー値の昇順
    }
    return valueCompare;
});

// ソートされたエントリを新しいLinkedHashMapに追加
LinkedHashMap<String, Integer> sortedmap = new LinkedHashMap<>();
for (Map.Entry<String, Integer> entry : entryList) {
    sortedmap1.put(entry.getKey(), entry.getValue());
}
```

### Key値のリスト化
map.keySet()  
※ stream使用するので、`import java.util.stream.*;`を掛ける必要がある  
※ 戻り値は【Set】
```Java
// キーをリスト化
List<String> keys = map.keySet().stream()
                                .collect(Collectors.toList());
```

### Value値のリスト化
map.values()  
※ stream使用するので、`import java.util.stream.*;`を掛ける必要がある  
※ 戻り値は【Collection】
```Java
// 値をリスト化
List<Integer> values = map.values().stream()
                                .collect(Collectors.toList());
```
