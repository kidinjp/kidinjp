概要
* [条件式](#条件式)
  * [if - else if - else](#if---else-if---else)
  * [switch](#switch)
    * [ラムダ式 (Java 8以降)](#switch-ラムダ式参考例)
  * [三項演算子](#三項演算子)
* [ループ](#ループ)
  * [for](#for)
    * [拡張forループ (Java 5以降)](#拡張forループ)
    * [foreachループ（ラムダ式） (Java 8以降)](#foreachループラムダ式)
  * [while](#while)
  * [do - while](#dowhile)
* [continue と break](#continue-と-break)

***
## 条件式
### if - else if - else
**基本の形：**  
if (`条件式1`) {  
　　処理  
} else if (`条件式2`) {  
　　処理  
} else {  
　　処理  
}  
``` Java
int n = 5;
if (n % 3 == 0 && n % 5 == 0) {
    System.out.println("FizzBuzz");
} else if (n % 3 == 0 && n % 5 != 0) {
    System.out.println("Fizz");
} else if (n % 3 != 0 && n % 5 == 0) {
    System.out.println("Buzz");
} else {
    System.out.println(n);
}
```
### switch
対象の変数が特定の値に一致する場合に効率的に処理を分岐する構文。  
※ 合致した項目以降の内容はbreakされるまで処理するので、**break**を掛けるかどうか判断する必要がある。

**基本の形：**  
switch (`変数`) {  
　　case `条件`:  
　　　　処理  
　　　　break;  
　　default:  
　　　　処理  
　　　　break;  
}  
``` Java
int month = 5;
switch(month){
    case 1:
    case 2:
    case 3:
        System.out.println("春");
        break;
    case 4:
    case 5:
    case 6:
        System.out.println("夏");
        break;
    default:
        System.out.println("対象範囲外");
        break;
}
```

#### switch-ラムダ式参考例
``` Java
Integer month = 9;

switch(month){
    case 1, 2, 3 -> System.out.println("春");
    case 4, 5, 6 -> System.out.println("夏");
    case 7, 8, 9 -> System.out.println("秋");
    case 10, 11, 12 -> System.out.println("冬");
    default -> System.out.println("不当な数値。入力し直してください。");
}
```

### 三項演算子
**基本の形：**  
`条件式` ? `trueの場合` : `falseの場合`  
(`条件式`) ? `trueの場合` : `falseの場合`
``` Java
String position = "student";
System.out.println(position.equals("student")? "student" : "teacher");
```

***
## ループ
### for
**基本の形：**  
for (`初期化式`; `条件式`; `増減式`) {  
　　処理  
}  

1. ループ開始時に、一度だけ`初期化式`を実行し、変数を宣言する（基本はint i = 0など）  
2. `条件式`falseになるまで`増減式`で変化を与える  
※ 掛けた条件式が無限ループになる場合、エラーとなる  
※ 初期から条件に満たさなかった場合処理されない  
※ 各式は提示しなくても稼働する  
``` Java
for (int i = 0; i < 5; i++) {
    System.out.print(i + " ");
} // 終了時、【0 1 2 3 4 】が出力される
System.out.println();

// 別で初期化式、条件式、増減式を設定することも可能
int i = 0;
for (;;) {
    System.out.print(i + " ");
    i++;
    if (!(i < 5)) {
        break;
    }
} // 終了時、【0 1 2 3 4 】が出力される
```
#### 拡張forループ
`配列`や`Iterableインターフェースを実装するコレクション型`に対して一個ずつ取り出す際に利用できる
``` Java
String[] li = {"A", "B", "C"};
for (String i: li) {
    System.out.println(i);
}
```

#### forEachループ(ラムダ式)
`Iterableインターフェースを実装するコレクション型`や`Stream`に対して一個ずつ取り出す際に利用できる。  
※ 配列で利用したい場合、Array.asList()またはArrays.stream()に変換してから利用可能。  
   前者の方が処理的に効率的。  

**基本の形：**  
`オブジェクト`.forEach((`要素`) ->) {  
　　処理（複数可能）  
});  
※ 要素の型はオブジェクトの内容と合わせるかvarにしておく必要がある
``` Java
List<String> li = new ArrayList<>(Arrays.asList("A", "B", "C"));

// 書き方A
li.forEach((String i) -> {
    System.out.println(i);
});

// 書き方B：iへの型指定を省略
li.forEach((i) -> {
    System.out.println(i);
});

// 書き方C：i周りの括弧を省略
li.forEach(i -> {
    System.out.println(i);
});

// 書き方D：処理が一つのみの場合{}と改行を省略。複数処理できない
li.forEach(i -> System.out.println(i) );

// 書き方E：ラムダ式を使わずにメソッド参照（::）。複数処理できない
li.forEach(System.out::println);
```

### while
**基本の形：**  
while (`条件式`) {  
　　処理  
}
``` Java
int i = 0;
while (i < 5) {
    System.out.print(i++ + " ");
}  // 【0 1 2 3 4 】が出力される
```
### do - while
**基本の形：**  
do {  
　　処理  
} while (`条件式`); 
``` Java
int i = 0;
do {
    System.out.print(i++ + " ");
} while (i > 5);
// 【0 】が出力される
```

#### continue と break
上記switch内のbreak以外に、forまたはwhileに使うループへの制御  
* continue：現在の反復をスキップし、次の反復に移る  
* break：現在いるループを終了させ、次の外部の処理に移る（二重ループの場合、内部のみを閉じる）
``` Java
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) {
        continue;
    }
    if (i == 5) {
        break;
    }
    System.out.print(i + " ");
}  // 【1 3 】のみが出力される
```
