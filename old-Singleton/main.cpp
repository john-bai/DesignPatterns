#include <iostream>
#include "Singleton.h"
using namespace std;

int main (int argc, char * const argv[]) {
    Singleton* var1 = Singleton::getInstance();
    Singleton* var2 = Singleton::getInstance();
    cout << "var1 and var2 both refer to one single instance of the Singleton class" << endl;
    var1->addToFoo(1);
    cout << "var1 added 1 to foo..." << endl;
    cout << "var1->getFoo() = " << var1->getFoo() << endl;
    cout << "var2->getFoo() = " << var2->getFoo() << endl << endl;
    var2->addToFoo(10);
    cout << "var2 added 10 to foo..." << endl;
    cout << "var1->getFoo() = " << var1->getFoo() << endl;
    cout << "var2->getFoo() = " << var2->getFoo() << endl;
    return 0;
}
