package pe.edu.cibertec.S2_PEREZ_EDGAR.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.S2_PEREZ_EDGAR.service.IAutorService;
import pe.edu.cibertec.ws.objects.*;

@Endpoint
public class AutorEndPoint {
    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/objects";
    @Autowired
    private IAutorService autorService;

    @PayloadRoot(namespace = NAMESPACE_URI,
            localPart = "getListAutorRequest")
    @ResponsePayload
    public GetListAutorResponse getListAutor(@RequestPayload GetListAutorRequest request) {
        return autorService.obtenerAutors();
    }

    @PayloadRoot(namespace = NAMESPACE_URI,
            localPart = "getAutorRequest")
    @ResponsePayload
    public GetAutorResponse getAutor(@RequestPayload
                                             GetAutorRequest request) {
        return autorService.obtenerAutor(request.getId());
    }
    @PayloadRoot(namespace = NAMESPACE_URI,
            localPart = "postAutorRequest")
    @ResponsePayload
    public PostAutorResponse guardarAutor(@RequestPayload
            PostAutorRequest request) {
        return autorService.guardarAutor(request);
    }

}
