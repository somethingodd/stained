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
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.Block;

import java.util.Random;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class GlowstoneBlock extends CubeBlock {
    private Plugin plugin;
    private Color color;

    public GlowstoneBlock(Plugin plugin, String name, Texture texture, int[] textureId, Block source, Color color) {
        super(plugin, name, texture, textureId, source);
        this.plugin = plugin;
        this.color = color;
        setItemDrop(new SpoutItemStack(((Stained) plugin).getItems().get("Glowstone Dust").getItem(color), 4));
    }
}
