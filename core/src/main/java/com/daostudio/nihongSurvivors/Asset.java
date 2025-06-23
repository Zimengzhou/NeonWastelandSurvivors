package com.daostudio.nihongSurvivors;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Asset {
    public static final AssetManager assetManager = new AssetManager();

    public static void load() {
        TextureLoader.TextureParameter textureParameter = new TextureLoader.TextureParameter();
        textureParameter.magFilter = Texture.TextureFilter.MipMapLinearNearest;
        textureParameter.minFilter = Texture.TextureFilter.MipMapLinearNearest;
        textureParameter.genMipMaps = true;
        assetManager.load("libgdx.png", Texture.class);
        assetManager.load("heroes/fatiaojishi_animation.png", Texture.class, textureParameter);

        assetManager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
        assetManager.load("map/map1.tmx", TiledMap.class);

        assetManager.finishLoading();
    }

}
