package com.example.gamehokandroidassesment.util

import com.example.gamehokandroidassesment.R
import com.example.gamehokandroidassesment.model.GameComments
import com.example.gamehokandroidassesment.model.GameModel
import com.example.gamehokandroidassesment.model.GameRequirements


val games = listOf(
    GameModel(
        id = 1,
        name = "PUBG",
        image = R.drawable.pubg,
        description = "PUBG is a battle royale game where players fight to be the last one standing.",
        rating = 4.2f,
        comments = listOf(
            GameComments(1, 1, "Amazing gameplay!", "Gamer123", "2023-06-25"),
            GameComments(2, 1, "Great graphics and mechanics.", "ProGamer", "2023-06-26")
        ),
        minRequirements = GameRequirements(
            id = 1,
            gameId = 1,
            os = "Windows 7 64-bit",
            processor = "Intel Core i5-4430 / AMD FX-6300",
            memory = "8 GB RAM",
            graphics = "NVIDIA GeForce GTX 960 2GB / AMD Radeon R7 370 2GB",
            storage = "30 GB available space"
        ),
        recRequirements = GameRequirements(
            id = 2,
            gameId = 1,
            os = "Windows 10 64-bit",
            processor = "Intel Core i5-6600K / AMD Ryzen 5 1600",
            memory = "16 GB RAM",
            graphics = "NVIDIA GeForce GTX 1060 3GB / AMD Radeon RX 580 4GB",
            storage = "30 GB available space"
        ),
        genre = listOf("Battle Royale", "Shooter"),
        developer = "PUBG Corporation",
        publisher = "PUBG Corporation",
        releaseDate = "2017-12-20",
        ageGroup = "16"
    ),
    GameModel(
        id = 2,
        name = "Valorant",
        image = R.drawable.valorent,
        description = "Valorant is a tactical shooter game developed by Riot Games.",
        rating = 4.5f,
        comments = listOf(
            GameComments(3, 2, "Very strategic and fun.", "TacticalMaster", "2023-06-27"),
            GameComments(4, 2, "Love the unique agents.", "Agent007", "2023-06-28")
        ),
        minRequirements = GameRequirements(
            id = 3,
            gameId = 2,
            os = "Windows 7 64-bit",
            processor = "Intel Core 2 Duo E8400",
            memory = "4 GB RAM",
            graphics = "Intel HD 3000",
            storage = "8 GB available space"
        ),
        recRequirements = GameRequirements(
            id = 4,
            gameId = 2,
            os = "Windows 10 64-bit",
            processor = "Intel i3-4150",
            memory = "4 GB RAM",
            graphics = "GeForce GT 730",
            storage = "8 GB available space"
        ),
        genre = listOf("Tactical Shooter", "FPS"),
        developer = "Riot Games",
        publisher = "Riot Games",
        releaseDate = "2020-06-02",
        ageGroup = "16"
    ),
    GameModel(
        id = 3,
        name = "Apex Legends",
        image = R.drawable.apex_of_legend,
        description = "Apex Legends is a free-to-play battle royale game developed by Respawn Entertainment.",
        rating = 4.3f,
        comments = listOf(
            GameComments(5, 3, "Fast-paced and exciting!", "SpeedyGonzales", "2023-06-29"),
            GameComments(6, 3, "Great character abilities.", "AbilityMaster", "2023-06-30")
        ),
        minRequirements = GameRequirements(
            id = 5,
            gameId = 3,
            os = "Windows 7 64-bit",
            processor = "Intel Core i3-6300 / AMD FX-4350",
            memory = "6 GB RAM",
            graphics = "NVIDIA GeForce GT 640 / Radeon HD 7730",
            storage = "22 GB available space"
        ),
        recRequirements = GameRequirements(
            id = 6,
            gameId = 3,
            os = "Windows 10 64-bit",
            processor = "Intel i5 3570K / Ryzen 5 CPU",
            memory = "8 GB RAM",
            graphics = "NVIDIA GeForce GTX 970 / AMD Radeon R9 290",
            storage = "22 GB available space"
        ),
        genre = listOf("Battle Royale", "Shooter"),
        developer = "Respawn Entertainment",
        publisher = "Electronic Arts",
        releaseDate = "2019-02-04",
        ageGroup = "16"
    ),
    GameModel(
        id = 4,
        name = "Call of Duty",
        image = R.drawable.call_of_duty,
        description = "Call of Duty is a first-person shooter series developed by Infinity Ward, Treyarch, and Sledgehammer Games.",
        rating = 4.6f,
        comments = listOf(
            GameComments(7, 4, "Iconic FPS game!", "ShooterFan", "2023-07-01"),
            GameComments(8, 4, "Great single-player campaign.", "SoloPlayer", "2023-07-02")
        ),
        minRequirements = GameRequirements(
            id = 7,
            gameId = 4,
            os = "Windows 7 64-bit",
            processor = "Intel Core i3-4340 / AMD FX-6300",
            memory = "8 GB RAM",
            graphics = "NVIDIA GeForce GTX 670 / GeForce GTX 1650 / Radeon HD 7950",
            storage = "175 GB available space"
        ),
        recRequirements = GameRequirements(
            id = 8,
            gameId = 4,
            os = "Windows 10 64-bit",
            processor = "Intel Core i5-2500K / Ryzen R5 1600X",
            memory = "12 GB RAM",
            graphics = "NVIDIA GeForce GTX 970 / GTX 1660 / Radeon R9 390 / RX 580",
            storage = "175 GB available space"
        ),
        genre = listOf("FPS", "Shooter"),
        developer = "Infinity Ward",
        publisher = "Activision",
        releaseDate = "2003-10-29",
        ageGroup = "18"
    ),
    GameModel(
        id = 5,
        name = "Counter-Strike",
        image = R.drawable.counter_strike,
        description = "Counter-Strike is a series of multiplayer first-person shooter games in which teams of terrorists battle to perpetrate an act of terror while counter-terrorists try to prevent it.",
        rating = 4.8f,
        comments = listOf(
            GameComments(9, 5, "Classic and competitive.", "ProPlayer", "2023-07-03"),
            GameComments(10, 5, "A game that defined a genre.", "CSFan", "2023-07-04")
        ),
        minRequirements = GameRequirements(
            id = 9,
            gameId = 5,
            os = "Windows 7 64-bit",
            processor = "Intel Core 2 Duo E6600 / AMD Phenom X3 8750",
            memory = "2 GB RAM",
            graphics = "Video card must be 256 MB or more and should be a DirectX 9-compatible with support for Pixel Shader 3.0",
            storage = "15 GB available space"
        ),
        recRequirements = GameRequirements(
            id = 10,
            gameId = 5,
            os = "Windows 10 64-bit",
            processor = "Intel Core i5-2400 / AMD Ryzen 5 1400",
            memory = "8 GB RAM",
            graphics = "NVIDIA GeForce GTX 1050 Ti / AMD Radeon RX 570",
            storage = "15 GB available space"
        ),
        genre = listOf("FPS", "Shooter"),
        developer = "Valve",
        publisher = "Valve",
        releaseDate = "2000-11-01",
        ageGroup = "16"
    ),
    GameModel(
        id = 6,
        name = "PUBG",
        image = R.drawable.pubg,
        description = "PUBG is a battle royale game where players fight to be the last one standing.",
        rating = 4.2f,
        comments = listOf(
            GameComments(1, 1, "Amazing gameplay!", "Gamer123", "2023-06-25"),
            GameComments(2, 1, "Great graphics and mechanics.", "ProGamer", "2023-06-26")
        ),
        minRequirements = GameRequirements(
            id = 1,
            gameId = 1,
            os = "Windows 7 64-bit",
            processor = "Intel Core i5-4430 / AMD FX-6300",
            memory = "8 GB RAM",
            graphics = "NVIDIA GeForce GTX 960 2GB / AMD Radeon R7 370 2GB",
            storage = "30 GB available space"
        ),
        recRequirements = GameRequirements(
            id = 2,
            gameId = 1,
            os = "Windows 10 64-bit",
            processor = "Intel Core i5-6600K / AMD Ryzen 5 1600",
            memory = "16 GB RAM",
            graphics = "NVIDIA GeForce GTX 1060 3GB / AMD Radeon RX 580 4GB",
            storage = "30 GB available space"
        ),
        genre = listOf("Battle Royale", "Shooter"),
        developer = "PUBG Corporation",
        publisher = "PUBG Corporation",
        releaseDate = "2017-12-20",
        ageGroup = "16"
    )
)