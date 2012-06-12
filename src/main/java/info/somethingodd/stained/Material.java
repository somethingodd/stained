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

import info.somethingodd.stained.block.*;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.material.Block;
import org.getspout.spoutapi.material.CustomBlock;
import org.getspout.spoutapi.material.MaterialData;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class Material {
    private Plugin plugin;
    private String name;
    private Block source;
    private TextureCoordinates.TextureCoordinate textureCoordinate;
    private BlockType blockType;
    private final Map<Color, CustomBlock> blocks = new HashMap<Color, CustomBlock>();
    private static Texture texture;

    /**
     * @param plugin Plugin owning block
     * @param name Base name of new block
     * @param source Base block for non-spout clients
     */
    public Material(Plugin plugin, String name, Block source) {
        this(plugin, name, source, BlockType.CUBE);
    }

    /**
     * @param plugin Plugin owning block
     * @param name Base name of new block
     * @param source Base block for non-spout clients
     * @param blockType Type of block
     */
    public Material(Plugin plugin, String name, Block source, BlockType blockType) {
        this.plugin = plugin;
        this.name = name;
        this.source = source;
        this.blockType = blockType;
        textureCoordinate = TextureCoordinates.getTextureCoordinate(source);
    }

    public static void setTexture(Texture texture) {
        Material.texture = texture;
    }

    public static Texture getTexture() {
        return texture;
    }


    public String getName() {
        return name;
    }

    public org.getspout.spoutapi.material.Material getSource() {
        return source;
    }

    public Map<Color, CustomBlock> getBlocks() {
        return Collections.unmodifiableMap(blocks);
    }

    public CustomBlock getBlock(Color color) {
        return blocks.get(color);
    }

    public CustomBlock makeBlock(Color color) {
        CustomBlock block;
        String name = color.getName() + " " + getName();
        plugin.getLogger().info("Adding " + name);
        int[] textureId = textureIdForColor(color, textureCoordinate.getTextureId());
        plugin.getLogger().info("tid: " + Arrays.toString(textureId));
        if (BlockType.GLASS.equals(blockType)) {
            block = new GlassBlock(plugin, name, texture, textureId, source);
        } else if (BlockType.GLOWSTONE.equals(blockType)) {
            block = new GlowstoneBlock(plugin, name, texture, textureId, source, color);
        } else if (BlockType.OBSIDIAN.equals(blockType)) {
            block = new ObsidianBlock(plugin, name, texture, textureId, source, color);
        } else if (BlockType.SLAB.equals(blockType)) {
            int[] textureIdLow = textureIdForColor(color, textureCoordinate.getTextureIdLow());
            int[] textureIdHigh = textureIdForColor(color, textureCoordinate.getTextureIdHigh());
            plugin.getLogger().info("tidL: " + Arrays.toString(textureIdLow));
            plugin.getLogger().info("tidH: " + Arrays.toString(textureIdHigh));
            block = new SlabBlock(plugin, name, texture, textureIdLow, textureId, textureIdHigh, source);
        } else if (BlockType.STONE.equals(blockType)) {
            block = new StoneBlock(plugin, name, texture, textureId, source, color);
        } else {
            block = new CubeBlock(plugin, name, texture, textureId, source);
        }
        blocks.put(color, block);
        return block;
    }

    public int[] textureIdForColor(Color color, int[] textureId) {
        int rowSize = getTexture().getWidth() / 16;
        int[] coloredTextureId = new int[textureId.length];
        for (int i = 0; i < textureId.length; i++) {
            coloredTextureId[i] = textureId[i] + (rowSize * color.getRow());
        }
        return coloredTextureId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Material{");
        sb.append("plugin: ").append(plugin.toString()).append(", ");
        sb.append("name: \"").append(name).append("\", ");
        sb.append("source: ").append(source.toString()).append(", ");
        sb.append("textureCoordinate: ").append(textureCoordinate.toString()).append(", ");
        sb.append("blockType: ").append(blockType.name()).append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return name.hashCode() + source.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Material)) return false;
        if (!getName().equals(((Material) obj).getName())) return false;
        return (getSource().equals(((Material) obj).getSource()));
    }

    public enum BlockType {
        CUBE,
        GLASS,
        GLOWSTONE,
        OBSIDIAN,
        STONE,
        SLAB
    }
}
