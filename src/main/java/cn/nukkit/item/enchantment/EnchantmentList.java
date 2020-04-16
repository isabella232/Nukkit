package cn.nukkit.item.enchantment;

import cn.nukkit.inventory.CraftingManager;
import cn.nukkit.inventory.Recipe;
import cn.nukkit.inventory.RecipeType;
import cn.nukkit.item.Item;

/**
 * @author Nukkit Project Team
 */
public class EnchantmentList implements Recipe {

    private final EnchantmentEntry[] enchantments;

    public EnchantmentList(int size) {
        this.enchantments = new EnchantmentEntry[size];
    }

    /**
     * @param slot  The index of enchantment.
     * @param entry The given enchantment entry.
     * @return {@link EnchantmentList}
     */
    public EnchantmentList setSlot(int slot, EnchantmentEntry entry) {
        enchantments[slot] = entry;
        return this;
    }

    public EnchantmentEntry getSlot(int slot) {
        return enchantments[slot];
    }

    public int getSize() {
        return enchantments.length;
    }

    @Override
    public Item getResult() {
        return null;
    }

    @Override
    public void registerToCraftingManager(CraftingManager manager) {
        manager.registerRecipe(this);
    }

    @Override
    public RecipeType getType() {
        return RecipeType.SHULKER_BOX;
    }
}
