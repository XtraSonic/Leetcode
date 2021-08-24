package dailies.complexNumberMultiplication;

public class ComplexNumberMultiplicationApproach1 implements ComplexNumberMultiplication {

    @Override
    public String complexNumberMultiply(String num1, String num2) {
        ComplexNumber a = ComplexNumber.parse(num1);
        ComplexNumber b = ComplexNumber.parse(num2);
        return a.multiply(b).toString();
    }

    //ideally these would be done without conversions
    private static String multiplyStrings(String a, String b) {
        return Long.toString(Long.parseLong(a) * Long.parseLong(b));
    }

    private static String subtractStrings(String a, String b) {
        return Long.toString(Long.parseLong(a) - Long.parseLong(b));
    }

    private static String addStrings(String a, String b) {
        return Long.toString(Long.parseLong(a) + Long.parseLong(b));
    }

    private static class ComplexNumber {
        String real;
        String imaginary;

        public ComplexNumber(String real, String imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        public static ComplexNumber parse(String num) {
            int indexOfPlus = num.indexOf('+');
            return new ComplexNumber(num.substring(0, indexOfPlus), num.substring(indexOfPlus + 1, num.length() - 1));
        }

        public ComplexNumber multiply(ComplexNumber b) {
            String newReal = subtractStrings(multiplyStrings(real, b.real), multiplyStrings(imaginary, b.imaginary));
            String newImaginary = addStrings(multiplyStrings(real, b.imaginary), multiplyStrings(imaginary, b.real));
            return new ComplexNumber(newReal, newImaginary);
        }


        @Override
        public String toString() {
            return real + "+" + imaginary + "i";
        }
    }
}
