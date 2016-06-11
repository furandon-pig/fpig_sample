#!/usr/bin/env ruby
# coding: utf-8

require 'webrick'
require 'json'

options = {
  :BindAddress  => '127.0.0.1',
  :Port         => 38080,
  :DocumentRoot => '.',
}
server = WEBrick::HTTPServer.new(options)

# curl -s -XGET http://localhost:38080/json | jq .
[
  { path: '/', body: [ 'apple', 'grape', 'orange' ] },
].each do |conf|
  server.mount_proc(conf[:path]) do |req,res|
    json = conf[:body].to_json

    res.header["Access-Control-Allow-Origin"] = "*"
    res.header["Access-Control-Allow-Methods"] = "*"

    res.content_type = 'application/json; charset=utf-8'
    res.content_length = json.length
    res.body = json
  end
end

trap(:INT) { server.shutdown() }
server.start()

