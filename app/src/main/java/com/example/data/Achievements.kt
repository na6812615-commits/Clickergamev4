package com.example.data

data class AchievementDef(
    val id: String,
    val title: String,
    val description: String,
    val rewardDollars: Double,
    val rewardShards: Long,
    val targetValue: Double,
    val progressSelector: (GameStateEntity) -> Double
)

object AchievementCatalog {
    val all: List<AchievementDef> = listOf(
        AchievementDef(
            id = "clicks_50",
            title = "Khởi động ngón tay",
            description = "Đạt 50 lượt click trong một vòng",
            rewardDollars = 3.0,
            rewardShards = 0L,
            targetValue = 50.0,
            progressSelector = { it.clicks.toDouble() }
        ),
        AchievementDef(
            id = "clicks_500",
            title = "Nhịp chạm chuyên cần",
            description = "Đạt 500 lượt click trong một vòng",
            rewardDollars = 10.0,
            rewardShards = 1L,
            targetValue = 500.0,
            progressSelector = { it.clicks.toDouble() }
        ),
        AchievementDef(
            id = "clicks_5000",
            title = "Cỗ máy bấm tốc độ",
            description = "Đạt 5.000 lượt click trong một vòng",
            rewardDollars = 35.0,
            rewardShards = 3L,
            targetValue = 5000.0,
            progressSelector = { it.clicks.toDouble() }
        ),
        AchievementDef(
            id = "points_2k",
            title = "Nguồn năng lượng đầu tiên",
            description = "Tích lũy tổng 2.500 điểm trọn đời",
            rewardDollars = 5.0,
            rewardShards = 1L,
            targetValue = 2500.0,
            progressSelector = { it.lifetimePoints }
        ),
        AchievementDef(
            id = "points_50k",
            title = "Nhà máy Cyber",
            description = "Tích lũy tổng 50.000 điểm trọn đời",
            rewardDollars = 25.0,
            rewardShards = 2L,
            targetValue = 50_000.0,
            progressSelector = { it.lifetimePoints }
        ),
        AchievementDef(
            id = "points_1m",
            title = "Triệu phú Lượng Tử",
            description = "Tích lũy tổng 1.000.000 điểm trọn đời",
            rewardDollars = 100.0,
            rewardShards = 5L,
            targetValue = 1_000_000.0,
            progressSelector = { it.lifetimePoints }
        ),
        AchievementDef(
            id = "combo_10",
            title = "Bắt nhịp Neon",
            description = "Đạt kỷ lục Click Combo từ 10x trở lên",
            rewardDollars = 5.0,
            rewardShards = 1L,
            targetValue = 10.0,
            progressSelector = { it.bestCombo.toDouble() }
        ),
        AchievementDef(
            id = "combo_35",
            title = "Bậc thầy Liên hoàn",
            description = "Đạt kỷ lục Click Combo từ 35x trở lên",
            rewardDollars = 20.0,
            rewardShards = 2L,
            targetValue = 35.0,
            progressSelector = { it.bestCombo.toDouble() }
        ),
        AchievementDef(
            id = "combo_50",
            title = "Quá tải tuyệt đối",
            description = "Đạt kỷ lục Click Combo 50x trở lên",
            rewardDollars = 50.0,
            rewardShards = 4L,
            targetValue = 50.0,
            progressSelector = { it.bestCombo.toDouble() }
        ),
        AchievementDef(
            id = "crits_25",
            title = "Xạ thủ Chí mạng",
            description = "Kích hoạt 25 lần Chí mạng (Crit)",
            rewardDollars = 15.0,
            rewardShards = 2L,
            targetValue = 25.0,
            progressSelector = { it.totalCrits.toDouble() }
        ),
        AchievementDef(
            id = "auto_unlock",
            title = "Tự động hóa hoàn toàn",
            description = "Mở khóa Auto Click trong \$Shop\$",
            rewardDollars = 0.0,
            rewardShards = 2L,
            targetValue = 1.0,
            progressSelector = { if (it.autoUnlocked) 1.0 else 0.0 }
        ),
        AchievementDef(
            id = "restart_1",
            title = "Vòng lặp đầu tiên",
            description = "Thực hiện Restarts đạt cấp 1",
            rewardDollars = 10.0,
            rewardShards = 2L,
            targetValue = 1.0,
            progressSelector = { it.restartLv.toDouble() }
        ),
        AchievementDef(
            id = "restart_5",
            title = "Chúa tể Tái sinh",
            description = "Thực hiện Restarts đạt cấp 5",
            rewardDollars = 50.0,
            rewardShards = 5L,
            targetValue = 5.0,
            progressSelector = { it.restartLv.toDouble() }
        ),
        AchievementDef(
            id = "fleet_power_5",
            title = "Đô đốc Tập sự",
            description = "Đạt Tổng Lực Chiến Hạm đội từ 5 trở lên",
            rewardDollars = 30.0,
            rewardShards = 2L,
            targetValue = 5.0,
            progressSelector = { it.fleetTotalPower.toDouble() }
        ),
        AchievementDef(
            id = "fleet_power_25",
            title = "Hạm Đội Thiên Hà",
            description = "Đạt Tổng Lực Chiến Hạm đội từ 25 trở lên",
            rewardDollars = 150.0,
            rewardShards = 6L,
            targetValue = 25.0,
            progressSelector = { it.fleetTotalPower.toDouble() }
        ),
        AchievementDef(
            id = "expedition_1",
            title = "Chuyến Tàu Đầu Tiên",
            description = "Hoàn thành 1 chuyến Thám Hiểm Hành Tinh",
            rewardDollars = 25.0,
            rewardShards = 2L,
            targetValue = 1.0,
            progressSelector = { it.totalExpeditionsCompleted.toDouble() }
        ),
        AchievementDef(
            id = "expedition_10",
            title = "Nhà Thám Hiểm Vũ Trụ",
            description = "Hoàn thành 10 chuyến Thám Hiểm Hành Tinh",
            rewardDollars = 180.0,
            rewardShards = 7L,
            targetValue = 10.0,
            progressSelector = { it.totalExpeditionsCompleted.toDouble() }
        ),
        AchievementDef(
            id = "stock_trade_5",
            title = "Nhà Đầu Tư Cyber",
            description = "Thực hiện 5 giao dịch trên Sàn Chứng Khoán",
            rewardDollars = 45.0,
            rewardShards = 2L,
            targetValue = 5.0,
            progressSelector = { it.stockTradesCount.toDouble() }
        ),
        AchievementDef(
            id = "stock_profit_500",
            title = "Cá Mập Phố Wall Neon",
            description = "Chốt lời tổng cộng $500 trên Sàn Chứng Khoán",
            rewardDollars = 250.0,
            rewardShards = 8L,
            targetValue = 500.0,
            progressSelector = { it.stockTotalProfit }
        ),
        AchievementDef(
            id = "tech_level_5",
            title = "Kỹ Sư Lượng Tử",
            description = "Đạt tổng 5 cấp Cây Công Nghệ",
            rewardDollars = 60.0,
            rewardShards = 3L,
            targetValue = 5.0,
            progressSelector = { it.totalTechLevel.toDouble() }
        ),
        AchievementDef(
            id = "tech_level_20",
            title = "Kiến Trúc Sư Tối Thượng",
            description = "Đạt tổng 20 cấp Cây Công Nghệ",
            rewardDollars = 320.0,
            rewardShards = 10L,
            targetValue = 20.0,
            progressSelector = { it.totalTechLevel.toDouble() }
        ),
        AchievementDef(
            id = "skill_cast_10",
            title = "Chiến Binh Xung Kích",
            description = "Kích hoạt 10 lần Kỹ Năng Chủ Động",
            rewardDollars = 40.0,
            rewardShards = 3L,
            targetValue = 10.0,
            progressSelector = { it.totalSkillsCast.toDouble() }
        ),
        AchievementDef(
            id = "boss_slayer_5",
            title = "Diệt Chủng Boss Lõi",
            description = "Hạ gục 5 Boss Lõi",
            rewardDollars = 140.0,
            rewardShards = 5L,
            targetValue = 5.0,
            progressSelector = { it.bossesDefeated.toDouble() }
        )
    )
}
