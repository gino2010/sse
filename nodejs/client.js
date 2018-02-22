var EventSource = require('eventsource');

var es = new EventSource("http://localhost:8080/stock/transaction");
es.onmessage = function (event) {
    console.log(event.data);
};