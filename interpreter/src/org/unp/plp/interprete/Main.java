package org.unp.plp.interprete;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {

    public static void main(String args[]) throws IOException {
        // Crea un lector para la entrada.
        Reader lector = null;

        // Verifica los argumentos
        if (args.length > 0) {
            // Si se indicó un archivo de entrada lo abre
            try {

                lector = new FileReader(args[0]);
            } catch (IOException exc) {
                System.err.println("imposible abrir archivo '" + args[0] + "'");
                System.err.println("causa: " + exc.getMessage());
                System.exit(1);
            }

            // System.out.println("leyendo archivo '" + args[0] + "'");
        } else {

            // Si no se indicó archivo lee de la entrada estandar
            lector = new InputStreamReader(System.in);
            System.out.println("\n\nINTERPRETE INICIADO\nMODO INTERACTIVO\n");

            //System.out.println("leyendo entrada estándard (terminar con ctrl-d)");
        }


        // Ejecuta el analizador léxico/sintáctico
        Parser analizador = new Parser(lector);
        //analizador.yydebug = true;
        analizador.yyparse();
    }

}