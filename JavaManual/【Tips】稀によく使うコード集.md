概要
* [コード](#コード)
  * [変数の型を確認する方法](#変数の型を確認する方法)
* [応用コード](#応用コード)
  * [a~zを出力する方法](#azを出力する方法)

## コード
### 変数の型を確認する方法
1. x`.getClass()``.getName()`;  
※ プリミティブ型変数には使用できない（エラーする）  
出力例：`java.lang.String`

2. x `instanceof` 型  
※ プリミティブ型変数には使用できない（どちらかがオブジェクトのでなければエラーする）  
出力例：`true`、`false`

3. 型.class.isInstance(x)  
※ プリミティブ型変数には使用できない（エラーしない）  
出力例：`true`、`false`

4. ((Object) x).getClass().getName()  
※ プリミティブ型をオブジェクト型に変換し、1～3の方法でチェックすることができる  
出力例：`ラップクラス`/`true`/`false`
```Java
// 1. プリミティブ型変数には使用できない（エラーする）
System.out.println(x.getClass().getName());
// 2. プリミティブ型変数には使用できない（エラーする）
System.out.println((x instanceof String)? "Yes" : "No");
// 3.プリミティブ型変数には使用できない（エラーしない）  
System.out.println((String.class.isInstance(x)));
```

## 応用コード
### a~zを出力する方法
``` Java
// char を使う方法
for (char i = 'a'; i < 'z' + 1; i++) {
    System.out.println(i);
}
// int を使う方法
for (int i = 0; i < 26; i++) {
    System.out.println((char) ('a' + i));
}
```
