# RspecSample.rb

=begin
$ export GEM_HOME=$HOME/.gems
$ export PATH=$PATH:$GEM_HOME/bin
$ gem install bundle
$ bundle install
$ bundle exec rspec --init
$ echo '--format=doc' >> .rspec
$ bundle exec rspec
=end

describe 'arithmetic test' do
  context 'addition' do
    it 'add test' do
      (1 + 1) == 2
    end
  end
  context 'subtract' do
    it 'sub test' do
      (1 - 2) == -1
    end
  end
end

