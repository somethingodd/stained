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
package info.somethingodd.stained.glowstone;

import info.somethingodd.stained.Textures;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class GreenGlowstone extends GenericCubeCustomBlock {
    @Override
    public int getBlockId() {
        return 89;
    }

    public GreenGlowstone(Plugin plugin) {
        super(plugin, "Green" + " Glowstone", new GenericCubeBlockDesign(plugin, Textures.get("glowstone-" + "green"), 16));
    }
}
