$(function() {
	function fullscreen() {
		var el = document.getElementById("containerInteractionNetwork");
		if (el.webkitRequestFullScreen) {
			el.webkitRequestFullScreen();
		} else {
			el.mozRequestFullScreen();
		}
	}
	document.getElementById("fullScreenBtn").addEventListener("click",
			fullscreen);
});
