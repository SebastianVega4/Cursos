#include <iostream>

using namespace std;

int main()
{
    //Operadores de apuntadores.
    int playerID = 25;

    cout << playerID << endl;
    cout << &playerID << endl;

    int* playerReference;

    cout << playerReference << endl;
    playerReference = &playerID;

    cout << playerReference << endl;
    cout << *playerReference << endl;

    *playerReference = -1337;

    cout << playerID;

    //Memoria dinamica usando apuntadores. (Ejemplo en iPad)
    int* totalLifes;
    totalLifes = new int;

    cout << totalLifes << endl;
    cout << *totalLifes << endl;

    *totalLifes = 2039;
    cout << *totalLifes << endl;

    delete totalLifes;



    return 0;
}
