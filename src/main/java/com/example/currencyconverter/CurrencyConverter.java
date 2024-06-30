package com.example.currencyconverter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencyConverter {

    private static final HistoryManager historyManager = new HistoryManager();
    private static final ExchangeRateService exchangeRateService = new ExchangeRateService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printWelcomeMessage();
        while (true) {
            try {
                showMenu();
                int choice = scanner.nextInt();
                if (choice == 0) {
                    printGoodbyeMessage();
                    historyManager.saveConversionHistory();
                    break;
                }

                if (choice == 9) {
                    historyManager.showConversionHistory();
                    System.out.println();
                    continue;
                }

                if (choice < 0 || choice > 8) {
                    System.out.println("Selección no válida. Por favor, ingrese un número entre 0 y 9.");
                    continue;
                }

                double amount;
                while (true) {
                    System.out.print("Ingrese el monto a convertir: ");
                    amount = scanner.nextDouble();
                    if (amount > 0) {
                        break;
                    } else {
                        System.out.println("El monto debe ser un número positivo. Intente nuevamente.");
                    }
                }

                String fromCurrency = getCurrencyCode(choice);
                System.out.println();
                showMenu("destino");
                int targetChoice = scanner.nextInt();

                if (targetChoice < 0 || targetChoice > 8) {
                    System.out.println("Selección no válida. Por favor, ingrese un número entre 0 y 8.");
                    continue;
                }

                String toCurrency = getCurrencyCode(targetChoice);

                double rate = exchangeRateService.getExchangeRate(fromCurrency, toCurrency);
                double convertedAmount = amount * rate;

                ConversionRecord record = new ConversionRecord(amount, fromCurrency, convertedAmount, toCurrency);
                historyManager.addConversionRecord(record);

                System.out.printf("Monto convertido: %.2f %s%n", convertedAmount, toCurrency);
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();  // Limpiar la entrada no válida
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void printWelcomeMessage() {
        System.out.println();
        System.out.println("===============================================");
        System.out.println("     ¡Bienvenido al Conversor de Monedas!      ");
        System.out.println("===============================================");
        System.out.println("¡Convierte fácilmente entre diferentes monedas!");
        System.out.println("===============================================");
        System.out.println();
    }

    private static void printGoodbyeMessage() {
        System.out.println("============================================================");
        System.out.println("Gracias por usar el Conversor de Monedas. ¡Hasta la próxima!");
        System.out.println("============================================================");
    }

    private static void showMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. ARS - Peso argentino");
        System.out.println("2. BOB - Boliviano boliviano");
        System.out.println("3. BRL - Real brasileño");
        System.out.println("4. CLP - Peso chileno");
        System.out.println("5. COP - Peso colombiano");
        System.out.println("6. USD - Dólar estadounidense");
        System.out.println("7. EUR - Euro");
        System.out.println("8. GBP - Libra esterlina");
        System.out.println("9. Consultar historial de conversiones");
        System.out.println("0. Salir");
    }

    private static void showMenu(String tipo) {
        if (tipo.equals("origen")) {
            System.out.println("Seleccione la moneda de origen:");
        } else if (tipo.equals("destino")) {
            System.out.println("Seleccione la moneda de destino:");
        }
        System.out.println("1. ARS - Peso argentino");
        System.out.println("2. BOB - Boliviano boliviano");
        System.out.println("3. BRL - Real brasileño");
        System.out.println("4. CLP - Peso chileno");
        System.out.println("5. COP - Peso colombiano");
        System.out.println("6. USD - Dólar estadounidense");
        System.out.println("7. EUR - Euro");
        System.out.println("8. GBP - Libra esterlina");
        System.out.println("0. Salir");
    }

    private static String getCurrencyCode(int choice) {
        return switch (choice) {
            case 1 -> "ARS";
            case 2 -> "BOB";
            case 3 -> "BRL";
            case 4 -> "CLP";
            case 5 -> "COP";
            case 6 -> "USD";
            case 7 -> "EUR";
            case 8 -> "GBP";
            default -> throw new IllegalArgumentException("Selección no válida");
        };
    }
}
