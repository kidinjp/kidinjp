概要
* [ArrayListの特徴](#arraylistの特徴)
* [主なコード一覧](#主なコード一覧)
    * [要素の追加](#要素の追加)
    * [要素を指定された位置に追加](#要素を指定された位置に追加)
    * [二つのリストを結合](#二つのリストを結合)
    * [二つのリストを指定された位置に結合](#二つのリストを指定された位置に結合)
    * [指定位置範囲の要素を切り出す\[fromIndex, toIndex)【List<>】](#指定位置範囲の要素を切り出すfromindex-toindexlist)
    * [指定された位置にある要素を削除](#指定された位置にある要素を削除)
    * [最初に検出された指定要素を削除](#最初に検出された指定要素を削除)
    * [範囲のインデックスを持つすべての要素をこのリストから削除\[fromIndex, toIndex)](#範囲のインデックスを持つすべての要素をこのリストから削除fromindex-toindex)
    * [リストから、指定されたコレクション内に保持されているすべての要素を削除。差集合](#リストから、指定されたコレクション内に保持されているすべての要素を削除。差集合)
    * [リストから、指定されたコレクション内に保持されているすべての要素を削除。共通集合](#リストから、指定されたコレクション内に保持されているすべての要素を削除。共通集合)
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
    * [このリストに要素があるかどうか【boolean】](#このリストに要素があるかどうかboolean)
    * [特定要素はリストに含まれているかどうか【boolean】](#特定要素はリストに含まれているかどうかboolean)
    * [特定要素が最初に検出された位置のインデックスを返す](#特定要素が最初に検出された位置のインデックスを返す)
    * [特定要素が最後に検出された位置のインデックスを返す](#特定要素が最後に検出された位置のインデックスを返す)
    * [join_String](#join_string)
    * [join_Integer](#join_integer)
    * [このリスト内の要素を(適切な順序で)反復するリスト・イテレータを返す](#このリスト内の要素を(適切な順序で)反復するリスト・イテレータを返す)
    * [定された位置で始まる、リスト内の要素を(適切な順序で)反復するリスト・イテレータを返す](#定された位置で始まる、リスト内の要素を(適切な順序で)反復するリスト・イテレータを返す)
    * [リストを走査するためのイテレータを返す](#リストを走査するためのイテレータを返す)
    * [配列への変換](#配列への変換)
* [Collectionsを利用したコード](#collectionsを利用したコード)
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
    * [xというものが現れた回数](#xというものが現れた回数)
    * [補填](#補填)
    * [コピー（深いコピー、Collections）](#コピー深いコピーcollections)
    * [サブリスト](#サブリスト)
    * [空リストを生成](#空リストを生成)
    * [指定したい要素を一つ持つリストを生成](#指定したい要素を一つ持つリストを生成)
    * [順序の確認](#順序の確認)
    * [スレッドセーフなコレクションの生成](#スレッドセーフなコレクションの生成)


なお、便宜を図って、各型のデフォ値を下記通りとする。  
`ArrayList<String>` li = new ArrayList<>();　または  
`ArrayList<Integer>` li = new ArrayList<>();

***************************************************************************
## ArrayListの特徴
* **import java.util.ArrayList;**
* **動的なサイズ調整もできるリスト型コレクション**
  要素が追加されるたびに自動的にサイズが増加する。内部で管理する配列のサイズを必要に応じて拡張することで、動的なサイズ変更が可能になっている
* **ランダムアクセスが高速**
  インデックスによるアクセスが高速。リストの特定位置のデータを即座に取得できる
* **要素の挿入・削除に注意**
  構造上、リストの中間で要素を追加・削除すると、それ以降の要素を移動させる必要があるため、要素の挿入や削除は配列の末尾以外ではやや低速
* **宣言と初期化**
```Java
// 空の ArrayList を生成（デフォルトの初期容量）
ArrayList<String> list = new ArrayList<>();

// 初期容量を指定して生成（要素数が多い場合に便利）
ArrayList<Integer> numbers = new ArrayList<>(50);

// 初期要素付きで生成する（Arrays.asListを使う）import java.util.Arrays;も必要となる
ArrayList<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
```

***************************************************************************
## 主なコード一覧

### 要素の追加
li.add();

### 要素を指定された位置に追加
li.add(インデックス, 指定された要素);  
※ 長さを超えたインデックスに追加しようとすると``エラーが起こる``

### 二つのリストを結合
li1.addAll(li2);  
※ 前のリストにのみ追加を行う

### 二つのリストを指定された位置に結合
li1.addAll(インデックス, li2);  
※ 前のリストにのみ追加を行う  
※ 長さを超えたインデックスに追加しようとすると``エラーが起こる``

### 指定位置範囲の要素を切り出す[fromIndex, toIndex)【List<>】
li.subList(fromIndex, toIndex);  
※ 戻り値はList<>となるため、直接のコピーはできない。以下の工夫が必要となる
``` Java
// 同じ型のリストから特定の範囲の要素を取り出す
ArrayList<Integer> li2 = new ArrayList<>(li.subList(fromIndex, toIndex));
```

※ clear()と合わせて利用することによって、指定範囲の内容を削除でき、[.removeRange()](#範囲のインデックスを持つすべての要素をこのリストから削除fromindex-toindex)の代わりになれる
```Java
// 【li = 】の記述はいらない
li.subList(fromIndex, toIndex).clear();
```
### 指定された位置にある要素を削除
li.remove(インデックス);  
※ 長さを超えたインデックスを削除しようとすると``エラーが起こる``

### 最初に検出された指定要素を削除
li.remove(文字（列）);  
li.remove(Integer.valueOf(数値));  
※ 特に特定インデックスではなく、特定数値を削除したい場合、このように指定するとインデックスではなく数値をターゲットとして削除の動作を行う  
※ 特定数値/文字（列）がリスト内に存在しない場合、特に行うことはない上``エラー起らない``  

### 範囲のインデックスを持つすべての要素をこのリストから削除[fromIndex, toIndex)
li.removeRange(fromIndex, toIndex);  
※ removeRange(int,int) has protected access in ArrayList該メソッドは保護されているので、通常使えない  
※ 代わりにsubListやclearを使うのをおすすめ

### リストから、指定されたコレクション内に保持されているすべての要素を削除。差集合
li1.removeAll(li2);

### リストから、指定されたコレクション内に保持されているすべての要素を削除。共通集合
li1.retainAll(li2);

### 指定された条件と合致する要素を全削除
li.removeIf(i -> i % 2 == 1); ⇒ 奇数を消す

### このリストからすべての要素を削除する
li.clear()

### コピー（浅いコピー）
```Java
ArrayList<Integer> li2 = (ArrayList<Integer>)li.clone();
ArrayList<Integer> li2 = new ArrayList<>(li);
```
※ 不変オブジェクトではない場合、コピー内容に対する変更はコピー元に影響を与える（浅いコピー）

### コピー（深いコピー）
``` Java
// streamを使用する
ArrayList<Integer> li2 = new ArrayList<Integer>(li.stream()
    .map(Integer::valueOf) // オートボクシングの明示、記載すると可読性は上がる。ない方が処理効率的にいい
    .collect(Collectors.toList()));

// クラスのリストの場合
List<Person> deepCopy = original.stream()
    .map(person -> new Person(person.name))
    .collect(Collectors.toList());
```

### 指定されたインデックスにある要素を取得する
li.get(n);

### 指定されたインデックスにある要素を、指定された数値/文字列に置き換える
li.set(n, X);

### 指定されたオブジェクトがこのリストと等しいかどうか【boolean】
li1.equals(li2);  
※ trueになる条件
* 指定されたオブジェクトもリストである
* サイズが同じ
* 2つのリストの各インデックスに対応する要素がすべて等しい

### このリストのハッシュ・コード値を返す
li.hashCode();

### 内部配列の容量を要素数に合わせる
li.trimToSize();
``` Java
// 初期容量を100と指定して生成（要素数が多い場合に便利）
ArrayList<String> li = new ArrayList<>(100);
// 実際に追加された内容は3つ
li.add("A");
li.add("B");
li.add("C");

// 未使用の無駄なメモリーを解放
li.trimToSize();
```

### 要素を追加する前に容量を確保しておく
li.ensureCapacity(n);
``` Java
ArrayList<String> li = new ArrayList<>();
// 大量の要素を追加する前に、あらかじめ容量を確保(100)
li.ensureCapacity(100);
for (int i = 0; i < 100; i++) {
    li.add(i);
}

```

### リスト内の要素数/長さを返す
li.size();

### このリストに要素があるかどうか【boolean】
li.isEmpty();  
※ 空の場合`true`と返す

### 特定要素はリストに含まれているかどうか【boolean】
li.contains(o);

### 特定要素が最初に検出された位置のインデックスを返す
li.indexOf(o);

### 特定要素が最後に検出された位置のインデックスを返す
li.lastIndexOf(o);

### join_String
System.out.println(String.join(" ", li));

### join_Integer
joinはStringの要素に対して
```Java
ArrayList<Integer> li = new ArrayList<>(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0));
System.out.println(String.join(" ", li.stream()
                                      .map(String::valueOf)  // 各 Integer を String に変換
                                      .collect(Collectors.toList())));
```


***************************************************************************
### このリスト内の要素を(適切な順序で)反復するリスト・イテレータを返す
ListIterator<String> iterator = list.listIterator();
```Java
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> iterator = list.iterator(); // イテレータの取得
        while (iterator.hasNext()) {                 // 要素があるかチェック
            System.out.println(iterator.next());     // 次の要素を取得
        }
    }
}
```

### 定された位置で始まる、リスト内の要素を(適切な順序で)反復するリスト・イテレータを返す
ListIterator<String> iterator = list.listIterator(1);

### リストを走査するためのイテレータを返す
Iterator<String> iterator = list.iterator();  
Spliterator<String> spliterator = list.spliterator();
```Java
import java.util.ArrayList;
import java.util.Spliterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Spliterator<String> spliterator = list.spliterator(); // スプリッタレータの取得
        spliterator.forEachRemaining(System.out::println);    // 残り要素を処理
    }
}
```

### 配列への変換
Integer[] array = li.toArray(new Integer[0または上限に設定したい数字]);  
※ 数字について、  
　　元リストの長さより高い数値を設定した場合：`null`を補う  
　　元リストの長さより低い数値を設定した場合：元のリストの長さそのまま変換される（少なくなることはない）
```Java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> li = new ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4, 5));
        Integer[] array = li.toArray(new Integer[0]);  // 長さ0の配列を指定
        for (Integer num : array) {
            System.out.println(num);
        }
    }
}
```

***************************************************************************
## Collectionsを利用したコード
### 逆順
Collections.reverseOrder(li);

### ソート（昇順）
Collections.sort(li);

### ソート（降順）
Collections.sort(li, Collections.reverseOrder());

### 二重ソート
#### li[x][2] の昇順で並び替え、同列の場合 li[x][0] の昇順
```Java
Collections.sort(li, (a, b) -> {
    // まず、3番目の要素（index 2）を昇順で比較
    if (!a.get(2).equals(b.get(2))) {
        return Integer.compare(a.get(2), b.get(2));
    } else {
        // 3番目の要素が同じ場合、1番目の要素（index 0）を昇順で比較
        return Integer.compare(a.get(0), b.get(0));
    }
});
```

#### li[x][2] の降順で並び替え、同列の場合 li[x][0] の降順
```Java
// li[x][2] の降順で並び替え、同列の場合 li[x][0] の降順
Collections.sort(li, (a, b) -> {
    // まず、3番目の要素（index 2）を降順で比較
    if (!a.get(2).equals(b.get(2))) {
        return Integer.compare(b.get(2), a.get(2));
    } else {
        // 3番目の要素が同じ場合、1番目の要素（index 0）を降順で比較
        return Integer.compare(b.get(0), a.get(0));
    }
});
```

### シャッフル
ランダムに並び替える  
Collections.shuffle(li);

### 最小値
Collections.min(li);

### 最大値
Collections.max(li);

### sum
``import java.util.stream.*;``などが必要
``` Java
int sum = li.stream()
    .mapToInt(Integer::intValue)
    .sum();
```
    
### xというものが現れた回数
Collections.frequency(li, "a")  
※ StringでもIntegerでも数えれる、Match Caseではある

### 補填
Collections.fill(li, 1)

### コピー（深いコピー、Collections）
Collections.nCopies(li.size(), "デフォ値"); // コレクションクラスのコピーは、Listにした対応できない  
Collections.copy(コピー先, コピー元); // 要素数の型統一する必要ある

```Java
ArrayList<String> li = new ArrayList<>(Arrays.asList("a", "a", "C", "A", "a"));
List<String> copy = new ArrayList<>(Collections.nCopies(li.size(), ""));
Collections.copy(copy, li);  // 両方ともString型に統一
```

### サブリスト
Collections.unmodifiableList(li);  
※ 作成されたリストは`不変`であり、変更を行おうとするとエラーが発生する`java.lang.UnsupportedOperationException`  
※ リストの要素がミュータブル（変更可能）であれば、その要素自体は変更可能

```Java
// リストの要素がミュータブル（変更可能）であれば、その要素自体は変更可能の例
List<List<String>> outerList = new ArrayList<>();
List<String> innerList = new ArrayList<>(Arrays.asList("A", "B"));
outerList.add(innerList);

// 外側のリストは変更不可だが、内側のリストは変更可能
List<List<String>> unmodifiableOuter = Collections.unmodifiableList(outerList);

// これで内側のリストは変更不可になるわけではない
unmodifiableOuter.get(0).add("C");  // これは問題なく実行される
System.out.println(outerList);  // [[A, B, C]]
```

### 空リストを生成
Collections.emptyList();  
※ 変更不可能

```Java
List<Integer> emptyList = Collections.emptyList();
```

### 指定したい要素を一つ持つリストを生成
Collections.singletonList("指定したい要素");  
※ 変更不可能

```Java
List<String> singletonList = Collections.singletonList("one");
```

### 順序の確認
Collections.indexOfSubList(調査されるリスト, 探す内容リスト);  
※ 含まれていない場合：-1を返す  
※ 含まれている場合：見つかるインデックスを返す

```Java
int index = Collections.indexOfSubList(li, Arrays.asList("a", "b"));
```
使用例：sourceリストの中でどの位置にtargetリストが含まれているかを探す
```Java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> source = Arrays.asList(1, 2, 3, 4, 3, 4, 5);
        List<Integer> target = Arrays.asList(3, 4);
        List<Integer> indices = new ArrayList<>();

        int index = Collections.indexOfSubList(source, target);
        while (index != -1) {
            indices.add(index);
            // 次の検索開始位置
            index = Collections.indexOfSubList(source.subList(index + 1, source.size()), target);
            if (index != -1) {
                index += indices.get(indices.size() - 1) + 1;
            }
        }

        System.out.println("Target found at indices: " + indices);  // 出力: Target found at indices: [2, 4]
    }
}
```

### スレッドセーフなコレクションの生成
Collections.synchronizedList(li);
