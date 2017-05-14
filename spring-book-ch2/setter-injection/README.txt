Spike che istanzia lo Spring Container e lo va a configurare utilizzando la XML‐Based Configuration
rispetto agli esempi precedenti la DI è stata applicata sfruttando la Setter Injectin.

- Da notare come in questo caso la classe "AccountDaoInMemoryImpl" non abbia più la parte relativa a "Instance initializers"
  i 2 oggetti Account iniziali  sono stati trasformati anch'essi in beans attraverso la configurazione presente nel file ch2-beans.xml

(utilizzo del XML java ch2-beans.xml)