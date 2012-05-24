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
package info.somethingodd.stained.block.design;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.GenericCuboidBlockDesign;
import org.getspout.spoutapi.block.design.Texture;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class SlabDesign extends GenericCuboidBlockDesign {
    public SlabDesign(Plugin plugin, Texture texture) {
        this(plugin, texture, new int[]{0, 0, 0, 0, 0, 0});
    }

    public SlabDesign(Plugin plugin, Texture texture, int[] textureId) {
        super(plugin, texture, textureId, 0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
    }
}