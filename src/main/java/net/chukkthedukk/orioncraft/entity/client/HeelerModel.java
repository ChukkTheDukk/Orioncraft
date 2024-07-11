// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.chukkthedukk.orioncraft.entity.client;

import net.chukkthedukk.orioncraft.entity.animation.ModAnimations;
import net.chukkthedukk.orioncraft.entity.custom.HeelerEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class HeelerModel<T extends HeelerEntity> extends SinglePartEntityModel<T> {
	private final ModelPart heeler;
	private final ModelPart head;

	public HeelerModel(ModelPart root) {
		this.heeler = root.getChild("heeler");
		this.head = heeler.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData heeler = modelPartData.addChild("heeler", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData tail = heeler.addChild("tail", ModelPartBuilder.create().uv(24, 5).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.6502F, 10.4812F, 1.0036F, 0.0F, 0.0F));

		ModelPartData leg4 = heeler.addChild("leg4", ModelPartBuilder.create().uv(16, 5).cuboid(-1.0F, -3.0F, -1.0008F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.25F, -3.0F, 7.0008F));

		ModelPartData leg3 = heeler.addChild("leg3", ModelPartBuilder.create().uv(16, 5).mirrored().cuboid(-1.0F, -3.0F, 0.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(1.25F, -3.0F, 6.0F));

		ModelPartData leg2 = heeler.addChild("leg2", ModelPartBuilder.create().uv(16, 5).mirrored().cuboid(-1.0F, -3.0F, -1.0008F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-1.25F, -3.0F, -0.9992F));

		ModelPartData leg1 = heeler.addChild("leg1", ModelPartBuilder.create().uv(16, 5).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.25F, -3.0F, -1.0F));

		ModelPartData head = heeler.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -1.0F, -0.75F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(24, 0).cuboid(0.25F, -3.0F, 1.25F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 0).cuboid(-1.0F, 0.75F, -2.5F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(24, 0).mirrored().cuboid(-2.25F, -3.0F, 1.25F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(12, 2).cuboid(-0.5F, 0.5F, -2.75F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(12, 0).cuboid(0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(12, 0).cuboid(-1.5F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.75F, -5.0F));

		ModelPartData body = heeler.addChild("body", ModelPartBuilder.create().uv(0, 21).cuboid(-2.5F, -10.0F, 2.5F, 5.0F, 5.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 10).cuboid(-2.5F, -10.25F, -2.5F, 5.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		heeler.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public void setAngles(HeelerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);//comment this out lol
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.HEELER_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.HEELER_IDLE, ageInTicks, 1f);
	}

	@Override
	public ModelPart getPart() {
		return heeler;
	}
}