概要
  * [・数字処理](#数字処理)
    * [Integerの最小値/最大値を呼び出す](#integerの最小値/最大値を呼び出す)
    * [NaN（Infinity）](#naninfinity)
     * [NaNになる条件](#nanになる条件)
     * [NaNであるかどうかをチェック](#nanであるかどうかをチェック)
    * [無限大（Infinity）](#無限大infinity)
     * [無限大になる条件])(#無限大になる条件)
     * [無限大であるかどうかをチェック](#無限大であるかどうかをチェック)
    * [二つの数字での比較](#二つの数字での比較)
  * [・ビット](#ビット)
    * [1. ビット基本操作](#1-ビット基本操作)
      * [最上位の1ビットを取得する](#最上位の1ビットを取得する)
      * [最下位の1ビットを取得する](#最下位の1ビットを取得する)
      * [整数のビット表現における1のビットの数](#整数のビット表現における1のビットの数)
      * [ビット順を反転](#ビット順を反転)
      * [バイト順を反転](#バイト順を反転)
      * [10進数から2進数への変換【String】](#10進数から2進数への変換string)
    * [2. よく使うビット運用](#2-よく使うビット運用)
      * [nは奇数か偶数かを判定【boolean】](#nは奇数か偶数かを判定boolean)
      * [nのi番目のビットが立っているか判定](#nのi番目のビットが立っているか判定)
      * [nのi番目のビットを1に設定する](#nのi番目のビットを1に設定する)
      * [nのi番目のビットを0に設定する](#nのi番目のビットを0に設定する)
      * [nのi番目のビットを反転させる](#nのi番目のビットを反転させる)
  * [・Mathクラス](#Mathクラス)
    * [1. 数値の定数と基本計算](#1-数値の定数と基本計算)
      * [円周率π](#円周率π)
      * [ネイピア数e](#ネイピア数e)
      * [絶対値](#絶対値)
      * [最小値](#最小値)
      * [最大値](#最大値)
      * [aのb乗【double】](#aのb乗【double】)
      * [平方根【double】](#平方根【double】)
      * [立方根【double】](#立方根【double】)
      * [2次元座標の原点からの距離【double】](#2次元座標の原点からの距離double)
      * [小数点切り上げ【double】](#小数点切り上げ【double】)
      * [小数点切り捨て【double】](#小数点切り捨て【double】)
      * [四捨五入【long】](#四捨五入【long】)
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
    * [4. 指数・対数](#4-指数・対数)
      * [eのn乗を返す【double】](#eのn乗を返すdouble)
      * [e^n - 1 の値を返す【double】](#en---1-の値を返すdouble)
      * [自然対数を返す（ln n）【double】](#自然対数を返すlnndouble)
      * [常用対数（底が10の対数）を返す【double】](#常用対数底が10の対数を返すdouble)
      * [1 + n の自然対数【double】](#1+nの自然対数double)
    * [5. 値の処理](#5-値の処理)
      * [数値の符号を返す【double】](#数値の符号を返すdouble)
      * [magnitude の値に sign の符号を適用した値を返す【double】](#magnitudeの値にsignの符号を適用した値を返すdouble)
      * [n より大きい最小の浮動小数点数を返す【double】](#nより大きい最小の浮動小数点数を返すdouble)
      * [n より小さい最小の浮動小数点数を返す【double】](#nより小さい最小の浮動小数点数を返すdouble)
      * [start に最も近い方向の浮動小数点数を返す【double】](#startに最も近い方向の浮動小数点数を返すdouble)
      * [n の1単位の浮動小数点値を返す【double】](#nの1単位の浮動小数点値を返すdouble)
      * [d × 2^scaleFactor を計算する【double】](#d--2scalefactor-を計算するdouble)

***************************************************************************
なお、便宜を図って、各型のデフォ値を下記通りとする。  
`int` n = 10;  
`int` a = 2;  
`int` b = 5;  
または、  
`double` n = 10.5;

***************************************************************************
## ・数字処理
int/ Integerなど、数字型関連のよく使うコードまとめ。

### Integerの最小値/最大値を呼び出す
Integer.MIN_VALUE  
Integer.MAX_VALUE

### NaN（Infinity）
double型/ float型しか扱えない。  
なお、NaNは他のNaNとは等しくない。  

#### NaNになる条件
* 0を0で割る
* 無限大から無限大を引く
* 平方根を負の数に対して計算する（Math.sqrt(-1)）
* ゼロと無限大の掛け算など、数学的に定義できない結果が出た際
* 文字列を数値に変換しようとした際

#### NaNであるかどうかをチェック
Double.isNaN(n);  
Float.isNaN(n);

### 無限大（Infinity）
double型/ float型しか扱えない。  

#### 無限大になる条件
* 0で割る
* 非常に大きな値を超える計算
* 無限大間での計算
* Double.POSITIVE_INFINITY/ Float.POSITIVE_INFINITY（正の無限）
* Double.NEGATIVE_INFINITY/ Float.NEGATIVE_INFINITY（負の無限）

#### 無限大であるかどうかをチェック
Double.isInfinite(n);  
Float.isInfinite(n);

### 二つの数字での比較
Integer.compare(a, b);  
Long.compare(a, b);  
Short.compare(a, b);  
Double.compare(a, b);  
Float.compare(a, b);  
※ a > b ⇒ 1  
　 a = b ⇒ 0  
　 a < b ⇒ -1  

***************************************************************************
## ・ビット
基本IntegerまたはLongで扱う。  
* ビット演算子（[おさらい](./【Tips】0Java基礎.md#ビット演算子)）

| 演算子 | 使用例  | 説明 | 式の値 |
| ----- | ------- | ----- | ---- |
| &     | a & b   | a と b の論理積（AND） | 整数 |
| \|    | a \| b  | a と b の論理和（OR） | 整数 |
| ^     | a ^ b   | a と b の排他的論理和（XOR） | 整数 |
| \~    | \~a     | a のビット反転（NOT） | 整数 |
| <<    | a << n  | a を左へ n ビットシフト | 整数 |
| >>    | a >> n  | a を右へ n ビットシフト（算術シフト） | 整数 |
| >>>   | a >>> n | a を右へ n ビットシフト（論理シフト） | 整数 |

### 1. ビット基本操作
#### 最上位の1ビットを取得する
Integer.highestOneBit(n);  
※ 例：n = 10 ⇒ 1010 ⇒ 最上位の1ビット 1000 ⇒ 8

#### 最下位の1ビットを取得する
Integer.lowestOneBit(n);  
※ 例：n = 10 ⇒ 1010 ⇒ 最下位の1ビット 0010 ⇒ 2

#### 整数のビット表現における1のビットの数
Integer.bitCount(n);  
※ 例：n = 7 ⇒ 0111 ⇒ 3

#### ビット順を反転
Integer.reverse(n);  
※ 32ビット整数で行う  
※ 10の場合 ⇒ 00000000 00000000 00000000 00001010  
　　 反転後 ⇒ 01010000 00000000 00000000 00000000

#### バイト順を反転
Integer.reverseBytes(n);  
※ 32ビット整数を4つの8ビットの「バイト」に分けて反転を行う  
※ 10の場合 ⇒ 00000000 00000000 00000000 00001010  
　　 反転後 ⇒ 00001010 00000000 00000000 00000000

#### 10進数から2進数への変換【String】
Integer.toBinaryString(n);

### 2. よく使うビット運用
#### nは奇数か偶数かを判定【boolean】
(n & 1) == 1;  
※ この場合、true（左項目が1）は奇数、false（左項目が0）は偶数

#### nのi番目のビットが立っているか判定
(n & (1 << i)) != 0;  
※ (1 << i)は、00.....001（1）の唯一の1を左にシフトする回数を指定する  
※ &：論理積（AND）  
※ i = 0 ⇒ 一番右のビット  
※ よくforと合わせてパターン判断に扱う

#### nのi番目のビットを1に設定する
n | (1 << i);  
※ \|：論理和（OR）  
※ i = 0 ⇒ 一番右のビット

#### nのi番目のビットを0に設定する
n & \~(1 << i);  
※ \~：反転（NOT）  
※ i = 0 ⇒ 一番右のビット

#### nのi番目のビットを反転させる
n ^ (1 << i);  
※ ^：排他的論理和（XOR）  
※ i = 0 ⇒ 一番右のビット

***************************************************************************
## ・Mathクラス
Mathクラス：`java.lang` パッケージ(インポートいらない)  
Mathクラスの数学演算や数値処理に便利な静的メソッド、全員あつまれぇ～！  
※ 【double】の内容は(int)などを掛けておくのおすすめ

### 1. 数値の定数と基本計算
#### 円周率π
Math.PI  
※ 円周率 π（約3.14159…）

#### ネイピア数e
Math.E  
※ ネイピア数 e（約2.71828…）

#### 絶対値
Math`.abs(n)`;

#### 最小値
Math`.min(`a`, `b`)`;  
※ 引数は二つ、それ以外はエラーする

#### 最大値
Math`.max(`a`, `b`)`;  
※ 引数は二つ、それ以外はエラーする

#### aのb乗【double】
Math`.pow(`a`, `b`)`; 

#### 平方根【double】
Math.sqrt(n);

#### 立方根【double】
Math.cbrt(n);

#### 2次元座標の原点からの距離【double】
Math.hypot(a, b);  
※ Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2))　と同義

#### 小数点切り上げ【double】
Math.ceil(n)

#### 小数点切り捨て【double】
Math.floor(n)

#### 四捨五入【long】
Math.round(n);

#### 最も近い整数値を返す（偶数への丸めを行う）【double】
Math.rint(n);
```Java
// 偶数への丸め
// 0.5への判断は四捨五入ではない。その他は同じ
System.out.println(Math.rint(2.5));  // 出力: 2.0　⇒　四捨五入ではなく偶数への丸め
System.out.println(Math.rint(3.5));  // 出力: 4.0
System.out.println(Math.rint(4.5));  // 出力: 4.0　⇒　四捨五入ではなく偶数への丸め
System.out.println(Math.rint(5.5));  // 出力: 6.0
```

#### ランダム【double】
Math`.random()`  
※ 0 <= random < 1、0.999999999999の範囲を返す  
※ (int)などを掛けておくのおすすめ  
※ 小数点以下の内容をランダムで出力するので、(int) (*欲しい範囲 + 1)にすると欲しい範囲を制限できる  
※ Integer n = (int) (Math.random() * 100 + 1);
``` Java
// 50~99という範囲を取りたい場合
Math.random() * (99 - 50 + 1) + 50;
```
### 2. 三角関数
下記内容の大半はラジアン（radians、弳）で指定する必要がある。  
便宜を図って、各型のデフォ値を下記通りとする。  
`double` x = 90; // x は 角度  
`double` rad = Math.toRadians(x); // rad は ラジアン

1ラジアンは、およそ`57.3度`に相当する  
180度は、ラジアンでは π  
360度は、ラジアンでは 2π  
※ 範囲外の場合、`NaN`（Not a Number）と返される

#### 角度をラジアンに変換【double】
Math.toRadians(x);  
結果： ラジアン値

#### ラジアンを角度に変換【double】
Math.toDegrees(rad);

#### sinを返す【double】
Math.sin(rad);  
結果： ラジアン値

#### cosを返す【double】
Math.cos(rad);  
結果： ラジアン値

#### tanを返す【double】
Math.tan(rad);  
結果： ラジアン値

#### asin（arcsin/ アークサイン/ 逆サイン）【double】
Math.asin(rad);  
結果：-π/2 ～ π/2（-90度 ～ 90度）のラジアン値  
NaN範囲：-1 より小さい、または 1 より大きい値

#### acos（arccos/ アークコサイン/ 逆コサイン）【double】
Math.acos(rad);  
結果： 0 ～ π（0度 ～ 180度）のラジアン値  
NaN範囲：-1 より小さい、または 1 より大きい値

#### atan（arctan/ アークサイン/ 逆サイン）
Math.atan(rad);  
結果：-π/2 ～ π/2（-90度 ～ 90度）の範囲のラジアン値

#### 原点から(x, y)の角度を計算する【double】
Math.atan2(y, x)  
結果： ラジアン値（使用するのは座標位置、ラジアン値ではない）  
実際の使用例：  
Math.toDegrees(Math.atan2(y, x));

``` Java
double x = 15; // 角度
double rad = Math.toRadians(x); // 角度をラジアンに変換

// 三角関数
var a = Math.sin(rad);  // sin(ラジアン)
var b = Math.cos(rad);  // cos(ラジアン)
var c = Math.tan(rad);  // tan(ラジアン)

// 逆三角関数（入力値として-1～1の範囲が必要）
var d = Math.asin(Math.sin(rad));  // asin()にsin(rad)を渡す(ラジアン)
var e = Math.acos(Math.cos(rad));  // acos()にcos(rad)を渡す(ラジアン)
var f = Math.atan(Math.tan(rad));  // atan()にtan(rad)を渡す(ラジアン)

System.out.println("sin: " + a);
System.out.println("cos: " + b);
System.out.println("tan: " + c);
System.out.println("asin(sin(rad)): " + Math.toDegrees(d));  // 結果を度に変換
System.out.println("acos(cos(rad)): " + Math.toDegrees(e));  // 結果を度に変換
System.out.println("atan(tan(rad)): " + Math.toDegrees(f));  // 結果を度に変換
```

### 3. 双曲線関数
指数関数に基づいた計算を行うもの  
ラジアンではなく、通常の実数値を入力/出力する

#### 双曲線sin
Math.sinh(n)

#### 双曲線cos
Math.cosh(n)

#### 双曲線tan
Math.tanh(n)

#### 逆双曲線sin
Math.asinh(n)

#### 逆双曲線cos
Math.acosh(n)

#### 逆双曲線tan
Math.atanh(n)

```Java
double x = 1.0;
double sinhResult = Math.sinh(x); // 双曲線サイン
double coshResult = Math.cosh(x); // 双曲線コサイン
double tanhResult = Math.tanh(x); // 双曲線タンジェント

// 逆双曲線関数
double asinhResult = Math.asinh(x); // 逆双曲線サイン
double acoshResult = Math.acosh(x); // 逆双曲線コサイン
double atanhResult = Math.atanh(x); // 逆双曲線タンジェント

System.out.println("sinh(1): " + sinhResult);
System.out.println("cosh(1): " + coshResult);
System.out.println("tanh(1): " + tanhResult);
System.out.println("asinh(1): " + asinhResult);
System.out.println("acosh(1): " + acoshResult);
System.out.println("atanh(1): " + atanhResult);
```

### 4. 指数・対数
e は数学的な定数で、自然対数の底（ナチュラル・ベース）として知られている  
これは、無理数であり、およそ 2.71828 の値を持つ  
e は指数関数や対数関数、微積分などで頻繁に登場する重要な定数  

#### eのn乗を返す【double】
Math.exp(n);

#### e^n - 1 の値を返す【double】
Math.expm1(n);  
※ nが非常に小さいときの誤差を減らす

#### 自然対数を返す（ln n）【double】
Math.log(n);

#### 常用対数（底が10の対数）を返す【double】
Math.log10(n);

#### 1 + n の自然対数【double】
Math.log1p(n);
※ nが非常に小さいときの誤差を減らす

### 5. 値の処理
#### 数値の符号を返す【double】
Math.signum(n);
※ 正の数は1.0、負の数は-1.0、0は0.0

#### magnitude の値に sign の符号を適用した値を返す【double】
Math.copySign(magnitude, sign);  
※ Math.copySign(magnitude, sign)の動作は、  
　　sign の符号を magnitude に適用するというものだが、  
　　これが数値の符号を反転させる用途にも使える

#### n より大きい最小の浮動小数点数を返す【double】
Math.nextUp(n);

#### n より小さい最小の浮動小数点数を返す【double】
Math.nextDown(n);

#### start に最も近い方向の浮動小数点数を返す【double】
Math.nextAfter(start, direction);

#### n の1単位の浮動小数点値を返す【double】
Math.ulp(n);

#### d × 2^scaleFactor を計算する【double】
Math.scalb(d, scaleFactor): 
