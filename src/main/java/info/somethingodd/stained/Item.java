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

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.material.CustomItem;
import org.getspout.spoutapi.material.item.GenericCustomItem;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class Item {
    private Plugin plugin;
    private String name;
    private org.getspout.spoutapi.material.Item source;
    private final Map<Color, CustomItem> items = new HashMap<Color, CustomItem>();

    public Item(Plugin plugin, String name, org.getspout.spoutapi.material.Item source) {
        this.plugin = plugin;
        this.name = name;
        this.source = source;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public String getName() {
        return name;
    }

    public org.getspout.spoutapi.material.Item getSource() {
        return source;
    }

    public Map<Color, CustomItem> getItems() {
        return Collections.unmodifiableMap(items);
    }

    public CustomItem getItem(Color color) {
        return items.get(color);
    }

    public CustomItem makeItem(Color color) {
        CustomItem item;
        String texture = getName().toLowerCase().replaceAll(" ", "") + "-" + color.getName().toLowerCase().replaceAll(" ", "");
        item = new GenericCustomItem(getPlugin(), color.getName() + " " + getName(), ((Stained) getPlugin()).getTexture(texture));
        items.put(color, item);
        return item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Material{");
        sb.append("plugin: ").append(getPlugin().toString()).append(", ");
        sb.append("name: \"").append(getName()).append("\", ");
        sb.append("source: ").append(getSource().toString()).append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return getName().hashCode() + getSource().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Item)) return false;
        if (!getName().equals(((Item) obj).getName())) return false;
        return (getSource().equals(((Item) obj).getSource()));
    }
}
