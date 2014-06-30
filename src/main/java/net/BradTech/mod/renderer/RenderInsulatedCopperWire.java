package net.BradTech.mod.renderer;

import org.lwjgl.opengl.GL11;

import net.BradTech.mod.BradTech;
import net.BradTech.mod.model.ModelInsulatedCopperWire;
import net.BradTech.mod.model.ModelInsulatedCopperWire.ModelWireDirection;
import net.BradTech.mod.tileentity.TileEntityInsulatedCopperWire;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderInsulatedCopperWire extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(BradTech.modid + ":" + "textures/models/InsulatedCopperWire.png");

	private ModelInsulatedCopperWire model;
	
	private final float modelScale = 0.0625F;
	
	public RenderInsulatedCopperWire() {
		model = new ModelInsulatedCopperWire();
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
		TileEntityInsulatedCopperWire tileWire = (TileEntityInsulatedCopperWire)tileEntity;
		
		GL11.glPushMatrix();
			GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
			GL11.glRotatef(180, 0F, 0F, 1F);
		
			this.bindTexture(texture);
		
			GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_LIGHTING);
				// Figure out what parts of the model should be drawn then render each part accordingly...
				
				//this.model.renderCore(modelScale);
				
				this.model.renderStraight(modelScale, ModelWireDirection.NORTHSOUTH);
				//this.model.renderStraight(modelScale, ModelWireDirection.EASTWEST);
				//this.model.renderStraight(modelScale, ModelWireDirection.UPDOWN);
				
				if(tileWire.getConnectionStatus()) {
					this.model.renderNorth(modelScale, true);
					this.model.renderSouth(modelScale, true);
				} else if (!tileWire.getConnectionStatus()) {
					this.model.renderNorth(modelScale, false);
					this.model.renderSouth(modelScale, false);
				}
				
				//this.model.renderNorth(modelScale, false);
				//this.model.renderNorth(modelScale, true);
				
				//this.model.renderSouth(modelScale, false);
				//this.model.renderSouth(modelScale, true);

				//this.model.renderEast(modelScale, false);
				//this.model.renderEast(modelScale, true);

				//this.model.renderWest(modelScale, false);
				//this.model.renderWest(modelScale, true);

				//this.model.renderUp(modelScale, false);
				//this.model.renderUp(modelScale, true);

				//this.model.renderDown(modelScale, false);
				//this.model.renderDown(modelScale, true);
				
				GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
