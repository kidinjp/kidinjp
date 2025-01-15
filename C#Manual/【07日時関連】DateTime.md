概要
* [DateTimeについて](#DateTimeについて)
* [主なプロパティ一覧](#主なプロパティ一覧)
  * [日付と時刻を取得](#日付と時刻を取得)
  * [年を取得](#年を取得)
  * [月を取得](#月を取得)
  * [日を取得](#日を取得)
  * [時間部分を取得](#時間部分を取得)
  * [時を取得](#時を取得)
  * [分を取得](#分を取得)
  * [秒を取得](#秒を取得)
  * [曜日を取得](#曜日を取得)
  * [現在の日時ローカル](#現在の日時ローカル)
  * [現在のUTC日時ローカル](#現在のutc日時ローカル)
  * [現在日時のローカル](#現在日時のローカル)
  * [主なメソッド一覧](#主なメソッド一覧)
  * [年を加算または減算](#年を加算または減算)
  * [月を加算または減算](#月を加算または減算)
  * [日を加算または減算](#日を加算または減算)
  * [時間を加算または減算](#時間を加算または減算)
  * [分を加算または減算](#分を加算または減算)
  * [秒を加算または減算](#秒を加算または減算)
  * [日時の比較](#日時の比較)
  * [文字列との変換](#文字列との変換)
    * [日時を文字列に変換](#日時を文字列に変換)
    * [タイムゾーン](#タイムゾーン)
    * [オフセット](#オフセット)
    * [ロケール](#ロケール)
    * [タイムゾーン、オフセット、ロケールの違い](#タイムゾーンオフセットロケールの違い)
    * [文字列を日時に変換](#文字列を日時に変換)
  * [指定した年は閏年であるかどうか【boolean】](#指定した年は閏年であるかどうかboolean)
  * [指定した年と月の日数を取得](#指定した年と月の日数を取得)
  * [タイムゾーン設定](#タイムゾーン設定)
  * [グローバルに日時操作を統一する](#グローバルに日時操作を統一する)
  * [タイムゾーン一覧](#タイムゾーン一覧)

***************************************************************************
## DateTimeについて
* `System.DateTime`
  * DateTimeクラスは、日付と時刻を表現するために使用される、C#で非常に重要なクラス
  * このクラスを使えば、特定の日時の取得・計算・操作が可能
* 基本的な特徴
  * 日付と時刻の値を管理（例: 年、月、日、時、分、秒、ミリ秒）
  * **タイムゾーン**や**ローカル時間**と**UTC**（協定世界時）を扱える
  * **不変（Immutable）型**：変更不可のため、新しい日時の値を生成するときは、新しいインスタンスを返す  

宣言と初期化
```C#
DateTime now = DateTime.Now;
DateTime nextWeek = now.AddDays(7); // 1週間後
DateTime lastMonth = now.AddMonths(-1); // 1ヶ月前
DateTime specificDate = new DateTime(2025, 1, 4, 12, 30, 45); // 2025年1月4日12時30分45秒
```
なお、便宜を図って、以下はDateTime型のnowを使用する前提で説明する
DateTime now = DateTime.Now;

## 主なプロパティ一覧

### 日付と時刻を取得
now.Date  
※ デフォの日付形式は以下通り【m/d/yyyy hh:mm:ss AM】  
※ 時刻は常に00:00:00（午前0時0分0秒）  
※ 例：【1/14/2025 12:00:00 AM】

### 年を取得
now.Year

### 月を取得
now.Month

### 日を取得
now.Day

### 時間部分を取得
now.TimeOfDay
※ デフォの日付形式は以下通り【hh:mm:ss】ssの部分は小数点以下を取る  
※ 例：【07:59:51.9894080】

### 時を取得
now.Hour

### 分を取得
now.Minute

### 秒を取得
now.Second
※ 小数点以下は取らない

### 曜日を取得
now.DayOfWeek  
※ 英語曜日（フルネーム）

### 【0001-01-01】からの経過時間
now.Ticks
※ 100ナノ秒単位
※ 例：638724401473443040

### 現在の日時ローカル
DateTime.Now

### 現在のUTC日時ローカル
DateTime.UtcNow

### 現在日時のローカル
DateTime.Today

## 主なメソッド一覧
インスタンスの生成
* DateTime.Now: 現在の日時を取得（ローカル時間）
* DateTime.UtcNow: 現在の日時を取得（UTC）
* DateTime.Today: 今日の日付のみ取得（時刻は00:00:00）
* カスタム日時: 
```C#
DateTime specificDate = new DateTime(2025, 1, 4, 12, 30, 45); // 2025年1月4日12時30分45秒
```

### 年を加算または減算
now.AddYears(x);  
※ xの型はdouble型に対応不可能、int型のみ  
※ xがマイナスの場合減算となる

### 月を加算または減算
now.AddMonths(x);  
※ xの型はdouble型に対応不可能、int型のみ  
※ xがマイナスの場合減算となる

### 日を加算または減算
now.AddDays(x);  
※ xの型はdouble型やint型に対応可能    
※ xがマイナスの場合減算となる

### 時間を加算または減算
now.AddHours(x);  
※ xの型はdouble型やint型に対応可能  
※ xがマイナスの場合減算となる

### 分を加算または減算
now.AddMinutes(x);  
※ xの型はdouble型やint型に対応可能  
※ xがマイナスの場合減算となる

### 秒を加算または減算
now.AddSeconds(x);  
※ xの型はdouble型やint型に対応可能  
※ xがマイナスの場合減算となる

### 日時の比較
Compare(time1, time2);
* -1: t1 < t2 (t1の時間はt2よりはやい)
* 0: t1 == t2
* 1: t1 > t2

### 文字列との変換
#### 日時を文字列に変換
```C#
Console.WriteLine(now.ToString("yyyy-MM-dd HH:mm:ss"));
```
* 年
  * yyyy: 西暦4桁(2025)
  * yy: 西暦下2桁(25)
* 月
  * MMMM: フル月名（ロケールに依存）（January）
  * MMM: 短縮月名（ロケール依存）（Jan）
  * MM: 2桁の月（01）
  * M: 1-2桁の月（ゼロパディングなし）（1）
* 日
  * dd: 2桁の日（01）
  * d: 1-2桁の日（ゼロパディングなし）（1）
* 時間
  * HH: 24時間制の時（00～23）
  * H: 24時間制の時（ゼロパディングなし）（0～23）
  * hh: 12時間制の時（01～12）
  * h: 24時間制の時（ゼロパディングなし）（01～12）
  * 例：12AM：00, 0, 12, 12
* 分
  * mm: 2桁の分（00～59）
  * m: 1-2桁の分（ゼロパディングなし）（0～59）
* 秒
  * ss: 2桁の秒（00～59）
  * s: 1-2桁の秒（ゼロパディングなし）（0～59）
* 午前/午後
  * tt: 午前または午後（ロケールに依存）（AM/PM）（午前/午後）
  * t: 午前または午後の先頭文字（ロケールに依存）（A/P）（午/午）※ 日本語表記の場合、一文字目のみを表示するため判別がつかなくなる
* 曜日
  * dddd: フル曜日名（ロケールに依存）（Monday）（月曜日）
  * ddd: 短縮曜日名（ロケールに依存）（Mon）（月）
* タイムゾーン
  * zzz: 時差（+hh:mm形式）(+09:00)
  * zz: 時差（+hh形式）(+09)
  * z: 時差（+h形式）(+9)
  * 反映させるにはオフセットを設定する必要がある

日本標準時のタイムゾーン設定方法：
```C#
// 現在のUTC時刻
DateTime utcNow = DateTime.UtcNow;

// 日本標準時（JST）のタイムゾーン
TimeZoneInfo jstZone = TimeZoneInfo.FindSystemTimeZoneById("Asia/Tokyo");

// JST に変換（DateTimeOffset を使用）
DateTimeOffset utcOffsetNow = new DateTimeOffset(utcNow, TimeSpan.Zero);
DateTimeOffset jstOffsetNow = TimeZoneInfo.ConvertTime(utcOffsetNow, jstZone);

// 出力
Console.WriteLine($"UTC: {utcOffsetNow}");
Console.WriteLine($"UTC Offset: {utcOffsetNow.ToString("zzz, zz, z")}");
Console.WriteLine($"JST: {jstOffsetNow}");
Console.WriteLine($"JST Offset: {jstOffsetNow.ToString("zzz, zz, z")}");

/* 出力内容：
UTC: 1/15/2025 12:30:15 PM +00:00
UTC Offset: +00:00, +00, +0
JST: 1/15/2025 9:30:15 PM +09:00
JST Offset: +09:00, +09, +9
*/
```

なお、曜日について、英語表記や日本語表記の違いがあり、以下のようなロケール変更方法がある：
```C#
using System;
using System.Globalization;

class Program
{
    static void Main()
    {
        DateTime now = new DateTime(2025, 1, 14); // サンプル用の日付

        // 日本語ロケール
        var japaneseCulture = new CultureInfo("ja-JP");

        Console.WriteLine(now.ToString("dddd", japaneseCulture)); // 火曜日
        Console.WriteLine(now.ToString("ddd", japaneseCulture));  // 火

        // 英語ロケール
        var englishCulture = new CultureInfo("en-US");

        Console.WriteLine(now.ToString("dddd", englishCulture)); // Tuesday
        Console.WriteLine(now.ToString("ddd", englishCulture));  // Tue
    }
}
```

アプリ全体で日本語ロケールを使用：
```C#
using System;
using System.Globalization;
using System.Threading;

class Program
{
    static void Main()
    {
        // アプリ全体のカルチャを日本語に設定
        Thread.CurrentThread.CurrentCulture = new CultureInfo("ja-JP");
        Thread.CurrentThread.CurrentUICulture = new CultureInfo("ja-JP");

        DateTime now = DateTime.Now;

        Console.WriteLine(now.ToString("dddd")); // 火曜日
        Console.WriteLine(now.ToString("ddd"));  // 火
    }
}
```
#### タイムゾーン
タイムゾーンは **地理的な位置** に基づいた時間の基準を表す  

* 特徴
  * タイムゾーンには「名前」があります。例: Asia/Tokyo、Eastern Standard Time
  * 夏時間 (DST: Daylight Saving Time) の考慮が含まれる場合がある
  * タイムゾーンの変化 (夏時間の切り替えなど) を考慮する必要があるときに使用する
* 主なクラスとメソッド
  * TimeZoneInfo クラス: タイムゾーンを扱うためのクラス
  * 例: 日本標準時を指定して時間を変換する
```C#
TimeZoneInfo jstZone = TimeZoneInfo.FindSystemTimeZoneById("Asia/Tokyo");
DateTime utcNow = DateTime.UtcNow;
DateTime jstNow = TimeZoneInfo.ConvertTimeFromUtc(utcNow, jstZone);
Console.WriteLine(jstNow);
```

#### オフセット
オフセットは、ある時間が UTC (協定世界時) からどれだけ離れているかを示す「時間差」を表す  

* 特徴
  * タイムゾーンの一部と言えますが、単純に「UTCとの差」に限定される
  * 夏時間や歴史的なタイムゾーン変更は考慮されない
  * オフセットだけを扱う場合はタイムゾーンより軽量
* 主なクラスとメソッド
  * DateTimeOffset クラス: 日時とそのオフセットを扱う
  * 例: UTC から +9 時間のオフセットを持つ日時を作成
```C#
TimeSpan offset = TimeSpan.FromHours(9);
DateTimeOffset dateTimeOffset = new DateTimeOffset(DateTime.UtcNow, offset);
Console.WriteLine(dateTimeOffset);
```

#### ロケール
ロケールは 文化や言語の設定 を表し、日時の表示やフォーマットを制御する  

* 特徴
  * 表示フォーマットや文字列変換で使われる
  * 数字、通貨、日付の形式がロケールに依存する
  * 実際の日時や時間帯には影響しない
* 主なクラスとメソッド
  * CultureInfo クラス: 言語や地域に基づいた情報を管理
  * 例: 日本語のロケールを使用して日時を表示
```C#
var japaneseCulture = new CultureInfo("ja-JP");
DateTime now = DateTime.Now;
Console.WriteLine(now.ToString("yyyy年MM月dd日 dddd", japaneseCulture));
```

#### タイムゾーン、オフセット、ロケールの違い
| 概念 | 用途 | 実際の影響 | クラス/メソッド |
| --- | --- | --- | --- |
| タイムゾーン | 地域ごとの時間の違いを管理 | 時間変換（夏時間なども考慮） | `TimeZoneInfo` |
| オフセット | UTCからの時間差を表す（タイムゾーンの一部） | 夏時間や複雑なタイムゾーンは無視 | `DateTimeOffset` |
| ロケール | 日付や数字の表示形式を文化と言語に合わせる | 表示のフォーマットのみ | `CultureInfo` |

#### 文字列を日時に変換
```C#
DateTime date;
if (DateTime.TryParse("2025-01-04", out date))
{
    Console.WriteLine(date); // 2025/01/04 0:00:00
{
```

### 指定した年は閏年であるかどうか【boolean】
DateTime.IsLeapYear(now.Year);  
※ 括弧の内容はintに対応するためDateTime自体を入れることはできない

### 指定した年と月の日数を取得
DateTime.DaysInMonth(now.Year, now.Month);  
※ 括弧の内容はintに対応するためDateTime自体を入れることはできない  
※ 例：2024, 9を入れた場合答えは29となる

### タイムゾーン設定
`TimeZoneInfo` を利用する

```C#
using System;

class Program
{
    static void Main()
    {
        // 現在のUTC時刻
        DateTime utcNow = DateTime.UtcNow;

        // タイムゾーンを指定 (例: 日本標準時 JST)
        TimeZoneInfo jstZone = TimeZoneInfo.FindSystemTimeZoneById("Tokyo Standard Time");
        DateTime jstNow = TimeZoneInfo.ConvertTimeFromUtc(utcNow, jstZone);

        Console.WriteLine($"UTC: {utcNow}");
        Console.WriteLine($"JST: {jstNow}");
    }
}
```
#### グローバルに日時操作を統一する
アプリケーション全体で統一されたタイムゾーンを使いたい場合、次のような方法が有効  
アプローチ: カスタム日時の取得メソッドを作成
```C#
using System;

class Program
{
    // アプリ全体で使用するタイムゾーンを設定
    private static readonly TimeZoneInfo CustomTimeZone = TimeZoneInfo.FindSystemTimeZoneById("Tokyo Standard Time");

    public static DateTime GetLocalDateTime()
    {
        return TimeZoneInfo.ConvertTimeFromUtc(DateTime.UtcNow, CustomTimeZone);
    }

    static void Main()
    {
        DateTime customNow = GetLocalDateTime();
        Console.WriteLine($"Custom Local Time: {customNow}");
    }
}
```

#### タイムゾーン一覧
以下内容は、TimeZoneInfo.GetSystemTimeZones()の内容を全出力した結果  
利用する際は下記例のように記述する  
* UTC: "UTC"
* 日本標準時 (JST): "Tokyo Standard Time"
* アメリカ東部時間: "Eastern Standard Time"
```
Pacific/Niue
Pacific/Midway
Pacific/Pago_Pago
Pacific/Rarotonga
Pacific/Tahiti
Pacific/Honolulu
America/Adak
Pacific/Marquesas
Pacific/Gambier
America/Nome
America/Sitka
America/Metlakatla
America/Anchorage
America/Juneau
America/Yakutat
Pacific/Pitcairn
America/Vancouver
America/Los_Angeles
America/Tijuana
America/Phoenix
America/Boise
America/Denver
America/Dawson
America/Hermosillo
America/Fort_Nelson
America/Dawson_Creek
America/Creston
America/Mazatlan
America/Inuvik
America/Cambridge_Bay
America/Ciudad_Juarez
America/Edmonton
America/Whitehorse
Pacific/Easter
Pacific/Galapagos
America/Resolute
America/Winnipeg
America/El_Salvador
America/Belize
America/Swift_Current
America/Costa_Rica
America/Rankin_Inlet
America/Regina
America/North_Dakota/Beulah
America/Indiana/Tell_City
America/Mexico_City
America/Merida
America/Monterrey
America/Matamoros
America/Chihuahua
America/Tegucigalpa
America/Chicago
America/Guatemala
America/Bahia_Banderas
America/Managua
America/Ojinaga
America/Indiana/Knox
America/Menominee
America/North_Dakota/New_Salem
America/North_Dakota/Center
America/Lima
America/Bogota
America/Guayaquil
America/Rio_Branco
America/Eirunepe
America/Havana
America/Panama
America/Cancun
America/Atikokan
America/Iqaluit
America/Toronto
America/Grand_Turk
America/Jamaica
America/Nassau
America/Port-au-Prince
America/Cayman
America/Indiana/Winamac
America/Indiana/Indianapolis
America/Indiana/Marengo
America/Kentucky/Monticello
America/Kentucky/Louisville
America/Detroit
America/New_York
America/Indiana/Petersburg
America/Indiana/Vevay
America/Indiana/Vincennes
America/Boa_Vista
America/Asuncion
America/La_Paz
America/Manaus
America/Santiago
America/Porto_Velho
America/Campo_Grande
America/Caracas
America/Cuiaba
America/Guyana
America/Barbados
America/Marigot
America/St_Thomas
America/Martinique
America/Curacao
America/Montserrat
America/Dominica
America/Santo_Domingo
America/Antigua
America/Anguilla
America/St_Vincent
America/Puerto_Rico
America/Aruba
America/Grenada
America/Thule
America/Tortola
America/Guadeloupe
America/St_Kitts
America/Glace_Bay
America/St_Lucia
America/Halifax
Atlantic/Bermuda
America/Goose_Bay
America/Kralendijk
America/Moncton
America/St_Barthelemy
America/Blanc-Sablon
America/Port_of_Spain
America/Lower_Princes
America/St_Johns
America/Argentina/San_Juan
America/Argentina/Mendoza
Atlantic/Stanley
America/Argentina/San_Luis
America/Argentina/La_Rioja
America/Punta_Arenas
America/Argentina/Rio_Gallegos
America/Sao_Paulo
America/Araguaina
America/Argentina/Catamarca
America/Cayenne
America/Argentina/Buenos_Aires
America/Argentina/Cordoba
America/Argentina/Tucuman
America/Maceio
America/Argentina/Salta
Antarctica/Rothera
America/Argentina/Ushuaia
America/Recife
America/Montevideo
America/Santarem
America/Paramaribo
Antarctica/Palmer
America/Bahia
America/Miquelon
America/Fortaleza
America/Belem
America/Argentina/Jujuy
America/Noronha
America/Scoresbysund
Atlantic/South_Georgia
America/Nuuk
Atlantic/Azores
Atlantic/Cape_Verde
Antarctica/Troll
Africa/Monrovia
Atlantic/Reykjavik
Africa/Nouakchott
Africa/Bissau
Europe/Isle_of_Man
Europe/Jersey
Africa/Bamako
Europe/Guernsey
Africa/Banjul
Africa/Lome
Africa/Sao_Tome
Africa/Freetown
Africa/Dakar
Atlantic/St_Helena
Africa/Conakry
Africa/Abidjan
Europe/London
Africa/Ouagadougou
Africa/Accra
America/Danmarkshavn
Atlantic/Faroe
Europe/Lisbon
Atlantic/Madeira
Atlantic/Canary
Africa/Casablanca
Africa/El_Aaiun
Arctic/Longyearbyen
Europe/Vaduz
Europe/Amsterdam
Europe/Luxembourg
Europe/Oslo
Europe/Monaco
Europe/Podgorica
Europe/Malta
Europe/Warsaw
Europe/Vatican
Europe/Skopje
Europe/Belgrade
Europe/Stockholm
Africa/Tunis
Europe/Bratislava
Europe/San_Marino
Europe/Ljubljana
Europe/Andorra
Europe/Gibraltar
Europe/Sarajevo
Europe/Berlin
Europe/Zurich
Europe/Prague
Europe/Vienna
Europe/Zagreb
Europe/Rome
Europe/Paris
Europe/Tirane
Europe/Busingen
Africa/Ceuta
Europe/Madrid
Africa/Algiers
Europe/Copenhagen
Europe/Brussels
Europe/Budapest
Europe/Dublin
Africa/Bangui
Africa/Douala
Africa/Porto-Novo
Africa/Brazzaville
Africa/Niamey
Africa/Kinshasa
Africa/Lagos
Africa/Libreville
Africa/Luanda
Africa/Malabo
Africa/Ndjamena
Africa/Maputo
Africa/Windhoek
Africa/Juba
Africa/Khartoum
Africa/Kigali
Africa/Blantyre
Africa/Lubumbashi
Africa/Harare
Africa/Gaborone
Africa/Lusaka
Africa/Bujumbura
Asia/Beirut
Europe/Vilnius
Europe/Sofia
Europe/Riga
Asia/Famagusta
Asia/Nicosia
Africa/Tripoli
Europe/Helsinki
Europe/Athens
Europe/Kaliningrad
Europe/Mariehamn
Europe/Chisinau
Asia/Gaza
Asia/Hebron
Europe/Tallinn
Europe/Kyiv
Europe/Bucharest
Africa/Cairo
Asia/Jerusalem
Africa/Johannesburg
Africa/Mbabane
Africa/Maseru
Asia/Aden
Asia/Kuwait
Asia/Riyadh
Antarctica/Syowa
Europe/Istanbul
Asia/Qatar
Asia/Baghdad
Asia/Damascus
Asia/Amman
Asia/Bahrain
Europe/Minsk
Africa/Dar_es_Salaam
Indian/Comoro
Africa/Kampala
Africa/Djibouti
Indian/Antananarivo
Africa/Asmara
Africa/Addis_Ababa
Indian/Mayotte
Africa/Nairobi
Africa/Mogadishu
Europe/Moscow
Europe/Kirov
Europe/Volgograd
Europe/Simferopol
Asia/Tehran
Europe/Astrakhan
Europe/Saratov
Europe/Ulyanovsk
Asia/Dubai
Asia/Baku
Indian/Mahe
Asia/Yerevan
Europe/Samara
Indian/Mauritius
Indian/Reunion
Asia/Muscat
Asia/Tbilisi
Asia/Kabul
Asia/Dushanbe
Asia/Oral
Antarctica/Mawson
Asia/Samarkand
Asia/Tashkent
Asia/Atyrau
Indian/Kerguelen
Antarctica/Vostok
Indian/Maldives
Asia/Yekaterinburg
Asia/Aqtau
Asia/Aqtobe
Asia/Qostanay
Asia/Qyzylorda
Asia/Almaty
Asia/Ashgabat
Asia/Karachi
Asia/Colombo
Asia/Kolkata
Asia/Kathmandu
Asia/Urumqi
Asia/Thimphu
Asia/Dhaka
Asia/Bishkek
Asia/Omsk
Indian/Chagos
Indian/Cocos
Asia/Yangon
Asia/Bangkok
Indian/Christmas
Asia/Hovd
Asia/Phnom_Penh
Asia/Ho_Chi_Minh
Asia/Novosibirsk
Asia/Barnaul
Asia/Tomsk
Asia/Novokuznetsk
Asia/Krasnoyarsk
Asia/Vientiane
Antarctica/Davis
Asia/Pontianak
Asia/Jakarta
Asia/Kuching
Asia/Ulaanbaatar
Asia/Singapore
Antarctica/Casey
Asia/Irkutsk
Asia/Brunei
Asia/Kuala_Lumpur
Asia/Choibalsan
Australia/Perth
Asia/Shanghai
Asia/Macau
Asia/Taipei
Asia/Hong_Kong
Asia/Manila
Asia/Makassar
Australia/Eucla
Pacific/Palau
Asia/Dili
Asia/Chita
Asia/Yakutsk
Asia/Khandyga
Asia/Tokyo
Asia/Pyongyang
Asia/Seoul
Asia/Jayapura
Australia/Broken_Hill
Australia/Darwin
Australia/Adelaide
Asia/Ust-Nera
Antarctica/DumontDUrville
Pacific/Port_Moresby
Pacific/Chuuk
Asia/Vladivostok
Antarctica/Macquarie
Australia/Melbourne
Australia/Sydney
Australia/Brisbane
Australia/Lindeman
Australia/Hobart
Pacific/Guam
Pacific/Saipan
Australia/Lord_Howe
Pacific/Pohnpei
Pacific/Noumea
Pacific/Norfolk
Asia/Magadan
Asia/Sakhalin
Asia/Srednekolymsk
Pacific/Guadalcanal
Pacific/Efate
Pacific/Bougainville
Pacific/Kosrae
Pacific/Fiji
Pacific/Kwajalein
Pacific/Wallis
Pacific/Wake
Pacific/Majuro
Pacific/Tarawa
Asia/Kamchatka
Pacific/Funafuti
Pacific/Nauru
Asia/Anadyr
Pacific/Auckland
Antarctica/McMurdo
Pacific/Chatham
Pacific/Apia
Pacific/Kanton
Pacific/Fakaofo
Pacific/Tongatapu
Pacific/Kiritimati
```
