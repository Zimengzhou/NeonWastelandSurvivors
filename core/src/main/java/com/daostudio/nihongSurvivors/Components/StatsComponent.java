package com.daostudio.nihongSurvivors.Components;

import com.badlogic.ashley.core.Component;

// HP、护甲、闪避相关属性组件
public class StatsComponent implements Component {
    public int HP = 100;
    public int maxHP = 100;
    public int armor = 0;
    public float dodgeChance = 0;
    public int damageReduce;
}
