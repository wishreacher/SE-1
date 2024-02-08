/*
    В нас є тварини(оберіть самостійно), наприклад пінгвін і медвідь. А також є працівник зоопарку
    (роль його оберіть самостійно), наприклад доглядач тварин.

    Зробіть класи які будуть характеризувати вказані дійові особи системи, опишіть поля і методи,
    що їм притаманні (деякі методи можуть бути порожні).
    Зробіть клас , який буде моделювати день зоопарку.
 */

public class Zoo {
    public static void main(String[] args) {
        Worker worker = new Worker("John");
        Fox fox = new Fox("Roxy", 3);
        Cat cat = new Cat("Richard", 4);
        Owl owl = new Owl("Oscar", 5);

        System.out.println("Day in the zoo:");
        System.out.println("Animals kept at the zoo:");
        worker.inspect(fox);
        worker.inspect(cat);
        worker.inspect(owl);

        System.out.println("-------------------");

        worker.feed(fox);
        System.out.println();
        worker.pet(cat);
        System.out.println();
        worker.pet(owl);
    }
}
