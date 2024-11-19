概要
* [PriorityQueueの特徴](#priorityqueueの特徴)
* [主なコード一覧](#主なコード一覧)
  * [要素を追加](#要素を追加)
  * [要素を追加、エラー出る場合falseを返す](#要素を追加エラー出る場合falseを返す)
  * [先頭要素を取得](#先頭要素を取得)
  * [先頭要素を削除、エラー出る場合nullを返す](#先頭要素を削除エラー出る場合nullを返す)
  * [先頭要素を削除、エラー出る場合falseを返す](#先頭要素を削除エラー出る場合falseを返す)
  * [空であるかどうか【boolean】](#空であるかどうかboolean)
  * [キュー内の要素数を返す](#キュー内の要素数を返す)
  * [キュー内の全要素を削除](#キュー内の全要素を削除)
  * [指定した要素が存在するかどうか【boolean】](#指定した要素が存在するかどうかboolean)
  * [キュー内の要素を配列として返す](#キュー内の要素を配列として返す)

なお、便宜を図って、各型のデフォ値を下記通りとする。  
`PriorityQueue<String>` queue = new PriorityQueue<>();　または  
`PriorityQueue<Integer>` queue = new PriorityQueue<>();

***************************************************************************
## PriorityQueueの特徴
* **java.util.PriorityQueue;**
* **優先順位付きキュー**（ヒープベースのデータ構造）（例: スケジューリングアルゴリズム）
* **最小値・最大値の頻繁な取得と削除**
* **効率性**(要素の追加・削除は O(log n)、先頭要素の参照は O(1))
* **グラフアルゴリズム（例: ダイクストラ法）**
* **インターフェイス**
  * Queue
  * Collection
  * Iterable
* **スレッドセーフではない**
* **重複要素を許容**
* **null要素を許容しない**
* **宣言と初期化**
```Java
// 空の PriorityQueue を生成（デフォルトの初期容量）
PriorityQueue<Integer> pq = new PriorityQueue<>();

// カスタムコンパレータを指定(逆順)
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

// 初期容量を指定して生成（要素数が多い場合に便利）
PriorityQueue<String> pqWithCapacity = new PriorityQueue<>(50);

// 初期要素付きで生成する（Arrays.asListを使う）import java.util.Arrays;も必要となる
PriorityQueue<String> pqWithElements = new PriorityQueue<>(Arrays.asList("Apple", "Banana", "Cherry"));
```

***************************************************************************
## 主なコード一覧
### 要素を追加
queue.add(x);  
※ キューが満杯の場合例外

### 要素を追加、エラー出る場合falseを返す
queue.offer(x);

### 先頭要素を取得
queue.peek(x);

### 先頭要素を削除、エラー出る場合nullを返す
queue.poll(x);

### 先頭要素を削除、エラー出る場合falseを返す
queue.remove();

### 空であるかどうか【boolean】
queue.isEmpty();

### キュー内の要素数を返す
queue.size();

### キュー内の全要素を削除
queue.clear();

### 指定した要素が存在するかどうか【boolean】
queue.contains(x);

### キュー内の要素を配列として返す
queue.toArray();
