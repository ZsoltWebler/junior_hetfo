# Junior Java Backend fejlesztő tanfolyam

## Vizsga

### 1. Feladat - Java programozási nyelv alapjai:

A `java_basics` package-ben található timestamp generáló alkalmazást kell folytatnia a következő szempontok
figyelembevételével.

- A jelenlegi implementáció az időbélyegzőt az év, hónap és nap alapján állítja elő.
- A hónapnak 1 és 12, a napnak pedig 1 és 31 között kell lennie. A 31 napnál rövidebb hónapokkal nem kell foglalkozni.
- A megrendelő szeretné, ha a elkészülne egy új metódus is, azonos névvel de más paraméterlistával, ami az óra és a
  percet is figyelembe veszi a timestamp generálása során.
- Az új óra és perc lehetséges értékeinek a vizsgálata is az ön feladata.

Javítsa ki az elkészült alkalmazást, hogy a teszt esetek sikeresen lefussanak, készítse el az új metódust majd készítsen
hozzá legalább kettő teszt esetet.

### 2. Feladat - Java objektumorientált programozás:

A `java_oop` package-ben található alkalmazott fizetés nyilvántartó alkalmazást kell folytatnia a következő szempontok
figyelembevételével.

A vállalat a bérkorrekció jegyében szeretné megemelni mindenkinek a fizetését, attól függően, hogy mikor történt a
legutóbbi fizetésemelés és milyen a dolgozó teljesítménye. A feladatok az alkalmazás befejezése és javítása az alábbi
szempontok figyelembevételével.

- Egy alkalmazott teljesítménye 1 és 10 között vehet fel értékeket, ha ezen kívül adnak meg értéket, akkor 1 alatt 1-re,
  10 fölött pedig 10 -re kell állítani az értéket.
- A javasolt új fizetést az alábbi képlet adja:
  `alapfizetés*(1+(teljesitmeny/100))^legutóbbi_fizetés_emelés_óta_eltelt_évek_száma` vagyis, ha egy dolgozó
  alapfizetése 10 000 a teljesítménye 6 és 4 éve nem kapott fizetést, akkor a javasolt új
  fizetés: `10 000*(1+6/100)^4 = 12624.7696`

Javítsa ki az elkészült alkalmazást, hogy a teszt esetek sikeresen lefussanak, készítse el az új metódust majd készítsen
hozzá legalább kettő teszt esetet.

### 3. Feladat - Java kollekciók:

A `java_collections` package-ben található számítógépes játék nyilvántartó rendszert kell folytatnia a következő
szempontok
figyelembevételével.

- Vizsgálja meg az alkalmazást és tekintse meg a felhasznált osztályokat.
- A `GameShop` osztályban található lekérdezések közül, nem lett mind befejezve. Ezen metódusok implementálása az ön
  feladata lesz.
    - `gamesByGenre` : Térjen vissza a játékokkal csoportosítva a múfaj alapján.
    - `averagePriceOfGames` : Térjen vissza az üzletben található játékok átlag árával
    - `mostReviewedGame` : Térjen vissza azzal a játékkal, ami a legtöbb review-t kapta.
- Az új metódusok átható tesztelése is az ön feladata lesz.
- A `GameShopTest` osztályban található tesztesetek közül nem fut le mind sikeresen. Keresse meg a hiba okát és javítsa
  az almalmazást, amíg a tesztesetek sikeresen le nem futnak.

### Feladat 4 - Java io:

A `java_io` package-ben található használt autó kezelő alkalmazást kell folytatnia a következő szempontok
figyelembevételével.

```text
name,year,selling_price,km_driven,fuel,seller_type,transmission,owner
Maruti 800 AC,2007,60000,70000,Petrol,Individual,Manual,First Owner
Maruti Wagon R LXI Minor,2007,135000,50000,Petrol,Individual,Manual,First Owner
Hyundai Verna 1.6 SX,2012,600000,100000,Diesel,Individual,Manual,First Owner
Datsun RediGO T Option,2017,250000,46000,Petrol,Individual,Manual,First Owner
```

> A feldolgozás során, nem kell az összes oszlopot felhasználni!

- Olvassa be az cars.csv fáljban található adatokat az `CarReader` osztály felhasználásával.
- Valósítsa meg a `readCarsFromCSV` metódust, ami `Car` objektumok listájával tér vissza.
- Készítsen 3 új tesztesetet:
    - Ellenőrizze, az autók átlag ára kerekítve 504127.
    - Ellenőrizze, hogy:
        - 2123 - petrol típusú autó van
        - 2153 - diesel típusú autó van
        - 40 - cng típusú autó van
        - 23 - lpg típusú autó van
        - 1 - electric típusú autó van
    - Ellenőrizze, hogy 2020-as a legújabb autó és 1992-es a legrégebbi autó.

### Feladat 5 - Java adatbázis:

A `java_database` package-ben található Airbnb alkalmazást kell folytatnia. Hozz létre egy adatbázist és csatlakozz
hozzá a `Database` osztályban található `createConnection` metódus megfelelő paraméterezésével.

A PgAdmin felületen futtasd az alábbi SQL-t, hogy létrehozd a táblákat és beszúrd a kezdő adatokat.

```sql
CREATE TABLE IF NOT EXISTS apartment
(
    apartment_id       serial PRIMARY KEY,
    apartment_city     VARCHAR NOT NULL,
    apartment_address  VARCHAR NOT NULL,
    apartment_area     REAL    NOT NULL,
    apartment_price    INT     NOT NULL,
    apartment_reserved BOOL    NOT NULL
);

INSERT INTO apartment(apartment_city, apartment_address, apartment_area, apartment_price, apartment_reserved)
VALUES ('Szeged', 'Kárász utca 37', 60, 7000, FALSE),
       ('Szeged', 'Zárda utca 4', 56, 4000, FALSE),
       ('Budapest', 'Váci út 11', 23, 17000, TRUE),
       ('Budapest', 'Hengerhalom út 30', 80, 23000, TRUE),
       ('Kecskemét', 'Izsáki út 12', 35, 5000, FALSE);
```

A feladatod, befejezni az alkalmazást az alábbi szempontok figyelembevételével:

- Az `Airbnb` osztály tartalmaz egy grafikus felületet, de jelenleg az `Add apartment` gomb nem működik.
    - Találsz egy `addApartment(ApartmentDao apartment)` metódust a `Airbnb` osztályban. A gomb megnyomására hozz létre
      egy `Dialog`-t
      amin a felhasználó fel tudja vinni az új apartman adatait és az **Ok** gomb lenyomására az új szoba szúrodjon be
      az
      adatbázisba.
    - Oldd meg, hogy a táblázat frissüljön az új apartman adataival, minden beszúrás után.

