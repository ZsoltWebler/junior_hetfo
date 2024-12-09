package java_oop;

import java.util.Objects;

public class Item {

    private final int strengthBonus;
    private final int intelligenceBonus;
    private final int dexterityRequirements;


    public Item(int strengthBonus, int intelligenceBonus, int dexterityRequirements) {
        this.strengthBonus = strengthBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.dexterityRequirements = dexterityRequirements;
    }

    public int getStrengthBonus() {
        return strengthBonus;
    }

    public int getIntelligenceBonus() {
        return intelligenceBonus;
    }

    public int getDexterityRequirements() {
        return dexterityRequirements;
    }

    @Override
    public String toString() {
        return "Item{" +
                "strengthBonus=" + strengthBonus +
                ", intelligenceBonus=" + intelligenceBonus +
                ", dexterityRequirements=" + dexterityRequirements +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return strengthBonus == item.strengthBonus && intelligenceBonus == item.intelligenceBonus && dexterityRequirements == item.dexterityRequirements;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strengthBonus, intelligenceBonus, dexterityRequirements);
    }
}
