package MineMage.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.client.registry.ClientRegistry;

public class CommonProxy {
	public static String TextureBlockCopperOre = "/minemage_images/blocks/CopperOre.png";
	public static String TextureItemCopperIngot = "/minemage_images/items/CopperIngot.png";
	
	// Client stuff
	public void registerRenderers() {
		// Nothing here as this is the server side proxy
	}
}
