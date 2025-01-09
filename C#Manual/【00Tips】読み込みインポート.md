概要
* [Console.ReadLine()について](#consolereadlineについて)
  * [Console.ReadLine()の基本形](#consolereadlineの基本形)
  * [読み込み（基本データ型）](#読み込み基本データ型)
  * [読み込み（配列）](#読み込み配列)
  * [読み込み（リスト）](#読み込みリスト)
 
***************************************************************************
## Console.ReadLine()について
* `using System;`
* C#では、データ入力の読み込みを行う際に `Console.ReadLine()` を使用する
* もう読み込めるものがない場合、`null` を返すけどエラーにはならない
* 以下は、Console.ReadLine()の基本的な使い方や、様々な型への変換方法

### Console.ReadLine()の基本形
C#では、ユーザー入力をConsole.ReadLine()で文字列として取得する  
取得した文字列は、必要に応じて型変換を行う
```C#
using System;

class Program
{
    static void Main(string[] args)
    {
        // 文字列の入力
        string input = Console.ReadLine();
        Console.WriteLine("入力された文字列: " + input);
    }
}
```

### 読み込み（基本データ型）
Console.Read(); ⇒ 一文字だけ読み込み、その文字の ASCII値 を整数（int 型）で返す  

string str = Console.ReadLine(); ⇒ string   
char c = Console.ReadLine()\[0\];  
int n = int.Parse(Console.ReadLine());  
long l = long.Parse(Console.ReadLine());  
short s = short.Parse(Console.ReadLine());  
double d = double.Parse(Console.ReadLine());  
float f = float.Parse(Console.ReadLine());  
bool b = bool.Parse(Console.ReadLine());  

### 読み込み（配列）
`using System.Linq;` を使用する
```C#
using System;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        string[] arrayString = Console.ReadLine().Split(' ');
        int[] arrayInt = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
        long[] arrayLong = Console.ReadLine().Split(' ').Select(long.Parse).ToArray();
        double[] arrayDouble = Console.ReadLine().Split(' ').Select(double.Parse).ToArray();
    }
}
```

### 読み込み（リスト）
`using System.Linq;` を使用する
```C#
using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        List<string> listString = Console.ReadLine().Split(' ').ToList();
        List<int> listInt = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
    }
}
```
