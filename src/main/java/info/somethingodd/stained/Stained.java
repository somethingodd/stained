/* This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package info.somethingodd.stained;

import info.somethingodd.stained.block.SlabBlock;
import info.somethingodd.stained.block.design.CubeDesign;
import info.somethingodd.stained.block.design.SlabDesign;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.design.GenericCuboidBlockDesign;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.inventory.SpoutShapelessRecipe;
import org.getspout.spoutapi.material.CustomBlock;
import org.getspout.spoutapi.material.CustomItem;
import org.getspout.spoutapi.material.MaterialData;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;
import org.getspout.spoutapi.material.block.GenericCuboidCustomBlock;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

import java.util.*;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class Stained extends JavaPlugin {
    private final Set<Color> colors = new HashSet<Color>();
    private final Map<String, Item> items = new HashMap<String, Item>();
    private final Map<String, Material> materials = new HashMap<String, Material>();

    @Override
    public void onEnable() {
        setup();
    }

    @Override
    public void onDisable() {
    }

    public Set<Color> getColors() {
        return Collections.unmodifiableSet(colors);
    }

    public Map<String, Item> getItems() {
        return Collections.unmodifiableMap(items);
    }

    public Map<String, Material> getMaterials() {
        return Collections.unmodifiableMap(materials);
    }

    public String getTexture(String name) {
        return "http://somethingodd.info/textures/" + name + ".png";
    }

    public void makeRecipes(org.getspout.spoutapi.material.Material result, org.getspout.spoutapi.material.Material source, org.getspout.spoutapi.material.Material ink) {
        SpoutShapedRecipe recipe = new SpoutShapedRecipe(new SpoutItemStack(result, 2));
        recipe.shape("ABA");
        recipe.setIngredient('A', source);
        recipe.setIngredient('B', ink);
        SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
        SpoutShapelessRecipe unrecipe = new SpoutShapelessRecipe(new SpoutItemStack(source, 1));
        unrecipe.addIngredient(result);
        unrecipe.addIngredient(MaterialData.waterBucket);
        SpoutManager.getMaterialManager().registerSpoutRecipe(unrecipe);
    }

    public void makeGlowstoneRecipes(org.getspout.spoutapi.material.Material result, org.getspout.spoutapi.material.Material source) {
        SpoutShapedRecipe recipe = new SpoutShapedRecipe(new SpoutItemStack(result, 1));
        recipe.shape("AA", "AA");
        recipe.setIngredient('A', source);
        SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
    }

    public void makeSlabRecipe(org.getspout.spoutapi.material.Material result, org.getspout.spoutapi.material.Material source) {
        SpoutShapedRecipe recipe = new SpoutShapedRecipe(new SpoutItemStack(result, 6));
        recipe.shape("AAA");
        recipe.setIngredient('A', source);
        SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
    }

    public void makeStairsRecipe(org.getspout.spoutapi.material.Material result, org.getspout.spoutapi.material.Material source) {
        SpoutShapedRecipe recipe = new SpoutShapedRecipe(new SpoutItemStack(result, 6));
        recipe.shape("AAA");
        recipe.setIngredient('A', source);
        SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
    }

    public void setup() {
        Material.setTexture(new Texture(this, "http://somethingodd.info/textures/stained.png", 512, 512, 16));

        colors.add(new Color("Black",  MaterialData.inkSac, 0));
        colors.add(new Color("Blue", MaterialData.lapisLazuli, 1));
        colors.add(new Color("Brown", MaterialData.cocoaBeans, 2));
        colors.add(new Color("Cyan", MaterialData.cyanDye, 3));
        colors.add(new Color("Gray", MaterialData.grayDye, 4));
        colors.add(new Color("Green", MaterialData.cactusGreen, 5));
        colors.add(new Color("Light Blue", MaterialData.lightBlueDye, 6));
        colors.add(new Color("Light Gray", MaterialData.lightGrayDye, 7));
        colors.add(new Color("Lime", MaterialData.limeDye, 8));
        colors.add(new Color("Magenta", MaterialData.magentaDye, 9));
        colors.add(new Color("Orange", MaterialData.orangeDye, 10));
        colors.add(new Color("Pink", MaterialData.pinkDye, 11));
        colors.add(new Color("Purple", MaterialData.purpleDye, 12));
        colors.add(new Color("Red", MaterialData.roseRed, 13));
        colors.add(new Color("White", MaterialData.boneMeal, 14));
        colors.add(new Color("Yellow", MaterialData.dandelionYellow, 15));

        /*colors.add(new Color("Black",  MaterialData.inkSac, 23));
        colors.add(new Color("Blue", MaterialData.lapisLazuli, 22));
        colors.add(new Color("Brown", MaterialData.cocoaBeans, 21));
        colors.add(new Color("Cyan", MaterialData.cyanDye, 20));
        colors.add(new Color("Gray", MaterialData.grayDye, 19));
        colors.add(new Color("Green", MaterialData.cactusGreen, 18));
        colors.add(new Color("Light Blue", MaterialData.lightBlueDye, 17));
        colors.add(new Color("Light Gray", MaterialData.lightGrayDye, 16));
        colors.add(new Color("Lime", MaterialData.limeDye, 15));
        colors.add(new Color("Magenta", MaterialData.magentaDye, 14));
        colors.add(new Color("Orange", MaterialData.orangeDye, 13));
        colors.add(new Color("Pink", MaterialData.pinkDye, 12));
        colors.add(new Color("Purple", MaterialData.purpleDye, 11));
        colors.add(new Color("Red", MaterialData.roseRed, 10));
        colors.add(new Color("White", MaterialData.boneMeal, 9));
        colors.add(new Color("Yellow", MaterialData.dandelionYellow, 8));*/

        items.put("Glowstone Dust", new Item(this, "Glowstone Dust", MaterialData.glowstoneDust));

        materials.put("Brick", new Material(this, "Brick", MaterialData.brick));
        materials.put("Brick Slab", new Material(this, "Brick Slab", MaterialData.brickSlab, Material.BlockType.SLAB));
        materials.put("Cobblestone", new Material(this, "Cobblestone", MaterialData.cobblestone));
        materials.put("Cobblestone Slab", new Material(this, "Cobblestone Slab", MaterialData.cobblestoneSlab, Material.BlockType.SLAB));
        materials.put("Glass", new Material(this, "Glass", MaterialData.glass, Material.BlockType.GLASS));
        materials.put("Glowstone", new Material(this, "Glowstone", MaterialData.glowstoneBlock, Material.BlockType.GLOWSTONE));
        materials.put("Obsidian", new Material(this, "Obsidian", MaterialData.obsidian));
        materials.put("Sandstone", new Material(this, "Sandstone", MaterialData.sandstone));
        materials.put("Sandstone Slab", new Material(this, "Sandstone Slab", MaterialData.sandstoneSlab, Material.BlockType.SLAB));
        materials.put("Stone", new Material(this, "Stone", MaterialData.stone, Material.BlockType.STONE));
        materials.put("Stone Slab", new Material(this, "Stone Slab", MaterialData.stoneSlab, Material.BlockType.SLAB));
        materials.put("Stone Brick", new Material(this, "Stone Brick", MaterialData.stoneBricks));
        materials.put("Stone Brick Slab", new Material(this, "Stone Brick Slab", MaterialData.stoneBrickSlab, Material.BlockType.SLAB));
        materials.put("Wood", new Material(this, "Wood", MaterialData.wood));
        materials.put("Wooden Slab", new Material(this, "Wooden Slab", MaterialData.woodenSlab, Material.BlockType.SLAB));

        for (Color color : colors) {
            for (Item item : items.values()) {
                //int id = SpoutManager.getMaterialManager().registerCustomItemName(this, color.getName() + " " + item.getName());
                CustomItem custom = item.makeItem(color);
                makeRecipes(custom, item.getSource(), color.getSource());
            }
            for (Material material : materials.values()) {
                //int id = SpoutManager.getMaterialManager().registerCustomItemName(this, color.getName() + " " + material.getName());
                CustomBlock custom = material.makeBlock(color);
                makeRecipes(custom, material.getSource(), color.getSource());
            }
            makeGlowstoneRecipes(materials.get("Glowstone").getBlock(color), items.get("Glowstone Dust").getItem(color));
        }
    }
}