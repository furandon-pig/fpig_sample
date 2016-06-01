#!/usr/bin/env ruby
# coding: utf-8

[
  { id:1, name:'hello' },
  { id:2, name:'world' },
].each do|item|
  print "#{item[:id]},#{item[:name]}\n"
end

