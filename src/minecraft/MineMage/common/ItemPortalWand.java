package MineMage.common;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.FoodStats;
import net.minecraft.world.World;

public class ItemPortalWand extends Item {

	public ItemPortalWand(int id) {
		super(id);
		setUnlocalizedName("portalWand");
		setCreativeTab(MainMod.tabMineMage);
	}

	public void updateIcons(IconRegister iconRegister) {
		this.iconIndex = iconRegister.registerIcon("darkdim:darkIgniter");
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (par3World.getBlockId(par4, par5, par6) == Block.stone.blockID && BlockSkyPortal.tryToCreatePortal(par3World, par4, par5+1, par6)) {
			par2EntityPlayer.inventory.consumeInventoryItem(MainMod.ItemPortalWand.itemID);
			par2EntityPlayer.addPotionEffect((new PotionEffect(Potion.confusion.getId(), 200, 1)));
			par2EntityPlayer.addPotionEffect((new PotionEffect(Potion.hunger.getId(), 200, 2)));
			par2EntityPlayer.addPotionEffect((new PotionEffect(Potion.moveSlowdown.getId(), 500, 100)));
			par2EntityPlayer.addPotionEffect((new PotionEffect(Potion.weakness.getId(), 100, 1)));
			par2EntityPlayer.addChatMessage("Creating portal needs all your povers... You need to sleep and eat something!");
			
			return true;
		} else {
			return false;
		}
    }
}
