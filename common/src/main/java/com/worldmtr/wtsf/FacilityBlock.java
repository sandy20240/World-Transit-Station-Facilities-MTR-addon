package com.worldmtr.wtsf;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public final class FacilityBlock extends Block {
    private final String facilityName;

    public FacilityBlock(String facilityName, Properties properties) {
        super(properties);
        this.facilityName = facilityName;
    }

    @Override
    public InteractionResult use(
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            InteractionHand hand,
            BlockHitResult hit
    ) {
        if (hand != InteractionHand.MAIN_HAND) {
            return InteractionResult.PASS;
        }

        if (!level.isClientSide) {
            player.displayClientMessage(
                    Component.literal("WTSF • " + facilityName + " is operational."),
                    true
            );
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
