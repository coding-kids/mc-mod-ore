package codingkids.mc.ckore;

import codingkids.mc.ckore.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

/**
 * Created by Wilson Wu on 2020/02/11.
 */
@Mod(modid = Reference.MODID, version = Reference.VERSION, name = Reference.NAME,
        acceptedMinecraftVersions = Reference.ACCEPTED_VERSION)
public class OreMod {

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    public static Item myDust;
    public static Block myBlock;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        myDust = new Item()
                .setRegistryName("my_dust")
                .setTranslationKey("ckore.my_dust")
                .setCreativeTab(CreativeTabs.MISC);
        myBlock = new OreBlock(new Material(MapColor.AIR), myDust)
                .setRegistryName("my_ore")
                .setTranslationKey("ckore.my_ore")
                .setHardness(1.5F)
                .setCreativeTab(CreativeTabs.MISC);
    }

    @EventHandler
    public void init(FMLInitializationEvent event){
        GameRegistry.addSmelting(myBlock, new ItemStack(myDust), 0.7f);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}
