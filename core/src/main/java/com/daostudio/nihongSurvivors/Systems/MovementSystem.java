package com.daostudio.nihongSurvivors.Systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.daostudio.nihongSurvivors.Components.PositionComponent;
import com.daostudio.nihongSurvivors.Components.VelocityComponent;

public class MovementSystem extends IteratingSystem {
    private ComponentMapper<PositionComponent> Pm = ComponentMapper.getFor(PositionComponent.class);
    private ComponentMapper<VelocityComponent> Vm = ComponentMapper.getFor(VelocityComponent.class);

    public MovementSystem() {
        super(Family.all(
            PositionComponent.class,
            VelocityComponent.class
        ).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent pos = Pm.get(entity);
        VelocityComponent vel = Vm.get(entity);

        pos.position.add(vel.velocity.x*deltaTime, vel.velocity.y*deltaTime);


    }
}
