package qbyssal.deepmachinery;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.util.Identifier;
import qbyssal.deepmachinery.fluid.ModFluids;
import qbyssal.deepmachinery.fluid.MoltenFluid;
import qbyssal.deepmachinery.screen.CrucibleScreen;
import qbyssal.deepmachinery.screen.ModScreenHandlers;


public class DeepMachineryClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		register(ModFluids.MOLTEN_CHROMIUM);
		register(ModFluids.MOLTEN_FERROCHROMIUM);
		register(ModFluids.MOLTEN_IRON);
	}

	private static <T extends MoltenFluid>void register(T fluid){
		FluidRenderHandlerRegistry.INSTANCE.register(
				fluid.getStill(),
				fluid.getFlowing(),
				new SimpleFluidRenderHandler(
						new Identifier("deepmachinery:block/molten_fluid_still"),
						new Identifier("deepmachinery:block/molten_fluid_flow"),
						fluid.getTint()
				)
		);

		ModScreenHandlers.registerScreenHandlers();
		HandledScreens.register(ModScreenHandlers.CRUCIBLE_SCREEN_HANDLER, CrucibleScreen::new);

	}
}