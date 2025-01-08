概要
* [Stack（スタック）の特徴](#stackスタックの特徴)
* [主なコード一覧](#主なコード一覧)
  * [スタックの最後に要素を追加する](#スタックの最後に要素を追加する)
  * [スタックの先頭から要素を取り出し、削除する](#スタックの最後から要素を取り出し削除する)
  * [スタックの先頭の要素を確認する（削除しない）](#スタックの最後の要素を確認する削除しない)
  * [スタック内の要素数を取得する](#スタック内の要素数を取得する)
  * [スタック内のすべての要素を削除する](#スタック内のすべての要素を削除する)
  * [スタックに特定の要素が存在するか確認する【boolean】](#スタックに特定の要素が存在するか確認するboolean)
  * [スタックを配列に変換する](#スタックを配列に変換する)

***************************************************************************
## Stack（スタック）の特徴
* データの構造: LIFO (Last In, First Out)
  * 最後に入れた要素が最初に取り出される
  * → 「**後入れ先出し**」のデータ構造
* コレクション
  * `System.Collections`（非ジェネリック版）と
  * `System.Collections.Generic`（ジェネリック版）の`Queue<T>``が存在する
  * 通常は型安全でパフォーマンスが良い**ジェネリック版**を使用すことを推奨する
* 主な操作
  * Push: データを追加する
  * Pop: データを取り出す（削除と取得）
  * Peek: 取り出さずに最後のデータを見る
* 使いどころ
  * 再帰処理の管理
  * 操作の履歴やバックトラッキング
* マルチスレッド環境
  * スレッドセーフではない
  * スレッドセーフが必要な場合、`ConcurrentStack<T>`を使用する

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
        Stack stack = new Stack();
        stack.Push(1);
        stack.Push(2);
        stack.Push(3);
        Console.WriteLine(stack.Pop()); // 3
        Console.WriteLine(stack.Peek()); // 2
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
        Stack<int> stack = new Stack<int>();
        stack.Push(1);
        stack.Push(2);
        stack.Push(3);
        Console.WriteLine(stack.Pop()); // 3
        Console.WriteLine(stack.Peek()); // 2

        // List/ array などを引数として渡して初期化することが可能
        Stack<int> stack = new Stack<int>(li);

        // 配列を引数として渡して初期化
        Stack<int> stack = new Stack<int>(new[] { 1, 2, 3 });
    }
}

```

***************************************************************************
## 主なコード一覧
### スタックの最後に要素を追加する
stack.Push(x);

### スタックの最後から要素を取り出し、削除する
stack.Pop();  
※ 空の状態で呼び出すと`InvalidOperationException`が発生する

### スタックの先頭の要素を確認する（削除しない）
stack.Peek();

### スタック内の要素数を取得する
stack.Count;

### スタック内のすべての要素を削除する
stack.Clear();

### スタックに特定の要素が存在するか確認する【boolean】
stack.Contains(x);

### スタックを配列に変換する
int[] arr = stack.ToArray();
