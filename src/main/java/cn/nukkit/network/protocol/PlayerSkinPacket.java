package cn.nukkit.network.protocol;

import cn.nukkit.entity.data.Skin;
import lombok.ToString;

import java.util.UUID;

@ToString
public class PlayerSkinPacket extends DataPacket {

    public UUID uuid;
    public Skin skin;
    public String newSkinName;
    public String oldSkinName;

    @Override
    public byte pid() {
        return ProtocolInfo.PLAYER_SKIN_PACKET;
    }

    @Override
    public void decode() {
        uuid = getUUID();
        String skinId = this.getString();
        newSkinName = getString();
        oldSkinName = getString();
        skin = getSkin(skinId);
//        newSkinName = getString();
//        oldSkinName = getString();
    }

    @Override
    public void encode() {
        reset();
        putUUID(uuid);
        this.putString("Standard_Alex"); // TODO: fixme "Standard_Steve" "Standard_Alex"
        putString(newSkinName);
        putString(oldSkinName);
        this.putImage(this.skin.getSkinData());
        this.putImage(this.skin.getCapeData());
        this.putString(this.skin.getGeometryModel());
        this.putString(this.skin.getGeometryData());
    }
}
