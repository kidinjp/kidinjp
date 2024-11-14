概要
* [LinkedHashSetの特徴](#linkedhashsetの特徴)
* [主なコード一覧](#主なコード一覧)
* [よく使う運用](#よく使う運用)
  * [配列化](#配列化)
    * [String\[\]配列に](#string配列に)
    * [Integer\[\]配列に](#integer配列に)

なお、便宜を図って、各型のデフォ値を下記通りとする。  
`LinkedHashSet<String>` li = new LinkedHashSet<>();　または  
`LinkedHashSet<Integer>` li = new LinkedHashSet<>();

***************************************************************************
## LinkedHashSetの特徴
* **import java.util.LinkedHashSet;**
* **挿入順序の保持**
* **ユニークな要素（一意）**
* **高速なアクセスと操作**  
   HashSetと同様に、ハッシュテーブルを使った効率的なデータ構造であるため、要素の追加・削除・検索が平均的にO(1)の時間で行えます。
* **宣言と初期化**

```Java
// 空の LinkedHashSet を生成（デフォルトの初期容量）LinkedHashSet
LinkedHashSet<String> list = new LinkedHashSet<>();

// 初期容量を指定して生成（要素数が多い場合に便利）
LinkedHashSet<Integer> numbers = new LinkedHashSet<>(50);

// 初期要素付きで生成する（Arrays.asListを使う）import java.util.Arrays;も必要となる
LinkedHashSet<String> fruits = new LinkedHashSet<>(Arrays.asList("Apple", "Banana", "Cherry"));

// リストをセットに変える
List<Integer> li = Arrays.asList(1, 3, 5, 1, 2, 3, 6, 6, 5, 1, 4);
Set<Integer> a = new LinkedHashSet<>(li);
LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(li);
LinkedHashSet<Integer> linkedHashSet2 = new LinkedHashSet(li); // ダイヤモンド演算子 は省略可

```

***************************************************************************
## 主なコード一覧
大半のコードは[ArrayList](/【1List】ArrayList.md#arraylistの特徴)にまとめてあるコードが使えるため別紙参照ください。

***************************************************************************
## よく使う運用

### 配列化
LinkedHashSetのロジックを利用して、重複を許さない、挿入順序を保持した配列を作る

#### String[]配列に
```Java
import java.util.stream.*;

String[] s = Arrays.stream("1 3 5 1 2 3 6 6 5 1 4".split(" "))
    .collect(Collectors.toCollection(LinkedHashSet::new)) // 重複を許さない、挿入順序の保持
    .toArray(String[]::new);
```

#### Integer[]配列に
```Java
import java.util.stream.*;

Integer[] s = Arrays.stream("1 3 5 1 2 3 6 6 5 1 4".split(" "))
    .map(Integer::parseInt) // 要素を Integer に変換
    .collect(Collectors.toCollection(LinkedHashSet::new)) // 重複を許さない、挿入順序の保持
    .toArray(Integer[]::new);
```
