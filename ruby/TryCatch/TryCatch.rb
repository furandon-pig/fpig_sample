#!/usr/bin/env ruby
# coding: utf-8

begin
  func()
rescue Exception => e
  puts e.message
  puts e.backtrace.inspect
ensure
  puts '-=> encure'
end

