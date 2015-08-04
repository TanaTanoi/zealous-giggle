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
// camera.rotation.y = .5;
//set up scene
scene = new THREE.Scene();

var nzmap = loadNZMap();
scene.add(nzmap);

var wellingtonCoords = [1.8, 0.1];

// var listingIcon = new THREE.

// var listings = loadListings();
// scene.add(listings);

// var highlight = loadHighlight();
// scene.add(highlight);



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

	// camera.position.x = 2 + 5*(x-w/2)/w/Math.sqrt(cz);
	// camera.position.y = 5*(h-y/2)/h/Math.sqrt(cz);

	console.log(x,y);
});	

document.addEventListener("mousewheel", function (event) {

	var delta = Math.max(-1, Math.min(1, (event.wheelDelta || -event.detail)));

	camera.position.z -= delta;
});

function getScreenCoords (x, y) {

	var width = window.innerWidth, height = window.innerHeight;
	var widthHalf = width / 2, heightHalf = height / 2;

	var vector = new THREE.Vector3(x,y,0);
	var projector = new THREE.Projector();
	projector.projectVector( vector.setFromMatrixPosition( nzmap.matrixWorld ), camera );

	var screenX = ( vector.x * widthHalf ) + widthHalf;
	var screenY = - ( vector.y * heightHalf ) + heightHalf;

	return [screenX, screenY];
}