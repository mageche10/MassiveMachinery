package mageche.massivemachinery;

import com.mojang.logging.LogUtils;
import mageche.massivemachinery.registres.RegistresImpl;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(MassiveMachinery.MOD_ID)
public class MassiveMachinery {

    public static final String MOD_ID = "massivemachinery";
    private static final Logger LOGGER = LogUtils.getLogger();


    public MassiveMachinery() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        RegistresImpl.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
