package fr.xelasflame.vanillaplus;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

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



            } else if(strings.length == 2) {
                if(strings[0].equalsIgnoreCase("give") && player.hasPermission("bse.admin")) {
                    switch(strings[1]) {
                        case "iron_hammer":
                            player.getInventory().addItem(ItemManager.ironhammer);
                            break;
                        case "diamond_hammer":
                            player.getInventory().addItem(ItemManager.diamondhammer);
                            break;
                        case "netherite_hammer":
                            player.getInventory().addItem(ItemManager.netheritehammer);
                            break;
                        case "portable_crafter":
                            player.getInventory().addItem(ItemManager.portablecrafter);
                            break;
                        case "parachute":
                            player.getInventory().addItem(ItemManager.parachute);
                            break;
                        case "backpack1":
                            player.getInventory().addItem(ItemManager.backpack1);
                            break;
                        case "backpack2":
                            player.getInventory().addItem(ItemManager.backpack2);
                            break;
                        case "backpack3":
                             player.getInventory().addItem(ItemManager.backpack3);
                             break;
                        case "gembag":
                            player.getInventory().addItem(ItemManager.gembag);
                            break;
                        case "chrismascup":
                            player.getInventory().addItem(ItemManager.chrismascup);
                            break;
                        case "mining_tear":
                            player.getInventory().addItem(ItemManager.mining_tear.getItem());
                            break;
                        case "the_mask":
                            player.getInventory().addItem(ItemManager.the_mask.getItem());
                            break;
                        case "luffy_strawhat":
                            player.getInventory().addItem(ItemManager.luffy_strawhat.getItem());
                            break;
                        case "atlantide_gem":
                            player.getInventory().addItem(ItemManager.atlantide_gem.getItem());
                            break;
                        case "spartan_shield":
                            player.getInventory().addItem(ItemManager.spartan_shield.getItem());
                            break;
                        case "sun_comet":
                            player.getInventory().addItem(ItemManager.sun_comet.getItem());
                            break;
                        case "pegasus_feather":
                            player.getInventory().addItem(ItemManager.pegasus_feather.getItem());
                            break;
                        case "candy":
                            player.getInventory().addItem(ItemManager.candy);
                            break;
                        case "xmashat":
                            player.getInventory().addItem(ItemManager.xmashat);
                            break;
                        default:
                            player.sendMessage("Erreur dans le nom de l'item");
                            break;

                    }
                }
                }

                else{
                    player.sendMessage("Plugin créé par §bXelasflame§f en collaboration avec BS Esport.\n" +
                            "Ce plugin rajoute de nombreux items apparraissant dans votre livre de recette §l§3(n'hésitez pas à déco reco si les items n'apparaissent pas)\n" +
                            "N'oubliez pas le texture pack fait sur mesure pour ce plugin.\n\n" +
                            ChatColor.WHITE + "Ci dessous la liste des commandes possible:\n" +
                            ChatColor.GREEN + ChatColor.BOLD + "/vp gems : " + ChatColor.WHITE + "Permet de connaitre tous les spécificités des gems\n"+
                            ChatColor.GREEN + ChatColor.BOLD + "/vp recipe : " + ChatColor.WHITE + "Permet de remettre à jours les recettes customs");
                }
            }

        }
        return false;
    }
}
