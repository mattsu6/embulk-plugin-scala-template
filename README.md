# Emublk Plugin Scala Template
Embulk pluginをScala+sbtで作成する時のテンプレートです.

# 実行方法
- 各テンプレートのディレクトリで `./gradlew classpath`を実行
- `embulk run -I lib ./example.yml` で実行

exmaple.yml (input-pluginの場合)
```yaml
in:
    type: template
    option1: 1
    option2: example2
    columns: []
out:
    type: stdout
```