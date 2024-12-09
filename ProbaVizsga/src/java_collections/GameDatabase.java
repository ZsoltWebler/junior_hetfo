package java_collections;

import java.util.ArrayList;
import java.util.List;

public class GameDatabase {

    private final List<Game> gameList;


    public GameDatabase() {
        this.gameList = new ArrayList<>(
                List.of(
                        new Game("Galactic Bowling", 19.99, 6, 11, new Developer("Perpetual FX Creative"), List.of(Genre.CASUAL, Genre.INDIE, Genre.SPORTS)),
                        new Game("Train Bandit", 0.99, 53, 5, new Developer("Rusty Moyher"), List.of(Genre.ACTION, Genre.INDIE)),
                        new Game("Jolt Project", 4.99, 0, 0, new Developer("Campião Games"), List.of(Genre.ACTION, Genre.ADVENTURE, Genre.INDIE, Genre.STRATEGY)),
                        new Game("Henosis™", 5.99, 3, 0, new Developer("Odd Critter Games"), List.of(Genre.ADVENTURE, Genre.CASUAL, Genre.INDIE)),
                        new Game("Two Weeks in Painland", 0.0, 50, 8, new Developer("Unusual Games"), List.of(Genre.ADVENTURE, Genre.INDIE)),
                        new Game("Wartune Reborn", 0.0, 87, 49, new Developer("7Road"), List.of(Genre.ADVENTURE, Genre.CASUAL, Genre.FREE_TO_PLAY, Genre.MASSIVELY_MULTIPLAYER, Genre.RPG, Genre.STRATEGY)),
                        new Game("TD Worlds", 10.99, 21, 7, new Developer("MAKSIM VOLKAU"), List.of(Genre.INDIE, Genre.STRATEGY)),
                        new Game("Legend of Rome - The Wrath of Mars", 9.99, 0, 0, new Developer("magnussoft"), List.of(Genre.CASUAL)),
                        new Game("MazM: Jekyll and Hyde", 14.99, 76, 6, new Developer("Growing Seeds"), List.of(Genre.ADVENTURE, Genre.RPG, Genre.SIMULATION, Genre.STRATEGY)),
                        new Game("Deadlings: Rotten Edition", 3.99, 225, 45, new Developer("ONE MORE LEVEL"), List.of(Genre.ACTION, Genre.ADVENTURE, Genre.INDIE)),
                        new Game("WARSAW", 23.99, 589, 212, new Developer("Pixelated Milk"), List.of(Genre.INDIE, Genre.RPG)),
                        new Game("Cthulhu Realms", 0.0, 147, 58, new Developer("Wise Wizard Games, LLC"), List.of(Genre.STRATEGY)),
                        new Game("Clockwork Dungeon", 1.99, 5, 0, new Developer("Beardlings LLC"), List.of(Genre.CASUAL, Genre.INDIE)),
                        new Game("Royal Battleships", 2.99, 36, 11, new Developer("Beardlings LLC"), List.of(Genre.CASUAL, Genre.INDIE)),
                        new Game("Diary of Lucie", 12.99, 100, 5, new Developer("Beardlings LLC"), List.of(Genre.ACTION, Genre.ADVENTURE, Genre.INDIE, Genre.RPG, Genre.STRATEGY, Genre.EARLY_ACCESS)),
                        new Game("Alien Breed 3: Descent", 9.99, 349, 134, new Developer("Team17 Digital Ltd"), List.of(Genre.ACTION)),
                        new Game("Hunting Unlimited 3", 9.99, 17, 0, new Developer("SCS Software"), List.of(Genre.ACTION, Genre.CASUAL, Genre.SIMULATION, Genre.SPORTS)),
                        new Game("Hero of the Kingdom II", 7.99, 2046, 120, new Developer("Lonely Troops"), List.of(Genre.ADVENTURE, Genre.CASUAL, Genre.INDIE, Genre.RPG)),
                        new Game("Super Naughty Maid 2", 9.59, 0, 0, new Developer("KENZsoft"), List.of(Genre.CASUAL, Genre.INDIE)),
                        new Game("KHIO", 9.99, 3, 1, new Developer("Necavare"), List.of(Genre.ACTION, Genre.ADVENTURE, Genre.CASUAL, Genre.INDIE, Genre.EARLY_ACCESS)),
                        new Game("Steam Squad", 17.99, 61, 29, new Developer("Bretwalda Games"), List.of(Genre.INDIE, Genre.STRATEGY)),
                        new Game("Project: R.E.B.O.O.T 2", 2.99, 29, 28, new Developer("Volens Nolens Games"), List.of(Genre.ACTION, Genre.ADVENTURE, Genre.CASUAL, Genre.INDIE)),
                        new Game("Aerofly FS 2 Flight Simulator", 37.49, 1490, 408, new Developer("IPACS"), List.of(Genre.ACTION, Genre.INDIE, Genre.RACING, Genre.SIMULATION)),
                        new Game("Turtle Lu", 2.99, 4, 10, new Developer("Falco Software"), List.of(Genre.ACTION, Genre.ADVENTURE, Genre.CASUAL, Genre.INDIE)),
                        new Game("PowersVR", 9.99, 37, 22, new Developer("Falco Software"), List.of(Genre.ACTION, Genre.INDIE, Genre.SIMULATION)),
                        new Game("Draw Your Game", 4.99, 18, 50, new Developer("Zero One"), List.of(Genre.CASUAL)),
                        new Game("Pathfinders: Memories", 2.99, 38, 4, new Developer("Mens Sana Interactive"), List.of(Genre.CASUAL)),
                        new Game("Bright Days in Quarantine", 1.99, 24, 5, new Developer("Delta Arcade"), List.of(Genre.CASUAL, Genre.INDIE, Genre.SIMULATION, Genre.STRATEGY)),
                        new Game("Dupio", 11.99, 23, 18, new Developer("NedoStudio"), List.of(Genre.CASUAL, Genre.INDIE)),
                        new Game("Home Office Tasker", 0.99, 11, 4, new Developer("lonch.me"), List.of(Genre.UTILITIES)),
                        new Game("Terror In The Atomic Desert", 2.99, 8, 4, new Developer("TensionSplice"), List.of(Genre.ADVENTURE, Genre.INDIE)),
                        new Game("Unhappy Ever After", 0.99, 16, 10, new Developer("Dark Water Studios Ltd"), List.of(Genre.ADVENTURE, Genre.INDIE, Genre.RPG)),
                        new Game("DogFighter", 0.99, 258, 166, new Developer("Dark Water Studios Ltd"), List.of(Genre.ACTION, Genre.INDIE)),
                        new Game("March Of Soldiers", 1.99, 1, 0, new Developer("FAYEZ ALRASHEEDI"), List.of(Genre.ACTION, Genre.STRATEGY, Genre.EARLY_ACCESS)),
                        new Game("Bepuzzled Kittens Jigsaw Puzzle", 1.99, 7, 2, new Developer("Team Spikkeee"), List.of(Genre.CASUAL)),
                        new Game("Dream Detective", 7.99, 16, 8, new Developer("Century Game"), List.of(Genre.ADVENTURE, Genre.CASUAL, Genre.INDIE)),
                        new Game("Tower of Shades", 1.99, 35, 8, new Developer("Lame Jam"), List.of(Genre.INDIE, Genre.RPG)),
                        new Game("Vanguard Princess", 2.49, 2014, 841, new Developer("Tomoaki Sugeno"), List.of(Genre.ACTION, Genre.CASUAL, Genre.INDIE)),
                        new Game("IRON REBELLION", 11.99, 168, 39, new Developer("Dark Water Studios Ltd"), List.of(Genre.ACTION, Genre.INDIE, Genre.EARLY_ACCESS)),
                        new Game("Treasures of the Ancients: Egypt", 0.99, 55, 91, new Developer("Dark Water Studios Ltd"), List.of(Genre.ADVENTURE, Genre.CASUAL, Genre.INDIE)),
                        new Game("Deadfall Adventures", 19.99, 1716, 628, new Developer("Dark Water Studios Ltd"), List.of(Genre.ACTION, Genre.ADVENTURE)),
                        new Game("Who We Are Now", 14.99, 0, 0, new Developer("Chroma Field Games"), List.of(Genre.INDIE)),
                        new Game("Reigns: Game of Thrones", 3.99, 698, 203, new Developer("Nerial"), List.of(Genre.ADVENTURE, Genre.INDIE, Genre.RPG)),
                        new Game("CasinoRPG", 0.0, 138, 84, new Developer("GoldFire Studios"), List.of(Genre.CASUAL, Genre.FREE_TO_PLAY, Genre.INDIE, Genre.MASSIVELY_MULTIPLAYER, Genre.RPG, Genre.SIMULATION)),
                        new Game("Far Cry® 5", 59.99, 100620, 25286, new Developer("Ubisoft Montreal"), List.of(Genre.ACTION, Genre.ADVENTURE)),
                        new Game("Loot Collection: Mahjong", 0.55, 2, 3, new Developer("Boogygames Studios"), List.of(Genre.ADVENTURE, Genre.CASUAL, Genre.INDIE, Genre.SIMULATION, Genre.STRATEGY)),
                        new Game("INFERNO CLIMBER", 14.99, 60, 46, new Developer("Arc System Works"), List.of(Genre.ACTION, Genre.RPG)),
                        new Game("Grim Tales: The Heir Collector's Edition", 9.99, 7, 1, new Developer("Elephant Games"), List.of(Genre.ADVENTURE, Genre.CASUAL)),
                        new Game("Mythos Ever After: A Cthulhu Dating Sim", 4.99, 1, 0, new Developer("Stegalosaurus Game Development"), List.of(Genre.ADVENTURE, Genre.INDIE)),
                        new Game("Pool Adventure", 0.99, 0, 0, new Developer("Uintani"), List.of(Genre.ADVENTURE, Genre.INDIE)),
                        new Game("Eternal Edge+ Prologue", 0.0, 0, 0, new Developer("Righteous Weasel Games"), List.of(Genre.ACTION, Genre.ADVENTURE, Genre.RPG)),
                        new Game("A Journey Through Valhalla", 5.99, 3, 3, new Developer("Team Sämst"), List.of(Genre.ACTION, Genre.ADVENTURE, Genre.RPG)),
                        new Game("COUNTDOWN", 0.99, 6, 1, new Developer("Hello Friend LLC"), List.of(Genre.ACTION, Genre.INDIE, Genre.EARLY_ACCESS)),
                        new Game("Colours of Magic: Aqua Teeter", 0.99, 69, 17, new Developer("RunServer"), List.of(Genre.CASUAL, Genre.INDIE)),
                        new Game("Forza Horizon 4", 59.99, 122539, 15095, new Developer("Playground Games"), List.of(Genre.RACING)),
                        new Game("Viking Warrior", 3.99, 2, 17, new Developer("VikingWarrior"), List.of(Genre.ACTION, Genre.ADVENTURE, Genre.INDIE, Genre.RPG)),
                        new Game("Square Keeper", 4.99, 10, 0, new Developer("KanakStudio"), List.of(Genre.ADVENTURE, Genre.INDIE)),
                        new Game("Pension Day", 0.99, 0, 1, new Developer("Julian Henley"), List.of(Genre.ACTION, Genre.CASUAL)),
                        new Game("Slipstream 5000", 2.99, 283, 92, new Developer("Gremlin Interactive"), List.of(Genre.ACTION, Genre.RACING, Genre.SPORTS)),
                        new Game("100 Doors: Escape from Work", 9.99, 7, 2, new Developer("Peaksel"), List.of(Genre.CASUAL)),
                        new Game("Project MIKHAIL: A Muv-Luv War Story", 19.99, 328, 253, new Developer("aNCHOR Inc."), List.of(Genre.ACTION, Genre.ADVENTURE, Genre.RPG, Genre.SIMULATION, Genre.STRATEGY, Genre.EARLY_ACCESS)),
                        new Game("Rezist: Tower Defense", 0.99, 8, 0, new Developer("SparkGames"), List.of(Genre.INDIE, Genre.STRATEGY)),
                        new Game("Max Payne", 3.49, 9516, 1114, new Developer("Remedy Entertainment"), List.of(Genre.ACTION)),
                        new Game("Black Mansion", 6.99, 1, 0, new Developer("PICTOLOGI"), List.of(Genre.ACTION, Genre.ADVENTURE, Genre.INDIE))
                )
        );

    }

    public List<Game> getGames() {
        return gameList;
    }
}
