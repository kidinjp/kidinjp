概要
 * [数字処理](#数字処理)
   * [intの最小値/最大値を呼び出す](#intの最小値最大値を呼び出す)
   * [NaN（Infinity）](#naninfinity)
     * [NaNになる条件](#nanになる条件)
     * [NaNであるかどうかをチェック【boolean】](#nanであるかどうかをチェックboolean)
   * [無限大（Infinity）](#無限大infinity)
     * [無限大になる条件](#無限大になる条件)
     * [無限大であるかどうかをチェック【boolean】](#無限大であるかどうかをチェックboolean)
   * [二つの数字での比較](#二つの数字での比較)
 * [ビット](#ビット)
   * [1. ビット基本操作](#1-ビット基本操作)
     * [最上位の1ビットを取得する](#最上位の1ビットを取得する)
     * [最下位の1ビットを取得する](#最下位の1ビットを取得する)
     * [整数のビット表現における1のビットの数](#整数のビット表現における1のビットの数)
     * [ビット順を反転](#ビット順を反転)
     * [バイト順を反転](#バイト順を反転)
     * [10進数から2進数への変換【string】](#10進数から2進数への変換string)
     * [2進数から10進数への変換【int】](#2進数から10進数への変換int)
     * [10進数から16進数への変換【string】](#10進数から16進数への変換string)
     * [16進数から10進数への変換【int】](#16進数から10進数への変換int)
   * [2. よく使うビット運用](#2-よく使うビット運用)
     * [nは奇数か偶数かを判定【boolean】](#nは奇数か偶数かを判定boolean)
     * [nのi番目のビットが立っているか判定【論理積】](#nのi番目のビットが立っているか判定論理積)
     * [nのi番目のビットを1に設定する【論理和】](#nのi番目のビットを1に設定する論理和)
     * [nのi番目のビットを0に設定する【反転/否定】](#nのi番目のビットを0に設定する反転否定)
     * [nのi番目のビットを反転させる【排他的論理和】](#nのi番目のビットを反転させる排他的論理和)
     * [ビット列（配列）を整数値に変換する](#ビット列配列を整数値に変換する)
 * [Mathクラス](#mathクラス)
   * [1. 数値の定数と基本計算](#1-数値の定数と基本計算)
     * [円周率π](#円周率π)
     * [ネイピア数e](#ネイピア数e)
     * [絶対値](#絶対値)
     * [最小値](#最小値)
     * [最大値](#最大値)
     * [aのb乗【double】](#aのb乗double)
     * [平方根【double】](#平方根double)
     * [立方根【double】](#立方根double)
     * [2次元座標の原点からの距離【double】](#2次元座標の原点からの距離double)
     * [小数点切り上げ【double】](#小数点切り上げdouble)
     * [小数点切り捨て【double】](#小数点切り捨てdouble)
     * [四捨五入【long】](#四捨五入long)
     * [小数点以下の桁数を指定する](#小数点以下の桁数を指定する)
     * [桁区切りを含んだ数値の表示](#桁区切りを含んだ数値の表示)
     * [指数表記](#指数表記)
     * [整数を指定した桁数で表示](#整数を指定した桁数で表示)
     * [最も近い整数値を返す（偶数への丸めを行う）【double】](#最も近い整数値を返す偶数への丸めを行うdouble)
     * [ランダム【double】](#ランダムdouble)
   * [2. 三角関数](#2-三角関数)
     * [角度をラジアンに変換【double】](#角度をラジアンに変換double)
     * [ラジアンを角度に変換【double】](#ラジアンを角度に変換double)
     * [sinを返す【double】](#sinを返すdouble)
     * [cosを返す【double】](#cosを返すdouble)
     * [tanを返す【double】](#tanを返すdouble)
     * [asin（arcsin/ アークサイン/ 逆サイン）【double】](#asinarcsin-アークサイン-逆サインdouble)
     * [acos（arccos/ アークコサイン/ 逆コサイン）【double】](#acosarccos-アークコサイン-逆コサインdouble)
     * [atan（arctan/ アークサイン/ 逆サイン）](#atanarctan-アークサイン-逆サイン)
     * [原点から(x, y)の角度を計算する【double】](#原点からx-yの角度を計算するdouble)
   * [3. 双曲線関数](#3-双曲線関数)
     * [双曲線sin](#双曲線sin)
     * [双曲線cos](#双曲線cos)
     * [双曲線tan](#双曲線tan)
     * [逆双曲線sin](#逆双曲線sin)
     * [逆双曲線cos](#逆双曲線cos)
     * [逆双曲線tan](#逆双曲線tan)
   * [4. 指数・対数](#4-指数対数)
     * [eのn乗を返す【double】](#eのn乗を返すdouble)
     * [e^n - 1 の値を返す【double】](#en---1-の値を返すdouble)
     * [自然対数を返す（ln n）【double】](#自然対数を返すln-ndouble)
     * [常用対数（底が10の対数）を返す【double】](#常用対数底が10の対数を返すdouble)
     * [1 + n の自然対数【double】](#1--n-の自然対数double)
   * [5. 値の処理](#5-値の処理)
     * [数値の符号を返す【double】](#数値の符号を返すdouble)
     * [magnitude の値に sign の符号を適用した値を返す【double】](#magnitude-の値に-sign-の符号を適用した値を返すdouble)
     * [n より大きい最小の浮動小数点数を返す【double】](#n-より大きい最小の浮動小数点数を返すdouble)
     * [n より小さい最小の浮動小数点数を返す【double】](#n-より小さい最小の浮動小数点数を返すdouble)
     * [start に最も近い方向の浮動小数点数を返す【double】](#start-に最も近い方向の浮動小数点数を返すdouble)
     * [n の1単位の浮動小数点値を返す【double】](#n-の1単位の浮動小数点値を返すdouble)
     * [d × 2^scaleFactor を計算する【double】](#d--2scalefactor-を計算するdouble)

なお、便宜を図って、各型のデフォ値を下記通りとする  
`int` n = 10;  
`int` a = 2;  
`int` b = 5;  
または、  
`double` n = 10.5;

***************************************************************************
## 数字処理
intなど、数字型関連のよく使うコードまとめ。

### intの最小値/最大値を呼び出す
int.MinValue  
int.MaxValue

### NaN（Infinity）
double型/ float型しか扱えない。  
なお、NaNは他のNaNとは等しくない。  

#### NaNになる条件
* 0を0で割る
* 無限大から無限大を引く
* 平方根を負の数に対して計算する（Math.sqrt(-1)）
* ゼロと無限大の掛け算など、数学的に定義できない結果が出た際
* 文字列を数値に変換しようとした際

#### NaNであるかどうかをチェック【boolean】
double.IsNaN(n);  
float.IsNaN(n);

### 無限大（Infinity）
double型/ float型しか扱えない。  

#### 無限大になる条件
* 0で割る
* 非常に大きな値を超える計算
* 無限大間での計算
* Double.PositiveInfinity / Single.PositiveInfinity（正の無限）
* Double.NegativeInfinity / Single.NegativeInfinity（負の無限）

#### 無限大であるかどうかをチェック【boolean】
double.IsInfinite(n);  
float.IsInfinite(n);

### 二つの数字での比較
下記書き方は`int`/ `long`/ `float`/ `double`に通用するが、`short`の場合差自体を返す
```C#
// Comparer<T> クラスの静的プロパティ Default を使う
int result1 = Comparer<int>.Default.Compare(a, b);
// IComparable<T> インターフェースを実装している型のインスタンスメソッド
int result1 = a.CompareTo(b);
```

※ a > b ⇒ 1  
　 a = b ⇒ 0  
　 a < b ⇒ -1  

**************************************************************************
## ビット
基本IntegerまたはLongで扱う。  
* ビット演算子（[おさらい](./【【00Tips】C%23基礎.md#ビット演算子)）

| 演算子 | 使用例  | 説明 | 式の値 |
| ----- | ------- | ----- | ---- |
| &     | a & b   | a と b の論理積（AND） | 整数 |
| \|    | a \| b  | a と b の論理和（OR） | 整数 |
| ^     | a ^ b   | a と b の排他的論理和（XOR） | 整数 |
| \~    | \~a     | a のビット反転（NOT） | 整数 |
| <<    | a << n  | a を左へ n ビットシフト | 整数 |
| >>    | a >> n  | a を右へ n ビットシフト（算術シフト） | 整数 |

### 1. ビット基本操作
#### 最上位の1ビットを取得する
1 << (int)Math.Floor(Math.Log(n, 2));  
※ 例：n = 10 ⇒ 1010 ⇒ 最上位の1ビット 1000 ⇒ 8

#### 最下位の1ビットを取得する
n & -n;  
※ 例：n = 10 ⇒ 1010 ⇒ 最下位の1ビット 0010 ⇒ 2

#### 整数のビット表現における1のビットの数
Convert.ToString(n, 2).Count(c => c == '1');  
※ 例：n = 7 ⇒ 0111 ⇒ 3

#### ビット順を反転
```C#
    int reversed = 0;
    for (int i = 0; i < 32; i++)
    {
        reversed = (reversed << 1) | (n & 1);
        n >>= 1;
    }
```
※ 32ビット整数で行う  
※ 10の場合 ⇒ 00000000 00000000 00000000 00001010  
　　 反転後 ⇒ 01010000 00000000 00000000 00000000

#### バイト順を反転
Integer.reverseBytes(n);  
※ 32ビット整数を4つの8ビットの「バイト」に分けて反転を行う  
※ 10の場合 ⇒ 00000000 00000000 00000000 00001010  
　　 反転後 ⇒ 00001010 00000000 00000000 00000000

#### 10進数から2進数への変換【string】
Convert.ToString(n, 2)

#### 2進数から10進数への変換【int】
Convert.ToInt32(str, 2);

#### 10進数から16進数への変換【string】
Convert.ToString(n, 16);

#### 16進数から10進数への変換【int】
Convert.ToInt32(string1, 16)


### 2. よく使うビット運用
#### nは奇数か偶数かを判定【boolean】
(n & 1) == 1;  
※ この場合、true（左項目が1）は奇数、false（左項目が0）は偶数

#### nのi番目のビットが立っているか判定【論理積】
bool isBitSet = (n & (1 << i)) != 0;  
※ (1 << i)は、00.....001（1）の唯一の1を左にシフトする回数を指定する  
※ &：**論理積**（AND）  
※ i = 0 ⇒ 一番右のビット  
※ よくforと合わせてパターン判断に扱う

#### nのi番目のビットを1に設定する【論理和】
n |= (1 << i);  
※ \|：**論理和**（OR）  
※ i = 0 ⇒ 一番右のビット

#### nのi番目のビットを0に設定する【反転/否定】
n &= \~(1 << i);  
※ \~：**反転**/**否定**（NOT）  
※ i = 0 ⇒ 一番右のビット

#### nのi番目のビットを反転させる【排他的論理和】
n ^= (1 << i);  
※ ^：**排他的論理和**（XOR）  
※ i = 0 ⇒ 一番右のビット

#### ビット列（配列）を整数値に変換する
ループ操作する：`kotae = (kotae << 1) | s[i];`
```C#
int[] s = {1, 0, 1, 1, 1, 1};
int kotae = 0;
for (int i = 0; i < n; i++)
{
    kotae = (kotae << 1) | s[i];
} // 47となる
```

**************************************************************************
## Mathクラス
C# の Math クラスは System 名前空間に属しており、using System; の記述が必要  
Math クラスは静的クラスであり、Math.Method() の形で直接使用する  
※ 【double】の内容は(int)などを掛けておくのおすすめ

### 1. 数値の定数と基本計算
#### 円周率π
Math.PI  
※ 円周率 π（約3.14159265358979…）

#### ネイピア数e
Math.E  
※ ネイピア数 e（約2.71828182845905…）

#### 絶対値
Math`.Abs(n)`;

#### 最小値
Math`.Min(`a`, `b`)`;  
※ 引数は二つ、それ以外はエラーする

#### 最大値
Math`.Max(`a`, `b`)`;  
※ 引数は二つ、それ以外はエラーする

#### aのb乗【double】
Math`.Pow(`a`, `b`)`; 

#### 平方根【double】
Math.Sqrt(n);

#### 立方根【double】
Math.Cbrt(n);

#### 2次元座標の原点からの距離【double】 
Math.Sqrt(Math.Pow(x1, x2) + Math.Pow(y1, y2))  
※ Math.hypot(a, b);　と同義

#### 小数点切り上げ【double】
Math.Ceiling(n)

#### 小数点切り捨て【double】
Math.Floor(n)

#### 四捨五入【long】
Math.Round(n);

### 小数点以下の桁数を指定する
n.ToString("F2");  
※ F (Fixed-point)、$"F{x}"
```C#
double number = 123.456789;
Console.WriteLine(number.ToString("F2"));  // 出力: 123.46
```

### 桁区切りを含んだ数値の表示
n.ToString("N0");  
※ N (Number)
```C#
int value = 1234567;
Console.WriteLine(value.ToString("N0"));  // 出力: 1,234,567
```

### 指数表記
n.ToString("E2");  
※ E (Exponential): 
```C#
double exponent = 12345.6789;
Console.WriteLine(exponent.ToString("E2"));  // 出力: 1.23E+004
```

### 整数を指定した桁数で表示
n.ToString("D5");
※ D (Decimal): 
```C#
int integer = 123;
Console.WriteLine(integer.ToString("D5"));  // 出力: 00123
```

#### 最も近い整数値を返す（偶数への丸めを行う）【double】
Math.Round(n, `MidpointRounding.ToEven`);  
※ Math.Rouneの`MidpointRounding.ToEven`オプションを利用する  
※ Javaでの丸めやり方：
```Java
// 偶数への丸め
// 0.5への判断は四捨五入ではない。その他は同じ
System.out.println(Math.rint(2.5));  // 出力: 2.0　⇒　四捨五入ではなく偶数への丸め
System.out.println(Math.rint(3.5));  // 出力: 4.0
System.out.println(Math.rint(4.5));  // 出力: 4.0　⇒　四捨五入ではなく偶数への丸め
System.out.println(Math.rint(5.5));  // 出力: 6.0
```

#### ランダム【double】
Random random = new Random();  
random.NextDouble(); ※ 0 <= random < 1  
random.Next(50, 100); ※ 50 <= random < 100。\[a, b\)  

Java の Random との比較  
| 特徴 | C#(Random) | Java(java.util.Random) |
| --- | --- | --- |
| スレッドの安全性 | 非スレッドセーフ | 非スレッドセーフ |
| シードのデフォルト | システム時刻を使用 | システム時刻に基づく |
| 乱数範囲の指定 | `Next(min, max)`<br>`[min, max)` | `nextInt(bound)`<br>`[0, bound)` |
| 小数乱数の生成 | `NextDouble()`<br>`[0.0, 1.0)` | `nextDouble()`<br>`[0.0, 1.0)` |
| バイト配列の乱数格納 | `NextBytes(byte[])`が提供される | バイト配列に乱数を格納するメソッドなし |
| 内部実装 | 線形合同法（LCG） | 線形合同法（LCG） |
| 暗号論的乱数生成 | `Random`ではサポートなし | 別途`SecureRandom`クラスを使用 |

### 2. 三角関数
下記内容の大半はラジアン（radians、弳）で指定する必要がある。  
便宜を図って、各型のデフォ値を下記通りとする。  
`double` x = 90; // x は 角度  
`double` rad = Math.PI * angle / 180.0; // 度をラジアンに変換  
※ Java：`double` rad = Math.toRadians(x); // rad は ラジアン  
1ラジアンは、およそ`57.3度`に相当する  
180度は、ラジアンでは π  
360度は、ラジアンでは 2π  
※ 範囲外の場合、`NaN`（Not a Number）と返される

#### 角度をラジアンに変換【double】
Math.PI * angle / 180.0;  
結果： ラジアン値

#### ラジアンを角度に変換【double】
rad * (180.0 / Math.PI);

#### sinを返す【double】
Math.Sin(rad);  
結果： ラジアン値

#### cosを返す【double】
Math.Cos(rad);  
結果： ラジアン値

#### tanを返す【double】
Math.Tan(rad);  
結果： ラジアン値

#### asin（arcsin/ アークサイン/ 逆サイン）【double】
Math.Asin(Math.Sin(rad_);  
結果：-π/2 ～ π/2（-90度 ～ 90度）のラジアン値  
NaN範囲：-1 より小さい、または 1 より大きい値

#### acos（arccos/ アークコサイン/ 逆コサイン）【double】
Math.Acos(Math.Cos(rad));  
結果： 0 ～ π（0度 ～ 180度）のラジアン値  
NaN範囲：-1 より小さい、または 1 より大きい値

#### atan（arctan/ アークサイン/ 逆サイン）
Math.Atan(Math.Tan(rad));  
結果：-π/2 ～ π/2（-90度 ～ 90度）の範囲のラジアン値

#### 原点から(x, y)の角度を計算する【double】
Math.Atan2(y, x) * 180.0 / Math.PI  
結果： ラジアン値（使用するのは座標位置、ラジアン値ではない）  
実際の使用例：  
Math.toDegrees(Math.atan2(y, x));

``` C#
double angle = 90; // 角度
double rad = Math.PI * angle / 180.0; // 度をラジアンに変換

// 三角関数
Console.WriteLine("sin: " + Math.Sin(rad)); // sin
Console.WriteLine("cos: " + Math.Cos(rad)); // cos
Console.WriteLine("tan: " + Math.Tan(rad)); // tan

// 逆三角関数（入力値として-1～1の範囲が必要）
Console.WriteLine("asin: " + Math.Asin(Math.Sin(rad))); // arcsin
Console.WriteLine("acos: " + Math.Acos(Math.Cos(rad))); // arccos
Console.WriteLine("atan: " + Math.Atan(Math.Tan(rad))); // arctan

// 原点から (x, y) の角度を計算
Console.WriteLine("角度: " + Math.Atan2(4, 3) * 180.0 / Math.PI); // 度に変換
```

### 3. 双曲線関数
指数関数に基づいた計算を行うもの  
ラジアンではなく、通常の実数値を入力/出力する

#### 双曲線sin
Math.Sinh(n)

#### 双曲線cos
Math.Cosh(n)

#### 双曲線tan
Math.Tanh(n)

#### 逆双曲線sin
Math.Asinh(n)  
※ .NET Core 2.0 以降または .NET 5 以降

#### 逆双曲線cos
Math.Acosh(n)  
※ .NET Core 2.0 以降または .NET 5 以降

#### 逆双曲線tan
Math.Atanh(n)  
※ .NET Core 2.0 以降または .NET 5 以降

```Java
double x = 1.0;
// 双曲線関数
Console.WriteLine("sinh: " + Math.Sinh(1)); // 双曲線 sin
Console.WriteLine("cosh: " + Math.Cosh(1)); // 双曲線 cos
Console.WriteLine("tanh: " + Math.Tanh(1)); // 双曲線 tan

// 逆双曲線関数
Console.WriteLine("asinh: " + Math.Asinh(1)); // 逆双曲線 sin
Console.WriteLine("acosh: " + Math.Acosh(1)); // 逆双曲線 cos
Console.WriteLine("atanh: " + Math.Atanh(1)); // 逆双曲線 tan
```

### 4. 指数・対数
e は数学的な定数で、自然対数の底（ナチュラル・ベース）として知られている  
これは、無理数であり、およそ 2.71828 の値を持つ  
e は指数関数や対数関数、微積分などで頻繁に登場する重要な定数

#### eのn乗を返す【double】
Math.Exp(n);

#### e^n - 1 の値を返す【double】
Math.Exp(n) - 1;   
※ Javaでは、`Math.expm1(n);`を使用し、nが非常に小さいときの誤差を減らす  

#### 自然対数を返す（ln n）【double】
Math.Log(n);

#### 常用対数（底が10の対数）を返す【double】
Math.Log10(n);

#### 1 + n の自然対数【double】
Math.Log(1 + n);  
※ Javaでは、`Math.log1p(n);`を使用し、nが非常に小さいときの誤差を減らす

### 5. 値の処理
#### 数値の符号を返す【double】
Math.Sign(n);  
※ 正の数は1、負の数は-1、0は0

#### magnitude の値に sign の符号を適用した値を返す【double】
Math.Abs(magnitude) * Math.Sign(sign);  
※ Javaでは、`Math.copySign(magnitude, sign)`を使用し、  
　　sign の符号を magnitude に適用するというものだが、  
　　これが数値の符号を反転させる用途にも使える

#### n より大きい最小の浮動小数点数を返す【double】
BitConverter.Int64BitsToDouble(BitConverter.DoubleToInt64Bits(n) + 1);  
※ Javaでは、`Math.nextUp(n);`を使用する

#### n より小さい最小の浮動小数点数を返す【double】
BitConverter.Int64BitsToDouble(BitConverter.DoubleToInt64Bits(n) - 1);  
※ Javaでは、`Math.nextDown(n);`を使用する

#### start に最も近い方向の浮動小数点数を返す【double】
```C#
static double NextAfter(double start, double direction)
{
    if (start == direction) return start;
    return direction > start 
        ? BitConverter.Int64BitsToDouble(BitConverter.DoubleToInt64Bits(start) + 1) 
        : BitConverter.Int64BitsToDouble(BitConverter.DoubleToInt64Bits(start) - 1);
}
```
※ Javaでは、`Math.nextAfter(start, direction);`を使用する

#### n の1単位の浮動小数点値を返す【double】
BitConverter.Int64BitsToDouble(BitConverter.DoubleToInt64Bits(n) & ~0xFFF);  
※ Javaでは、`Math.ulp(n);`を使用する

#### d × 2^scaleFactor を計算する【double】
d * Math.Pow(2, scaleFactor);  
※ Javaでは、`Math.scalb(d, scaleFactor): `を使用する
