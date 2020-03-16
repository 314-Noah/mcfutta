
function sleep(milliseconds) {
  const date = Date.now();
  let currentDate = null;
  do {
    currentDate = Date.now();
  } while (currentDate - date < milliseconds);
}

function update(id) {
	send(id, 'orders/increment');
    	sleep(200);
	location.reload(true);
}

function reload() {
	location.reload(true);
}
