package qbyssal.deepmachinery.screen;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import qbyssal.deepmachinery.DeepMachinery;

public class ModScreenHandlers {
    public static ScreenHandlerType<CrucibleScreenHandler> CRUCIBLE_SCREEN_HANDLER;

    public static void registerScreenHandlers(){
        DeepMachinery.LOGGER.info("Registering screen handlers for "+DeepMachinery.MOD_ID);
        CRUCIBLE_SCREEN_HANDLER = new ScreenHandlerType<>(CrucibleScreenHandler::new,FeatureFlags.VANILLA_FEATURES);
    }

}
