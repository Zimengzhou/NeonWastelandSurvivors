package com.daostudio.nihongSurvivors;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;

    Engine engine = new Engine(); // ECS框架的核心
    Entity entity_image = new Entity(); //测试entity

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
    }

    @Override
    public void render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        batch.begin();
        batch.draw(image, Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
