package rrunnerx.auto_respawn;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Auto_Respawn.MODID, name = Auto_Respawn.NAME,
        version = Auto_Respawn.VERSION, acceptedMinecraftVersions = Auto_Respawn.MC_VERSION, useMetadata = true)
public class Auto_Respawn
{
    public static final String MODID = "auto_respawn";
    public static final String NAME = "Auto-Respawn";
    public static final String VERSION = "0.0.1";
    public static final String MC_VERSION = "1.12.2";

    public static final Logger LOGGER = LogManager.getLogger(Auto_Respawn.MODID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MyForgeEventHandler handler = new MyForgeEventHandler();
        MinecraftForge.EVENT_BUS.register(handler);

        ClientCommandHandler.instance.registerCommand(new RespawnSettingsCommand());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

}
