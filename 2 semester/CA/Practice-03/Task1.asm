a: DW -5
b: DW -2

start:
mov ax, word a
mov bx, word b

add ax, bx

; Check if ax is negative
test ax, ax
jns end

; If here, ax is negative. Convert it to its absolute value.
not ax
add ax, 1 ;1's complement

end: