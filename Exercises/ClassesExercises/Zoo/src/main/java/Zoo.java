public class Zoo {
    public static void main(String[] args) {
        Animal[] jaula = new Animal[10];

        Animal[] modelos = {new Lion(), new Wolf(), new Owl()};

        // Gambiarra para preencher o array de animais com os modelos disponíveis
        for (int i = 0; i < jaula.length; i++) {
            jaula[i] = modelos[i % modelos.length];
        }

        for (Animal animal : jaula) {
            animal.makeSound();
            if (animal instanceof Lion lion) {
                lion.run();
            } else if (animal instanceof Wolf wolf) {
                wolf.run();
            }
        }
    }
}
