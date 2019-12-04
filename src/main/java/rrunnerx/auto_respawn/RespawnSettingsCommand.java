package rrunnerx.auto_respawn;

import com.google.common.collect.Lists;
import com.ibm.icu.text.UFormat;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

import static net.minecraft.command.CommandBase.getListOfStringsMatchingLastWord;

public class RespawnSettingsCommand implements ICommand
{

    @Override
    public String getName() {
        return "autorespawn";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "/autorespawn to toggle";
    }

    @Override
    public List<String> getAliases()
    {
        List<String> aliases = Lists.<String>newArrayList();
        aliases.add("ar");
        aliases.add("respawn");
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        MyForgeEventHandler.ToggleRespawnIsActive();
        if(MyForgeEventHandler.GetRespawnIsActive() == true)
        {
            sender.sendMessage(new TextComponentString(TextFormatting.GREEN + "You will now respawn automatically."));
        }else
        {
            sender.sendMessage(new TextComponentString(TextFormatting.RED + "You will no longer respawn automatically."));
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return args.length == 1 ? getListOfStringsMatchingLastWord(args, new String[] {"off", "on"}) : Collections.emptyList();
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
