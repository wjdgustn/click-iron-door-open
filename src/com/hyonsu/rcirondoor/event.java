package com.hyonsu.rcirondoor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Openable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class event implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if(e.getClickedBlock().getType() == Material.IRON_DOOR && e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getHand() == EquipmentSlot.HAND) {
            BlockData data = e.getClickedBlock().getBlockData();
            Openable openable = (Openable) data;

            if(openable.isOpen()) {
                openable.setOpen(false);
                for(Player all : Bukkit.getServer().getOnlinePlayers()) {
                    all.playSound(e.getClickedBlock().getLocation(), Sound.BLOCK_IRON_DOOR_CLOSE, 1, 1);
                }
            }
            else {
                openable.setOpen(true);
                for(Player all : Bukkit.getServer().getOnlinePlayers()) {
                    all.playSound(e.getClickedBlock().getLocation(), Sound.BLOCK_IRON_DOOR_OPEN, 1, 1);
                }
            }
            e.getClickedBlock().setBlockData(data);
            e.getClickedBlock().getState().update();
            e.setCancelled(true);
        }
    }
}
