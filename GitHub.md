# リポジトリ　repositories
GitHubでリポジトリの作成（git init）、または複製（git clone）する  
ファイルの作成、編集を行う  
ファイルの作成/変更/削除をGitのインデックスに追加する（git add）  
変更結果をローカルリポジトリにコミットする（git commit）(コミットメッセージを残しておくのおすすめ)  
ローカルリポジトリをプッシュしてリモートリポジトリへ反映させる（git push）  

# 作成者の設定
git config --global user.name "名前"  
git cinfig --global user.email "メール名"  

# リポジトリの作成
git init	ローカルリポジトリの作成  
git status　⇒　現在の作業ディレクトリの状態を表示  

* git add -A　⇒　全部、ワークツリー全体の変更（追加、変更、削除）を一度にステージングします。  
* git add .　⇒　カレントディレクトリ以下の追加・変更ファイルのみステージング  
* git add 指定したいファイル名  
* git add 指定したいフォルダ名/  

git commit -m"コメントメッセージ"  
git log　⇒　プロジェクトのコミット履歴（ハッシュ値も得れる）  

# コミットされたくないファイルの指定方法  
.gitignoreのテキストファイルを作る  
ファイル指定：【/ファイル名】  
フォルダ：【/フォルダ名/】  

# ブランチの作成
git checkout -b feature/user_login  
git checkout feature/user_login  
git checkout main  

# マージ
git merge feature/user_login 今いるmainに対して、feature/user_loginをマージする  

# ロールバック方法
git reset --hard <commit番号>（commit番号⇒git statusから参照できる）  
git revert <commit番号>（commit番号⇒git statusから参照できる）  

# 紐付け
git remote add （リモートリポジトリ名）（リモートリポジトリURL）⇒リモートリポジトリの追加（ローカルと紐づけ）  
※ 通常「リモートリポジトリ名」はorigin  
※ URLはgithubのコードからHTTPSリンクをコピー  
https://github.com/kidinjp/JavaBennkyouNote.git  
⇓  
https://（ユーザー名：アクセストークン＠）github.com/kidinjp/JavaBennkyouNote.git  
⇓  
https://kidinjp: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@github.com/kidinjp/JavaBennkyouNote.git  

# git push -u （リポジトリ名　ローカルブランチ名：リモートブランチ名）
リモートのブランチにアップロード（上流ブランチを設定）  
git push -u origin main  
※失敗した場合一回統合してみてください：  
git pull origin main --rebase  

# GitHubからPCへ
git clone （HTTPS　URL）  
https://（ユーザー名：アクセストークン＠）github.com/kidinjp/JavaBennkyouNote.git  

# スタッシュ
git stash　⇒　作業途中の変更をスタッシュ
git checkout main　⇒　mainブランチに移動

# mainでの修正を行う
git commit -am "Hotfix in main branch"
git checkout feature-A 　⇒　作業ブランチに戻る
git stash apply　⇒　作業を再開するためスタッシュした変更を戻す
