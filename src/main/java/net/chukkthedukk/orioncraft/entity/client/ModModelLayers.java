package net.chukkthedukk.orioncraft.entity.client;

import net.chukkthedukk.orioncraft.Orioncraft;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer HEELER =
            new EntityModelLayer(new Identifier(Orioncraft.MOD_ID, "heeler"), "main");
}
