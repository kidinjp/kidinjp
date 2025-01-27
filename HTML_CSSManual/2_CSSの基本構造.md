概念
* [CSSの基本構造](#cssの基本構造)
* [プロパティ](#プロパティ)
  * [padding、要素内側の余白](#padding要素内側の余白)
  * [margin、要素の外側の余白](#margin要素の外側の余白)
  * [色指定](#色指定)
  * [フォント指定](#フォント指定)
  * [テーブルの幅調整](#テーブルの幅調整)
  * [枠線](#枠線)
* [レスポンシブデザイン](#レスポンシブデザイン)
* [グリッドシステム](#グリッドシステム)

***************************************************************************
## CSSの基本構造
* おすすめサイト：
  * [神サイト](https://www.osaka-kyoiku.ac.jp/~joho/html5_ref/css/padding_css.php)
  * [カラーピッカー](https://paiza-webapp.s3.amazonaws.com/files/learning/color-slider.html)
* 主な目的: サイズ、色、フォント、余白、レイアウトなどのスタイルを指定
* HTMLファイル+CSSファイルで組み合わせてWebページを表示する
* `<head>`タグ内で、適用するCSSファイルを指定する
  * 例：`<link rel="stylesheet" href="your_style.css">`
* HTMLファイルの中でCSS指定する場合、`<head>`タグ内で`<style>`タグを指定する
* CSSの書式：
  * スタイルの適用対象を**セレクタ**として指定(例 body)
  * 波カッコの中に、**プロパティ**と設定値をコロンで区切って記述する(例 padding)
  * 各プロパティの行の末尾に**セミコロン**を書く
  * px:ピクセル  
```css
<head>
	<meta charset="utf-8">
	<title>Project Nyaan</title>
    <style>
        body { <!-- bodyをセレクタとして指定 -->
            padding: 30px; <!-- padding(余白)をプロパティとして指定 -->
        }
    </style>
</head>
```

## プロパティ
### padding、要素内側の余白
padding: 30px;

### margin、要素の外側の余白
margin: 30px;

### 色指定
* **#rrggbb** か**代表色**で指定する必要がある（例: #C6A4E7）
* 基本指定するエリア：
  * color、文字の色
  * background-color、背景色
  * border-color、境界色
  * outline-color、輪郭色
  * 使用例：`color: #C6A4E7;`

【スタイルで固定パターンの指定方法と代表色名】
```html
    <style type="text/css" media="screen, handheld, print, tv" >
      .color0 {
          color: #000000; } /* black */
      .color1 {
          color: #ff0000; } /* red */
      .color2 {
          color: #00ff00; } /* lime */
      .color3 {
          color: #0000ff; } /* blue */
      .color4 {
          color: #00cc00; } /* lightgreen */
      .color5 {
          color: #ff6600; } /* orange */
      .color6 {
          color: #ff00ff; } /* fuchsia */
      .color7 {
          color: #ccffff; } /* lightblue */
      .color8 {
          color: #ffffff; } /* white */
      .color9 {
          color: #000099; } /* darkblue */
</style>
```
【body内でオリジナルパターンの応用html】
```html
    <span class="color0;">黒色：black</span>
    <br><span class="color1">赤色：red</span>
    <br><span class="color2">ライム色：lime</span>
    <br><span class="color3">青色：blue</span>
    <br><span class="color4">明るい緑色：lightgreen</span>
    <br><span class="color5">オレンジ色：orange</span>
    <br><span class="color6">赤紫色：fuchsia</span>
    <br><span class="color7">水色：lightblue</span>
    <br><span class="color8" style="background-color:#000000;">
                             白色：white</span>
    <br><span class="color9">暗い青色：darkblue</span>
```

### フォント指定
* `font-weight: bold;`、太字。基本\<strong>\</strong>の使用を推奨する
* `font-size: 120%;`、文字の大きさ、pxまたは%(%は相対的の大きさのため、端末違いの弊害的に推奨する)
* `font-family: serif;`、字体（デフォはゴシック体(サンセリフ)が多い。serif：明朝体）

### テーブルの幅調整
```html
<style>
  table {
    width: 100%; /* テーブル全体の幅を指定 */
  }
  tr {
    height: 50px; /* 各行の高さを指定 */
  }
  th, td {
    width: 150px; /* 各列の幅を指定 */
  }
</style>
```

* 個別サイズ調整例：
  * `<tr style="height: 50px;">`
  *  `<th style="width: 150px;">見出し1</th>`

### 枠線
* border
* border-top
* border-bottom
* border-left
* border-right
  * 値：border-style border-width("thin"，"medium"，"thick") border-color

| スタイル | 説明 |
| --- | --- |
| none | 境界なし（他指定あれば他優先） |
| hidden | 非表示（他指定あれば非表示優先） |
| solid | 実線 |
| dashed | 破線 |
| dotted | 点線 |
| double | 2重線 |
| groove | 立体的にへこんで見える線 |
| ridge | 立体的に飛び出して見える線 |
| inset | 内部が立体的にへこんで見える線 |
| outset | 内部が立体的に飛び出して見える線 |

## レスポンシブデザイン
* **レスポンシブデザイン**とは、スマホやタブレット・PCなどサイズが異なるディスプレイでも、単一のHTMLファイルで、最適なデザインで表示する技術
* 縦持ちで細長いディスプレイのスマホと、大きな画面のPCでは、最適なレイアウトが違っている
* レスポンシブデザインでは、これを単一のHTMLで自動的に表示し分ける
* `<div>`とコンテナを使う
* `<div class="container">`...\</div>

```html
<!-- レスポンシブデザイン -->
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
    <div class="container">
		<div class="starter-template">
        	<h1>吾輩は猫である。</h1>
        	<p class="lead">名前はまだない。</p>
        	<p>どこで生れたかとんと見当がつかぬ。何でも薄暗いじめじめした所でニャーニャー泣いていた事だけは記憶している。吾輩はここで始めて人間というものを見た。しかもあとで聞くとそれは書生という人間中で一番獰悪な種族であったそうだ。</p>
        	<a class="btn btn-primary" href="#">OK</a>
        </div>
    </div>
    
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>

</html>
```

### \<div class="jumbotron">、
* **視覚的な強調**: ジャンボトロンは、重要なメッセージや特別なコンテンツを目立たせるために使用されている。通常、ページの最上部に配置されることが多い
* タイトルや説明文: 主に大きな見出しやサブタイトル、説明文を含むことが多い
* スタイル:
  * パディング: 自動的に十分なパディングが与えられ、コンテンツが周囲から浮き上がるように見えるデザインが施されている
  * 背景色: 通常、**明るい背景色**（例えば、ライトグレーやホワイト）で、内容を強調するデザインになっている
  * 影: コンテンツが立体的に見えるように、ボックスシャドウが適用されることもある
* レスポンシブ:
  * Bootstrapの特徴であるレスポンシブデザインにより、jumbotronは様々な画面サイズに適応し、適切に表示される

## グリッドシステム
* 行(row)と列(column/ col)で管理する
* 一行は12グリッドとなる
* `<div class="row">`　⇒　行、指定すると同じ行となる範囲を囲む
*     `<div class="col-sm-12">`　⇒　列、同列にある内容を比例で分ける（画面が狭い場合結局1カラムとなる）  
```html
<!-- Bootstrapのグリッドシステム -->
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
	<div class="container">
		<div class="starter-template">
		    <div class="row">
		        <div class="col-sm-12">
		            <div class="jumbotron">
            			<h1>吾輩は猫である。</h1>
            			<p class="lead">名前はまだない。</p>
            			<a class="btn btn-primary" href="#">OK</a>
        			</div>
    			</div>
			</div>
		    <div class="row">
		        <div class="col-sm-4">
        			<h2>どこで生れたか</h2>
        			<p>とんと見当がつかぬ。何でも薄暗いじめじめした所でニャーニャー泣いていた事だけは記憶している。吾輩はここで始めて人間というものを見た。しかもあとで聞くとそれは書生という人間中で一番獰悪な種族であったそうだ。</p>
    			</div>
		        <div class="col-sm-4"> 
        			<h2>この書生というのは</h2>
        			<p>時々我々を捕えて煮て食うという話である。しかしその当時は何という考もなかったから別段恐しいとも思わなかった。ただ彼の掌に載せられてスーと持ち上げられた時何だかフワフワした感じがあったばかりである。書生の顔を見たのがいわゆる人間というものの見始であろう。</p>
    			</div>
		        <div class="col-sm-4">
        			<h2>掌の上で少し落ちついて</h2>
        			<p>書生の顔を見たのがいわゆる人間というものの見始であろう。この時妙なものだと思った感じが今でも残っている。第一毛をもって装飾されべきはずの顔がつるつるしてまるで薬缶だ。</p>
    			</div>
			</div>
		</div>
	</div>
	<!-- /.container -->

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>

</html>
```
