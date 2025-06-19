package com.daostudio.nihongSurvivors.Systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.daostudio.nihongSurvivors.Components.TransformComponent;

public class MovementSystem extends IteratingSystem {
    private ComponentMapper<TransformComponent> Pm = ComponentMapper.getFor(TransformComponent.class);

    public MovementSystem() {
        super(Family.all(
            TransformComponent.class
        ).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TransformComponent transform = Pm.get(entity);

        transform.position.add(transform.velocity.x*deltaTime, transform.velocity.y*deltaTime);


    }
}
