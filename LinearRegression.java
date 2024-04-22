public class LinearRegression {
    public static double[] calculateCoefficients(double[] X, double[] y) {
        double n = X.length;
        double meanX = 0;
        double meanY = 0;
        for (int i = 0; i < n; i++) {
            meanX += X[i];
            meanY += y[i];
        }
        meanX /= n;
        meanY /= n;
        double sumXY = 0;
        double sumXX = 0;
        for (int i = 0; i < n; i++) {
            sumXY += (X[i] - meanX) * (y[i] - meanY);
            sumXX += (X[i] - meanX) * (X[i] - meanX);
        }
        double m = sumXY / sumXX;
        double b = meanY - m * meanX;
        return new double[]{m, b};
    }
    public static double[] predict(double[] X, double[] coefficients) {
        double m = coefficients[0];
        double b = coefficients[1];
        int n = X.length;
        double[] predictions = new double[n];
        for (int i = 0; i < n; i++) {
            predictions[i] = m * X[i] + b;
        }
        return predictions;
    }
    public static void main(String[] args) {
        double[] X = {1, 2, 3, 4, 5};
        double[] y = {2, 3, 4, 5, 6};
        double[] coefficients = calculateCoefficients(X, y);
        double[] X_new = {6, 7};
        double[] predictions = predict(X_new, coefficients);
        System.out.println("Predictions:");
        for (double prediction : predictions) {
            System.out.println(prediction);
        }
    }
}