#include <iostream>

using namespace std;

class Cat
{
public :
    Cat(string Name, string MeowType)
    {
        mName = Name;
        mMeow = MeowType;
    }


    void Meow()
    {
        cout << mMeow << endl;
    }

    string GetName()
    {
        return mName;
    }

    string mName;
    string mMeow;

private:

};

int main()
{
    Cat myCuteCat("Guapo", "Miau");
    Cat myUglyCat("Poopycle", "Mrow");
    Cat mySmallCat("Poopycle", "Purr");

    myCuteCat.Meow();

    cout << myUglyCat.GetName() << " " << myUglyCat.Cat() << endl;

    mySmallCat.Meow()

    return 0;
}
