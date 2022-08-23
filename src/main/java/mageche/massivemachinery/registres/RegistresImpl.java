package mageche.massivemachinery.registres;

import net.minecraftforge.eventbus.api.IEventBus;

public class RegistresImpl {

    public static void register(IEventBus eventBus){
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
    }

}
