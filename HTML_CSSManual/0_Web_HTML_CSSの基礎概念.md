概要
* [インターネット・Web概念](#インターネットweb概念)
* [おすすめサイト](#おすすめサイト)
* [HTMLとCSSとは](#htmlとcssとは)
  * [HTMLとは](#htmlとは)
  * [CSSとは](#cssとは)
* [ボックスモデル](#ボックスモデル)
  * [ブロック要素](#ブロック要素)
  * [インライン要素](#インライン要素)

***************************************************************************
## インターネット・Web概念
* インターネットを意味するものは以下のようなもの
  * 世界規模のコンピュータネットワーク
  * 世界中のコンピュータ同士で様々な情報を交換できる仕組み
  * 複数のコンピュータネットワークを相互接続した、グローバルなネットワーク  

* Web
  * World Wide Web
  * インターネットの機能のひとつ
  * インターネットの仕組みを利用して、Webサイトを通して情報を発信／閲覧するための仕組み
  * Webサイトは、WebサーバとWebクライアントという二つの要素で構成されている
  * Webサーバ：Web上で情報を公開する側であり、作成したWebサイト上で利用するファイルを保管する
  * Webクライアントは情報を受け取る側で、ユーザの利用するパソコンや端末のこと  

「Webサイトを構築したWebサーバがインターネットでつながっていて」  
⇒「Webの仕組みを利用してWebサーバとのURL要求（リクエスト）／応答（レスポンス）の通信を行い」  
⇒「パソコンやスマホからWebページの閲覧やWebサービスを利用する」  

* URL
* `http://xxxxx.com/xx/index.html` を例とする
  * http: 　⇒　プロトコル
  * http:// 　⇒　スキーム
  * xxxxx.com　⇒　ドメイン名
  * xxx　⇒　パス
  * index.html　⇒　ファイル名（拡張子）

## おすすめサイト
* Webページの構造
  * [HTML	Living	Standard](https://html.spec.whatwg.org/multipage/)
  * [W3C](https://www.w3.org/Style/CSS/)、W3C:World Wide Web Consortium
  * **[HTML5 & CSS3 リファレンス](https://www.osaka-kyoiku.ac.jp/~joho/html5_ref/html5.html)、大阪教育大学様**
  * [HTML LS コンテンツモデル ガイド](https://webgoto.net/html5/)、コンテンツモデル
  * [Nu	Html	Checker](https://validator.w3.org/nu/)、HTML文法チェッカー
  * [CSS	Validation	Service](https://jigsaw.w3.org/css-validator/)、CSS文法チェッカー
* 色関連
  * [CSS	Gradient](https://cssgradient.io/)、グラデーションピッカー
  * [CSS	Gradient](https://webgradients.com/)、グラデーションパターン参考
  * [GradPad](http://ourownthing.co.uk/gradpad.html)、グラデーションピッカー
  * [Eggradients](Eggradients)、グラデーションパターン参考
 * サイト制作事前調査関連
   * [Statcounter](https://gs.statcounter.com/)、国別で解像度使用率などの統計データまとめサイト
   * [ScreenSizses](https://www.screensizes.app/)、デバイス規格まとめサイト

## HTMLとCSSとは
* Webページ：
  * `HTML`の役割はこの**情報を構造化する**こと
  * `CSS`の役割はこの**見た目やデザイン**こと
* HTMLフレームワークについて：
  * 代表的なHTMLフレームワークのひとつ、Bootstrap
    * HTMLフレームワークは、あらかじめデザインされたHTML/CSSをセットにしたもの
    * Bootstrapは、ツイッター社が開発した高機能なHTMLフレームワーク
    * オープンソースで、誰でも自由に無料でおｋ
    * Webページ用の便利な部品を多数装備
    * レスポンシブデザイン

### HTMLとは
* **HTML (HyperText Markup Language)**
* ウェブページの骨組みを作るための言語。
* Webページに表示したい内容を構造として表現し、その構造の表現にはタグを使用する
* 主な目的: テキストや画像などのコンテンツを**構造化**
  * HTMLの役割は構造を表現すること
  * HTMLでは構造の表現にタグを使用する
  * HTMLは情報を構造として記述し、その構造をタグで表す
    * Webページの内容と構成を指定する
    * テキストファイルとして記述する
    * 基本的に、1ページにつき1ファイル
* 例: **見出し**、**段落**、**リスト**、**リンク**、**画像**
* [公式ドキュメント](https://developer.mozilla.org/ja/docs/Web/HTML)
* [HTMLの規範](https://html.spec.whatwg.org/multipage/)
* [CSSの規範](https://www.w3.org/Style/CES/)  

```html
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>My First Page</title>
</head>
<body>
    <h1>はじめてのページ</h1>
    <p>これは段落です。</p>
</body>
</html>
```

### CSSとは
* CSS (Cascading Style Sheets)
* ウェブページのデザインやレイアウトを調整するための言語
* 主な目的: **サイズ**、**色**、**フォント**、**余白**、**レイアウト**などの**スタイル**を指定
  * テキストファイルとして記述
  * 複数のCSSを組み合わせたり、複数のHTMLから共通のCSSを利用したりできる
  * 複数のCSSを利用する際、上書き適用のため後に追加された内容が優先される
* ブラウザによって、HTMLのデフォスタイルは違ってくる場合があるため、リセットすることが推奨される
 * Normalize.css: ノーマライズ、独創的なデザインや「**イチからきっちり作りたい**」時に役立つリセットCSS
  * 代表的なCSS例：`<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css"/>`
 * Sanitize.css: サニタイズ、ノーマライズを更に**ブラウザ間の差を無くし**つつ、きれいなベースを作ってくれるサニタイズCSS
  * 代表的なCSS例：`<link href="https://unpkg.com/sanitize.css" rel="stylesheet"/>`

```html
<style>
    body {
        background-color: lightblue;
    }
    h1 {
        color: darkblue;
        text-align: center;
    }
</style>
```

## ボックスモデル
* HTML要素がどのように**幅**・**高さ**・**余白**を持つかを定義する概念
* すべてのHTML要素は、見え方に関係なく以下の4つの領域で構成される
 * `margin`（外側の余白）: 要素と他の要素との間隔
 * `border`（枠線）: 要素の外枠
 * `padding`（内側の余白）: 内容とボーダーの間のスペース
 * `content`（内容領域）: 実際のテキストや画像が表示される部分
```
+-------------------------+  ← マージン（margin）
|  +-------------------+  |  ← ボーダー（border）
|  |  +-------------+  |  |  ← パディング（padding）
|  |  |  コンテンツ  |  |  |  ← コンテンツ（content）
|  |  +-------------+  |  |
|  +-------------------+  |
+-------------------------+
```

### ブロック要素
* ブロック要素 = 幅いっぱい + 改行する（例: <div>, <p>, <h1>）
* ブロック要素は、**横幅いっぱいに広がり、次の要素を改行して配置する**
* 主にページのレイアウトを構成するために使われる
* 主なブロック要素
 * `<div>`: **汎用のコンテナ要素**
 * `<p>`: 段落
 * `<h1>`～`<h6>`: 見出し
 * `<ul>`, `<ol>`, `<li>`: リスト
 * `<table>`: 表
 * `<form>`: フォーム
* ブロック要素の特徴
 * 親要素の**幅いっぱいに広がる**（width: 100% がデフォルト）
 * 自動的に**改行**される
 * width や height を自由に指定できる

```html
<!-- 1つの<div>は幅いっぱいに広がり、次の<div>は改行される -->
<div style="background: lightblue;">ブロック要素1</div>
<div style="background: lightgreen;">ブロック要素2</div>
```

### インライン要素
* インライン要素 = 必要な幅だけ + 改行しない（例: <span>, <a>, <img>）
* インライン要素は、横幅を**必要な分だけ占める**だけで、改行せずに**同じ行に並ぶ**要素
* 主にテキストの一部として装飾するために使われる
* インライン要素の中にブロック要素を入れない
* 主なインライン要素
 * `<span>`: **汎用のインラインコンテナ**(インライン要素版の`<div>`)
 * `<a>`: リンク
 * `<strong>` / `<b>`: 文字を太字にする
 * `<em>` / `<i>`: 文字を斜体にする
 * `<img>`: 画像
* インライン要素の特徴
 * コンテンツのサイズ分だけ横幅を取る
 * 改行されずに横に並ぶ
 * width や height を指定しても効果がない
```html
<!-- <span> はインライン要素なので、段落内の一部だけを装飾可能 -->
<p>この<span style="color: red;">赤い部分</span>だけを装飾できます。</p>
```
