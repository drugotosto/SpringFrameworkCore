package animali;

/**
 * Created by drugo on 14/05/2017.
 */

/*
 Java permits an object of a subclass type to be treated as an object of any superclass type.
 This is called upcasting. Upcasting is done automatically, while downcasting must be manually done
 by the programmer.
 Upcasting is casting to a supertype, while downcasting is casting to a subtype.
 Upcasting is always allowed, but downcasting involves a type check and can throw a ClassCastException
 */

class Animal
{
    void callme()
    {
        System.out.println("In callme of Animal");
    }
}


class Dog extends Animal
{
    void callme()
    {
        System.out.println("In callme of Dog");
    }

    void callme2()
    {
        System.out.println("In callme2 of Dog");
    }
}

public class UseAnimals
{
    public static void main (String [] args)
    {
        Dog d = new Dog();
        /*
        Si effettua l'Upcasting. In realtà non ci sarebbe neanche necessità di farlo esplicitamente.
        Seppur il riferimento è verso un oggetto CANE il compilatore eseguira i controlli come se fosse un oggetto ANIMAL
        */
        Animal a = (Animal)d;
        d.callme();
        // Verrà eseguito ancora il metodo relativo a CANE seppur la variabile e di tipo ANIMAL
        a.callme();
        /*
        Si effettua il Downcast. Partendo da una variabile ANIMAL seppur l'oggetto in essa contenuto
        risulta essere del sottotipo CANE per risucire ad utilizzare il metodo "CALLME()" occorre
        effettuare esplicitamente il Downcast!
         */
        ((Dog) a).callme2();
    }
}
