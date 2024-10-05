package fr.xelasflame.vanillaplus;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandManager implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if(s.equalsIgnoreCase("vp")) {
                if(strings.length == 1) {
                    if(strings[0].equalsIgnoreCase("recipe")) {
                        RecipeManager.updaterecipe(player);
                        player.sendMessage("Update successfully");
                    }
                    else if(strings[0].equalsIgnoreCase("gems")) {
                        player.sendMessage(ChatColor.BOLD + "Dans ces contrés, l'on peut acquérir des gems, vestiges du passé, elle octroient à leur détenteur d'inombrables pouvoirs.\n" +
                                "Cependant, leur force est telle qu'il est necessaire de posseder un sac pour contenir et rediriger leur force.\n\n" +
                                "Les pouvoirs des gems sont :\n");
                        for(Gems gems : Gems.gems_list) {
                            player.sendMessage(gems.toString());
                        }
                        player.sendMessage("Si un de ces vestiges du passé vous interesse il vous faudra le" + ChatColor.RED + " Gems Bag.\n" +
                                ChatColor.WHITE + "Tous ces crafts sont disponibles dans le livre de recette de l'établie'");
                    }

                }
                else{
                    player.sendMessage("Plugin créé par §bXelasflame§f en collaboration avec BS Esport.\n" +
                            "Ce plugin rajoute de nombreux items apparraissant dans votre livre de recette §l§3(n'hésitez pas à déco reco si les items n'apparaissent pas)\n" +
                            "N'oubliez pas le texture pack fait sur mesure pour ce plugin.\n\n" +
                            ChatColor.WHITE + "Ci dessous la liste des commandes possible:\n" +
                            ChatColor.GREEN + ChatColor.BOLD + "/vp gems : " + ChatColor.WHITE + "Permet de connaitre tous les spécificités des gems");
                }

            }

        }
        return false;
    }
}
