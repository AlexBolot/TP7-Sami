package TP7.Factories;

import TP7.Factories.Types.ImprovementType;
import TP7.Factories.Types.WeaponType;
import TP7.Weapon.Weapon;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*................................................................................................................................
 . Copyright (c)
 .
 . The WeaponFactoryTest	 Class was Coded by :
 . -> Alexandre BOLOT
 . -> Christopher SABOYA
 .
 . Last Modified : 30/01/17 16:30
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class WeaponFactoryTest
{
    @SuppressWarnings("FieldCanBeLocal")
    private final float delta = 0.001f;
    
    @SuppressWarnings("UnusedAssignment")
    @Test
    public void CreateAndImprove () throws Exception
    {
        WeaponFactory wf = new WeaponFactory();
        
        Weapon weapon = wf.createWeapon(WeaponType.SWORD);
        
        weapon = wf.improve(ImprovementType.BUFF, weapon, 5);
        
        assertEquals(30, weapon.getPower(), delta);
        assertEquals(10, weapon.getProtection(), delta);
        
        weapon = wf.improve(ImprovementType.ENCHANT, weapon, 10);
        
        assertEquals(300, weapon.getPower(), delta);
        assertEquals(100, weapon.getProtection(), delta);
    }
    
    @SuppressWarnings("UnusedAssignment")
    @Test
    public void CreateWithNameAndImprove () throws Exception
    {
        WeaponFactory wf = new WeaponFactory();
        
        Weapon w = wf.createWeapon(WeaponType.SWORD, "excalibur");
        
        w = wf.improve(ImprovementType.BUFF, "excalibur", 5);
        
        assertEquals(30, w.getPower(), delta);
        assertEquals(10, w.getProtection(), delta);
        
        w = wf.improve(ImprovementType.ENCHANT, "excalibur", 10);
        
        assertEquals(300, w.getPower(), delta);
        assertEquals(100, w.getProtection(), delta);
    }
}