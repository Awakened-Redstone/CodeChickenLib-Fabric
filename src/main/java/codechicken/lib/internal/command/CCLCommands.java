package codechicken.lib.internal.command;

import codechicken.lib.internal.command.admin.CountCommand;
import codechicken.lib.internal.command.admin.KillAllCommand;
import codechicken.lib.internal.command.admin.MiscCommands;
import codechicken.lib.internal.command.client.HighlightCommand;
import codechicken.lib.internal.command.dev.DevCommands;
import com.mojang.brigadier.CommandDispatcher;
import net.covers1624.quack.util.CrashLock;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;

/**
 * Created by covers1624 on 17/9/20.
 */
public class CCLCommands {

    private static final CrashLock LOCK = new CrashLock("Already Initialized");

    public static void init() {
        LOCK.lock();

        CommandRegistrationCallback.EVENT.register(CCLCommands::registerServerCommands);
    }

    private static void registerServerCommands(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext registryAccess, Commands.CommandSelection environment) {
        CountCommand.register(dispatcher);
        KillAllCommand.register(dispatcher);
        MiscCommands.register(dispatcher);
        DevCommands.register(dispatcher);
    }

    private static void registerClientCommands(RegisterClientCommandsEvent event) { //TODO: Register with ClientCommandManager
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
        HighlightCommand.register(dispatcher);
    }

}
