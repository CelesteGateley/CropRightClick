package net.fluxinc.croprightclick;

import com.sk89q.worldguard.WorldGuard;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import net.fluxinc.croprightclick.listeners.InteractListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CropRightClick extends JavaPlugin {

    private boolean worldGuardCompat;
    private boolean griefPreventionCompat;
    @Override
    public void onEnable() {
        // Test For WorldGuard Compatibility
        try {
            WorldGuard worldGuard = WorldGuard.getInstance();
            worldGuardCompat = true;
        } catch (NoClassDefFoundError e) {
            worldGuardCompat = false;
        }
        // Test For GriefPrevention Compatibility
        try {
            GriefPrevention gpInst = GriefPrevention.instance;
            griefPreventionCompat = true;
        } catch (NoClassDefFoundError e) {
            griefPreventionCompat = false;
        }

        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new InteractListener(this, worldGuardCompat, griefPreventionCompat), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
