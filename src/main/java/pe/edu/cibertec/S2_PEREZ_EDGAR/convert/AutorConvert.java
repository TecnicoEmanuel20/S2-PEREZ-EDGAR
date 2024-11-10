package pe.edu.cibertec.S2_PEREZ_EDGAR.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.S2_PEREZ_EDGAR.bd.Autor;
import pe.edu.cibertec.ws.objects.Autorsoap;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AutorConvert {

    public Autor convertAutorBD(Autorsoap autorsoap){
        Autor autor = new Autor();
        autor.setIdautor(autorsoap.getId());
        autor.setNomautor(autorsoap.getNombre());
        autor.setApeautor(autorsoap.getApellido());
        autor.setFechnacautor(autorsoap.getFecnac());
        return  autor;
    }
    public Autorsoap convertAutorSoap(Autor autor){
        Autorsoap autorsoap = new Autorsoap();
        autorsoap.setId(autor.getIdautor());
        autorsoap.setNombre(autor.getNomautor());
        autorsoap.setApellido(autor.getApeautor());
        autorsoap.setFecnac(autor.getFechnacautor());
        return autorsoap;
    }

    public List<Autor> convertAutorBdList(List<Autorsoap> autorsoap){
        List<Autor> autors= new ArrayList<Autor>();
        for (Autorsoap autor : autorsoap) {
            autors.add(convertAutorBD(autor));
        }
        return autors;
    }

    public List<Autorsoap> convertAutorSoapList(List<Autor> autors){
        List<Autorsoap> autorsoap = new ArrayList<Autorsoap>();
        for (Autor autor : autors) {
            autorsoap.add(convertAutorSoap(autor));
        }
        return autorsoap;
    }


}
