var requestURL = 'http://localhost:8080/todolist';								// Set the base url.

function populateTodoList(target) {												// A function to populate the div #todoList. Receives a parameter describing the target within the API gateway (don't know if this is how it's called but I mean the entry point to the rest resource)
	var todoList = document.getElementById('todoList')							// A variable to locate the div #todoList.
	var request = new XMLHttpRequest();											// Initialize an XMLHttpRequest to communicate with Spring MVC.

	request.open('GET', requestURL + target, true);								// Configure a request using Get method, and the requestURL + target 
	request.onreadystatechange = function () {									// Initialize the communication.
		if (request.readyState == 4 && request.status === 200) {				// If communication is established and is done,
			var items = JSON.parse(request.responseText);						// parse the json response as item,
			var tbltop = `<table>
								<tr><th>Description</th><th>Completed?</th></tr>`;// build a header for the items.
			var rows = "";														// Initialize a variable to hold all item's innerHtml
			for (i = 0; i < items.length; i++) {								// Step through the json response: item.
				rows += "<tr><td>" + items[i].description + "</td><td>" + items[i].completed + "</td></tr>"; // Concatenate items into the table rows.
			}
			var tblbottom = "</table>";											// End the table.
			var todoListtbl = tbltop + rows + tblbottom;						// Concatenate all pieces.
			todoList.innerHTML = todoListtbl;									// Write to the todolist innerHTML.
		}
	};
	request.send();																// Send the request.
}


function createEventListeners() {
	
	// IMPORTANT: ToDo despite displaying on http://localhost:8080/todolist/todo, not able to display it on http://localhost:8080/
	var todoButton = document.getElementById('todo');
	todoButton.addEventListener("click", function() {populateTodoList("/todo");}, false);
	
	// IMPORTANT: Complete despite displaying on http://localhost:8080/todolist/complete, not able to display it on http://localhost:8080/
	var completeButton = document.getElementById('complete');
	completeButton.addEventListener("click", function() {populateTodoList("/complete");}, false);
	
	// Sort
	var sortButton = document.getElementById('sort');
	sortButton.addEventListener("click", function() {populateTodoList("/all/sorted");}, false);	
		
	// Shuffle
	var shuffleButton = document.getElementById('shuffle');
	shuffleButton.addEventListener("click", function() {populateTodoList("/all/shuffled");}, false)
}


window.onload = function () {													// On window.load
	populateTodoList("/all");													// Populate TodoList with all. Note that this could be changed to todo or complete to illustrate that they work.
	createEventListeners();														// Load event listeners for buttons and calling different functions to trigger the service in Spring MVC.
	
}