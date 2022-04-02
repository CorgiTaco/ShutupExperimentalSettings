package corgitaco.shutupexperimentalsettings.mixin.client;

import net.minecraft.client.gui.screens.worldselection.WorldSelectionList;

import com.mojang.blaze3d.vertex.PoseStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldSelectionList.WorldListEntry.class)
public abstract class WorldSelectionListMixin
{
    /**
     * Prevent Forge from rendering the little warning sign with the "this world may break at any time" tooltip, because it's nonsense.
     */
    @Inject(method = "renderExperimentalWarning", at = @At("HEAD"), cancellable = true, remap = false)
    private void ignoreExperimentalWarningIcon(PoseStack stack, int mouseX, int mouseY, int top, int left, CallbackInfo ci)
    {
        ci.cancel();
    }
}
