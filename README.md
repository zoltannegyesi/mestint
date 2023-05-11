# Nyolcas puzzle

| 0 | 1 | 2 | 
|---|---|---|
| 3 | 4 | 5 |
| 6 | 7 | 8 |


## Probléma:
- Egy 3x3-as táblán vannak a számok 0-tól 8-ig. 
- Ezek a számok össze-vissza vannak, valamilyen sorrendben.
- A játék célja, hogy a számokat sorba rendezzük úgy, hogy egyszerre csak egy négyzetet tudunk arrébb mozgatni a 0-s számú helyére.

## Állapottér:
- Állapotok: az egyes lépések utáni, jelenlegi táblázat.
- A program az egyes állapotokat egy 3x3-as tömbbel ábrázolja, például: [[3, 2, 8], [4, 1, 0], [6, 5, 7]]
- Műveletek: Észak, kelet, dél, nyugat, amely a 0-s számú négyzet mozgatását jelöli.
- Célfeltétel: a számok soronként balról-jobbra sorba legyenek rendezve, tehát: [[0, 1, 2], [3, 4, 5], [6, 7, 8]].
- Kezdőállapot: [[1, 3, 2], [0, 7, 8], [4, 6, 5]]
