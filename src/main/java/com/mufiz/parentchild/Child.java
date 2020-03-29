package com.mufiz.parentchild;

/**
 * 1. If you don't provide any constructor, implicit no-arg constructor is inserted.
 * 2. If you provide custom constructor (say with some args), then the jvm would not provide the default constructor.
 * 3. Whenever you instantiate a child, the parent is instantiated first and then the child is instantiated.
 *    In short, there is an implicit call of super() from the child constructor.
 * 4. if you explicitly make no-arg constructor as private, then child will throw error as it can't access the
 *    default constructor.
 * 5. However, if you provide another parent constructor (with some args), and the child constructor makes a call to the
 *    customer constructor, then there will not be any error and the child can be instantiated.
 */
public class Child extends Parent {
    protected String childName = "child name";

    public Child(){
        super("some");
    }
    public static void main(String[] args) {
        Child c = new Child();
        System.out.println(c.name);
        System.out.println(c.childName);
    }
}
