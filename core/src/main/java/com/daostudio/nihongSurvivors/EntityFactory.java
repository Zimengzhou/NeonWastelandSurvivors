package com.daostudio.nihongSurvivors;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.daostudio.nihongSurvivors.Components.*;

public class EntityFactory {
    private final Engine engine;
    private AssetManager assetManager = Asset.assetManager;
    public EntityFactory(Engine engine) {
        this.engine = engine;
    }
    public Entity createPlayer(float x, float y) {
        Entity player =  new Entity();
        PlayerTagComponent playerTAG = new PlayerTagComponent();
        player.add(playerTAG);

        //位置属性
        TransformComponent transform = new TransformComponent();
        transform.position.set(x, y);
        transform.faceTo.set(0, -y);
        transform.rotate = 0;
        transform.scale = 0.75f;
        player.add(transform);

        StatsComponent stats = new StatsComponent();
        stats.armor = 0;
        stats.HP = 20;
        stats.maxHP = 20;
        stats.dodgeChance = 0;
        stats.velocity = 389f;
        player.add(stats);

        AnimationComponent animationComponent = new AnimationComponent();
        TextureRegion[][] tempRegions = TextureRegion.split(Asset.assetManager.get("heroes/fatiaojishi_animation.png", Texture.class), 100, 100);
        TextureRegion[] regions = new TextureRegion[5];
        System.arraycopy(tempRegions[0], 0, regions, 0, 5);
        animationComponent.currentAnim = new Animation<>(0.15f, regions);
        player.add(animationComponent);

        TextureComponent texture = new TextureComponent(null);
        texture.textureRegion = animationComponent.currentAnim.getKeyFrame(0);
        player.add(texture);

        engine.addEntity(player);
        return player;
    }
    public Entity createBullet() {
        Entity bullet = new Entity();

        return bullet;
    }
}
