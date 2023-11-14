class Animal:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def speak(self):
        print("The animal speaks.")


class Dog(Animal):
    def bark(self):
        print("The dog barks.")


dog = Dog("Max", 3)
dog.speak()
dog.bark()
