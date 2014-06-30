package net.BradTech.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelObsidianTable extends ModelBase {
	ModelRenderer tabletop;
	ModelRenderer legtwo;
	ModelRenderer legone;
	ModelRenderer legthree;
	ModelRenderer legfour;

	public ModelObsidianTable() {

		textureWidth = 64;
		textureHeight = 64;

		tabletop = new ModelRenderer(this, 0, 0);
		tabletop.addBox(0F, 0F, 0F, 16, 4, 16);
		tabletop.setRotationPoint(-8F, 10F, -8F);
		tabletop.setTextureSize(64, 64);
		tabletop.mirror = true;
		setRotation(tabletop, 0F, 0F, 0F);
		
		legtwo = new ModelRenderer(this, 17, 21);
		legtwo.addBox(0F, 0F, 0F, 4, 10, 4);
		legtwo.setRotationPoint(-8F, 14F, -8F);
		legtwo.setTextureSize(64, 64);
		legtwo.mirror = true;
		setRotation(legtwo, 0F, 0F, 0F);

		legone = new ModelRenderer(this, 0, 21);
		legone.addBox(0F, 0F, 0F, 4, 10, 4);
		legone.setRotationPoint(4F, 14F, -8F);
		legone.setTextureSize(64, 64);
		legone.mirror = true;
		setRotation(legone, 0F, 0F, 0F);

		legthree = new ModelRenderer(this, 0, 36);
		legthree.addBox(0F, 0F, 0F, 4, 10, 4);
		legthree.setRotationPoint(4F, 14F, 4F);
		legthree.setTextureSize(64, 64);
		legthree.mirror = true;
		setRotation(legthree, 0F, 0F, 0F);
		
		legfour = new ModelRenderer(this, 17, 36);
		legfour.addBox(0F, 0F, 0F, 4, 10, 4);
		legfour.setRotationPoint(-8F, 14F, 4F);
		legfour.setTextureSize(64, 64);
		legfour.mirror = true;
		setRotation(legfour, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		tabletop.render(f5);
		legtwo.render(f5);
		legone.render(f5);
		legthree.render(f5);
		legfour.render(f5);
	}

	public void renderModel(float f) {
		tabletop.render(f);
		legtwo.render(f);
		legone.render(f);
		legthree.render(f);
		legfour.render(f);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
