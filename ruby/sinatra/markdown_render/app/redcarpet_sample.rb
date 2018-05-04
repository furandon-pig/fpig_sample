
require 'uri'
require 'json'
require 'logger'
require 'sinatra'
require 'sinatra/cross_origin'
require 'redcarpet'

get '/' do
  erb :index
end

post '/preview' do
  begin
    renderer = Redcarpet::Render::HTML.new
    markdown = Redcarpet::Markdown.new(renderer, {tables: true, fenced_code_blocks: true})

    # GET => params["key–¼"]
    # POST => request.body.read
    md = String.new(URI.decode(request.body.read))
    html = markdown.render(md)
    html = html.gsub(/<table/, '<table class="table" ') # XXX

    {:res => URI.escape(html)}.to_json
  rescue
    '{"error":"Invalid Markdown text"}'
  end
end

