package java_database.model;

import java.util.Objects;

public class PokemonDao {

    private int id;
    private String name;
    private String type;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    private boolean legendary;

    public PokemonDao(String name, String type, int hp, int attack, int defense, int speed, boolean legendary) {

        this(0, name, type, hp, attack, defense, speed, legendary);
    }

    public PokemonDao(int id, String name, String type, int hp, int attack, int defense, int speed, boolean legendary) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.legendary = legendary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isLegendary() {
        return legendary;
    }

    @Override
    public String toString() {
        return "PokemonDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", speed=" + speed +
                ", legendary=" + legendary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonDao that = (PokemonDao) o;
        return id == that.id && hp == that.hp && attack == that.attack && defense == that.defense && speed == that.speed && legendary == that.legendary && Objects.equals(name, that.name) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, hp, attack, defense, speed, legendary);
    }
}
