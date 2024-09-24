package fr.xelasflame.vanillaplus;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BundleMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public static ItemStack ironhammer;
    public static ItemStack diamondhammer;
    public static ItemStack netheritehammer;
    public static ItemStack portablecrafter;

    public static ItemStack parachute;
    public static ItemStack backpack1;
    public static ItemStack backpack2;
    public static ItemStack backpack3;
    public static ItemStack gembag;

    public static ItemStack mining_tear;

    public static ItemStack the_mask;
    public static ItemStack luffy_strawhat;
    public static ItemStack atlantide_gem;
    public static ItemStack spartan_shield;
    public static ItemStack sun_comet;
    public static ItemStack pegasus_feather;

    public static void init(){
        createironhammer();
        creatediamondhammer();
        createnetheritehammer();
        createportablecrafter();
        createparachute();
        createbackpack1();
        createbackpack2();
        createbackpack3();
        creategembag();


        createthe_mask();
        createluffy_strawhat();
        createatlantide_gem();
        createmining_tear();
        createspartan_shiel();
        createsuns_comet();
        createpegasus_feather();

    }

    private static void createironhammer(){
        ItemStack item = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Iron Hammer");
        meta.setCustomModelData(1);
        List<String> lore = new ArrayList<>();
        lore.add("§9Mine en 3x3");
        lore.add("§cNe fonctionne pas avec l'enchantement Fortune");
        meta.setLore(lore);
        item.setItemMeta(meta);
        ironhammer = item;
    }

    private static void creatediamondhammer(){
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Diamond Hammer");
        meta.setCustomModelData(1);
        List<String> lore = new ArrayList<>();
        lore.add("§9Mine en 3x3");
        lore.add("§cNe fonctionne pas avec l'enchantement Fortune");
        meta.setLore(lore);
        item.setItemMeta(meta);
        diamondhammer = item;
    }
    private static void createnetheritehammer(){
        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Netherite Hammer");
        meta.setCustomModelData(1);
        List<String> lore = new ArrayList<>();
        lore.add("§9Mine en 3x3");
        lore.add("§cNe fonctionne pas avec l'enchantement Fortune");
        meta.setLore(lore);
        item.setItemMeta(meta);
        netheritehammer = item;
    }




    private static void createparachute(){
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Parachute");
        meta.setCustomModelData(1);
        List<String> lore = new ArrayList<>();
        lore.add("Un parachute qui vous permet de ne plus mourrir de chute !");
        meta.setLore(lore);
        item.setItemMeta(meta);
        parachute = item;
    }

    private static void createportablecrafter(){
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Portable Crafter");
        meta.setCustomModelData(2);
        List<String> lore = new ArrayList<>();
        lore.add("Avez vous déjà vu une table de craft de poche ? Maintenant OUi");
        meta.setLore(lore);
        item.setItemMeta(meta);
        portablecrafter = item;
    }

    private  static  void createbackpack1(){
        ItemStack item = new ItemStack(Material.BUNDLE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "BackPack Tier 1");
        meta.setCustomModelData(1);
        item.setItemMeta(meta);
        backpack1 = item;
    }
    private  static  void createbackpack2(){
        ItemStack item = new ItemStack(Material.BUNDLE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "BackPack Tier 2");
        meta.setCustomModelData(2);
        item.setItemMeta(meta);
        backpack2 = item;
    }
    private  static  void createbackpack3(){
        ItemStack item = new ItemStack(Material.BUNDLE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "BackPack Tier 3");
        meta.setCustomModelData(3);
        item.setItemMeta(meta);
        backpack3 = item;
    }



    private  static  void creategembag(){
        ItemStack item = new ItemStack(Material.BUNDLE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Gems Bag");
        meta.setCustomModelData(4);
        item.setItemMeta(meta);
        gembag = item;
    }

    public static boolean isPickaxe(ItemStack item) {
        if (item == null || item.getType() == Material.AIR) {
            return false;
        }

        switch (item.getType()) {
            case WOODEN_PICKAXE:
            case STONE_PICKAXE:
            case IRON_PICKAXE:
            case GOLDEN_PICKAXE:
            case DIAMOND_PICKAXE:
            case NETHERITE_PICKAXE:
                return true;
            default:
                return false;
        }
    }

    public static void applyGemEffect(Player player, Inventory inv){
        player.removePotionEffect(PotionEffectType.HASTE);
        player.removePotionEffect(PotionEffectType.SPEED);
        player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
        player.removePotionEffect(PotionEffectType.RESISTANCE);
        player.removePotionEffect(PotionEffectType.STRENGTH);
        player.removePotionEffect(PotionEffectType.JUMP_BOOST);
        player.removePotionEffect(PotionEffectType.WATER_BREATHING);
        player.getInventory().setMaxStackSize(64);
        for(ItemStack item : inv.getContents()){
            if(item != null && item.getType() != Material.AIR){
            int data = item.getItemMeta().getCustomModelData();

            switch (data){
                case 1: // "Mining Tear"
                    player.addPotionEffect(new PotionEffect(PotionEffectType.HASTE, PotionEffect.INFINITE_DURATION, 2, true, false, false));
                    break;

                case 2: // "Sun's comet"
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, PotionEffect.INFINITE_DURATION, 2, true, false, true));
                    break;
                case 3: // "Pegasus's Feather"
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, PotionEffect.INFINITE_DURATION, 1, true, false, false));
                    break;
                case 4: //"Spartan's Shiel"
                    player.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, PotionEffect.INFINITE_DURATION, 1, true, false, false));
                    break;
                case 5 ://"Luffy's Straw Hat"
                    player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, PotionEffect.INFINITE_DURATION, 0, true, false, false));
                    break;
                case 6: //"Atlantide's Gem"
                    player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, PotionEffect.INFINITE_DURATION, 0, true, false, false));
                    break;
                case 7: //"The Mask" :
                    player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP_BOOST, PotionEffect.INFINITE_DURATION, 2, true, false, false));
                    break;
                default:
                    break;

            }
        }}


    }

    private static void createmining_tear(){
        ItemStack item = new ItemStack(Material.EMERALD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Mining Tear");
        meta.setCustomModelData(1);
        List<String> lore = new ArrayList<>();
        lore.add("Les larmes des mineurs perdu ici bas vous confère un immence pouvoir");
        meta.setLore(lore);
        item.setItemMeta(meta);
        mining_tear = item;
    }
    private static void createsuns_comet(){
        ItemStack item = new ItemStack(Material.EMERALD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Sun's Commet");
        meta.setCustomModelData(2);
        List<String> lore = new ArrayList<>();
        lore.add("Les rayons du soleil vous parcours tout le corp");
        meta.setLore(lore);
        item.setItemMeta(meta);
        sun_comet = item;
    }
    private static void createpegasus_feather(){
        ItemStack item = new ItemStack(Material.EMERALD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Pegasus's Feather");
        meta.setCustomModelData(3);
        List<String> lore = new ArrayList<>();
        lore.add("La grace de pégase semble être avec vous");
        meta.setLore(lore);
        item.setItemMeta(meta);
        pegasus_feather = item;
    }
    private static void createspartan_shiel(){
        ItemStack item = new ItemStack(Material.EMERALD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GRAY + "Spartan's Shiel");
        meta.setCustomModelData(4);
        List<String> lore = new ArrayList<>();
        lore.add("Une protection d'antan semble vous appeler");
        meta.setLore(lore);
        item.setItemMeta(meta);
        spartan_shield = item;
    }
    private static void createluffy_strawhat(){
        ItemStack item = new ItemStack(Material.EMERALD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Luffy's Straw Hat");
        meta.setCustomModelData(5);
        List<String> lore = new ArrayList<>();
        lore.add("Le tambour de la liberté frappe en vous");
        meta.setLore(lore);
        item.setItemMeta(meta);
        luffy_strawhat = item;
    }
    private static void createatlantide_gem(){
        ItemStack item = new ItemStack(Material.EMERALD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_AQUA + "Atlantide's Gem");
        meta.setCustomModelData(6);
        List<String> lore = new ArrayList<>();
        lore.add("Un trésor des plus intrigant aux ressourses inconnues");
        meta.setLore(lore);
        item.setItemMeta(meta);
        atlantide_gem = item;
    }
    private static void createthe_mask(){
        ItemStack item = new ItemStack(Material.EMERALD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "The Mask");
        meta.setCustomModelData(7);
        List<String> lore = new ArrayList<>();
        lore.add("Un masque aux propriétés elastique semble vous murmurer à l'oreille");
        meta.setLore(lore);
        item.setItemMeta(meta);
        the_mask = item;
    }

}
