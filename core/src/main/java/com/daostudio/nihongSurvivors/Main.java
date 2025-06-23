package com.daostudio.nihongSurvivors;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.daostudio.nihongSurvivors.Components.AllComponentsMap;
import com.daostudio.nihongSurvivors.Components.PlayerTagComponent;
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

    private TiledMap map1;
    private OrthogonalTiledMapRenderer mapRenderer;
    TiledMapTileLayer ground_layer;


    static Engine engine = new Engine(); // ECS框架的核心
    MovementSystem movementSystem = new MovementSystem();
    EntityFactory entityFactory = new EntityFactory(engine);
    Entity player;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.position.set(camera.viewportWidth/2f, camera.viewportHeight/2f, 0);
        Asset.load();

        //加载测试地图
        map1 = Asset.assetManager.get("map/map1.tmx");
        ground_layer = (TiledMapTileLayer) map1.getLayers().get("ground");
        mapRenderer = new OrthogonalTiledMapRenderer(map1, 5f, batch);
        ground_layer.setVisible(true);

//        player = entityFactory.createPlayer(MathUtils.random(0, 8000), MathUtils.random(0, 4000));
        player = entityFactory.createPlayer(0, 0);

        engine.addSystem(movementSystem);
        engine.addSystem(new PlayerControlSystem());
        engine.addSystem(new AnimationSystem());
        engine.addSystem(new DrawSystem(batch));
    }

    @Override
    public void render() {

        CameraControll.cameraMove(camera, AllComponentsMap.transformComponentMapper.get(player).position);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        ScreenUtils.clear(0, 0, 0, 1f);

        mapRenderer.setView(camera);
        mapRenderer.render();

        batch.begin();
        engine.update(Gdx.graphics.getDeltaTime());

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        Asset.assetManager.dispose();
    }

    private class CameraControll{
        public static void cameraMove(Camera camera, Vector2 target){
            float targetx = target.x+20;
            float targety = target.y+20;
            targetx = MathUtils.clamp(targetx, 600, 8000 - 600);
            targety = MathUtils.clamp(targety, 300, 4000 - 300);
            camera.position.set(targetx,targety,0);
        }
    }
}

