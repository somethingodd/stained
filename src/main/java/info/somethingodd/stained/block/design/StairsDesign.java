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
import org.getspout.spoutapi.block.design.Vertex;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class StairsDesign extends GenericBlockDesign {
    public StairsDesign(Plugin plugin, Texture texture) {
        setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 0.1F, 1.0F);
        setQuadNumber(10);
        setTexture(plugin, texture);
        setMinBrightness(0);
        setMaxBrightness(1);

        Quad top = new Quad(0, texture.getSubTexture(0));
        // 1.0 1.0 0.0
        // 0.0 1.0 0.0
        // 0.0 1.0 0.5
        // 1.0 1.0 0.5
        top.addVertex(0, 1.0F, 1.0F, 0.0F);
        top.addVertex(1, 0.0F, 1.0F, 0.0F);
        top.addVertex(2, 0.0F, 1.0F, 0.5F);
        top.addVertex(3, 1.0F, 1.0F, 0.5F);

        Quad halftop = new Quad(1, texture.getSubTexture(0));
        // 1.0 0.5 0.5
        // 0.0 0.5 0.5
        // 0.0 0.5 1.0
        // 1.0 0.5 1.0
        halftop.addVertex(0, 1.0F, 0.5F, 0.5F);
        halftop.addVertex(1, 0.0F, 0.5F, 0.5F);
        halftop.addVertex(2, 0.0F, 0.5F, 1.0F);
        halftop.addVertex(3, 1.0F, 0.5F, 1.0F);

        Quad front = new Quad(2, texture.getSubTexture(0));
        // 1.0 1.0 0.5
        // 0.0 1.0 0.5
        // 0.0 0.5 0.5
        // 1.0 0.5 0.5
        front.addVertex(0, 1.0F, 1.0F, 0.5F);
        front.addVertex(1, 0.0F, 1.0F, 0.5F);
        front.addVertex(2, 0.0F, 0.5F, 0.5F);
        front.addVertex(3, 1.0F, 0.5F, 0.5F);

        Quad halffront = new Quad(3, texture.getSubTexture(0));
        // 1.0 0.5 1.0
        // 0.0 0.5 1.0
        // 0.0 0.0 1.0
        // 1.0 0.0 1.0
        halffront.addVertex(0, 1.0F, 0.5F, 1.0F);
        halffront.addVertex(1, 0.0F, 0.5F, 1.0F);
        halffront.addVertex(2, 0.0F, 0.0F, 1.0F);
        halffront.addVertex(3, 1.0F, 0.0F, 1.0F);

        Quad bottom = new Quad(4, texture.getSubTexture(0));
        // 1.0 0.0 0.0
        // 0.0 0.0 0.0
        // 0.0 0.0 1.0
        // 1.0 0.0 1.0
        bottom.addVertex(0, 1.0F, 0.0F, 0.0F);
        bottom.addVertex(1, 0.0F, 0.0F, 0.0F);
        bottom.addVertex(2, 0.0F, 0.0F, 1.0F);
        bottom.addVertex(3, 1.0F, 0.0F, 1.0F);

        Quad back = new Quad(5, texture.getSubTexture(0));
        // 1.0 1.0 0.0
        // 0.0 1.0 0.0
        // 0.0 0.0 0.0
        // 1.0 0.0 0.0
        back.addVertex(0, 1.0F, 1.0F, 0.0F);
        back.addVertex(1, 0.0F, 1.0F, 0.0F);
        back.addVertex(2, 0.0F, 0.0F, 0.0F);
        back.addVertex(3, 1.0F, 0.0F, 0.0F);

        Quad left = new Quad(6, texture.getSubTexture(0));
        // 1.0 1.0 0.5
        // 1.0 1.0 0.0
        // 1.0 0.5 0.0
        // 1.0 0.5 0.5
        left.addVertex(0, 1.0F, 1.0F, 0.5F);
        left.addVertex(1, 1.0F, 1.0F, 0.0F);
        left.addVertex(2, 1.0F, 0.5F, 0.0F);
        left.addVertex(3, 1.0F, 0.5F, 0.5F);

        Quad halfleft = new Quad(7, texture.getSubTexture(0));
        // 1.0 0.5 1.0
        // 1.0 0.5 0.0
        // 1.0 0.0 0.0
        // 1.0 0.0 1.0
        halfleft.addVertex(0, 1.0F, 0.5F, 1.0F);
        halfleft.addVertex(1, 1.0F, 0.5F, 0.0F);
        halfleft.addVertex(2, 1.0F, 0.0F, 0.0F);
        halfleft.addVertex(3, 1.0F, 0.0F, 1.0F);

        Quad right = new Quad(8, texture.getSubTexture(0));
        // 0.0 1.0 0.5
        // 0.0 1.0 0.0
        // 0.0 0.5 0.0
        // 0.0 0.5 0.5
        right.addVertex(0, 0.0F, 1.0F, 0.5F);
        right.addVertex(1, 0.0F, 1.0F, 0.0F);
        right.addVertex(2, 0.0F, 0.5F, 0.0F);
        right.addVertex(3, 0.0F, 0.5F, 0.5F);

        Quad halfright = new Quad(9, texture.getSubTexture(0));
        // 0.0 0.5 1.0
        // 0.0 0.5 0.0
        // 0.0 0.0 0.0
        // 0.0 0.0 1.0
        halfright.addVertex(0, 0.0F, 0.5F, 1.0F);
        halfright.addVertex(1, 0.0F, 0.5F, 0.0F);
        halfright.addVertex(2, 0.0F, 0.0F, 0.0F);
        halfright.addVertex(3, 0.0F, 0.0F, 1.0F);

        setQuad(top);
        setQuad(halftop);
        setQuad(front);
        setQuad(halffront);
        setQuad(bottom);
        setQuad(back);
        setQuad(left);
        setQuad(halfleft);
        setQuad(right);
        setQuad(halfright);
    }
}
