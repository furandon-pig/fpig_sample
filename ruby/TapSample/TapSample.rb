#!/usr/bin/env ruby
# coding: utf-8

def func(x)
  if x == true
    "hello"
  else
    "world"
  end.tap {|r| print "#{r}\n" }
end

func(true)
func(false)

