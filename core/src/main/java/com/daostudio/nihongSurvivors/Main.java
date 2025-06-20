package com.daostudio.nihongSurvivors;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.daostudio.nihongSurvivors.Components.TransformComponent;
import com.daostudio.nihongSurvivors.Components.TextureComponent;
import com.daostudio.nihongSurvivors.Systems.AnimationSystem;
import com.daostudio.nihongSurvivors.Systems.DrawSystem;
import com.daostudio.nihongSurvivors.Systems.MovementSystem;
import com.daostudio.nihongSurvivors.Systems.PlayerControlSystem;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private OrthographicCamera camera;
    Stage mainStage;
    Screen mainScreen;
    Actor actor;

    Engine engine = new Engine(); // ECS框架的核心
    MovementSystem movementSystem = new MovementSystem();
    EntityFactory entityFactory = new EntityFactory(engine);

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.position.set(camera.viewportWidth/2f, camera.viewportHeight/2f, 0);
        Asset.load();

        Entity player = entityFactory.createPlayer(0.27f, 0);


        engine.addSystem(movementSystem);
        engine.addSystem(new PlayerControlSystem());
        engine.addSystem(new AnimationSystem());
        engine.addSystem(new DrawSystem(batch));
    }

    @Override
    public void render() {
        camera.update();
        batch.setProjectionMatrix(camera.combined);
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
