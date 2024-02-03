public class SortingAlgorithms {
    enum sortOrder{
        ASCENDING,
        DESCENDING
    }

    /*  Короткий опис цього алгоритму:
        Ми починаємо з найпершого елементу масиву, визначаємо його як найменший елемент. Далі ми рухаємось через весь масив у пошуках нового мінімуму.
        Коли знаходимо нове мінімальне число - міняємо його місцями з тим елементом від якого починали пошук та повторюємо це поки не закінчиться масив.
    */
    public static void selectionSortByGrade(Student[] array, sortOrder order){
        switch(order){
            case ASCENDING -> {
                for(int i = 0; i < array.length - 1; i++){
                    int min = array[i].averageGrade;
                    int indexMin = i;
                    for(int j = i + 1; j < array.length; j++){
                        if(array[j].averageGrade < min){
                            min = array[j].averageGrade;
                            indexMin = j;
                        }
                    }
                    swap(array, i, indexMin);
                }
            }
            case DESCENDING -> {
                for(int i = 0; i < array.length - 1; i++){
                    int max = array[i].averageGrade;
                    int indexMax = i;
                    for(int j = i + 1; j < array.length; j++){
                        if(array[j].averageGrade > max){
                            max = array[j].averageGrade;
                            indexMax = j;
                        }
                    }
                    swap(array, i, indexMax);
                }
            }
        }
    }

    public static void selectionSortByName(Student[] array, sortOrder order){
        switch(order){
            case ASCENDING -> {
                for(int i = 0; i < array.length - 1; i++){
                    int indexMin = i;
                    for(int j = i + 1; j < array.length; j++){
                        if(compareStrings(array[j].name, array[i].name) < 0){
                            indexMin = j;
                        }
                    }
                    swap(array, i, indexMin);
                }
            }
            case DESCENDING -> {
                for(int i = 0; i < array.length - 1; i++){
                    int indexMin = i;
                    for(int j = i + 1; j < array.length; j++){
                        if(compareStrings(array[j].name, array[i].name) > 0){
                            indexMin = j;
                        }
                    }
                    swap(array, i, indexMin);
                }
            }
        }
    }

    public static int compareStrings(String str1, String str2) {
        String lowerStr1 = str1.toLowerCase();
        String lowerStr2 = str2.toLowerCase();
        int len1 = lowerStr1.length();
        int len2 = lowerStr2.length();
        int lim = Math.min(len1, len2);

        for (int k = 0; k < lim; k++) {
            char c1 = lowerStr1.charAt(k);
            char c2 = lowerStr2.charAt(k);
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        return len1 - len2;
    }

    public static void swap(Student[] array, int a, int b){
        Student temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /*  Короткий опис цього алгоритму:
        Починаємо з другого елементу масиву оскільки перший елемент завжди "відсортований".
        Ми дивимось чи попередній елемент масиву більше числа, яка ми маємо перемістити і якщо так, значення поперднього елементу призначаємо теперішньому
        і декрементуємо індекс, щоб рухатись далі ліворуч. Коли ми дійшли до потрібного місця, тобто початку масиву або ситуації, коли елемент зліва не більший
        теперішнього, ставимо на це місце початковий елемент та повторюємо цикл.

        логічніше було б назвати це якось типу shiftSort, це більше відповідає його практичній реалізації в коді
     */
    public static void insertionSort(Student[] array, sortOrder order){
        switch (order){
            case ASCENDING -> {
                //починаємо з одиниці, оскільки перший елемент завжди "відсортований"
                for(int i = 1; i < array.length; i++){
                    Student temp = array[i];
                    int j = i - 1;
                    while(j >= 0 && array[j].averageGrade > temp.averageGrade){
                        array[j + 1] = array[j];
                        j--;
                    }
                    array[j + 1] = temp;
                }
            }
            case DESCENDING -> {
                for(int i = 1; i < array.length; i++){
                    Student temp = array[i];
                    int j = i - 1;
                    while(j >= 0 && array[j].averageGrade < temp.averageGrade){
                        array[j + 1] = array[j];
                        j--;
                    }
                    array[j + 1] = temp;
                }
            }
        }
    }

    /* Короткий опис алгоритму:
        В списку елементів ми розглядаємо елементи по два, як своєрідну бульбашку. Якщо другий елемент в бульбашці більше першого - міняємо їх місцями і йдемо длалі.
        Після однієї ітерації свапа масив скоріш за все не буде відсортованим повністю, тому це має бути у вайл лупі. Ми можемо дізнатись чи масив відсортувався
        увівши булеву змінну яка відслідковувала би чи міняли ми щось місцями, якщо при одній ітерації нічого не змінилось, то масив вважаємо відсортованим.

     */
    public static void bubbleSort(Student[] array, sortOrder order){
        boolean didSwap = true;

        switch(order){
            case ASCENDING -> {
                while(didSwap){
                    didSwap = false;
                    for(int i = 0; i < array.length - 1; i++){
                        if(array[i].averageGrade > array[i + 1].averageGrade){
                            didSwap = true;
                            swap(array, i, i + 1);
                        }
                    }
                }
            }
            case DESCENDING -> {
                while(didSwap){
                    didSwap = false;
                    for(int i = 0; i < array.length - 1; i++){
                        if(array[i].averageGrade < array[i + 1].averageGrade){
                            didSwap = true;
                            swap(array, i, i + 1);
                        }
                    }
                }
            }
        }
    }

    /*
        Короткий опис алгоритму.
        Ми обираємо опорний елемент в масиві та порівнюємо інші значення з ним.
        Нам потрібно знайти перше значення рухаючись зліва яке буде більше за опорний елемент і перше значення
        рухаючись справа, яке буде менше за опорний елемент. Коли ці значення знайдені - ми міняємо їх місцями,
        допоки лівий індекс не стаене більше правого, що означатиме, що фінальне місце опорного елемента в масиві знайдено.
        Далі ми "розбиваємо" цей масив на дві половини - ліворуч і праворуч від опорного елемента та рекурсивно
        повторюємо сортування.
     */
    public static void quickSort(Student[] array, int start, int end, sortOrder order){
        if(start >= end){
            return;
        }

        int pivot = end;

        int leftPtr = start;
        int rightPtr = end;

        while(leftPtr < rightPtr){
            while(array[leftPtr].averageGrade <= array[pivot].averageGrade && leftPtr < rightPtr){
                leftPtr++;
            }
            while(array[rightPtr].averageGrade >= array[pivot].averageGrade && leftPtr < rightPtr){
                rightPtr--;
            }
            swap(array, leftPtr, rightPtr);
        }
        swap(array, leftPtr, pivot);

        quickSort(array, start, leftPtr - 1, order);
        quickSort(array, leftPtr + 1, end, order);
    }
}
