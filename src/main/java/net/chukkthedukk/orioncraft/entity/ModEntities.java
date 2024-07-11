package net.chukkthedukk.orioncraft.entity;

import net.chukkthedukk.orioncraft.Orioncraft;
import net.chukkthedukk.orioncraft.entity.custom.HeelerEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<HeelerEntity> HEELER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Orioncraft.MOD_ID, "heeler"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HeelerEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());

    public static void registerModEntities() {
        Orioncraft.LOGGER.info("Registering Entities for Orioncraft");
    }
}
