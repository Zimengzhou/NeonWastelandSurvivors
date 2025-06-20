package com.daostudio.nihongSurvivors;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.daostudio.nihongSurvivors.Components.PlayerTagComponent;
import com.daostudio.nihongSurvivors.Components.StatsComponent;
import com.daostudio.nihongSurvivors.Components.TextureComponent;
import com.daostudio.nihongSurvivors.Components.TransformComponent;

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
        player.add(transform);

        StatsComponent stats = new StatsComponent();
        stats.armor = 0;
        stats.HP = 20;
        stats.maxHP = 20;
        stats.dodgeChance = 0;
        stats.velocity = 200f;
        player.add(stats);

        TextureComponent texture = new TextureComponent("fatiaojishi_.png");
        player.add(texture);

        engine.addEntity(player);
        return player;
    }
    public Entity createBullet() {
        Entity bullet = new Entity();

        return bullet;
    }
}
