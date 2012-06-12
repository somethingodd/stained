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

import org.getspout.spoutapi.material.Material;
import org.getspout.spoutapi.material.MaterialData;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class TextureCoordinates {
    private static final Map<Material, TextureCoordinate> textureCoordinateMap = new HashMap<Material, TextureCoordinate>();
    private static int textureSize;
    
    static {
        textureCoordinateMap.put(MaterialData.brick, new TextureCoordinate(0));
        textureCoordinateMap.put(MaterialData.brickSlab, new TextureCoordinate(0));
        textureCoordinateMap.put(MaterialData.cobblestone, new TextureCoordinate(3));
        textureCoordinateMap.put(MaterialData.cobblestoneSlab, new TextureCoordinate(3));
        textureCoordinateMap.put(MaterialData.glass, new TextureCoordinate(6));
        textureCoordinateMap.put(MaterialData.glowstoneBlock, new TextureCoordinate(7));
        textureCoordinateMap.put(MaterialData.obsidian, new TextureCoordinate(8));
        textureCoordinateMap.put(MaterialData.sandstone, new TextureCoordinate(9, 10, 12));
        textureCoordinateMap.put(MaterialData.sandstoneSlab, new TextureCoordinate(9, 10, 12, 11, 11));
        textureCoordinateMap.put(MaterialData.stone, new TextureCoordinate(13));
        textureCoordinateMap.put(MaterialData.stoneSlab, new TextureCoordinate(17, 14, 17, 15, 16));
        textureCoordinateMap.put(MaterialData.stoneBricks, new TextureCoordinate(18));
        textureCoordinateMap.put(MaterialData.stoneBrickSlab, new TextureCoordinate(18));
        textureCoordinateMap.put(MaterialData.wood, new TextureCoordinate(21));
        textureCoordinateMap.put(MaterialData.woodenSlab, new TextureCoordinate(21));
    }
    
    public static TextureCoordinate getTextureCoordinate(Material material) {
        return textureCoordinateMap.get(material);
    }

    public static void registerTextureCoordinate(Material material, TextureCoordinate textureCoordinate) {
        textureCoordinateMap.put(material, textureCoordinate);
    }

    public static void setTextureSize(int textureSize) {
        TextureCoordinates.textureSize = textureSize;
    }

    public static int getTextureSize() {
        return textureSize;
    }

    public static class TextureCoordinate {
        private int side;
        private int top;
        private int bottom;
        private int sideLow;
        private int sideHigh;

        public TextureCoordinate(int side) {
            this(side, side, side);
        }
        
        public TextureCoordinate(int bottom, int side, int top) {
            this(bottom, side, top, side + 1, side + 2);
        }

        public TextureCoordinate(int bottom, int side, int top, int sideHigh, int sideLow) {
            this.bottom = bottom;
            this.side = side;
            this.top = top;
            this.sideHigh = sideHigh;
            this.sideLow = sideLow;
        }

        public int getSide() {
            return side;
        }

        public int getTop() {
            return top;
        }

        public int getBottom() {
            return bottom;
        }

        public int getSideLow() {
            return sideLow;
        }

        public int getSideHigh() {
            return sideHigh;
        }

        public int[] getTextureId() {
            return new int[]{getBottom(), getSide(), getSide(), getSide(), getSide(), getTop()};
        }
        
        public int[] getTextureIdHigh() {
            return new int[]{getBottom(), getSideHigh(), getSideHigh(), getSideHigh(), getSideHigh(), getTop()};
        }
        
        public int[] getTextureIdLow() {
            return new int[]{getBottom(), getSideLow(), getSideLow(), getSideLow(), getSideLow(), getTop()};
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("TextureCoordinate{");
            sb.append("bottom: ").append(getBottom()).append(", ");
            sb.append("side: ").append(getSide()).append(", ");
            sb.append("top: ").append(getTop()).append(", ");
            sb.append("sideHigh: ").append(getSideHigh()).append(", ");
            sb.append("sideLow: ").append(getSideLow()).append("}");
            return sb.toString();
        }
    }
}
