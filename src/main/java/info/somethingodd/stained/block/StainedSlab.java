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

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.BlockDesign;
import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.GenericCuboidBlockDesign;
import org.getspout.spoutapi.material.MaterialData;
import org.getspout.spoutapi.material.block.GenericBlock;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;
import org.getspout.spoutapi.material.block.GenericCuboidCustomBlock;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class StainedSlab extends GenericCuboidCustomBlock {
    @Override
    public int getBlockId() {
        return MaterialData.stoneSlab.getRawId();
    }

    public StainedSlab(Plugin plugin, String name, String texture, int textureSize) {
        super(plugin, name, new GenericCuboidBlockDesign(plugin, texture, textureSize, 0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F));
        setFriction(MaterialData.brick.getFriction());
        setHardness(MaterialData.brick.getHardness());
        setLightLevel(MaterialData.brick.getLightLevel());
        setOpaque(MaterialData.glass.isOpaque());
        setStepSound(MaterialData.brick.getStepSound());
    }
}
