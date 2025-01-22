# Junior Java Backend fejlesztő tanfolyam

## Próbavizsga

### 1. Feladat - Java programozási nyelv alapjai:

A `java_basics` csomagban hozz létre egy `TextAnalyzer` osztályt, amely különböző szinteken elemzi a szöveg karaktereit.

Elemzési módok:

* `CountLetters`: Számolja meg, hogy hány kis- és nagybetű található a szövegben.
* `CountDigits`: Számolja meg, hogy hány számjegy van a szövegben.
* `CountSpecialCharacters`: Számolja meg, hogy hány speciális karakter található a szövegben (pl.: !, @, #, $, %, &, *).
* `CountWords`: Számolja meg, hogy hány szó található a szövegben (a szavakat szóköz választja el).

Feladat:

1. Implementáld a `TextAnalyzer` osztály hiányzó metódusait.
2. A teszteléshez használd a `TextAnalyzerTest` osztályt:
    * Bizonyosodj meg róla, hogy minden metódus helyes eredményt ad különböző típusú szövegekre.
    * Adj hozzá teszteket olyan érvénytelen bemenetek ellenőrzésére, mint például üres szöveg vagy csak szóközökből álló
      szöveg.

### 2. Feladat - Java objektumorientált programozás:

A `java_oop` package-ben lévő recept-nyilvántartó rendszert kell folytatnia a következő szempontok figyelembevételével:


A `Recipe` osztály:

* `name` - A recept neve (String)
* `ingredients` - Egy lista az összetevőkről (List<Ingredient>)
* `servings` - Az adagok száma (int)

Az `Ingredient` osztály:

* `name` - Az összetevő neve (String)
* `calories` - Az összetevő kalóriatartalma 100 grammra vetítve (int)
* `weight` - Az összetevő mennyisége grammban (int)


**Értékek validálása:**

Az összetevő kalóriatartalma és súlya **nem lehet negatív**. Ha negatív értéket adnak meg, állítsd 0-ra.
Egy receptnek legalább egy összetevőt tartalmaznia kell.

**Metódusok:**

Implementálja az alábbi metódusokat a `Recipe` osztályba.

- `public int calculateTotalCalories()`
Számolja ki a recept összes kalóriatartalmát az alábbi képlet szerint:
**Összes kalória = Σ (összetevő kalóriája * összetevő súlya / 100)**.
- `public int calculateCaloriesPerServing()`
Ossza el a recept teljes kalóriatartalmát az adagok számával.


Jelenleg nem minden teszt eset fut le sikeresen. Javítsa a hibás teszteket és tesztelje a három új metódust.

### 3. Feladat - Java kollekciók:

A `java_collections` package-ben található `Pokedex` osztály befejezése lesz a feladatod.
Az osztály a méltán híres Pokémon nyilvántartó rendszer, amiben különböző lekérdezések vannak, ami alapján szűrni lehet a
pokémonokat. Az előző fejlesztő nem tudta befejezni az összes lekérdezést, ezeknek a pótlása a te feladatod lesz és a
tesztelő csapat szerint a jelenlegi lekérdezések közül nem működik az összes az elvárás szerint.

A `tests` package-ben
található `PokedexTest` teszt esetek találsz, amik az elvárt működés szerint vizsgálják a metódusokat.
A feladatod a teszt esetek mentén javítani a jelenlegi lekérdezéseket, valamint a három befejezetlen metódus
implementálása

- `getAllPokemonWithoutSecondType`: Visszaadja az összes olyan pokémont, amelynek nincs második típusa.
- `getAllPokemonByMainType` : Visszaadja az összes olyan pokémont, amelynek első típusa megegyezik a megadott típussal.
- `getAllPokemonGroupedByMainType` : Visszaadja az összes pokémont csoportosítva az első típusuk szerint.

a `Pokedex` osztályban. A három új metódus tesztelése is a te feladatod lesz.

### Feladat 4 - Java io:

A feladatod a `amazon_books.csv` fáljban lévő adatok beolvasása. A beolvasáshoz használd a `BookReader` osztály
`readBooksFromCsv` metódusát. A fájl feldolgozása során az adatokból `Book` objektumokat kell létrehoznod, majd egy
listával
visszatérni ami az összes beolvasot sort tartalmazza.

```text
Name;Author;User Rating;Reviews;Price;Year;Genre
10-Day Green Smoothie Cleanse;JJ Smith;4.7;17350;8;2016;Non Fiction
11/22/63: A Novel;Stephen King;4.6;2052;22;2011;Fiction
12 Rules for Life: An Antidote to Chaos;Jordan B. Peterson;4.7;18979;15;2018;Non Fiction
1984 (Signet Classics);George Orwell;4.7;21424;6;2017;Fiction
5,000 Awesome Facts (About Everything!) (National Geographic Kids);National Geographic Kids;4.8;7665;12;2019;Non Fiction
A Dance with Dragons (A Song of Ice and Fire);George R. R. Martin;4.4;12643;11;2011;Fiction
A Game of Thrones / A Clash of Kings / A Storm of Swords / A Feast of Crows / A Dance with Dragons;George R. R. Martin;4.7;19735;30;2014;Fiction
A Gentleman in Moscow: A Novel;Amor Towles;4.7;19699;15;2017;Fiction
A Higher Loyalty: Truth, Lies, and Leadership;James Comey;4.7;5983;3;2018;Non Fiction
A Man Called Ove: A Novel;Fredrik Backman;4.6;23848;8;2016;Fiction
A Man Called Ove: A Novel;Fredrik Backman;4.6;23848;8;2017;Fiction
A Patriot's History of the United States: From Columbus's Great Discovery to the War on Terror;Larry Schweikart;4.6;460;2;2010;Non Fiction
A Stolen Life: A Memoir;Jaycee Dugard;4.6;4149;32;2011;Non Fiction
A Wrinkle in Time (Time Quintet);Madeleine L'Engle;4.5;5153;5;2018;Fiction
Act Like a Lady, Think Like a Man: What Men Really Think About Love, Relationships, Intimacy, and Commitment;Steve Harvey;4.6;5013;17;2009;Non Fiction
Adult Coloring Book Designs: Stress Relief Coloring Book: Garden Designs, Mandalas, Animals, and Paisley Patterns;Adult Coloring Book Designs;4.5;2313;4;2016;Non Fiction
Adult Coloring Book: Stress Relieving Animal Designs;Blue Star Coloring;4.6;2925;6;2015;Non Fiction
Adult Coloring Book: Stress Relieving Patterns;Blue Star Coloring;4.4;2951;6;2015;Non Fiction
Adult Coloring Books: A Coloring Book for Adults Featuring Mandalas and Henna Inspired Flowers, Animals, and Paisley…;Coloring Books for Adults;4.5;2426;8;2015;Non Fiction
Alexander Hamilton;Ron Chernow;4.8;9198;13;2016;Non Fiction
```

A feladatod a `readBooksFromCsv ` metódus implementálása. A sikeres implementálás után a `PeopleReaderTest` -ben
található
metódusok sikeresen le fognak futni.
A `bookReadTest_5` metódusban teszteld, hogy `248` különböző író található a csv-ben.

### Feladat 5 - Java adatbázis:

A feladatod a Pokédex pokémon nyilvántartó rendszerének befejezése lesz.
Hozz létre egy adatbázist és csatlakozz hozzá a `Database` osztályban található `createConnection` metódus megfelelő
paraméterezésével.

A PgAdmin felületen futtasd az alábbi SQL-t, hogy létrehozd a táblákat és beszúrd a kezdő adatokat.

```sql
CREATE TABLE POKEMON
(
    pokemon_id        serial PRIMARY KEY,
    pokemon_name      TEXT,
    pokemon_type      TEXT,
    pokemon_hp        INT,
    pokemon_attack    INT,
    pokemon_defense   INT,
    pokemon_speed     INT,
    pokemon_legendary BOOL
);
INSERT INTO POKEMON(pokemon_name, pokemon_type, pokemon_hp, pokemon_attack, pokemon_defense,
                    pokemon_speed, pokemon_legendary)
VALUES ('Bulbasaur', 'Grass', 45, 49, 49, 45, FALSE),
       ('Ivysaur', 'Grass', 60, 62, 63, 60, FALSE),
       ('Venusaur', 'Grass', 80, 82, 83, 80, FALSE),
       ('VenusaurMega Venusaur', 'Grass', 80, 100, 123, 80, FALSE),
       ('Charmander', 'Fire', 39, 52, 43, 65, FALSE),
       ('Charmeleon', 'Fire', 58, 64, 58, 80, FALSE),
       ('Charizard', 'Fire', 78, 84, 78, 100, FALSE),
       ('CharizardMega Charizard X', 'Fire', 78, 130, 111, 100, FALSE),
       ('CharizardMega Charizard Y', 'Fire', 78, 104, 78, 100, FALSE),
       ('Squirtle', 'Water', 44, 48, 65, 43, FALSE),
       ('Wartortle', 'Water', 59, 63, 80, 58, FALSE),
       ('Blastoise', 'Water', 79, 83, 100, 78, FALSE),
       ('BlastoiseMega Blastoise', 'Water', 79, 103, 120, 78, FALSE),
       ('Caterpie', 'Bug', 45, 30, 35, 45, FALSE),
       ('Metapod', 'Bug', 50, 20, 55, 30, FALSE),
       ('Butterfree', 'Bug', 60, 45, 50, 70, FALSE),
       ('Weedle', 'Bug', 40, 35, 30, 50, FALSE),
       ('Kakuna', 'Bug', 45, 25, 50, 35, FALSE),
       ('Beedrill', 'Bug', 65, 90, 40, 75, FALSE),
       ('BeedrillMega Beedrill', 'Bug', 65, 150, 40, 145, FALSE),
       ('Pidgey', 'Normal', 40, 45, 40, 56, FALSE),
       ('Pidgeotto', 'Normal', 63, 60, 55, 71, FALSE),
       ('Pidgeot', 'Normal', 83, 80, 75, 101, FALSE),
       ('PidgeotMega Pidgeot', 'Normal', 83, 80, 80, 121, FALSE),
       ('Rattata', 'Normal', 30, 56, 35, 72, FALSE),
       ('Raticate', 'Normal', 55, 81, 60, 97, FALSE),
       ('Spearow', 'Normal', 40, 60, 30, 70, FALSE),
       ('Fearow', 'Normal', 65, 90, 65, 100, FALSE),
       ('Ekans', 'Poison', 35, 60, 44, 55, FALSE),
       ('Arbok', 'Poison', 60, 85, 69, 80, FALSE),
       ('Pikachu', 'Electric', 35, 55, 40, 90, FALSE),
       ('Raichu', 'Electric', 60, 90, 55, 110, FALSE),
       ('Sandshrew', 'Ground', 50, 75, 85, 40, FALSE),
       ('Sandslash', 'Ground', 75, 100, 110, 65, FALSE),
       ('Nidoran', 'Poison', 55, 47, 52, 41, FALSE),
       ('Nidorina', 'Poison', 70, 62, 67, 56, FALSE),
       ('Nidoqueen', 'Poison', 90, 92, 87, 76, FALSE),
       ('Nidoran', 'Poison', 46, 57, 40, 50, FALSE),
       ('Nidorino', 'Poison', 61, 72, 57, 65, FALSE);

```

A feladatod, befejezni az alkalmazást.

- Az `Pokedex` osztály tartalmaz egy grafikus felületet, de jelenleg az `Add Pokemon` gomb nem működik.
    - Találsz egy `addPokemon(PokemonDao pokemon)` a `Pokedex` osztályban. A gomb megnyomására hozz létre egy `Dialog`-t amin a
      felhasználó fel tudja vinni az új pokémon adatait és az `Ok` gomb lenyomására az új szoba szúrodjon be az adatbázisba.
    - Old meg, hogy a táblázat frissüljön az új pokémon adataival.