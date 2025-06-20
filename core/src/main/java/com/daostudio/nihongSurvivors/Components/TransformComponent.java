package com.daostudio.nihongSurvivors.Components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class TransformComponent implements Component {
    public Vector2 position = new Vector2();
    public Vector2 faceTo = new Vector2(); //朝向

    public float scale = 1;
    public float rotateOx, rotateOy;
    public float rotate = 0; //旋转角度

    public Vector2 velocity = new Vector2(); //速度
}
