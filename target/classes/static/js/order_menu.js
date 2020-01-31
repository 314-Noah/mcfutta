
const seperator = "-#-"
var selected = "";

function init() {
	selected = document.getElementsByTagName('body')[0].title; //MENU id
}

function select(id, divID, last) { //Food id

	if(divID == '0') init();

	selected += seperator;
	selected += id;

	document.getElementById(divID).style.display 			= "none";
	if(last) {
		document.getElementById('send_p').style.display 	= "block";
		send(selected, "create-order");
		setTimeout('location = "http://localhost:8080/"',3750);
	} else {
		document.getElementById(next(divID)).style.display 	= "block";
	}
}

function next(id) {
	return parseInt(id) + 1;
}
