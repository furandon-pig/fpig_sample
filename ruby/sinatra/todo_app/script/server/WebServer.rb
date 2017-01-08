#!/usr/bin/env ruby
# coding: utf-8

require 'webrick'
require 'json'

options = {
  :BindAddress  => '127.0.0.1',
  :Port         => 8080,
  :DocumentRoot => './www',
}
server = WEBrick::HTTPServer.new(options)

trap(:INT) { server.shutdown() }
server.start()

