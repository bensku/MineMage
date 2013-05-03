package MineMage.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabMineMage extends CreativeTabs {

	public CreativeTabMineMage(int position, String tabID) {
		super(position, tabID);
	}

	@SideOnly(Side.CLIENT) public int getTabIconItemIndex() {
		return Item.eyeOfEnder.itemID;
	}

	public String getTranslatedTabLabel() {
		return "MineMage";
	}

}