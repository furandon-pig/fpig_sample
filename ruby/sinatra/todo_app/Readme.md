
## セットアップ

```
$ bundle install --path vender/bundle
$ bundle exec rake migrate
$
$ # todo_listsテーブルが作成される
$ sqlite3 db/todo.db '.schema' | grep todo_lists
CREATE TABLE "todo_lists" ("id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "done" bool NOT NULL, "title" varchar NOT NULL, "note" varchar NOT NULL);
```

## サーバの起動

以下の2つのサーバを起動する

```
$ # Webサーバ
$ bundle exec ruby script/server/WebServer.rb
```

```
$ # WebAPIサーバ
$ bundle exec ruby script/server/ToDoAPI_Server.rb
```

## Webアプリにアクセスする

 * http://localhost:8080

## rails consoleっぽいことをする

```
$ bundle exec irb -r ./script/console/Console.rb
```

