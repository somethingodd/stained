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

import info.somethingodd.stained.cobblestone.BlackCobblestone;
import info.somethingodd.stained.cobblestone.BlueCobblestone;
import info.somethingodd.stained.cobblestone.BrownCobblestone;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.inventory.SpoutShapelessRecipe;
import org.getspout.spoutapi.material.Item;
import org.getspout.spoutapi.material.MaterialData;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class Stained extends JavaPlugin {
    /*public Cyan
    public Gray
    public Green
    public Lightblue
    public Lightgray
    public Lime
    public Magenta
    public Orange
    public Pink
    public Purple
    public Red
    public White
    public Yellow*/
    
    @Override
    public void onEnable() {
        setup();
    }

    @Override
    public void onDisable() {
    }

    public void setup() {
        String[] colors = new String[]{"Black", "Blue", "Brown", "Cyan", "Gray", "Green", "Lightblue",
                "Lightgray", "Lime", "Magenta", "Orange", "Pink", "Purple", "Red", "White", "Yellow"};
        String[] blocks = new String[]{"Cobblestone", "Glass", "Glowstone", "Obsidian", "Slab", "Stone", "Wood"};
        for (String color : colors) {
            for (String block : blocks) {
                Texture t = new Texture(this, Textures.get(block.toLowerCase() + "-" + color.toLowerCase()), 16, 16, 64);
                try {
                    Class c = Class.forName(color + block);
                    GenericCubeCustomBlock genericCubeCustomBlock = (GenericCubeCustomBlock) c.getConstructor(Plugin.class).newInstance(this);
                    makeRecipes(genericCubeCustomBlock, inkFromColor(color));
                } catch (Exception e) {
                    getLogger().warning("Couldn't do " + color + block);
                    e.printStackTrace();
                }
            }
        }
    }

    private void makeRecipes(GenericCubeCustomBlock block, Item dye) {
        SpoutShapedRecipe spoutShapedRecipe = new SpoutShapedRecipe(new SpoutItemStack(block, 2));
        spoutShapedRecipe.shape("ABA");
        spoutShapedRecipe.setIngredient('A', MaterialData.getBlock(block.getBlockId()));
        spoutShapedRecipe.setIngredient('B', dye);
        SpoutManager.getMaterialManager().registerSpoutRecipe(spoutShapedRecipe);
        SpoutShapelessRecipe spoutShapelessRecipe = new SpoutShapelessRecipe(new SpoutItemStack(block.getBlockId()));
        spoutShapelessRecipe.addIngredient(1, MaterialData.waterBucket);
        spoutShapelessRecipe.addIngredient(block);
        SpoutManager.getMaterialManager().registerSpoutRecipe(spoutShapelessRecipe);
    }

    public Item inkFromColor(String color) {
        if ("Blue".equals(color)) {
            return MaterialData.lapisLazuli;
        } else if ("Brown".equals(color)) {
            return MaterialData.cocoaBeans;
        } else if ("Cyan".equals(color)) {
            return MaterialData.cyanDye;
        } else if ("Gray".equals(color)) {
            return MaterialData.grayDye;
        } else if ("Green".equals(color)) {
            return MaterialData.cactusGreen;
        } else if ("Lightblue".equals(color)) {
            return MaterialData.lightBlueDye;
        } else if ("Lightgray".equals(color)) {
            return MaterialData.lightGrayDye;
        } else if ("Lime".equals(color)) {
            return MaterialData.limeDye;
        } else if ("Magenta".equals(color)) {
            return MaterialData.magentaDye;
        } else if ("Orange".equals(color)) {
            return MaterialData.orangeDye;
        } else if ("Pink".equals(color)) {
            return MaterialData.pinkDye;
        } else if ("Purple".equals(color)) {
            return MaterialData.purpleDye;
        } else if ("Red".equals(color)) {
            return MaterialData.roseRed;
        } else if ("White".equals(color)) {
            return MaterialData.boneMeal;
        } else if ("Yellow".equals(color)) {
            return MaterialData.dandelionYellow;
        }
        return MaterialData.inkSac;
    }
}