# [html実行]
# python -m http.server 8000

# ------------------------------------------------------
# [ファイル分割] excel_to_csv
$excel = New-Object -ComObject Excel.Application
$excel.Visible = $false
$excel.DisplayAlerts = $false

$basePath = $PWD.Path
$outputFolder = Join-Path $basePath "ファイル"

if (!(Test-Path $outputFolder)) {
    New-Item -ItemType Directory -Path $outputFolder | Out-Null
}

$workbook = $excel.Workbooks.Open("$basePath\ファイル\基本情報技術者対策.xlsx")

# UTF8（BOMなし）のエンコーディング準備
$utf8NoBom = New-Object System.Text.UTF8Encoding $false

# 【役割：左から1番目から5番目のシートのみを処理対象にする】
for ($i = 1; $i -le 5; $i++) {
    $sheet = $workbook.Sheets.Item($i)
    if ($null -eq $sheet) { continue } # もしシートが5個未満だった場合の安全策

    $name = $sheet.Name
    $finalCsv = Join-Path $outputFolder "$name.csv"
    
    Write-Host "処理中 ($i/5): $name ..." -ForegroundColor Yellow
    
    $lines = New-Object System.Collections.Generic.List[string]
    $usedRange = $sheet.UsedRange
    $rowCount = $usedRange.Rows.Count
    $colCount = $usedRange.Columns.Count

    for ($r = 1; $r -le $rowCount; $r++) {
        $rowValues = @()
        for ($c = 1; $c -le $colCount; $c++) {
            # セルの表示テキストをそのまま取得
            $val = $usedRange.Cells.Item($r, $c).Text
            
            # CSV形式にするため、カンマ・改行・ダブルクォートが含まれる場合はエスケープ処理
            if ($val -like "*`n*" -or $val -like "*`r*" -or $val -like "*,*" -or $val -like '*"*') {
                $val = '"' + $val.Replace('"', '""') + '"'
            }
            $rowValues += $val
        }
        $lines.Add(($rowValues -join ","))
    }

    # 日本語を壊さずUTF-8で保存
    [System.IO.File]::WriteAllLines($finalCsv, $lines, $utf8NoBom)
}

$workbook.Close($false)
$excel.Quit()

Write-Host "完了！左から5つのシートを抽出しました。" -ForegroundColor Cyan
