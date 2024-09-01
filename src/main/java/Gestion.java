import java.util.Objects;

public class Gestion {
    public static void main(String[] args) {
        System.out.println("Inicio");
    }
    public static boolean verificarEdad (String [][] matrix, int row) {
        return Integer.parseInt(matrix[(row - 1)][1]) >= 18;
    }
    public static String verificarBoleto (String [][] matrix, int row) {
        return matrix[(row - 1)][2];
    }
    public static boolean validarInvitados (String [][] matrix, int row) {
        return Integer.parseInt(matrix[row-1][3]) <= 2;
    }
    public static int aforoDisponible (String [][] matrix, String room) {
        int people = 0;
        if (Objects.equals(room, "VIP")){
            for (String[] strings : matrix) {
                if ((Objects.equals(strings[2], room) && (Boolean.parseBoolean(strings[4])))) {
                    people += (Integer.parseInt(strings[3]) + 1);
                }
            }
            return (20 - people);
        } else {
            for (String[] strings : matrix) {
                if (((Objects.equals(strings[2], room) && (Boolean.parseBoolean(strings[4]))))) {
                    people++;
                }
            }
            return (10 - people);
        }
    }
    public static String [][] ingresarPersona (String [][] matrix, int row) {
        matrix[row-1][4] = "true";
        return matrix;
    }
    public static boolean permitirEntrada (String [][] matrix, int row) {
        if (Objects.equals(verificarBoleto(matrix, row-1), "VIP")) {
            return  (verificarEdad(matrix, row-1) && validarInvitados(matrix, row-1) && (aforoDisponible(matrix, "VIP")+Integer.parseInt(matrix[row-1][3])+1 >= 20));
        } else if (Objects.equals(verificarBoleto(matrix,row), "General")){
            return (verificarEdad(matrix, row-1) && validarInvitados(matrix, row-1) && (aforoDisponible(matrix, "General") > 0));
        } else {
            return false;
        }
    }
    public static String [][] removerPersona (String [][] matrix, int row) {
        matrix[row-1][4] = "false";
        return matrix;
    }
}
