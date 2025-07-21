package com.dashboard.systemstats.controller;
import com.dashboard.systemstats.service.SystemStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController
@RequestMapping("/api/stats")
public class SystemStatsController {
    @Autowired
    private SystemStatsService systemStatsService;

    @GetMapping
    public Map<String, Object> getStats() {
        return systemStatsService.getSystemStats();
    }
}
