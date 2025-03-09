package com.github.alexthe666.iceandfire.compat.jade;

import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.entity.EntityDragonBase;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.EntityAccessor;
import snownee.jade.api.IEntityComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public enum DragonComponentProvider implements IEntityComponentProvider {
    INSTANCE;

    @Override
    public ResourceLocation getUid() {
        return new ResourceLocation(IceAndFire.MODID, "dragon");
    }

    @Override
    public void appendTooltip(ITooltip iTooltip, EntityAccessor entityAccessor, IPluginConfig iPluginConfig) {
        if (entityAccessor.getEntity() instanceof EntityDragonBase dragon) {
            iTooltip.add(Component.translatable("dragon.stage").withStyle(ChatFormatting.GRAY)
                    .append(Component.literal(" " + dragon.getDragonStage())));
            iTooltip.add(Component.literal(dragon.getAgeInDays() + " day"));
            iTooltip.add(Component.literal(dragon.isMale() ? "Male" : "Female"));
        }
    }
}