- Spike che istanzia lo Spring Container e lo va a configurare utilizzando la XML‐Based Configuration
  attraverso utilizzo dell' "Automatically wiring beans" utilizzando le funzioni di:
        - Component Scanning: Spring automatically discovers beans to be created in the application context.
        - Autowiring: Spring automatically satisfies bean dependencies.

- In particolare si ricorre in questo caso ad una modalità di autowiring byName. Alla property viene iniettato
  il bean che presenta lo stesso nome attraverso il corrispondente metodo setter

(Utilizzo del XML java ch2-beans.xml)