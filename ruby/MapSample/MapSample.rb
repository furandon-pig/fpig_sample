#!/usr/bin/env ruby
# coding: utf-8

result = [1,2,3,4,5,6,7,8,9,10].map{|n| n * 10}
puts "#{result}"

sum = [1,2,3,4,5,6,7,8,9,10].inject{|sum, n| sum + n}
puts "sum= #{sum}"

