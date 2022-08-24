package mageche.massivemachinery.registres;

import mageche.massivemachinery.MassiveMachinery;
import mageche.massivemachinery.block.OreBlock;
import mageche.massivemachinery.resources.OreType;
import mageche.massivemachinery.util.STONE_TYPES;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.antlr.v4.runtime.atn.SemanticContext;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MassiveMachinery.MOD_ID);

    public static final Map<OreType, Map<STONE_TYPES, RegistryObject<OreBlock>>> ORES = new HashMap<>();

    static {
        for (OreType ore: OreType.values()){
            Map<STONE_TYPES, RegistryObject<OreBlock>> ores = registerOre(ore);
            ORES.put(ore, Map.of(STONE_TYPES.STONE, ores.get(STONE_TYPES.STONE), STONE_TYPES.DEEPSLATE, ores.get(STONE_TYPES.DEEPSLATE)));
        }
    }

    public static final RegistryObject<Block> BALSAM_FIR_PLANKS = registerBlock("balsam_fir_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> BALSAM_FIR_LOG = registerBlock("balsam_fir_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> BALSAM_FIR_WOOD = registerBlock("balsam_fir_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> COPPER_ORE = registerBlock("copper_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE)));
    public static final RegistryObject<Block> DEEPSLATE_COPPER_ORE = registerBlock("deepslate_copper_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_COPPER_ORE)));
    //public static final RegistryObject<Block> LEAD_ORE = registerBlock("lead_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
    //public static final RegistryObject<Block> DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)));
    //public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
    //public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)));
    //public static final RegistryObject<Block> ZINC_ORE = registerBlock("zinc_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
    //public static final RegistryObject<Block> DEEPSLATE_ZINC_ORE = registerBlock("deepslate_zinc_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)));
    //public static final RegistryObject<Block> SULFUR_ORE = registerBlock("sulfur_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).strength(2.5F, 2.5F), UniformInt.of(1, 3)));
    //public static final RegistryObject<Block> DEEPSLATE_SULFUR_ORE = registerBlock("deepslate_sulfur_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).strength(4F, 2.5F), UniformInt.of(1, 3)));
    //public static final RegistryObject<Block> BAUXITE_ORE = registerBlock("bauxite_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).strength(4F, 4F)));
    //public static final RegistryObject<Block> DEEPSLATE_BAUXITE_ORE = registerBlock("deepslate_bauxite_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).strength(5.5F, 3.5F)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(ModCreativeTab.MASSIVEMACHINERY_TAB)));
        return toReturn;
    }

    private static Map<STONE_TYPES, RegistryObject<OreBlock>> registerOre(OreType ore){
        String name = ore.getResource().getRegistryName();
        RegistryObject<OreBlock> stoneOre = registerBlock(name + "_ore", () -> new OreBlock(ore));
        RegistryObject<OreBlock> deepslateOre = registerBlock("deepslate_" + name + "_ore",
                () -> new OreBlock(ore, BlockBehaviour.Properties.of(Material.STONE).strength(4.5F, 3F).requiresCorrectToolForDrops().color(MaterialColor.DEEPSLATE).sound(SoundType.DEEPSLATE)));
        return Map.of(STONE_TYPES.STONE, stoneOre, STONE_TYPES.DEEPSLATE, deepslateOre);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
