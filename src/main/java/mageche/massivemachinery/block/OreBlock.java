package mageche.massivemachinery.block;

import mageche.massivemachinery.resources.IResource;
import mageche.massivemachinery.resources.OreType;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class OreBlock extends DropExperienceBlock {

    private final OreType ore;

    public OreBlock(OreType ore) {
        this(ore, BlockBehaviour.Properties.of(Material.STONE).strength(3F, 3F).requiresCorrectToolForDrops());
    }

    public OreBlock(OreType ore, Properties properties) {
        super(properties, UniformInt.of(ore.getMinExp(), ore.getMaxExp()));
        this.ore = ore;
    }

    public IResource getResource() {
        return ore.getResource();
    }
}
