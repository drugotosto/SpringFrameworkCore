- Spike che istanzia lo Spring Container e lo va a configurare utilizzando Annotation‐Based Configuration
  attraverso lìuso del "Automatically wiring beans" utilizzando le funzioni di:
    - Component Scanning: Spring automatically discovers beans to be created in the application context.
    - Autowiring: Spring automatically satisfies bean dependencies.

- Da notare come in questo caso viene applicato l'autowiring direttamente sulla property senza avere nemmeno la necessità
  di adottare il setter method che difatti non è più presente.

- Al'interno del file ch2-beans.xml è presente il solo codice (<context:component-scan base-package="com.wiley.beginningspring.ch2"/>)
  che istruisce il Container in quale pacchetto andare a cercare i beans da creare.
