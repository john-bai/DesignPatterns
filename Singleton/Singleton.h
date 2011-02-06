/*
 *  Singleton.h
 *  DesignPatterns
 *
 *  Created by John Therrell on 1/30/11.
 *  Copyright 2011 __MyCompanyName__. All rights reserved.
 *
 */
class Singleton {
public:
    static Singleton* getInstance();
    void addToFoo(int);
    int getFoo();
protected:
    Singleton();
private:
    static Singleton* s_instance;
    int foo;
};