#include <iostream>

using namespace std;

class Human
{
public:
    Human(int Age)
    {
        age = Age;
    }

    void Think()
    {
        if(GetInteligenceLevel())
        {
            Smile();
        }
        else
        {
            Laugh();
        }
    }

private:

    int age;

    int GetInteligenceLevel()
    {
        if(GetAge() >= 18 && HappyLevel() > 3.5f)
        {
            return 17;
        }
        else if(HappyLevel() < 3.2f)
        {
            return 100;
        }
        else
        {
            return -1;
        }
    }

    int GetAge()
    {
        return age;
    }

    void Smile()
    {
        cout << ":D" << endl;
    }

    void Laugh()
    {
        cout << "hahahaha " << endl;
    }

    float HappyLevel()
    {
        return 4.5f;
    }

};

int main()
{
    Human Bob(16);
    Bob.Think();

    return 0;
}
