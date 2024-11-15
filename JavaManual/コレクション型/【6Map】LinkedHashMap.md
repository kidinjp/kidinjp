概要
なお、便宜を図って、各型のデフォ値を下記通りとする。

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
主なコード一覧




🫠 put
map.put(a, b); //すでにaがある場合、内容がbに更新する 
🫠 取得、get
map.get(a) //（a, b）のペアの中のbを取り出す。aが存在しなかった場合エラーせずにnullになる
KID. — 2024/09/19 21:59
🫠 ペア数の取得、size
mao.size()

🫠 ペアの有無を確認、containsKey、containsValue。true/ falseを返す

map.containsKey(a); 
map.containsValue(b); 

🫠 ペアを削除、remove
map.remove(a);

🫠 ペアリセット、clear
map.clear();

🫠 空であるかどうか、isEmpty。true/ falseを返す
map.isEmpty()
🫠 出力
①
map.forEach((key, value) -> System.out.println(key + ":" + value));
②
for (String key : map.keySet()){
    Integer value = map.get(key);
    System.out.println(key + ":" + value);
}
③
import java.util.Map.Entry;
for (Map.Entry<Integer, String> entry : users.entrySet()) {
    System.out.println(entry.getKey());
    System.out.println(entry.getValue());
}


🫠 Keyの辞書順でソート
        List<String> sortedKeys = new ArrayList<>(li.keySet());
        Collections.sort(sortedKeys); 
🫠 キー一覧を取得、map.keySet()
[1, 2, 3]
KID. — 2024/09/23 3:10
🫠 既存ではない場合nを代入し、該ペアを追加する
ma.put(S, ma.getOrDefault(S, n) + 1);
🫠 辞書順のmap、TreeMap
        Map<String, Integer> map = new TreeMap<>();
KID. — 2024/10/01 9:09
🫠 値降順⇒キー降順
```Java
        // エントリをリストに変換
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(supacha.entrySet());

        // 値で降順、同じ値のときはキーで降順にソート
        entryList.sort((entry1, entry2) -> {
            int valueCompare = entry2.getValue().compareTo(entry1.getValue()); // 値の降順
            //int valueCompare = entry1.getValue().compareTo(entry2.getValue()); // 値の降順
            if (valueCompare == 0) {
                return entry2.getKey().compareTo(entry1.getKey()); // キーの降順
                //return entry1.getKey().compareTo(entry2.getKey()); // キーの昇順
            }
            return valueCompare;
        });

        // ソートされたエントリを新しいLinkedHashMapに追加
        LinkedHashMap<String, Integer> sortedSupacha = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedSupacha.put(entry.getKey(), entry.getValue());
        }
```
