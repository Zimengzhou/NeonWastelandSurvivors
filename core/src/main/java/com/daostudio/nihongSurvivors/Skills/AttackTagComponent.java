package com.daostudio.nihongSurvivors.Skills;

import com.badlogic.ashley.core.Component;

public class AttackTagComponent implements Component {
    public float damage; //伤害值
    public int hitCount; //穿透数量
    public int hitCountMax; //最大穿透数量
    public AttackComponent.AttackType attackType; //攻击类型
}
