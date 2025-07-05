package fr.xelasflame.vanillaplus;

import jdk.dynalink.Operation;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BundleMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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

    public static ItemStack chrismascup;
    public static ItemStack candy;
    public static ItemStack xmashat;

    public static Gems mining_tear;
    public static Gems the_mask;
    public static Gems luffy_strawhat;
    public static Gems atlantide_gem;
    public static Gems spartan_shield;
    public static Gems sun_comet;
    public static Gems pegasus_feather;

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


        mining_tear = new Gems("Mining Tear", ChatColor.BLUE, Collections.singletonList("Les larmes de mineurs déchus parcourent votre être"), PotionEffectType.HASTE, 2);
        sun_comet = new Gems("Sun's Commet", ChatColor.YELLOW, Collections.singletonList("Les rayons du soleil vous parcours tout le corp"), PotionEffectType.FIRE_RESISTANCE, 2);
        pegasus_feather = new Gems("Pegasus's Feather", ChatColor.AQUA, Collections.singletonList("La grace de pégase semble être avec vous"), PotionEffectType.SPEED, 1);
        spartan_shield = new Gems( "Spartan's Shiel", ChatColor.GRAY, Collections.singletonList("Une protection d'antan semble vous appeler"), PotionEffectType.RESISTANCE, 1);
        luffy_strawhat = new Gems("Luffy's Straw Hat", ChatColor.GOLD, Collections.singletonList("Le tambour de la liberté frappe en vous"), PotionEffectType.STRENGTH, 0);
        atlantide_gem = new Gems("Atlantide's Gem", ChatColor.DARK_AQUA, Collections.singletonList("Un trésor des plus intrigant aux ressourses inconnues"), PotionEffectType.WATER_BREATHING, 0);
        the_mask = new Gems( "The Mask", ChatColor.GREEN, Collections.singletonList("Un masque aux propriétés elastique semble vous murmurer à l'oreille"), PotionEffectType.JUMP_BOOST, 2);

        createchrismasCup();
        createcandy();
        createXmasHat();
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

    private static void createchrismasCup(){
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Chrismas Cup : " + LocalDate.now().getYear());
        meta.setCustomModelData(3);
        item.setItemMeta(meta);
        chrismascup = item;
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
        for(PotionEffectType effect : Gems.gems_effect) {
            player.removePotionEffect(effect);
        }
        for(ItemStack item : inv.getContents()){
            if(item != null) {
                Gems gems = Gems.gems_list.get(item.getItemMeta().getCustomModelData() - 1);
                gems.setPotion(player);
            }
           }
    }

    public static void createcandy(){
        ItemStack item = new ItemStack(Material.COOKIE, 5);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Candy");
        meta.setCustomModelData(1);
        List<String> lore = new ArrayList<>();
        lore.add("Un excès de sucre est si vite arrivé.");
        meta.setLore(lore);
        item.setItemMeta(meta);
        candy = item;
    }

    public static void createXmasHat(){
        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Xmas Hat");
        meta.setCustomModelData(1);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(NamespacedKey.minecraft("xmas_generic_armor"), 5, AttributeModifier.Operation.ADD_NUMBER));
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList<>();
        lore.add("Un chapeau soyeux et de bonne fabrique aux propriétés indescriptibles");
        meta.setLore(lore);
        item.setItemMeta(meta);
        xmashat = item;

    }
}
