package com.daostudio.nihongSurvivors.Components;

import com.badlogic.ashley.core.ComponentMapper;

public class AllComponentsMap {
    public static ComponentMapper<TextureComponent> textureComponentMapper = ComponentMapper.getFor(TextureComponent.class);
    public static ComponentMapper<TransformComponent> transformComponentMapper = ComponentMapper.getFor(TransformComponent.class);
    public static ComponentMapper<AnimationComponent> animationComponentMapper = ComponentMapper.getFor(AnimationComponent.class);
    public static ComponentMapper<StatsComponent> statsComponentMapper = ComponentMapper.getFor(StatsComponent.class);
}
