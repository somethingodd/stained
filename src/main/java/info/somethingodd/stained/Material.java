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

import info.somethingodd.stained.block.StainedBlock;
import info.somethingodd.stained.block.design.StairsDesign;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.GenericCuboidBlockDesign;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.material.Block;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;
import org.getspout.spoutapi.material.block.GenericCuboidCustomBlock;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class Material implements Cloneable {
    private Plugin plugin;
    private String name;
    private String fileName;
    private Block sourceBlock;
    private MaterialType materialType;
    private Texture texture;
    private Block block;
    private Color color;

    public Material(Plugin plugin, String name, String fileName, Color color, Block sourceBlock) {
        this(plugin, name, fileName, color, sourceBlock, MaterialType.BLOCK);
    }

    public Material(Plugin plugin, String name, String fileName, Color color, Block sourceBlock, MaterialType materialType) {
        this.plugin = plugin;
        this.name = name;
        this.fileName = fileName;
        this.color = color;
        this.sourceBlock = sourceBlock;
        this.materialType = materialType;
        switch (materialType) {
            case BLOCK:
                texture = new Texture(getPlugin(), getFileName() + "-" + getColor().getFileName(), 16, 16, 16);
                block = new StainedBlock(plugin, name, getFileName() + "-" + getColor().getFileName(), 16, sourceBlock);
                break;
            case SLAB:
                texture = new Texture(getPlugin(), getFileName() + "-" + getColor().getFileName(), 32, 16, 16);
                GenericCuboidBlockDesign bottom = new GenericCuboidBlockDesign(plugin, texture, new int[]{1, 0, 0, 0, 0, 1}, 0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
                GenericCuboidBlockDesign top = new GenericCuboidBlockDesign(plugin, texture, new int[]{1, 0, 0, 0, 0, 1}, 0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
                block = new GenericCustomBlock(plugin, name, sourceBlock.isOpaque(), top);
                block = new GenericCustomBlock(plugin, name, sourceBlock.isOpaque(), bottom);
                break;
            case STAIRS:
                texture = new Texture(getPlugin(), getFileName() + "-" + getColor().getFileName(), 16, 16, 16);
                block = new GenericCustomBlock(plugin, name, sourceBlock.isOpaque(), new StairsDesign(texture));
                break;
        }
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public String getName() {
        return name;
    }

    public String getFileName() {
        return fileName;
    }

    public Block getSourceBlock() {
        return sourceBlock;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public Color getColor() {
        return color;
    }

    public Block getBlock() {
        return block;
    }

    public Texture getTexture() {
        return texture;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + fileName.hashCode() + sourceBlock.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Material)) return false;
        if (!getName().equals(((Material) obj).getName())) return false;
        if (!getFileName().equals(((Material) obj).getFileName())) return false;
        if (!getSourceBlock().equals(((Material) obj).getSourceBlock())) return false;
        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Material(getPlugin(), getName(), getFileName(), getColor(), getSourceBlock(), getMaterialType());
    }

    public enum MaterialType {
        BLOCK,
        SLAB,
        STAIRS
    }
}
