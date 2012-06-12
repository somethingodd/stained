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
package info.somethingodd.stained.block.design;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.Quad;
import org.getspout.spoutapi.block.design.SubTexture;
import org.getspout.spoutapi.block.design.Texture;

import java.util.Arrays;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class CubeDesign extends GenericBlockDesign {
    private int[] textureId;

    public CubeDesign(Plugin plugin, Texture texture, int[] textureId) {
        this.textureId = textureId;
        SubTexture topt = new SubTexture(texture, textureId[0] % 32, textureId[0] / 32, 16);
        SubTexture side1 = new SubTexture(texture, textureId[1] % 32, textureId[1] / 32, 16);
        SubTexture side2 = new SubTexture(texture, textureId[2] % 32, textureId[2] / 32, 16);
        SubTexture side3 = new SubTexture(texture, textureId[3] % 32, textureId[3] / 32, 16);
        SubTexture side4 = new SubTexture(texture, textureId[4] % 32, textureId[4] / 32, 16);
        SubTexture bottomt = new SubTexture(texture, textureId[5] % 32, textureId[5] / 32, 16);
        setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        //setMinBrightness(0.0F);
        //setMaxBrightness(1.0F);
        this.
        setTexture(plugin, texture);
        setQuadNumber(6);
        Quad top = new Quad(0, topt);
        Quad bottom = new Quad(5, bottomt);
        Quad front = new Quad(1, side1);
        Quad right = new Quad(2, side2);
        Quad back = new Quad(3, side3);
        Quad left = new Quad(4, side4);
        top(top);
        front(front);
        right(right);
        back(back);
        left(left);
        bottom(bottom);

        setQuad(top);
        setQuad(front);
        setQuad(right);
        setQuad(back);
        setQuad(left);
        setQuad(bottom);
    }

    public static void top(Quad quad) {
        quad.addVertex(0, 0.0F, 1.0F, 1.0F);
        quad.addVertex(1, 1.0F, 1.0F, 1.0F);
        quad.addVertex(2, 1.0F, 1.0F, 0.0F);
        quad.addVertex(3, 0.0F, 1.0F, 0.0F);
    }

    public static void front(Quad quad) {
        quad.addVertex(0, 0.0F, 1.0F, 0.0F);
        quad.addVertex(1, 1.0F, 1.0F, 0.0F);
        quad.addVertex(2, 1.0F, 0.0F, 0.0F);
        quad.addVertex(3, 0.0F, 0.0F, 0.0F);
    }

    public static void right(Quad quad) {
        quad.addVertex(0, 1.0F, 1.0F, 0.0F);
        quad.addVertex(1, 1.0F, 1.0F, 1.0F);
        quad.addVertex(2, 1.0F, 0.0F, 1.0F);
        quad.addVertex(3, 1.0F, 0.0F, 0.0F);
    }

    public static void back(Quad quad) {
        quad.addVertex(0, 0.0F, 1.0F, 1.0F);
        quad.addVertex(1, 1.0F, 1.0F, 1.0F);
        quad.addVertex(2, 1.0F, 0.0F, 1.0F);
        quad.addVertex(3, 0.0F, 0.0F, 1.0F);
    }

    public static void left(Quad quad) {
        quad.addVertex(0, 0.0F, 1.0F, 0.0F);
        quad.addVertex(1, 0.0F, 1.0F, 1.0F);
        quad.addVertex(2, 0.0F, 0.0F, 1.0F);
        quad.addVertex(3, 0.0F, 0.0F, 0.0F);
    }

    public static void bottom(Quad quad) {
        quad.addVertex(0, 0.0F, 0.0F, 1.0F);
        quad.addVertex(1, 1.0F, 0.0F, 1.0F);
        quad.addVertex(2, 1.0F, 0.0F, 0.0F);
        quad.addVertex(3, 0.0F, 0.0F, 0.0F);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CubeDesign{");
        sb.append("topt: ").append(textureId[0] % 24).append(",").append(textureId[0] / 24).append(", ");
        sb.append("side1: ").append(textureId[1] % 24).append(",").append(textureId[1] / 24).append(", ");
        sb.append("side2: ").append(textureId[2] % 24).append(",").append(textureId[2] / 24).append(", ");
        sb.append("side3: ").append(textureId[3] % 24).append(",").append(textureId[3] / 24).append(", ");
        sb.append("side4: ").append(textureId[4] % 24).append(",").append(textureId[4] / 24).append(", ");
        sb.append("bottomt: ").append(textureId[5] % 24).append(",").append(textureId[5] / 24).append("}");
        return sb.toString();
    }
}
