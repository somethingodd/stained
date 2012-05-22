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
            StainedBrick stainedBrick = new StainedBrick(this, colors[i] + " Brick", Textures.get("brick-" + colors[i].toLowerCase()), 16);
            stainedBrick.setBlockDesign(new GenericCubeBlockDesign(this, Textures.get("brick-" + colors[i].toLowerCase()), 16), i);
            SpoutShapelessRecipe stainedBrickRecipe = new SpoutShapelessRecipe(new SpoutItemStack(stainedBrick, 2));
            stainedBrickRecipe.addIngredient(2, MaterialData.brick);
            stainedBrickRecipe.addIngredient(inkFromColor(colors[i]));
            SpoutManager.getMaterialManager().registerSpoutRecipe(stainedBrickRecipe);
            SpoutShapelessRecipe brickRecipe = new SpoutShapelessRecipe(new SpoutItemStack(MaterialData.brick, 2));
            brickRecipe.addIngredient(2, stainedBrick);
            brickRecipe.addIngredient(1, MaterialData.waterBucket);
            SpoutManager.getMaterialManager().registerSpoutRecipe(brickRecipe);

            StainedCobblestone stainedCobblestone = new StainedCobblestone(this, colors[i] + " Cobblestone", Textures.get("cobblestone-" + colors[i].toLowerCase()), 16);
            stainedCobblestone.setBlockDesign(new GenericCubeBlockDesign(this, Textures.get("cobblestone-" + colors[i].toLowerCase()), 16), i);
            SpoutShapelessRecipe stainedCobblestoneRecipe = new SpoutShapelessRecipe(new SpoutItemStack(stainedCobblestone, 2));
            stainedCobblestoneRecipe.addIngredient(2, MaterialData.cobblestone);
            stainedCobblestoneRecipe.addIngredient(inkFromColor(colors[i]));
            SpoutManager.getMaterialManager().registerSpoutRecipe(stainedCobblestoneRecipe);
            SpoutShapelessRecipe cobblestoneRecipe = new SpoutShapelessRecipe(new SpoutItemStack(MaterialData.cobblestone, 2));
            cobblestoneRecipe.addIngredient(2, stainedCobblestone);
            cobblestoneRecipe.addIngredient(1, MaterialData.waterBucket);
            SpoutManager.getMaterialManager().registerSpoutRecipe(cobblestoneRecipe);

            StainedGlass stainedGlass = new StainedGlass(this, colors[i] + " Glass", Textures.get("glass-" + colors[i].toLowerCase()), 16);
            stainedGlass.setBlockDesign(new GenericCubeBlockDesign(this, Textures.get("glass-" + colors[i].toLowerCase()), 16), i);
            SpoutShapelessRecipe stainedGlassRecipe = new SpoutShapelessRecipe(new SpoutItemStack(stainedGlass, 2));
            stainedGlassRecipe.addIngredient(2, MaterialData.glass);
            stainedGlassRecipe.addIngredient(inkFromColor(colors[i]));
            SpoutManager.getMaterialManager().registerSpoutRecipe(stainedGlassRecipe);
            SpoutShapelessRecipe glassRecipe = new SpoutShapelessRecipe(new SpoutItemStack(MaterialData.glass, 2));
            glassRecipe.addIngredient(2, stainedGlass);
            glassRecipe.addIngredient(1, MaterialData.waterBucket);
            SpoutManager.getMaterialManager().registerSpoutRecipe(glassRecipe);

            StainedGlowstone stainedGlowstone = new StainedGlowstone(this, colors[i] + " Glowstone", Textures.get("glowstone-" + colors[i].toLowerCase()), 16);
            stainedGlowstone.setBlockDesign(new GenericCubeBlockDesign(this, Textures.get("glowstone-" + colors[i].toLowerCase()), 16), i);
            SpoutShapelessRecipe stainedGlowstoneRecipe = new SpoutShapelessRecipe(new SpoutItemStack(stainedGlowstone, 2));
            stainedGlowstoneRecipe.addIngredient(2, MaterialData.glowstoneBlock);
            stainedGlowstoneRecipe.addIngredient(inkFromColor(colors[i]));
            SpoutManager.getMaterialManager().registerSpoutRecipe(stainedGlowstoneRecipe);
            SpoutShapelessRecipe glowstoneRecipe = new SpoutShapelessRecipe(new SpoutItemStack(MaterialData.glowstoneBlock, 2));
            glowstoneRecipe.addIngredient(2, stainedGlowstone);
            glowstoneRecipe.addIngredient(1, MaterialData.waterBucket);
            SpoutManager.getMaterialManager().registerSpoutRecipe(glowstoneRecipe);
            
            StainedObsidian stainedObsidian = new StainedObsidian(this, colors[i] + " Obsidian", Textures.get("obsidian-" + colors[i].toLowerCase()), 16);
            stainedObsidian.setBlockDesign(new GenericCubeBlockDesign(this, Textures.get("obsidian-" + colors[i].toLowerCase()), 16), i);
            SpoutShapelessRecipe stainedObsidianRecipe = new SpoutShapelessRecipe(new SpoutItemStack(stainedObsidian, 2));
            stainedObsidianRecipe.addIngredient(2, MaterialData.obsidian);
            stainedObsidianRecipe.addIngredient(inkFromColor(colors[i]));
            SpoutManager.getMaterialManager().registerSpoutRecipe(stainedObsidianRecipe);
            SpoutShapelessRecipe obsidianRecipe = new SpoutShapelessRecipe(new SpoutItemStack(MaterialData.obsidian, 2));
            obsidianRecipe.addIngredient(2, stainedObsidian);
            obsidianRecipe.addIngredient(1, MaterialData.waterBucket);
            SpoutManager.getMaterialManager().registerSpoutRecipe(obsidianRecipe);

            StainedStone stainedStone = new StainedStone(this, colors[i] + " Stone", Textures.get("stone-" + colors[i].toLowerCase()), 16);
            stainedStone.setBlockDesign(new GenericCubeBlockDesign(this, Textures.get("stone-" + colors[i].toLowerCase()), 16), i);
            SpoutShapelessRecipe stainedStoneRecipe = new SpoutShapelessRecipe(new SpoutItemStack(stainedStone, 2));
            stainedStoneRecipe.addIngredient(2, MaterialData.stone);
            stainedStoneRecipe.addIngredient(inkFromColor(colors[i]));
            SpoutManager.getMaterialManager().registerSpoutRecipe(stainedStoneRecipe);
            SpoutShapelessRecipe stoneRecipe = new SpoutShapelessRecipe(new SpoutItemStack(MaterialData.stone, 2));
            stoneRecipe.addIngredient(2, stainedStone);
            stoneRecipe.addIngredient(1, MaterialData.waterBucket);
            SpoutManager.getMaterialManager().registerSpoutRecipe(stoneRecipe);

            StainedStoneBricks stainedStoneBricks = new StainedStoneBricks(this, colors[i] + " StoneBricks", Textures.get("stonebrick-" + colors[i].toLowerCase()), 16);
            stainedStoneBricks.setBlockDesign(new GenericCubeBlockDesign(this, Textures.get("stonebrick-" + colors[i].toLowerCase()), 16), i);
            SpoutShapelessRecipe stainedStoneBricksRecipe = new SpoutShapelessRecipe(new SpoutItemStack(stainedStoneBricks, 2));
            stainedStoneBricksRecipe.addIngredient(2, MaterialData.stoneBricks);
            stainedStoneBricksRecipe.addIngredient(inkFromColor(colors[i]));
            SpoutManager.getMaterialManager().registerSpoutRecipe(stainedStoneBricksRecipe);
            SpoutShapelessRecipe stoneBricksRecipe = new SpoutShapelessRecipe(new SpoutItemStack(MaterialData.stoneBricks, 2));
            stoneBricksRecipe.addIngredient(2, stainedStoneBricks);
            stoneBricksRecipe.addIngredient(1, MaterialData.waterBucket);
            SpoutManager.getMaterialManager().registerSpoutRecipe(stoneBricksRecipe);

            StainedWood stainedWood = new StainedWood(this, colors[i] + " Wood", Textures.get("wood-" + colors[i].toLowerCase()), 16);
            stainedWood.setBlockDesign(new GenericCubeBlockDesign(this, Textures.get("wood-" + colors[i].toLowerCase()), 16), i);
            SpoutShapelessRecipe stainedWoodRecipe = new SpoutShapelessRecipe(new SpoutItemStack(stainedWood, 2));
            stainedWoodRecipe.addIngredient(2, MaterialData.wood);
            stainedWoodRecipe.addIngredient(inkFromColor(colors[i]));
            SpoutManager.getMaterialManager().registerSpoutRecipe(stainedWoodRecipe);
            SpoutShapelessRecipe woodRecipe = new SpoutShapelessRecipe(new SpoutItemStack(MaterialData.wood, 2));
            woodRecipe.addIngredient(2, stainedWood);
            woodRecipe.addIngredient(1, MaterialData.waterBucket);
            SpoutManager.getMaterialManager().registerSpoutRecipe(woodRecipe);
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