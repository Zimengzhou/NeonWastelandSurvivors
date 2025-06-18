package com.daostudio.nihongSurvivors.Components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;

public class TextureComponent implements Component {
    public Texture texture;
    public TextureComponent(String internalPath) {
        texture = new Texture(internalPath);
    }
}
