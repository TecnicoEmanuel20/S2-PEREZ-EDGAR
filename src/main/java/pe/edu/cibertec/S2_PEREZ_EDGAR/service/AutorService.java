package pe.edu.cibertec.S2_PEREZ_EDGAR.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.S2_PEREZ_EDGAR.bd.Autor;
import pe.edu.cibertec.S2_PEREZ_EDGAR.convert.AutorConvert;
import pe.edu.cibertec.S2_PEREZ_EDGAR.repository.AutorRepository;
import pe.edu.cibertec.ws.objects.GetAutorResponse;
import pe.edu.cibertec.ws.objects.GetListAutorResponse;
import pe.edu.cibertec.ws.objects.PostAutorRequest;
import pe.edu.cibertec.ws.objects.PostAutorResponse;


@RequiredArgsConstructor
@Service
public class AutorService implements IAutorService {

    private final AutorRepository autorRepository;
    private final AutorConvert autorConvert;


    @Override
    public GetListAutorResponse obtenerAutors() {
        GetListAutorResponse response = new GetListAutorResponse();
        response.getListautor().addAll(
                autorConvert.convertAutorSoapList(
                        autorRepository.findAll()
                )
        );
        return response;
    }
    @Override
    public GetAutorResponse obtenerAutor(int id) {
        GetAutorResponse response = new GetAutorResponse();
        Autor autor = autorRepository.findById(id).orElse(null);
        if (autor != null) {
            response.setAutor(autorConvert.convertAutorSoap(autor));
        }
        return response;
    }

    @Override
    public PostAutorResponse guardarAutor(PostAutorRequest autor) {
        PostAutorResponse response = new PostAutorResponse();
        Autor nuevoAutor = autorRepository.save(
                autorConvert.convertAutorBD(autor.getAutor())
        );
        response.setAutor(
                autorConvert.convertAutorSoap(nuevoAutor));
        return response;
    }
}
