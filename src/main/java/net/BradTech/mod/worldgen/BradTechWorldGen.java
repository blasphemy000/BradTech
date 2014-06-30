package net.BradTech.mod.worldgen;

import java.util.Random;

import net.BradTech.mod.BradTech;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class BradTechWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case 0:
			// Generate our surface world.
			generateSurface(world, random, chunkX * 16, chunkZ * 16);

		case -1:
			// Generate our nether world.
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			
		case 1:
			// Generate our end world.
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
	}
	
	

	private void generateSurface(World world, Random random, int x, int z) {
		// this.addOreSpawn(BradTech.[OreName], world, random, x=BlockXPos, z=BlockZPos, MaxX, MaxZ, MaxVeinSize, ChanceToSpawn, MinY, MaxY); 
		this.addOreSpawn(BradTech.oreCopperOre, world, random, x, z, 16, 16, 4 + random.nextInt(6), 25, 35, 100);
		this.addOreSpawn(BradTech.oreTinOre, world, random, x, z, 16, 16, 4 + random.nextInt(6), 25, 35, 100);
		this.addOreSpawn(BradTech.oreAluminumOre, world, random, x, z, 16, 16, 4 + random.nextInt(6), 25, 35, 100);
		this.addOreSpawn(BradTech.oreNickelOre, world, random, x, z, 16, 16, 4 + random.nextInt(6), 25, 10, 50);
		this.addOreSpawn(BradTech.orePlatinumOre, world, random, x, z, 16, 16, 2 + random.nextInt(4), 25, 1, 30);
		this.addOreSpawn(BradTech.oreUraniumOre, world, random, x, z, 16, 16, 2 + random.nextInt(4), 25, 1, 30);
		this.addOreSpawn(BradTech.oreBlueQuartzOre, world, random, x, z, 16, 16, 4 + random.nextInt(6), 25, 10, 50);
	}

	
	private void generateNether(World world, Random random, int x, int z) {
		this.addNetherOreSpawn(BradTech.oreNetherIronOre, world, random, x, z, 16, 16, 4 + random.nextInt(6), 25, 1, 127);
		this.addNetherOreSpawn(BradTech.oreNetherGoldOre, world, random, x, z, 16, 16, 4 + random.nextInt(6), 25, 1, 127);
		this.addNetherOreSpawn(BradTech.oreNetherCopperOre, world, random, x, z, 16, 16, 4 + random.nextInt(6), 25, 1, 127);
		this.addNetherOreSpawn(BradTech.oreNetherTinOre, world, random, x, z, 16, 16, 4 + random.nextInt(6), 25, 1, 127);
		this.addNetherOreSpawn(BradTech.oreNetherAluminumOre, world, random, x, z, 16, 16, 4 + random.nextInt(6), 25, 1, 127);
		this.addNetherOreSpawn(BradTech.oreNetherNickelOre, world, random, x, z, 16, 16, 4 + random.nextInt(6), 25, 1, 127);
		this.addNetherOreSpawn(BradTech.oreNetherPlatinumOre, world, random, x, z, 16, 16, 2 + random.nextInt(4), 20, 1, 127);
		this.addNetherOreSpawn(BradTech.oreNetherUraniumOre, world, random, x, z, 16, 16, 2 + random.nextInt(4), 20, 1, 127);
		this.addNetherOreSpawn(BradTech.oreNetherBlueQuartzOre, world, random, x, z, 16, 16, 4 + random.nextInt(6), 25, 1, 127);
		this.addNetherOreSpawn(BradTech.oreNetherDiamondOre, world, random, x, z, 16, 16, 2 + random.nextInt(4), 20, 1, 127);
		this.addNetherOreSpawn(BradTech.oreNetherEmeraldOre, world, random, x, z, 16, 16, 2 + random.nextInt(4), 20, 1, 127);
		this.addNetherOreSpawn(BradTech.oreNetherRedstoneOre, world, random, x, z, 16, 16, 4 + random.nextInt(6), 25, 1, 127);
		this.addNetherOreSpawn(BradTech.oreNetherCoalOre, world, random, x, z, 16, 16, 4 + random.nextInt(6), 25, 1, 127);
	}


	private void generateEnd(World world, Random random, int x, int z) {
		
	}


	private void addOreSpawn(Block block, World world, Random random, int blockX, int blockZ, int maxX, int maxZ, int maxVein, int spawnChance, int minY, int maxY) {
		for(int i = 0; i < spawnChance; i++) {
			int posX = blockX + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY);
			int posZ = blockZ + random.nextInt(maxZ);
			
			(new WorldGenMinable(block, maxVein)).generate(world, random, posX, posY, posZ);
			
		}
	}
	

	private void addNetherOreSpawn(Block block, World world, Random random, int blockX, int blockZ, int maxX, int maxZ, int maxVein, int spawnChance, int minY, int maxY) {
		for(int i = 0; i < spawnChance; i++) {
			int posX = blockX + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY);
			int posZ = blockZ + random.nextInt(maxZ);
			
			(new WorldGenNetherMinable(block, maxVein)).generate(world, random, posX, posY, posZ);
		}		
	}

}	// End Class





