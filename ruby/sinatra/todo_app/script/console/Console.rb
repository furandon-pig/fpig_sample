#!/usr/bin/env ruby
# coding: utf-8

require 'yaml'
require 'json'
require 'logger'
require 'active_record'

config = YAML.load_file('config/database.yml')

ActiveRecord::Base.logger = Logger.new(STDOUT)
ActiveRecord::Base.establish_connection(config["db"]["development"])

class Items < ActiveRecord::Base
  self.table_name = 'todo_lists'
end

# DBの中身を表示してみる
if Items.all.length < 10
  puts "-=> Items.all"
  puts "id,done,title,note"
  Items.all.each do |item|
    puts "#{item.id},#{item.done},#{item.title},#{item.note}"
  end
end

