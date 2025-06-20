package com.daostudio.nihongSurvivors.Systems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.daostudio.nihongSurvivors.Components.PlayerTagComponent;
import com.daostudio.nihongSurvivors.Components.StatsComponent;
import com.daostudio.nihongSurvivors.Components.TransformComponent;

public class PlayerControlSystem extends EntitySystem {
    private ImmutableArray<Entity> entities;
    private final ComponentMapper<TransformComponent> transformComponentMapper = ComponentMapper.getFor(TransformComponent.class);
    private final ComponentMapper<StatsComponent> statsComponentMapper = ComponentMapper.getFor(StatsComponent.class);

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(PlayerTagComponent.class).get());
    }

    @Override
    public void update(float deltaTime) {
        for (Entity entity:entities) {
            TransformComponent transform = transformComponentMapper.get(entity);
            StatsComponent stats = statsComponentMapper.get(entity);
            transform.velocity.set(0, 0);

            if (Gdx.input.isKeyPressed(Input.Keys.W)) { transform.velocity.y = 1; }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) { transform.velocity.y = -1; }
            if (Gdx.input.isKeyPressed(Input.Keys.A)) { transform.velocity.x = -1; }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) { transform.velocity.x = 1; }

            transform.velocity.nor().scl(stats.velocity);
        }
    }

    public PlayerControlSystem() {
        super();
    }
}
