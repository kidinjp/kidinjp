概念
* [CSSの基本構造](#cssの基本構造)
  * [vendor prefixes、ベンダープレフィックス](#vendor_prefixesベンダープレフィックス)
* [セレクター](#セレクター)
  * [A B {}、子孫セレクター](#a-b-子孫セレクター)
  * [A > B {}、直接の子要素セレクター](#a--b-直接の子要素セレクター)
  * [A + B {}、隣接セレクター](#a--b-隣接セレクター)
  * [A\[C\] {}、属性セレクター](#ac-属性セレクター)
  * [.class名前 {}、クラスセレクター](#class名前-クラスセレクター)
  * [\#id名前 {}、IDセレクター](#id名前-idセレクター)
  * [A:... {}、疑似セレクター](#a-疑似セレクター)
* [プロパティ](#プロパティ)
  * [padding、要素内側の余白](#padding要素内側の余白)
  * [margin、要素の外側の余白](#margin要素の外側の余白)
  * [width・height、要素の幅・高さ指定](#widthheight要素の幅高さ指定)
  * [color、色指定](#color色指定)
  * [font、フォント指定](#fontフォント指定)
  * [text、テキスト指定](#textテキスト指定)
  * [border、枠線指定](#border枠線指定)
  * [テーブルの幅調整](#テーブルの幅調整)
  * [display、要素の表示形式](#display要素の表示形式)
  * [background、背景](#background背景)
  * [position、位置](#position位置)
  * [transition、効果、時間的変化](#transition効果時間的変化)
  * [transform、@keyframes、アニメーションなどの要素変形](#transformkeyframesアニメーションなどの要素変形)
  * [object、画像の切り抜き](#object画像の切り抜き)
  * [その他の指定](#その他の指定)
    * [影効果の指定](#影効果の指定)
    * [リストスタイル](#リストスタイル)
    * [スクロール](#スクロール)
    * [z軸により深さの設定](#z軸により深さの設定)
    * [content、画像・映像の差し込み](#content画像映像の差し込み)
    * [jumbotron、強調](#jumbotron強調)
* [グリッドシステム](#グリッドシステム)
  * [グリッドレイアウト設定](#グリッドレイアウト設定)
  * [グリッドシステム_Bootstrap](#グリッドシステム_bootstrap)
* [ハンバーガーメニュー](#ハンバーガーメニュー)
  * [ハンバーガーメニューの基本HTMLやCSS](#ハンバーガーメニューの基本htmlやcss)
  * [ハンバーガーメニュー_Bootstrap](#ハンバーガーメニュー_bootstrap)

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

### vendor prefixes、ベンダープレフィックス
* ベンダー接頭辞
* 試験的、開発段階または非標準な CSS プロパティおよび JavaScript API に接頭辞を追加することがある  
* ブラウザによって、反映状態が違ってくる場合がある
* 主流は`-webkit-`と`-moz-`を指定しておく
* 書き方：
  1. `接頭辞 プロパティ;`
  2. `実際に該標準プロパティを定義する`

【CSSの主な接頭辞】
* `-webkit-`：
  * Chrome
  * Safari
  * 新しいバージョンの Opera
  * ほぼすべての iOS ブラウザー (Firefox for iOS を含む)
  * 基本的に WebKit ベースのブラウザーすべて
* `-moz-`：**Firefox**
* `-o-`：WebKit 導入前の古い Opera
* `-ms-`：Internet Explorer と **Microsoft Edge**  

```css
/* background-clipを利用しよう */
-webkit-background-clip: text;
-moz-background-clip: text;
background-clip: text;
```

## セレクター
CSSファイルでは、適用したいスタイルをHTML内のタグを名指しで選択する  
```css
タグ名 {
  プロパティ: 値;
} 

<!-- 複数の対象を同時に選択する場合は , で隔てる -->
タグA, タグB {
  プロパティ: 値;
} 
```

なお、CSSは記述の順番で適用するスタイルを上書きしていくが、セレクターの詳細度も大事な指標となる  
* 優先順位
  1. 詳細度（Specificity）、最も影響が大きい
  2. 記述の順番、後に書いたものが上書き
  3. `!important`の有無、ついてる場合すべてのルールより優先される

【優先度の計算ルール】
| セレクターの種類 | 点数（優先度） |
| --- | --- |
| `!important` | 最優先（無視できない） |
| インラインスタイル（`style="..."`）<br>直接にhtmlに指定されたスタイル | 1000 |
| IDセレクター<br>`#id` | 100 |
| クラス・属性・疑似クラス<br>`.class`・`[attr]`・`:hover` | 10 |
| 要素・疑似要素<br>`div`・`p`・`::before` | 1 |

```css
/* <p class="text">テキスト</p> */
/* 1番目 */
.text {
  color: red;
}

/* 2番目 */
p {
  color: blue;
}

/* 2番目の方が新しく書いたが、1番目のセレクターの方が優先度が高いため red が適用される */
```
以降の説明にて、`<A><B><C></C></B></A>`のようなタグで説明する

### A B {}、子孫セレクター
ネストされた要素全てに適用（BやCも）

### A > B {}、直接の子要素セレクター
A の直下の B にのみ適用される
```html
<div>
  <p>青色のテキスト</p>  <!-- 直接の子要素なので適用 -->
  <section>
    <p>これは適用されない</p>  <!-- divの「孫」なので適用されない -->
  </section>
</div>
```

### A + B {}、隣接セレクター
Aのすぐ後ろにあるBに適用される
```html
<h1>見出し</h1>
<p>緑色になる</p>  <!-- h1の直後なので適用 -->
<p>これは適用されない</p>  <!-- h1の直後ではない -->
```

### A\[C] {}、属性セレクター
A で指定したタグの中で、特定の属性を持つものに適用される
```css
input[type="text"] {
  border: 2px solid blue;
}
```

```html
<input type="text" placeholder="青枠になる">
<input type="password" placeholder="適用されない">
```

### .class名前 {}、クラスセレクター
クラス名が一致する要素に適用される
```css
.red-text {
  color: red;
}
```

```html
<p class="red-text">赤色のテキスト</p>
<p>これは適用されない</p>
```

### \#id名前 {}、IDセレクター
```css
#main-title {
  font-size: 32px;
}
```

```html
<h1 id="main-title">大きなタイトル</h1>
<h1>これは適用されない</h1>
```

### A:... {}、疑似セレクター
* ユーザーの操作に反応する疑似クラス
  * `:hover`：マウスを乗せたとき
  * `:focus`：フォーカスが当たったとき（入力欄クリックなど）
  * `:active`：クリック（押している間）
  * `:visited`：訪問済みのリンク
  * `:link`：未訪問のリンク
* 要素の状態に関する疑似クラス
  * `:checked`：チェックされた（ラジオボタンやチェックボックス）
  * `:disabled`：無効化された（disabled 属性）
  * `:enabled`：有効化された
  * `:required`：必須の入力フィールド
  * `:optional`：任意入力のフィールド
  * `:read-only`：読み取り専用（readonly の要素）
  * `:read-write`：編集可能な要素
* 位置を指定する疑似クラス
  * `:first-child`：最初の子要素
  * `:last-child`：最後の子要素
  * `:nth-child(n)`：n番目の子要素
  * `:nth-last-child(n)`：後ろからn番目の子要素
  * `:only-child`：その親の唯一の子要素
  * `:first-of-type`：指定されたタイプの最初の要素
  * `:last-of-type`：指定されたタイプの最後の要素
  * `:nth-of-type(n)`：指定されたタイプの n 番目の要素
  * `:nth-last-of-type(n)`：指定されたタイプの後ろから n 番目の要素
  * `:only-of-type`：親の中で唯一のそのタイプの要素
* UI 要素に使える疑似クラス
  * `:empty`：中身がない要素
  * `:not(条件)`：ある条件に当てはまらない要素
  * `:has(条件)`：子要素に特定のものを含む要素（CSS4）
* その他
  * `:root`：html 要素（最上位要素）
  * `::before`：要素の前にコンテンツを追加(contentと併せて使う)
  * `::after`：要素の後にコンテンツを追加(contentと併せて使う)

## プロパティ
### padding、要素内側の余白
* `padding: 30px;`
* 同時に4つの辺に対して指定することが可能（時計回り）
  1. 値を1つ指定：上の値 （右の値＝下の値＝左の値＝上の値）
  2. 値を2つ指定：上の値、右の値（下の値＝上の値、左の値＝右の値）
  3. 値を3つ指定：上の値、右の値、下の値 （左の値＝右の値）
  4. 値を4つ指定：上の値、右の値、下の値、左の値
* **インライン要素の【上下】に対して設定できない**

### margin、要素の外側の余白
* `margin: 30px;`
* 同時に4つの辺に対して指定することが可能（時計回り）（padding同様）
* autoを掛けることも可。余白が自動調整される
  * 例：`margin: 30px auto;`　⇒　中央揃え（左右が同じように調整される）
* 隣接同士で上要素に`margin-bottom:20px;`、下要素に`margin-top:50px;`の場合、**合計ではなく最大値（50px）を取る**
* **インライン要素の【上下】に対して設定できない**

### width・height、要素の幅・高さ指定
* `width`：：コンテンツの幅制限を設ける。px数値または%
* `height`：コンテンツの高さ制限を設ける。px数値または%
* `max-width`：：コンテンツの幅制限を設ける。px数値または%
* `max-height`：コンテンツの高さ制限を設ける。px数値または%
  * 親要素の幅/高さより**大きくならない**。body直下の場合ブラウザの幅に収まるなど
  * 画像が小さい場合は**拡大されない**
* `min-width`：：コンテンツの幅制限を設ける。px数値または%
* `min-height`：コンテンツの高さ制限を設ける。px数値または%
  * 親要素の幅/高さより**小さくならない**。最低でも親要素と同じ幅を持つ
  * 画像が大きい場合は**縮小されない**（オーバーフローする可能性がある）
* **インライン要素に対して設定できない**

### color、色指定
* **#rrggbb** か **rgba(r, g, b, a)** もしくは **代表色**で指定する必要がある
  * 例1: `#C6A4E7`。16進数で表現
  * 例2: `rgba(0, 255, 255, 0.7)`。10進数(0~255)で透明度0.7=70％で表現
* 基本指定するエリア：
  * `color`、文字の色
  * `background-color`、背景色
  * `border-color`、境界色
  * `outline-color`、輪郭色
  * 使用例：`color: #C6A4E7;`
  * 使用例：`color: transparent;`：色を透明にする（リセット）

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

### font、フォント指定
* `font-weight: bold;`、太字。基本\<strong>\</strong>の使用を推奨する
  * 400 ⇒ normal
  * 700 ⇒ bold
* `font-size: 120%;`、文字の大きさ、largeまたはpxまたは%で指定(キーワードや%は相対的の大きさのため、端末違いの弊害的に推奨する)
* `font-family: serif;`、字体（デフォルトはゴシック体(サンセリフ)が多い。serif：明朝体）
  * 例：`font-family: 'Verdana','Hiragino Sans','Meiryo',sans-serif;`
  * 優先順位は左から右へ
  * 'Verdana'：英語フォント
  * 'Hiragino Sans'：ヒラギノ角ゴシック
  * 'Meiryo'：メイリオ（日本語フォント）
  * sans-serif：汎用フォントファミリー、ゴシップ体
* `line-height: 1.6;`：文章毎行の高さを1.6倍に（デフォルトは1.2）
* `letter-spacing: .05em;`：文字の間隔を指定する（基本0.04~0.12emが安牌）1em=文字の高さ
* `vertical-align`：テキストの揃え方
  * 例：`input[type="radio"] {vertical-align: baseline;}`：選択肢の位置を調整する
  * `baseline`：文字の基準線に揃う
  * `middle`：親要素の高さの中央に揃う
  * `top`：親要素の一番上に揃う
  * `bottom`：親要素の一番下に揃う

### text、テキスト指定
* `text-align`：align(整列する)
  * `left`：左揃え
  * `right`：右揃え
  * `center`：中央揃え
  * `justify`：両端揃え（正当化するの意味）
* `text-decoration`：主に`:hover`などの疑似セレクターと併用する
  * `text-decoration:`位置 スタイル 色 太さ
    * 位置：underline、overline（上線）、line-through（打ち消し線）
    * スタイル：solid、double、dotted（点線）、dashed（破線）、wavy（波線）  
* `text-transform:`：英文字を大文字または小文字にする
  * uppercase：全文字を大文字にする
  * lowercase：全文字を小文字にする
  * capitalize：頭文字だけを大文字にする
  * ウェブアクセシビリティ的に、HTMLでの大文字の並びに対しては**一文字ずつ読まれる**がCSSからの調整だと**単語として**読み上げる

```css
a:hover {
  text-decoration: underline double;
}
```
* テキストではないが、文字の色や前景の線の色を指定したい場合は`color`のみで指定する

### border、枠線指定
* `border`：太さ、スタイル、色を簡潔に指定することが可能
  * 例：`border: 3px solid #ffffff;`
* `border-style`：スタイル（詳細は下記の表にて）
* `border-top`：上の枠線
* `border-bottom`：下の枠線
* `border-left`：左の枠線
* `border-right`：右の枠線
  * 値：`border-style` `border-width`("thin"，"medium"，"thick") `border-color`
* `border-radius`:コーナーを`radius`（半径）指定したpx数の円に調整する。アイコンの場合50%が多い
  1. 値を1つ指定：左上（右上＝右下＝左下＝左上）
  2. 値を2つ指定：左上、右上（右下＝左上、左下＝右上）
  3. 値を3つ指定：左上、右上、右下（左下＝右上）
  4. 値を4つ指定：左上、右上、右下、左下

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

### filter、フィルター
* 透明度、飽和度、 コントラストのフィルターを掛ける
* `filter: 効果(数値);`
  * 効果：
    * brightness：明るさ調整。大きいほど明るい
    * drop-shadow：drop-shadow(オフセットX オフセットY ぼかし 色)、影をつける
      * 例：`drop-shadow(5px 5px 10px rgba(0, 0, 0, 0.5));`。右下にぼやけた黒い影をつける
      * [影効果の指定](#影効果の指定)との比較
    * blur：単位px。ぼかし。大きいほどぼかしが強くなる
    * grayscale：グレースケール、モノクロ化。100%は完全なモノクロ
    * sepia：セピア調（古い写真のような茶色っぽい色）にする
    * saturate：彩度調整
      * `0%`⇒**完全に白黒になる**。`100%`⇒**変化なし**、`200%`⇒**彩度2倍、より鮮やかに**
    * contrast：コントラスト調整（明暗差）
      * `0%`⇒**コントラストなし。グレー**。`100%`⇒**変化なし**、`200%`⇒**コントラスト2倍、より明るく**
  * 数値は基本%で記述するのが推奨

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
  * `<th style="width: 150px;">見出し1</th>`

### display、要素の表示形式
* `display: block`：ブロック要素として扱う
  * 横幅いっぱいに広がる（width: 100% と同じ挙動）
  * width・height・margin・padding が適用できる
  * 自動的に改行される（次の要素は次の行に配置される）
  * 活躍する場面：レイアウトの大枠（コンテナ・セクション）
* `display: inline`：インライン要素として扱う
  * 横幅は内容の長さに応じる（width・height は指定できない）
  * margin・padding は 左右のみ適用可能（上下は効かない）
  * 自動的に改行されない（横並びになる）
  * 活躍する場面：文章の一部を強調したい
* `display: inline-block`：ブロック要素とインライン要素、両方の特性を併せ持つ
  * インライン要素のように横並びになる
  * ブロック要素のように width や height を指定できる
  * margin・padding は上下左右に適用できる
  * 活躍する場面：ボタンやメニューなど、サイズ調整しつつ横並びにしたい
* `display: none;`：該内容を生成しない
  * 例：`<br class=".onlySP">` ⇒ `.onlySP {display: none;}`にすると改行されなくなる。戻すは`block`など
* `display: grid`：[詳細](#グリッドレイアウト設定)

| 種類         | 横幅指定        | 高さ指定 | 自動改行 | 横並び配置 |
| ------------ | -------------- | ------ | -------- | ------------- |
| block        | **可**         | **可** | あり     | X（改行される） |
| inline       | X（内容の長さ） | X      | **なし** | **O（横並び）** |
| inline-block | **可**         | **可** | **なし** | **O（横並び）** |

* `display: flex;`：親要素に指定すると、子要素をフレックスアイテムとして扱うようになる
  * 横方向（主軸: row） に並ぶ
  * 子要素は 自動で均等に配置される
* 親要素への指定：
* `flex-wrap`（折り返し設定）
  * 子要素の合計幅が親要素より大きい場合、折り返すかどうかを決める
  * `nowrap`：（デフォルト）折り返さず、1行に詰め込む(123456(枠からはみ出し))
  * `wrap`：必要に応じて折り返す(1234-56)
  * `wrap-reverse`：折り返し方向を逆にする(56-1234)
* `justify-content`（主軸の揃え方）
  * 子要素を**横方向（主軸）**にどう配置するかを決める
  * `flex-start`：左寄せ（デフォルト）(1 2 3 _ _)
  * `flex-end`：右寄せ(_ _ 1 2 3)
  * `center`：中央揃え(_ 1 2 3 _)
  * `space-between`：左右端に配置、間隔均等(1 _ 2 _ 3)
  * `space-around`：要素の周囲に均等な余白(_ 1 _ _ 2 _ _ 3 _)
  * `space-evenly`：要素同士の間隔を均等にする(_ 1 _ 2 _ 3_)
* `align-items`（交差軸の揃え方）
  * 子要素を 縦方向（交差軸） にどう配置するかを決める
  * `stretch`：（デフォルト）親の高さに伸ばす(❚❚❚❚)
  * `flex-start`：上寄せ('''')
  * `flex-end`：下寄せ(....)
  * `center`：縦中央揃え(・・・・)
  * `baseline`：文字のベースラインを揃える  

* 子要素への指定
* `flex-basis`（基本サイズ）
  * 子要素の**基本の幅または高さ**を指定
  * autoまたはpxなど
* align-self（個別の縦揃え）
  * `auto`：親の align-items に従う（デフォルト）
  * `flex-start`：上寄せ
  * `flex-end`：下寄せ（親の**フレックス軸の終点**に揃える）
  * `end`：下寄せ（親の**書字方向の終点**に揃える）
  * `center`：縦中央揃え
  * `baseline`：文字のベースラインを揃える
  * `stretch`：親要素の高さいっぱいに伸ばす

```css
.container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: center;
}

.item {
  flex-basis: 200px;
  align-self: flex-start;
}
```

### background、背景
* `background`：color url(パス) repeat position/size
  * 例：`background: red url(パス) no-repeat right center/cover;`
* `background-image: url(パス);`：背景に画像を入れ込む（linearなどを利用した画像も可）
  * タイル状に敷き詰めた形で繰り返し背景画像が表示される
  * 元画像が小さいと読み込みが重くなる場合がある
  * ` linear-gradient(方向斜度, 色1 位置, 色2 位置... 位置)`：グラデーションを作成するための関数
    * 斜度：単位`deg`、90度で垂直方向、180度で水平方向に分ける
    * 位置：指定色が一番濃くなる位置を指定する。0%は開始位置、100%は終了位置
    * 例：`background-image: linear-gradient(135deg,#e6ba5d 0%,#9ac78a 100%);`斜めの線で色変化
    * 例：`background: linear-gradient(to right, red, blue);`：左から右へ、赤から青へ
    * 例：`background: linear-gradient(45deg, yellow, green);`：45度の角度、で黄色から緑へ
    * 例：`background: linear-gradient(to bottom, pink, transparent);`：上から下へ、ピンクから透明に
    * [CSS グラデーションジェネレーター](https://front-end-tools.com/generateGradient/)、作成参考例
* `background-repeat`:繰り返す形式を指定する
  * `repeat`：デフォルト
  * `repeat-x`：水平方向に繰り返す
  * `repeat-y`：垂直方向に繰り返す
  * `no-repeat`：繰り返ししない
* `background-position`：数値または位置（水平方向の位置　垂直方向の位置）を指定する
  * 水平方向：`left`、`center`、`right`
  * 垂直方向：`top`、`center`、`bottom`
* `background-size`:はみ出し場合の対応
  * `cover`：幅と高さのうち背景配置ボックスの値との比が小さい方を一致させるように，拡大・縮小する
  * `contain`：画像が 背景配置ボックス 内に完全に収まる
* `background-clip`：
  * `border-box`：デフォルト、ボーダーを含む領域まで背景を適用する（**ボーダーを含めて**背景が表示される）
  * `padding-box`：ボーダーには適用されない（**ボーダーを除いて**背景が表示される）
  * `content-box`：コンテンツ部分のみ背景適用（**ボーダーと padding領域を除いて**背景が表示される）
  * `text`：背景を**テキストの形に切り抜く**指定(**ベンター接頭辞必要**)

```css
h3 {
  background-image: url(パス);
  background-repeat: no-repeat;
  background-position: left bottom;
}
```

### position、位置
* `position:...;`：要素の表示位置の計算方法を指定 して相対位置や絶対位置による配置を指定する
  * `static`：デフォルト、left/right/top/bottomは適用されない（明示的に指定することは少ない）
  * `relative`：相対配置。通常の位置を基準に、指定した方向にずらす。left/right/top/bottomが適用される
    * 基準点は元位置の左上から計算する
    * 次のコンテンツに影響を及ぼすことはない
  * `absolute`：絶対配置。親要素（`relative`または`static`の`body`と設定された要素）を基準に配置
    * 基準点はウィンドウ自体の左上から計算する
    * 次のコンテンツに影響を及ぼす（本コンテンツが元からなかったよう前のコンテンツと隣接する）
  * `fixed`：固定配置。スクロールしても動かない。ヘッダーや戻るボタン用
  * `sticky`：スクロールに応じて固定配置。通常の位置にあるが、スクロールすると指定位置で固定される
    * 親要素の範囲を超えると固定が解除される
* `left`：要素を`左`から一定距離を離す　⇒　`右`へ一定距離を移動
* `right`：要素を`右`から一定距離を離す　⇒　`左`へ一定距離を移動
* `top`：要素を`上`から一定距離を離す　⇒　`下`へ一定距離を移動
* `bottom`：要素を`下`から一定距離を離す　⇒　`上`へ一定距離を移動

```css
.parent {
  position: relative;
}
.child {
  position: absolute;
  top: 10px;  /* 親要素の左上から10px下へ */
  left: 20px; /* 親要素の左上から20px右へ */
}

/* stickyの使い方 */
.sticky-box {
  position: sticky;
  top: 0px;
}
```

### transition、効果、時間的変化
* `transition: proprety duration timing-function delay`：
  * 例：`transition:all 300ms ease-in 100ms;`
* `transition-proprety`：属性名またはall
* `transition-duration`：リアクショントータル時間
* `transition-delay`：トリガーに触れる～リアクションするまで
* `transition-timing-function`：どう変化する
  * `ease`：デフォルト、ゆっくり始まり、ゆっくり終わる
  * `liner`：一定速度で変化する
  * `ease-in`：ゆっくり始まり、**早く終わる**
  * `ease-out`：**早く始まり**、ゆっくり終わる
  * `ease-in-out`：ゆっくり始まり、**早く経過し**、ゆっくり終わる
  * `cubic-bezier(数値, 数値, 数値, 数値)`：3次ベジェ曲線

```css
input[type="submit"]:hover {
  background-color: #c788cf;
  margin-left: 20px;
  transition-proprety: background-color, margin-left;
  transition-duration: 300ms;
  transition-timing-function: ease-in;
  transition-delay: 0ms;
}
```

### transform、@keyframes、アニメーションなどの要素変形
* `transform`：回転、ズーム、傾斜、移動
  * `rotate`：回転
  * `tranlate`：ズーム
  * `scale`：傾斜
  * `skew`：移動
  * X：水平方向に（scaleの場合拡大）
  * Y：垂直方向に（scaleの場合拡大）
  * ※CSSで追加した画像はmargin/paddingで調整できないため`transform`で代用する
* `transform-origin`：変形する基準を指定する
  * 例：`transform-origin: left top;`左上を基準に
  * `center`：デフォルト、中心
  * `left`：左を基準にする
  * `right`：右を基準にする
  * `top`：上を基準にする
  * `bottom`：下を基準にする
* `animation`：
  * `animation-name`：指定したいアニメ（transformの名前）
  * `animation-duration`：リアクショントータル時間
  * `animation-timing-function`：どう変化する
  * `animation-iteration-count`：デフォルトは0、ループ回数指定、`infinite`無限ループ

```css
@keyframes scrollAnimation {
  0% {
    transform: scaleY(0);　/* 要素の高さが0 */
    transform-origin: top;
  }
  50% {
    transform: scaleY(1);
    transform-origin: top;  /* 上topを基準に高さが1まで伸ばす */
  }
  50.1% {
    transform: scaleY(1);
    transform-origin: bottom;
  }
  100% {
    transform: scaleY(0);
    transform-origin: bottom;  /* 下bottomを基準に高さが0まで縮む */
  }
}

header .scroll img {
  animation-name: scrollAnimation;
  animation-duration: 1.8s;
  animation-timing-function: ease-out;
  animation-iteration-count: infinite;
}
```

### object、画像の切り抜き
* `object-fit`：
  * `fill`：コンテンツボックスのサイズにちょうど合うように調整（無理やりに引っ張る）
  * `contain`：縦横比は保持したまま，コンテンツボックスに**全体が収まる最小のサイズ**に調整(全体見えるのを重視)
  * `cover`：縦横比は保持したまま，コンテンツボックスを**完全に埋める最小のサイズ**に調整する（余白のない拡大、一部内容が画面外に出る可能性ある）
* `object-position: 水平位置 垂直位置`：
  * center、%などから指定することを推奨

### その他の指定
#### 影効果の指定
* `box-shadow:` X軸位置 Y軸位置 ぼかし 広がり 色 内側であるかどうか
  * 例：`box-shadow: 10px 10px 20px 12px #ffffff inset;'
  * `inset` 記述が内場合、外側に影を入れる
  * **透過画像に対しては不自然な影になる**、四角形（ボックスモデル）の影を入れる
* [filter、フィルター](#filterフィルター)に挙げた`filter: drop-shadow(X軸位置 Y軸位置 ぼかし 色)`との比較
  * PNGやSVGのような背景透過画像に対して、画像元の**非透明部分に沿って影を入れる**
  * `box-shadow`の方が細かく設定できる（広がり範囲、内側か外側か）

#### リストスタイル
* `list-style-type`
  * `disc`：ulのデフォルト、・黒い点
  * `circle`：゜黒い枠線の白い点
  * `square`：■黒い四角
  * `decimal`：1. olのデフォルト、数字
  * `none`：なし

#### スクロール
* `overflow`：オーバーフロー（許容範囲を超えた状態）⇒スクロール
  * `visible`：デフォルト、はみ出し部分をそのまま表示する
  * `hidden`：隠す（スクロールもできない状態）
  * `scroll`：スクロール
  * `auto`：ブラウザ依存（基本スクロール）

#### z軸により深さの設定
`z-index`：数字が大きいほどワイヤーが上に来る。マイナスと設定するのも可（ただの数字で可）

#### content、画像・映像の差し込み
* 画像などのコンテンツを差し込み、positionで差し込む場所を指定する
  * 例：差し込む場所に`position: relative;`
  * 疑似クラスセレクターを使用する
    * `::before`：要素の前にコンテンツを追加
    * `::after`：要素の後にコンテンツを追加
    * なお`::before`や`::after`を使用する際、`content`で差し込む必要がある
    * `content: "";`で一旦入れておくのもあり

```css
/* 画像の差し込み */
p.illust {
 position: relative;
}

p.illust::before {
  content: url(パス);
  position: absolute;
  left: 10px;
}

p.illust::after {
  content: "";
  position: absolute;
  left: 0;
  top: 0;
  widith: 100%;
  height: 100%;
  background: url(パス);
}
```

```css
/* 装飾を入れる */
blockquote::before {
  content: "“";
  font-size: 2rem;
}

blockquote::after {
  content: "”";
  font-size: 2rem;
}
```

#### jumbotron、強調
* \<div class="jumbotron">、bootstrap必須
* **視覚的な強調**: ジャンボトロンは、重要なメッセージや特別なコンテンツを目立たせるために使用されている。通常、ページの最上部に配置されることが多い
* タイトルや説明文: 主に大きな見出しやサブタイトル、説明文を含むことが多い
* スタイル:
  * パディング: 自動的に十分なパディングが与えられ、コンテンツが周囲から浮き上がるように見えるデザインが施されている
  * 背景色: 通常、**明るい背景色**（例えば、ライトグレーやホワイト）で、内容を強調するデザインになっている
  * 影: コンテンツが立体的に見えるように、ボックスシャドウが適用されることもある
* レスポンシブ:
  * Bootstrapの特徴であるレスポンシブデザインにより、jumbotronは様々な画面サイズに適応し、適切に表示される

## グリッドシステム
### グリッドレイアウト設定
* `display: grid;`で利用する（ulなどのリストに対して設定することが多い）
* `flexbox`は一行または一列での整列に対して`grid`は複数行で並び替えができる
* グリッドライン(grid line)
* グリッドトラック(grid track)
* グリッドセル(grid cell)  

【設置手順】  
1. `display: grid;`：親要素で指定
2. 各行/列の長さを指定、複数形、単位：`px`、`vw`、`%` など
  * `grid-template-rows`：行数があるだけ該行の高さを指定する
  * `grid-template-columns`：列数があるだけ該列の広さを指定する
  * 例：`grid-template-rows: 20vw 30vw 40vw;`：20vw+30vw+40vwで合計3行のグリッド
3. 子要素に置く、単数形、グリッドラインで指定する、一番上/左のラインは1でスタート。囲んだ範囲が子要素の位置。\[a, b + 1]
  * `grid-row-start: a;`：上から
  * `grid-row-end: b;`：下へ囲む
  * `grid-row: a / b;`：一行で指定することも可
  * `grid-column-start: a;`：左から
  * `grid-column-end: b;`：右へ囲む
  * `grid-column: a / b;`：一行で指定することも可

### グリッドシステム_Bootstrap
* **本項はBootstrap使用前提の内容**
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

## ハンバーガーメニュー
### ハンバーガーメニューの基本HTMLやCSS
【HTML内記述、<header>内推奨】  
* メニューボタンを押すと、チェックボックスのON/OFFが切り替わる
* 「:checked」を使用すると、チェックボックスがONのときのCSSを設定できる
* 「:checked」と「~」を組み合わせることで、チェックボックスがONのときのメニューボタンやメニューのデザインを設定できる
* チェックボックスがONのとき ⇒ メニューを表示し、メニューボタンが「✕」になる
* チェックボックスがOFFのとき ⇒ メニューを非表示にし、メニューボタンが三本線（ハンバーガーメニュー）になる  

```html
<nav class="gMenu">
  <input class="menu-btn" type="checkbox" id="menu-btn">
  <label class="menu-icon" for="menu-btn">
    <span class="navicon"></span>
  </label>
  <ul class="menu">
    <li><a href="#">menu1</a></li>
    <li><a href="#">menu2</a></li>
    <li><a href="#">menu3</a></li>
  </ul>
</nav>
```

【CSS内記述、`<link rel="stylesheet" href="menu.css">`とかで別ファイルに保存しておくのも可】
```css
/* メニューを画面の上部に固定 */
.gMenu {
  position: fixed;
  right: 0;
  top: 0;
  width: 100%;
  z-index: 99;
}

/* メニューアイコン（ハンバーガーメニュー）を画面の右上に固定 */
.gMenu .menu-icon {
  cursor: pointer;
  position: absolute;
  right: 10px;
  top: 12px;
  padding-top: 5px;
  height: 12px;
}

/* メニューアイコン（三本線）の中央の線 */
.gMenu .menu-icon .navicon {
  background: #ffc107; /* 色は自由に変更可能 */
  display: block;
  height: 2px; /* 線の太さ */
  width: 31px; /* 線の長さ */
  position: relative;
  transition: background .4s ease-out; /* 形が変わる際のアニメーション */
}

/* 疑似要素を使って、メニューアイコン（三本線）の上下に線を追加 */
.gMenu .menu-icon .navicon::before,
.gMenu .menu-icon .navicon::after {
  background: #ffc107; /* 色は自由に変更可能 */
  content: '';
  display: block;
  height: 100%;
  position: absolute;
  transition: all .4s ease-out; /* 形が変わる際のアニメーション */
  width: 100%;
}
.gMenu .menu-icon .navicon::before {top: 10px;} /* 上の線を移動 */
.gMenu .menu-icon .navicon::after {top: -10px;} /* 下の線を移動 */

/* 表示されるメニュー */
.gMenu .menu {
  background-color: rgba(255,255,255,0.9);
  overflow: hidden;
  max-height: 0; /* ★ 初期状態では高さを0にして非表示 */
  transition: max-height .6s; /* 表示時のアニメーション */
  text-align: center;
}

/* メニューのデザイン */
.gMenu .menu li:first-of-type {
  padding-top: 50px;
}
.gMenu .menu li a {
  display: block;
  padding: 24px 20px;
  text-decoration: none;
  text-transform: uppercase;
}
.gMenu .menu li a:hover {
  background-color: #f4f4f4;
}

/* チェックボックスは常に非表示 */
.gMenu .menu-btn {
  display: none;
}

/* ▼▼▼ チェックボックスがONのときの設定 ▼▼▼ */

/* チェックボックスがONのとき、メニューを表示（高さを338pxに設定） */
.gMenu .menu-btn:checked ~ .menu {
  max-height: 338px;
  transition: max-height .6s;
}

/* メニューアイコンの中央の線を透明にする（✕マークの作成） */
.gMenu .menu-btn:checked ~ .menu-icon .navicon {
  background: transparent;
}

/* メニューアイコンの上下の線を45度傾けて「✕」マークを作る */
.gMenu .menu-btn:checked ~ .menu-icon .navicon::before {
  transform: rotate(-45deg);
  top: 0;
}
.gMenu .menu-btn:checked ~ .menu-icon .navicon::after {
  transform: rotate(45deg);
  top: 0;
}
```

### ハンバーガーメニュー_Bootstrap
* **本項はBootstrap使用前提の内容**
* ナビゲーションバー
* デバイス広さが短い場合、ハンバーガーメニューに変換する仕組みのコードとなる

```html
<!-- ナビゲーションバーの設定。クラスで色や位置を指定 -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <!-- コンテンツの中央揃えをするためのコンテナ -->
    <div class="container">
        <!-- ナビゲーションバーのヘッダー部分 -->
        <div class="navbar-header">
            <!-- 画面が小さくなった時に表示されるメニューボタン（ハンバーガーみたいなやつ） -->
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <!-- 画面リーダー用のテキスト。表示はされず、音声読み上げ等に対応 -->
                <span class="sr-only">Toggle navigation</span>
                <!-- ボタン内の3本線アイコンの1本目 -->
                <span class="icon-bar"></span>
                <!-- ボタン内の3本線アイコンの2本目 -->
                <span class="icon-bar"></span>
                <!-- ボタン内の3本線アイコンの3本目 -->
                <span class="icon-bar"></span>
            </button>
            <!-- ナビゲーションバー左側のブランド名（リンク付き） -->
            <a class="navbar-brand" href="#">会社ロゴ名や固定したい文章など</a>
        </div>
        <!-- ナビゲーションバー内のリンクや項目の設定 -->
        <div id="navbar" class="collapse navbar-collapse">
            <!-- リスト形式でナビゲーションメニューを作成 -->
            <ul class="nav navbar-nav">
                <!-- 現在のページを示すために"active"クラスを使用 -->
                <li class="active"><a href="#">Home</a></li>
                <!-- ページ内の"list"というidにジャンプするリンク -->
                <li><a href="#list">List</a></li>
                <!-- テーブルページのリンク -->
                <li><a href="">Table</a></li>
            </ul>
        </div>
    </div>
</nav>
```
なお、下記内容を読み込む必要もある。\<body>の最後に入れておけばいい内容
```html
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
```
