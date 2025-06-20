package com.daostudio.nihongSurvivors;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Asset {
    public static final AssetManager assetManager = new AssetManager();

    public static void load() {
        TextureLoader.TextureParameter textureParameter = new TextureLoader.TextureParameter();
        textureParameter.magFilter = Texture.TextureFilter.MipMapLinearNearest;
        textureParameter.minFilter = Texture.TextureFilter.MipMapLinearNearest;
        textureParameter.genMipMaps = true;
        assetManager.load("libgdx.png", Texture.class);
        assetManager.load("heroes/fatiaojishi_animation.png", Texture.class, textureParameter);



        assetManager.finishLoading();
    }

}
