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
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.inventory.SpoutShapelessRecipe;
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

    public void setup() {
        Textures.setPlugin(this);
        String[] colors = new String[]{"Black", "Blue", "Brown", "Cyan", "Gray", "Green", "Lightblue",
                "Lightgray", "Lime", "Magenta", "Orange", "Pink", "Purple", "Red", "White", "Yellow"};
        for (int i = 0; i < colors.length; i++) {
            String name = colors[i] + " Glowstone";
            StainedBrick stainedBrick = new StainedBrick(this, colors[i] + " Brick", Textures.get("brick-" + colors[i].toLowerCase()), i) ;
            makeRecipes(stainedBrick, inkFromColor(colors[i]));
            StainedCobblestone stainedCobblestone = new StainedCobblestone(this, colors[i] + " Cobblestone", Textures.get("cobblestone-" + colors[i].toLowerCase()), i);
            makeRecipes(stainedCobblestone, inkFromColor(colors[i]));
            StainedGlass stainedGlass = new StainedGlass(this, colors[i] + " Glass", Textures.get("glass-" + colors[i].toLowerCase()), i);
            makeRecipes(stainedGlass, inkFromColor(colors[i]));
            StainedGlowstone stainedGlowstone = new StainedGlowstone(this, colors[i] + " Glowstone", Textures.get("glowstone-" + colors[i].toLowerCase()), i);
            makeRecipes(stainedGlowstone, inkFromColor(colors[i]));
            StainedObsidian stainedObsidian = new StainedObsidian(this, colors[i] + " Obsidian", Textures.get("obsidian-" + colors[i].toLowerCase()), i);
            makeRecipes(stainedObsidian, inkFromColor(colors[i]));
            StainedStone stainedStone = new StainedStone(this, colors[i] + " Stone", Textures.get("stone-" + colors[i].toLowerCase()), i);
            makeRecipes(stainedStone, inkFromColor(colors[i]));
            StainedStoneBricks stainedStoneBricks = new StainedStoneBricks(this, colors[i] + " StoneBricks", Textures.get("stonebrick-" + colors[i].toLowerCase()), i);
            makeRecipes(stainedStoneBricks, inkFromColor(colors[i]));
            StainedWood stainedWood = new StainedWood(this, colors[i] + " Wood", Textures.get("wood-" + colors[i].toLowerCase()), i);
            makeRecipes(stainedWood, inkFromColor(colors[i]));
        }
    }

    private void makeRecipes(CustomBlock block, Item dye) {
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