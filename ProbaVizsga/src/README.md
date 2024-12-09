# Junior Java Backend fejlesztő tanfolyam

## Vizsga

### 1. Feladat - Java programozási nyelv alapjai:

A `java_basics` package-ben található titkosító alkalmazást kell folytatnia a következő szempontok
figyelembevételével.

- Jelenleg a titkosító alkalmazás **[Caesar](https://hu.wikipedia.org/wiki/Caesar-rejtjel)** kódolást valósít meg
  azonban az implementáció hibás, ennek javítása lesz az első feladat.
- A megrendelő szeretné az **Atbash** kódolás megvalósítását. Az Atbash kódolás egy egyszerűen alkalmazható, klasszikus
  titkosítási módszer, amely egy olyan átalakítást alkalmaz, amelyben az ábécé betűit tükrözi vagy megfordítja. Például
  az angol ábécében az "A" betű az "Z"-re, a "B" a "Y"-ra, és így tovább.

**Csak az angol abc betűit kell kezelni!**

Javítsa ki az elkészült alkalmazást, hogy a teszt eset sikeresen lefusson, majd készítse el az új metódust majd
készítsen
hozzá legalább teszt esetet.

### 2. Feladat - Java objektumorientált programozás:

A `java_oop` package-ben található alkalmazást kell folytatnia a következő szempontok
figyelembevételével.

Az alkalmazás két osztályból áll:

A **Character** osztály egy szerepjátékos karaktert reprezentál a következő tulajdonságokkal.

- **strength**: A karakter erő pontjai.
- **dexterity**: A karakter ügyességi pontjai.
- **intelligence**: A karakter intelligencia pontjai.
- **items**: A karakternél található eszközök halmaza.

Az **Item** osztály egy tárgyat reprezentál, amik módosítják a karakter tulajdonságpontjait.

- **strengthBonus** : A tárgy használata ennyi bónusz erőt ad a karakternek.
- **intelligenceBonus** : A tárgy használata ennyi bónusz intelligenciát ad a karakternek.
- **dexterityRequirements** : Ennyi ügyességi pont kell a tárgy használatához.

A **Character** osztály két metódussal rendelkezik:

- **doAttack** : Visszatér a karakter fizikai sebzésének az értékével. A sebzés a következőképp számolódik, minden olyan
  a karakternél lévő tárgynak aminek a **dexterityRequirements** -e kissebb vagy egyenlő mint a karakter **dexterity**
  értéke a **strengthBonus** értékének a **dexterity** / **dexterityRequirements** szorosa hozzáadódik a karakter alap
  **strength** értékéhez. Vagyis, ha a karakternek az alap **strength** értéke 8 a **dexterity** értéke pedig 10 és
  van nála egy tárgy, aminek a **strengthBonus** értéke 20 a **dexterityRequirements** értéke pedig 5, akkor a sebzés a
  következőképpen alakul. 8 + 20 * (10/5) = 48.

- **doMagic** : Visszatér a karakter mágikus sebzésének az értékével. A sebzés a következőképp számolódik, minden olyan
  a karakternél lévő tárgynak aminek a **dexterityRequirements** -e kissebb vagy egyenlő mint a karakter **dexterity**
  értéke a **intelligenceBonus** értékének a **dexterity** / **dexterityRequirements** szorosa hozzáadódik a karakter
  alap
  **intelligence** értékéhez. Vagyis, ha a karakternek az alap **intelligence** értéke 8 a **dexterity** értéke pedig 10
  és
  van nála egy tárgy, aminek a **intelligenceBonus** értéke 20 a **dexterityRequirements** értéke pedig 5, akkor a
  sebzés a
  következőképpen alakul. 8 + 20 * (10/5) = 48.

  Ha az eszköz **dexterityRequirements** nagyobb mint a karakter dexterity értéke akkor a tárgy értéke kivónodik és nem
  hozzáadódik az sebzéshez.

### 3. Feladat - Java kollekciók:

A `java_collections` package-ben található számítógépes játék nyilvántartó rendszert kell folytatnia a következő
szempontok
figyelembevételével.

- Vizsgálja meg az alkalmazást és tekintse meg a felhasznált osztályokat.
- A `GameShop` osztályban található lekérdezések közül, nem lett mind befejezve. Ezen metódusok implementálása az ön
  feladata lesz.
    - `gamesByDeveloper` : Térjen vissza a játékokkal csoportosítva a játékfejlesztő alapján.
    - `medianPriceOfGames` : Térjen vissza az üzletben található játékok medián árával
    - `minPriceGame` : Térjen vissza azzal a játékkal, ami a legkevesebbe kerül.
- Az új metódusok átható tesztelése is az ön feladata lesz.
- A `GameShopTest` osztályban található tesztesetek közül nem fut le mind sikeresen. Keresse meg a hiba okát és javítsa
  az almalmazást, amíg a tesztesetek sikeresen le nem futnak.

### Feladat 4 - Java io:

A `java_io` package-ben található bűnügy nyilvántartó alkalmazást kell folytatnia a következő szempontok
figyelembevételével.

```text
,crime,number,date,location,beat,neighborhood,npu,lat,long
0,LARCENY-NON VEHICLE,103040029,10/31/2010,610 SPRING ST NW,509,Downtown,M,33.77101,-84.38895
1,AUTO THEFT,103040061,10/31/2010,850 OAK ST SW,401,West End,T,33.74057,-84.4168
2,LARCENY-FROM VEHICLE,103040169,10/31/2010,1344 METROPOLITAN PKWY SW,301,Capitol View Manor,X,33.71803,-84.40774
3,AUTO THEFT,103040174,10/31/2010,1752 PRYOR RD SW,307,Betmar LaVilla,Y,33.70731,-84.39674
```

> A feldolgozás során, nem kell az összes oszlopot felhasználni!

- Olvassa be az crimes.csv fáljban található adatokat az `CrimeReader` osztály felhasználásával.
- Valósítsa meg a `readCrimesFromCSV` metódust, ami `Crime` objektumok listájával tér vissza.
- Készítsen 3 új tesztesetet:
    - Ellenőrizze, hogy:
        - Polar Rock - neighborhoodban 75 bűneset történt.
        - Washington Park - neighborhoodban 128 bűneset történt.
        - Center Hill - neighborhoodban 280 bűneset történt.
    - Ellenőrizze, hogy a 210 es police beat egység kezelte a legtöbb bűnesetet.
    - Ellenőrizze, hogy a 3867 location-n történt 1-nél több bűneset.

### Feladat 5 - Java adatbázis:

A feladatod egy Hotel szobanyilvántartó rendszerének befejezése lesz.
Hozz létre egy adatbázist és csatlakozz hozzá a `Database` osztályban található `createConnection` metódus megfelelő
paraméterezésével.

A PgAdmin felületen futtasd az alábbi SQL-t, hogy létrehozd a táblákat és beszúrd a kezdő adatokat.

```sql
CREATE TABLE IF NOT EXISTS room_category (
	room_category_id serial PRIMARY KEY,
	room_category_name VARCHAR ( 50 ) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS room (
	room_id serial PRIMARY KEY,
	room_level INT NOT NULL,
	room_area REAL NOT NULL,
	room_price INT NOT NULL,
	room_reserved BOOL NOT NULL,
	room_on_sale BOOL NOT NULL,
	room_category_id INT NOT NULL,
	FOREIGN KEY (room_category_id)
		REFERENCES room_category (room_category_id)
);

INSERT INTO room_category(room_category_name) VALUES ('Economy'),('Default'),('Premium'),('Luxury');
INSERT INTO room(room_level,room_area,room_price,room_reserved,room_on_sale,room_category_id) VALUES
	(1,19.5,400,TRUE,FALSE,1),
	(1,20.5,450,FALSE,FALSE,1),
	(1,23.5,500,FALSE,FALSE,1),
	(1,25.5,475,TRUE,FALSE,1),
	(2,32.5,550,TRUE,TRUE,2),
	(2,43.5,600,TRUE,TRUE,2),
	(2,40.5,650,FALSE,TRUE,2),
	(3,60.5,700,TRUE,TRUE,3),
	(3,65.5,760,TRUE,FALSE,3),
	(3,70.0,800,FALSE,FALSE,3),
	(4,83.5,1400,TRUE,TRUE,4),
	(4,132.5,2400,FALSE,TRUE,4);
```

A feladatod, befejezni az alkalmazást.

- Javítsd ki a hibás teszt eseteket
- Az `Hotel` osztály tartalmaz egy grafikus felületet, de jelenleg az `Add Room` gomb nem működik.
    - Találsz egy `addRoom(RoomDao room)` a `Hotel` osztályban. A gomb megnyomására hozz létre egy `Dialog`-t amin a
      felhasználó fel tudja vinni az új szoba adatait és az Ok gomb lenyomására az új szoba szúrodjon be az adatbázisba.
    - Old meg, hogy a táblázat frissüljön az új szoba adataival.
- A `RoomDaoTest`-ben található teszt metódus nem fut le sikeresen. A teszt azt ellenőrzi, hogy a `getOnSalePrice`
  megfelelően működik-e. Ha a szoba akciós, akkor az `getOnSalePrice` metódusnak, a szoba árának 90%-val kell
  visszatérnie. Ha nem akciós, akkor pedig a rendes árral.
