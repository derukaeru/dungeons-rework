package derukaeru.dungeons_rework.mixin;

import net.minecraft.block.entity.ChestBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ChestBlockEntity.class)
public class ChestBlockEntityMixin {

    @Unique
    private boolean dungeons_rework$locked = false;

    @Unique
    public boolean dungeons_rework$isLocked() {
        return dungeons_rework$locked;
    }

    @Unique
    public void dungeons_rework$setLocked(boolean value) {
        dungeons_rework$locked = value;
    }
}