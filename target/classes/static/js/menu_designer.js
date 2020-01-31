//var socket = io('http://localhost:8080/');

var selected = [];
var string = "";

var status = 0;

function select(id) {
	document.getElementById(id).style.display 	   = "none";
	document.getElementById(id+"_s").style.display = "inline-block";
	selected.push(id);
}

function deselect(id) {
	document.getElementById(id).style.display 						   = "none";
	document.getElementById(id.substr(0, id.length - 2)).style.display = "inline-block";
	selected.splice(selected.indexOf(id.substr(0, id.length - 2)), 1);
}

function next() {
	string += document.getElementById('question').value;
	for (var i = 0; i < selected.length; i++) {
		string += "#-#";
		string += selected[i];
		document.getElementById(selected[i]  +"_s").style.display 	= "none";
		document.getElementById(selected[i] ).style.display 		= "inline-block";
	}
	selected = [];
	string += "-#-"
	document.getElementById('question').value = "";
}

function finish() {
	if(status == 0) {
		next();
		document.getElementById('question').placeholder 	= "Name des Menüs";
		document.getElementById('food_list').style.display 	= "none";
		document.getElementById('next').style.display 		= "none";
		status++;
	} else if(status == 1) {
		string += document.getElementById('question').value; 
		send("str=" + string, 'create-menu');
		document.getElementById('question').value = "Abgesendet";
		status++;
	} else {
		console.log("RELOAD");
		location.reload();
	}
}


