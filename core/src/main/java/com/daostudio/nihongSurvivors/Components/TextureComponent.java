package com.daostudio.nihongSurvivors.Components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.daostudio.nihongSurvivors.Asset;

public class TextureComponent implements Component {
    public TextureRegion textureRegion;

    public TextureComponent(String internalPath) {
        if(internalPath != null)
            textureRegion = new TextureRegion(Asset.assetManager.get(internalPath, Texture.class));
    }
}
