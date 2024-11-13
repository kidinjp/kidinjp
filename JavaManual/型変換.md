概要
* [各型の制限について](#各型の制限について)
* [String](#string)
* [Character/ char](#character-char)
* [Integer/ int](#integer-int)
* [Double/ double](#double-double)
* [Float/ float](#float-float)
* [Long/ long](#long-long)
* [Short/ short](#short-short)
* [Byte/ byte](#byte-byte)
* [Boolean/ boolean](#boolean-boolean)

基本上記の順で変換方法を記述していく
***************************************************************************
## 各型の制限について
| 型 | 型制限 |
| --- | --- |
| String | すべての型から変換可能 |
| Character | 数値型や boolean からは変換不可 |
| char | 数値型（文字コード）から変換可能 |
| Integer | -2^31 ～ 2^31-1 |
| int | -2^31 ～ 2^31-1 |
| Double | ±1.8×10^308 |
| double | ±1.8×10^308 |
| Float | ±3.4×10^38 |
| float | ±3.4×10^38 |
| Long | -2^63 ～ 2^63-1 |
| long | -2^63 ～ 2^63-1 |
| Short | -32,768 ～ 32,767 |
| short | -32,768 ～ 32,767 |
| Byte | -128 ～ 127 |
| byte | -128 ～ 127 |
| Boolean | true または false のみ |
| boolean | true または false のみ |

***************************************************************************
## String
| 変換後 | コード |
| --- | --- |
| String | *(スキップ)* |
| Character | S.charAt(0); |
| char | S.charAt(0); |
| Integer | Integer.parseInt(S); |
| int | Integer.parseInt(S); |
| Double | Double.parseDouble(S); |
| double | Double.parseDouble(S); |
| Float | Float.parseFloat(S); |
| float | Float.parseFloat(S); |
| Long | Long.parseLong(S); |
| long | Long.parseLong(S); |
| Short | Short.parseShort(S); |
| short | Short.parseShort(S); |
| Byte | Byte.parseByte(S); |
| byte | Byte.parseByte(S); |
| Boolean | Boolean.parseBoolean(S); |
| boolean | Boolean.parseBoolean(S); |
***************************************************************************
## Character/ char
| 変換後 | ラッパークラス（Character） | プリミティブ型(char) |
| --- | --- | --- |
| String | String.valueOf(C);<br>Character.toString(C); | String.valueOf(c); |
| Character | *(スキップ)* |Character.valueOf(c); |
| char | C;<br>C.charValue(); |*(スキップ)* |
| Integer | (int) C;<br>Integer.valueOf(C);【ASCII/Unicode 値】<br>Character.getNumericValue(C);<br>Integer.valueOf(C - '0');<br>(int) C - '0'; |(int) c;<br>Integer.valueOf(c);【ASCII/Unicode 値】<br>Character.getNumericValue(c);<br>Integer.valueOf(c - '0');<br>(int) c - '0'; |
| int | (int) C;<br>Integer.valueOf(C);【ASCII/Unicode 値】<br>Character.getNumericValue(C);<br>Integer.valueOf(C - '0');<br>(int) C - '0'; |同上 |
| Double | (double) C;<br>Double.valueOf((double)C) ;【ASCII/Unicode 値】<br>Double.valueOf(Character.getNumericValue(C));<br>(double) Character.getNumericValue(C); |(double) c;<br>Double.valueOf(c) ;【ASCII/Unicode 値】<br>Double.valueOf(Character.getNumericValue(c));<br>(double) Character.getNumericValue(c); |
| double | (double) C;<br>Double.valueOf(C) ;【ASCII/Unicode 値】<br>Double.valueOf(Character.getNumericValue(C));<br>(double) Character.getNumericValue(C); | 同上 |
| Float | (float) C;<br>Float.valueOf(C) ;【ASCII/Unicode 値】<br>Float.valueOf(Character.getNumericValue(C));<br>(float) Character.getNumericValue(C); | (float) c;<br>Float.valueOf(c) ;【ASCII/Unicode 値】<br>Float.valueOf(Character.getNumericValue(c));<br>(float) Character.getNumericValue(c); |
| float | 同上 | 同上 |
| Long | (long) C;<br>Long.valueOf(C) ;【ASCII/Unicode 値】<br>Long.valueOf(Character.getNumericValue(C));<br>(long) Character.getNumericValue(C); | (long) c;<br>Long.valueOf(c) ;【ASCII/Unicode 値】<br>Long.valueOf(Character.getNumericValue(c));<br>(long) Character.getNumericValue(c); |
| long | 同上 | 同上 |
| Short | (short) c.charValue() ;【ASCII/Unicode 値】<br>Short.valueOf((short) Character.getNumericValue(C));<br>(short) Character.getNumericValue(C); | (short) c.charValue() ;【ASCII/Unicode 値】<br>Short.valueOf((short) Character.getNumericValue(c));<br>(short) Character.getNumericValue(c); |
| short | 同上 |同上 |
| Byte | (byte)(int) C;【ASCII/Unicode 値】<br>Byte.valueOf((byte) Character.getNumericValue(C)); | (byte)(int) c;<br>Byte.valueOf((byte) Character.getNumericValue(c)); |
| byte | 同上 |同上 |
| Boolean | *(変換不可能)* | *(変換不可能)* |
| boolean | *(変換不可能)* | *(変換不可能)* |
***************************************************************************
## Integer/ int
| 変換後 | ラッパークラス（Integer） | プリミティブ型(int) |
| --- | --- | --- |
| String | String.valueOf(I); | String.valueOf(i); |
| Character | (char) I.intValue();【ASCII/Unicode 値】<br>(char) (I + '0'); | (char) i;【ASCII/Unicode 値】<br>(char) (i + '0'); |
| char | 同上 | 同上 |
| Integer | *(スキップ)* | i;<br>i.intValue(); |
| int | I;<br>I.intValue(); | *(スキップ)* |
| Double | I.doubleValue();<br>Double.valueOf(I);<br>(double) I; | Double.valueOf(i);<br>(double) i; |
| double | 同上 | 同上 |
| Float | I.floatValue();<br>Float.valueOf(I);<br>(float) I; | Float.valueOf(i);<br>(float) i; |
| float | 同上 | 同上 |
| Long | I.longValue();<br>Long.valueOf(I);<br>(long) I; | Long.valueOf(i);<br>(long) i; |
| long | 同上 | 同上 |
| Short | I.shortValue();<br>Short.valueOf((short) I);<br>(short) I; | Short.valueOf((short) i);<br>(short) i; |
| short | 同上 | 同上 |
| Byte | I.byteValue();<br>(byte) I.intValue();<br>Byte.valueOf((byte) I.intValue()); | (byte) i.intValue();<br>Byte.valueOf((byte) i.intValue()); |
| byte | 同上 | 同上 |
| Boolean | *(変換不可能)* | *(変換不可能)* |
| boolean | *(変換不可能)* | *(変換不可能)* |
***************************************************************************
## Double/ double
※ 変換後の数値は小数点以下切り捨てされる
| 変換後 | ラッパークラス（Double） | プリミティブ型(double) |
| --- | --- | --- |
| String | String.valueOf(D); | String.valueOf(d); |
| Character | *(変換不可能)* | (char) ('0' + (int) x % 10); |
| char | *(変換不可能)* | 同上 |
| Integer | D.intValue();<br>(int) (double) D; | (int) d; |
| int | 同上 | 同上 |
| Double | *(スキップ)* | d; |
| double | D; | *(スキップ)* |
| Float | D.floatValue();<br>(float) (double) D; | Float.valueOf((float)d);<br>(float) d; |
| float | 同上 | 同上 |
| Long | D.longValue();<br>(long) (double) D; | Long.valueOf((long)d);<br>(long) d; |
| long | 同上 | 同上 |
| Short | D.shortValue();<br>(short) (double) D; | Short.valueOf((short)d);<br>(short) d; |
| short | 同上 | 同上 |
| Byte | D.byteValue();<br>(byte) (double) D; | d.byteValue();<br>(byte) (double) d; |
| byte | 同上 | 同上 |
| Boolean | *(変換不可能)* | *(変換不可能)* |
| boolean | *(変換不可能)* | *(変換不可能)* |
***************************************************************************
## Float/ float
※ 変換後の数値は小数点以下切り捨てされる
| 変換後 | ラッパークラス（Floate） | プリミティブ型(float) |
| --- | --- | --- |
| String | String.valueOf(F); | String.valueOf(f); |
| Character | (char) (F + '0'); | (char) (f + '0'); |
| char | 同上 | 同上 |
| Integer | F.intValue();<br>(int) (float) F; | (int) f; |
| int | 同上 | 同上 |
| Double | F.doubleValue();<br>(double) (float) F; | Double.valueOf(f);<br>(double) f; |
| double | 同上 | Double.valueOf(f);<br>(double) f;<br>f; |
| Float | *(スキップ)* | (float) f; |
| float | F; | *(スキップ)* |
| Long | F.longValue();<br>(long) (float) F; | Long.valueOf((long)f);<br>(long) f; |
| long | 同上 | 同上 |
| Short | F.shortValue();<br>(short) (float) F; | Short.valueOf((short)f);<br>(short) f; |
| short | 同上 | 同上 |
| Byte | F.byteValue();<br>(byte) (float) F; | f.byteValue();<br>(byte) (float) f; |
| byte | 同上 | 同上 |
| Boolean | *(変換不可能)* | *(変換不可能)* |
| boolean | *(変換不可能)* | *(変換不可能)* |
***************************************************************************
## Long/ long
| 変換後 | ラッパークラス（Long） | プリミティブ型(long) |
| --- | --- | --- |
| String | String.valueOf(L); | String.valueOf(l); |
| Character | (char) (L + '0'); | (char) (l + '0'); |
| char | 同上 | 同上 |
| Integer | L.intValue();<br>(int) (long) L; | (int) l; |
| int | 同上 | 同上 |
| Double | Double.valueOf(L);<br>(double) L; | Double.valueOf(l);<br>(double) l; |
| double | Double.valueOf(L);<br>L; | 同上 |
| Float | L.floatValue();<br>Float.valueOf(L);<br>L; | Float.valueOf(x);<br>(float) l; |
| float | 同上 | Float.valueOf(l);<br>l; |
| Long | *(スキップ)* | Long.valueOf(l);<br>l; |
| long | Long.valueOf(l);<br>L; | *(スキップ)* |
| Short | L.shortValue();<br>(short) (long) L; | Short.valueOf((short)x);<br>(short) l; |
| short | 同上 | 同上 |
| Byte | L.byteValue();<br>(byte) L; | Byte.valueOf((byte) l);<br>(byte) l; |
| byte | 同上 | 同上 |
| Boolean | *(変換不可能)* | *(変換不可能)* |
| boolean | *(変換不可能)* | *(変換不可能)* |
***************************************************************************
## Short/ short
| 変換後 | ラッパークラス（Short） | プリミティブ型(short) |
| --- | --- | --- |
| String | String.valueOf(S); | String.valueOf(s); |
| Character | (char) (S + '0'); | (char) (S + '0'); |
| char | 同上 | 同上 |
| Integer | S.intValue();<br>(int) S; | (int) s; |
| int | 同上 | s; |
| Double | S.doubleValue();<br>Double.valueOf(S);<br>(double) S; | Double.valueOf(s);<br>(double) s; |
| double | S.doubleValue();<br>Double.valueOf(S);<br>S; | Double.valueOf(s);<br>s; |
| Float | S.floatValue();<br>Float.valueOf(S);<br>(float) S; | Float.valueOf(s);<br>(float) s; |
| float | S.floatValue();<br>Float.valueOf(S);<br>S; | Float.valueOf(s);<br>s; |
| Long | S.longValue();<br>Long.valueOf(S);<br>(long) S; | Long.valueOf(s);<br>(long) s; |
| long | S.longValue();<br>Long.valueOf(S);<br>S; | Long.valueOf(s);<br>s; |
| Short | *(スキップ)* | Short.valueOf((short)s);<br>s; |
| short | S.shortValue();<br>Short.valueOf((short)S);<br>S; | *(スキップ)* |
| Byte | S.byteValue();<br>(byte) (short) S; | Byte.valueOf((byte) s);<br>(byte) s; |
| byte | 同上 | 同上 |
| Boolean | *(変換不可能)* | *(変換不可能)* |
| boolean | *(変換不可能)* | *(変換不可能)* |
***************************************************************************
## Byte/ byte
| 変換後 | ラッパークラス（Byte） | プリミティブ型(byte) |
| --- | --- | --- |
| String | String.valueOf(B); | String.valueOf(b); |
| Character | (char) (B + '0'); | (char) (b + '0'); |
| char | 同上 | 同上 |
| Integer | B.intValue();<br>(int) B; | (int) b; |
| int | 同上 | 同上 |
| Double | B.doubleValue();<br>(double) B; | Double.valueOf(b);<br>(double) b; |
| double | 同上 | 同上 |
| Float | B.floatValue();<br>(float) B; | Float.valueOf(b);<br>(float) b; |
| float | 同上 | 同上 |
| Long | B.longValue();<br>(long) B; | Long.valueOf(b);<br>(long) b; |
| long | 同上 | 同上 |
| Short | B.shortValue();<br>(short) B; | Short.valueOf((short) b);<br>(short) b; |
| short | 同上 | 同上 |
| Byte | *(スキップ)* | Byte.valueOf(b);<br>b; |
| byte | B.byteValue();<br>B; | *(スキップ)* |
| Boolean | *(変換不可能)* | *(変換不可能)* |
| boolean | *(変換不可能)* | *(変換不可能)* |
***************************************************************************
## Boolean/ boolean
| 変換後 | ラッパークラス（Boolean） | プリミティブ型(boolean) |
| --- | --- | --- |
| String | String.valueOf(B); | String.valueOf(b); |
| Character | *(変換不可能)* | *(変換不可能)* |
| char | *(変換不可能)* | *(変換不可能)* |
| Integer | *(変換不可能)* | *(変換不可能)* |
| int | *(変換不可能)* | *(変換不可能)* |
| Double | *(変換不可能)* | *(変換不可能)* |
| double | *(変換不可能)* | *(変換不可能)* |
| Float | *(変換不可能)* | *(変換不可能)* |
| float | *(変換不可能)* | *(変換不可能)* |
| Long | *(変換不可能)* | *(変換不可能)* |
| long | *(変換不可能)* | *(変換不可能)* |
| Short | *(変換不可能)* | *(変換不可能)* |
| short | *(変換不可能)* | *(変換不可能)* |
| Byte | *(変換不可能)* | *(変換不可能)* |
| byte | *(変換不可能)* | *(変換不可能)* |
| Boolean | *(スキップ)* | Boolean.valueOf(b);<br>b |
| boolean | B.booleanValue();<br>B | *(スキップ)* |

