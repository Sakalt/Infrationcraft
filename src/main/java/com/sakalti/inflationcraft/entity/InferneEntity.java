package com.sakalti.inflationcraft.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;

public class InferneEntity extends MonsterEntity {

    public InferneEntity(EntityType<? extends MonsterEntity> type, World world) {
        super(type, world);
    }

    // アトリビュート設定
    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MonsterEntity.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 50.0)  // HP 50
                .add(Attributes.ATTACK_DAMAGE, 8.0) // ダメージ 8
                .add(Attributes.FLYING_SPEED, 0.7)  // 飛行速度
                .add(Attributes.MOVEMENT_SPEED, 0.25); // 地上移動速度
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true)); // 近接攻撃
        this.goalSelector.addGoal(2, new RandomFlyingGoal(this, 1.0D)); // ランダム飛行
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, PlayerEntity.class, 8.0F)); // プレイヤーを注視
    }

    @Override
    public boolean isFlying() {
        return true; // 飛行可能
    }

    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.BLAZE_AMBIENT; // 通常音
    }

    @Override
    public SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLAZE_HURT; // ダメージを受けた時の音
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.BLAZE_DEATH; // 死亡時の音
    }
}
