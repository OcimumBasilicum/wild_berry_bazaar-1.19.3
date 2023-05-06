package net.ocibas.wild_berry_bazaar.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ocibas.wild_berry_bazaar.Wild_Berry_Bazaar;
import net.ocibas.wild_berry_bazaar.block.ModBlocks;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Wild_Berry_Bazaar.MOD_ID);



    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_BUSH.get(), new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(2f).build())));
    public static final RegistryObject<Item> RASPBERRY = ITEMS.register("raspberry",
            () -> new ItemNameBlockItem(ModBlocks.RASPBERRY_BUSH.get(), new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(2f).build())));
    public static final RegistryObject<Item> BLACKBERRY = ITEMS.register("blackberry",
            () -> new ItemNameBlockItem(ModBlocks.BLACKBERRY_BUSH.get(), new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(2f).build())));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
