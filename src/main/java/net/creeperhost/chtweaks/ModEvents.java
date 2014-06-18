package net.creeperhost.chtweaks;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import java.util.Random;

public class ModEvents {
	private static final int SPAWN_RATIO = 8;

	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) {
		if (isServer(event.entity.worldObj) && event.entity != null && isHostile(event.entity)) {
			Random randomGenerator = new Random();
			if(randomGenerator.nextInt(100) > 80) {
				int amount = ((int) event.entityLiving.getMaxHealth() / SPAWN_RATIO);
				if(amount > 0) spawnStackAtEntity(event, new ItemStack(Items.gold_nugget, randInt(1, amount)));
			}
		}
	}

	private boolean isServer(World world) {
		return !world.isRemote;
	}

	private boolean isHostile(Entity entity) {
		return entity instanceof EntityMob;
	}

	private void spawnStackAtEntity(LivingDeathEvent event, ItemStack stack) {
		World world = event.entity.worldObj;
		EntityItem item = new EntityItem(world, event.entity.posX, event.entity.posY, event.entity.posZ, stack);
		world.spawnEntityInWorld(item);
	}
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
}
