package net.chukkthedukk.orioncraft;

import net.chukkthedukk.orioncraft.entity.ModEntities;
import net.chukkthedukk.orioncraft.entity.client.HeelerModel;
import net.chukkthedukk.orioncraft.entity.client.HeelerRenderer;
import net.chukkthedukk.orioncraft.entity.client.ModModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class OrioncraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.HEELER, HeelerRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.HEELER, HeelerModel::getTexturedModelData);
    }
}
