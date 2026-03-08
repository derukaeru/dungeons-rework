package derukaeru.dungeons_rework.mixin;

import derukaeru.dungeons_rework.util.LockedChest;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChestBlockEntity.class)
public class ChestBlockEntityMixin implements LockedChest {

    @Unique
    private boolean dungeons_rework$locked = false;

    @Override
    public boolean dungeons_rework$isLocked() {
        return dungeons_rework$locked;
    }

    @Override
    public void dungeons_rework$setLocked(boolean value) {
        dungeons_rework$locked = value;
    }

    @Inject(method = "writeData", at = @At("TAIL"))
    private void writeLock(NbtCompound nbt, CallbackInfo ci) {
        nbt.putBoolean("dungeons_rework_locked", dungeons_rework$locked);
    }

    @Inject(method = "readData", at = @At("TAIL"))
    private void readLock(NbtCompound nbt, CallbackInfo ci) {
        dungeons_rework$locked = nbt.getBoolean("dungeons_rework_locked").orElse(false);
    }
}