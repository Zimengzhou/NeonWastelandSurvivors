package com.daostudio.nihongSurvivors.Components.SkillComponent;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Array;

import java.util.Arrays;

public class SkillComponent implements Component {
    public Array<SkillProfile> skills = new Array<>(); //技能列表
}
