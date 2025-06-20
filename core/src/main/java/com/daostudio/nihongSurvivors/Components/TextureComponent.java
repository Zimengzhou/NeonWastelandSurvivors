package com.daostudio.nihongSurvivors.Components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.daostudio.nihongSurvivors.Asset;

public class TextureComponent implements Component {
    public Texture texture;
    public TextureComponent(String internalPath) {
        texture = Asset.assetManager.get(internalPath, Texture.class);
    }
}
