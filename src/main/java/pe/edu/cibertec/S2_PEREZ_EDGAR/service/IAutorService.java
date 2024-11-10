package pe.edu.cibertec.S2_PEREZ_EDGAR.service;


import pe.edu.cibertec.ws.objects.GetAutorResponse;
import pe.edu.cibertec.ws.objects.GetListAutorResponse;
import pe.edu.cibertec.ws.objects.PostAutorRequest;
import pe.edu.cibertec.ws.objects.PostAutorResponse;

public interface IAutorService {

   GetListAutorResponse obtenerAutors();

    GetAutorResponse obtenerAutor(int id);

    PostAutorResponse guardarAutor(PostAutorRequest domicilio);

}
