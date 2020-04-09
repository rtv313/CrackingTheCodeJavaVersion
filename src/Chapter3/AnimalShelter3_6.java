package Chapter3;

import java.util.LinkedList;

class Mascot{
    public String type;
    public int arrivalOrder;
}

class Dog extends Mascot{
    public Dog(int arrivalOrder){
        type = "Dog";
        this.arrivalOrder = arrivalOrder;
    }
}

class Cat extends Mascot{
    public Cat(int arrivalOrder){
        type = "Cat";
        this.arrivalOrder = arrivalOrder;
    }
}

public class AnimalShelter3_6 {
    int counter;
    LinkedList <Dog> dogs;
    LinkedList <Cat> cats;

    public AnimalShelter3_6(){
        counter = 0;
        dogs = new <Dog>LinkedList();
        cats = new <Cat>LinkedList();
    }

    public void enqueue(String type){
        if(type == "Dog"){
            dogs.add(new Dog(counter));
            counter++;
        }

        if(type == "Cat"){
            cats.add(new Cat(counter));
            counter++;
        }

        return;
    }

    public Dog dequeueDog(){
        return  dogs.pop();
    }

    public Cat dequeueCat(){
        return cats.pop();
    }

    public Mascot dequeueAny(){

        if(dogs.size() > 0 && cats.size() == 0){
            return dogs.pop();
        }

        if(dogs.size() > 0 && cats.size() > 0){
            if(dogs.peek().arrivalOrder < cats.peek().arrivalOrder){
                return dogs.pop();
            }else{
                return cats.pop();
            }
        }

        if(cats.size() > 0 && dogs.size() == 0){
            return cats.pop();
        }

        if(cats.size() > 0 && dogs.size() > 0){
            if(cats.peek().arrivalOrder < dogs.peek().arrivalOrder){
                return cats.pop();
            }else{
                return dogs.pop();
            }
        }

        return null;
    }

    public static  void main(String args[]){
        AnimalShelter3_6 shelter = new AnimalShelter3_6();
        shelter.enqueue("Dog");
        shelter.enqueue("Dog");
        shelter.enqueue("Dog");

        shelter.enqueue("Cat");
        shelter.enqueue("Cat");
        shelter.enqueue("Cat");

        shelter.enqueue("Dog");

        System.out.println(shelter.dequeueAny().type);
        System.out.println(shelter.dequeueAny().type);
        System.out.println(shelter.dequeueAny().type);
        System.out.println(shelter.dequeueAny().type);
        System.out.println(shelter.dequeueDog().type);
        System.out.println(shelter.dequeueCat().type);
        System.out.println(shelter.dequeueAny().type);
    }
}
