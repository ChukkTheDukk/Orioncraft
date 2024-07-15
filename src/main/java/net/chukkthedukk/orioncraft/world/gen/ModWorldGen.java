package net.chukkthedukk.orioncraft.world.gen;

public class ModWorldGen {
    public static void generateWorldGen() {
        ModOreGen.generateOres();
        ModEntitySpawn.addEntitySpawn();
    }
}
