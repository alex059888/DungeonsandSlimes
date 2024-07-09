#version 400

in vec4 fColor;
in vec2 fTexCoords;

out vec4 color;

uniform sampler2D tex;

void main() {
    vec4 tex = texture(tex, fTexCoords);
    vec4 texColor = tex * fColor;
    if (texColor.w == 0)
        discard;
    color = texColor;
}
