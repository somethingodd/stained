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
package info.somethingodd.stained.block;

import info.somethingodd.stained.Color;
import info.somethingodd.stained.Stained;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.Block;

import java.util.Random;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class ObsidianBlock extends CubeBlock {
    private Plugin plugin;
    private Color color;

    public ObsidianBlock(Plugin plugin, String name, Texture texture, int[] textureId, Block source, Color color) {
        super(plugin, name, texture, textureId, source);
        setItemDrop(null);
        this.plugin = plugin;
        this.color = color;
        setItemDrop(null);
    }

    @Override
    public void onBlockDestroyed(World world, int x, int y, int z, LivingEntity living) {
        super.onBlockDestroyed(world, x, y, z, living);
        Player player = SpoutManager.getPlayerFromId(living.getEntityId());
        if (player != null) {
            ItemStack inHand = player.getItemInHand();
            if (inHand.getType().equals(Material.DIAMOND_PICKAXE)) {
                world.dropItemNaturally(new Location(world, (double) x, (double) y, (double) z), new SpoutItemStack(((Stained) plugin).getMaterials().get("Obsidian").getBlock(color), 1));
            }
        }
    }
}
