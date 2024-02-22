a: db  "9"
b: db 10

start:
mov al, byte a 
mov ah, byte b
jmp firstPart

firstPart:
cmp al, 48
jb secondPart

cmp al, 57
ja secondPart

jmp outerIF

secondPart:
cmp al, 97
jb thirdPart

cmp al, 102
ja thirdPart 

cmp ah, 10
jbe thirdPart

jmp outerIF

thirdPart:
cmp ah, 10
jbe outerELSE

cmp al, 65
jb outerELSE

cmp al, 70
ja outerELSE

jmp outerIF


outerIF:
sub al, 48

jmp innerIF


outerELSE:
mov al, -1
jmp end

innerIF:
cmp al, 9
jbe innerELSE

cmp al, 23
jge innerELSE

sub al, 7

jmp end

innerELSE:
cmp al, 39
jbe end

sub al, 39
jmp end

jmp end

end:
mov ah, 0x1
mov byte a, al
int 0x21