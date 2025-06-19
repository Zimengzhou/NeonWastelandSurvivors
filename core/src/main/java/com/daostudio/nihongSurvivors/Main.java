package com.daostudio.nihongSurvivors;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.daostudio.nihongSurvivors.Components.TransformComponent;
import com.daostudio.nihongSurvivors.Components.TextureComponent;
import com.daostudio.nihongSurvivors.Systems.DrawSystem;
import com.daostudio.nihongSurvivors.Systems.MovementSystem;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;

    Engine engine = new Engine(); // ECS框架的核心
    MovementSystem movementSystem = new MovementSystem();
    Entity entity_image = new Entity();

    @Override
    public void create() {
        batch = new SpriteBatch();
        Asset.load();

        entity_image.add(new TransformComponent());
        entity_image.add(new TextureComponent("libgdx.png"));

        engine.addEntity(entity_image);
        engine.addSystem(movementSystem);
        engine.addSystem(new DrawSystem(batch));
    }

    @Override
    public void render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        batch.begin();
        engine.update(Gdx.graphics.getDeltaTime());

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        Asset.assetManager.dispose();
    }
}
