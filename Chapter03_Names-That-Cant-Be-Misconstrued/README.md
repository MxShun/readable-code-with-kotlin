# 3章 誤解をされない名前 *Chapter3 Names That Can't Be Misconstrued*
名前が他の意味と間違えられることはないだろうか？と何度も自問自答する。

### 3.1 例：filter() *Example: filter()*
選択するのか、除外するのかが曖昧な場合がある。選択する場合は select() 除外する場合は exclude() にしたほうがよい。

### 3.2 例：clip(text, length) *Example: clip(text, length)*
段落の内容を切り抜く関数 clip() があるとしよう。 clip() の動作は2つ考えられる。

- 最後から length 文字を削除する（remove）
- 最大 length 文字まで切り詰める（truncate）

それから maxLength にした方が明確になる。これで終わりじゃない。 maxLength もいろんな解釈ができる。

- バイト数
- 文字数
- 単語数

この場合は文字数を意味しているので、 maxLength ではなく maxChars にするといいだろう。

### 3.3 限界値含めるときは min と max を使う *Prefer min and max for (Inclusive) Limits*
上下限値を表すのに limit を使った場合、未満（限界値を含まない）のか以下（限界値を含む）なのかが分からず、古典的な「off-by-oneエラー」を引き起こす可能性がある。

### 3.4 範囲を指定するときは first と last を使う *Prefer first and last for Inclusive Ranges*
範囲を指定するのに start と stop を使った場合、 stop が複数の意味に解釈できるため誤解を招く可能性がある。包括的な範囲を表すのであれば first と last を使うのがいい。

### 3.5 包含/排他的範囲には begin と end を使う *Prefer begin and end for Inclusive/Exclusive Ranges*
10月16日の範囲を指定する場合のような包含/排他的範囲には begin と end を使うことが多い。

### 3.6 ブール値の名前 *Naming Booleans*
ブール値の変数やブール値を返す関数の名前を選ぶときには、true と false の意味を明確にしなければいけない。ブール値の変数名は、頭に is、has、can、should などをつけて分かりやすくすることが多い。

それから、名前を否定形にするのは避けた方がいい。

### 3.7 ユーザの期待に合わせる *Matching Expectations of Users*
例：get()

多くのプログラマは、get で始まるメソッドはメンバの値を返すだけの軽量アクセサであるという規約に慣れ親しんでいる。計算量が多い場合には、呼出しコストの高さが事前に分かるように compute() などの名前に変えるべきだろう。

例：list::size() （旧C++標準ライブラリ）

list.size() を他のコンテナと同じ高速な操作と誤認識したため、計算量がべき乗になった。（Kotlinにおける size メソッドの計算量は O(1) である。）

### 3.8 例：複数の名前を検討する *Example: Evaluating Multiple Name Candidates*
名前を決めるときには、複数の候補を検討すると思う。最終的に決める前に、それぞれ長所について話し合うのが普通だ。