package rrunnerx.auto_respawn;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MyForgeEventHandler
{
    public static boolean respawnIsActive = true;
    @SubscribeEvent
    public void GuiOpenEvent(GuiOpenEvent event)
    {

        if(event.getGui() instanceof GuiGameOver && respawnIsActive)
        {
            EntityPlayer player = Minecraft.getMinecraft().player;
            player.respawnPlayer();
        }

    }

    public static void ToggleRespawnIsActive()
    {
        respawnIsActive = !respawnIsActive;
    }

    public static boolean GetRespawnIsActive()
    {
        return respawnIsActive;
    }
}
