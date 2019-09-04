package fabrica.model.util.rest;

import fabrica.domain.Tela;
import fabrica.domain.TelaTblModel;
import fabrica.model.util.Convert;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class RestClientTela {

    private static final String URL_BASE = "http://localhost:8080/fabrica-web/webservice";
    private static Client cliente;
    private static WebTarget webTarget;
    private static Invocation.Builder invocationBuilder;
    private static Response response;

    public static List<TelaTblModel> findAllTelas() throws RuntimeException {
        try {
            List<TelaTblModel> models = new ArrayList<>();
            //Configuracion de credenciales para el metodo en el webservice
            HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
                    .nonPreemptive()
                    .credentials("admin", "admin")
                    .build();

            ClientConfig clientConfig = new ClientConfig();
            clientConfig.register(feature);

            cliente = ClientBuilder.newClient(clientConfig);
            //url del RestWebService a usar
            webTarget = cliente.target(URL_BASE).path("/tela/all");

            List<Tela> all = webTarget.request(MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON)
                    .get(Response.class).readEntity(new GenericType<List<Tela>>() {
            });
            for (Tela tela : all) {
                models.add(Convert.toTelaTblModel(tela));
            }
            return models;

        } catch (RuntimeException e) {
            throw e;
        }
    }

    public static Tela findTelaById(String id) throws RuntimeException {
        Tela tela = null;
        try {
            HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
                    .nonPreemptive()
                    .credentials("admin", "admin")
                    .build();

            ClientConfig clientConfig = new ClientConfig();
            clientConfig.register(feature);

            cliente = ClientBuilder.newClient(clientConfig);
            //url base que se usa en telas
            webTarget = cliente.target(URL_BASE).path("/tela");
            //invocamos el metodo a traves del url puesto
            tela = webTarget.path("/findI/" + id).request(MediaType.APPLICATION_XML).get(Tela.class);
            return tela;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public static Tela findTelaByName(String nombre) throws RuntimeException {
        Tela tela = null;
        try {
            HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
                    .nonPreemptive()
                    .credentials("admin", "admin")
                    .build();

            ClientConfig clientConfig = new ClientConfig();
            clientConfig.register(feature);

            cliente = ClientBuilder.newClient(clientConfig);

            webTarget = cliente.target(URL_BASE).path("/tela");

            tela = webTarget.path("/findN/" + nombre).request(MediaType.APPLICATION_XML).get(Tela.class);
            return tela;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public static List<TelaTblModel> findAllByTipo(String tipo) throws RuntimeException {
        try {
            List<TelaTblModel> models = new ArrayList<>();
            //Configuracion de credenciales para el metodo en el webservice
            HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
                    .nonPreemptive()
                    .credentials("admin", "admin")
                    .build();

            ClientConfig clientConfig = new ClientConfig();
            clientConfig.register(feature);

            cliente = ClientBuilder.newClient(clientConfig);
            //url del RestWebService a usar
            webTarget = cliente.target(URL_BASE).path("/tela");

            List<Tela> all = webTarget.path("/findT/" + tipo).request(MediaType.APPLICATION_XML)
                    .get(Response.class).readEntity(new GenericType<List<Tela>>() {
            });

            for (Tela tela : all) {
                models.add(Convert.toTelaTblModel(tela));
            }
            return models;

        } catch (RuntimeException e) {
            throw e;
        }
    }

    public static Response CrearTela(Tela tela) throws RuntimeException {
        try {
            //Configuracion de credenciales para el metodo en el webservice
            HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
                    .nonPreemptive()
                    .credentials("admin", "admin")
                    .build();

            ClientConfig clientConfig = new ClientConfig();
            clientConfig.register(feature);

            cliente = ClientBuilder.newClient(clientConfig);

            webTarget = cliente.target(URL_BASE).path("/tela/save");
            invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
            response = invocationBuilder.post(Entity.entity(tela, MediaType.APPLICATION_XML));
            return response;
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
    public static Tela recuperarTela(Response response){
        Tela telaRecuperada = response.readEntity(Tela.class);
        return telaRecuperada;
    }

    public static Response ModificarTela(Tela tela, String id) throws RuntimeException {
        try {
            HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
                    .nonPreemptive()
                    .credentials("admin", "admin")
                    .build();

            ClientConfig clientConfig = new ClientConfig();
            clientConfig.register(feature);

            cliente = ClientBuilder.newClient(clientConfig);

            webTarget = cliente.target(URL_BASE).path("/tela/update/" + id);
            invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);

            response = invocationBuilder.put(Entity.entity(tela, MediaType.APPLICATION_XML));

            return response;

        } catch (RuntimeException e) {
            throw e;
        }
    }

    public static Response eliminarTelaPorId(Tela tela,String id){
        try {
            HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
                    .nonPreemptive()
                    .credentials("admin", "admin")
                    .build();

            ClientConfig clientConfig = new ClientConfig();
            clientConfig.register(feature);

            cliente = ClientBuilder.newClient(clientConfig);

            webTarget = cliente.target(URL_BASE).path("/tela/delete/" + id);
            invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);

            response = invocationBuilder.delete();

            return response;

        } catch (RuntimeException e) {
            throw e;
        }
    }
}
