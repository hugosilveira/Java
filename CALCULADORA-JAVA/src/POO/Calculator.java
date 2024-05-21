package POO;

import java.util.HashMap;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Numero n = new Numero();

        boolean next = true;

        Scanner scan = new Scanner(System.in);
        while (next) {
            double x = 0;
            double y = 0;
            int operation = 0;

            System.out.println("Digite a operação: "
            +                    "\n (1) -> Soma"
            +                    "\n (2) -> Subtração"
            +                    "\n (3) -> Multiplicação"
            +                    "\n (4) -> Divisão"
            +                    "\n (0) -> Finalizar"
            );

            operation = scan.nextInt();

            if (operation == 0){
                next = false;
                return;
            }
            System.out.println("Informe o valor do primeiro numero");
            x = lerNumero(scan);

            System.out.println("Informe o valor do segundo numero");
            y = lerNumero(scan);

            switch (operation) {
                case (1):
                    imprimeCalculadora(operation, n.sum(x ,y), x, y);
                    break;
                case 2:
                    imprimeCalculadora(operation, n.sub(x ,y), x, y);
                    break;
                case 3:
                    imprimeCalculadora(operation, n.mul(x ,y), x, y);
                    break;                    
                case 4:
                    imprimeCalculadora(operation, n.div(x ,y), x, y);
                    break;
            }    

        }

        scan.close();
    }

    static double lerNumero(Scanner scanner) {
        String input = scanner.next();
        input = input.replace(',', '.'); // Substituir vírgula por ponto
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido, por favor, insira um número válido.");
            return lerNumero(scanner);
        }
    }
    
    
    static void imprimeCalculadora(int operation, double resultado, double x, double y){
        HashMap<Integer, String> mapOperation = new HashMap<>();
        mapOperation.put(1, " somado");
        mapOperation.put(2, " subtraído");
        mapOperation.put(3, " multiplicado");
        mapOperation.put(4, " dividido");

        System.out.println("\n O resultado de " + x + mapOperation.get(operation) + " por " +
        y + " é igual a " + resultado + "\n");
    }
}
