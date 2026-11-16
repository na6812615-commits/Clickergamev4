package com.example.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [GameStateEntity::class], version = 6, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameStateDao(): GameStateDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE game_state ADD COLUMN bestCombo INTEGER NOT NULL DEFAULT 0")
            }
        }

        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE game_state ADD COLUMN lifetimePoints REAL NOT NULL DEFAULT 0.0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN totalCrits INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN critChanceLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN critChanceCost REAL NOT NULL DEFAULT 120.0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN critMultLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN critMultCost REAL NOT NULL DEFAULT 200.0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN comboWindowLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN comboWindowCost REAL NOT NULL DEFAULT 90.0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN passiveLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN passiveCost REAL NOT NULL DEFAULT 8.0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN overdriveCharge REAL NOT NULL DEFAULT 0.0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN overdriveLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN overdriveCost REAL NOT NULL DEFAULT 12.0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN shards INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN permStartPointsLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN permGlobalMultLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN permCritLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN permDiscountLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN claimedAchievements TEXT NOT NULL DEFAULT ''")
            }
        }

        val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE game_state ADD COLUMN diamonds INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN hasVipPass INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN premTapGodLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN premMegaCritLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN premAutoGodLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN premZeroCdLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN premWealthMagnetLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN premGoldenFeverEndAt INTEGER NOT NULL DEFAULT 0")
            }
        }

        val MIGRATION_4_5 = object : Migration(4, 5) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE game_state ADD COLUMN dailyStreak INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN lastDailyClaimDay INTEGER NOT NULL DEFAULT -1")
                db.execSQL("ALTER TABLE game_state ADD COLUMN totalDailyClaims INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN seasonXp INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN seasonPassPremium INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN claimedSeasonFree TEXT NOT NULL DEFAULT ''")
                db.execSQL("ALTER TABLE game_state ADD COLUMN claimedSeasonPremium TEXT NOT NULL DEFAULT ''")
                db.execSQL("ALTER TABLE game_state ADD COLUMN gambleSpins INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN gambleWins INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN gambleBiggestWin REAL NOT NULL DEFAULT 0.0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN gambleJackpotPool REAL NOT NULL DEFAULT 2500.0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN bossLevel INTEGER NOT NULL DEFAULT 1")
                db.execSQL("ALTER TABLE game_state ADD COLUMN bossCurrentHp REAL NOT NULL DEFAULT 250.0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN bossesDefeated INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN relicTapLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN relicCritLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN relicLuckLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN relicBossLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN relicPassiveLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN boosterTapSurgeEndAt INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN boosterCritStormEndAt INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN boosterAutoFrenzyEndAt INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN dailyQuestDay INTEGER NOT NULL DEFAULT -1")
                db.execSQL("ALTER TABLE game_state ADD COLUMN dailyQuestTaps INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN dailyQuestCrits INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN dailyQuestGambles INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN dailyQuestBossKills INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN claimedDailyQuests TEXT NOT NULL DEFAULT ''")
            }
        }

        val MIGRATION_5_6 = object : Migration(5, 6) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE game_state ADD COLUMN techChips INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN fleetScoutLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN fleetHarvesterLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN fleetCruiserLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN fleetMothershipLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN activeExpeditionId TEXT NOT NULL DEFAULT ''")
                db.execSQL("ALTER TABLE game_state ADD COLUMN expeditionEndAt INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN totalExpeditionsCompleted INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN stockCoreShares INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN stockCoreAvgCost REAL NOT NULL DEFAULT 0.0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN stockNeonShares INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN stockNeonAvgCost REAL NOT NULL DEFAULT 0.0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN stockQbitShares INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN stockQbitAvgCost REAL NOT NULL DEFAULT 0.0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN stockVoidShares INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN stockVoidAvgCost REAL NOT NULL DEFAULT 0.0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN stockTotalProfit REAL NOT NULL DEFAULT 0.0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN stockTradesCount INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN techOverclockLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN techAutoProtocolLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN techConverterLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN techReactorCoreLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN techMarketIntelLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN techSuperCapLv INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN skillEmpReadyAt INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN skillHyperReadyAt INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN skillHyperEndAt INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN skillRainReadyAt INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE game_state ADD COLUMN totalSkillsCast INTEGER NOT NULL DEFAULT 0")
            }
        }

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "tapcore_game.db"
                )
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5, MIGRATION_5_6)
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}
