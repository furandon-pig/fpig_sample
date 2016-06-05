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

server.mount_proc('/') do |req,res|
  html = <<_EOS
<html>
  <head>
    <title>hello</title>
  </head>
  <body>
    <p>hello,world.</p>
  </body>
</html>
_EOS
  res.content_type = 'text/html'
  res.content_length = html.length
  res.body = html
end

# curl -s -XGET http://localhost:38080/json | jq .
server.mount_proc('/json') do |req,res|
  data = {
    id: 3,
    items: [ 'apple', 'grape', 'orange' ]
  }
  json = data.to_json

  res.content_type = 'application/json; charset=utf-8'
  res.content_length = json.length
  res.body = json
end

trap(:INT) { server.shutdown() }
server.start()

