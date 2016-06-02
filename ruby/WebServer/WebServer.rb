#!/usr/bin/env ruby
# coding: utf-8

require 'webrick'

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

trap(:INT) { server.shutdown() }
server.start()

