## Zadanie zespołowe
Zaprojektuj, zaimplementuj i przetestuj b. prosty system do wypożyczania hulajnóg *na minuty*

### Założenia (zgrubne)
1. wypożyczamy hulajnogę i system rejestruje czas do jej zwrócenia
1. maksymalny czas wypożyczenia 2h, poźniej system blokuje hulajnogę
2. po zwróceniu system wylicza opłatę za wypożyczenie, na podstawie czasu wykorzystania i taryfy
1. obowiązują taryfy: 
    - godziny szczytu w dni robocze: 8-9, 16-17: 2 zł za minutę
    - poza godzinami szczytu: 1 zł za minutę
    - weekendowa: soboty i niedziele (dni świąteczne pomijamy): 0.5 zł za minutę

### Praca zespołowa
1. Zespół sam dzieli się praca i wyznacza role w zespole, przykładowo:
	- praca nad projektem głównego interfejsu - współna
	- implementacja metod interfejsu - programista
	- implementacja testów - tester
   Po zaimplementowaniu kilku metod można zmienić role w zespole
2. Pracujemy z repozytorium w ramach *feature branch*
3. Nie commitujemy bezpośrednio do gałęzi master. Kod w master pojawia się tylko w wyniku merge (oprócz inicjalnego commita)
3. Korzystamy z *pull request*
	- komentujemy funkcjonalności i kod wykonując przy okazji *code review* 