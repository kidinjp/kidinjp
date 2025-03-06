概要
* [標準入力の選び方](#標準入力の選び方)
  * [fs、fsモジュールを使った一括入力](#fsfsモジュールを使った一括入力)
  * [process.stdin、リアルタイムの入力ストリーム](#processstdinリアルタイムの入力ストリーム)
  * [readline、リアルタイム処理（行単位での読み込み）](#readlineリアルタイム処理行単位での読み込み)
  * [readline、リアルタイム処理（複数行での読み込み）](#readlineリアルタイム処理複数行での読み込み)
 * [標準出力](#標準出力)

***************************************************************************
# 標準入力の選び方
1. `fs.readFileSync("/dev/stdin")`
    * **コンテスト・簡易スクリプト向き**
    * 標準入力を一括取得する方法
    * 短く書けるので競技プロパティ向き
    * 標準入力を一括取得して処理するケースに向いている。ただし、これはあくまでコンテストなどの特殊環境に寄った書き方
    * メリット：
      * 同期的に動作するため、処理の流れがシンプルで高速
    * デメリット：
      * **リアルタイム処理には不向き**
      * **Windows環境では非推奨**
2. `process.stdin`
    * **リアルタイム処理・ストリーム処理向き**
    * 標準入力をストリームとして扱う方法
    * データ入力されるたびに`data`イベントが発火し、終了時には`end`イベントが発火する
    * 複数行のデータを一度に処理したい場合に便利（競技プログラミングでも使用可）
    * メリット：
      * **リアルタイム処理可能**（データが来る度に処理を走らせる）
      * **非同期処理対応**
    * デメリット：
      * **行単位の制御が面倒**（`readline`ほど簡潔ではない）
      * 処理が複雑になりがち
3. `readline`
    * **業務アプリ・バックエンド開発向き**
    * 標準入力を行単位で処理する方法
    * リアルタイム処理・非同期処理に対応
    * Linux/Windows両対応なので環境依存しにくい
    * **実務ではこちらが好かれる**
    * メリット：
      * **1行ずつ処理可能**（`line`イベントで1行ずつ処理）
      * **非同期処理との相性が良い**
      * 環境依存が少ない
    * デメリット：
      * 短いスクリプトにはやや冗長
      * 競技プログラミングでは`fs`に比べるとコードが長くなる

| 入力方法 | 特徴 | 使用場面 |
| --- | --- | --- |
| [fs.readFileSync](#fsfsモジュールを使った一括入力) | 同期的・高速 | 競技プログラミング |
| [process.stdin](#processstdinリアルタイムの入力ストリーム) | 非同期・バッチ処理向き | スクリプト |
| [readline](#readlineリアルタイム処理行単位での読み込み) | 非同期・非同期リアルタイム処理 | 実務アプリ開発 |

**【`readline`が好かれる理由】**  
* 実務では非同期処理やリアルタイム処理が多い
* 動作環境がLinux/Windows混在でも問題が起きにくい
* 可読性が高い（同期処理特有のクセがない）

## fs、fsモジュールを使った一括入力
```JavaScript
// 書き方1. 入力をそのまま受け取る
// 「fs」モジュールを読み込んで、ファイルシステムを操作する機能を使えるようにする
// 標準入力（コンソールに入力されたデータ）をUTF-8文字コードで一気に読み込み、前後の余白を削除して変数inputに格納する
const fs = require("fs");
const input = fs.readFileSync("/dev/stdin", "utf-8").trim();

// 書き方2. 書き方1と同様だが、fs 変数定義せずに input 内に収める
const input = require("fs").readFileSync("/dev/stdin", "utf-8").trim();

// 書き方3. 読み込んだ内容に対して改行ごとに分割し、inputを配列として扱う
const fs = require("fs");
const input = fs.readFileSync("/dev/stdin", "utf-8").trim().split("\n");
console.log(input);
```
Node.js独自の関数で、「モジュール」という外部の機能を読み込む  
"fs" モジュールは File System（ファイルシステム） を扱う機能が詰まってる  
→ ファイルの読み書きなどができるようになる！

* `fs.readFileSync("/dev/stdin", "utf-8")`
  * `readFileSync()` はファイルを**同期的に**読み込む関数。
    * 第1引数`/dev/stdin`は**標準入力（コンソールからの入力）を意味する特殊なパス**  
      → `/dev/stdin`は、**Linux系のシステム**で使われる**入力の通り道**みたいなもの！
    * 第2引数`utf-8`は**文字コード**。テキストをどう解釈するかを指定する  
      → 文字が正しく読めるようにするために UTF-8 を使う。`utf8`と書くのも可
  * つまり、ここでは「**コンソールから受け取った文字列をUTF-8で読み込む**」という意味になる  

【fsのメリット】  
* 競技プログラミング向き：**短く**書けて、**複数行の入力**もすぐ取れる
* 同期処理：`readFileSync`は**同期的にデータを読み込むから、後続処理がシンプル**  

【fsのデメリット】  
* リアルタイム処理に弱い：逐次的な**行ごとの処理は難しい**
* 環境依存：`/dev/stdin`を使う方法は**Linux/Unix系**では動くけど、**Windowsではうまくいかない場合がある**

## process.stdin、リアルタイムの入力ストリーム
```JavaScript
// 標準入力を開始する（プログラムが入力を待つ状態になる）
// 標準入力の文字コードをUTF-8に設定する
process.stdin.resume();
process.stdin.setEncoding('utf8');

let data = '';

// 標準入力からデータを受け取る
process.stdin.on('data', (chunk) => {
  data += chunk;
});

// 入力が終了したら実行される（Ctrl+DやCtrl+Cで終了）
process.stdin.on('end', () => {
  const reader = data.trim().split(' '); // 空白区切りで分割
  console.log(reader); // 分割した結果を出力
});
// 入力終了は Ctrl+D
```
* `data` + `end`イベントを使う方法
* dataイベント：**入力データが届いた際に呼ばれる**
* endイベント：入力終了時に発火（Ctrl+D等）
* 特徴：
  * **全体のデータを一度に扱う**
  * 複数行でもまとめて処理するのに便利  
    → たとえば、データを一気に受け取って最後にまとめて解析したいケースに向いている
* 用途：まとめて入力を受け取り、最後に処理するケース

## readline、リアルタイム処理（行単位での読み込み）
```JavaScript
process.stdin.resume();
process.stdin.setEncoding('utf-8');

let input = "";

// require という処理を使って readline という機能を使う
// 標準入力と標準出力のインターフェースを作成する
const reader = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});
reader.on('line', (line) => {
   input = line; 
});
reader.on('close', () => {
    console.log(input);
});
```
* readline モジュール を使う
* 1行ごとに入力を処理する (`line` イベント)
* **リアルタイムに行ごとの入力を処理するのに便利**  
  → たとえば、複数行の入力がある競技プログラミングのケースでよく使う！
* `line`イベント: 入力のたびに実行
* `close`イベント: 入力が終了した時に発火（Ctrl+D等）
* 用途：**逐次的に1行ずつ処理する必要がある場合**

## readline、リアルタイム処理（複数行での読み込み）
```JavaScript
process.stdin.resume();
process.stdin.setEncoding('utf8');

let lines = [];

const reader = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

reader.on('line', (line) => {
  lines.push(line);
});

reader.on('close', () => {
  console.log(lines[0]);
});
```

# 標準出力
1. `console.log();`
  * 内容は一行に出力される
2. `process.stdout.write();`
  * 内容は同じ行に出力される。`"出力したい内容\n"`のように`\n`を使う  

`console.log("<b>あああ</b>");`のようなHTML表示もできる
