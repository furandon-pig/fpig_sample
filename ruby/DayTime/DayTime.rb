#!/usr/bin/env ruby
# coding: utf-8

require 'date'

tn = Time.now
yy = tn.year
mm = tn.month
dd = tn.day

d = Date.new(yy, mm, dd)

puts "year = #{d.year}"
puts "month= #{d.month}"
puts "day  = #{d.day}"  
puts "hour = #{tn.hour}"
puts "min  = #{tn.min}"
puts "sec  = #{tn.sec}"

