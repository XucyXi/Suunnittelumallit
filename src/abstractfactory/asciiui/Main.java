package abstractfactory.asciiui;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- GENERATING STYLE A UI ---");
        UIFactory myFactory = new AFactory();

        Button btn = myFactory.createButton("Submit");
        TextField txt = myFactory.createTextField("Enter username");
        Checkbox chk = myFactory.createCheckbox("Remember me");

        btn.display();
        txt.display();
        chk.display();

        System.out.println("\n--- DYNAMICALLY CHANGING TEXT ---");
        // Testing the setText method
        btn.setText("Processing...");
        btn.display();

        System.out.println("\n--- GENERATING STYLE B UI ---");
        // Switching to the other factory
        UIFactory fantasyFactory = new BFactory();

        Button btn2 = fantasyFactory.createButton("Play");
        TextField txt2 = fantasyFactory.createTextField("Character Name");
        Checkbox chk2 = fantasyFactory.createCheckbox("Enable Tutorial");

        btn2.display();
        txt2.display();
        chk2.display();
    }
}