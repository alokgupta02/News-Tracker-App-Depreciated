function getName() {
	var e = document.getElementById("memberId");
	var text = e.options[e.selectedIndex].text;
	var value = e.options[e.selectedIndex].index;
	localStorage.setItem("name", text);
	localStorage.setItem("value", value);
}

function setName() {
	document.getElementById('name').textContent = localStorage.getItem("name");
	var val = localStorage.getItem("value");
	document.getElementById('memberId').selectedIndex = val;
}

function clearStorage(){
	localStorage.clear();
}