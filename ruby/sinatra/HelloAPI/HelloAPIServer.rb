#!/usr/bin/env ruby
# coding: utf-8

require 'sinatra'
require 'json'

=begin
 * Listen *:4567
```
$ curl \
    --silent \
    -XGET http://localhost:4567/show \
    | jq
{
  "id": 1,
  "title": "message",
  "content": "hello,world"
}
$ curl \
    --silent \
    -XPOST http://localhost:4567/edit \
    -d '{"id":7,"title":"hello","content":"world"}' \
    | jq
"{\"id\":7,\"title\":\"hello\",\"content\":\"world\"}"
```
=end

get '/show' do
  article = {
    id: 1,
    title: 'message',
    content: 'hello,world'
  }.to_json
end

post '/edit' do
  body = request.body.read
  if body == ''
    status 400
  else
    body.to_json
  end
end

