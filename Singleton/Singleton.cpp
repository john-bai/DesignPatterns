/*
 *  Singleton.cpp
 *  DesignPatterns
 *
 *  Created by John Therrell on 1/30/11.
 *  Copyright 2011 __MyCompanyName__. All rights reserved.
 *
 */

#include "Singleton.h"

Singleton* Singleton::s_instance = 0;

Singleton::Singleton() {
    foo = 0;
}

Singleton* Singleton::getInstance () {
    if (!s_instance) {
        s_instance = new Singleton;
    }
    return Singleton::s_instance;
}

void Singleton::addToFoo(int num) {
    foo += num;
}

int Singleton::getFoo() {
    return foo;
}