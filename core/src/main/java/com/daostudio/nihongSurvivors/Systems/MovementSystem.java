package com.daostudio.nihongSurvivors.Systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.daostudio.nihongSurvivors.Components.AllComponentsMap;
import com.daostudio.nihongSurvivors.Components.TransformComponent;

public class MovementSystem extends IteratingSystem {

    public MovementSystem() {
        super(Family.all(
            TransformComponent.class
        ).get(), 1);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TransformComponent transform = AllComponentsMap.transformComponentMapper.get(entity);
        transform.position.add(transform.velocity.x*deltaTime, transform.velocity.y*deltaTime);

    }
}
