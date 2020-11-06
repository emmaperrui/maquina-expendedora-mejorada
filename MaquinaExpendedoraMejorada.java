public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    //El total de billetes
    private int numeroBilletesVendidos;
    //Maquina con premio
    private boolean premioBillete;
    //Numero maximo de billetes
    private int numeroMaximoBilletes;
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premio, int maximoBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        numeroBilletesVendidos = 0;
        premioBillete = premio;
        numeroMaximoBilletes = maximoBilletes;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int vaciarDineroDeLaMaquina() {
        int vaciarDinero = totalDineroAcumulado;
        if (balanceClienteActual != 0) {
            System.out.println(vaciarDinero + "no se puede vaciar la m�quina, hay una operaci�n en curso!!!");
            vaciarDinero = -1;
        }
        else {
            totalDineroAcumulado = 0;
        }
        return vaciarDinero;
    }

    /**
     * Devuelve el total de billetes vendidos
     */
    public int getNumeroBilletesVendidos () { 
        return numeroBilletesVendidos;
    }

    public void imprimeNumeroBilletesVendidos () {
        System.out.println("Numero de billetes vendidos" + numeroBilletesVendidos);
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            if (numeroBilletesVendidos >= numeroMaximoBilletes) { 
                System.out.println("No se puede introducir m�s dinero!!!");
            }
        }
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete(){
        int cantidadDeDineroQueFalta;
        cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        double descuentoBillete = 0.10;
        if (cantidadDeDineroQueFalta <= 0) {   
            // Simula la impresion de un billete
            System.out.println("##################");
            System.out.println("# Billete de tren:");
            System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
            System.out.println("# " + precioBillete + " euros.");
            System.out.println("##################");
            System.out.println();
            // Actualiza el total de dinero acumulado en la maquina
            totalDineroAcumulado = totalDineroAcumulado + precioBillete;
            // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
            balanceClienteActual = balanceClienteActual - precioBillete;
            //Numero de billetes vendidos
            numeroBilletesVendidos = numeroBilletesVendidos + 1;
            //El billete tiene descuento
            if (premioBillete == true) {
                descuentoBillete = precioBillete * 0.10;
                System.out.println("Enhorabuena!! Ha ganado usted un descuento del " + descuentoBillete + "� para gastar en la tienda que quiera!!");
            }
            if (numeroBilletesVendidos >= numeroMaximoBilletes) { 
                System.out.println("No se pueden imprimir m�s billetes!!!");
            }
        }
        else {
            System.out.println("Necesitas introducir" + (cantidadDeDineroQueFalta) + "Euros mas!");
        }
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
}
