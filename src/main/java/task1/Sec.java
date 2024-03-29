package task1;

public class Sec {
    public static double secApprox(double x) {

        // Преобразование радиан в диапазон [-π, π]
        x = x % (Math.PI * 2);
        if (x > Math.PI) {
            x -= Math.PI * 2;
        } else if (x < -Math.PI) {
            x += Math.PI * 2;
        }

        // Вычисление косинуса через его ряд Тейлора до 10-го порядка
        double cosX = 1;
        double term = 1;
        for (int n = 1; n <= 10; n++) {
            term *= -Math.pow(x, 2) / ((2 * n - 1) * (2 * n));
            cosX += term;
        }

        return 1 / cosX;
    }
}

