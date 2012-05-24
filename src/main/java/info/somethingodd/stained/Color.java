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

import org.getspout.spoutapi.material.Item;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class Color implements Cloneable {
    private String name;
    private String fileName;
    private Item item;

    public Color(String name, String fileName, Item item) {
        this.name = name;
        this.fileName = fileName;
        this.item = item;
   }

    public String getName() {
        return name;
    }

    public String getFileName() {
        return fileName;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Color{");
        sb.append("name: \"").append(name).append("\", ");
        sb.append("fileName: \"").append(fileName).append("\", ");
        sb.append("item: ").append(item.toString()).append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return name.hashCode() + fileName.hashCode() + item.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Color)) return false;
        if (!getName().equals(((Color) obj).getName())) return false;
        if (!getFileName().equals(((Color) obj).getFileName())) return false;
        if (!getItem().equals(((Color) obj).getItem())) return false;
        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Color(getName(), getFileName(), getItem());
    }
}
