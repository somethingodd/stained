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

import info.somethingodd.stained.block.design.CubeDesign;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.BlockDesign;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.Block;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class CubeBlock extends GenericCustomBlock {
    private Block source;

    @Override
    public int getBlockId() {
        return source.getRawId();
    }

    public CubeBlock(Plugin plugin, String name, Texture texture, int[] textureId, Block source) {
        this(plugin, name, true, texture, textureId, source);
    }

    public CubeBlock(Plugin plugin, String name, boolean isOpaque, Texture texture, int[] textureId, Block source) {
        this(plugin, name, isOpaque, texture, textureId, source, new GenericCubeBlockDesign(plugin, texture, textureId));
    }

    public CubeBlock(Plugin plugin, String name, boolean isOpaque, Texture texture, int[] textureId, Block source, BlockDesign blockDesign) {
        super(plugin, name, isOpaque, blockDesign);
        this.source = source;
        setFriction(source.getFriction());
        setHardness(source.getHardness());
        setLightLevel(source.getLightLevel());
        setOpaque(source.isOpaque());
        setStepSound(source.getStepSound());
    }

    public void setSource(Block source) {
        this.source = source;
    }


}
