#!/usr/bin/enbv ruby
# coding: utf-8

require 'yaml'
require 'json'
require 'logger'
require 'sinatra'
require 'sinatra/cross_origin'
require 'active_record'

config = YAML.load_file('config/database.yml')

ActiveRecord::Base.logger = Logger.new(STDOUT)
ActiveRecord::Base.establish_connection(config["db"]["development"])

configure do
  # この設定がないとget/postでのcross_originがundefineになる...。
  register Sinatra::CrossOrigin

  enable :cross_origin
end

# DBのtodo_listsテーブルをItemsクラスに関連づける。
class Items < ActiveRecord::Base
  self.table_name = 'todo_lists'
end
begin
  CurrentID = Items.maximum(:id) + 1
rescue
  # レコードが0件だった場合
  CurrentID = 1
end

# ToDoの一覧を返す
get '/todo' do
  cross_origin
  Items.all.to_json
end

=begin
JavaScriptからPOSTメソッドでAPIを呼び出しても、
条件によって事前にOPTIONSメソッドが投げられる
ことがある。そのため、optionsについても
cross_origionを指定しないとHTTPアクセス制御に
引っかかってしまいエラーになってしまう。
=end

# ToDoアイテムを作成する。
options '/todo/new' do
  cross_origin
end
post '/todo/new' do
  cross_origin

  body = request.body.read
  status 400 if body == ''

  begin
    json = JSON.parse(body)
    item = Items.new(
      id:    CurrentID,
      done:  false,
      title: json["title"],
      note:  json["note"]
    )
    item.save

    item_id = CurrentID
    CurrentID = CurrentID + 1

    { id: item_id }.to_json
  rescue Exception => e
    puts e.message
    puts e.backtrace.inspect
  end
end

# ToDoアイテムを編集する。
options %r{^/todo/edit/([\d]+)} do |id|
  cross_origin
end
post %r{^/todo/edit/([\d]+)} do |id|
  cross_origin

  body = request.body.read
  status 400 if body == ''

  begin
    json = JSON.parse(body)
    item = Items.find_by(id: id)
    if item != nil
      item.title = json["title"]
      item.note  = json["note"]
    end
    item.save
  rescue Exception => e
    puts e.message
  end

  { id: id }.to_json
end

# ToDoアイテムのチェックを切り替える
options %r{^/todo/toggle/([\d]+)} do |id|
  cross_origin
end
post %r{^/todo/toggle/([\d]+)} do |id|
  cross_origin

  body = request.body.read
  status 400 if body == ''

  begin
    json = JSON.parse(body)
    p json
    item = Items.find_by(id: id)
    if json["done"] == true
      item.done = 't'
    else
      item.done = 'f'
    end
    item.save
  rescue Exception => e
    puts e.message
  end

  { id: id }.to_json
end

# ToDoアイテムを削除する。
options %r{^/todo/delete/([0-9]*?)} do
  cross_origin
end
get %r{^/todo/delete/([\d]+)} do |id|
  cross_origin

  item = Items.find_by(id: id)
  if item != nil
    item.destroy
    item.save
  end
end

