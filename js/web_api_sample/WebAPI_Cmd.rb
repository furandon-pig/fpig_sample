#!/usr/bin/env ruby
# coding: utf-8

require 'net/http'
require 'uri'

[
  'http://localhost:38080/',
  'http://localhost:38080/hello',
].each do |url|
  url = URI.parse(url)
  req = Net::HTTP::Get.new(url.path)
  res = Net::HTTP.start(url.host, url.port) do |http|
    http.request(req)
  end
  puts res.body
end

