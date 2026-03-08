package derukaeru.dungeons_rework.items;

import derukaeru.dungeons_rework.util.LockedChest;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LockItem extends Item {

    public LockItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();

        BlockEntity be = world.getBlockEntity(pos);

        if (be instanceof ChestBlockEntity && be instanceof LockedChest lockedChest) {

            lockedChest.dungeons_rework$setLocked(true);
            be.markDirty();

            if (!world.isClient()) {
                if (context.getPlayer() != null) {
                    context.getPlayer().sendMessage(Text.literal("Chest locked"), true);
                }
            }

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }
}