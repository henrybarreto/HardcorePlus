package dev.henrybarreto.hardcoreplus.commands;

import dev.henrybarreto.hardcoreplus.state.ServerState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HdpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {
            return false;
        }
        Player player = (Player) commandSender;
        String arg1 = strings[0];
        String arg2 = strings[1];
        ServerState serverState = new ServerState();
        if(arg1.equals("count")) {
            if (arg2.equals("death")) {
                if(serverState.getDeaths() <= 1) {
                    player.sendMessage(Integer.toString(serverState.getDeaths()) + " death in the server");
                    return true;
                }
                player.sendMessage(Integer.toString(serverState.getDeaths()) + " deaths in the server");
                return true;
            }
            return false;
        }
        return false;
    }
}
