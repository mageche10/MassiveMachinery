package mageche.massivemachinery.registres;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class ModCreativeTab {

    public static final CreativeModeTab MASSIVEMACHINERY_TAB = new CreativeModeTab("massiveMachineryTab") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(Items.BARRIER);
        }
    };
}
