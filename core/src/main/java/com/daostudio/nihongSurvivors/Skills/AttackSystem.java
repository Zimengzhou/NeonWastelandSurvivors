package com.daostudio.nihongSurvivors.Skills;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.Vector2;
import com.daostudio.nihongSurvivors.Components.AllComponentsMap;
import com.daostudio.nihongSurvivors.Components.EnemyTagComponent;
import com.daostudio.nihongSurvivors.Components.PlayerTagComponent;
import com.daostudio.nihongSurvivors.Components.TransformComponent;
import com.daostudio.nihongSurvivors.EntityFactory;

public class AttackSystem extends EntitySystem {
    private EntityFactory entityFactory;


    private ImmutableArray<Entity> enemies;
    private ImmutableArray<Entity> players;
    Family playerFamily = Family.all(PlayerTagComponent.class).get();
    Family enemyFamily = Family.all(EnemyTagComponent.class).get();
    Family attackerFamily = Family.all(AttackComponent.class).get();

    public AttackSystem() {
        super();
    }

    @Override
    public void addedToEngine(Engine engine) {
        entityFactory = new EntityFactory(engine);
        enemies = engine.getEntitiesFor(enemyFamily); //敌人实体
        players = engine.getEntitiesFor(playerFamily); //玩家实体
    }

    @Override
    public void update(float deltaTime) {
        for (Entity attacker: players)
        {
            AttackComponent attackComponent = AllComponentsMap.attackComponentMapper.get(attacker);
            // 攻击间隔时间计时
            if (attackComponent.skillProfile.restCooldown > 0)
                attackComponent.skillProfile.restCooldown -= deltaTime;
            else attackComponent.skillProfile.restCooldown = 0;

            TransformComponent attackerTransform = AllComponentsMap.transformComponentMapper.get(attacker);
            for (Entity target: enemies)
            {
                TransformComponent targetTransform = AllComponentsMap.transformComponentMapper.get(target);
                float distance = attackerTransform.position.dst(targetTransform.position);
                if (distance < attackComponent.skillProfile.range) {
                    startAttack(attackComponent, attackerTransform.position, targetTransform.position);
                }
            }
        }
    }

    public void startAttack(AttackComponent attackComponent, Vector2 startPos, Vector2 targetPos) {
        if (attackComponent.skillProfile.restCooldown > 0) return; // 技能还在冷却中

        //远程攻击
        if (attackComponent.attackType == AttackComponent.AttackType.RANGED) {
            Entity bullet = entityFactory.createBullet(
                startPos, targetPos,
                attackComponent.skillProfile.bulletVelocity,
                attackComponent.skillProfile.damage
            );
        }
        //近战攻击
        else if (attackComponent.attackType == AttackComponent.AttackType.MELEE) {

        }
        attackComponent.skillProfile.restCooldown = attackComponent.skillProfile.cooldown; // 重置冷却时间
    }
}
