概念
* [HTMLの基本構造](#htmlの基本構造)
  * [\<!DOCTYPE html>](#doctype-html)
  * [\<html>～\</html>](#htmlhtml)
  * [\<head>～\</head>](#headhead)
    * [\<meta charset="UTF-8">](#meta-charsetutf-8)
    * [\<title>～\</title>](#titletitle)
    * [\<style>～\</style>](#stylestyle)
  * [\<body>～\</body>](#bodybody)
* [HTMLの主なタグ](#htmlの主なタグ)
  * [\<h>、見出し（ヘッディング）](#h見出しヘッディング)
  * [\<p>、段落](#p段落)
  * [\<br>、改行](#br改行)
  * [\<strong>、太字](#strong太字)
  * [\<img>、画像表示](#img画像表示)
    * [パス](#パス)
  * [\<a>、リンク](#aリンク)
  * [\<ul>/\<ol>/\<li>、リスト](#ulolliリスト)
  * [ナビゲーションバー](#ナビゲーションバー)
    * [テーブルの幅調整](#テーブルの幅調整)
    * [セルの結合 colspan、rowspan(改行br)](l#セルの結合-colspanrowspan改行br)
    * [表作りの実例【数独】](#表作りの実例数独)
  * [\<form>、フォーム](#formフォーム)
    * [paizaの実例](#paizaの実例)
  * [その他部品](#その他部品)
    * [\<link>、外部のCSSファイルやフォントをHTMLにリンクする](#link外部のcssファイルやフォントをhtmlにリンクする)
    * [\<blockquote>、引用文](#blockquote引用文)
    * [\<small>、著作権表記や法的表記](#small著作権表記や法的表記)
    * [\<span>、意味を持たないインライン要素](#span意味を持たないインライン要素)
    * [\<audio>、音声データを埋め込むために使用する](#audio音声データを埋め込むために使用する)
    * [\<video>、動画データを埋め込むために使用する](#video動画データを埋め込むために使用する)
    * [\<script>、スクリプトデータの埋め込みや参照で使用する(Javascriptなど)](#scriptスクリプトデータの埋め込みや参照で使用するjavascriptなど)
  * [グループ分け用ブロック要素](#グループ分け用ブロック要素)
    * [\<header>、ページ上部のヘッダ要素](#headerページ上部のヘッダ要素)
    * [\<nav>、メインのナビゲーションメニュー](#navメインのナビゲーションメニュー)
    * [\<article>、独立した記事やブログ投稿](#article独立した記事やブログ投稿)
    * [\<section>、1つのテーマに基づいたグループ化](#sectionつのテーマに基づいたグループ化)
    * [\<main>、ページのメインコンテンツ部分](#mainページのメインコンテンツ部分)
    * [\<aside>、補足情報や関連リンク](#aside補足情報や関連リンク)
    * [\<footer>、ページ下部のフッタ要素](#footerページ下部のフッタ要素)
    * [\<div>、意味を持たないブロック要素](#div意味を持たないブロック要素)

***************************************************************************
## HTMLの基本構造
HTML文章は以下の要素で構造される：
```html
<!DOCTYPE html> <!-- HTMLのバージョン宣言 -->
<html lang="ja"> <!-- 文書の言語を指定 -->
<head>
    <meta charset="UTF-8"> <!-- 文字コードの指定 -->
    <title>ページのタイトル</title> <!-- ブラウザタブに表示される名前 -->
</head>
<body>
    <!-- ここにコンテンツを記述 -->
</body>
</html>
```
* htmlは`<>`とのタグで記述する
* 基本的にスラッシュなしのタグとスラッシュありのタグを2つセットで使う

* ファイル名のルール
  * ファイル名に使用できる文字：半角英数字、ハイフン `-` 、アンダースコア `_`
  * 基本的には小文字で統一を推奨している
  * ファイル拡張子：`.html`
  * 慣例として、Webサイトの最初のページは `index.html` であること  

* Bootstrap
  * 参考になるサイト：[とほほのBootstrap入門 さま](https://www.tohoho-web.com/ex/bootstrap.html)
  * 追加例：
```html
<!DOCTYPE html>
<html lang="ja">

  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Project Nyaan</title>
    <!-- Bootstrap -->
    <!--link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"-->

  </head>

  <body>
    <h1>吾輩は猫である。</h1>
    <p class="lead">名前はまだない</p>
    <a class="btn btn-primary" herf="#">OK</a> 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  </body>

</html>
```

### \<!DOCTYPE html>
* 文書型宣言-DTD (Document Type Definition)
* どのバージョンのHTML仕様で作成しているかを宣言する  

【バージョン】  
* 現在は、主に HTML5 を意味する html を指定する
* その他バージョンとしては、次のようなものがある
  * HTML 4.01（<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 ～）
  * XHTML 1.1（<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 ～）
  * HTML 5 （<!DOCTYPE html>）（現在の主流）
  * など

```html
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <title>Project Nyaan</title>
  </head>
  <body>
    <h1>吾輩は猫である</h1>
  </body>
</html>
```

### \<html>～\</html>
`<html lang = "ja">`  
* HTML文書における基点となる要素
* DOCTYPE宣言のあとに記述する
* **Webページとなる**、との意味
* **HTML文書**であることを表す
* 言語を設定する**属性**を付けることも可能［lang="ja"］（日本語：ja、英語：en）

### \<head>～\</head>
* HTML文書のヘッダ部分
* ページの情報を記述する（タイトルや説明文、外部ファイルへのリンクなど）
* 検索エンジンのための説明文やCSSファイルへのリンク、タイトルなどを記述
* ブラウザには表示されない

#### \<meta charset="UTF-8">
* 文字コードを指定する
* metaはメタ要素のことで、文字コード以外にも多くの要素がある

* meta要素について
  * metaタグとも呼ばれている
  * Webページのメタデータを検索エンジンやブラウザに認識させるためのHTMLタグ
  * Webページの**概要**・**文字コード**・**キーワード**などHTML文書の**基本情報**を記述する
  * ※メタデータとは、データについてのデータを表し、そのデータの属性や関連する情報を記述した情報をいう

* 文字コードについて
  * コンピュータ上で文字列を表現するために用いられる表示方法で、多くの規格が存在する
  * 以前はWindowsで用いられたShift_JISが主流であったが、iOSでは文字化けするために現在では世界中で広く使われているUTF-8が主流となっている 

```html
<!-- 言語や説明文など、ページの情報を記述 -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```

#### \<title>～\</title>
* ページのタイトルを記述する
* ブラウザのタブや（ブックマークした時などの）ページタイトルとして表示される

#### \<style>～\</style>
* 主にCSSの部分
```html
<!-- 全体的に中央揃え -->
<style>
    fieldset {
        text-align：center; /* 中央揃え /
        margin：0 auto; / 中央に配置 /
        width：300px; / 幅を設定 （ない場合ウィンドウの幅に合わせる）*/ 
    }
</style> 
```

### \<body>～\</body>
* HTML文書の本体部分
* ブラウザに表示される

## HTMLの主なタグ
* タグ書き方のルール
  * 半角英数字
  * 大文字小文字の区別はない(**小文字で統一することを推奨**)
    * HTML仕様：要素名／属性名は、大文字小文字の区別はされない。基本小文字
    * XHTML仕様：要素名／属性名に小文字を使わなければならない
    * 両方の仕様に違反しないためには、小文字を使用するべきである
  * ある開始タグと終了タグの間に別のタグが入る場合は、必ず近いタグから終了タグを記載する(入れ子という)
  * 開始タグには、そのタグの付加情報を属性として記述ができる
  * 属性はタグ名の後にスペースを空けてから記述し、値はダブルクオーテーションで囲む
* コメントアウト
  * `<!-- 内容。コードへのコメントアウトと改行も可-->`

| タグ | 意味 |
| --- | --- |
| `<h1>`~`<h6>` | 見出しタグ<br>大見出しから小見出しまで |
| `<p>` | 段落 |
| `<a>` | リンク |
| `<img>` | 画像 |
| `<ul>`/ `<ol>`/ `<li>` | 箇条書きリスト<br>順序付きリスト |

### \<h>、見出し（ヘッディング）
`<h1>見出し１</h1>`
* `<h1>`から`<h6>`まで6種類ある
* `<h1>`が一番大きな見出し
* 数字の順に使用する(常にh1から始め、h2、h3と順に使用する)
* 見出しレベルを飛ばすことは避ける(フォントサイズ縮小のために低いレベル指定しない)

### \<p>、段落
`<p>`ひとつめの段落です。`</p>`
`<p>`ふたつめの段落です。`</p>`  
* `class="lead"`：強調して表示する。leadは文書の内容をまとめた要約文(Bootstrap)

### \<br>、改行
A`<br>`B　⇒  
A  
B

### \<strong>、太字
`<strong>`太字`</string>`  
・強い重要性要素
・一般的に太字で表示される

### \<img>、画像表示
`<img src =` "パス" `alt =`"ファイル名" `>`
* タグは単独で使用
* class属性(Bootstrap)：
  * "img-responsive center-block"：画面中央に表示
* src（source）属性：パスを指定する（画像がフォルダーにおいでの位置及び名前）
  * 同一階層の画像ファイルであれば、ファイル名を指定する
  * 階層が違う場合には、パス(絶対もしくは相対)で指定する
  * [パス](#パス)に「**絶対パス**」と「**相対パス**」がある
* alt（alternative text）属性：画像が表示できない場合に表示されるテキスト
  * 視覚障害者のためにスクリーンリーダーがこのテキストを読み上げるので、意味のある説明を入れるのが望ましい

```html
<img class="img-responsive center-block"　src="images/duke_mascot.png" alt="Duke">
<img src="images/duke_model.jpg" alt="Duke 3D">
```

#### パス
* ファイルパスとは、HTMLやCSS、画像などのファイルの場所を指定するためのもの
* webページのリンクや画像ファイルはパスで指定する

* 絶対パス：
  * ウェブ全体の中での「正確な場所」を指定するパスです。URL全体を指定するため、どこからアクセスしてもその場所にリンクできます。
    * `<a href="https://???/index.html">`こちらをクリック`</a>` の中の**完全なURL**のことを指す
* 相対パス：
  * 今のHTMLファイルが置かれている**位置**（フォルダ）を基準に、目的のファイルがどこにあるかを指定するパス
  * ページ間でのリンクや画像の参照を簡潔に行うことができます。
    * `<a href="about.html">Aboutページ`</a>`　⇒　**同じフォルダ**から指定
    * `<img src="images/pic.jpg" alt="写真"`>`　⇒　**サブフォルダ**にアクセス
    * `<a href="../index.html">トップページに戻る</a>　⇒　**親フォルダー**へ移動 

### \<a>、リンク
`<a href="">　</a>`  
* 別ページに移動するリンクを貼るためのタグ
* href属性：
  * 外部サイトへのリンクは絶対パスで指定し、サイト内リンクは基本的に相対パスで指定する
  * 【#見出しタイトル】を指定すると同ページの該見出しの位置に飛ぶ
  * 【#】のみを指定すると、該ページのトップ（一番上）まで飛ぶ
* target属性：
  * 省略すると**同ウィンドウ**で開く
  * "_blank"：**別ウィンドウ**で開く
* Bootstrap：
  * `<a class="btn btn-primary" herf="#">OK</a>`のような属性を付けると、青いボタンになる  
```html
<!-- 「OK」と書いてある青いボタンから、別ウィンドウでgoogleのページを開く -->
<a class="btn btn-primary" href="https://www.google.com/" target="_blank">OK</a>

<!-- 「こちら」と書いてある文字から、同ウィンドウで夏目漱石のwikiページを開く -->
詳しくは<a href="https://ja.wikipedia.org/wiki/%E5%A4%8F%E7%9B%AE%E6%BC%B1%E7%9F%B3">こちら</a>から

<!-- メール送信リンク -->
<a href="mailto:xxxxxx@xxxx.xx">お問い合わせ</a>

<!-- 画像にリンクを貼る -->
<a href="リンク先">
    <img src="画像パス" alt="説明文">
</a>
```

### \<ul>/\<ol>/\<li>、リスト
* \<ul>+\<li>：・との箇条書きや番号付きのリスト
* \<ol>+\<li>：1.との番号付きリスト
* <li>：リストの各項目
* Bootstrap関連の属性
  * class
    * "list-group"と"list-group-item"により・との箇条書きリストから表格にすることができる  
```html
<!-- 箇条書きリスト -->
<ul>
    <li>箇条書きアイテム１</li>
    <li>箇条書きアイテム２</li>
    <li>箇条書きアイテム３</li>
</ul>

<!-- 番号付きリスト -->
<ol>
    <li>番号付きアイテム１</li>
    <li>番号付きアイテム２</li>
    <li>番号付きアイテム３</li>
</ol>
<!-- Bootstrapでの応用、表格形式に表現する -->
<ul class="list-group">
  <li class="list-group-item">項目A</li>
  <li class="list-group-item">項目B</li>
  <li class="list-group-item">項目C</li>
</ul>
```

### ナビゲーションバー
* navbar-header
  * ナビゲーションバーの左側に配置され、主に**ブランド名**や**ロゴ**、およびモバイルでの**ナビゲーショントグルボタン**を含む
  * `<a class="navbar-brand">`でサイトやプロジェクトのブランド名を表示し、ホームページへのリンクを提供
  * **button**要素でナビゲーションを折りたたんだり展開したりするトグルボタン（3本線のアイコン）を提供
* collapse navbar-collapse
  * `id="navbar"`：トグルボタンで操作する対象として設定
  * ナビゲーションリンク（<ul>など）を含み、トグルボタンで展開・折りたたみ可能なエリアを指定
  * 展開・折りたたみ機能:
    * `class="collapse"`：デフォルトでは折りたたまれている状態(collapse：折りたたみ機能を有効にする)
    * `navbar-collapse`クラス：ナビゲーションバーのスタイルを適用
    * `data-target` 属性で指定されたID（ここでは`#navbar`）を操作対象にする
    * モバイルデバイスではトグルボタンをクリックすると、展開・折りたたみが切り替わる
  * ナビゲーションリンク配置:
    * `<ul class="nav navbar-nav">`内にリンクを定義し、ナビゲーションバーの右側または左側に配置  

```html
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Project Nyaan</a>
    </div>

    <div id="navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#list">List</a></li>
        <li><a href="">Table</a></li>
      </ul>
    </div>
  </div>
</nav>
```

### \<table>、テーブル
* `<table>` 表を示すタグ。表全体を囲む
  * border属性：枠線を指定する。0または表記ない場合はデフォルトで枠線なし
  * <tr>　</tr>見出しを含めた表の一行を囲む(Table row)
      * <th>　</th>見出しとなるセルを作成（なくても可）(Table Header)
      * <td>　</td>セルを作成（なくても可）(Table Data)
* Bootstrap  
```html
<table class="table table-striped" border="1>
    <thead>
        <tr>
            <th>#</th>
            <th>名前</th>
            <th>特徴</th>
            <th>住所</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>たま</td>
            <td>くつした</td>
                <td>東京都港区青山</td>
            </tr>
                <tr>
                  <td>2</td>
                  <td>ミケ</td>
                  <td>三毛</td>
                  <td>東京都千代田区秋葉原駅周辺</td>
                </tr>
                <tr>
            <td>3</td>
                  <td>トラ</td>
                  <td>シマ</td>
                  <td>兵庫県西宮市甲子園町</td>
                </tr>
                <tr>
                  <td>4</td>
                  <td>にゃあ</td>
                  <td>トラの兄弟</td>
                  <td>兵庫県西宮市甲子園町</td>
                </tr>
        </tbody>
</table>
```

#### テーブルの幅調整
```html
<style>
  table {
    width：100%; /* テーブル全体の幅を指定 */
  }
  tr {
    height：50px; /* 各行の高さを指定 */
  }
  th, td {
    width：150px; /* 各列の幅を指定 */
  }
</style>

<!-- 個別サイズ調整例(bodyにて)：-->
<tr style="height：50px;">
    <th style="width：150px;">見出し1</th> 
```

#### セルの結合 colspan、rowspan(改行br)
* colspan属性：結合する横の長さを指定
* rowspan属性：結合する縦の長さを指定（被られたコマは次のtr tdでの指定ではスキップされる）
```html
<table border="1">
    <tr>
        <th colspan="3">見出し１＋２＋３</th>
        <th>見出し４</th>
    </tr>
    <tr>
        <td rowspan="2">データ１－１<br>データ２－１</td>
        <td>データ１－２</td>
        <td>データ１－３</td>
        <td>データ１－４</td>
    </tr>
    <tr>
        <td>データ２－２</td>
        <td>データ２－３</td>
        <td>データ２－４</td>
    </tr>
</table>
```

#### 表作りの実例【数独】
CSS:
```html
<!-- type="text/css"：スタイルの種類を指定。通常は省略可能（デフォルトでtext/cssと解釈されるため）-->
<style type="text/css">
    <!-- border-collapse：collapse;テーブルセルの枠線（ボーダー）を重ねずに、1本の線として表示する -->
    <!-- border：solid thick;：テーブル全体に厚い（thick）実線（solid）の枠線を適用 -->
    table { border-collapse：collapse; border：solid thick; }

    <!-- <colgroup>（列グループ）と<tbody>（テーブル本体）要素に枠線を適用 -->
    <!-- border：solid medium;：中程度の太さ（medxium）の実線（solid）を枠線として設定 -->
    colgroup, tbody { border：solid medium; }

    <!-- <td>（テーブルデータセル）に適用するスタイルを定義 -->
    <!-- border：solid thin;：薄い（thin）実線の枠線を設定 -->
    <!-- height：1.4em;：セルの高さを1.4em（フォントサイズに比例）に設定 -->
    <!-- width：1.4em;：セルの幅を1.4emに設定 -->
    <!-- text-align：center;：セル内のテキストを中央揃えにする -->
    <!-- padding：0;：セル内の余白をなくす -->
    td { border：solid thin; height：1.4em; width：1.4em;
         text-align：center; padding：0; }
</style>
```
HTML:
```html
<table>
    <colgroup><col><col><col>
    <colgroup><col><col><col>
    <colgroup><col><col><col>
    <tbody>
        <tr> <td> 1 <td>   <td> 3 <td> 6 <td>   <td> 4 <td> 7 <td>   <td> 9
        <tr> <td>   <td> 2 <td>   <td>   <td> 9 <td>   <td>   <td> 1 <td>
        <tr> <td> 7 <td>   <td>   <td>   <td>   <td>   <td>   <td>   <td> 6
    <tbody>
        <tr> <td> 2 <td>   <td> 4 <td>   <td> 3 <td>   <td> 9 <td>   <td> 8
        <tr> <td>   <td>   <td>   <td>   <td>   <td>   <td>   <td>   <td>
        <tr> <td> 5 <td>   <td>   <td> 9 <td>   <td> 7 <td>   <td>   <td> 1
    <tbody>
        <tr> <td> 6 <td>   <td>   <td>   <td> 5 <td>   <td>   <td>   <td> 2
        <tr> <td>   <td>   <td>   <td>   <td> 7 <td>   <td>   <td>   <td>
        <tr> <td> 9 <td>   <td>   <td> 8 <td>   <td> 2 <td>   <td>   <td> 5
</table>
```

### \<form>、フォーム
* テキスト入力欄やボタンなどの部品を組み合わせてフォームを作成し、使用する部品は\<form>タグで囲んで配置する
* なお、\<form>は入力・送信フォームを作成する際に使用する要素だが、実際にデータを受け渡しする処理はJavaサーブレットやPHPなどのプログラムと連携して動作する
* \<from>:
  * action属性: "#"。データの送信先ページを指定する。またはデータの送信時に呼び出すプログラムを指定する
  * method属性: "post"。呼び出し方式（データの転送方法）を指定する(get/post)
・・get：データをURLの一部として送信する（?page=3のような内容）
・・post：URLとは別にデータを送信する（パスワードなどのデータを取り扱う際はこっちを使おう）
  * name属性: フォームの名前を指定する
  * \<label>: 入力欄の隣の見出し。フォーム部品と関連付けることができ、ラベルを含めた項目全体がクリック対象になる。（基本的にはすべてのフォーム要素にラベルを貼ることができる）
    * 関連付けするフォーム部品のidを指定するためにはfor属性を使用する ※**対象部品はid属性で識別名を宣言する**
    * 同じ名前のラベルがある場合、最初に設定された同名前のラベルに飛ぶ
    * class属性: "col-sm-2 control-label"などを掛けてフォームラベルの広さを指定（Bootstrap）
    * for属性: "comment_1"
  * **\<input>**: 入力用のテキストボックス
    * type属性: "text"。テキストボックス
      * "password": パスワード（*で表示する）
      * "hieddn": 隠しデータをサーバに送信する際に使用
      * "search": 検索条件テキスト
      * "emil": メールアドレス
      * "tel": 電話番号
      * "url": WebサイトのURL
      * "submit": 提出
        * value属性：ボタンに表示するテキスト（表）
        * name属性：ボタンの名前（裏）
```html
<!-- ①文字ボタン： -->
<input type="submit" value="送信">
<!-- ②画像ボタン： -->
<input type="image" name="{名前}" src="{パス}" alt="{代替テキスト}">
<input type="image" src="button.png" alt="送信">　<!-- イメージ自体が送信ボタンとみなす -->
```
* \<from>:
  * **\<input>**: 入力用のテキストボックス
    * type属性: "text"。テキストボックス
      * "radio": ラジオボタン。複数ある選択肢から１つの項目のみ選択することができる
      * "checkbox": チェックボックス。複数ある選択肢から複数の項目を選択することができる
        * name属性: 選択肢のグループ名。同一グループ内では１つだけ選択可能
        * value属性：送信される選択肢の値（value="いぬ"→いぬ）
        * checked属性：デフォルトの状態を選択済みの状態に指定（checked="checked"→最小化表記でcheckedのみを書く）
        * ラベル例①：`<input type="checkbox" name="hobby" id="h_01" value="sports"><label for="h_01"> スポーツ</label>`
        * ラベル例②：`<label><input type="checkbox" name="hobby"    value="sports"> スポーツ</label> `
    * placeholder属性: 入力ヒント
    * size属性：空欄の長さ（input()に対応）
    * name属性: "comment"。フォームのデータ送信する時の、データの名前
    * id属性: "title"。ラベルと入力欄はセットになっているため、ラベルのfor属性とinputタグのidには同じ値を設定する
  * \<select>: プルダウンメニュー、またの名はセレクトボックス
    * name属性：該セレクトボックスの名前（裏）
    * multiple属性：\[Shift]または\[Ctrl]キーで複数項目を選択可能になる
    * \<option>:
      * value属性：送信される選択肢の値を指定
      * selected属性：デフォルトで選択済状態にする
  * \<button>: 送信ボタン
    * type属性: "submit"。入力データの送信ボタン
  * \<textarea>: テキストエリア。複数行のテキストを入力するテキスト欄
    * rows属性：デフォ表示行数を指定
    * placeholder属性：入力ヒント
    * 初期値入れておく：`<textarea name="message">メッセージ初期値</textarea>`
    * ヒント内容：`<textarea name="message" placeholder="メッセージを入力"></textarea>`
* Bootstrap
  * class="from-group":
    * フォーム要素（ラベルや入力フィールド）をグループ化するためのクラス
    * 余白や配置が適切に調整され、フォーム全体の見た目を整える
    * divタグに付ける
  * class="form-contral":
    * テキスト入力フィールド、テキストエリア、セレクトボックスなどに付けるクラスで、フォーム要素の見た目を一貫性のあるスタイルに整える
    * inputタグに付ける
```html
<form action="送信先ページ" method="輸送方法(get/post)" name="テストフォーム">
    <!-- ここにフォームの部品を記述 -->
</from> 

<!-- 送信ボタンの設置 -->
<form action="#" method="post">
    <label for="comment_1">コメント</label>
    <input type="text" name="comment">
	<button type="submit">送信する</button>
</form>

<!-- Bootstap -->
<form action="#" method="post">
  <div class="form-group">
    <label for="title">タイトル</label>
    <input type="text" class="form-control" name="title" id="title">
  </div>
  <button type="submit">OK</button>
</form>
```

#### paizaの実例
[参照先](https://paiza.jp/works/html/primer/beginner-html3/11025)
```html
<!DOCTYPE html>
<html lang="ja">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Project Nyaan</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

	<style>
		body {
			padding-top: 50px;
			background-color: lightgray;
		}

		.starter-template {
			padding: 40px 15px;
			background-color: white;
		}
	</style>
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Project Nyaan</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#list">List</a></li>
					<li><a href="#table">Table</a></li>
					<li><a href="#form">Form</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
		<div class="starter-template">
			<h1>吾輩は猫である。</h1>
			<p class="lead">名前はまだない。</p>
			<img src="写真パス" class="img-responsive center-block">
			<p>どこで生れたかとんと見当がつかぬ。何でも薄暗いじめじめした所でニャーニャー泣いていた事だけは記憶している。吾輩はここで始めて人間というものを見た。しかもあとで聞くとそれは書生という人間中で一番獰悪な種族であったそうだ。この書生というのは時々我々を捕えて煮て食うという話である。しかしその当時は何という考もなかったから別段恐しいとも思わなかった。ただ彼の掌に載せられてスーと持ち上げられた時何だかフワフワした感じがあったばかりである。
			</p>

			<h2 id="list">動物リスト</h2>
			<ul class="list-group">
				<li class="list-group-item">ねこ</li>
				<li class="list-group-item">いぬ</li>
				<li class="list-group-item">うさぎ</li>
			</ul>

			<h2 id="table">猫テーブル</h2>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>名前</th>
						<th>特徴</th>
						<th>住所</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>たま</td>
						<td>くつ下</td>
						<td>東京都港区南青山</td>
					</tr>
					<tr>
						<td>2</td>
						<td>ミケ</td>
						<td>三毛</td>
						<td>東京都千代田区秋葉原駅周辺</td>
					</tr>
					<tr>
						<td>3</td>
						<td>トラ</td>
						<td>シマ</td>
						<td>兵庫県西宮市甲子園町</td>
					</tr>
					<tr>
						<td>4</td>
						<td>にゃあ</td>
						<td>トラの兄弟</td>
						<td>兵庫県西宮市甲子園町</td>
					</tr>
				</tbody>
			</table>

			<h2 id="form">猫フォーム</h2>
			<form class="form-horizontal" action="#" method="post">
				<div class="form-group">
					<label class="col-sm-2 control-label" for="title">タイトル</label>
					<div class="col-sm-10">
					    <input type="text" class="form-control" name="comment" id="title">
				    </div>
				</div>
            	<div class="form-group">
            		<label class="col-sm-2 control-label" for="message">メッセージ</label>
            		<div class="col-sm-10">
            			<textarea class="form-control" rows="3"></textarea>
            		</div>
            	</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"for="select">好みのネコ</label>
					<div class="col-sm-10">
    					<select class="form-control" name="select" id="select">
    					  <option>タマ</option>
    					  <option>ミケ</option>
    					  <option>トラ</option>
    					</select>
    				</div>
				</div>
				<div class="form-group">
		            <div class="col-sm-offset-2 col-sm-10">
			            <button type="submit">OK</button>
            		</div>
            	</div>
            </form>

			<hr>
			<a class="btn btn-primary" href="#">Topに戻る</a>
		</div>
	</div>
	<!-- /.container -->

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>

</html>
```

### その他部品
#### \<link>、外部のCSSファイルやフォントをHTMLにリンクする
* rel属性: `rel="stylesheet"`はリンク先がスタイルシートであることをす
* href属性: パス  
```html
<!-- CSSファイルを読み込む -->
<link rel="stylesheet" href="styles.css">
```

#### \<blockquote>、引用文
引用元を示したい場合は<cite>を併用する  
<blockquote>
  「人は城、人は石垣、人は堀。」
</blockquote>

```html
<blockquote>
  「人は城、人は石垣、人は堀。」
</blockquote>
```

#### \<small>、著作権表記や法的表記
```html
<small>© 2025 Your Company Name. All rights reserved.</small>
```

#### \<span>、意味を持たないインライン要素
インライン要素で、特定の部分だけスタイルを適用する  
CSSで一部分のみ装飾するときに使用する  
```html
<p>この<span style="color: red;">部分</span>だけ赤くなります。</p>
```

#### \<audio>、音声データを埋め込むために使用する
```html
<audio controls>
  <source src="audio.mp3" type="audio/mpeg">
  このブラウザは音声データの再生をサポートしていません。
</audio>
```
#### \<video>、動画データを埋め込むために使用する
```html
<video controls width="320" height="240">
  <source src="video.mp4" type="video/mp4">
  このブラウザは動画データの再生をサポートしていません。
</video>
```

#### \<script>、スクリプトデータの埋め込みや参照で使用する(Javascriptなど)
```html
<script src="script.js"></script>
```

### グループ分け用ブロック要素
#### \<header>、ページ上部のヘッダ要素
ロゴやページタイトル、ナビゲーションメニューなどを含むことが多い
```html
<header>
  <h1>ウェブサイトのタイトル</h1>
  <nav>
    <ul>
      <li><a href="#home">ホーム</a></li>
      <li><a href="#about">概要</a></li>
    </ul>
  </nav>
</header>
```

#### \<nav>、メインのナビゲーションメニュー
```html
<nav>
  <ul>
    <li><a href="#home">ホーム</a></li>
    <li><a href="#services">サービス</a></li>
    <li><a href="#contact">お問い合わせ</a></li>
  </ul>
</nav>
```

#### \<article>、独立した記事やブログ投稿
* ページ内の記事となる部分
* それだけで独立したページとして成り立つような内容

```html
<article>
  <h2>記事タイトル</h2>
  <p>この記事はウェブ開発に関するものです。</p>
</article>
```

#### \<section>、1つのテーマに基づいたグループ化
```html
<section>
  <h2>会社情報</h2>
  <p>私たちの会社は...。</p>
</section>
```

#### \<main>、ページのメインコンテンツ部分
```html
<main>
  <h1>ウェブ開発とは？</h1>
  <p>このページではウェブ開発の基本を解説します。</p>
</main>
```

#### \<aside>、補足情報や関連リンク
* 本文ではない補足情報
* メインコンテンツとの関連性が低い情報を扱う

```html
<aside>
  <h3>関連リンク</h3>
  <ul>
    <li><a href="#link1">リンク1</a></li>
  </ul>
</aside>
```

#### \<footer>、ページ下部のフッタ要素
コピーライトやSNSリンクなどを含むことが多い
```html
<footer>
  <p>© 2025 Your Company Name.</p>
</footer>
```

#### \<div>、意味を持たないブロック要素
```html
<div class="container">
  <p>コンテンツをグループ化します。</p>
</div>
```
