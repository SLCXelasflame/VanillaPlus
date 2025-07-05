package fr.xelasflame.vanillaplus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapedRecipe;

public class RecipeManager {

public static void init(){
    recipeironhammer();
    recipediamondhammer();
    recipenetheritehammer();
    recipeparachute();
    recipeportablecrafter();
    recipebackpack1();
    recipebackpack2();
    recipebackpack3();

    recipegemsbag();

    recipemining_tear();
    recipesun_comet();
    recipepegasus_feather();
    recipespartan_shield();
    recipeluffy_strawhat();
    recipeatlantide_gem();
    recipethe_mask();

    recipecandy();
    recipexmashat();
}

    private static void recipeironhammer(){
        ShapedRecipe ironHammer = new ShapedRecipe(NamespacedKey.minecraft("iron_hammer"), ItemManager.ironhammer);
        ironHammer.shape("ABA", "CDC", "ABA");
        ironHammer.setIngredient('A', Material.RAW_IRON);
        ironHammer.setIngredient('B', Material.COPPER_INGOT);
        ironHammer.setIngredient('C', Material.COAL_BLOCK);
        ironHammer.setIngredient('D', Material.IRON_PICKAXE);
        Bukkit.addRecipe(ironHammer);
    }

    private static void recipediamondhammer(){
        ShapedRecipe diamond_hammer = new ShapedRecipe(NamespacedKey.minecraft("diamond_hammer"), ItemManager.diamondhammer);
        diamond_hammer.shape("ABA", "CDC", "ABA");
        diamond_hammer.setIngredient('A', Material.DIAMOND);
        diamond_hammer.setIngredient('B', Material.GOLD_INGOT);
        diamond_hammer.setIngredient('C', Material.REDSTONE_BLOCK);
        diamond_hammer.setIngredient('D', ItemManager.ironhammer);
        Bukkit.addRecipe(diamond_hammer);
    }

    private static void recipenetheritehammer(){
        ShapedRecipe netheriteHammer = new ShapedRecipe(NamespacedKey.minecraft("netherite_hammer"), ItemManager.netheritehammer);
        netheriteHammer.shape("ABA", "CDC", "ABA");
        netheriteHammer.setIngredient('A', Material.NETHERITE_SCRAP);
        netheriteHammer.setIngredient('B', Material.DIAMOND);
        netheriteHammer.setIngredient('C', Material.AMETHYST_SHARD);
        netheriteHammer.setIngredient('D', ItemManager.diamondhammer);
        Bukkit.addRecipe(netheriteHammer);
    }




    private  static void recipeparachute(){
        ShapedRecipe parachute = new ShapedRecipe(NamespacedKey.minecraft("parachute"), ItemManager.parachute);
        parachute.shape("AAA", "CBC", "AAA");
        parachute.setIngredient('A', Material.PAPER);
        parachute.setIngredient('B', Material.FEATHER);
        parachute.setIngredient('C', Material.LEATHER);
        Bukkit.addRecipe(parachute);
    }

    private  static void recipeportablecrafter(){
        ShapedRecipe portable_crafter = new ShapedRecipe(NamespacedKey.minecraft("portable_crafter"), ItemManager.portablecrafter);
        portable_crafter.shape("ABA", "CDC", "ABA");
        portable_crafter.setIngredient('A', Material.CRAFTING_TABLE);
        portable_crafter.setIngredient('B', Material.IRON_INGOT);
        portable_crafter.setIngredient('C', Material.GOLD_INGOT);
        portable_crafter.setIngredient('D', Material.REDSTONE_BLOCK);
        Bukkit.addRecipe(portable_crafter);
    }

    private  static void recipebackpack1(){
        ShapedRecipe backpack = new ShapedRecipe(NamespacedKey.minecraft("backpack1"), ItemManager.backpack1);
        backpack.shape("ABA", "CDC", "ABA");
        backpack.setIngredient('A', Material.LEATHER);
        backpack.setIngredient('B', Material.CHEST);
        backpack.setIngredient('C', Material.STRING);
        backpack.setIngredient('D', Material.DIAMOND);
        Bukkit.addRecipe(backpack);
    }

    private  static void recipebackpack2(){
        ShapedRecipe backpack = new ShapedRecipe(NamespacedKey.minecraft("backpack2"), ItemManager.backpack2);
        backpack.shape("ABA", "CDC", "ABA");
        backpack.setIngredient('A', Material.IRON_INGOT);
        backpack.setIngredient('B', Material.GOLD_INGOT);
        backpack.setIngredient('C', Material.LEATHER);
        backpack.setIngredient('D', ItemManager.backpack1);
        Bukkit.addRecipe(backpack);
    }

    private  static void recipebackpack3(){
        ShapedRecipe backpack = new ShapedRecipe(NamespacedKey.minecraft("backpack3"), ItemManager.backpack3);
        backpack.shape("ABA", "CDC", "ABA");
        backpack.setIngredient('A', Material.GOLD_INGOT);
        backpack.setIngredient('B', Material.SHULKER_SHELL);
        backpack.setIngredient('C', Material.LEATHER);
        backpack.setIngredient('D', ItemManager.backpack2);
        Bukkit.addRecipe(backpack);
    }

    private  static void recipegemsbag(){
        ShapedRecipe gembag = new ShapedRecipe(NamespacedKey.minecraft("gems_bag"), ItemManager.gembag);
        gembag.shape("ABA", "CDC", "ABA");
        gembag.setIngredient('A', Material.LEATHER);
        gembag.setIngredient('B', Material.GOLD_INGOT);
        gembag.setIngredient('C', Material.LAPIS_LAZULI);
        gembag.setIngredient('D', Material.DIAMOND);
        Bukkit.addRecipe(gembag);
    }

    private  static void recipemining_tear(){
        ShapedRecipe mining_tear = new ShapedRecipe(NamespacedKey.minecraft("mining_tear"), ItemManager.mining_tear.getItem());
        mining_tear.shape("ABA", "CDC", "ABA");
        mining_tear.setIngredient('A', Material.IRON_PICKAXE);
        mining_tear.setIngredient('B', Material.GOLD_INGOT);
        mining_tear.setIngredient('C', Material.COPPER_INGOT);
        mining_tear.setIngredient('D', Material.TORCH);
        Bukkit.addRecipe(mining_tear);
    }
    private  static void recipesun_comet(){
        ShapedRecipe sun_comet = new ShapedRecipe(NamespacedKey.minecraft("sun_comet"), ItemManager.sun_comet.getItem());
        sun_comet.shape("ABA", "CDC", "ABA");
        sun_comet.setIngredient('A', Material.MAGMA_CREAM);
        sun_comet.setIngredient('B', Material.QUARTZ);
        sun_comet.setIngredient('C', Material.BLAZE_ROD);
        sun_comet.setIngredient('D', Material.LAVA_BUCKET);
        Bukkit.addRecipe(sun_comet);
    }

    private  static void recipepegasus_feather(){
        ShapedRecipe pegasus_feather = new ShapedRecipe(NamespacedKey.minecraft("pegasus_feather"), ItemManager.pegasus_feather.getItem());
        pegasus_feather.shape("ABA", "CDC", "ABA");
        pegasus_feather.setIngredient('A', Material.LEATHER);
        pegasus_feather.setIngredient('B', Material.FEATHER);
        pegasus_feather.setIngredient('C', Material.SUGAR);
        pegasus_feather.setIngredient('D', Material.DIAMOND_BOOTS);
        Bukkit.addRecipe(pegasus_feather);
    }
    private  static void recipespartan_shield(){
        ShapedRecipe spartan_shield = new ShapedRecipe(NamespacedKey.minecraft("spartan_shield"), ItemManager.spartan_shield.getItem());
        spartan_shield.shape("ABA", "CDC", "ABA");
        spartan_shield.setIngredient('A', Material.IRON_INGOT);
        spartan_shield.setIngredient('B', Material.GOLD_INGOT);
        spartan_shield.setIngredient('C', Material.ARROW);
        spartan_shield.setIngredient('D', Material.SHIELD);
        Bukkit.addRecipe(spartan_shield);
    }
    private  static void recipeatlantide_gem(){
        ShapedRecipe atlantide_gem = new ShapedRecipe(NamespacedKey.minecraft("atlantide_gem"), ItemManager.atlantide_gem.getItem());
        atlantide_gem.shape("ABA", "CDC", "ABA");
        atlantide_gem.setIngredient('A', Material.SALMON);
        atlantide_gem.setIngredient('B', Material.COD);
        atlantide_gem.setIngredient('C', Material.FISHING_ROD);
        atlantide_gem.setIngredient('D', Material.HEART_OF_THE_SEA);
        Bukkit.addRecipe(atlantide_gem);
    }

    private  static void recipeluffy_strawhat(){
        ShapedRecipe luffy_strawhat = new ShapedRecipe(NamespacedKey.minecraft("luffy_strawhat"), ItemManager.luffy_strawhat.getItem());
        luffy_strawhat.shape("ABA", "CDC", "ABA");
        luffy_strawhat.setIngredient('A', Material.WHEAT);
        luffy_strawhat.setIngredient('B', Material.GOLD_INGOT);
        luffy_strawhat.setIngredient('C', Material.EMERALD);
        luffy_strawhat.setIngredient('D', Material.LEATHER_HELMET);
        Bukkit.addRecipe(luffy_strawhat);
    }

    private  static void recipethe_mask(){
        ShapedRecipe the_mask = new ShapedRecipe(NamespacedKey.minecraft("the_mask"), ItemManager.the_mask.getItem());
        the_mask.shape("ABA", "CDC", "ABA");
        the_mask.setIngredient('A', Material.ROTTEN_FLESH);
        the_mask.setIngredient('B', Material.KELP);
        the_mask.setIngredient('C', Material.RABBIT_HIDE);
        the_mask.setIngredient('D', Material.GOLDEN_HELMET);
        Bukkit.addRecipe(the_mask);
    }

    private  static void recipecandy(){
        ShapedRecipe candy = new ShapedRecipe(NamespacedKey.minecraft("candy"), ItemManager.candy);
        candy.shape("XBX", "CDC", "XBX");
        candy.setIngredient('B', Material.SUGAR);
        candy.setIngredient('C', Material.RED_DYE);
        candy.setIngredient('D', Material.APPLE);
        Bukkit.addRecipe(candy);
    }

    private static void recipexmashat(){
        ShapedRecipe xmashat = new ShapedRecipe(NamespacedKey.minecraft("xmashat"), ItemManager.xmashat);
        xmashat.shape("ABA", "CDC", "ABA");
        xmashat.setIngredient('A', ItemManager.candy);
        xmashat.setIngredient('B', Material.RED_WOOL);
        xmashat.setIngredient('C', Material.GOLD_INGOT);
        xmashat.setIngredient('D', Material.DIAMOND_HELMET);
        Bukkit.addRecipe(xmashat);
    }




    public static void updaterecipe(Player player){
        player.discoverRecipe(NamespacedKey.minecraft("iron_hammer"));
        player.discoverRecipe(NamespacedKey.minecraft("diamond_hammer"));
        player.discoverRecipe(NamespacedKey.minecraft("netherite_hammer"));
        player.discoverRecipe(NamespacedKey.minecraft("parachute"));
        player.discoverRecipe(NamespacedKey.minecraft("portable_crafter"));
        player.discoverRecipe(NamespacedKey.minecraft("backpack1"));
        player.discoverRecipe(NamespacedKey.minecraft("backpack2"));
        player.discoverRecipe(NamespacedKey.minecraft("backpack3"));

        player.discoverRecipe(NamespacedKey.minecraft("gems_bag"));

        player.discoverRecipe(NamespacedKey.minecraft("mining_tear"));
        player.discoverRecipe(NamespacedKey.minecraft("sun_comet"));
        player.discoverRecipe(NamespacedKey.minecraft("spartan_shield"));
        player.discoverRecipe(NamespacedKey.minecraft("luffy_strawhat"));
        player.discoverRecipe(NamespacedKey.minecraft("atlantide_gem"));
        player.discoverRecipe(NamespacedKey.minecraft("the_mask"));
        player.discoverRecipe(NamespacedKey.minecraft("pegasus_feather"));

        player.discoverRecipe(NamespacedKey.minecraft("candy"));
        player.discoverRecipe(NamespacedKey.minecraft("xmashat"));

    }




}
