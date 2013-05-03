package MineMage.common;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;

public class BlockCopperOre extends MainBlock {
	public BlockCopperOre(int id, int texture, Material material) {
		super(id, texture, material);
		
		setHardness(1.5F);
		setStepSound(Block.soundStoneFootstep);
		setCreativeTab(MainMod.tabMineMage);
	}
	
	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("MineMage:BlockCopperOre");
	}
	
	//public int idDropped(int par1, Random random, int par2) {
	//	return ItemCopperIngot.shiftedIndex;
	//}
}