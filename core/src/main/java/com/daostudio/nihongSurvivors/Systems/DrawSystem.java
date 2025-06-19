package com.daostudio.nihongSurvivors.Systems;


import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.daostudio.nihongSurvivors.Components.TransformComponent;
import com.daostudio.nihongSurvivors.Components.TextureComponent;

public class DrawSystem extends IteratingSystem {
    private ComponentMapper<TextureComponent> textureComponentComponentMapper = ComponentMapper.getFor(TextureComponent.class);
    private ComponentMapper<TransformComponent> positionComponentComponentMapper = ComponentMapper.getFor(TransformComponent.class);
    private SpriteBatch batch;

    public DrawSystem(SpriteBatch batch) {
        super(Family.all(TextureComponent.class, TransformComponent.class).get());
        this.batch = batch;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TextureComponent texture = textureComponentComponentMapper.get(entity);
        TransformComponent pos = positionComponentComponentMapper.get(entity);
        batch.draw(texture.texture, pos.position.x, pos.position.y);
    }
}
