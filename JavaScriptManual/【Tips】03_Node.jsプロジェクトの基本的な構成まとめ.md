概要
* [Node.jsプロジェクトのよくある構造](#Nodejsプロジェクトのよくある構造)
  * [package.jsonとは](#packagejsonとは)
  * [app.jsとは](#appjsとは)
  * [router.jsとは](#routerjsとは)
* [ターミナルで実際の操作](#ターミナルで実際の操作)
  * [現在のディレクトリ(フォルダ位置)を確認](#現在のディレクトリフォルダ位置を確認)
  * [プロジェクトディレクトリへ移動](#プロジェクトディレクトリへ移動)
  * [依存関係をインストールする](#依存関係をインストールする)
  * [アプリケーションの起動](#アプリケーションの起動)
  * [アプリケーションを終了する](#アプリケーションを終了する)
  * [分割代入構文](#分割代入構文)

※ Node.jsのWebサーバー + Express + Pugの基本的な構成の実際例を紹介する  
※ 本項目で使用するコード内容は、[paiza](https://paiza.jp/works/javascript/new-primer
)教材抜粋

***************************************************************************
# Node.jsプロジェクトのよくある構造
```
# Expressを使った基本的なWebアプリのディレクトリ構造の例
my-app
├─ package.json                # プロジェクト設定・依存関係
├─ app.js                      # アプリケーションのエントリーポイント
├─ /routes                     # ルーティング関連のファイル
│   └─ router.js               # 各URLへの処理を定義
├─ /views                      # テンプレートファイル(Pugなど)
│   └─ index.pug
│   └─ 404.pug
├─ /public                     # 静的ファイル（CSS、画像、JS）
│   └─ style.css
├─ /node_modules               # npmでインストールされたパッケージ
└─ .gitignore                  # Git管理しないファイルを指定
```
* [`package.json`](#packagejsonとは)：プロジェクト情報、依存ライブラリ、スクリプトを記載
* [`app.js`](#appjsとは)：アプリの起動処理を行うメインファイル
* [`/routes`](#routerjsとは)：ルーティング処理をモジュールに分けることで見やすく管理
* `/views`：テンプレートエンジン（例：Pug）のHTMLファイル
* `/public`：静的ファイルを保存する場所（CSS・画像など）
* `/node_modules`：`npm install` でインストールされる依存ライブラリ
* `.gitignore`：Gitに含めたくないもの（`node_modules`など）を指定

## package.jsonとは
シェルダー操作コマンドをセッティング
Node.jsプロジェクトの設定ファイルで、以下のような情報を管理する
```JavaScript
{
  "name": "app",
  "version": "1.0.0",
  "description": "",
  "main": "app.js",
  "scripts": {
    "start": "node app.js"
  },
  "author": "",
  "license": "ISC",
  "dependencies": {
    "express": "^4.17.1",
    "pug": "^3.0.0"
  }
}
```
* name：プロジェクト名（app）
* version：バージョン番号（1.0.0）
* description：アプリの説明（今は空）
* main：エントリーポイント（実行される最初のファイル、app.js）
* scripts：ターミナルで実行するコマンドを設定できる
    * start：`npm start`と打つと、`node app.js`を実行してサーバーを起動する
* author：作成者名（今は空）
* license：ライセンスの種類（デフォルトはISC）
* dependencies：プロジェクトが使う外部ライブラリ
* express：Webアプリケーションを作るためのフレームワーク
* pug：テンプレートエンジン（HTMLを簡潔に書くためのもの）

## app.jsとは
Expressを使ってWebサーバーを作るための基本的なコード
```JavaScript
const express = require("express");	// express を読み込んで、サーバーを作る準備
const path = require("path");	// パス操作用のモジュール。ファイルパスを扱う
const router = require("./routes/router.js");	// ルーティング用。URLごとの処理を別のファイル（router.js）に分けて管理している。詳しくはrequireについての項目を（※ このファイルはrequireされるために、`router.js`に下記記述が必要：`module.exports = router;`）
const port = process.env.PORT || 3000;	// ポート番号を設定。環境変数PORTがなければデフォルトで3000番になる

const app = express();	// Expressアプリの本体を作成

app.set("view engine", "pug");	// view engine：テンプレートエンジンをPugに設定
app.set("views", path.join(__dirname, "views"));	// テンプレートファイルが入っているディレクトリを指定（viewsフォルダを使う）

app.use(express.urlencoded({ extended: true }));	// フォームデータを解析するためのミドルウェア
app.use(express.json());	// JSONデータを解析するためのミドルウェア

// ログの表示
// ミドルウェア：リクエストを受け取るたびにHTTPメソッドとパスをログに出力
app.use((req, res, next) => {
  console.log(`${req.method} at ${req.path}`);
  next();	// 次の処理に進むために必須。これがないと次のミドルウェアに進まない
});

// ルーティングと静的ファイルの配信
app.use(router);	// URLごとの処理を担当するルーティングを呼び出し
app.use(express.static(path.join(__dirname, "static")));	// staticフォルダ内のCSSや画像、JSなどをそのまま公開する
// 例：static/style.css → http://localhost:3000/style.css

// 404エラーハンドリング
// どのルートにもマッチしなかった場合、404ページ（views/404.pug）を表示する
app.use((req, res) => {
  // res.status(404)：HTTPステータスコード404をセット
  // render("404")：Pugテンプレートで404ページを描画する
  res.status(404).render("404");
});

// サーバー起動
// サーバーを指定したポート（3000番）で起動する
// 起動したら、コンソールにURLが表示される
app.listen(port, () => {
  console.log(`app running: http://localhost:${port}`);
});
```
* **express**：Expressを使ってサーバー作成
* **path**：ファイルパスの操作
* **router**：URLに応じた処理を分ける（`routes/router.js`）
* **ポート番号設定**：環境変数PORTがなければ3000を使用
* **テンプレートエンジン**：Pugを指定
* **静的ファイルの公開**：`static`フォルダ内のCSSや画像などを公開
* **404エラーハンドリング**：どのルートにも一致しない場合404ページを表示

## router.jsとは
ルーティング処理を管理するファイル
```JavaScript
//const router = require("express").Router();

let kyokoCount = 0;
let rioCount = 0;
let tsubameCount = 0;

/*
router.get("/", (req, res) => {
  res.render("index", { message: "みなさんこんにちは！" });
});

router.get("/votes", (req, res) => {
  res.render("votes", { kyokoCount: kyokoCount, rioCount: rioCount, tsubameCount: tsubameCount });
});

router.get("/votes/:name", (req, res) => {
    const name = req.params.name;

    if (name === "kyoko") {
      kyokoCount++;
      res.render("results", { fullName: "霧島京子", count: kyokoCount });
    } else if (name === "rio") {
      rioCount++;
      res.render("results", { fullName: "六村リオ", count: rioCount });
    } else if (name === "tsubame") {
      tsubameCount++;
      res.render("results", { fullName: "緑川つばめ", count: tsubameCount });
    } else {
      res.status(404).render("404");
    }
  });

module.exports = router;
*/
```
【**require(module)について**】  
* [Node.js v14.14.0 Documentation](https://nodejs.org/docs/latest-v14.x/api/modules.html)
* 他の言語と同様に、JavaScript（Node.js）でもファイルを分割することができる
* この際に module と呼ばれるシステムを活用することになる
* `require` される側のファイルでは、読み込まれて欲しい関数やクラスの塊を module.exports として定義する
* それを外部から `require` することで、戻り値として `module.exports` として定義された関数やオブジェクトを受け取ることができる

***************************************************************************
# ターミナルで実際の操作
## 現在のディレクトリ(フォルダ位置)を確認
```
$ pwd
```

## プロジェクトディレクトリへ移動
```
$ cd my-app
```

## 依存関係をインストールする
```
$ npm install
```
* これにより、そのプロジェクト内で利用するパッケージをインストールすることができる  

本プロジェクトでの動作：  
* `npm install` とのコマンドによって `package.json` に記述されたパッケージ、及びその依存関係にあるパッケージをローカルの `node_modules` 以下にインストールする
* `package.json` 及び `package-lock.json` を利用することで、様々な環境で同様のパッケージ・バージョン構成を再現することができる
* `package-lock.json` はバージョン管理に使われる

## アプリケーションの起動
$ npm run start
* `npm run-script` として登録された `start` を実行する
* `start` スクリプトは、もっぱら「アプリケーションの実行」のために用意されている
* この詳細は `package.json` に記述されている

```JavaScript
// この部分
  "scripts": {
    "start": "node app.js"
  },
```

【**`npm run-script`について**】  
* [npm Documentation](https://docs.npmjs.com/cli/run-script)
* package.json の "scripts" に指定されたコマンドを実行する
* 主な例として、`start` や `build` が慣習的に多く用いられますが、名前の付け方は自由
* 今回は `node app.js` で単に `app.js` を実行しているだけだが、他に前処理が必要であったり、実行ファイルが変わった場合でも、"start" を修正することで変わらず `npm run start` として実行できる、というようなメリットがある

## アプリケーションを終了する
\[ctrl\] + \[c\]  または  
\[ctrl\] + \[d\]
