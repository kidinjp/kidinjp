# Markdownファイル
テキストベースのマークアップ言語であるMarkdownを使用して書かれた文書。　　
Markdownは、テキストを簡潔にフォーマットするための記法で、主に次のような特徴があります。  
**1. シンプルな記法**  
   テキストをシンプルな記号で囲むことで、フォントスタイルや段落、リスト、リンクなどを指定できます。  
   例えば、アスタリスク（*）やアンダースコア（_）でテキストを囲むことで、イタリック体やボールド体を表現します。  
**2. 可読性**  
   Markdownで書かれたテキストは、フォーマットがない状態でも人間にとって読みやすいです。これにより、内容を理解しやすくなります。
**3. 拡張性**  
   基本的なMarkdownの機能に加えて、GitHub Flavored Markdown（GFM）や他のプラットフォームに特有の拡張機能をサポートしていることが多く、画像やテーブル、チェックリストなども扱えます。  
**4. 広範なサポート**  
Markdownファイルは多くのプラットフォームでサポートされており、GitHub、Bitbucket、Qiitaなどのウェブサイトや、テキストエディタ、ブログプラットフォームなどで利用されています。

**用途について：**
* **ドキュメント作成：** プロジェクトのREADMEファイルや技術文書、ノートなどをMarkdownで作成します。
* **ウェブコンテンツ：** Markdownを使用して記事やブログ投稿を執筆し、その後HTMLに変換してウェブページとして公開できます。
* **プレゼンテーション：** Markdownを用いてスライドを作成することも可能で、専用のツールを使えば視覚的なプレゼンテーションに変換できます。


# よく使われる書き方
|  種類   | 表記 - Markdown                            | 表記 - HTML/CSS                          | 表記例                         | 使用例                    |
| :-----: | :---------------------------------------- | ---------------------------------------: | :----------------------------- | :------------------------ |
| 段落    | 空白行                                     |`<p></p>`                                 | (Enter)<br><br>`<p>`1段落目`</p>` `<p>`2段落目`</p>`       | <p>1段落目</p><p>2段落目</p>        |
| 改行    | 行末に2つ以上の半角スペース<br>または\<br>    | `<br>`                                  | 1行目`  `<br>2行目<br><br>1行目`<br>`2行目                 | 1行目<br>2行目            |
| 見出し  | 行頭に`#`を付ける（H1～H6）                 | `<h1>～<h6>`タグ                          | `# `H1<br>`# `H2<br>`# `H3<br>`# `H4<br>`# `H5<br>`# `H6<br><br>`<h1>`H1`</h1>` | <h1>H1</h1><br><h2>H2</h2><br><h3>H3</h3><br><h4>H4</h4><br><h5>H5</h5><br><h6>H6</h6> |
| 強調<br>斜体 | テキストの前後に*または_で囲む | `<i></i>` | `*`A`*`<br><br>`_`B`_`<br><br>`<i>`C`</i>` | *A*<br>_B_<br><i>C</i> |
| 強調<br>太字 | テキストの前後に**または__で囲む | `<b></b>` | `**`A`**`<br><br>`__`B`__`<br><br>`<b>`C`</b>` | **A**<br>__B__<br><b>C</b> |
| 強調<br>斜体+太字 | テキストの前後に***または___で囲む | `<i><b></b></i>` | `***`A`***`<br><br>`___`B`___`<br><br>`<i><b>`C`</b></i>` | ***A***<br>___B___<br><i><b>C</b></i> |
| 強調<br>取り消し線 | テキストの前後に~~で囲む | `<del>`文脈的に「削除された」`</del>`<br>`<s>`視覚的に「取り消し線」`</s>` | `~~`A`~~`<br><br>`<del>`B`</del>`<br><br>`<s>`C`</s>` | ~~A~~<br><del>B</del><br><s>C</s> |
| Subscript | X | `<sub></sub>` | mc`<sub>`2`</sub>` | mc<sub>2</sub> |
| Superscript | X | `<sup></sup>` | H`<sup>`2`</sup>`O | H<sup>2</sup>O |
| リスト<br>＜箇条式＞ | 行頭に* または-  | `<ul><li></li></ul>` | `* `A<br><br>`- `B<br><br>`<ul><li>`C`</li></ul>` | <ul><li>A</li></ul><br><ul><li>B</li></ul><br><ul><li>C</li></ul> |
| ネストリスト | ネストする内容の行頭に<br>2つ以上のインデントを入れて、<br>* または-  | `<ul><li>`<br>  `<ul><li></li></ul>` <br>`</li></ul>` | `*` A<br>`   *` a<br><br>`-` B<br>`   -` b<br><br>`<ul><li>`C<br>`   <ul><li>`c`</li></ul>`<br>`</li></ul>` | <ul><li>A<ul><li>a</li></ul></li></ul><ul><li>B<ul><li>b</li></ul></li></ul><ul><li>C<ul><li>c</li></ul></li></ul> |
| リスト<br>＜番号付＞ | 行頭に**数字**と**ピリオド**と**スペースx1**<br>`1. ` | `<ol><li></li></ol>` | `1. `A<br>`2. `B<br><br>`<ol>`<br>`   <li>`一つ目`</li>`<br>`   <li>`二つ目`</li>`<br>`</ol>` | <ol><li>A</li>  <li>B</li></ol><ol>  <li>一つ目</li>  <li>二つ目</li></ol> |
| 引用 | 行頭に `> `を付ける<br>なお、HTMLのciteのような書き方はない<br>`> `を3行に書くなどが一般的  | `<blockquote>`文章`<cite>`作者名・出典`</cite></blockquote>`  | `> `文章<br>`> `<br>`> `作者名・出典<br><br>`<blockquote>`文章<br>`   <cite>`作者名・出典`</cite>`<br>`</blockquote>` | <blockquote>"文章"<br><br>– 作者名・出典</blockquote> <blockquote>"文章"<cite>– 作者名・出典</cite></blockquote> |
| ソースコード | テキストの前後に\`または<br>` ``` `(コードブロック、開発言語を指定)を使う<br>` ``` + 言語`と` ``` `は<br>内容との間は**改行する必要がある** | 単なるソースコード：`<code></code>`<br>コピーできるソースコード：`<pre><code></code></pre>` | \`内容A\`<br><br>` ``` `Java<br>内容B` ``` `<br><br> `<code>`内容C`</code>`<br><br>`<pre><code>`内容D`</pre></code>`| `内容A`<br><br>[内容B](#内容b) <br><br><code>内容C</code><br><br><pre><code>内容D</pre></code> |
| 区切り線 | 3つ以上の<br>`-`または`_`または`*` | `<hr>` | `---`<br>`___`<br>`***`<br>`<hr>`<br> | <hr><br><hr><br><hr><br><hr> |
| 表 | \|と改行で直感的に設定できる<br>1行目は**タイトル**<br>2行目はヘッダーと内容を区切る<br>そのなかにある-は必ず3つ以上で設定する<br>左揃え：`---`または`:---`<br>右揃え：`---:`<br>中央揃え：`:---:` | `<table>`<br>`   <thead>`<br>`      <tr>`<br>`         <th>`タイトル1`</th>`<br>`         <th>`タイトル2`</th>`<br>`      </tr>`<br>`   </thead>`<br>`   <tbody>`<br>`      <tr>`<br>`         <td>`内容A`</td>`<br>`         <td>`内容B`</td>`<br>`      </tr>`<br>`   </tbody>`<br>`</table>`<br><br> `<th>`または`<td>に対してstyle指定すると揃え設定できる<br>左揃え：`style="text-align: left;"`<br>右揃え：`style="text-align: right;"`<br>中央揃え：`style="text-align: center;"`<br>※ヘッドとボディ内はそれぞれ<br>  個別に設定する必要がある<br>※styleはCSSの範疇のため<br>  GitHubでは反映されない場合がある| \| タイトル1 \| タイトル2 \| タイトル3 \|<br>\| `:-------` \| `:-------:` \| `-------:` \|<br>\|   内容A  \|   内容B   \|    内容C   \|<br><br>`<table>`<br>`   <thead>`<br>`      <tr>`<br>`         <th style="text-align: left;">`タイトル1`</th>`<br>`         <th style="text-align: center;">`タイトル2`</th>`<br>`         <th style="text-align: right;">`タイトル3`</th>`<br>`      </tr>`<br>`   </thead>`<br>`   <tbody>`<br>`      <tr>`<br>`         <td  style="text-align: left;">`内容1`</td>`<br>`         <td  style="text-align: center;">`内容2`</td>`<br>`         <td  style="text-align: right;">`内容3`</td>`<br>`      </tr>`<br>`   </tbody>`<br>`</table>` | [Markdown表の例はこちら](#markdownの表左中央右揃え)<br><br><table>   <thead>      <tr>         <th style="text-align: left;">タイトル1</th>         <th style="text-align: center;">タイトル2</th>         <th style="text-align: right;">タイトル3</th>      </tr>   </thead>   <tbody>      <tr>         <td  style="text-align: left;">内容1</td>         <td  style="text-align: center;">内容2</td>         <td  style="text-align: right;">内容3</td>      </tr>   </tbody></table> |
| 画像 | 行頭に`!`を付ける<br>画像名前、<br>画像アドレスが必須 | `<img src="`画像アドレス`" alt="`画像ファイル名`">` | `![画像名前](画像アドレス)` <br><br>`<img src="`画像アドレス`" alt="`画像ファイル名`">` | （今回扱いません） |
| リンク | `<`アドレス`>`<br>`[文字内容](アドレス)`<br>※アドレスは本ファイルの<br>見出しとリンクすることも可能<br>`[文字内容]`(`#見出し`) | `<a href="`リンクアドレス`">`文字内容`</a>`<br>※アドレスは本ファイルの<br>見出しとリンクすることも可能 | `<`https://www.google.com/ `>`<br><br>`[`Google`](`https://www.google.com/ `)`<br><br>`<a href="`https://www.google.com/ `">`Google`</a>` | <https://www.google.com/><br><br>[Google](https://www.google.com/)<br><br><a href="https://www.google.com/">Google</a> |
| X | X | X | X | X |

#### 内容B
``` Java
内容B
```


#### Markdownの表、左/中央/右揃え
| タイトル1 | タイトル2 | タイトル3 |
| :------- | :-------: | -------: |
|   内容A  |   内容B   |    内容C   |

