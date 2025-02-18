import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class quiz {
    public static void main(String[] args) {

        String nombre = preguntarNombre();
        System.out.println("Hi " + nombre);

        String topico = preguntarTopico();

        int numPreguntas = seleccionarNumeroPreguntas();

        String[] preguntas = preguntasRandom(numPreguntas, topico);
        String[] respuestas = respuestasPreguntas(topico);

        int aciertos = jugarQuiz(preguntas, numPreguntas, respuestas);

        mostrarPuntuacion(aciertos, numPreguntas);

        queHaceAhora(aciertos, topico);
    }

    private static String preguntarNombre() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce your name: ");
        return sc.nextLine();
    }

    private static String preguntarTopico() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a topic:");
        System.out.println("1. General pet care");
        System.out.println("2. How to take care of an adopted dog");

        while (true) {
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                return "General pet care";
            } else if (choice.equals("2")) {
                return "How to take care of an adopted dog";
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }
    }

    private static int seleccionarNumeroPreguntas() {
        Scanner sc = new Scanner(System.in);
        int numPreguntas;

        System.out.println("How many questions do you want to answer? Choose a number between 5 and 20: ");
        while (true) {
            if (sc.hasNextInt()) {
                numPreguntas = sc.nextInt();
                if (numPreguntas >= 5 && numPreguntas <= 20) {
                    return numPreguntas;
                } else {
                    System.out.println("Please enter a number between 5 and 20.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }
    }

    private static String[] preguntasRandom(int numPreguntas, String topico) {
        String[] poolPreguntas;

        if (topico.equals("General pet care")) {
            poolPreguntas = new String[]{
                "How often should you feed an adult dog?\nA) Once a day\nB) Twice a day\nC) Every 6 hours",

                "What is the ideal way to clean a dog's ears?\nA) Use a cotton swab\nB) Use a damp cloth or vet-recommended cleaner\nC) Don’t clean them at all",

                "How often should you brush your dog’s coat?\nA) Once a month\nB) Once a week or more, depending on the breed\nC) Never",

                "What is one sign of dehydration in dogs?\nA) Dry nose and gums\nB) Excessive drooling\nC) Clear eyes",

                "Why is it important to provide chew toys for dogs?\nA) To prevent boredom and dental issues\nB) To keep them quiet\nC) To train them to eat slower",

                "What is the recommended exercise duration for most dogs?\nA) 10 minutes per day\nB) 30–60 minutes per day\nC) 2–3 hours per day",

                "How often should you trim your dog’s nails?\nA) Every week\nB) Once every 1–2 months\nC) Only when they grow too long",

               "What is one key sign your dog may have a skin allergy?\nA) Excessive scratching or licking\nB) Shivering or trembling\nC) Excessive barking",

                "What type of food is healthiest for most dogs?\nA) Table scraps\nB) Balanced commercial dog food\nC) Only raw meat",

                "What is the best way to introduce dental care to your dog?\nA) Start brushing their teeth gently with a dog toothbrush and toothpaste\nB) Use human toothpaste\nC) Don’t clean their teeth; they naturally clean themselves",

                "How do you know if your dog is overweight?\nA) They eat a lot\nB) You can’t feel their ribs\nC) They exercise a lot",

                "What is the best way to prevent flea infestations?\nA) Regularly check and use flea prevention treatments\nB) Bath them every day\nC) Keep them inside all the time",

                "What is a common symptom of ear infections in dogs?\nA) Head shaking and scratching ears\nB) Bright eyes\nC) Tail wagging excessively",

                "How should you handle a dog that is constantly barking?\nA) Ignore it\nB) Provide positive reinforcement when they stop barking\nC) Yell at the dog to stop",

                "How can you make sure your dog’s environment is safe?\nA) Remove any toxic plants and chemicals\nB) Let them roam freely without supervision\nC) Provide only small spaces for them to explore",

                "When should you take your dog to the vet for a check-up?\nA) Only when they’re sick\nB) Annually, even when they seem healthy\nC) Every 2-3 years",

                "Why is it important to socialize a dog?\nA) To improve their behavior around other dogs and people\nB) To prevent them from barking\nC) To make them aggressive",

                "What is the best way to provide mental stimulation for a dog?\nA) Give them lots of toys to play with\nB) Take them on long walks\nC) Use puzzle toys or teach them new tricks",

                "What are signs of a potential flea infestation on a dog?\nA) Scratching, red spots, and visible fleas\nB) Excessive drooling\nC) Excessive tail wagging",

                "Why is hydration important for dogs?\nA) It helps maintain their energy levels\nB) It prevents urinary problems\nC) It helps them stay cool in hot weather"

            };
        } else {
            poolPreguntas = new String[]{

            "What is the first thing you should do when bringing an adopted dog home?\nA) Take them to the park\nB) Let them explore the house safely\nC) Give them a bath immediately",

            "How can you build trust with an adopted dog?\nA) Offer treats and engage in gentle play\nB) Enforce strict rules right away\nC) Let them fend for themselves",

            "Why is a vet visit important after adopting a dog?\nA) To get vaccinations and check overall health\nB) To see if they like the vet’s office\nC) It’s not necessary if they seem healthy",

            "How long does it typically take for an adopted dog to adjust to a new home?\nA) A few hours\nB) 3 days to 3 months\nC) A year or more",

            "What should you consider when introducing your adopted dog to a new routine?\nA) Start with a strict routine immediately\nB) Gradually establish a consistent schedule for feeding, walking, and sleeping\nC) Change their routine daily to keep them flexible",

            "What is one way to help an adopted dog feel safe?\nA) Use a crate or designated safe space\nB) Give them free run of the entire house\nC) Always keep them outside",

            "Why is patience important when training an adopted dog?\nA) They might not respond to commands immediately\nB) They don’t need training at all\nC) It’s important to train aggressively",

            "How can you tell if an adopted dog is stressed?\nA) Panting, pacing, or hiding\nB) Sleeping peacefully\nC) Playing with toys",

            "What is the best way to bond with your adopted dog?\nA) Spend quality time with them and engage in activities they enjoy\nB) Force them to follow all commands immediately\nC) Ignore them to let them become independent",

            "What is a common mistake new dog adopters make?\nA) Not giving the dog enough time to adjust\nB) Showering them with attention immediately\nC) Both A and B",

            "How should you handle behavioral issues with an adopted dog?\nA) Immediately scold them\nB) Use positive reinforcement and gentle training\nC) Ignore the behavior",

            "What should you do if your adopted dog is fearful or shy?\nA) Allow them to approach new situations slowly\nB) Force them into social situations\nC) Isolate them from everything",

            "When adopting a dog, how can you assess if the dog is a good fit for your home?\nA) Observe their behavior and energy level in a neutral environment\nB) Assume they’ll fit in once you bring them home\nC) Choose based on appearance",

            "How can you help an adopted dog with separation anxiety?\nA) Leave them alone for extended periods\nB) Gradually increase the time you are away and provide comforting items\nC) Ignore the behavior",

            "What is one way to make your adopted dog feel more comfortable in your home?\nA) Provide a quiet area with their bed and favorite toys\nB) Let them roam the entire house immediately\nC) Never let them in any rooms",

            "What should you do if your adopted dog doesn’t seem to get along with other pets?\nA) Immediately give them time alone\nB) Slowly and carefully introduce them to other pets\nC) Keep them away from all other animals forever",

            "How should you handle house training an adopted dog?\nA) Use a consistent schedule for potty breaks\nB) Scold them for accidents\nC) Let them figure it out on their own",

            "How do you ensure your adopted dog is getting enough exercise?\nA) Take them for daily walks and play regularly\nB) Let them rest and be sedentary\nC) Take them to the park every weekend only",

            "What should you do if your adopted dog shows signs of aggression?\nA) Ignore the aggression and hope it goes away\nB) Seek professional behavior help immediately\nC) Respond aggressively",

            "How can you help an adopted dog adjust to being left alone?\nA) Gradually increase the time they spend alone\nB) Always leave them with a treat and comforting item\nC) Never leave them alone"

            };
        }

        ArrayList<String> preguntasLista = new ArrayList<>();
        Collections.addAll(preguntasLista, poolPreguntas);
        Collections.shuffle(preguntasLista);

        String[] preguntasSeleccionadas = new String[numPreguntas];
        for (int i = 0; i < numPreguntas; i++) {
            preguntasSeleccionadas[i] = preguntasLista.get(i);
        }

        return preguntasSeleccionadas;
    }

    private static String[] respuestasPreguntas(String topico) {
        if (topico.equals("General pet care")) {
            return new String[]{"B", "B", "B", "A", "A", "B", "B", "A", "B", "A", "B", "A", "A", "B", "A", "B", "A", "C", "A", "B"
            };
        } else {
            return new String[]{"B", "A", "A", "B", "B", "A", "A", "A", "A", "C", "B", "A", "A", "B", "A", "B", "A", "A", "B", "A"
            };
        }
    }

    private static int jugarQuiz(String[] preguntas, int numPreguntas, String[] respuestas) {
        Scanner sc = new Scanner(System.in);
        int aciertos = 0;

        for (int i = 0; i < numPreguntas; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + preguntas[i]);
            System.out.print("\nYour answer: ");
            String userAnswer = sc.nextLine();

            if (userAnswer.equalsIgnoreCase(respuestas[i])) {
                aciertos++;
            }
        }

        return aciertos;
    }

    private static void mostrarPuntuacion(int aciertos, int numPreguntas) {
        System.out.println("\nYou answered correctly " + aciertos + " out of " + numPreguntas + " questions");
        double porcentajeNota = 100.0 / numPreguntas;
        double puntuacionTotal = aciertos * porcentajeNota;
        System.out.println("Your score is: " + puntuacionTotal + "%");

        if (puntuacionTotal < 33) {
            System.out.println("Keep trying! Practice makes perfect 😎");
        } else if (puntuacionTotal < 66) {
            System.out.println("Good effort! There's room for improvement 😊");
        } else if (puntuacionTotal < 100) {
            System.out.println("Very good! You have a solid understanding but I bet you can do it perfectly 😉");
        } else {
            System.out.println("Excellent! You did a great job 🎉");
        }
    }

    private static void queHaceAhora(int aciertos, String topico) {
        Scanner sc = new Scanner(System.in);
        
        int numPreguntas;
        String[] preguntas;
        String[] respuestas;
        
        int answer1;

        do {
            System.out.println("\nNice game! What do you want to do now?");
            System.out.println("1. Play again :)");
            System.out.println("2. Exit game.");
            answer1 = sc.nextInt();

            if (answer1 == 1) {
                preguntarTopico();
                numPreguntas = seleccionarNumeroPreguntas();
                preguntas = preguntasRandom(numPreguntas, topico);
                respuestas = respuestasPreguntas(topico);

                aciertos = jugarQuiz(preguntas, numPreguntas, respuestas);

                mostrarPuntuacion(aciertos, numPreguntas);

            } else if (answer1 == 2) {
                System.out.println("See you soon 👋🤧.");
            }
        } while (answer1 == 1);
    }
}
