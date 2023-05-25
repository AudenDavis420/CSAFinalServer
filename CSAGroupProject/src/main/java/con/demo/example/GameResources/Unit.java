package con.demo.example.GameResources;

//@Author Dhruv

public class Unit 
{
    private int team;
    private String type;
    private String attackType;
    private int health;
    private float range;
    private int damage;
    private int wallDamage;
    private int attacksLeft;
    
    
    private float mobility; 

    public int getTeam(){return team;}
    public void setTeam(int Team){team = Team;}

    public String getType(){return type;}
    public void setType(String Type){type = Type;}

    public String getAttackType(){return attackType;}
    public void setAttackType(String AttackType){attackType = AttackType;}

    public int getHealth(){return health;}
    public void setHealth(int Health){health = Health;}

    public float getRange(){return range;}
    public void setRange(float Range){range = Range;}

    public int getDamage(){return damage;}
    public void setDamage(int Damage){damage = Damage;}

    public float getMobility(){return mobility;}
    public void setMobility(float Mobility){mobility = Mobility;}

    public int getWallDamage(){return wallDamage;}
    public void setWallDamage(int WallDamage){wallDamage = WallDamage;}

    public int getAttacksLeft(){return attacksLeft;}
    public void setAttacksLeft(int AttacksLeft){attacksLeft = AttacksLeft;}

    public Unit(int Team, String Type, String AttackType, int Health, float Range, int Damage, float Mobility, int WallDamage, int AttacksLeft)
    {
        team = Team;
        type = Type;
        attackType = AttackType;
        health = Health;
        range = Range;
        damage = Damage;
        mobility = Mobility;
        wallDamage = WallDamage;
        attackType = AttackType;
    }

    public String toString()
    {
        return type + ":\n     team: " + team + ":\n     Attack Type: " + attackType + "\n     health: " + health + "\n     Range: " + range + "\n     Damage: " + damage+ "\n     Mobility: " + mobility + "\n     Wall Damage: " + wallDamage  + "\n     Attacks Left: " + attacksLeft;
    }
}
