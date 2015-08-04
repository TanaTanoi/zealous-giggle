precision mediump float;

uniform vec3 color;

varying vec3 vNormal;

void main()
{
	vec3 light = vec3(1.0,1.0,0.0);
	light = normalize(light);

	float d = dot(vNormal, light);

	gl_FragColor = clamp(vec4((ceil(d)+0.3) * color, 1.0), 0.0, 1.0);
}