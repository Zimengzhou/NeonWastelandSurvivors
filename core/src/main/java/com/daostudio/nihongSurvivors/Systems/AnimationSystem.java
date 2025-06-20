package com.daostudio.nihongSurvivors.Systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.daostudio.nihongSurvivors.Components.AnimationComponent;
import com.daostudio.nihongSurvivors.Components.TextureComponent;

public class AnimationSystem extends IteratingSystem {
    private ComponentMapper<AnimationComponent> animationComponentMapper = ComponentMapper.getFor(AnimationComponent.class);
    private ComponentMapper<TextureComponent> textureComponentMapper = ComponentMapper.getFor(TextureComponent.class);

    public AnimationSystem() {
        super(Family.all(AnimationComponent.class, TextureComponent.class).get() );
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        AnimationComponent animationComponent = animationComponentMapper.get(entity);
        TextureComponent textureComponent = textureComponentMapper.get(entity);

        animationComponent.stateTime += deltaTime;
        textureComponent.textureRegion = animationComponent.currentAnim.getKeyFrame(animationComponent.stateTime, true);
    }
}
