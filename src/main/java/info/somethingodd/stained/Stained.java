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

import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.inventory.SpoutShapelessRecipe;
import org.getspout.spoutapi.material.Block;
import org.getspout.spoutapi.material.Item;
import org.getspout.spoutapi.material.MaterialData;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class Stained extends JavaPlugin {
    private final Map<String, Block> blocks = new HashMap<String, Block>();
    private final Set<Color> colors = new HashSet<Color>();
    private final Map<String, Block> slabs = new HashMap<String, Block>();
    private final Map<String, Block> stairs = new HashMap<String, Block>();
    private final Map<String, String> textures = new HashMap<String, String>();
    private final Map<String, Material> materials = new HashMap<String, Material>();

    @Override
    public void onEnable() {
        setup();
    }

    @Override
    public void onDisable() {
    }

    public Map<String, Block> getBlocks() {
        return Collections.unmodifiableMap(blocks);
    }

    public Set<Color> getColors() {
        return Collections.unmodifiableSet(colors);
    }

    public Map<String, Material> getMaterials() {
        return Collections.unmodifiableMap(materials);
    }

    public Map<String, Block> getSlabs() {
        return Collections.unmodifiableMap(slabs);
    }

    public Map<String, Block> getStairs() {
        return Collections.unmodifiableMap(stairs);
    }

    public Map<String, String> getTextures() {
        return Collections.unmodifiableMap(textures);
    }

    protected String getTextureURL(String key) {
        return "http://somethingodd.info/textures/" + key + ".png";
    }

    protected Texture getTexture(String key) {
        return new Texture(this, "http://somethingodd.info/textures/" + key + ".png", 16, 16, 16);
    }

    public void makeRecipes(Block block, Block source, Item ink) {
        SpoutShapedRecipe recipe = new SpoutShapedRecipe(new SpoutItemStack(block, 2));
        recipe.shape("ABA");
        recipe.setIngredient('A', source);
        recipe.setIngredient('B', ink);
        SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
        SpoutShapelessRecipe unrecipe = new SpoutShapelessRecipe(new SpoutItemStack(source, 1));
        unrecipe.addIngredient(1, block);
        unrecipe.addIngredient(1, MaterialData.waterBucket);
        SpoutManager.getMaterialManager().registerSpoutRecipe(unrecipe);
    }

    public void setup() {
        // Inks
        colors.add(new Color("Black", "black", MaterialData.inkSac));
        colors.add(new Color("Blue", "blue", MaterialData.lapisLazuli));
        colors.add(new Color("Brown", "brown", MaterialData.cocoaBeans));
        colors.add(new Color("Cyan", "cyan", MaterialData.cyanDye));
        colors.add(new Color("Gray", "gray", MaterialData.grayDye));
        colors.add(new Color("Green", "green", MaterialData.cactusGreen));
        colors.add(new Color("Light Blue", "lightblue", MaterialData.lightBlueDye));
        colors.add(new Color("Light Gray", "lightgray", MaterialData.lightGrayDye));
        colors.add(new Color("Lime", "lime", MaterialData.limeDye));
        colors.add(new Color("Magenta", "magenta", MaterialData.magentaDye));
        colors.add(new Color("Orange", "orange", MaterialData.orangeDye));
        colors.add(new Color("Pink", "pink", MaterialData.pinkDye));
        colors.add(new Color("Purple", "purple", MaterialData.purpleDye));
        colors.add(new Color("Red", "red", MaterialData.roseRed));
        colors.add(new Color("White", "white", MaterialData.boneMeal));
        colors.add(new Color("Yellow", "yellow", MaterialData.dandelionYellow));

        // Blocks
        blocks.put("Brick", MaterialData.brick);
        blocks.put("Cobblestone", MaterialData.cobblestone);
        blocks.put("Glass", MaterialData.glass);
        blocks.put("Glowstone", MaterialData.glowstoneBlock);
        blocks.put("Obsidian", MaterialData.obsidian);
        blocks.put("Stone", MaterialData.stone);
        blocks.put("Stone Brick", MaterialData.stoneBricks);
        blocks.put("Wood", MaterialData.wood);

        slabs.put("Cobblestone Slab", MaterialData.cobblestoneSlab);
        slabs.put("Stone Brick Slab", MaterialData.stoneBrickSlab);
        slabs.put("Stone Slab", MaterialData.stoneSlab);
        slabs.put("Wooden Slab", MaterialData.woodenSlab);

        stairs.put("Cobblestone Stairs", MaterialData.cobblestoneStairs);
        stairs.put("Stone Brick Stairs", MaterialData.stoneBrickStairs);
        stairs.put("Wooden Stairs", MaterialData.woodenStairs);

        // Textures - Blocks
        textures.put("Brick", "brick");
        textures.put("Cobblestone", "cobblestone");
        textures.put("Cooblestone Slab", "cobblestone");
        textures.put("Cooblestone Stairs", "cobblestone");
        textures.put("Glass", "glass");
        textures.put("Glowstone", "glowstone");
        textures.put("Obsidian", "obsidian");
        textures.put("Stone", "stone");
        textures.put("Stone Brick", "stonebrick");
        textures.put("Stone Brick Slab", "stonebrick");
        textures.put("Stone Brick Stairs", "stonebrick");
        textures.put("Stone Slab", "stone");
        textures.put("Stone Stairs", "stone");
        textures.put("Wood", "wood");
        textures.put("Wooden Slab", "wood");
        textures.put("Wooden Stairs", "wood");
        
        for (Color color : colors) {
            for (String name : blocks.keySet()) {
                String fullName = color.getName() + " " + name;
                getLogger().info("Adding " + fullName);
                materials.put(fullName, new Material(this, fullName, getTextureURL(textures.get(name) + "-" + color.getFileName()), color, blocks.get(name)));
            }
            for (String name : slabs.keySet()) {
                String fullName = color.getName() + " " + name;
                getLogger().info("Adding " + color.getName() + " " + name);
                materials.put(fullName, new Material(this, fullName, getTextureURL(textures.get(name) + "-" + color.getFileName()), color, slabs.get(name), Material.MaterialType.SLAB));
            }
            for (String name : stairs.keySet()) {
                String fullName = color.getName() + " " + name;
                //getLogger().info("Adding " + fullName);
                //materials.put(fullName, new Material(this, fullName, getTextureURL(textures.get(name) + "-" + color.getFileName()), color, stairs.get(name), Material.MaterialType.STAIRS));
            }
        }
        for (Material material : materials.values()) {
            makeRecipes(material.getBlock(), material.getSourceBlock(), material.getColor().getItem());
        }
    }
}