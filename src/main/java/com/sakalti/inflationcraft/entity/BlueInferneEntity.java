package com.sakalti.inflationcraft.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class BlueInferneEntity extends MonsterEntity {

    public BlueInferneEntity(EntityType<? extends MonsterEntity> type, World world) {
        super(type, world);
    }

    // 属性設定
    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MonsterEntity.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 75.0)  // HP 75
                .add(Attributes.ATTACK_DAMAGE, 10.0) // ダメージ 10
                .add(Attributes.FLYING_SPEED, 0.8)  // 飛行速度
                .add(Attributes.MOVEMENT_SPEED, 0.24); // 移動速度
                .add(Attributes.FOLLOW_RANGE, 38.4D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2D, true)); // 攻撃速度少し速め
        this.goalSelector.addGoal(2, new RandomFlyingGoal(this, 1.2D)); // ランダム飛行
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, PlayerEntity.class, 8.0F)); // プレイヤー注視
    }

    @Override
    public boolean isFlying() {
        return true; // 飛行可能
    }

    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.SOUL_ESCAPE; // ソウル系の音
    }

    @Override
    public SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.GENERIC_HURT; // ダメージ音
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.GENERIC_DEATH; // 死亡音
    }
}
