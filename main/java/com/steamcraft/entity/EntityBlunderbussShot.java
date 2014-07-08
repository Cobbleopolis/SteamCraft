package com.steamcraft.entity;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityBlunderbussShot extends EntityThrowable {
	int ticksAlive = 0;
	int maxTicks = 4;
	Random rand = new Random(2);

	public EntityBlunderbussShot(World world) {
		super(world);
	}

	public EntityBlunderbussShot(World world, EntityLivingBase livingBase) {
		super(world, livingBase);
	}

	public EntityBlunderbussShot(World world, double posX, double posY,
			double posZ) {
		super(world, posX, posY, posZ);
	}

	@Override
	public void onEntityUpdate() {
		ticksAlive++;
		if (ticksAlive >= maxTicks) {
			setDead();
		}
		super.onEntityUpdate();
		this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ,
				this.motionX / 10, this.motionY / 10, this.motionZ / 10);
	}

	protected void onImpact(MovingObjectPosition paramMovingObjectPosition) {
		if (paramMovingObjectPosition.entityHit != null) {
			int i = 0;
			if (paramMovingObjectPosition.entityHit instanceof EntityBlaze) {
				i = 3;
			}
			paramMovingObjectPosition.entityHit.attackEntityFrom(
					DamageSource.causeThrownDamage(this, getThrower()), 10);
		}
		for (int j = 0; j < 64; ++j)
			this.worldObj.spawnParticle("smoke", this.posX, this.posY,
					this.posZ, 0.0D, 0.0D, 0.0D);
		if (!(this.worldObj.isRemote))
			setDead();
	}

	public void registerEntity(EntityRegistry iconRegister) {
		EntityRegistry.registerGlobalEntityID(EntityBlunderbussShot.class,
				"BlunderbussShot", EntityRegistry.findGlobalUniqueEntityId());
	}
}
