a: DW 19
b: DB 0  

start:
mov ax, word a

; ділення на 8
sar ax, 3; кожний зсув вправо ділить число на 2, тому робимо це 3 рази
mov word a, ax

; остача
and ax, 7
mov byte b, al
mov bl, al;не впливає на логіку, просто щоб відобразити відповідь
print reg