#include <iostream>

using namespace std;

class Mage{
protected:
    int mana, hp, power;

    bool hasMana(){
        return mana > 0;
    }

public:
    Mage(int m = 10,int h = 100, int p = 1){
        mana = m;
        hp = h;
        power = p;
    }

    float Attack(){
        if(hasMana())
        {
            return power;
        }
        else
        {
            return 0;
        }
    }

    void DealDamage(float damage){
        hp -= damage;
    }

    int GetHp(){
        return hp;
    }
};

class NecroMancer : public Mage
{
public:

    NecroMancer(int m = 10,int h = 100, int p = 1):Mage(m,h,p){
        mana = 5;
        hp = h = 30;
        power = power + 3;
    }
};

class PyroMancer : public Mage
{
public:

    void DealDamage(float damage)
    {
        hp = hp - (damage - 3);
    }
};

int main()
{
    Mage* currentMage;

    NecroMancer EvilWizard;
    PyroMancer GoodWizard;

    currentMage = &EvilWizard;

    GoodWizard.DealDamage( currentMage->Attack() );
    currentMage->DealDamage(GoodWizard.Attack());

    currentMage = &GoodWizard;
    EvilWizard.DealDamage( currentMage->Attack() );
    currentMage->DealDamage(EvilWizard.Attack());

    cout << "Necromancer hp: " << EvilWizard.GetHp() << endl;
    cout << "Pyromancer hp: " << GoodWizard.GetHp() << endl;

    return 0;
}
