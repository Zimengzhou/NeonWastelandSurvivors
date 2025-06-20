package com.daostudio.nihongSurvivors.Systems;


import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.daostudio.nihongSurvivors.Components.TransformComponent;
import com.daostudio.nihongSurvivors.Components.TextureComponent;

public class DrawSystem extends IteratingSystem {
    private ComponentMapper<TextureComponent> textureComponentMapper = ComponentMapper.getFor(TextureComponent.class);
    private ComponentMapper<TransformComponent> transformComponentMapper = ComponentMapper.getFor(TransformComponent.class);
    private final SpriteBatch batch;

    public DrawSystem(SpriteBatch batch) {
        super(Family.all(TextureComponent.class, TransformComponent.class).get(), 10);
        this.batch = batch;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TextureComponent texture = textureComponentMapper.get(entity);
        TransformComponent transform = transformComponentMapper.get(entity);
        batch.draw(texture.textureRegion, transform.position.x, transform.position.y, transform.rotateOx, transform.rotateOy,
                texture.textureRegion.getRegionWidth(), texture.textureRegion.getRegionHeight(), transform.scale, transform.scale, transform.rotate);
    }
}
