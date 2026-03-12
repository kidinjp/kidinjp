概要
* [ServletサーブレットとJSPの基本概念](#servletサーブレットとjspの基本概念)
  * [参考になるWebサイト](#参考になるwebサイト)
* [HelloWorld.java](#helloworldjava)
* [web.xml](#webxml)
* [JSP](#jsp)
  * [JSPタグの書き方](#jspタグの書き方)
  * [.jspファイルのみを作成してみる](#jspファイルのみを作成してみる)
  * [ServletからJSPを呼び出す](#servletからjspを呼び出す)
* [Tomcatの再起動を不要にする設定](#tomcatの再起動を不要にする設定)
* [ターミナルでの操作](#ターミナルでの操作)
  * [今いるディレクトリを確認](#今いるディレクトリを確認)
  * [今いるディレクトリ内にあるフォルダ内容一覧を確認](#今いるディレクトリ内にあるフォルダ内容一覧を確認)
  * [Javaのバージョン確認](#javaのバージョン確認)
  * [Tomcatを呼び出す](#tomcatを呼び出す)
  * [Tomcatの起動](#tomcatの起動)
  * [Tomcatの停止](#tomcatの停止)
  * [コンパイル](#コンパイル)
  * [ファイル位置を移動させる](#ファイル位置を移動させる)
  * [ファイルをコピーして新ファイルの名前を設定する](#ファイルをコピーして新ファイルの名前を設定する)
  * 
***************************************************************************
# ServletサーブレットとJSPの基本概念
* ルーティング
  * Webブラウザからのリクエストに合わせて呼び出す処理を切り替える機能
* テンプレートエンジン
  * アプリケーションが保持するデータやプログラムが処理した結果をhtmlの雛形と組み合わせてWEBページとして出力する機能
* フォーム処理
* GETメソッドとPOSTメソッド
* データベース  

【**JavaでWebアプリを開発するには**】  
* Servlet：サーバー上でJavaを実行する処理
* JSP（Javaサーバーページズ）：HTMLの中にJavaのコードを埋め込んで、動的にWebページを生成する技術
  * 同じくサーバー上でJavaを実行する処理。主にWebアプリケーションの表示部分を担当
* Tomcat：ServletやJSPを実行する**サーバー用アプリケーション**。サーブレットコンテナとも呼ばれている

```
tomcat
├ conf/Catalina/localhost/mywork.xml # このファイルを設定することでTomcatの再起動を不要にする設定することも可能
└─ webapps
        └─ mywork
                ├─ HelloWorld.java
                ├─ HelloServlet.java
                ├─ HelloTemplate.jsp
                └─ WEB-INF
                        ├─ classes
                        │      ├─ HelloWorld.classes
                        │      └─ HelloServlet.classes
                        ├─ views
                        │      └─ index.jsp
                        └─ web.xml
```

## 参考になるWebサイト
- Javaの道＞Servlet・JSP
https://www.javaroad.jp/servletjsp/index.html

- Servletアプリ開発：目次 - Web系開発メモ
http://web-dev.hatenablog.com/entry/java/servlet/dev-restful-app/table-of-contents

- Java Servlet - Wikipedia
https://ja.wikipedia.org/wiki/Java_Servlet

- JavaServer Pages - Wikipedia
https://ja.wikipedia.org/wiki/JavaServer_Pages

***************************************************************************
# HelloWorld.java
```Java
// HelloWorld Servlet 
// serlvet を実行するために必要なライブラリをコードに組み込む
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet {
    
    // doGetメソッド：このプログラムを呼び出したときにTomcatが自動的に呼び出すメソッド
    // HtttpSerlvetRequest request：servletを呼び出した時のリクエストを対応したオブジェクト
    // HttpServletResponse response：servletからの出力に対応したオブジェクト
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
            
            response.setContentType("text/html");
            // servletでhtmlを直接に出力するために利用する
            PrintWriter out = response.getWriter();
            
            out.println("<html><head>paiza</head></body>");
            out.println("<p>Hello World!</p>");
            out.println("</body></html>");
        }
    
}
```

***************************************************************************
# web.xml
* ルーティング：Webアプリケーションにおけるルーティングは、Webブラウザからのリクエストに合わせて、呼び出す処理を切り替える機能
* 複数のアドレスを割り当てることができる
* 下記コードの場合、各ページのパスはこうなる：
  * `http://(ドメイン):8080/mywork/hello` ⇒ HelloWorld.classの内容
  * `http://(ドメイン):8080/mywork/servlet` ⇒ HelloServlet.classの内容
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
        http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
        version="4.0" metadata-complete="true">

    <servlet>
        <servlet-name>Hello</servlet-name>
        <servlet-class>HelloWorld</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>Hello</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>

    <servlet>
        <servlet-name>Servlet</servlet-name>
        <servlet-class>HelloServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>Servlet</servlet-name>
        <url-pattern>/servlet</url-pattern>
    </servlet-mapping>
</web-app>
```

***************************************************************************
# JSP
* JavaServer Pages
* HTMLの中にJavaコードを記述
* Webページとして出力
* Servletからテンプレートとして呼び出し
* HTMLとしてメンテナンスことが可能
* 繰り返し部分をコードで出力
* データと見た目を分離できる

## JSPタグの書き方
* <%@ %> JSPの宣言(ディレクティブ)
* <%! %> 変数やメソッドの宣言
* <%= %> 式の評価結果を出力
* <% %> コードを実行 ※ %でJavaのコードを実行する場合、末尾にセミコロンが必要
* <%-- --%> コメント  

【**Javaファイルで、`request.setAttribute()`を利用することでJSPにデータを渡す**】
```Java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowTemplate extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
        
        // jspにデータ（キーと値）を渡すコード
        // messageがデータのキー、hello World!がデータの内容
        // 下記例のように変数での代入・同時に複数のキーを渡すことも可能
        String message = "hello ";
        request.setAttribute("message1", message + "World!");
        request.setAttribute("message2", message + "Everyone!");
        
        String view = "/WEB-INF/views/index.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
```

【**JSPファイルでのキーの扱い方**】
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello Template</title>
    </head>
    <body>
        <h1>Hello JSP</h1>
        <strong><%= new java.util.Date() %></strong>
        
        <% String message = (String)request.getAttribute("message"); %>
        <p><%= message %></p>
    </body>
</html>
```

【**この例だと以下内容が出力される**】
```
Hello JSP
Thu Mar 06 11:42:54 UTC 2025(現在時刻のため固定値ではない)
hello World!
```

## .jspファイルのみを作成してみる
* JSPのコンパイルは、Tomcatが自動的に行うので、ブラウザからアクセスするだけで結果を表示することができる
* 下記コードの場合：`http://(ドメイン):8080/mywork/HelloTemplate.jsp`

ファイル名：`HelloTemplate.jsp`  
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello Template</title>
    </head>
    <body>
        <h1>Hello Template</h1>
        <%= new java.util.Date() %> <!-- javaのコード -->
    </body>
</html>
```

## ServletからJSPを呼び出す
手順：【`index.jsp` JSPファイルを用意する（今回扱うのは前項の`HelloTemplate.jsp`と同じ内容）】
⇒【`ShowTemplate.java`】
⇒それをコンパイル
⇒【`web.xml`】  
⇒この例のパスは【`http://(ドメイン):8080/mywork/show`】  

【**ShowTemplate.java**】ファイルを作る
```Java
// HelloWorld Servlet

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowTemplate extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

            // 呼び出し先のjspファイルを指定する
            String view = "/WEB-INF/views/index.jsp";
            // 他のプログラムに処理を切り替えるためのオブジェクトを用意
            RequestDispatcher dispacher = request.getRequestDispatcher(view);
            // 処理を呼び出し先に伝送するメソッド
            dispacher.forward(request, response);
    }
}
```

【web.xml】でサーブレット設定
```xml
    <servlet>
        <servlet-name>Template</servlet-name>
        <servlet-class>ShowTemplate</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>Template</servlet-name>
        <url-pattern>/show</url-pattern>
    </servlet-mapping>
```

***************************************************************************
# Tomcatの再起動を不要にする設定
`tomcat/conf/Catalina/localhost/mywork.xml`
```
<Context
reloadable="true"/>
```

***************************************************************************
# ターミナルでの操作
## 今いるディレクトリを確認
pwd

## 今いるディレクトリ内にあるフォルダ内容一覧を確認
ls

## Javaのバージョン確認
java -version

## Tomcatを呼び出す
http://(ドメイン):8080/

## Tomcatの起動
tomcat/bin/startup/sh

## Tomcatの停止
tomcat/bin/shutdown/sh

## コンパイル
tomcat/webapps/work/ にあるHelloWorld.javaをコンパイルした例

cd tomcat/webapps/work/
javac -classpath "../../lib/servlet-api.jar" HelloWorld.java
javac -classpath "../../lib/servlet-api.jar" -d WEB-INF/classes HelloWorld.java

`-classpath "../../lib/servlet-api.jar"`このオプションでservletに必要なclassライブラリのある場所を教えてあげる
`HelloWorld.java`コンパイルするソースファイルを指定する

## ファイル位置を移動させる
tomcat/webapps/work/ にあるHelloWorld.classをtomcat/webapps/work/WEB-INF/classesに移動させた例

cd tomcat/webapps/work/
mv HellpWorld.class WEB-INF/classes

## ファイルをコピーして新ファイルの名前を設定する
cp HelloWorld.java HelloWorld2.java
