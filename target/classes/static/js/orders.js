
function update(id) {
	send(id, 'orders/increment');
	location.reload(true);
}

function reload() {
	location.reload(true);
}