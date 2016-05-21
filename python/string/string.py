#!/usr/bin/env python
# -*- coding: utf-8 -*-

msg = 'hello,world.'

print msg.capitalize()
print msg.upper()
print msg.upper().lower()

col = 80
print msg.center(col)

msg2 = 'hellohellohelloworld'
print msg2.count('hello')

msg3 = 'aaa,bbb,ccc'
print msg3.rsplit(',')
print len(msg3.rsplit(','))

print 'hello' + 'world'

