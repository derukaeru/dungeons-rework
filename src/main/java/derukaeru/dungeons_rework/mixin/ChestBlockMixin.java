package derukaeru.dungeons_rework.mixin;

import derukaeru.dungeons_rework.util.LockedChest;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(net.minecraft.block.ChestBlock.class)
public class ChestBlockMixin {

    @Inject(method = "onUse", at = @At("HEAD"), cancellable = true)
    private void preventOpening(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
        BlockEntity be = world.getBlockEntity(pos);

        if (be instanceof LockedChest lockedChest) {
            if (lockedChest.dungeons_rework$isLocked()) {

                if (!world.isClient()) {
                    player.sendMessage(Text.literal("This chest is locked"), true);
                }

                cir.setReturnValue(ActionResult.SUCCESS);
            }
        }
    }
}