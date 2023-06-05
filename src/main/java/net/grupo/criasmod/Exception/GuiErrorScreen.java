package net.grupo.criasmod.Exception;


import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.MultiLineLabel;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;


public class GuiErrorScreen extends Screen {

    private final String errorMessage;
    private final Component reason;
    private MultiLineLabel message = MultiLineLabel.EMPTY;
    private final Screen parent;
    private int textHeight;

    public GuiErrorScreen(String errorMessage, Component reason, Screen parent) {
        super(Component.nullToEmpty(errorMessage));
        this.errorMessage = errorMessage;
        this.reason = reason;
        this.parent = parent;
    }


    @Override
    protected void init() {
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.setConnectedToRealms(false);
        minecraft.getDownloadedPackSource().clearServerPack();
        this.message = MultiLineLabel.create(this.font, this.reason, this.width - 50);
        this.textHeight = this.message.getLineCount() * 9;
        this.addRenderableWidget(Button.builder(CommonComponents.GUI_BACK, (p_120663_) -> {
            minecraft.setScreen(this.parent);
        }).bounds(this.width / 2 - 100, this.height / 2 + this.textHeight / 2 + 9, 200, 20).build());

    }

    @Override
    public void render(PoseStack poseStack, int i, int i1, float v) {
        renderDirtBackground(1);
        super.render(poseStack, i, i1, v);
    }
}
