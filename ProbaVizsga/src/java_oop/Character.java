package java_oop;

import java.util.Set;

public class Character {

    private final int strength;
    private final int dexterity;
    private final int intelligence;

    private final Set<Item> items;

    public Character(int strength, int dexterity, int intelligence, Set<Item> items) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.items = items;
    }

    public double doAttack() {
        return strength + items.stream()
                .filter(item -> item.getDexterityRequirements() >= dexterity)
                .mapToDouble(item -> item.getStrengthBonus() * (1.0 * dexterity / item.getDexterityRequirements()))
                .sum();
    }

    public double doMagic() {
        throw new UnsupportedOperationException();
    }
}
