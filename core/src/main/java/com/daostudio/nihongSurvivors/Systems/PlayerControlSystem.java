package com.daostudio.nihongSurvivors.Systems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.systems.IntervalSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.daostudio.nihongSurvivors.Components.AllComponentsMap;
import com.daostudio.nihongSurvivors.Components.PlayerTagComponent;
import com.daostudio.nihongSurvivors.Components.StatsComponent;
import com.daostudio.nihongSurvivors.Components.TransformComponent;

public class PlayerControlSystem extends EntitySystem implements InputProcessor {
    private ImmutableArray<Entity> entities;
    boolean up, down, right, left;

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(PlayerTagComponent.class).get());
    }

    @Override
    public void update(float deltaTime) {
        for (Entity entity:entities) {
            TransformComponent transform = AllComponentsMap.transformComponentMapper.get(entity);
            StatsComponent stats = AllComponentsMap.statsComponentMapper.get(entity);

            transform.velocity.set(0, 0);
            if (up) { transform.velocity.y = 1; }
            if (down) { transform.velocity.y = -1; }
            if (left) { transform.velocity.x = -1; }
            if (right) { transform.velocity.x = 1; }

            transform.velocity.nor();
            transform.faceTo.set(transform.velocity);
            transform.velocity.scl(stats.velocity);
        }
    }

    public PlayerControlSystem() {
        super();
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.W)
            up = true;
        if (keycode == Input.Keys.S)
            down = true;
        if (keycode == Input.Keys.A)
            left = true;
        if (keycode == Input.Keys.D)
            right = true;
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.W)
            up = false;
        if (keycode == Input.Keys.S)
            down = false;
        if (keycode == Input.Keys.A)
            left = false;
        if (keycode == Input.Keys.D)
            right = false;
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
