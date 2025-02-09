概要
* [OGPについて](#ogpについて)
* [タグ](#タグ)
  * [og:タグ](#ogタグ)
  * [Twitter用タグ](#twitter用タグ)
  * [言語指定](#言語指定)
  * [著者情報](#著者情報)
* [SNSワンボタン](#SNSワンボタン)
  * [Twitterの「ポスト」ボタン_A](#twitterのポストボタン_a)
  * [Twitterの「ポスト」ボタン_B](#twitterのポストボタン_b)
  * [LINEの「シェア」ボタン_A](#lineのシェアボタン_a)
  * [LINEの「シェア」ボタン_B](#lineのシェアボタン_b)
  * [Facebookの「シェア」ボタン_A](#facebookのシェアボタン_a)
  * [Facebookの「シェア」ボタン_B](#facebookのシェアボタン_b)
* [シェアリンク（パラメータ）の解説](#シェアリンクパラメータの解説)

便宜上、シェアしたいURL名を本講では一律に【シェアリンク先】と書く
***************************************************************************
## OGPについて
* Open Graph Protocol
* <meta>メタタグに記述
* WebページがSNS（Facebook、Twitter、Lineなど）でシェアされたときに、表示される情報を指定するためのもの  

シェアされると以下のような内容が表示される：  
```
タイトル: コーディング勉強中
説明: 本サイトに関する説明文
画像: シェアリンク先images/ogp.png
```

## タグ
### og:タグ
* `og:type` ⇒ ページの種類（website は通常のWebサイトを意味する）
* `og:url` ⇒ ページのURL
* `og:site_name` ⇒ サイトの名前
* `og:title` ⇒ ページのタイトル（SNS上で大きく表示される）
* `og:description` ⇒ ページの説明（SNSでのプレビューに表示される）
* `og:image` ⇒ シェア時に表示される画像のURL
* `og:image:alt` ⇒ 画像の代替テキスト（画像が表示されないときの説明）
* `og:image:width` & `og:image:height` ⇒ 画像のサイズ（1200×630はFacebook推奨サイズ）  

```html
<meta property="og:type" content="website">
<meta property="og:url" content="シェアリンク先">
<meta property="og:site_name" content="コーディング勉強中">
<meta property="og:title" content="コーディング勉強中">
<meta property="og:description" content="本サイトに関する説明文">
<meta property="og:image" content="シェアリンク先images/ogp.png">
<meta property="og:image:alt" content="Harvest Restaurant">
<meta property="og:image:width" content="1200">
<meta property="og:image:height" content="630">
```

### Twitter用タグ
X（Twitter）での表示を最適化するために、Twitter Cardのタグを追加するのもよき  

* `twitter:card` ⇒ summary_large_image を指定すると、大きなサムネイル画像付きで表示される
* `twitter:site` ⇒ 公式Twitterアカウント（例: @abcd_123）
* `twitter:title` & `twitter:description` ⇒ OGPと同じでOK
* `twitter:image` ⇒ SNSシェア時に表示する画像
```html
<meta name="twitter:card" content="summary_large_image">
<meta name="twitter:site" content="@your_twitter_handle">
<meta name="twitter:title" content="コーディング勉強中">
<meta name="twitter:description" content="本サイトに関する説明文">
<meta name="twitter:image" content="シェアリンク先images/ogp.png">
```

### 言語指定
多言語対応用に、検索エンジンやSNSが適切に処理しやすくなる  

* `og:locale` ⇒ ページのデフォルト言語
* `og:locale:alternate` ⇒ ほかの言語のページがある場合に指定
```html
<meta property="og:locale" content="ja_JP"> <!-- 日本語 -->
<meta property="og:locale:alternate" content="zh_TW"> <!-- 繁体字中国語（台湾） -->
<meta property="og:locale:alternate" content="en_US"> <!-- 英語 -->
```

### 著者情報
ブログ記事やニュース記事の場合、著者名を入れる  

* article:author ⇒ 記事の著者名
* article:published_time ⇒ 公開日時
* article:modified_time ⇒ 最終更新日時

```html
<meta property="article:author" content="作者名">
<meta property="article:published_time" content="2024-02-10T12:00:00+09:00">
<meta property="article:modified_time" content="2024-02-10T15:00:00+09:00">
```

## SNSワンボタン
このようにすべてのSNSボタンを横並びで設置することも可能  

【簡潔に文字からのシェア】
```html
<div>
  <a href="https://twitter.com/intent/tweet?url=シェアリンク先" target="_blank">Xでポスト</a>
  <a href="https://www.facebook.com/sharer/sharer.php?u=シェアリンク先" target="_blank">Facebookでシェア</a>
  <a href="https://social-plugins.line.me/lineit/share?url=シェアリンク先" target="_blank">LINEで送る</a>
</div>
```

【本家アイコン付きのリンク】  
`<head>`内：
```html
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
```

`<body>`内：
```html
<div>
  <a href="https://twitter.com/intent/tweet?url=シェアリンク先" target="_blank">
    <i class="fa-brands fa-x-twitter"></i> Xでポスト
  </a>
  <a href="https://www.facebook.com/sharer/sharer.php?u=シェアリンク先" target="_blank">
    <i class="fa-brands fa-facebook"></i> Facebookでシェア
  </a>
  <a href="https://social-plugins.line.me/lineit/share?url=シェアリンク先" target="_blank">
    <i class="fa-brands fa-line"></i> LINEで送る
  </a>
</div>
```

### Twitterの「ポスト」ボタン_A
【公式のウィジェットを利用する】  
【スクリプト】
```html
<script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
```

【ボタン設置】
```html
<a href="https://twitter.com/share" class="twitter-share-button" data-text="コメント" data-url="シェアリンク先" data-hashtags="眠い,勉強">
  X（旧Twitter）でシェア
</a>
```
この場合、【コメント シェアリンク先 #眠い #勉強 】と書かれたポストの下書きが出てくる

### Twitterの「ポスト」ボタン_B
【文字+リンクのやり方】  
* `url=` ⇒ シェアしたいURL
* `text=` ⇒ シェア時のコメント
* `target="_blank"` ⇒ 別タブで開く
```html
<a href="https://twitter.com/intent/tweet?url=シェアリンク先&text=ここにシェアする文章を書く" 
   target="_blank" 
   rel="noopener noreferrer">
  Xでポストする
</a>
```

### LINEの「シェア」ボタン_A
* [公式ドキュメント](https://developers.line.biz/ja/docs/line-social-plugins/install-guide/using-line-share-buttons/)
  * 上記サイトから必要な形式のボタンを選択することが可能
* もしくは下記コードの【LINE社のJavaScript SDK】を利用する方法も

```html
<script type="text/javascript" src="https://static.line-scdn.net/liff/edge/2/sdk.js"></script>

<button onclick="shareOnLine()">LINEでシェア</button>

<script>
  function shareOnLine() {
    liff.init({ liffId: "your-liff-id" }, () => {
      liff.shareTargetPicker([{
        type: 'text',
        text: 'シェアする内容のテキスト'
      }])
    }, (error) => {
      console.error('LIFFの初期化に失敗しました', error);
    });
  }
</script>
```

### LINEの「シェア」ボタン_B
【文字+リンクのやり方】
```html
<a href="https://social-plugins.line.me/lineit/share?url=シェアリンク先" 
   target="_blank" 
   rel="noopener noreferrer">
  LINEで送る
</a>
```

### Facebookの「シェア」ボタン_A
【公式のウィジェットを利用する】  
【スクリプト】
```html
<script async defer crossorigin="anonymous" 
		src="https://connect.facebook.net/ja_JP/sdk.js#xfbml=1&version=v16.0" 
		nonce="XYZ">
</script>
```

【ボタン設置】
```html
<div class="fb-like" 
     data-href="シェアリンク先" 
     data-layout="standard"
     data-action="like"
     data-size="small"
     data-share="true">
</div>
```
* `data-href="シェアリンク先"` ⇒ シェアリンク 
* `data-layout="standard"` ⇒ ボタンのレイアウト。`'standard'` はデフォルトの大きなボタン
* `data-action="like"` ⇒ いいねボタン
* `data-size="small"` ⇒ ボタンのサイズ。`'small'` または `'large'`
* `data-share="true">` ⇒ シェアボタンも表示

### Facebookの「シェア」ボタン_B
【文字+リンクのやり方】  
```html
<a href="https://www.facebook.com/sharer/sharer.php?u=シェアリンク先" 
   target="_blank" 
   rel="noopener noreferrer">
  Facebookでシェア
</a>
```

## シェアリンク（パラメータ）の解説
| パラメータ | 説明 |
| --- | --- |
| `url=` | シェアするページのURL（安全性よりエンコード推奨） |
| `text=` | ツイートの本文 |
| `via=` | （オプション）ツイートにアカウント名を含める |
| `hashtags=` | （オプション）カンマ区切りでハッシュタグを追加 |

```html
<a href="https://twitter.com/intent/tweet?url=https%3A%2F%2Fexample.com%2F&text=このお店最高だった！&via=HarvestResJP&hashtags=秘境レストラン,グルメ">
  X（旧Twitter）でシェア
</a>
<!-- via=HarvestResJP ⇒ @HarvestResJP のメンションが付く -->
<!-- hashtags=秘境レストラン,グルメ ⇒ #秘境レストラン #グルメ が追加される -->
```

* URLエンコードする方法
  * URLに`&`や`?`が含まれていると正しく反映されない場合がある
  * JavaScriptの `encodeURIComponent()` を使ってエンコード すると安全

```js
const url = encodeURIComponent("シェアリンク先");
const text = encodeURIComponent("このお店最高だった！");
const tweetUrl = `https://twitter.com/intent/tweet?url=${url}&text=${text}`;
console.log(tweetUrl);
```
