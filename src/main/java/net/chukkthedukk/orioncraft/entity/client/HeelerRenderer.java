package net.chukkthedukk.orioncraft.entity.client;

import net.chukkthedukk.orioncraft.Orioncraft;
import net.chukkthedukk.orioncraft.entity.custom.HeelerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

import java.util.Random;

public class HeelerRenderer extends MobEntityRenderer<HeelerEntity, HeelerModel<HeelerEntity>> {
    private final Identifier TEXTURE = new Identifier(Orioncraft.MOD_ID, "textures/entity/heeler_blue.png");

    public HeelerRenderer(EntityRendererFactory.Context context) {
        super(context, new HeelerModel<>(context.getPart(ModModelLayers.HEELER)), 0.6f);
    }

    @Override
    public Identifier getTexture(HeelerEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(HeelerEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
