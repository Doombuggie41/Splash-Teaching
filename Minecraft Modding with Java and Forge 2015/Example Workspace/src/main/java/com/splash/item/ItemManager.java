package com.splash.item;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemManager {
	public static CustomItem customItem;
	public static CustomSword customSword;
	public static void mainRegistry() {
	    initializeItem(); //Allocates Memory
	    registerItem(); //Adds it to the game
	}

	public static void initializeItem() {
	    customItem = new CustomItem(); 
	    //Sets the tool material as iron
	    customSword = new CustomSword(ToolMaterial.IRON);
	}

	public static void registerItem() {
	    //Adds the items to the game
		
		GameRegistry.registerItem(customItem, customItem.name );

		GameRegistry.registerItem(customSword, customSword.name );
	}
}
