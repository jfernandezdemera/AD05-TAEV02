/*
 * package taev.app.BootStrap;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.CommandLineRunner; import
 * org.springframework.stereotype.Component;
 * 
 * import jakarta.transaction.Transactional; import taev.app.domain.Coche;
 * import taev.app.domain.Revision; import taev.app.repository.CocheRepository;
 * import taev.app.repository.RevisionRepository;
 * 
 * @Component public class BootStrapData implements CommandLineRunner {
 * 
 * @Autowired CocheRepository cocheRepository;
 * 
 * @Autowired RevisionRepository revisionRepository;
 * 
 * @Transactional
 * 
 * @Override public void run(String... args) throws Exception {
 * 
 * Coche coche = new Coche(); coche.setColor("blanco");
 * coche.setMarca("Renault"); coche.setModelo("Laguna");
 * coche.setPrecio(30.000); coche.setMatricula("1234-MMM");
 * 
 * Revision revision = new Revision(); revision.setAceite(1);
 * revision.setFiltro(1); revision.setFrenos(1); revision.setCoche(coche);
 * 
 * cocheRepository.save(coche); clienteRepository.save(cliente);
 * revisionRepository.save(revision);
 * 
 * 
 * } }
 */
