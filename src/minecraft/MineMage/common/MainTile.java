package MineMage.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class MainTile extends TileEntity {

    private ForgeDirection orientation;
    private byte state;
    private String customName;

    public MainTile() {

        orientation = ForgeDirection.SOUTH;
        state = 0;
        customName = "";
    }

    public ForgeDirection getOrientation() {

        return orientation;
    }

    public void setOrientation(ForgeDirection orientation) {

        this.orientation = orientation;
    }

    public void setOrientation(int orientation) {

        this.orientation = ForgeDirection.getOrientation(orientation);
    }

    public short getState() {

        return state;
    }

    public void setState(byte state) {

        this.state = state;
    }

    public boolean hasCustomName() {

        return customName != null && customName.length() > 0;
    }

    public String getCustomName() {

        return customName;
    }

    public void setCustomName(String customName) {

        this.customName = customName;
    }

    public boolean isUseableByPlayer(EntityPlayer player) {

        return true;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {

        super.readFromNBT(nbtTagCompound);

        if (nbtTagCompound.hasKey("teDirection")) {
            orientation = ForgeDirection.getOrientation(nbtTagCompound.getByte("teDirection"));
        }

        if (nbtTagCompound.hasKey("teState")) {
            state = nbtTagCompound.getByte("teState");
        }

        if (nbtTagCompound.hasKey("CustomName")) {
            customName = nbtTagCompound.getString("CustomName");
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {

        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setByte("teDirection", (byte) orientation.ordinal());
        nbtTagCompound.setByte("teState", state);

        if (this.hasCustomName()) {
            nbtTagCompound.setString("CustomName", customName);
        }
    }

    //@Override
    //public Packet getDescriptionPacket() {

    //    return PacketTypeHandler.populatePacket(new PacketTileUpdate(xCoord, yCoord, zCoord, orientation, state, customName));
    //}

}