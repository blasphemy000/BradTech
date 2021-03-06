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
				
				this.model.renderCore(modelScale, ModelWireDirection.CORE);
				//this.model.renderCore(modelScale, ModelWireDirection.NORTHSOUTH);
				//this.model.renderCore(modelScale, ModelWireDirection.EASTWEST);
				//this.model.renderCore(modelScale, ModelWireDirection.UPDOWN);
				
				if(tileWire.getRenderNorth()) {
					if(tileWire.getConnectNorth()) {
						if(tileWire.getAllowConnNorth())
							this.model.renderNorth(modelScale, true);
					} else {
						this.model.renderNorth(modelScale, false);
					}
				}
				
				if(tileWire.getRenderSouth()) {
					if(tileWire.getConnectSouth()) {
						if(tileWire.getAllowConnSouth())
							this.model.renderSouth(modelScale, true);
					} else {
						this.model.renderSouth(modelScale, false);
					}
				}
				
				if(tileWire.getRenderEast()) {
					if(tileWire.getConnectEast()) {
						if(tileWire.getAllowConnEast())
							this.model.renderEast(modelScale, true);
					} else {
						this.model.renderEast(modelScale, false);
					}
				}
				
				if(tileWire.getRenderWest()) {
					if(tileWire.getConnectWest()) {
						if(tileWire.getAllowConnWest())
							this.model.renderWest(modelScale, true);
					} else {
						this.model.renderWest(modelScale, false);
					}
				}
				
				if(tileWire.getRenderUp()) {
					if(tileWire.getConnectUp()) {
						if(tileWire.getAllowConnUp())
							this.model.renderUp(modelScale, true);
					} else {
						this.model.renderUp(modelScale, false);
					}
				}
				
				if(tileWire.getRenderDown()) {
					if(tileWire.getConnectDown()) {
						if(tileWire.getAllowConnDown())
							this.model.renderDown(modelScale, true);
					} else {
						this.model.renderDown(modelScale, false);
					}
				}
				
				GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
