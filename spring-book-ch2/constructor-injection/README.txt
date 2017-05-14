Spike che istanzia lo Spring Container e lo va a configurare utilizzando la XML‐Based Configuration
rispetto agli esempi precedenti la DI è stata applicata sfruttando il Costructor Injectin.

- Da notare inoltre la creazione dei vari BEANS uno per i diversi costruttori richiamati nelle diverse
  modalità e in particolare la modalità con cui si riesce ad aiutare Spring quale dei 2 costruttori
  scegliere (classi Foo, Bar, Baz)

-  One disadvantage of constructor injection is that it cannot handle circular dependencies. If, for
   example, you have two beans, a and b, and they both have dependencies to each other through their
   constructors, the Spring Container is not able to instantiate those two beans (classi A,B)

(utilizzo del XML java ch2-beans.xml)