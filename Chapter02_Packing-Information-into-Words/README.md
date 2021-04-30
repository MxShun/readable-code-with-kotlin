# 2章 名前に情報を詰め込む *Packing Information into Words*
情報を詰め込んだ名前の付け方

- 明確な単語を選ぶ
- 汎用的な名前を避ける
- 抽象的な名前よりも具体的な名前を使う
- 接尾辞や接頭辞を使って情報を追加する
- 名前の長さを決める
- 名前のフォーマットで情報を伝える

### 2.1 明確な単語を選ぶ *Choose Specific Words*
get → インターネットから取ってくるなら fetch や download

size → 目的に合わせて height や numNodes や memoryBytes

stop → 動作に合わせて kill や Resume や Pause

| 単語 | 代替案 |
| --- | --- |
| send | delivery, dispatch, announce, distribute, route |
| find | search, extract, locate, recover |
| start | launch, create, begin, open |
| make | create, set up, build, generate, compose, add, new |

### 2.2 汎用的な名前を避ける *Avoid Generic Names*
バグを早期に発見するため、少しでも時間を使っていい名前を考える習慣をつけよう。

いい名前というのは、変数の目的や値を表すものだ。

### 2.3 抽象的な名前よりも具体的な名前を使う *Prefer Concrete Names over Abstract Names*
メソッドの動作を想定しやすくなり。意図しない使われ方を防ぐ。

### 2.4 名前に情報を追加する *Attaching Extra Information to a Name*
16進数の文字列を持つ id があった場合には、 hexId のようにする。

時間やバイト数のように計測できる者であれば、変数名に単位を入れるといいだろう。

| 関数の仮引数 | 単位を追加した仮引数 |
| --- | --- |
| Start(delay: Int) | delay → delaySecs |
| CreateCache(size: Int) | size → sizeMb |
| ThrottleDownload(limit: Float) | limit → maxKbps |
| Rotate(angle: Float) | angle → degreesCw |

危険や注意を喚起する情報も追加した方がいい。

| 状況 | 変数名 | 改善後 |
| --- | --- | --- |
| password はプレーンテキストなので、処理をする前に暗号化すべきである。 | password | plaintextPassword |
| ユーザが入力した comment は表示する前にエスケープする必要がある。 | comment | unescapedComment |
| html の文字コードを UTF-8 に変えた。 | html | htmlUtf8 |
| 入力された data をURLエンコードした。 | data | urlencodedData |

### 2.5 名前の長さを決める *How Long Should a Name Be?*
長い名前は覚えにくいし、画面を大きく占領してしまう。折返しが必要になれば、コード行が無駄に増えてしまう。
ただし、スコープが小さければ短い名前でもいい。

プロジェクト固有の省略形は控えた方がよい。新しくプロジェクトに参加した人は、暗号のように見えて怖いと思うだろう。

「新しいチームメイトはその名前の意味を理解できるだろうか？」

プログラマは、 document の代わりに doc を使う。 string の代わりに str を使う。
新しいチームメンバーでも FormatStr() の意味は理解できる。

名前に含まれる単語を削除しても情報がまったく損なわれないこともある。 ConvertToString() を短くして ToString() にしても、必要な情報は損なわれない。

### 2.6 名前のフォーマットで情報を伝える *Use Name Formatting to Covey Meaning*
キャメルケースやスネークケースの統一、メンバ変数はアンダースコアの接尾辞を加える、jQueryのライブラリ関数を呼び出したときには変数名の頭に $ をつけるなどエンティティごとに異なるフォーマットを使うことで、一種のシンタックスハイライトを実現することができる。