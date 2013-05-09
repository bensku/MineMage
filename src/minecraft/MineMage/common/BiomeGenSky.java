package MineMage.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.world.biome.*;
import net.minecraft.entity.passive.*;

public class BiomeGenSky extends BiomeGenBase
{
    public BiomeGenSky(int par1)
    {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 11, 4, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 1, 1, 3));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 1, 1, 3));
        this.topBlock = (byte)Block.grass.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
        this.theBiomeDecorator = new BiomeEndDecorator(this);
    }
}
