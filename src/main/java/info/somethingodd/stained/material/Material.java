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
package info.somethingodd.stained.material;

import info.somethingodd.stained.Color;
import info.somethingodd.stained.TextureCoordinates;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.GenericCuboidBlockDesign;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.material.Block;
import org.getspout.spoutapi.material.CustomBlock;
import org.getspout.spoutapi.material.block.GenericCuboidCustomBlock;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class Material {
    protected Plugin plugin;
    protected String name;
    protected Block source;
    protected TextureCoordinates.TextureCoordinate textureCoordinate;
    protected final Map<Color, CustomBlock> blocks = new HashMap<Color, CustomBlock>();
    protected static Texture texture;

    /**
     * @param plugin Plugin owning block
     * @param name Base name of new block
     * @param source Base block for non-spout clients
     */
    public Material(Plugin plugin, String name, Block source) {
        this.plugin = plugin;
        this.name = name;
        this.source = source;
        textureCoordinate = TextureCoordinates.getTextureCoordinate(source);
    }

    public static void setTexture(Texture texture) {
        Material.texture = texture;
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

    /**
     * Instantiates a colored block of this material and returns it
     * @param color Color for block
     * @return colored block
     */
    public CustomBlock makeBlock(Color color) {
        CustomBlock block;
        String name = color.getName() + " " + getName();
        block = new GenericCuboidCustomBlock(plugin, name, new GenericCuboidBlockDesign(plugin, texture, textureIdForColor(color, textureCoordinate.getTextureId()), 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F));
        blocks.put(color, block);
        return block;
    }

    public int[] textureIdForColor(Color color, int[] textureId) {
        int rowSize = texture.getWidth() / texture.getSpriteSize();
        plugin.getLogger().info("Texture size: " + texture.getWidth() + "x" + texture.getHeight() + "-" + texture.getSpriteSize());
        int[] coloredTextureId = new int[textureId.length];
        for (int i = 0; i < textureId.length; i++) {
            coloredTextureId[i] = textureId[i] + (rowSize * color.getRow());
        }
        return coloredTextureId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName()).append("{");
        sb.append("plugin: ").append(plugin.toString()).append(", ");
        sb.append("name: \"").append(name).append("\", ");
        sb.append("source: ").append(source.toString()).append(", ");
        sb.append("textureCoordinate: ").append(textureCoordinate.toString()).append("}");
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
}
