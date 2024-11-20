概要
* [Stream APIの特徴](#stream-apiの特徴)
* [中間操作](#中間操作)
  * [フィルタリング](#フィルタリング)
  * [マッピング](#マッピング)
  * [フラットマップ](#フラットマップ)
  * [ソート](#ソート)
  * [スライス](#スライス)
  * [途中経過を出力](#途中経過を出力)
  * [重複する要素を削除](#重複する要素を削除)
  * [最初の要素をn個スキップする](#最初の要素をn個スキップする)
* [終端操作](#終端操作)
  * [収集](#収集)
  * [集計](#集計)
  * [ループ(出力)](#ループ出力)
  * [ループ(順序を保った出力)](#ループ順序を保った出力)
  * [変換](#変換)
    * [ストリームを配列に](#ストリームを配列に)
    * [リストを配列に](#リストを配列に)
  * [マッチ条件](#マッチ条件)
    * [任意マッチ](#任意マッチ)
    * [全マッチ](#全マッチ)
    * [全ノーマッチ](#全ノーマッチ)
  * [最初の要素を返す](#最初の要素を返す)
  * [無限生成](#無限生成)
* [Optionalについて](#optionalについて)
  * [Optionalを作成する](#optionalを作成する)
  * [空のOptionalを作成する](#空のoptionalを作成する)
  * [null要素を入ったOptionalを作成する](#null要素を入ったoptionalを作成する)
  * [値を取得](#値を取得)
  * [値が存在するかどうか【boolean】](#値が存在するかどうかboolean)
  * [値が存在する場合に指定した操作を行う](#値が存在する場合に指定した操作を行う)
  * [値が存在しない場合、指定したデフォルト値を返す](#値が存在しない場合指定したデフォルト値を返す)
  * [デフォルト値を生成するロジックを指定できる](#デフォルト値を生成するロジックを指定できる)
  * [値が存在しない場合に例外をスロー](#値が存在しない場合に例外をスロー)
  * [値が存在する場合、変換処理を適用し、新しいOptionalを返す](#値が存在する場合変換処理を適用し新しいoptionalを返す)
  * [条件に一致する場合のみ値を保持](#条件に一致する場合のみ値を保持)

***************************************************************************
## Stream APIの特徴
1. **ストリームパイプライン**
    * ストリームはデータを流れるように操作する
    * `中間操作`（例: filter, map）と`終端操作`（例: forEach, collect）で構成される
    * `中間操作`: 新しいストリームを返す（例: filter(), map()）
    * `終端操作`: ストリームを消費して結果を返す（例: forEach(), collect()）。
2. **非破壊的**
    * 元のデータ構造（リストや配列など）は変更されない
3. **遅延評価**
    * 中間操作は結果を即座に実行せず、必要に応じて終端操作時に評価される
4. **並列処理のサポート**
    * ストリームは簡単に並列処理（parallelStream()）に対応できる
5. **ストリームの種類**
    * シーケンシャルストリーム：`順次処理`。要素を順序通りに処理するストリーム
    * パラレルストリーム（parallel() または parallelStream()）：`並列処理`。要素を並列に処理するストリーム  
※ パラレルストリームは計算が重い処理に適しているが、軽量な処理ではオーバーヘッドが増える
```Java
// シーケンシャルストリーム
IntStream.range(1, 5) // 1, 2, 3, 4 を生成
         .forEach(n -> System.out.println(Thread.currentThread().getName() + " processing " + n));

// パラレルストリーム
IntStream.range(1, 5) // 1, 2, 3, 4 の内容で、ランダムの順番で生成
         .parallel() // 並列処理を指定
         .forEach(n -> System.out.println(Thread.currentThread().getName() + " processing " + n));

// パラレルストリーム(順序を保った結果を出力)
IntStream.range(1, 5) // 1, 2, 3, 4 の内容で、ランダムの順番で生成
         .parallel() // 並列処理
         .forEachOrdered(n -> System.out.println(n)); // 順序を保持、1, 2, 3, 4
```
6. **注意点**
  * `1度しか消費できない`: ストリームは一度消費されると再利用できない(例えStream変数を使っても)
  * `無限ストリームの制御`: .limit() なしで使用すると無限ループの原因になる
  * `Null を扱わない`: Stream.ofNullable() を利用する
7. **ストリーム生成方法**
* コレクション型から
```Java
Stream<String> stream1 = li.stream();  // コレクションから
Stream<String> stream2 = collection.stream();

```

* 配列から
```Java
Stream<Integer> stream1 =Stream.of(arr);
Stream<Integer> stream2 = Arrays.stream(new int[]{1, 2, 3});  // 配列から
```

* 値や範囲から  
※ boxed():プリミティブ型のストリーム（IntStream, LongStream, DoubleStream）を、  
ラッパー型のストリーム（Stream<Integer>, Stream<Long>, Stream<Double>）に変換
```Java
Stream<String> stream = Stream.of("A", "B", "C"); // 任意の値から
Stream<Integer> stream2 = IntStream.range(1, 5).boxed(); // 1から4までの範囲
```

* 無限ストリーム(`.limit(n)` で制限して無限エラーを回避する)
```Java
Stream<Double> randomStream = Stream.generate(Math::random); // 無限ランダム値
Stream<Integer> iterateStream = Stream.iterate(0, n -> n + 2); // 0, 2, 4...。偶数内容を
```

* ファイルから
var stream = Files.lines(Paths.get("file.txt"));

***************************************************************************
## 中間操作
ある要素に満たしているものに対して操作する
* ストリームを別のストリームに変換
* 0個以上
* 終端操作が実行されるまで未実行
* 関数型インターフェースのインスタンスや、メソッドを使用する（ラムダ式、メソッド参照など）

### フィルタリング
* `Predicate型`を引数に取る
* 条件に一致する要素のみを残す
```Java
Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5).filter(n -> n % 2 == 0); // 2, 4
```

### マッピング
* `Predicate型`を引数に取る
* 要素を変換する（型/値を変更）
```Java
Stream<String> upperCase = Stream.of("a", "b", "c").map(String::toUpperCase);　// A, B, C
```

### フラットマップ
`.flatMap(List::stream)`
* `Function型`を引数に取る
* 各要素から新たに生成したストリームを、すべて繋げて、flatと化したストリームを返すメソッド
* 新しいストリームを生成し、複数の値を一つのストリームにflat化する

```Java
List<List<String>> nested = List.of(List.of("A", "B"), List.of("C", "D"));
Stream<String> flat = nested.stream().flatMap(List::stream); // A, B, C, D
```

### ソート
* 引数はいらない
* 要素を自然順序に従ってソートしたストリームを返すメソッド

```Java
Stream<String> customSorted = Stream.of("apple", "banana", "cherry")
//    .sorted(); // 昇順
//    .sorted(Comparator.reverseOrder()); // 降順
//    .sorted((s1, s2) -> s2.length() - s1.length()); // 長い順（ラムダ式）
//    .sorted(Comparator.comparingInt(s -> (int) s.chars().filter(ch -> ch == 'a').count())); // 特定の文字'a'の出現回数昇順
    .sorted(Comparator.comparingInt(String::length)); // 文字数が短い方
        .thenComparing(Comparator.naturalOrder())); // 更に辞書順でソート
```

### スライス
`.limit(x)`
`.skip(x)`
* `int型`/ `Integer型`を引数に取る
* 部分的なストリームを作る
* limit(n); 先頭からn個の要素を取得
* skip(n); 先頭のn個の要素をスキップ
```Java
Stream<Integer> limited = Stream.iterate(1, n -> n + 1).limit(5); // 1, 2, 3, 4, 5
Stream<Integer> skipped = Stream.of(1, 2, 3, 4, 5).skip(2); // 3, 4, 5
```

### 途中経過を出力
`.peek(s -> System.out.println("After filtering: " + s))`
* `Consumer型`を引数に取る
* ストリームの各要素に対して、指定された操作を実行し、それらの各要素からなるストリームを返すメソッド
* 中間操作の途中経過を確認する際におすすめ。主にデバッグ目的で使用
```Java
Stream.of("apple", "banana", "cherry")
    .peek(s -> System.out.println("Before filtering: " + s)) // フィルタ前の要素を確認
    .filter(s -> s.startsWith("b")) // "b" で始まる要素のみ
    .peek(s -> System.out.println("After filtering: " + s)) // フィルタ後の要素を確認
    .forEach(System.out::println); // 結果を出力
```

### 重複する要素を削除
* 引数はいらない
* 順番は元の順番を維持
* 内部的には equals() メソッドを使用するため、カスタムオブジェクトの場合は equals() の実装が影響する
```Java
Stream.of(1, 2, 2, 3, 3, 3, 4)
      .distinct()
      .forEach(System.out::println);　// 
```

### 最初の要素をn個スキップする
* Integer/ int などの整数型を引数に取る
* 指定する長さが全体を超えた場合、何も残されないOptionになるため`エラーにはならない`
```Java
Stream.of(1, 2, 3, 4, 5)
      .skip(2)
      .forEach(System.out::println);
```

***************************************************************************
## 終端操作
中間操作の結果ストリームに対して、最終的な操作を行う操作
* 最後の中間操作をもとに行われる最終的な計算
* 例えば：条件に満たしている要素のみの状態のストリームからリストを生成する、など
* 関数型インターフェースのインスタンスや、メソッドを使用する（ラムダ式、メソッド参照など）

### 収集
* コレクションなどの要素数が可変なオブジェクトに、ストリームの要素を追加して返す
* コレクター型を引数に取る（コレクター型のインスタンスはコレクターズクラスに様々な実装を返すメソッドが用意されているためこれらを使うと便利）
```Java
String s = Stream.of("a", "b", "c").collect(Collectors.joining("/")); // "a/b/c"
List<String> list = Stream.of("a", "b", "c").collect(Collectors.toList());
Set<String> set = Stream.of("a", "b", "c").collect(Collectors.toSet());
Map<String, Integer> map = Stream.of("apple", "banana")
                                 .collect(Collectors.toMap(s -> s, String::length));
```

### 集計
* データをまとめる
  * 要素数、長さ
  * 最大値
  * 最小値
  * 合計
```Java
long count = Stream.of(1, 2, 3).count(); // 要素数
Optional<Integer> max = Stream.of(1, 2, 3).max(Integer::compareTo); // 最大値
Integer msx2 = Stream.of(1, 2, 3)
                         .max(Integer::compareTo)
                         .orElse(Integer.MAX_VALUE); // ストリームが空の場合、最大値を返す

Optional<Integer> min = Stream.of(1, 2, 3).min(Integer::compareTo); // 最小値
Integer min2 = Stream.of(1, 2, 3)
                         .min(Integer::compareTo)
                         .orElse(Integer.MIN_VALUE); // ストリームが空の場合、最大値を返す
int sum = Stream.of(1, 2, 3).reduce(0, Integer::sum); // 合計
```

### ループ(出力)
* `Consumer型`を引数に取る
* 各要素に対して操作を実行
```Java
Stream.of("a", "b", "c").forEach(System.out::println);
```

### ループ(順序を保った出力)
* パラレルストリームに対して、順序を保った処理結果を求める
```Java
IntStream.range(1, 5)
         .parallel() // パラレルストリームに対してforEach()を行うと結果はランダムで毎回違う
         .forEachOrdered(n -> System.out.print(n + " ")); // 順序を保った結果を出力できる
```

### 変換
#### ストリームを配列に
* 引数はない。だら引数ないと`Object[]`になるため、改めて型指定する必要がある
* このストリームの要素を含むオブジェクト型の配列を返す
```Java
String[] li = l.stream().toArray(String[]::new);
```

#### リストを配列に
* 引数はない
* リストにストリームの要素を追加して返す
```Java
List<String> li = l.stream().toList();
```

### マッチ条件
#### 任意マッチ
* `Predicate型`を引数に取る
* `短絡終端操作`（すべての要素を調べる前であっても、判定処理に一致した場合は処理が終了する）
* ストリームの要素中に引数で指定された判定処理に`一致したものがあればture`を返すメソッド。一致していない/ストリームが空の場合はfalseを返す
```Java
boolean b = Stream.of(1, 2, 3, 4)
                  .peek(System.out::println) // 1 2まで出力できる
                  .anyMatch(i -> i % 2 == 0); // 2 はマッチするので、bの答えはtrueと返し、ここで操作処理終了とする
```

#### 全マッチ
* `Predicate型`を引数に取る
* `短絡終端操作`（すべての要素を調べる前であっても、判定処理に一致した場合は処理が終了する）
* ストリームの`すべての要素が、引数に指定された判定処理に一致した場合にture`を返す。ストリームが空の場合はtureが返される
```Java
boolean b = Stream.of(1, 2, 3, 4)
                  .peek(System.out::println) // 1まで出力できる
                  .allMatch(i -> i % 2 == 0); // 1 はマッチできないので、bの答えはfalseと返し、ここで操作処理終了とする
```

#### 全ノーマッチ
* `Predicate型`を引数に取る
* `短絡終端操作`（すべての要素を調べる前であっても、判定処理に一致した場合は処理が終了する）
* 引数に指定された判定処理に一致する要素がストリーム内に存在していない場合にtureを返すメソッド。ストリームが空の場合はtureが返される
```Java
boolean b = Stream.of(1, 3, 5)
                  .peek(System.out::println) // 1 3 5と出力する
                  .noneMatch(i -> i % 2 == 0); // 全部奇数のため、bの答えはfalseと返す
```

### 最初の要素を返す
* 引数はない
* `短絡終端操作`（すべての要素を調べる前であっても、判定処理に一致した場合は処理が終了する）
* ストリームの最初の要素を返す
* 戻り値：Optional型
```Java
System.out.println(Stream.of(1, 3, 5).findFirst()); // Optional[1]と返す
```

### 無限生成
* iterate(T seed, UnaryOperator<T> f)
* seed（初期値）から始める
* 関数 f を適用して次の要素を生成する  
※ iterate は無限ストリームを生成するため、制御が必要（通常、limit() で制限する）
```Java
Stream.iterate(1, n -> n + 2) // 1, 3, 5, 7, ...
      .limit(5) // 最初の5個を取得
      .forEach(System.out::println);
```

***************************************************************************
## Optionalについて
null値を扱う際の安全性を高めるためのJava8以降で導入されたクラス  
通常、null を返す可能性がある場合、NullPointerExceptionのリスクがあるが、  
Optional を使うことでそのリスクを軽減できる
* null チェックの代替手段として使用する（nullが入っているOptionalを出力する際、Optional.emptyとの内容になる）
* 値が存在するかどうかを明示的に扱える
* 値が存在する場合は処理を続け、存在しない場合はデフォルト値やエラーハンドリングを適用  

使う場面
※ 以降は`Optional<String>`型を持つoptional変数で例えていく  

### Optionalを作成する
Optional.of("Hello");

### 空のOptionalを作成する
Optional.empty();

### null要素を入ったOptionalを作成する
optional = Optional.ofNullable(null); // Optional.empty

### 値を取得
optional.get();

### 値が存在するかどうか【boolean】
optional.isPresent()  
※ nullが入っている場合、falseとなる。

### 値が存在する場合に指定した操作を行う
optional.ifPresent(System.out::println)

### 値が存在しない場合、指定したデフォルト値を返す
optional.orElse("Default")

### デフォルト値を生成するロジックを指定できる
optional.orElseGet(() -> "Generated")

### 値が存在しない場合に例外をスロー
optional.orElseThrow(() -> new RuntimeException())

### 値が存在する場合、変換処理を適用し、新しいOptionalを返す
optionalValue.map(String::toUpperCase)

### 条件に一致する場合のみ値を保持
optionalValue.filter(s -> s.startsWith("H"))



Optional の取り扱い
ストリーム操作で結果が空になる可能性がある場合、Optional が返される。
Optional.orElse() でデフォルト値を提供。
誤記がある可能性:
Optional をそのまま使用せず、orElse を付け忘れている場合。
Optional.empty

