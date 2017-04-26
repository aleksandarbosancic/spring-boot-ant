var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

var ws;
var ws1;

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
        stompClient.subscribe('/topic/images', function (image) {
            //showImage(JSON.parse(image.body).content);
            showImage(image.body);
        });
    });
    
    // Let us open a web socket
    ws = new WebSocket("ws://localhost:8080/text");

    ws.onopen = function()
    {
       // Web Socket is connected, send data using send()
       ws.send("image");
    };

    ws.onmessage = function (evt) 
    { 
       var received_msg = evt.data;
       console.log('message is received: ' + evt.data);
    };

    ws.onclose = function()
    { 
       // websocket is closed.
       alert("Connection is closed..."); 
    };
    
    // Let us open a web socket
    ws1 = new WebSocket("ws://localhost:8080/binary");

    ws1.onopen = function()
    {
       // Web Socket is connected, send data using send()
       var uint8array = new TextEncoder("utf-8").encode("image");
       ws1.send(uint8array.buffer);
    };
    
    ws1.onmessage = function (evt) 
    { 
       var received_msg = evt.data;
       console.log('message is received: ' + evt.data);
       
        var reader = new window.FileReader();
        reader.readAsDataURL(received_msg); 
        reader.onloadend = function() {
            var base64data = reader.result;                
            showImage1(base64data);
        };
    };

    ws1.onclose = function(e)
    { 
       // websocket is closed.
       alert("Connection is closed..."); 
    };
    
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function getImage() {
    stompClient.send("/app/images", {}, JSON.stringify({'name': $("#image").val()}));
}
function getImageBinary() {
    var uint8array = new TextEncoder("utf-8").encode($("#image").val());
    ws1.send(uint8array.buffer);
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}
function showImage(image) {
    $("#images").append("<img class='img-thumbnail' src='" + image + "' alt='Nema slike' />");
}
function showImage1(image) {
    $("#images").append("<img class='img-thumbnail' src='" + image + "' alt='Nema slike' />");
}

$(function () {
    //$("form").on('submit', function (e) {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
    $( "#get" ).click(function() { getImage(); });
    $( "#get1" ).click(function() { getImageBinary(); });
});

