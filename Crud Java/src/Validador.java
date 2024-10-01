public class Validador {

    public static String validarLetras(String str) throws IllegalArgumentException {
        if (!str.matches("[a-zA-Z]+")){
            throw new IllegalArgumentException("Debe contener sólo letras 😉😉");

        }

        return str;
    }

    public static int validarID(int ID) throws ValiException {

        if (ID <= 0 || ID >= 100) {
            throw new ValiException("El número de cartón debe estar en un rango de 1 a 100 🙃🙃");
        }
        return ID;
    }
    public static float validarFloat(String str) throws IllegalArgumentException {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("La entrada no puede estar vacía.");
        }
        try {
            return Float.parseFloat(str);  // Devuelve el valor si es válido
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error❌❌❌ \nDebe ingresar el decimal con un (.) \nDebe ingresar solo numeros");


        }
    }
}
