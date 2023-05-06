package net.ocibas.wild_berry_bazaar.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ocibas.wild_berry_bazaar.Wild_Berry_Bazaar;
import net.ocibas.wild_berry_bazaar.block.new_blocks.BlackberryCropBlock;
import net.ocibas.wild_berry_bazaar.block.new_blocks.RaspberryCropBlock;
import net.ocibas.wild_berry_bazaar.block.new_blocks.StrawberryCropBlock;
import net.ocibas.wild_berry_bazaar.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Wild_Berry_Bazaar.MOD_ID);

    public static final RegistryObject<Block> STRAWBERRY_BUSH = BLOCKS.register("strawberry_bush", () -> new StrawberryCropBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)));
    public static final RegistryObject<Block> RASPBERRY_BUSH = BLOCKS.register("raspberry_bush", () -> new RaspberryCropBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)));
    public static final RegistryObject<Block> BLACKBERRY_BUSH = BLOCKS.register("blackberry_bush", () -> new BlackberryCropBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)));

    private static <T extends Block> RegistryObject<T> RegisterBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
