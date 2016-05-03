#!/usr/bin/env node

var msg = "The quick brown fox jumps over the lazy dog" + ' ';
var len = msg.length;
var idx = 0;

while ((idx = idx % len + 1) != len) {
	front = msg.substr(idx, (len - idx));
	rear = msg.substr(0, idx);

	console.log(front + rear);
}

