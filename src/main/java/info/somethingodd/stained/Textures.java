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
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.material.CustomBlock;

/**
 * @author Gordon Pettey (petteyg359@gmail.com)
 */
public class Textures {
    private static Plugin plugin;

    public static void setPlugin(Plugin plugin) {
        Textures.plugin = plugin;
    }

    public static Texture get(String key) {
        return new Texture(plugin, "http://somethingodd.info/textures/" + key + ".png", 16, 16, 64);
    }
}