package com.splash.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class CustomItem extends Item{
	
	public static final String name = "CustomItem"; //This is what the code sees the item's name as. Not what appears ingame
	//contructor
	public CustomItem(){
		super(); //super runs the parent's constructor
		this.setUnlocalizedName("Custom Item"); //Gives the item a name ingame
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
	//This makes an explosion on right click
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos position, EnumFacing side, float hitX, float hitY, float hitZ){
		world.createExplosion(player, position.getX() + hitX, position.getY() + hitY, position.getZ() + hitZ, 20f, true); //creates the boom
		return super.onItemUse(stack, player, world, position, side, hitX, hitY, hitZ); //runs the parents onItemUse method and returns
		//whatever that it does
	}
}
