package net.ocibas.wild_berry_bazaar;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.ocibas.wild_berry_bazaar.block.ModBlocks;
import net.ocibas.wild_berry_bazaar.item.ModItems;
import net.ocibas.wild_berry_bazaar.sound.ModSounds;
import org.slf4j.Logger;

@Mod(Wild_Berry_Bazaar.MOD_ID)
public class Wild_Berry_Bazaar
{
    public static final String MOD_ID = "wild_berry_bazaar";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Wild_Berry_Bazaar()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModSounds.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }



    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.STRAWBERRY_BUSH.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.RASPBERRY_BUSH.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACKBERRY_BUSH.get(), RenderType.cutout());

        }
    }
}
