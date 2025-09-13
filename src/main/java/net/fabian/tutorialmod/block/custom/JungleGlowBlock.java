package net.fabian.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class JungleGlowBlock extends MultifaceBlock implements BonemealableBlock {
    private final MultifaceSpreader spreader = new MultifaceSpreader(this);
    public JungleGlowBlock(Properties pProperties) {
        // Pass the properties of the block being very bright //
        super(pProperties.lightLevel(state->15));
    }

    // Hooks into spreader //
    @Override
    public MultifaceSpreader getSpreader() {
        return spreader;
    }

    // Called every so often to let the block randomly spread
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        // delegate to the spreader here
        spreader.spreadFromRandomFaceTowardRandomDirection(state, level, pos, random);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // logic for which face(s) can get the jungle glow
        return super.getStateForPlacement(context);
    }


    // returns whether bonemeal cane be used on the object and it should spread the vines around it //
    @Override
    // nf
    public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return Direction.stream().anyMatch((p_153316_) -> {
            return this.spreader.canSpreadInAnyDirection(pState, pLevel, pPos, p_153316_.getOpposite());
        });
    }

    @Override
    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        this.spreader.spreadFromRandomFaceTowardRandomDirection(pState, pLevel, pPos, pRandom);
    }


    // I want it to glow very bright //
    // I want it to spread vines on a singular face of a object near it //

}


