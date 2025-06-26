package com.daostudio.nihongSurvivors;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.daostudio.nihongSurvivors.Components.*;
import com.daostudio.nihongSurvivors.Skills.AttackComponent;
import com.daostudio.nihongSurvivors.Skills.AttackTagComponent;

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
        transform.scale = 0.65f;
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

        AttackComponent attackComponent = engine.createComponent(AttackComponent.class);
        attackComponent.skillProfile.damage = 10;
        attackComponent.skillProfile.range = 500;
        attackComponent.skillProfile.cooldown = 0.1f;
        attackComponent.skillProfile.bulletVelocity = 500;
        attackComponent.attackType = AttackComponent.AttackType.RANGED;
        player.add(attackComponent);

        engine.addEntity(player);
        return player;
    }

    public Entity createBullet(Vector2 startPos, Vector2 targetPos, float velocity, float damage) {
        Entity bullet = new Entity();

        AttackTagComponent attackTagComponent = engine.createComponent(AttackTagComponent.class);
        attackTagComponent.attackType = AttackComponent.AttackType.RANGED;
        attackTagComponent.damage = damage;
        attackTagComponent.hitCount = 0;
        attackTagComponent.hitCountMax = 1;
        bullet.add(attackTagComponent);

        TransformComponent transform = engine.createComponent(TransformComponent.class);
        transform.position.set(startPos);
//        Gdx.app.log("BulletFactory", "start_x"+transform.position.x+", start_y"+transform.position.y);
        transform.velocity.set(targetPos.x - startPos.x, targetPos.y - startPos.y).nor().scl(velocity);
        transform.scale = 0.5f;
        bullet.add(transform);

//        TextureComponent texture = engine.createComponent(TextureComponent.class);
        TextureComponent texture = new TextureComponent(null);
        texture.textureRegion = new TextureRegion(assetManager.get("attack/sf_attack.png", Texture.class));
        bullet.add(texture);

        engine.addEntity(bullet);

        return bullet;
    }
}
