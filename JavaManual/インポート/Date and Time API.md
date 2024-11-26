概要
* [Date and Time APIの特徴](#date-and-time-apiの特徴)
* [主なクラス一覧](#主なクラス一覧)
  * [LocalDate【年-月-日】](#localdate年-月-日)
    * [現在の日付](#現在の日付)
    * [特定の日付](#特定の日付)
    * [日付操作_進む](#日付操作_進む)
    * [日付操作_遡る](#日付操作_遡る)
  * [LocalTime【時:分:秒.ナノ秒】](#localtime時分秒ナノ秒)
    * [現在の時刻](#現在の時刻)
    * [特定の時刻](#特定の時刻)
    * [時刻の操作_進む](#時刻の操作_進む)
    * [時刻の操作_遡る](#時刻の操作_遡る)
  * [LocalDateTime【年-月-日T時:分:秒】](#localdatetime年-月-日t時分秒)
    * [現在の時間](#現在の時間)
  * [ZonedDateTime【年-月-日T時:分:秒+GMT時差\[州/地区\]】](#zoneddatetime年-月-日t時分秒gmt時差州地区)
    * [デフォルトタイムゾーン(GMT +0)](#デフォルトタイムゾーンgmt-0)
    * [特定のタイムゾーン日時を取得](#特定のタイムゾーン日時を取得)
    * [タイムゾーン変更](#タイムゾーン変更)
    * [タイムゾーンID一覧](#タイムゾーンid一覧)
  * [Instant【年-月-日T時:分:秒.ナノ秒Z】](#instant年-月-日t時分秒ナノ秒z)
    * [現在の時刻を取得](#現在の時刻を取得)
    * [特定の時刻を指定](#特定の時刻を指定)
    * [時間の前後比較【Boolean】](#時間の前後比較boolean)
    * [変換](#変換)
  * [Duration【PT時H分M秒.ナノ秒S】](#durationpt時h分m秒ナノ秒s)
    * [二つの時間においでの差分](#二つの時間においでの差分)
    * [時間を取得](#時間を取得)
    * [指定単位で全体の差分](#指定単位で全体の差分)
  * [Period【P年Y月M日D】](#periodp年y月m日d)
    * [二つの日付においでの差分](#二つの日付においでの差分)
    * [日付差を取得](#日付差を取得)
  * [DateTimeFormatter](#datetimeformatter)
    * [フォーマットパターン指定](#フォーマットパターン指定)
    * [標準のフォーマッター](#標準のフォーマッター)
    * [パターン適用【String】](#パターン適用string)
    * [文字列からパース](#文字列からパース)


***************************************************************************
## Date and Time APIの特徴
* `import java.time.*;`
* 旧来のDateやCalendarの欠点を補う、より直感的で使いやすい日付と時間操作のためのAPI
* このAPIは、スレッドセーフであり、明確で読みやすいコードを書くのに役立つ
* スレッドセーフ性：旧来のjava.util.Dateやjava.util.Calendarの非スレッドセーフ性の問題を解消
* 可読性の向上：明確な命名規則と直感的なAPIにより、複雑な操作が簡略化されている

***************************************************************************
## 主なクラス一覧
1. `ローカル`な日時：
    * `LocalDate`、`LocalTime`、`LocalDateTime`を使用
    * タイムゾーンが不要な場合に適している
2. `タイムゾーン`を扱う日時：
    * `ZonedDateTime`または`OffsetDateTime`を使用
    * タイムゾーンやオフセットを管理する必要がある場合
3. `タイムスタンプ`
    * `Instant`でUTC基準の時刻を管理
    * 多くのデータベースや外部システムで利用される形式
4. `期間`の操作
    * 短い時間単位：`Duration`
    * 長い時間単位（年月日）：`Period`

| クラス名 | 説明 |
| --- | --- |
| [LocalDate](#localdate年-月-日) | 日付のみを表現する（年、月、日） |
| [LocalTime](#localtime時分秒ナノ秒) | 時間のみを表現する（時、分、秒） |
| [LocalDateTime](#localdatetime年-月-日t時分秒) | 日付と時間を表現する（タイムゾーンなし） |
| [ZonedDateTime](#zoneddatetime年-月-日t時分秒gmt時差州地区) | 日付と時間に加えてタイムゾーンも扱う |
| [Instant](#instant年-月-日t時分秒ナノ秒z) | タイムスタンプ（1970-01-01からの秒） |
| [Duration](#durationpt時h分m秒ナノ秒s) | 時間の間隔を扱う |
| [Period](#periodp年y月m日d) | 年、月、日単位の期間を扱う |
| [DateTimeFormatter](#datetimeformatter) | 日付と時間のフォーマット/パースを行う |

***************************************************************************
### LocalDate【年-月-日】
#### 現在の日付
LocalDate date = LocalDate.now();

#### 特定の日付
LocalDate date = LocalDate.of(yyyy, mm, dd);

#### 日付操作_進む
date.plusYears(x);  
date.plusMonths(x);  
date.plusDays(x);

#### 日付操作_遡る
date.minusYears(x);  
date.minusMonths(x);  
date.minusDays(x);

```Java
LocalDate today = LocalDate.now();
System.out.println(today); // 【2024-11-25】と出力される
```

***************************************************************************
### LocalTime【時:分:秒.ナノ秒】
#### 現在の時刻
LocalTime time = LocalTime.now();  
※ 秒の時間は正確に【13:58:45.496093480】のような小数点以下9桁まで取る

#### 特定の時刻
LocalTime time = LocalTime.of(hh, mm, ss);  

#### 時刻の操作_進む
time.plusHours(x);  
time.plusMinutes(x);  
time.plusSeconds(x);

#### 時刻の操作_遡る
time.minusHours(x);  
time.minusMinutes(x);  
time.minusSeconds(x);
```Java
LocalTime time = LocalTime.now();
System.out.println(time);  // 【13:58:45.496093480】と出力される
```

***************************************************************************
### LocalDateTime【年-月-日T時:分:秒】
#### 現在の時間
LocalDateTime time = LocalDateTime.now();  
※ その他操作は`LocalDate`や`LocalTime`と同じ  
※ 【2024-11-25T13:58:45.496093480】のような出力結果となる（ナノ秒）

***************************************************************************
### ZonedDateTime【年-月-日T時:分:秒+GMT時差\[州/地区\]】
`import java.time.ZonedDateTime;`  
`import java.time.ZoneId;`

#### デフォルトタイムゾーン(GMT +0)
ZonedDateTime now = ZonedDateTime.now();  または  
ZonedDateTime zonedDateTime = LocalDateTime.now().atZone(ZoneId.systemDefault());  または  
ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.systemDefault());

#### 特定のタイムゾーン日時を取得
ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));

#### タイムゾーン変更
now.withZoneSameInstant(ZoneId.of("America/New_York"));

```Java
// 現在日時をデフォルトタイムゾーンで取得
ZonedDateTime now = ZonedDateTime.now();
System.out.println("現在日時（デフォルトタイムゾーン）: " + now);

// 特定のタイムゾーンで日時を取得
ZonedDateTime tokyoTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
System.out.println("東京の現在日時: " + tokyoTime);

// タイムゾーンを変更
ZonedDateTime newYorkTime = tokyoTime.withZoneSameInstant(ZoneId.of("America/New_York"));
System.out.println("ニューヨーク時間: " + newYorkTime);
```
※ 取得時の時間によって秒のミリの部分は違ってくるので、特に上記コードの場合、それぞれの秒の細かい内容は違う

#### タイムゾーンID一覧
ZoneId.getAvailableZoneIds()  
上記の【HashSet】でゾーンid一覧を取得できる（長さ601）  

**よく使うID一覧：**
| タイムゾーン ID | 対応する地域 | GMT± |
| --- | --- | --- |
| Japan<br>Asia/Tokyo | 日本標準時 (JST) | +9 |
| Asia/Taipei | 台北標準時 (TST) | +8 |
| PRC<br>Asia/Shanghai | 中国標準時 (CST) | +8 |
| America/Los_Angeles | 米国太平洋標準時 (PST) | -8 |
| America/Chicago | 米国中部標準時 (CST) | -6 |
| America/New_York | 米国東部標準時 (EST) | -5 |
| Europe/London | グリニッジ標準時 (GMT) | 0 |
| UTC | 協定世界時 (UTC) | 0 |
| Europe/Paris | 中央ヨーロッパ時間 (CET) | +1 |
| Asia/Kolkata | インド標準時 (IST) | +5:30 |
| Australia/Sydney | オーストラリア東部標準時 (AEST) | +10 |
| Etc/GMT+1 | 直接に時差を入れる方法<br>左例：GMT-1:00 | -1 |

***************************************************************************
### Instant【年-月-日T時:分:秒.ナノ秒Z】
`import java.time.Instant;`  
※ plusやminusの動作を行うことは可能  
※ タイムゾーンを含まない  
※ 多くのデータベースはInstantの形式（UTC）をネイティブにサポートしている
| 特徴 | LocalDateTime | Instant |
| --- | --- | --- |
| タイムゾーン | タイムゾーンなし<br>ローカル時間を表現する | UTC基準（協定世界時）<br>タイムゾーンに依存しない |
| 用途 | ユーザーのローカル時間やカレンダーの日付・時刻を操作する | グローバルで一意な時刻を扱う場合に使用（タイムゾーンを顧慮せず、時間間隔の計測など） |
| 精度 | ナノ秒まで | ナノ秒まで |
| 保存形式 | 年/月/日 時:分:秒:ナノ秒<br>例: 2024-11-26T15:30:45.123 | 1970-01-01T00:00:00Z（エポック時）からの秒数とナノ秒 |
| 主な使いどころ | ユーザーが認識するローカル日時の操作、表示、フォーマット<br>ローカル時間に基づく操作や表示<br>タイムゾーンが不要な場合に適している | システムやデータベースの時刻保存<br>UTCベースの演算<br>時刻データの一意性が必要な場合に適している<br>タイムゾーンに依存しないグローバルな時間計測や保存 |
| タイムゾーン変換 | タイムゾーンの情報を持たないため、明示的にタイムゾーンを指定する必要がある | タイムゾーン変換なし（UTC基準）<br>`ZonedDateTime`を介してローカル日時へ変換可能 |
| 具体例 | `LocalDateTime.now()`| Instant.now()|

#### 現在の時刻を取得
Instant time = Instant.now();

#### 特定の時刻を指定
Instant time = Instant.ofEpochSecond(0);  
※ `1970-01-01T00:00:00Z`スタート  
※ 1_000_000_000秒指定すると`2001-09-09T01:46:40Z`となる

#### 時間の前後比較【Boolean】
```Java
Instant time1 = Instant.ofEpochSecond(0);
Instant time2 = Instant.ofEpochSecond(1_000_000_000);
System.out.println(time1.isAfter(time2)); // time1 は time2 より後なのか、false
System.out.println(time1.isBefore(time2)); // time1 は time2 より前なのか、true
```

#### 変換
* **LocalDateTime**  
LocalDateTime localDateTime = LocalDateTime.ofInstant(time, ZoneId.systemDefault()); // UTC → ローカル日時

* **ZonedDateTime**  
ZonedDateTime tokyoTime = time.atZone(ZoneId.of("Asia/Tokyo")); // タイムゾーン指定

***************************************************************************
### Duration【PT時H分M秒.ナノ秒S】
時分秒単位での差分を求める  
※ plusやminusの動作を行うことは可能  
※ 0の項目があれば該項目は省略する【PT1S】など

```Java
LocalTime start = LocalTime.of(10, 0);
LocalTime end = LocalTime.of(12, 30);

Duration duration = Duration.between(start, end);
System.out.println("時間差: " + duration.toHours() + "時間 " + duration.toMinutes() + "分");
```

#### 二つの時間においでの差分
Duration time = Duration.between(start, end);

#### 時間を取得
time.getSeconds();  
time.getNano();

#### 指定単位で全体の差分
time.toHours();  
time.toMinutes();  
time.toSeconds();  
time.toNanos();
```Java
LocalTime start = LocalTime.now();
end = end.plusSeconds(5);
end = end.plusMinutes(5);

Duration duration = Duration.between(start, end);
System.out.println(duration.getSeconds()); // 秒以上の差分：305
System.out.println(duration.getNano()); // ナノ秒の差分：454169
System.out.println(duration.toNanos()); // 全体（秒+ナノ秒など）のナノ秒差分：305000454169
```

***************************************************************************
### Period【P年Y月M日D】
年月日単位での差分を求める  
※ plusやminusの動作を行うことは可能  
※ `LocalDateTime`で計算することは不可能。基本は`LocalDate`で行う

#### 二つの日付においでの差分
Period time = Period.between(start, end);

#### 日付差を取得
time.getYears();  
time.getMonths();  
time.getDays();

***************************************************************************
### DateTimeFormatter
日付や時刻のフォーマットとパースを行う  
`import java.time.format.DateTimeFormatter;`

#### フォーマットパターン指定
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("時間形式の指定");  
`import java.util.Locale;`を利用することで、特定の地域の時間の表記仕方に変更することが可能となる  
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("時間形式の指定", `Locale.JAPAN`);

**※ 主なパターン記号**
| 単位 | 書き方 | 実際の表現 | Locale.JAPAN |
| --- | --- | --- | --- |
| 年 | `y`または`yyyy`<br>`yy` ⇒ 西暦2桁 | 2024<br>24 | 同左 |
| 月 | `M`<br>`MM`<br>`MMM` ⇒ 月の名前(Jul)<br>`MMMM` ⇒ 月の名前(July) | 1<br>01<br>Jan<br>January | 1<br>01<br>1月<br>1月 |
| 日 | 1. 単純な日付を表す<br>　`d`<br>　`dd`<br>2. 今年から該日付までのトータル日数<br>　`D`または`DDD` | <br>5<br>05<br><br>123 | 同左 |
| 時 | 1. 24時間制<br>　`H`<br>　`HH`<br>2. 12時間制<br>　`h`<br>　`hh`<br>※午前または午後を記述する場合【`a`】を付ける | <br>5<br>05<br><br>5<br>05<br>【a hh】⇒ AM 05 | <br>5<br>05<br><br>5<br>05<br>【a hh】⇒ 午前 05 |
| 分 | `m`<br>`mm` | 5<br>05 | 同左 |
| 秒 | `s`<br>`ss` | 3<br>03 | 同左 |
| ナノ秒 | `n`<br>`nnnnnnnnn`【9桁を超えると0埋めされるのでおすすめしない】 | - | - |
| 午前/午後 | `a` | AM/ PM | 午前/ 午後 |
| タイムゾーン名 | ※ `ZonedDateTime`/ `OffsetDateTime`のデータ型使用可能<br>1. タイムゾーンの名前を表す<br>　`z`<br>2. タイムゾーンのオフセットを表す<br>　`Z`<br>3. ISO 8601形式のタイムゾーンを表す<br>　`XXX` | <br><br>GMT、PSTなど<br><br>+0900、-0800など<br><br>+09:00、-08:00など | <br><br>JST<br><br>+0900<br><br>+09:00 |
| 曜日 | `E`または`EEEE` | Mon | 月 |

#### 標準のフォーマッター
* `ISO_DATE`：yyyy-MM-dd
* `ISO_TIME`：HH:mm:ss
* `ISO_DATE_TIME`：yyyy-MM-dd'T'HH:mm:ss
* `RFC_1123_DATE_TIME`：EEE, dd MMM yyyy HH:mm:ss zzz (HTTP形式)

```Java
DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_DATE_TIME;`
String formattedDate = LocalDateTime.now().format(isoFormatter);
```

#### パターン適用【String】
時間.format(formatter);

#### 文字列からパース
フォーマットに沿った時間文字列を、`LocalDateTime`型のオブジェクトに戻す
```Java
LocalDateTime now = LocalDateTime.now();
// フォーマットを指定
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
String formattedDate = now.format(formatter);
System.out.println("フォーマット済み日時: " + formattedDate);

// 文字列から日時をパース
String dateString = "2024/11/20 14:30:00";
LocalDateTime parsedDate = LocalDateTime.parse(dateString, formatter);
System.out.println("パースされた日時: " + parsedDate);
```
