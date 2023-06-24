class javaCnpj{
public static boolean validarCNPJ(String CNPJ) {
        String CNPJformatado = CNPJ.replace(".", "").replace("/", "").replace("-", "");
        int contadorDozeDigitos = 5;
        int somaDozeDigitos = 0;
        int restoDozeDigitos = 0;
        int somaTrezeDigitos = 0;
        int restoTrezeDigitos = 0;
        
        char primeiroDigitoVerificador;
        char segundoDigitoVerificador;
        
        // Calcular o primeiro dígito verificador:
        for (int i = 0; i < 4; i++) {
            somaDozeDigitos += Character.getNumericValue(CNPJformatado.charAt(i)) * contadorDozeDigitos;
            contadorDozeDigitos--;
            // System.out.print(CNPJformatado.charAt(i) + " ");
        }
        contadorDozeDigitos = 9;
        for (int i = 4; i < 12; i++) {
            somaDozeDigitos += Character.getNumericValue(CNPJformatado.charAt(i)) * contadorDozeDigitos;
            contadorDozeDigitos--;
            // System.out.print(CNPJformatado.charAt(i) + " ");
        }
        
        restoDozeDigitos = somaDozeDigitos % 11;
        if (restoDozeDigitos < 2) {
            primeiroDigitoVerificador = '0';
        } else {
            primeiroDigitoVerificador = Character.forDigit(11 - restoDozeDigitos, 10);
        }
        
        // Calcular o segundo dígito verificador:
        contadorDozeDigitos = 6;
        for (int i = 0; i < 5; i++) {
            somaTrezeDigitos += Character.getNumericValue(CNPJformatado.charAt(i)) * contadorDozeDigitos;
            contadorDozeDigitos--;
        }
        contadorDozeDigitos = 9;
        for (int i = 5; i < 13; i++) {
            somaTrezeDigitos += Character.getNumericValue(CNPJformatado.charAt(i)) * contadorDozeDigitos;
            contadorDozeDigitos--;
            System.out.print(CNPJformatado.charAt(i) + " ");
        }
        
        restoTrezeDigitos = somaTrezeDigitos % 11;
        if (restoTrezeDigitos < 2) {
            segundoDigitoVerificador = '0';
        } else {
            segundoDigitoVerificador = Character.forDigit(11 - restoTrezeDigitos, 10);
        }
        System.out.println(somaTrezeDigitos);
        
        return primeiroDigitoVerificador == CNPJformatado.charAt(12) && segundoDigitoVerificador == CNPJformatado.charAt(13);
    }    
}
