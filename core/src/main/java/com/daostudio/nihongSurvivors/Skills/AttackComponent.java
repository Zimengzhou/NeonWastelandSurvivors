package com.daostudio.nihongSurvivors.Skills;

import com.badlogic.ashley.core.Component;

public class AttackComponent implements Component {
    public SkillProfile skillProfile = new SkillProfile();
    public AttackType attackType; //攻击类型
    public enum AttackType {
        MELEE, //近战
        RANGED, //远程
    }
}

