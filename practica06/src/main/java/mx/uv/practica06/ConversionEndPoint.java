package mx.uv.practica06;

import java.util.ArrayList;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mx.uv.t4is.conversion.CelsiusRequest;
import mx.uv.t4is.conversion.CelsiusResponse;
import mx.uv.t4is.conversion.ConversionesResponse;
import mx.uv.t4is.conversion.FahrenheitRequest;
import mx.uv.t4is.conversion.FahrenheitResponse;
import mx.uv.t4is.conversion.ConversionesResponse.Conversiones;

@Endpoint
public class ConversionEndPoint {
    ArrayList<Conversiones> conversiones = new ArrayList<Conversiones>();
    int i = 0;
    @PayloadRoot(localPart = "CelsiusRequest", namespace = "t4is.uv.mx/conversion")
    @ResponsePayload
    public CelsiusResponse convertirCtoF(@RequestPayload CelsiusRequest temperatura){
        CelsiusResponse response = new CelsiusResponse();
        Double Fahrenheit = (temperatura.getTemperatura() * 1.8) + 32;
        response.setRespuesta(Fahrenheit.toString());
        Conversiones e = new Conversiones();
        e.setId(i);
        e.setTemperatura(temperatura.getTemperatura() + " to " + Fahrenheit);
        e.setTipo("Celsius to Fahrenheit");
        i++;
        conversiones.add(e);
        return response;
    }

    @PayloadRoot(localPart = "FahrenheitRequest", namespace = "t4is.uv.mx/conversion")
    @ResponsePayload
    public FahrenheitResponse convertirFtoC(@RequestPayload FahrenheitRequest temperatura){
        FahrenheitResponse response = new FahrenheitResponse();
        Double Celsius = ((temperatura.getTemperatura() - 32) * 5) / 9;
        response.setRespuesta(Celsius.toString());
        Conversiones e = new Conversiones();
        e.setId(i);
        e.setTemperatura(temperatura.getTemperatura() + " to " + Celsius);
        e.setTipo("Fahrenheit to Celsius");
        i++;
        conversiones.add(e);
        return response;
    }

    @PayloadRoot(localPart = "ConversionesRequest", namespace = "t4is.uv.mx/conversion")
    @ResponsePayload
    public ConversionesResponse historialConversiones() {
        ConversionesResponse response = new ConversionesResponse();
        for(int j = 0; j < conversiones.size(); j++){
            response.getConversiones().add(conversiones.get(j));
        }
        return response;
    }
}