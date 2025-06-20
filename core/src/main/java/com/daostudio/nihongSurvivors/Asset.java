package com.daostudio.nihongSurvivors;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Asset {
    public static final AssetManager assetManager = new AssetManager();

    public static void load() {
        assetManager.load("libgdx.png", Texture.class);
        assetManager.load("fatiaojishi_.png", Texture.class);

        assetManager.finishLoading();
    }

}
