package com.dashboard.systemstats.service;

import oshi.SystemInfo;
import oshi.hardware.*;
import oshi.software.os.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemStatsService {

    private final SystemInfo systemInfo = new SystemInfo();
    private final HardwareAbstractionLayer hardware = systemInfo.getHardware();
    private final OperatingSystem os = systemInfo.getOperatingSystem();

    private long[] prevTicks = hardware.getProcessor().getSystemCpuLoadTicks();

    public Map<String, Object> getSystemStats() {
        Map<String, Object> stats = new HashMap<>();

        // CPU Load (requires previous ticks)
        CentralProcessor processor = hardware.getProcessor();
        long[] ticks = processor.getSystemCpuLoadTicks();
        double cpuLoad = processor.getSystemCpuLoadBetweenTicks(prevTicks);
        prevTicks = ticks;
        stats.put("cpuLoad", cpuLoad);

        // Memory
        GlobalMemory memory = hardware.getMemory();
        stats.put("totalMemory", memory.getTotal());
        stats.put("availableMemory", memory.getAvailable());

        // Uptime
        stats.put("uptime", os.getSystemUptime());

        // OS Info
        stats.put("os", os.toString());
        stats.put("hostname", os.getNetworkParams().getHostName());

        // Battery (if available)
        List<PowerSource> powerSources = hardware.getPowerSources();
        if (!powerSources.isEmpty()) {
            stats.put("battery", powerSources.get(0).getRemainingCapacityPercent());
        }

        // Network Interfaces (count)
        List<NetworkIF> netList = hardware.getNetworkIFs();
        stats.put("networkInterfaces", netList.size());

        return stats;
    }
}
