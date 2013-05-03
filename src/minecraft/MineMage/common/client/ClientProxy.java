package MineMage.common.client;

import net.minecraftforge.client.MinecraftForgeClient;
import MineMage.common.CommonProxy;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() {
		MinecraftForgeClient.preloadTexture(TextureBlockCopperOre);
		MinecraftForgeClient.preloadTexture(TextureItemCopperIngot);
	}
	
}