#include <iostream>

using namespace std;

class Cat
{
public:
    string Name;

    Cat()
    {
        Name = "Default_Cat";
    }

    Cat(string iName)
    {
        Name = iName;
    }

private:


    int age = 0;
    int wieght = 10;
    float height = 3.14f;

};

class Dog
{
public:
    string Bark;

    Dog()
    {
        Bark = "Woof";
    }

};

int main()
{

    Cat FirstCat("Tori");
    Cat SecondCat("Chell");

    cout << FirstCat.Name << endl;
    cout << SecondCat.Name << endl;

    Dog GoodBoi;

    cout << GoodBoi.Bark << endl;



    return 0;
}
