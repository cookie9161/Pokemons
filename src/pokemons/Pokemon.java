package pokemons;


import RNG.Rng;

public class Pokemon {
    private final String name;
    private final ElementsType type;
    private Integer hp;
    private Integer baseAttackPower;
    private Integer experience;

    public Pokemon(String name, ElementsType type, Integer hp, Integer baseAttackPower) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.baseAttackPower = baseAttackPower;
        this.experience = 0;
    }

    private void attack(Attack chosenAttack, Pokemon target, int baseDamage) {
        int damage = getStrongWeakBonus(chosenAttack.getType(), target.getType(), baseDamage);

        int interval = (int) (damage * 0.15);

        damage = Rng.getARoll(damage - interval, damage + interval);

        target.setHp(Math.max(target.getHp() - damage, 0));
    }

    private int getStrongWeakBonus(ElementsType attackType, ElementsType targetPokemonType, int baseDamage) {
        if (this.type.isWeakAgainst(targetPokemonType) || attackType.isWeakAgainst(targetPokemonType)) {
            return (int) (baseDamage * 0.5);
        } else if (this.type.isStrongAgainst(targetPokemonType) || attackType.isStrongAgainst(targetPokemonType)) {
            return (int) (baseDamage * 1.5);
        }
        return baseDamage;
    }

    public void attack(Attack chosenAttack, Pokemon target) {
        attack(chosenAttack, target, this.baseAttackPower);
    }

    public void heal(int healAmount) {
        this.setHp(Math.min(this.hp + healAmount, 100));
    }

    public String getName() {
        return name;
    }

    public ElementsType getType() {
        return type;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getBaseAttackPower() {
        return baseAttackPower;
    }

    public void setBaseAttackPower(Integer baseAttackPower) {
        this.baseAttackPower = baseAttackPower;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }
}