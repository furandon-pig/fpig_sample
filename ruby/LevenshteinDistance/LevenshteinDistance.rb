#!/usr/bin/env ruby
# coding: utf-8

require 'levenshtein'

module Levenshtein
  module_function
  def similarity(word1, word2)
    1 - Levenshtein.normalized_distance(word1, word2)
  end
end

if ARGV.length > 1
  word1 = ARGV[0]
  word2 = ARGV[1]
else
  word1 = "けんぶりっじ"
  word2 = "けぶんりっじ"
end

distance   = Levenshtein.normalized_distance(word1, word2)
similarity = Levenshtein.similarity(word1, word2)

distance   = distance.round(2)
similarity = similarity.round(2)

print("between '#{word1}' to '#{word2}'\n")
print("distance   = #{distance}\n")
print("similarity = #{similarity}\n")

