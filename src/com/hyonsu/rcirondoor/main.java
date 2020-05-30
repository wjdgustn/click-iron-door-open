package com.hyonsu.rcirondoor;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    @Override
    public void onEnable() {
        // 이벤트 등록
        getServer().getPluginManager().registerEvents(new event(), this);

        // 활성화 알림
        Bukkit.getLogger().info("§a[HYONSU_Iron_Door_Right_Click_Open] 플러그인이 활성화 되었습니다.");
    }

    @Override
    public void onDisable() {
        // 비활성화 알림
        Bukkit.getLogger().info("§a[HYONSU_Iron_Door_Right_Click_Open] 플러그인이 비활성화 되었습니다.");
    }
}
