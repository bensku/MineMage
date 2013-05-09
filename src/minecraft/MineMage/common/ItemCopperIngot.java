package MineMage.common;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;

public class ItemCopperIngot extends Item {

	public ItemCopperIngot(int id) {
		super(id);
		
		// Constructor Configuration
        	maxStackSize = 1;
        	setCreativeTab(MainMod.tabMineMage);
	}
	
	public void func_94581_a(IconRegister iconRegister)
	{
	         iconIndex = iconRegister.registerIcon("MineMage:CopperIngot");
	}
}
