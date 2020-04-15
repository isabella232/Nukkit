package cn.nukkit.network.protocol;

import cn.nukkit.entity.Attribute;
import cn.nukkit.entity.data.EntityMetadata;
import cn.nukkit.entity.item.*;
import cn.nukkit.entity.mob.*;
import cn.nukkit.entity.passive.*;
import cn.nukkit.entity.projectile.*;
import cn.nukkit.entity.weather.EntityLightning;
import cn.nukkit.network.protocol.types.EntityLink;
import cn.nukkit.utils.Binary;
import com.google.common.collect.ImmutableMap;
import lombok.ToString;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
@ToString
public class AddEntityPacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.ADD_ENTITY_PACKET;

    public static ImmutableMap<String, Integer> LEGACY_IDS = ImmutableMap.<String, Integer>builder()
            .put("minecraft:npc", 51)
            .put("minecraft:player", 63)
            .put("minecraft:wither_skeleton", EntityWitherSkeleton.NETWORK_ID)
            .put("minecraft:husk", EntityHusk.NETWORK_ID)
            .put("minecraft:stray", EntityStray.NETWORK_ID)
            .put("minecraft:witch", EntityWitch.NETWORK_ID)
            .put("minecraft:zombie_villager", EntityZombieVillagerV1.NETWORK_ID)
            .put("minecraft:blaze", EntityBlaze.NETWORK_ID)
            .put("minecraft:magma_cube", EntityMagmaCube.NETWORK_ID)
            .put("minecraft:ghast", EntityGhast.NETWORK_ID)
            .put("minecraft:cave_spider", EntityCaveSpider.NETWORK_ID)
            .put("minecraft:silverfish", EntitySilverfish.NETWORK_ID)
            .put("minecraft:enderman", EntityEnderman.NETWORK_ID)
            .put("minecraft:slime", EntitySlime.NETWORK_ID)
            .put("minecraft:zombie_pigman", EntityZombiePigman.NETWORK_ID)
            .put("minecraft:spider", EntitySpider.NETWORK_ID)
            .put("minecraft:skeleton", EntitySkeleton.NETWORK_ID)
            .put("minecraft:creeper", EntityCreeper.NETWORK_ID)
            .put("minecraft:zombie", EntityZombie.NETWORK_ID)
            .put("minecraft:skeleton_horse", EntitySkeletonHorse.NETWORK_ID)
            .put("minecraft:mule", EntityMule.NETWORK_ID)
            .put("minecraft:donkey", EntityDonkey.NETWORK_ID)
            .put("minecraft:dolphin", EntityDolphin.NETWORK_ID)
            .put("minecraft:tropicalfish", EntityTropicalFish.NETWORK_ID)
            .put("minecraft:wolf", EntityWolf.NETWORK_ID)
            .put("minecraft:squid", EntitySquid.NETWORK_ID)
            .put("minecraft:drowned", EntityDrowned.NETWORK_ID)
            .put("minecraft:sheep", EntitySheep.NETWORK_ID)
            .put("minecraft:mooshroom", EntityMooshroom.NETWORK_ID)
            .put("minecraft:panda", EntityPanda.NETWORK_ID)
            .put("minecraft:salmon", EntitySalmon.NETWORK_ID)
            .put("minecraft:pig", EntityPig.NETWORK_ID)
            .put("minecraft:villager", EntityVillagerV1.NETWORK_ID)
            .put("minecraft:cod", EntityCod.NETWORK_ID)
            .put("minecraft:pufferfish", EntityPufferfish.NETWORK_ID)
            .put("minecraft:cow", EntityCow.NETWORK_ID)
            .put("minecraft:chicken", EntityChicken.NETWORK_ID)
            .put("minecraft:balloon", 107)
            .put("minecraft:llama", EntityLlama.NETWORK_ID)
            .put("minecraft:iron_golem", 20)
            .put("minecraft:rabbit", EntityRabbit.NETWORK_ID)
            .put("minecraft:snow_golem", 21)
            .put("minecraft:bat", EntityBat.NETWORK_ID)
            .put("minecraft:ocelot", EntityOcelot.NETWORK_ID)
            .put("minecraft:horse", EntityHorse.NETWORK_ID)
            .put("minecraft:cat", EntityCat.NETWORK_ID)
            .put("minecraft:polar_bear", EntityPolarBear.NETWORK_ID)
            .put("minecraft:zombie_horse", EntityZombieHorse.NETWORK_ID)
            .put("minecraft:turtle", EntityTurtle.NETWORK_ID)
            .put("minecraft:parrot", EntityParrot.NETWORK_ID)
            .put("minecraft:guardian", EntityGuardian.NETWORK_ID)
            .put("minecraft:elder_guardian", EntityElderGuardian.NETWORK_ID)
            .put("minecraft:vindicator", EntityVindicator.NETWORK_ID)
            .put("minecraft:wither", EntityWither.NETWORK_ID)
            .put("minecraft:ender_dragon", EntityEnderDragon.NETWORK_ID)
            .put("minecraft:shulker", EntityShulker.NETWORK_ID)
            .put("minecraft:endermite", EntityEndermite.NETWORK_ID)
            .put("minecraft:minecart", EntityMinecartEmpty.NETWORK_ID)
            .put("minecraft:hopper_minecart", EntityMinecartHopper.NETWORK_ID)
            .put("minecraft:tnt_minecart", EntityMinecartTNT.NETWORK_ID)
            .put("minecraft:chest_minecart", EntityMinecartChest.NETWORK_ID)
            .put("minecraft:command_block_minecart", 100)
            .put("minecraft:armor_stand", 61)
            .put("minecraft:item", EntityItem.NETWORK_ID)
            .put("minecraft:tnt", EntityPrimedTNT.NETWORK_ID)
            .put("minecraft:falling_block", EntityFallingBlock.NETWORK_ID)
            .put("minecraft:xp_bottle", EntityExpBottle.NETWORK_ID)
            .put("minecraft:xp_orb", EntityXPOrb.NETWORK_ID)
            .put("minecraft:eye_of_ender_signal", 70)
            .put("minecraft:ender_crystal", EntityEndCrystal.NETWORK_ID)
            .put("minecraft:shulker_bullet", 76)
            .put("minecraft:fishing_hook", EntityFishingHook.NETWORK_ID)
            .put("minecraft:dragon_fireball", 79)
            .put("minecraft:arrow", EntityArrow.NETWORK_ID)
            .put("minecraft:snowball", EntitySnowball.NETWORK_ID)
            .put("minecraft:egg", EntityEgg.NETWORK_ID)
            .put("minecraft:painting", EntityPainting.NETWORK_ID)
            .put("minecraft:thrown_trident", EntityThrownTrident.NETWORK_ID)
            .put("minecraft:fireball", 85)
            .put("minecraft:splash_potion", EntityPotion.NETWORK_ID)
            .put("minecraft:ender_pearl", EntityEnderPearl.NETWORK_ID)
            .put("minecraft:leash_knot", 88)
            .put("minecraft:wither_skull", 89)
            .put("minecraft:wither_skull_dangerous", 91)
            .put("minecraft:boat", EntityBoat.NETWORK_ID)
            .put("minecraft:lightning_bolt", EntityLightning.NETWORK_ID)
            .put("minecraft:small_fireball", 94)
            .put("minecraft:llama_spit", 102)
            .put("minecraft:area_effect_cloud", 95)
            .put("minecraft:lingering_potion", 101)
            .put("minecraft:fireworks_rocket", EntityFirework.NETWORK_ID)
            .put("minecraft:evocation_fang", 103)
            .put("minecraft:evocation_illager", 104)
            .put("minecraft:vex", EntityVex.NETWORK_ID)
            .put("minecraft:agent", 56)
            .put("minecraft:ice_bomb", 106)
            .put("minecraft:phantom", EntityPhantom.NETWORK_ID)
            .put("minecraft:tripod_camera", 62)
            .put("minecraft:pillager", EntityPillager.NETWORK_ID)
            .put("minecraft:wandering_trader", EntityWanderingTrader.NETWORK_ID)
            .put("minecraft:ravager", EntityRavager.NETWORK_ID)
            .put("minecraft:villager_v2", EntityVillager.NETWORK_ID)
            .put("minecraft:zombie_villager_v2", EntityZombieVillager.NETWORK_ID)
            .put("minecraft:fox", 121)
            .put("minecraft:bee", 122)
            .build();

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    public long entityUniqueId;
    public long entityRuntimeId;
    public int type;
    public String id;
    public float x;
    public float y;
    public float z;
    public float speedX = 0f;
    public float speedY = 0f;
    public float speedZ = 0f;
    public float yaw;
    public float pitch;
    public float headYaw;
    public EntityMetadata metadata = new EntityMetadata();
    public Attribute[] attributes = new Attribute[0];
    public EntityLink[] links = new EntityLink[0];

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        this.putEntityUniqueId(this.entityUniqueId);
        this.putEntityRuntimeId(this.entityRuntimeId);
        if (id != null) {
            type = LEGACY_IDS.get(id);
        }
        this.putUnsignedVarInt(this.type);
        this.putVector3f(this.x, this.y, this.z);
        this.putVector3f(this.speedX, this.speedY, this.speedZ);
        this.putLFloat(this.pitch);
        this.putLFloat(this.yaw);
        this.putLFloat(this.headYaw);
        this.putAttributeList(this.attributes);
        this.put(Binary.writeMetadata(this.metadata));
        this.putUnsignedVarInt(this.links.length);
        for (EntityLink link : links) {
            putEntityLink(link);
        }
    }
}
