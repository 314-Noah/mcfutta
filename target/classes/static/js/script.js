
function send(string, target) {
	var r = null;
 
	if(window.XMLHttpRequest) {
		r = new XMLHttpRequest();
	} else if(window.ActiveXObject) {
		try {
			r = new ActiveXObject('Msxml2.XMLHTTP');
		}
		catch(e1) {
			try {
				r = new ActiveXObject('Microsoft.XMLHTTP');
			} catch(e2) {
				document.getElementById('status').innerHTML = 
				"Request nicht möglich.";
			}
		}		
	}
 
	
	if(r != null) {
		r.open('POST', 'http://localhost:8080/' + target);
		r.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		r.send(string);
	}
}