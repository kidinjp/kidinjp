概要
* [リポジトリ（Repository）](#リポジトリrepository)
  * [ターミナルを開く方法](#ターミナルを開く方法)
    * [Windowsから開く](#windowsから開く)
    * [Macから開く](#macから開く)
* [よく使う操作](#よく使う操作)
  * [作成者の設定](#作成者の設定)
  * [リポジトリの作成](#リポジトリの作成)
  * [変更のステージング](#変更のステージング)
  * [コミットと履歴確認](#コミットと履歴確認)
  * [コミットされたくないファイルの指定方法](#コミットされたくないファイルの指定方法)
  * [ブランチの作成と切り替え](#ブランチの作成と切り替え)
  * [マージ](#マージ)
  * [ロールバック方法](#ロールバック方法)
  * [リモートリポジトリとの紐付け](#リモートリポジトリとの紐付け)
  * [リモートリポジトリへのプッシュ](#リモートリポジトリへのプッシュ)
  * [GitHubからローカルPCへクローン](#githubからローカルpcへクローン)
  * [スタッシュ（作業の一時保存）](#スタッシュ作業の一時保存)
  * [ブランチの切り替えやコミット移動](#ブランチの切り替えやコミット移動)
* [最近やった操作の操作例](#最近やった操作の操作例)
  * [リポジトリの内容をローカルPCにコピーして、フォルダファイルを追加してから同期する](#リポジトリの内容をローカルpcにコピーしてフォルダファイルを追加してから同期する)
  * [ローカルPCにリポジトリフォルダが既にありアップデートしたい場合](#ローカルpcにリポジトリフォルダが既にありアップデートしたい場合)
  * [Git LFSの使い方](#git-lfsの使い方)

***************************************************************************


# リポジトリ（Repository）
リポジトリの作成と管理
* **作成**: `git init` でローカルリポジトリを作成
* **複製**: `git clone <リポジトリURL>` でリモートリポジトリを複製
* **状態確認**: `git status` で作業ディレクトリの状態を表示
* **変更をステージング**: `git add` <ファイル名> または `git add .` ですべての変更を追加
* **コミット**: `git commit -m "コミットメッセージ"`
* **リモートに反映**: `git push origin <ブランチ名>`

## ターミナルを開く方法
### Windowsから開く
1. 「コマンドプロンプト（cmd）」を開く
    * **Win + R → cmd と入力 → Enter**
    * スタートメニュー → cmd を検索
2. 「Windows PowerShell」を開く
    * **Win + R → powershell と入力 → Enter**
    * スタートメニュー → Windows PowerShell を検索
3. 「Windows Terminal」を開く（推奨）
    * **Win + X → Windows ターミナル を選択**
    * スタートメニュー → Windows Terminal を検索
4. 「Git Bash」を開く（Gitをインストールしている場合）
    * スタートメニュー → Git Bash を検索
    * エクスプローラーのフォルダ上で 右クリック → Git Bash Here
5. 「WSL（Windows Subsystem for Linux）」を開く（Linux環境が必要な場合）
    * Win + R → wsl と入力 → Enter
    * スタートメニュー → Ubuntu（または他のインストールしたディストリビューション）を検索

### Macから開く
1. 「ターミナル.app」を開く
    * Command + Space（Spotlight検索） → terminal と入力 → Enter
    * Launchpad → その他 フォルダ → ターミナル
2. 「iTerm2」を開く（カスタマイズ可能なターミナル）
    * 事前に iTerm2 をインストールしておく
    * Command + Space → iterm と入力 → Enter
3. 「VS Code のターミナル」を開く
    * VS Code を開き、Ctrl + Shift + P → "ターミナル: 新しいターミナル" を選択
    * Terminal メニュー → New Terminal
4. 「Macのリカバリーモードのターミナル」（システム修復時）
    * Command + R を押しながら Mac を起動 → ユーティリティ → ターミナル

# よく使う操作
## 作成者の設定
```
git config --global user.name "名前"  
git config --global user.email "メール名"  
```

## リポジトリの作成
```
git init   # ローカルリポジトリの作成
git status # 現在の作業ディレクトリの状態を表示
```

## 変更のステージング
```
git add -A   # すべての変更（追加、変更、削除）をステージング
git add .    # カレントディレクトリ以下の追加・変更のみをステージング
git add 指定したいファイル名
git add 指定したいフォルダ名/
```

## コミットと履歴確認
```
git commit -m "コミットメッセージ"
git log    # コミット履歴の確認（ハッシュ値も表示）
```

## コミットされたくないファイルの指定方法  
.gitignore によるファイル除外
```
/ファイル名  # ファイルを無視
/フォルダ名/ # フォルダを無視
```

## ブランチの作成と切り替え
```
git switch -c feature/user_login  # 新しいブランチを作成して移動
git switch feature/user_login     # 既存のブランチに移動
git switch main                   # メインブランチに移動
```

## マージ
```
git merge feature/user_login  # 現在のブランチに feature/user_login をマージ
```

## ロールバック方法
```
git reset --hard <コミット番号>  # 指定のコミットまで完全に戻す（変更は消える）
git revert <コミット番号>        # 指定のコミットを取り消す（履歴は残る）
# ※ commit番号⇒git statusから参照できる
```

## リモートリポジトリとの紐付け
```
git remote add origin <リモートリポジトリURL>  # リモートリポジトリの追加
```
※ 通常、リモートリポジトリ名は origin  
※ URLはgithubのコードからHTTPSリンクをコピー  
https://github.com/kidinjp/BennkyouNote.git  
⇓  
https://（ユーザー名：アクセストークン＠）github.com/kidinjp/BennkyouNote.git  
⇓  
https://kidinjp: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@github.com/kidinjp/BennkyouNote.git  

## リモートリポジトリへのプッシュ
```
git push -u origin main  # リモートリポジトリへアップロード
```
* git push -u （リポジトリ名　ローカルブランチ名：リモートブランチ名）
* リモートのブランチにアップロード（上流ブランチを設定）  

※失敗した場合一回統合してみてください：  
```
git pull origin main --rebase
```

## GitHubからローカルPCへクローン
```
git clone <HTTPS_URL>
```
* **HTTPS_URL**：`https://（ユーザー名：アクセストークン＠`
* 例：このBennkyouNoteのURLは【https://github.com/kidinjp/BennkyouNote.git`】となる

## スタッシュ（作業の一時保存）
```
git stash            # 変更をスタッシュ（一時保存）
git switch main      # メインブランチに移動
git commit -am "Hotfix in main branch"
git switch feature-A # 作業ブランチに戻る
git stash apply      # 作業を再開するためスタッシュした変更を戻す
```

## ブランチの切り替えやコミット移動
```
git checkout -b debug-branch <コミットID>  # 過去のコミットを基に新しいブランチを作成
git checkout <コミットID>  # 過去の特定のコミットに移動
git checkout -- ファイル名   # 特定のファイルの変更を取り消したい
```

# 最近やった操作の操作例

## リポジトリの内容をローカルPCにコピーして、フォルダファイルを追加してから同期する
1. ターミナル（今回はPowerShell今回はを使用）を開いて、コピー先に移動
    * `cd Documents/Projects`
2. クローンする
    * `git clone https://github.com/kidinjp/BennkyouNote.git`
3. フォルダ作成
    * リポジトリ内に作成したいとこに移動：`cd BennkyouNote`
    * `mkdir 作品集/繁體中文/HTMLCSS`
4. ローカルPCにある特定のフォルダを、リポジトリ内に移動させる
    * 今回は**コピー移動**させたいだけのため、元位置にある
    * `xcopy "移動させたいフォルダの絶対パス" "C:\Users\q1352\OneDrive\桌面\プログラミング関連\GitHub管理\BennkyouNote\作品集\日本語\Java\1_Java基礎クラス課題" /E /I`
    * /E → 空のフォルダも含めてコピー
    * /I → 移動先がフォルダだと認識させる
5. 変更を追加
    * `git add .`
6. コミット
    * `git commit -m "コメント"`
7. リモートリポジトリにプッシュする
    * `git push origin main`
    * ※ 100MB超えのファイルがある場合【Git LFS】を利用する必要がある

## ローカルPCにリポジトリフォルダが既にありアップデートしたい場合
1. 該リポジトリフォルダに移動する
    * `cd BennkyouNote`
2. ブランチが`main`の場合
    * `git pull origin main`
  
## Git LFSの使い方
* フォルダA　に　`sharedassets0.resource`　というファイルがある
* 今回はフォルダB（リポジトリ同名内のフォルダ）とのフォルダに移動させたい
* ※ 下記やり方は、Git LFSをダウンロードできてる前提ですすめる
* ※ ダウンロードページ、[Git LFS 公式サイト](https://git-lfs.com/)

1. 該リポジトリフォルダに移動し、Git LFS をリポジトリで有効化 (このコマンドは 1回だけ 実行すればOK)
    * `cd C:\Users\q1352\OneDrive\桌面\プログラミング関連\GitHub管理\BennkyouNote`
    * `git lfs install`
2. ブランチが`main`の場合
    * `git pull origin main`
3. `.resource` ファイルを Git LFS で管理対象にする  
    * `git lfs track "*.resource"`
    * ※ この設定は `.gitattributes` ファイルに記録され
4. ファイルをリポジトリの適切なフォルダへ移動
    * 下記二つの書き方どちらでも可。改行で書くときに【`】を挟む必要があることを示す(PowerShell)  

```
Move-Item -Path "フォルダA\sharedassets0.resource" /`
          -Destination "フォルダB"

Move-Item -Path "移動するファイルまたはフォルダのパス" -Destination "移動先のフォルダのパス"
```
5. ブランチが`main`の場合
    * `cd リポジトリフォルダ`
    * `git add .gitattributes`
    * `git add フォルダB/sharedassets0.resource`
    * `git commit -m "Add sharedassets0.resource using Git LFS"`　、今回はGit LFSでコミットするとの旨を
    * `git push origin ブランチ名`
