#!/usr/bin/env ruby
# coding: utf-8

:a!

require 'date'
def getTimeStamp()
  mon_elm = [
    "Jan", "Feb", "Mar", "Apr", "May", "Jun",
    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
  ]

  t = Time.now
  d = Date.new(t.year, t.month, t.day)

  sprintf "%04d%s%02d-%02d%02d",
    d.year, mon_elm[d.month], d.day, t.hour, t.min
end

puts getTimeStamp()

