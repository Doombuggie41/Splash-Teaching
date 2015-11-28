package com.splash.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class CustomSword extends ItemSword{
	public static final String name = "CustomSword";
	
	public CustomSword(ToolMaterial material){
		super(material); //The material for the sword, it is set in the ItemManager
		this.setUnlocalizedName("Custom Sword");
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos position, EnumFacing side, float hitX, float hitY, float hitZ){
		world.createExplosion(player, position.getX() + hitX, position.getY() + hitY, position.getZ() + hitZ, 20f, true);
		return super.onItemUse(stack, player, world, position, side, hitX, hitY, hitZ);
	}
	
}
