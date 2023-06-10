package net.grupo.criasmod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {

    public static final String KEY_CATEGORY_CRIASMOD = "key.category.criasmod.criasmod";

    public static final String KEY_TRANSFORM = "key.criasmod.transform";


    public static final KeyMapping TRANSFORM_KEY = new KeyMapping(KEY_TRANSFORM, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_T, KEY_CATEGORY_CRIASMOD);



}
