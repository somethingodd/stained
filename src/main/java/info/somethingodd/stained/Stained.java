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

import info.somethingodd.stained.block.StainedBrick;
import info.somethingodd.stained.block.StainedCobblestone;
import info.somethingodd.stained.block.StainedGlass;
import info.somethingodd.stained.block.StainedGlowstone;
import info.somethingodd.stained.block.StainedObsidian;
import info.somethingodd.stained.block.StainedStone;
import info.somethingodd.stained.block.StainedStoneBricks;
import info.somethingodd.stained.block.StainedWood;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.inventory.SpoutShapelessRecipe;
import org.getspout.spoutapi.material.Block;
import org.getspout.spoutapi.material.CustomBlock;
import org.getspout.spoutapi.material.Item;
import org.getspout.spoutapi.material.MaterialData;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class Stained extends JavaPlugin {

    @Override
    public void onEnable() {
        setup();
    }

    @Override
    public void onDisable() {
    }

    public void makeRecipes(CustomBlock block, Block source, Item ink) {
        SpoutShapelessRecipe recipe = new SpoutShapelessRecipe(new SpoutItemStack(block, 2));
        recipe.addIngredient(2, source);
        recipe.addIngredient(1, ink);
        SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
        SpoutShapelessRecipe unrecipe = new SpoutShapelessRecipe(new SpoutItemStack(source, 2));
        unrecipe.addIngredient(2, block);
        unrecipe.addIngredient(1, MaterialData.waterBucket);
        SpoutManager.getMaterialManager().registerSpoutRecipe(unrecipe);
    }

    public void setup() {
        Textures.setPlugin(this);
        String[] colors = new String[]{"Black", "Blue", "Brown", "Cyan", "Gray", "Green", "Lightblue",
                "Lightgray", "Lime", "Magenta", "Orange", "Pink", "Purple", "Red", "White", "Yellow"};
        for (String color : colors) {
            StainedBrick stainedBrick = new StainedBrick(this, color + " Brick", Textures.get("brick-" + color.toLowerCase()), 16);
            makeRecipes(stainedBrick, MaterialData.brick, inkFromColor(color));

            StainedCobblestone stainedCobblestone = new StainedCobblestone(this, color + " Cobblestone", Textures.get("cobblestone-" + color.toLowerCase()), 16);
            makeRecipes(stainedCobblestone, MaterialData.cobblestone, inkFromColor(color));

            StainedGlass stainedGlass = new StainedGlass(this, color + " Glass", Textures.get("glass-" + color.toLowerCase()), 16);
            makeRecipes(stainedGlass, MaterialData.glass, inkFromColor(color));

            StainedGlowstone stainedGlowstone = new StainedGlowstone(this, color + " Glowstone", Textures.get("glowstone-" + color.toLowerCase()), 16);
            makeRecipes(stainedGlowstone, MaterialData.glowstoneBlock, inkFromColor(color));

            StainedObsidian stainedObsidian = new StainedObsidian(this, color + " Obsidian", Textures.get("obsidian-" + color.toLowerCase()), 16);
            makeRecipes(stainedObsidian, MaterialData.obsidian, inkFromColor(color));

            StainedStone stainedStone = new StainedStone(this, color + " Stone", Textures.get("stone-" + color.toLowerCase()), 16);
            makeRecipes(stainedStone, MaterialData.stone, inkFromColor(color));

            StainedStoneBricks stainedStoneBricks = new StainedStoneBricks(this, color + " StoneBricks", Textures.get("stonebrick-" + color.toLowerCase()), 16);
            makeRecipes(stainedStoneBricks, MaterialData.stoneBricks, inkFromColor(color));

            StainedWood stainedWood = new StainedWood(this, color + " Wood", Textures.get("wood-" + color.toLowerCase()), 16);
            makeRecipes(stainedWood, MaterialData.wood, inkFromColor(color));
        }
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