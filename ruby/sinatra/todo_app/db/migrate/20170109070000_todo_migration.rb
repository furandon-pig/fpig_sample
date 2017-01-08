#!/usr/bin/env ruby
# coding: utf-8

require 'active_record'

class TodoMigration < ActiveRecord::Migration

  def up
    create_table(:todo_lists) do |t|
      # カラム名, データ型,  (制約)
      t.column :done,  :bool,   :null => false
      t.column :title, :string, :null => false
      t.column :note,  :string, :null => false
    end
  end

  def down
    drop_table :todo_lists
  end

end

