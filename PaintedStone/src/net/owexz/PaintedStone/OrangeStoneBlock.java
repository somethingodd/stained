package net.owexz.PaintedStone;
 
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;
 
public class OrangeStoneBlock extends GenericCubeCustomBlock
{
 
    public OrangeStoneBlock(Plugin plugin)
    {
        super(plugin, "OrangeStone Block", new GenericCubeBlockDesign(plugin, "http://www.jamoscraft.owexz.net/uploads/1/4/8/5/1485487/7151376.png", 16));
    }
}