package paagbat.model;

public class Eragiketa {
    private double zenb1,zenb2,zenb3;

    public Eragiketa(double zenb1,double zenb2,double zenb3) {
        this.zenb1 = zenb1;
        this.zenb2 = zenb2;
        this.zenb3 = zenb3;
    }

    public double getZenb1(){
        return zenb1;
    }

    public double getZenb2(){
        return zenb2;
    }

    public double getZenb3(){
        return zenb3;
    }

    public void setZenb1(double zenb1Berria){
        zenb1 = zenb1Berria;
    }

    public void setZenb2(double zenb2Berria){
        zenb2 = zenb2Berria;
    }

    public void setZenb3(double zenb3Berria){
        zenb3 = zenb3Berria;
    }


    public Eragiketa(String eragIdatzia) {
        // Verificar que la cadena no esté vacía
        if (eragIdatzia == null || eragIdatzia.isEmpty()) {
            throw new IllegalArgumentException("La expresión no puede estar vacía.");
        }
    
        // Buscar el operador (suponiendo que solo puede ser uno de los operadores especificados)
        String operador = "";
        if (eragIdatzia.contains("+")) {
            operador = "+";
        } else if (eragIdatzia.contains("-")) {
            operador = "-";
        } else if (eragIdatzia.contains("*")) {
            operador = "*";
        } else if (eragIdatzia.contains("/")) {
            operador = "/";
        } else if (eragIdatzia.contains("%")) {
            operador = "%";
        } else {
            throw new IllegalArgumentException("Operador no válido.");
        }
    
        // Dividir la cadena por el operador encontrado
        String[] zenbakiak = eragIdatzia.split("\\" + operador); // Escapar el operador
    
        if (zenbakiak.length < 2) {
            throw new IllegalArgumentException("La expresión debe contener dos operandos.");
        }
    
        // Convertir los operandos de la cadena a números
        this.zenb1 = Double.parseDouble(zenbakiak[0].trim());
        this.zenb2 = Double.parseDouble(zenbakiak[1].trim());
    
        // Ahora realiza la operación correspondiente
        switch (operador) {
            case "+":
                batuketa(this.zenb1, this.zenb2);
                break;
            case "-":
                kenketa(this.zenb1, this.zenb2);
                break;
            case "*":
                biderketa(this.zenb1, this.zenb2);
                break;
            case "/":
                zatiketa(this.zenb1, this.zenb2);
                break;
            case "%":
                ehunekoa(this.zenb1);
                break;
        }
    }
    

    public double batuketa(double zenb1,double zenb2){
        zenb3 = this.getZenb1() + this.getZenb2();
        this.setZenb3(zenb3);
        return this.zenb3;
    }
    public double kenketa(double zenb1,double zenb2){
        this.setZenb3(this.getZenb1() - this.getZenb2());
        return this.zenb3;
    }
    public double zatiketa(double zenb1,double zenb2){
        this.setZenb3(this.getZenb1() / this.getZenb2());
        return this.zenb3;
    }
    public double biderketa(double zenb1,double zenb2){
        this.setZenb3(this.getZenb1() * this.getZenb2());
        return this.zenb3;
    }
    public double ehunekoa(double zenb1){
        this.setZenb3(this.getZenb1() /100);
        return this.zenb3;
    }
}
