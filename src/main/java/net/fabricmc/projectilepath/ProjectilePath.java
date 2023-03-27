package net.fabricmc.projectilepath;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.Vec3d;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectilePath implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("projectilepath");

    /**
     * This code runs as soon as Minecraft is in a mod-load-ready state.
     * However, some things (like resources) may still be uninitialized.
     * Proceed with mild caution.
     */
    @Override
    public void onInitialize() {
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) ->
        {
            BlockState state = world.getBlockState(pos);

            if (state.isToolRequired() && !player.isSpectator() &&
                    player.getMainHandStack().isEmpty()) {
                Vec3d position = player.getPos();
                player.teleport(position.getX(), position.getY() + 5, position.getZ());
                LOGGER.info(position.toString());
            }

            return ActionResult.PASS;
        });
    }
}
