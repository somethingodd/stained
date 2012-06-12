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

import info.somethingodd.stained.block.design.SlabDesign;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.SpoutWorld;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.block.design.GenericCuboidBlockDesign;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.Block;
import org.getspout.spoutapi.material.CustomBlock;
import org.getspout.spoutapi.material.block.GenericCuboidCustomBlock;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class SlabBlock extends GenericCustomBlock {
    private Block source;

    private Block full;
    private Block top;

    @Override
    public int getBlockId() {
        return source.getRawId();
    }

    public SlabBlock(Plugin plugin, String name, Texture texture, int[] textureIdBottom, int[] textureIdDouble, int[] textureIdTop, Block source) {
        super(plugin, name, true, new SlabDesign(plugin, texture, textureIdBottom, SlabDesign.Slab.BOTTOM));
        full = new GenericCustomBlock(plugin, name, true, new SlabDesign(plugin, texture, textureIdDouble, SlabDesign.Slab.DOUBLE));
        top = new GenericCustomBlock(plugin, name, true, new SlabDesign(plugin, texture, textureIdTop, SlabDesign.Slab.TOP));

        this.source = source;
        setFriction(source.getFriction());
        setHardness(source.getHardness());
        setOpaque(source.isOpaque());
        setStepSound(source.getStepSound());

        full.setFriction(source.getFriction());
        full.setHardness(source.getHardness());
        full.setOpaque(source.isOpaque());
        full.setStepSound(source.getStepSound());
        ((CustomBlock) full).setItemDrop(new SpoutItemStack(this, 2));

        top.setFriction(source.getFriction());
        top.setHardness(source.getHardness());
        top.setOpaque(source.isOpaque());
        top.setStepSound(source.getStepSound());
        ((CustomBlock) top).setItemDrop(new SpoutItemStack(this, 1));
    }

    public Block getFull() {
        return full;
    }

    public Block getTop() {
        return top;
    }
}
