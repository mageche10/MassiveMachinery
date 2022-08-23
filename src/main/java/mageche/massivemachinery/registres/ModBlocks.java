package mageche.massivemachinery.registres;

import mageche.massivemachinery.MassiveMachinery;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MassiveMachinery.MOD_ID);

    public static final RegistryObject<Block> BALSAM_FIR_PLANKS = registerBlock("balsam_fir_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeTab.MASSIVEMACHINERY_TAB);
    public static final RegistryObject<Block> BALSAM_FIR_LOG = registerBlock("balsam_fir_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeTab.MASSIVEMACHINERY_TAB);
    public static final RegistryObject<Block> BALSAM_FIR_WOOD = registerBlock("balsam_fir_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeTab.MASSIVEMACHINERY_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(tab)));
        return toReturn;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }



}
