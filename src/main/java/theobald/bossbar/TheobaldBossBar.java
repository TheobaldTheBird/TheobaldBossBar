package theobald.bossbar;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheobaldBossBar implements ModInitializer
{
    private MinecraftClient client;
    public static final Logger LOGGER = LoggerFactory.getLogger("ElytraUtil");
    public static KeyBinding toggleKeybind;
    public static boolean enabled;

    @Override
    public void onInitialize()
    {
        toggleKeybind = KeyBindingHelper.registerKeyBinding(new KeyBinding("ToggleKeybind", InputUtil.Type.KEYSYM, InputUtil.UNKNOWN_KEY.getCode(), "Theobald Utilities"));
        LOGGER.info("Loading Theobald Bossbar Mod");

        ClientTickEvents.END_CLIENT_TICK.register(client ->
        {
            if(toggleKeybind.wasPressed())
            {
                enabled = !enabled;
                client.player.sendMessage(Text.of("Bossbar rendering " + (enabled ? "disabled" : "enabled")), true);
            }
        });
    }

}
