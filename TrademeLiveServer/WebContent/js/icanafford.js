var renderer, camera, scene;
//set up renderer
var clearColor = new THREE.Color(1.000000, 0.938686, 0.768151);
renderer = new THREE.WebGLRenderer({ antialias: false });
renderer.setClearColor(clearColor);
renderer.setSize(window.innerWidth, window.innerHeight);
document.body.appendChild(renderer.domElement);
//set up camera
var ASPECT = window.innerWidth / window.innerHeight;
camera = new THREE.PerspectiveCamera(75, ASPECT, 0.1, 1000);
camera.position.z = 10;
camera.rotation.y = .5;
//set up scene
scene = new THREE.Scene();

var nzmap = loadNZMap();
scene.add(nzmap);

var listings = loadListings();
scene.add(listings);

var highlight = loadHighlight();
scene.add(highlight);


// $.getJSON("json/" + maxPrice).done(function (data) {

// 	console.log(data);

// });

// render();

// $("#maxPriceForm").submit(function () {

// 	var maxPrice;
// 	maxPrice = $("#maxPriceInput").val();

// 	$.getJSON("/TrademeLiveServer/api/getlisting?price=" + maxPrice).done(function (data) {

// 		console.log(data);

// 	});
// });

render();

function render () 
{
	requestAnimationFrame(render);
	renderer.render(scene,camera);
}

document.addEventListener( 'mousemove', function ( event ) {

	var w = window.innerWidth;
	var h = window.innerHeight;

	var x = event.clientX;
	var y = event.clientY;

	var cz = camera.position.z;

	camera.position.x = 2 + 5*(x-w/2)/w/Math.sqrt(cz);
	camera.position.y = 5*(h-y/2)/h/Math.sqrt(cz);
});	

document.addEventListener("mousewheel", function (event) {

	var delta = Math.max(-1, Math.min(1, (event.wheelDelta || -event.detail)));

	camera.position.z -= delta;
});