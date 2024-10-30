import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Conversor {

    private List <Moneda> lstMonedas = new ArrayList<>();

    public void LlenarMonedas(String clave){
        lstMonedas.clear();
        try{
            // Setting URL
            String url_str = "https://v6.exchangerate-api.com/v6/a748023c516a154dc749ba66/latest/" + clave;

// Making Request
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

// Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

// Accessing object
            String req_result = jsonobj.get("result").getAsString();

            System.out.println(req_result);


            JsonObject tasasDeConversion = jsonobj.getAsJsonObject("conversion_rates");


            // Llenar la lista de monedas con los datos obtenidos
            for (String codigo : tasasDeConversion.keySet()) {
                double monto = tasasDeConversion.get(codigo).getAsDouble();
                Moneda moneda = new Moneda(codigo, monto);
                lstMonedas.add(moneda);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }//fin llenar monedas

    public void MostrarMonedas (){

        for (int i = 0; i < lstMonedas.size(); i++) {

            Moneda moneda = lstMonedas.get(i);

            System.out.println(moneda.getTipoMoneda() + " :" + moneda.getTipoCambio());

        }
    }//fin mostrar monedas

    private double ObtenerMontoPorCodigo(String codigo){
        for (int i = 0; i < lstMonedas.size(); i++) {

            Moneda moneda = lstMonedas.get(i);
            double resultado;
            if (moneda.getTipoMoneda().equalsIgnoreCase(codigo)){
                resultado = moneda.getTipoCambio();
                return resultado;
            }

        }
        throw new IllegalArgumentException("Moneda con código " + codigo + " no encontrada.");
    }


    public double ConvertirMoneda(double monto , String codigo){

        double monedaAConvertir = ObtenerMontoPorCodigo(codigo);

        double resultado = monto * monedaAConvertir;

        return resultado;

    }

}//fin clase
