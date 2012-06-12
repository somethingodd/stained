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

import info.somethingodd.stained.block.design.GlassDesign;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.material.Block;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class GlassBlock extends CubeBlock {

    public GlassBlock(Plugin plugin, String name, Texture texture, int[] textureId, Block source) {
        super(plugin, name, false, texture, textureId, source, new GlassDesign(plugin, texture, textureId));
    }

}
