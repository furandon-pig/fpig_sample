#!/usr/bin/env node

var fs = require('fs');
var file_name = process.argv[2] == undefined ? 'hello.txt' : process.argv[2];

fs.readFile(file_name, 'utf8', function(err, line) {
	console.log(line);
});

