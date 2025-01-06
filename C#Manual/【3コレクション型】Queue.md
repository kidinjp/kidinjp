概要
* [Queue（キュー）の特徴](#queueキューの特徴)
* [主なコード一覧](#主なコード一覧)
  * [キューの最後に要素を追加する](#キューの最後に要素を追加する)
  * [キューの先頭から要素を取り出し、削除する](#キューの先頭から要素を取り出し削除する)
  * [キューの先頭の要素を確認する（削除しない）](#キューの先頭の要素を確認する削除しない)
  * [キュー内の要素数を取得する](#キュー内の要素数を取得する)
  * [キュー内のすべての要素を削除する](#キュー内のすべての要素を削除する)
  * [キューに特定の要素が存在するか確認する【boolean】](#キューに特定の要素が存在するか確認するboolean)
  * [キューを配列に変換する](#キューを配列に変換する)

***************************************************************************
## Queue（キュー）の特徴
* データの構造: FIFO (First In, First Out)
  * 最初に入れた要素が最初に取り出される
  * → 「**先入れ先出し**」のデータ構造
* コレクション
  * `System.Collections`（非ジェネリック版）と
  * `System.Collections.Generic`（ジェネリック版）の`Queue<T>``が存在する
  * 通常は型安全でパフォーマンスが良い**ジェネリック版**を使用すことを推奨する
* 主な操作
  * Enqueue: データを追加する
  * Dequeue: データを取り出す（削除と取得）
  * Peek: 取り出さずに先頭のデータを見る
* 使いどころ
  * タスクやジョブの処理
  * プリンタの印刷待ちキュー
  * メッセージキューやリアルタイム処理
* マルチスレッド環境
  * スレッドセーフではない
  * スレッドセーフが必要な場合、`ConcurrentQueue<T>`を使用する

| 特徴 | Queue | Stack |
| --- | --- | --- |
| 構造 | FIFO(先入れ先出し) | LIFO(後入れ先出し) |
| 追加 | Enqueue | Push |
| 取り出し | Dequeue | Pop |
| 先頭の確認 | Peek | Peek |
| 使いどころ | タスク管理、順番待ち処理 | 再帰処理、履歴管理 |

非ジェネリック：
```C#
using System;
using System.Collections;

class Program
{
    static void Main()
    {
        Queue queue = new Queue();
        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        Console.WriteLine(queue.Dequeue()); // 1
        Console.WriteLine(queue.Peek()); // 2
    }
}
```

ジェネリック：
```C#
using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        Queue<int> queue = new Queue<int>();
        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        Console.WriteLine(queue.Dequeue()); // 1
        Console.WriteLine(queue.Peek()); // 2
        // List/ array などを引数として渡して初期化することが可能
        Queue<int> queue = new Queue<int>(li);
        // コレクション初期化子を使用
        Queue<int> queue = new Queue<int>(new[] { 1, 2, 3 });
    }
}
```

***************************************************************************
## 主なコード一覧
### キューの最後に要素を追加する
queue.Enqueue(x);

### キューの先頭から要素を取り出し、削除する
queue.Dequeue();  
※ 空の状態で呼び出すと`InvalidOperationException`が発生する

### キューの先頭の要素を確認する（削除しない）
queue.Peek();

### キュー内の要素数を取得する
queue.Count;

### キュー内のすべての要素を削除する
queue.Clear();

### キューに特定の要素が存在するか確認する【boolean】
queue.Contains(x);

### キューを配列に変換する
int[] arr = queue.ToArray();
