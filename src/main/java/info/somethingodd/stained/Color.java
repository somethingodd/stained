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

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class Color {
    private String name;
    private Material source;
    private int row;

    public Color(String name, Material source, int row) {
        this.name = name;
        this.source = source;
        this.row = row;
    }

    public String getName() {
        return name;
    }

    public Material getSource() {
        return source;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Color{");
        sb.append("name: \"").append(name).append("\", ");
        sb.append("source: ").append(source.toString()).append(", ");
        sb.append("row: ").append(row).append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return name.hashCode() + source.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Color)) return false;
        if (!getName().equals(((Color) obj).getName())) return false;
        return (getSource().equals(((Color) obj).getSource()));
    }
}
