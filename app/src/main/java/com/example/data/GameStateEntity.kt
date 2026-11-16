package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.math.pow
import kotlin.math.roundToLong
import kotlin.math.sqrt

@Entity(tableName = "game_state")
data class GameStateEntity(
    @PrimaryKey val id: Int = 1,
    val diem: Double = 0.0,
    val dollars: Double = 0.0,
    val clicks: Long = 0L,
    val multiplier: Double = 1.0,
    val baseMultiplier: Double = 1.0,
    val pointsPerClick: Double = 1.0,
    val clickCooldownSec: Double = 0.25,
    val cooldownStep: Double = 0.125,
    val discountFactor: Double = 1.0,
    val discountStep: Double = 0.1,
    val pointPowerLv: Int = 0,
    val pointPowerCost: Double = 25.0,
    val multiplierLv: Int = 0,
    val multiplierCost: Double = 50.0,
    val cooldownLv: Int = 0,
    val cooldownCost: Double = 75.0,
    val discountLv: Int = 0,
    val discountCost: Double = 5.0,
    val menuSpeedLv: Int = 0,
    val menuSpeedCost: Double = 3.0,
    val menuTransitionSec: Double = 1.0,
    val toastSpeedLv: Int = 0,
    val toastSpeedCost: Double = 3.0,
    val toastDurationSec: Double = 1.0,
    val autoUnlocked: Boolean = false,
    val autoEnabled: Boolean = false,
    val autoPoints: Double = 1.0,
    val autoCooldownSec: Double = 1.0,
    val autoPowerLv: Int = 0,
    val autoPowerCost: Double = 15.0,
    val autoSpeedLv: Int = 0,
    val autoSpeedCost: Double = 20.0,
    val autoSpeedStep: Double = 0.25,
    val restartLv: Int = 0,
    val restartCost: Double = 150.0,
    val bestCombo: Int = 0,
    val lifetimePoints: Double = 0.0,
    val totalCrits: Long = 0L,
    val critChanceLv: Int = 0,
    val critChanceCost: Double = 120.0,
    val critMultLv: Int = 0,
    val critMultCost: Double = 200.0,
    val comboWindowLv: Int = 0,
    val comboWindowCost: Double = 90.0,
    val passiveLv: Int = 0,
    val passiveCost: Double = 8.0,
    val overdriveCharge: Double = 0.0,
    val overdriveLv: Int = 0,
    val overdriveCost: Double = 12.0,
    val shards: Long = 0L,
    val permStartPointsLv: Int = 0,
    val permGlobalMultLv: Int = 0,
    val permCritLv: Int = 0,
    val permDiscountLv: Int = 0,
    val claimedAchievements: String = "",
    val diamonds: Long = 0L,
    val hasVipPass: Boolean = false,
    val premTapGodLv: Int = 0,
    val premMegaCritLv: Int = 0,
    val premAutoGodLv: Int = 0,
    val premZeroCdLv: Int = 0,
    val premWealthMagnetLv: Int = 0,
    val premGoldenFeverEndAt: Long = 0L,
    val dailyStreak: Int = 0,
    val lastDailyClaimDay: Long = -1L,
    val totalDailyClaims: Int = 0,
    val seasonXp: Long = 0L,
    val seasonPassPremium: Boolean = false,
    val claimedSeasonFree: String = "",
    val claimedSeasonPremium: String = "",
    val gambleSpins: Long = 0L,
    val gambleWins: Long = 0L,
    val gambleBiggestWin: Double = 0.0,
    val gambleJackpotPool: Double = 2500.0,
    val bossLevel: Int = 1,
    val bossCurrentHp: Double = 250.0,
    val bossesDefeated: Long = 0L,
    val relicTapLv: Int = 0,
    val relicCritLv: Int = 0,
    val relicLuckLv: Int = 0,
    val relicBossLv: Int = 0,
    val relicPassiveLv: Int = 0,
    val boosterTapSurgeEndAt: Long = 0L,
    val boosterCritStormEndAt: Long = 0L,
    val boosterAutoFrenzyEndAt: Long = 0L,
    val dailyQuestDay: Long = -1L,
    val dailyQuestTaps: Int = 0,
    val dailyQuestCrits: Int = 0,
    val dailyQuestGambles: Int = 0,
    val dailyQuestBossKills: Int = 0,
    val claimedDailyQuests: String = "",
    val techChips: Long = 0L,
    val fleetScoutLv: Int = 0,
    val fleetHarvesterLv: Int = 0,
    val fleetCruiserLv: Int = 0,
    val fleetMothershipLv: Int = 0,
    val activeExpeditionId: String = "",
    val expeditionEndAt: Long = 0L,
    val totalExpeditionsCompleted: Long = 0L,
    val stockCoreShares: Long = 0L,
    val stockCoreAvgCost: Double = 0.0,
    val stockNeonShares: Long = 0L,
    val stockNeonAvgCost: Double = 0.0,
    val stockQbitShares: Long = 0L,
    val stockQbitAvgCost: Double = 0.0,
    val stockVoidShares: Long = 0L,
    val stockVoidAvgCost: Double = 0.0,
    val stockTotalProfit: Double = 0.0,
    val stockTradesCount: Long = 0L,
    val techOverclockLv: Int = 0,
    val techAutoProtocolLv: Int = 0,
    val techConverterLv: Int = 0,
    val techReactorCoreLv: Int = 0,
    val techMarketIntelLv: Int = 0,
    val techSuperCapLv: Int = 0,
    val skillEmpReadyAt: Long = 0L,
    val skillHyperReadyAt: Long = 0L,
    val skillHyperEndAt: Long = 0L,
    val skillRainReadyAt: Long = 0L,
    val totalSkillsCast: Long = 0L,
    val updatedAt: Long = System.currentTimeMillis()
) {
    fun discountedPointCost(baseCost: Double): Long =
        (baseCost / discountFactor).roundToLong().coerceAtLeast(1L)

    val globalPermanentMultiplier: Double
        get() = 1.0 + permGlobalMultLv * 0.25

    val seasonLevel: Int
        get() = SeasonPassCatalog.levelForXp(seasonXp)

    val seasonMultiplier: Double
        get() = 1.0 + seasonLevel * 0.05

    val relicTapMultiplier: Double
        get() = 1.0 + relicTapLv * 0.35

    val relicPassiveMultiplier: Double
        get() = 1.0 + relicPassiveLv * 0.35

    val bossDamageMultiplier: Double
        get() = (1.0 + relicBossLv * 0.50) * (1.0 + techReactorCoreLv * 0.30)

    val techTapMultiplier: Double
        get() = 1.0 + techOverclockLv * 0.25

    val techAutoMultiplier: Double
        get() = 1.0 + techAutoProtocolLv * 0.30

    val techConverterMultiplier: Double
        get() = 1.0 + techConverterLv * 0.20

    val techExpeditionBonusMultiplier: Double
        get() = 1.0 + techMarketIntelLv * 0.15 + fleetMothershipLv * 0.10

    val skillCooldownFactor: Double
        get() = (1.0 - techSuperCapLv * 0.10).coerceAtLeast(0.45)

    val skillPowerMultiplier: Double
        get() = 1.0 + techSuperCapLv * 0.15

    val fleetMothershipSynergy: Double
        get() = 1.0 + fleetMothershipLv * 0.25

    val fleetTotalPower: Int
        get() = fleetScoutLv + fleetHarvesterLv * 2 + fleetCruiserLv * 4 + fleetMothershipLv * 8

    val fleetPointsPerSec: Double
        get() {
            if (fleetTotalPower <= 0) return 0.0
            val basePts = (fleetScoutLv * 4.0 + fleetHarvesterLv * 10.0 + fleetCruiserLv * 22.0 + fleetMothershipLv * 45.0)
            return basePts * fleetMothershipSynergy * multiplier * globalPermanentMultiplier * seasonMultiplier
        }

    val fleetDollarsPer10Sec: Double
        get() = fleetHarvesterLv * 0.35 * fleetMothershipSynergy

    val fleetBossDps: Double
        get() = if (fleetCruiserLv <= 0) 0.0 else maxOf(6.0, effectivePointsPerClick * 0.25) * fleetCruiserLv * fleetMothershipSynergy

    val totalTechLevel: Int
        get() = techOverclockLv + techAutoProtocolLv + techConverterLv + techReactorCoreLv + techMarketIntelLv + techSuperCapLv

    val vipMultiplier: Double
        get() = if (hasVipPass) 3.0 else 1.0

    val premTapMultiplier: Double
        get() = 2.0.pow(premTapGodLv.coerceIn(0, 20))

    val premAutoMultiplier: Double
        get() = 2.5.pow(premAutoGodLv.coerceIn(0, 15))

    val premPassiveMultiplier: Double
        get() = 1.0 + premAutoGodLv * 0.5

    val effectivePointsPerClick: Double
        get() = pointsPerClick * multiplier * globalPermanentMultiplier * vipMultiplier * premTapMultiplier * relicTapMultiplier * seasonMultiplier * techTapMultiplier

    val effectiveAutoPointsPerTick: Double
        get() = autoPoints * multiplier * globalPermanentMultiplier * vipMultiplier * premAutoMultiplier * relicPassiveMultiplier * seasonMultiplier * techAutoMultiplier

    val effectiveClickCooldownSec: Double
        get() = (clickCooldownSec * 0.8.pow(premZeroCdLv.coerceIn(0, 5))).coerceAtLeast(0.005)

    val critChancePercent: Double
        get() = (critChanceLv * 4.0 + permCritLv * 3.0 + premMegaCritLv * 8.0 + relicCritLv * 2.5 + fleetScoutLv * 1.5 + if (hasVipPass) 10.0 else 0.0)
            .coerceAtMost(95.0)

    val critMultiplier: Double
        get() = 2.5 + critMultLv * 0.5 + premMegaCritLv * 1.5 + relicCritLv * 0.4

    val comboWindowMs: Long
        get() = 2000L + comboWindowLv * 350L

    val passivePointsPerSec: Double
        get() = if (passiveLv <= 0) 0.0 else effectivePointsPerClick * 0.4 * passiveLv * premPassiveMultiplier * relicPassiveMultiplier

    val overdriveDurationSec: Double
        get() = 10.0 + overdriveLv * 2.0 + premZeroCdLv * 3.0

    val overdriveChargePerTap: Double
        get() = (5.0 + overdriveLv * 1.0) * (1.0 + techReactorCoreLv * 0.20) * (if (hasVipPass) 2.0 else 1.0)

    val dollarExchangeMultiplier: Double
        get() = 1.5.pow(premWealthMagnetLv.coerceIn(0, 15)) * techConverterMultiplier

    val restartRequirement: Long
        get() = discountedPointCost(restartCost)

    val nextBaseMultiplier: Double
        get() = baseMultiplier + 0.5

    val pendingShardsOnRestart: Long
        get() = if (diem < restartRequirement) {
            0L
        } else {
            val baseShards = 1L + sqrt(diem / restartRequirement.toDouble()).toLong() + (restartLv / 2L)
            (baseShards * (1.0 + premWealthMagnetLv * 0.25)).roundToLong().coerceAtLeast(1L)
        }

    val permStartPointsAmount: Double
        get() = permStartPointsLv * 500.0

    val permStartDiscountBonus: Double
        get() = permDiscountLv * 0.15

    val reactorTier: ReactorTier
        get() = when {
            restartLv >= 10 || lifetimePoints >= 2_500_000.0 -> ReactorTier.V_INFINITY
            restartLv >= 6 || lifetimePoints >= 250_000.0 -> ReactorTier.IV_SINGULARITY
            restartLv >= 3 || lifetimePoints >= 25_000.0 -> ReactorTier.III_QUANTUM
            restartLv >= 1 || lifetimePoints >= 2_500.0 -> ReactorTier.II_PLASMA
            else -> ReactorTier.I_NUCLEAR
        }

    fun isAchievementClaimed(achievementId: String): Boolean {
        if (claimedAchievements.isBlank()) return false
        return claimedAchievements.split(",").contains(achievementId)
    }

    fun isSeasonFreeClaimed(level: Int): Boolean {
        if (claimedSeasonFree.isBlank()) return false
        return claimedSeasonFree.split(",").contains(level.toString())
    }

    fun isSeasonEliteClaimed(level: Int): Boolean {
        if (claimedSeasonPremium.isBlank()) return false
        return claimedSeasonPremium.split(",").contains(level.toString())
    }

    fun isDailyQuestClaimed(questId: String): Boolean {
        if (claimedDailyQuests.isBlank()) return false
        return claimedDailyQuests.split(",").contains(questId)
    }

    fun relicLevel(relic: RelicId): Int = when (relic) {
        RelicId.TITAN -> relicTapLv
        RelicId.CRIT_EYE -> relicCritLv
        RelicId.LUCKY_CLOVER -> relicLuckLv
        RelicId.BOSS_SLAYER -> relicBossLv
        RelicId.ETERNAL_CELL -> relicPassiveLv
    }
}

enum class ReactorTier(val code: String, val displayName: String, val sides: Int) {
    I_NUCLEAR("Mk.I", "Lõi Hạt Nhân", 4),
    II_PLASMA("Mk.II", "Lõi Plasma", 6),
    III_QUANTUM("Mk.III", "Lõi Lượng Tử", 8),
    IV_SINGULARITY("Mk.IV", "Lõi Hố Đen", 10),
    V_INFINITY("Mk.V", "Lõi Vô Cực", 12)
}

object ComboSystem {
    const val COMBO_WINDOW_MS = 2000L

    fun multiplierFor(combo: Int): Double = when {
        combo >= 50 -> 3.0
        combo >= 35 -> 2.5
        combo >= 20 -> 2.0
        combo >= 10 -> 1.5
        combo >= 5 -> 1.2
        else -> 1.0
    }

    fun tierLabelFor(combo: Int): String = when {
        combo >= 50 -> "QUÁ TẢI NEON"
        combo >= 35 -> "SIÊU TỐC"
        combo >= 20 -> "BÙNG NỔ"
        combo >= 10 -> "NHỊP ĐỘ"
        combo >= 5 -> "KHỞI ĐỘNG"
        else -> "CHUỖI COMBO"
    }
}

object ShardShopCosts {
    fun costFor(level: Int, baseCost: Long): Long = baseCost * (level + 1L)
}

object PremiumShopCosts {
    fun upgradeCost(level: Int, baseDiamonds: Long): Long = baseDiamonds * (level + 1L)

    fun smallPointsPack(game: GameStateEntity): Double =
        maxOf(5_000.0, game.effectivePointsPerClick * 250.0)

    fun mediumPointsPack(game: GameStateEntity): Double =
        maxOf(50_000.0, game.effectivePointsPerClick * 1_500.0)

    fun megaPointsPack(game: GameStateEntity): Double =
        maxOf(500_000.0, game.effectivePointsPerClick * 8_000.0)
}
