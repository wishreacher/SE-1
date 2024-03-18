;(1B: 1.5 бали) Визначити двовимірний масив 10x20. 
;Елемент масиву - теж слово. Записати значення Y*(X+5) у 
;елементи цього масиву з використанням ret/call. 
;X - рядок, Y - стовпчик.

.model small
.stack 100h

.data
    array dw 10*20 dup(0) ; define array and initialize it with 0


.code 
    main PROC
        mov ax, @data
        mov ds, ax

        mov ch, 0 ; initialize counter for x
        mov cl, 0 ; initialize counter for y

        int 21h ; call procedure to fill array with values

main ENDP
END main