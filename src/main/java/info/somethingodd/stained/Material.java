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

import info.somethingodd.stained.block.CubeBlock;
import info.somethingodd.stained.block.SlabBlock;
import info.somethingodd.stained.block.StairsBlock;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.material.Block;

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
        try {
            this.plugin = plugin;
            this.name = name;
            this.fileName = fileName;
            this.color = color;
            this.sourceBlock = sourceBlock;
            this.materialType = materialType;
            texture = new Texture(plugin, fileName, 16, 16, 16);
            switch (materialType) {
                case BLOCK:
                    block = new CubeBlock(plugin, name, texture, sourceBlock);
                    break;
                case SLAB:
                    block = new SlabBlock(plugin, name, texture, sourceBlock);
                    break;
                case STAIRS:
                    block = new StairsBlock(plugin, name, texture, sourceBlock);
                    break;
            }
        } catch (Exception e) {
            plugin.getLogger().severe("Failure: " + this.toString());
            throw new ExceptionInInitializerError(e);
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
    public String toString() {
        StringBuilder sb = new StringBuilder("Material{");
        sb.append("name: \"").append(name).append("\", ");
        sb.append("fileName: \"").append(fileName).append("\", ");
        sb.append("color: ").append(color.toString()).append(", ");
        sb.append("sourceBlock: ").append(sourceBlock.toString()).append(", ");
        sb.append("materialType: ").append(materialType.toString()).append("}");
        return sb.toString();
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
        STAIRS;

        @Override
        public String toString() {
            return "MaterialType{" + this.name() + "}";
        }
    }
}
