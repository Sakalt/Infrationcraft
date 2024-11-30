package com.sakalti.inflationcraft.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class HydrineEntity extends Mob {
    public HydrineEntity(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 108.0D)
                .add(Attributes.ARMOR, 8.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.36D);
                .add(Attributes.FOLLOW_RANGE, 25.6D);
                .add(Attributes.ATTACK_DAMAGE, 17.0D);
    }

    // AIゴールの設定
    @Override
    protected void addBehaviorGoals() {
        // プレイヤーを追いかけて攻撃
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2D, true));

        // ランダムに歩き回る
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));

        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, PlayerEntity.class, 8.0F)); // プレイヤーを注視
    }

    // プレイヤーに対する攻撃
    @Override
    public boolean doHurtTarget(Entity target) {
        if (target instanceof Player) {
            // プレイヤーを攻撃する
            // 例えば、攻撃時に追加のエフェクトやダメージを加えることができます
            target.setSecondsOnFire(16); // 火にする（オプション）
        }
        return super.doHurtTarget(target);
    }

    // 死亡時の処理（錫ドロップ）
    @Override
    public void onDeath() {
        super.onDeath();
        if (Math.random() < 0.111) { // 11.1%の確率
            this.spawnAtLocation(Items.IRON_INGOT); // 鉄のアイテムとして追加
        }
    }
}
