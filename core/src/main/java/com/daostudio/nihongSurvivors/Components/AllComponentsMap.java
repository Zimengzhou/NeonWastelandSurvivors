package com.daostudio.nihongSurvivors.Components;

import com.badlogic.ashley.core.ComponentMapper;
import com.daostudio.nihongSurvivors.Skills.AttackComponent;
import com.daostudio.nihongSurvivors.Skills.AttackTagComponent;

public class AllComponentsMap {
    public static ComponentMapper<TextureComponent> textureComponentMapper = ComponentMapper.getFor(TextureComponent.class);
    public static ComponentMapper<TransformComponent> transformComponentMapper = ComponentMapper.getFor(TransformComponent.class);
    public static ComponentMapper<AnimationComponent> animationComponentMapper = ComponentMapper.getFor(AnimationComponent.class);
    public static ComponentMapper<StatsComponent> statsComponentMapper = ComponentMapper.getFor(StatsComponent.class);

    public static ComponentMapper<AttackComponent> attackComponentMapper = ComponentMapper.getFor(AttackComponent.class);
    public static ComponentMapper<AttackTagComponent> attackTagComponentMapper = ComponentMapper.getFor(AttackTagComponent.class);
}
