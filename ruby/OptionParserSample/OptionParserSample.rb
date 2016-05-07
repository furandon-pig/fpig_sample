#!/usr/bin/env ruby
# coding: utf-8

require 'optparse'

param = {}

opt = OptionParser.new
opt.on('-a') {|v| param[:a] = v }
opt.on('-b arg') {|v| param[:b] = v }
opt.parse!(ARGV)

p param

