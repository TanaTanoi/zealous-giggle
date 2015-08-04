function loadNZMap()
{
	var group = new THREE.Object3D();
	var basicVertShaderPath = "shaders/basicVertexShader.vert";
	var shadelessFragShaderPath = "shaders/shadelessFragmentShader.frag";

	loadModel(group, basicVertShaderPath, shadelessFragShaderPath, [0,.5,.5], THREE.FlatShading, "models/nzmap.json");

	return group;
}

function loadListings()
{
	var group = new THREE.Object3D();
	var basicVertShaderPath = "shaders/basicVertexShader.vert";
	var shadelessFragShaderPath = "shaders/shadelessFragmentShader.frag";

	loadModel(group, basicVertShaderPath, shadelessFragShaderPath, [1,.2,.2], THREE.FlatShading, "models/listings.json");

	return group;
}

function loadHighlight()
{
	var group = new THREE.Object3D();
	var basicVertShaderPath = "shaders/basicVertexShader.vert";
	var shadelessFragShaderPath = "shaders/shadelessFragmentShader.frag";

	backMaterial = new THREE.MeshBasicMaterial({ color: 0x550022, transparent: true, opacity: 0.7});
	loadModelMat(group, backMaterial, "models/highlightBack.json");
	loadModel(group, basicVertShaderPath, shadelessFragShaderPath, [0,1,1], THREE.FlatShading, "models/highlightText.json");

	return group;
}

function loadXML(filepath, output, done)
{
	var xmlhttp;
	xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function () 
	{
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) 
		{
			output.value = xmlhttp.responseText;
			done();
		}
	}

	xmlhttp.open("GET", filepath, true);
	xmlhttp.send();
}

function loadModel(group, vertShaderPath, fragShaderPath, color, shading, modelPath) 
{
	var vertexShader = {value: ""};
	var fragmentShader = {value: ""};

	loadXML(vertShaderPath, vertexShader, function () {

		loadXML(fragShaderPath, fragmentShader, function () {

			var shaderMaterial = new THREE.ShaderMaterial({
				
				uniforms: THREE.UniformsUtils.merge([
					THREE.UniformsLib['lights'], 
					{
						color: {type: "v3", value: new THREE.Vector3(color[0],color[1],color[2])}
					}
				]),

				vertexShader: vertexShader.value,
				fragmentShader: fragmentShader.value,
				lights: true,
				shading: shading
			});

			var loader = new THREE.JSONLoader();
			loader.load(modelPath, function (geometry) {

				// var basicMaterial = new THREE.MeshBasicMaterial();

				mesh = new THREE.Mesh(geometry, shaderMaterial);

				group.add(mesh);
			});
		})
	});
}

function loadModelMat(group, mat, modelPath) 
{
	var loader = new THREE.JSONLoader();
	loader.load(modelPath, function (geometry) {

		// var basicMaterial = new THREE.MeshBasicMaterial();

		mesh = new THREE.Mesh(geometry, mat);

		group.add(mesh);
	});
}