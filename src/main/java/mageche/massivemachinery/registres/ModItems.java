package mageche.massivemachinery.registres;

import mageche.massivemachinery.MassiveMachinery;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MassiveMachinery.MOD_ID);

    public static final RegistryObject<Item> RAW_BAUXITE = ITEMS.register("raw_bauxite", () -> new Item(new Item.Properties().tab(ModCreativeTab.MASSIVEMACHINERY_TAB)));
    public static final RegistryObject<Item> RAW_COPPER = ITEMS.register("raw_copper", () -> new Item(new Item.Properties().tab(ModCreativeTab.MASSIVEMACHINERY_TAB)));
    public static final RegistryObject<Item> RAW_LEAD = ITEMS.register("raw_lead", () -> new Item(new Item.Properties().tab(ModCreativeTab.MASSIVEMACHINERY_TAB)));
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin", () -> new Item(new Item.Properties().tab(ModCreativeTab.MASSIVEMACHINERY_TAB)));
    public static final RegistryObject<Item> SULFUR = ITEMS.register("sulfur", () -> new Item(new Item.Properties().tab(ModCreativeTab.MASSIVEMACHINERY_TAB)));
    public static final RegistryObject<Item> RAW_ZINC = ITEMS.register("raw_zinc", () -> new Item(new Item.Properties().tab(ModCreativeTab.MASSIVEMACHINERY_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
