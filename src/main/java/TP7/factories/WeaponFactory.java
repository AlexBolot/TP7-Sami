package TP7.factories;

import TP7.factories.types.ImprovementType;
import TP7.factories.types.WeaponType;
import TP7.weapons.Dager;
import TP7.weapons.Shield;
import TP7.weapons.Sword;
import TP7.weapons.Weapon;
import TP7.weapons.improvements.BuffedWeapon;
import TP7.weapons.improvements.EnchantedWeapon;
import TP7.weapons.improvements.NamedWeapon;

import java.util.HashMap;

/*................................................................................................................................
 . Copyright (c)
 .
 . The WeaponFactory	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 18:36
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings({"SameParameterValue", "WeakerAccess"})
public class WeaponFactory {
    private HashMap<String, Weapon> namedWeapons = new HashMap<>();

    public Weapon createWeapon(WeaponType weaponType) {
        switch (weaponType) {
            case SWORD:
                return new Sword();

            case DAGER:
                return new Dager();

            case SHIELD:
                return new Shield();

            default:
                return null;
        }
    }

    public Weapon createWeapon(WeaponType weaponType, String weaponName) {
        switch (weaponType) {
            case SWORD:
                Weapon sword = new Sword();

                if (weaponName != null) {
                    sword = new NamedWeapon(sword, weaponName);
                    namedWeapons.put(weaponName, sword);
                }

                return sword;

            case DAGER:
                Weapon dager = new Dager();

                if (weaponName != null) {
                    dager = new NamedWeapon(dager, weaponName);
                    namedWeapons.put(weaponName, dager);
                }

                return dager;

            case SHIELD:
                Weapon shield = new Shield();

                if (weaponName != null) {
                    shield = new NamedWeapon(shield, weaponName);
                    namedWeapons.put(weaponName, shield);
                }

                return shield;

            default:
                return null;
        }
    }

    public Weapon improve(ImprovementType improvementType, String weaponName, int coeficient) {
        switch (improvementType) {
            case BUFF:
                Weapon weaponToBuff = namedWeapons.get(weaponName);
                weaponToBuff = new BuffedWeapon(weaponToBuff, coeficient);
                namedWeapons.replace(weaponName, weaponToBuff);

                return weaponToBuff;

            case ENCHANT:
                Weapon weaponToEnchant = namedWeapons.get(weaponName);
                weaponToEnchant = new EnchantedWeapon(weaponToEnchant, coeficient);
                namedWeapons.replace(weaponName, weaponToEnchant);

                return weaponToEnchant;

            default:
                return null;
        }
    }

    public Weapon improve(ImprovementType improvementType, Weapon weapon, int coeficient) {
        switch (improvementType) {
            case BUFF:
                return new BuffedWeapon(weapon, coeficient);

            case ENCHANT:
                return new EnchantedWeapon(weapon, coeficient);

            default:
                return null;
        }
    }

    public Weapon name(Weapon weapon, String weaponName) {
        namedWeapons.put(weaponName, weapon);
        return new NamedWeapon(weapon, weaponName);
    }

    public Weapon rename(String OldName, String NewName) {
        Weapon weaponToRename = namedWeapons.get(OldName);
        weaponToRename = new NamedWeapon(weaponToRename, NewName);
        namedWeapons.remove(OldName);
        namedWeapons.put(NewName, weaponToRename);

        return weaponToRename;
    }
}